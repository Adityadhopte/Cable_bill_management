package com.tech.cablebill;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCustomer extends AppCompatActivity {

    EditText et_Customer,et_mobile,et_oldbalance,et_remark,et_area,et_agentname,et_settopbox;

    Spinner spinner;

    String name,mobile,oldbalance,remark,area,Routeid,Routename,Agentname,Agentid,Settopbox;

    Button bnt_Save;

    Databasehelper databasehelper;

    ArrayList<Planet_route> Route_name;

    RoutenameAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        databasehelper = new Databasehelper(this);

        et_Customer= findViewById(R.id.InputCustomer);
        et_mobile = findViewById(R.id.MobileCust);
        et_oldbalance = findViewById(R.id.InputOld);
        et_remark = findViewById(R.id.InputRemark);
        et_area = findViewById(R.id.AreaCust);
        et_settopbox = findViewById(R.id.Settopbox);
        et_agentname = findViewById(R.id.Agent_name);

        spinner= findViewById(R.id.Spin_route);

        bnt_Save = findViewById(R.id.btnSave);

        Route_name=new ArrayList<>();
        Route_name = databasehelper.getroute();
        adapter = new RoutenameAdapter(AddCustomer.this, android.R.layout.simple_spinner_dropdown_item,Route_name);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Planet_route myModel = (Planet_route) parent.getSelectedItem();
                Routeid = myModel.getId();
                Routename = myModel.getRoutename();
                Agentname = myModel.getAgentname();
                et_agentname.setText(Agentname);
                Agentid = myModel.getAgentid();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

        }
        });


        bnt_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_Customer.getText().toString();
                mobile = et_mobile.getText().toString();
                oldbalance = et_oldbalance.getText().toString();
                remark = et_remark.getText().toString();
                area = et_area.getText().toString();
                Settopbox = et_settopbox.getText().toString();
//                Agentname = et_agentname.getText().toString();



                Boolean inserted = databasehelper.addcust(name,mobile,oldbalance,remark,area,Agentname,Settopbox,Routename,Routeid);
                if (inserted == true) {
                    Toast.makeText(AddCustomer.this, "Registration Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddCustomer.this, MainActivity.class);
                    startActivity(intent);

                }

                else {
                    Toast.makeText(AddCustomer.this, "Registraion Failed", Toast.LENGTH_LONG).show();

                }
            }
        });

    }


}