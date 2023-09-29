package com.tech.cablebill;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_route extends AppCompatActivity {

    EditText et_Addroute;

    String Addroute,Agentname,Agentid;

    Spinner Sp_agent;

    Button btn_Save1;
    ArrayList<Agentplanet> agentname;
    Databasehelper databasehelper;

    AgentnameAdapter adapter;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_route);
        et_Addroute= findViewById(R.id.AddRoute);
        Sp_agent = findViewById(R.id.Sp_agent);

        databasehelper = new Databasehelper(this);

        agentname=new ArrayList<>();
        agentname = databasehelper.getagent();
        adapter = new AgentnameAdapter(Add_route.this, android.R.layout.simple_spinner_dropdown_item,agentname);
        Sp_agent.setAdapter(adapter);
        Sp_agent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Agentplanet myModel=(Agentplanet) parent.getSelectedItem();
                Agentid = myModel.getId();
                Agentname = myModel.getAgent_name();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_Save1 = findViewById(R.id.btnSave1);

        btn_Save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Addroute = et_Addroute.getText().toString();

                Boolean inserted = databasehelper.addroute(Addroute,Agentid,Agentname);
                if (inserted == true) {
                    Toast.makeText(Add_route.this, "Registration Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Add_route.this, MainActivity.class);
                    startActivity(intent);

                }

                else {
                    Toast.makeText(Add_route.this, "Registraion Failed", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}