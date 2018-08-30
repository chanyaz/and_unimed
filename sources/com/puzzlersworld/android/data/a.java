package com.puzzlersworld.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import javax.inject.Inject;

public class a extends SQLiteOpenHelper {
    @Inject
    public a(Context context) {
        super(context, "androapp_data_db", null, 5);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE cart (_id INTEGER PRIMARY KEY autoincrement, pid int, vid int, product_name text, mrp text, selling_price text, product_quantity int, type text, variant text, image_link text, cart_item_key text, UNIQUE(cart_item_key) );");
        try {
            sQLiteDatabase.execSQL("CREATE TABLE saveforlater ( post_id INTEGER PRIMARY KEY, post_data longtext, save_date INTEGER );");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.w("AndroApp", "Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cart");
        onCreate(sQLiteDatabase);
    }
}
