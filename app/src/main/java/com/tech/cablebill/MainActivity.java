package com.tech.cablebill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

      CardView cd_addagent,cd_customer,cd_area,cd_User;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cd_addagent = findViewById(R.id.AddAgent);

        cd_addagent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Add_Agent.class);
                startActivity(intent);
            }

            });


        cd_customer = findViewById(R.id.Customer);

        cd_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddCustomer.class);
                startActivity(intent);

            }
        });

        cd_area = findViewById(R.id.Area);

        cd_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Add_route.class);
                startActivity(intent);

            }
        });


        cd_User = findViewById(R.id.LinearLayout);

        cd_User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Userlist.class);
                startActivity(intent);

            }
        });


        }





}