package com.tech.cablebill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Userlist extends AppCompatActivity implements UserlistAdapter.onItemClick {

    TextView tv_routename;
    Databasehelper databaseHelper;
    UserlistAdapter  adapter;
    RecyclerView recyclerView;
    String id,routename;

    List<Planet_route> mPlanetlist=new ArrayList<Planet_route>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        databaseHelper =new Databasehelper(this);
//        tv_routename =(TextView)findViewById(R.id.tv_routename);

        recyclerView=(RecyclerView)findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(Userlist.this));
        mPlanetlist=databaseHelper.getroute();
        adapter=new UserlistAdapter(mPlanetlist);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClick(Userlist.this);


    }

    @Override
    public void onItemClickSelected(Planet_route planet) {
        id=planet.getId();
        routename=planet.getRoutename();

        Intent intent=new Intent(Userlist.this,Customer_list.class);

        intent.putExtra("Id",id);
        intent.putExtra("RouteName",routename);

        startActivity(intent);

    }
}