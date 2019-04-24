package com.team.termproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "subscription_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "pay_day";
    private static final String COL4 = "amount";
    private static final String COL5 = "email";
    private static final String COL6 = "memo";
    private static final String COL7 = "img_url";


    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " +
                COL3 + " TEXT, " +
                COL4 + " TEXT, " +
                COL5 + " TEXT, " +
                COL6 + " TEXT, " +
                COL7 + " TEXT)";

        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String name, String day, String amount, String email, String memo, String img_url){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, day);
        contentValues.put(COL4, amount);
        contentValues.put(COL5, email);
        contentValues.put(COL6, memo);
        contentValues.put(COL7, img_url);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String name, String day, String amount, String email, String memo, String img_url){

        System.out.println("Does this even happen?2");
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME + " WHERE (" + COL2 + " = '" + name + "' AND "
                + COL3 + " = '" + day + "')";

//        + "' AND "
//                + COL4 + " = '" + amount + "' AND "
//                + COL5 + " = '" + email + "' AND "
//                + COL6 + " = '" + memo + "' AND "
//                + COL7 + " = '" + img_url

        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void deleteItem(int id, String name, String day, String amount, String email, String memo, String img_url){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "+ "(" + COL1 + " = '" + id + "' AND " + COL2 + " = '" + name + "' AND "
                + COL3 + " = '" + day + "')";

//        "' AND "
//                + COL4 + " = '" + amount + "' AND "
//                + COL5 + " = '" + email + "' AND "
//                + COL6 + " = '" + memo + "' AND "
//                + COL7 + " = '" + img_url +

        db.execSQL(query);
    }
}
