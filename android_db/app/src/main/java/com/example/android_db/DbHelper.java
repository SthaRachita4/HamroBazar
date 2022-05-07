package com.example.android_db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context c){
        super(c,"myDatabase",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("Create table if not exists studentrecord(id integer PRIMARY KEY AUTOINCREMENT, name VARCHAR, stid integer,faculty VARCHAR,semester integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     sqLiteDatabase.execSQL("DROP TABLE IF EXISTS studentrecord ");
     onCreate(sqLiteDatabase);
    }

    public void addRecord(DataModel data) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",data.getName());
        cv.put("stid",data.getStid());
        cv.put("faculty",data.getFaculty());
        cv.put("semester",data.getSem());
        db.insert("studentrecord",null,cv);

    }
    
    public ArrayList<DataModel> getRecords() {
        ArrayList<DataModel> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * from studentrecord";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                DataModel dm = new DataModel();
                dm.setId(c.getInt(0));
                dm.setName(c.getString(1));
                dm.setStid(c.getInt(2));
                dm.setFaculty(c.getString(3));
                dm.setSem(c.getInt(4));
                list.add(dm);
            } while (c.moveToNext());
        }
            return list;
        }

    public void deleteRecord(int stid) {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM studentrecord WHERE stid="+stid);
    }
    public void updateRecord(DataModel dm){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("semester",dm.getSem());
        db.update("studentrecord",cv,"stid="+dm.getStid(),null);
    }
}
