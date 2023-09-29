package com.tech.cablebill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Add_Agent extends AppCompatActivity {

    EditText et_name,et_mobile,et_username,et_password,et_area;

    Button bnt_register;

    String name,mobile,username,password,area;

    Databasehelper databasehelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_agent);

        databasehelper = new Databasehelper(this);

        et_name = findViewById(R.id.Inputname);
        et_mobile = findViewById(R.id.InputMobile);
        et_username = findViewById(R.id.Inputusername);
        et_password = findViewById(R.id.Agentpassword);
        et_area = findViewById(R.id.Inputarea);

        bnt_register = findViewById(R.id.btnRegister);

        bnt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = et_name.getText().toString();
                mobile = et_mobile.getText().toString();
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                area = et_area.getText().toString();

                Boolean inserted = databasehelper.addagent(name,mobile,username,password,area);
                if (inserted == true) {
                    Toast.makeText(Add_Agent.this, "Registration Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Add_Agent.this, MainActivity.class);
                    startActivity(intent);

                }

                else {
                    Toast.makeText(Add_Agent.this, "Registraion Failed", Toast.LENGTH_LONG).show();

                }
            }
        });



   }
}