package com.example.workfit.DatabaseHandlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by Revina Adisty on 6/27/2017.
 */

public class DatabaseHandler_Photo extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "workfitPhotoDatabase";
    private static final String TABLE_NAME = "PhotoDataTable";

    private static final String KEY_ID = "ID";
    private static final String KEY_IMAGE = "Image";

    public DatabaseHandler_Photo(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String QUERY = "CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " TEXT, " + KEY_IMAGE + " BLOB);";
        sqLiteDatabase.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public void addPhoto(String ID, Bitmap image) throws SQLiteException {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        byte[] data = getBitmapAsByteArray(image); //converting to byte
        cv.put(KEY_IMAGE,   ID);
        cv.put(KEY_IMAGE,   data);
        database.insert(TABLE_NAME, null, cv);
    }

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    public Bitmap getPhoto(String ID) {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cur = database.rawQuery(query, null);

        if (cur.moveToFirst()){
            byte[] imgByte = cur.getBlob(cur.getColumnIndex(KEY_IMAGE));
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imgByte);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            cur.close();
            return bitmap;
        }
        if (cur != null && !cur.isClosed()) {
            cur.close();
        }
        return null;
    }
}
