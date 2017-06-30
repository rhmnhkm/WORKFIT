package com.example.workfit.DatabaseHandlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.IntegerRes;

import com.example.workfit.DataFiles.PersonalData;

/**
 * Created by Revina Adisty on 6/27/2017.
 */

public class DatabaseHandler_PersonalData extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "workfitPersonalData";
    private static final String TABLE_NAME = "PersonalInfo";
    private static final String KEY_ID = "ID";
    private static final String KEY_NAME = "Name";
    private static final String KEY_GENDER = "Gender";
    private static final String KEY_HEIGHT = "Height";
    private static final String KEY_WEIGHT = "Weight";

    public DatabaseHandler_PersonalData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER, " + KEY_NAME + " TEXT,"
                + KEY_GENDER + " INTEGER, " + KEY_HEIGHT + " INTEGER, " + KEY_WEIGHT
                + " INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public void addCompletePersonalData (PersonalData data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put(KEY_ID,    0);
        cv.put(KEY_NAME,    data.getName());
        cv.put(KEY_GENDER,   data.getGender());
        cv.put(KEY_HEIGHT,   data.getHeight());
        cv.put(KEY_WEIGHT,   data.getWeight());
        db.insert(TABLE_NAME, null, cv);
    }

    public int updateCompletePersonalData (PersonalData data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put(KEY_ID,    0);
        cv.put(KEY_NAME,    data.getName());
        cv.put(KEY_GENDER,   data.getGender());
        cv.put(KEY_HEIGHT,   data.getHeight());
        cv.put(KEY_WEIGHT,   data.getWeight());
        return db.update(TABLE_NAME, cv, KEY_ID + " = 0", // update based on ID = 0 (WHERE ID = 0)
                null);
    }

    public PersonalData getPersonalData() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_NAME,
                        KEY_GENDER, KEY_HEIGHT, KEY_WEIGHT}, KEY_ID + "= 0",
                null, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Boolean gender;
        if (Integer.parseInt(cursor.getString(1)) == 1) gender = true; else gender = false;

        PersonalData returnedData = new PersonalData(cursor.getString(0), gender,
                Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)));

        return returnedData;
    }


}
