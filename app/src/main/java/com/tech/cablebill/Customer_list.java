package com.tech.cablebill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Customer_list extends AppCompatActivity {

    TextView tv_agentname,tv_settopbox,tv_phoneno,tv_customername;
    Databasehelper databaseHelper;
    RecyclerView recyclerView;
    String id,Routename,settopbox,phoneno,customername;
    CustlistAdapter custadapter;

    List<Customerlistplanet> mcustlist=new ArrayList<Customerlistplanet>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list2);

        databaseHelper =new Databasehelper(this);
        recyclerView=(RecyclerView)findViewById(R.id.recycle2);
        recyclerView.setLayoutManager(new LinearLayoutManager(Customer_list.this));

//        tv_agentname =(TextView)findViewById(R.id.Custname);
//        tv_phoneno =(TextView)findViewById(R.id.Phoneno);
//        tv_settopbox =(TextView)findViewById(R.id.Settopbox);

        Display();

        mcustlist=databaseHelper.getCust(id);

        custadapter=new CustlistAdapter(mcustlist);
        recyclerView.setAdapter(custadapter);

    }

    public void Display()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            id = (String)bundle.get("Id");
            Routename = (String)bundle.get("RouteName");
        }
    }
}