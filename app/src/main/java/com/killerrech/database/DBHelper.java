package com.killerrech.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RENU on 9/17/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    Context context;
    private static final String DB_NAME="geoutility.db";
    public static final String SETTINGS_TABLE ="setting";
    public static final String  GEOLOCATION_TABLE="geolocation";

    private static final int DB_VERSION=1;
    private static DBHelper dbHelper=null;

//Setting TAble Coloumn name
    public static final String ID ="id";
    public static final String GEO_ID ="geo_id"; //forgien key
    public static final String PROFILE_MODE_IN ="profile_mode_in";
    public static final String PROFILE_MODE_OUT ="profile_mode_out";
    public static final String GEO_NOTIFICATION ="geo_notification";



    //Geolocation table coloumn name

    public static  final String  GEOLOC_ID="geo_id";      // primary key
    public static  final String  GEO_LATITUDE="geo_latitude";
    public static  final String  GEO_LONGITUDE="geo_longitude";
    public static  final String  GEO_RADIUS="geo_radius";
    public static  final String  GEO_NAME="geo_name";
    public static  final String  GEO_Address="geo_address";









    private DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.context=context;

    }

    public static DBHelper getDbHelper(Context context){
       if(dbHelper==null)
           dbHelper=new DBHelper(context);
        return dbHelper;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // create host table
        String CREATE_SETTINGS_TABLE =  "CREATE TABLE " + SETTINGS_TABLE + " (" + ID
                + " INTEGER PRIMARY KEY,"
                + GEO_ID + " TEXT not null,"
                + PROFILE_MODE_IN + " TEXT,"
                + PROFILE_MODE_OUT + " TEXT,"
                + GEO_NOTIFICATION + " TEXT );";
        db.execSQL(CREATE_SETTINGS_TABLE);
        System.out.println("commiting this as change");



        String CREATE_GEOLOCATION_TABLE =  "CREATE TABLE " +  GEOLOCATION_TABLE + " (" + GEOLOC_ID
                + " INTEGER PRIMARY KEY,"
                + GEO_LATITUDE+ " TEXT," + GEO_LONGITUDE+ " TEXT,"
                + GEO_RADIUS+ " TEXT,"+ GEO_Address+ " TEXT,"
                + GEO_NAME + " TEXT );";
        db.execSQL(CREATE_GEOLOCATION_TABLE);
        System.out.println("created tables");
        System.out.println("created tables");



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
