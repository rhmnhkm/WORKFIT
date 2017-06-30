package com.example.workfit.DatabaseHandlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.workfit.Activities.Register;
import com.example.workfit.DataFiles.DetailedProgress_DynamicData;

/**
 * Created by Revina Adisty on 6/26/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper  {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "workfitDynamicData";
    private static final String TABLE_NAME = "DataTable";

    private static final String KEY_INDEX = "groupIndex";
    private static final String KEY_V0 = "variable0";
    private static final String KEY_V1 = "variable1";
    private static final String KEY_V2 = "variable2";
    private static final String KEY_V3 = "variable3";
    private static final String KEY_V4 = "variable4";
    private static final String KEY_V5 = "variable5";
    private static final String KEY_V6 = "variable6";
    private static final String KEY_V7 = "variable7";
    private static final String KEY_V8 = "variable8";
    private static final String KEY_V9 = "variable9";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PRIMARY_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + KEY_INDEX + " INTEGER, " +
                KEY_V0 + " INTEGER, "+ KEY_V1 + " INTEGER, "+ KEY_V2 + " INTEGER, "+ KEY_V3 + " INTEGER, "+
                KEY_V4 + " INTEGER, "+ KEY_V5 + " INTEGER, "+ KEY_V6 + " INTEGER, "+ KEY_V7 + " INTEGER, "+
                KEY_V8 + " INTEGER, "+ KEY_V9 + " INTEGER" + ")";

        sqLiteDatabase.execSQL(CREATE_PRIMARY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public void addDatabase(DetailedProgress_DynamicData database) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_INDEX, database.getGroupIndex());
        values.put(KEY_V0, database.getV0());
        values.put(KEY_V1, database.getV1());
        values.put(KEY_V2, database.getV2());
        values.put(KEY_V3, database.getV3());
        values.put(KEY_V4, database.getV4());
        values.put(KEY_V5, database.getV5());
        values.put(KEY_V6, database.getV6());
        values.put(KEY_V7, database.getV7());
        values.put(KEY_V8, database.getV8());
        values.put(KEY_V9, database.getV9());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public DetailedProgress_DynamicData getDatabase(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_INDEX,
                        KEY_V0, KEY_V1, KEY_V2, KEY_V3, KEY_V4, KEY_V5,
                        KEY_V6, KEY_V7, KEY_V8, KEY_V9}, KEY_INDEX + "=" + id,
                null, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DetailedProgress_DynamicData data = new DetailedProgress_DynamicData(
                Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),
                Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)),
                Integer.parseInt(cursor.getString(10))
                );
        return data;
    }

    public int updateDatabase(DetailedProgress_DynamicData database) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_INDEX, database.getGroupIndex());
        values.put(KEY_V0, database.getV0());
        values.put(KEY_V1, database.getV1());
        values.put(KEY_V2, database.getV2());
        values.put(KEY_V3, database.getV3());
        values.put(KEY_V4, database.getV4());
        values.put(KEY_V5, database.getV5());
        values.put(KEY_V6, database.getV6());
        values.put(KEY_V7, database.getV7());
        values.put(KEY_V8, database.getV8());
        values.put(KEY_V9, database.getV9());

        return db.update(TABLE_NAME, values, KEY_INDEX + " = ?",
                new String[] { String.valueOf(database.getGroupIndex()) });
    }
}
