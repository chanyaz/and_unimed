package com.appnext.base.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.appnext.base.a.b.e;
import com.appnext.base.b.m;
import java.util.ArrayList;
import java.util.List;

public class g extends e<e> {
    private static final String gK = "latitude";
    private static final String gL = "longitude";
    private static final String gM = "additional_data";
    private static final String gN = "date";
    private static final String gO = "times_type";
    public static final String gs = "times_location_table";
    private String[] gu = new String[]{gK, gL, gM, gN};

    enum a {
        Morning("morning"),
        AfterNoon("afternoon"),
        Night("night");
        
        private String mValue;

        private a(String str) {
            this.mValue = str;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    private void a(a aVar) {
        super.f(gs, ("date NOT IN (SELECT date FROM times_location_table WHERE times_type like '" + aVar.getValue() + "' ORDER BY " + gN + " DESC LIMIT 1 ) ") + " AND times_type like '" + aVar.getValue() + "'");
    }

    public static String bl() {
        return "create table times_location_table ( latitude real, longitude real, additional_data text, date integer, times_type text)";
    }

    public long a(e eVar) {
        a(a.Morning);
        return super.a(gs, a(eVar, a.Morning));
    }

    protected ContentValues a(e eVar, a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(gK, eVar.bi());
        contentValues.put(gL, eVar.bj());
        contentValues.put(gM, eVar.bk());
        contentValues.put(gN, Long.valueOf(eVar.getDate().getTime()));
        contentValues.put(gO, aVar.getValue());
        return contentValues;
    }

    public long b(e eVar) {
        a(a.AfterNoon);
        return super.a(gs, a(eVar, a.AfterNoon));
    }

    protected String[] bn() {
        return this.gu;
    }

    public List<e> bp() {
        List arrayList = new ArrayList();
        arrayList.add(com.appnext.base.a.c.e.a.Equals);
        return super.a(gs, new String[]{gO}, new String[]{String.valueOf(a.Morning.getValue())}, ai(gN), arrayList);
    }

    public List<e> bq() {
        List arrayList = new ArrayList();
        arrayList.add(com.appnext.base.a.c.e.a.Equals);
        return super.a(gs, new String[]{gO}, new String[]{String.valueOf(a.AfterNoon.getValue())}, ai(gN), arrayList);
    }

    public List<e> br() {
        List arrayList = new ArrayList();
        arrayList.add(com.appnext.base.a.c.e.a.Equals);
        return super.a(gs, new String[]{gO}, new String[]{String.valueOf(a.Night.getValue())}, ai(gN), arrayList);
    }

    public long c(e eVar) {
        a(a.Night);
        return super.a(gs, a(eVar, a.Night));
    }

    public void delete() {
        super.delete(gs);
    }

    /* renamed from: f */
    protected e b(Cursor cursor) {
        return new e(Double.valueOf(cursor.getDouble(cursor.getColumnIndex(gK))), Double.valueOf(cursor.getDouble(cursor.getColumnIndex(gL))), cursor.getString(cursor.getColumnIndex(gM)), m.d((long) cursor.getInt(cursor.getColumnIndex(gN))));
    }
}
