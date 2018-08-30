package com.appnext.base.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.appnext.base.a.c.a;
import com.appnext.base.a.c.c;
import com.appnext.base.a.c.f;
import com.appnext.base.a.c.g;

public class b extends SQLiteOpenHelper {
    private static final String fS = "db469";
    private static final int fT = 9;
    private static volatile b fU;

    private b(Context context) {
        super(context, fS, null, 9);
    }

    public static b f(Context context) {
        if (fU == null) {
            synchronized (b.class) {
                if (fU == null) {
                    fU = new b(context.getApplicationContext());
                }
            }
        }
        return fU;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS category_table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS collected_data_table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_data_table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS times_location_table");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS config_table");
            onCreate(sQLiteDatabase);
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(a.bl());
            sQLiteDatabase.execSQL(com.appnext.base.a.c.b.bl());
            sQLiteDatabase.execSQL(f.bl());
            sQLiteDatabase.execSQL(g.bl());
            sQLiteDatabase.execSQL(c.bl());
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
    }
}
