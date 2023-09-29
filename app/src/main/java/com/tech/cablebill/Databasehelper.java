package com.tech.cablebill;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Databasehelper extends SQLiteOpenHelper {

    public static String Database_name = "Cablebill.db";

    public static String Table_name = "Agent";
    public static String Cal_0 = "ID";
    public static String Cal_1 = "Agent_Name";
    public static String Cal_2 = "Mobile";
    public static String Cal_3 = "Username";
    public static String Cal_4 = "Password";
    public static String Cal_5 = "Area";


    public static String Table_cust = "Customer";
    public static String cal_0 = "CID";
    public static String cal_1 = "CName";
    public static String cal_2 = "CMobile";
    public static String cal_3 = "Coldbalance";
    public static String cal_4 = "Cremark";
    public static String cal_5 = "CArea";
    public static String cal_6 = "CAgentname";
    public static String cal_7 = "CSettopbox";
    public static String cal_8 = "CRoutename";
    public static String cal_9 = "CRouteid";

    public static String Table_route = "Route";
    public static String cal_11 = "RID";
    public static String cal_12 = "Routename";
    public static String cal_13 = "Agentid";
    public static String cal_14 = "Agentname";

    public Databasehelper(@Nullable Context context) {
        super(context, Database_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE " + Table_name + "(ID Integer primary key autoincrement,Agent_Name Text,Mobile Text,Username Text,Password Text,Area Text)");
        db.execSQL(" CREATE TABLE " + Table_cust + "(CID Integer primary key autoincrement,CName Text,CMobile Text,Coldbalance Text,Cremark Text,CArea Text,CAgentname Text,CSettopbox Text,CRoutename Text,CRouteid Text)");
        db.execSQL(" CREATE TABLE " + Table_route + "(RID Integer primary key autoincrement,Routename Text,Agentid Text,Agentname Text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table " + Table_name);
        db.execSQL("Drop Table " + Table_cust);
        db.execSQL("Drop Table " + Table_route);

    }

    public boolean addagent(String Agent_Name, String Mobile, String Username, String Password, String Area) {


        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Cal_1, Agent_Name);
        contentValues.put(Cal_2, Mobile);
        contentValues.put(Cal_3, Username);
        contentValues.put(Cal_4, Password);
        contentValues.put(Cal_5, Area);

        Long result = db.insert(Table_name, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addcust(String CName, String CMobile, String Coldbalance, String Cremark, String CArea, String CAgentname, String CSettopbox,String CRoutename,String CRouteid) {


        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(cal_1, CName);
        contentValues.put(cal_2, CMobile);
        contentValues.put(cal_3, Coldbalance);
        contentValues.put(cal_4, Cremark);
        contentValues.put(cal_5, CArea);
        contentValues.put(cal_6, CAgentname);
        contentValues.put(cal_7, CSettopbox);
        contentValues.put(cal_8, CRoutename);
        contentValues.put(cal_9, CRouteid);

        Long result = db.insert(Table_cust, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }


    public boolean addroute(String Routename, String Agentid, String Agentname) {


        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(cal_12, Routename);
        contentValues.put(cal_13, Agentid);
        contentValues.put(cal_14, Agentname);

        Long result = db.insert(Table_route, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public ArrayList<Planet_route> getroute() {
        SQLiteDatabase db = getWritableDatabase();
        Planet_route planet_route = null;
        ArrayList<Planet_route> mplanetlist = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * from Route ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            planet_route = new Planet_route(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            mplanetlist.add(planet_route);
            cursor.moveToNext();
        }
        cursor.close();
        return mplanetlist;
    }


    public ArrayList<Agentplanet> getagent() {

        SQLiteDatabase db = getWritableDatabase();
        Agentplanet planet_agent = null;
        ArrayList<Agentplanet> aplanetlist = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT ID,Agent_Name from Agent ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            planet_agent = new Agentplanet(cursor.getString(0), cursor.getString(1));
            aplanetlist.add(planet_agent);
            cursor.moveToNext();
        }
        cursor.close();
        return aplanetlist;

    }


    public ArrayList<Customerlistplanet> getCust(String routename) {

        SQLiteDatabase db = getWritableDatabase();

        Customerlistplanet customerlistplanet = null;
        ArrayList<Customerlistplanet> mcustlist = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT CID,CName,CMobile,CSettopbox from Customer where CRouteid=?", new String[]{routename});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            customerlistplanet = new Customerlistplanet(cursor.getString(0), cursor.getString(1),cursor.getString(2),cursor.getString(3));
            mcustlist.add(customerlistplanet);
            cursor.moveToNext();
        }
        cursor.close();
        return mcustlist;
    }


 }


