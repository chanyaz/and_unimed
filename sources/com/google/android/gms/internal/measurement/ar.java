package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@VisibleForTesting
final class ar extends SQLiteOpenHelper {
    private final /* synthetic */ aq a;

    ar(aq aqVar, Context context, String str) {
        this.a = aqVar;
        super(context, str, null, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    private final boolean a(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
        r10 = this;
        r8 = 0;
        r9 = 0;
        r1 = "SQLITE_MASTER";
        r0 = 1;
        r2 = new java.lang.String[r0];	 Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
        r0 = 0;
        r3 = "name";
        r2[r0] = r3;	 Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
        r3 = "name=?";
        r0 = 1;
        r4 = new java.lang.String[r0];	 Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
        r0 = 0;
        r4[r0] = r12;	 Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r11;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
        r0 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x0040 }
        if (r1 == 0) goto L_0x0025;
    L_0x0022:
        r1.close();
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = move-exception;
        r1 = r9;
    L_0x0028:
        r2 = r10.a;	 Catch:{ all -> 0x003d }
        r3 = "Error querying for table";
        r2.c(r3, r12, r0);	 Catch:{ all -> 0x003d }
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.close();
    L_0x0034:
        r0 = r8;
        goto L_0x0025;
    L_0x0036:
        r0 = move-exception;
    L_0x0037:
        if (r9 == 0) goto L_0x003c;
    L_0x0039:
        r9.close();
    L_0x003c:
        throw r0;
    L_0x003d:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0037;
    L_0x0040:
        r0 = move-exception;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.ar.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    private static Set<String> b(SQLiteDatabase sQLiteDatabase, String str) {
        Set<String> hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (Object add : columnNames) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (this.a.e.a(3600000)) {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.a.e.a();
                this.a.f("Opening the database failed, dropping the table and recreating it");
                this.a.j().getDatabasePath(aq.D()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    this.a.e.b();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    this.a.e("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }
        throw new SQLiteException("Database open failed");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (bj.a() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        String valueOf;
        int i = 0;
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (a(sQLiteDatabase, "hits2")) {
            Set b = b(sQLiteDatabase, "hits2");
            String[] strArr = new String[]{"hit_id", "hit_string", "hit_time", "hit_url"};
            int i2 = 0;
            while (i2 < 4) {
                Object obj = strArr[i2];
                if (b.remove(obj)) {
                    i2++;
                } else {
                    String str = "Database hits2 is missing required column: ";
                    valueOf = String.valueOf(obj);
                    throw new SQLiteException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            i2 = !b.remove("hit_app_id") ? 1 : 0;
            if (!b.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (i2 != 0) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        } else {
            sQLiteDatabase.execSQL(aq.a);
        }
        if (a(sQLiteDatabase, "properties")) {
            Set b2 = b(sQLiteDatabase, "properties");
            String[] strArr2 = new String[]{"app_uid", "cid", "tid", "params", "adid", "hits_count"};
            while (i < 6) {
                Object obj2 = strArr2[i];
                if (b2.remove(obj2)) {
                    i++;
                } else {
                    String str2 = "Database properties is missing required column: ";
                    valueOf = String.valueOf(obj2);
                    throw new SQLiteException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
            if (!b2.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
