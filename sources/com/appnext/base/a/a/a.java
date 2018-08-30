package com.appnext.base.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.appnext.base.a.b;
import com.appnext.base.b.d;

public class a {
    private static a fW;
    private static b fX;
    private Integer fV = Integer.valueOf(0);
    private SQLiteDatabase fY;

    public enum a {
        Global,
        DatabaseOrDiskFull
    }

    private a(Context context) {
        fX = b.f(context);
    }

    public static a aT() {
        if (fW == null) {
            synchronized (a.class) {
                if (fW == null) {
                    fW = new a(d.getContext().getApplicationContext());
                }
            }
        }
        return fW;
    }

    public static synchronized void g(Context context) {
        synchronized (a.class) {
            if (fW == null) {
                fW = new a(context.getApplicationContext());
            }
        }
    }

    public void a(a aVar, Throwable th) {
        switch (aVar) {
            case DatabaseOrDiskFull:
            case Global:
                com.appnext.base.b.a(th);
                return;
            default:
                return;
        }
    }

    public synchronized SQLiteDatabase aU() {
        this.fV = Integer.valueOf(this.fV.intValue() + 1);
        if (this.fV.intValue() == 1) {
            this.fY = fX.getWritableDatabase();
        }
        return this.fY;
    }

    public synchronized void aV() {
        this.fV = Integer.valueOf(this.fV.intValue() - 1);
        if (this.fV.intValue() == 0) {
            this.fY.close();
        }
    }
}
