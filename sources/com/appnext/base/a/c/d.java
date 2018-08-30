package com.appnext.base.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.appnext.base.a.b.b;
import com.appnext.base.a.c.e.a;
import com.appnext.base.b.m;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONArray;

public class d extends e<b> {
    public static final String COLUMN_TYPE = "type";
    public static final String gD = "primary_key";
    public static final String gE = "collected_data";
    public static final String gF = "collected_data_date";
    public static final String gG = "collected_data_type";
    private String gH;
    private String[] gu = new String[]{gD, "type", gE, gF, gG};

    public d(String str) {
        this.gH = str;
    }

    protected static String b(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create table ");
        stringBuilder.append(str);
        stringBuilder.append(" ( primary_key text not null, type text not null " + c(z) + ", " + gE + " text not null, " + gF + " text default (strftime('%s','now')), " + gG + " text)");
        return stringBuilder.toString();
    }

    private ContentValues c(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(gD, bVar.aX());
        contentValues.put("type", bVar.getType());
        contentValues.put(gE, bVar.aY());
        contentValues.put(gG, bVar.getDataType());
        return contentValues;
    }

    private static String c(boolean z) {
        return z ? "primary key" : "";
    }

    public long a(b bVar) {
        return super.a(this.gH, c(bVar));
    }

    public long a(JSONArray jSONArray) {
        return super.b(this.gH, jSONArray);
    }

    public void ad(String str) {
        List arrayList = new ArrayList();
        arrayList.add(a.Equals);
        super.a(this.gH, new String[]{"type"}, new String[]{str}, arrayList);
    }

    public List<b> ae(String str) {
        List arrayList = new ArrayList();
        arrayList.add(a.Equals);
        return super.a(this.gH, new String[]{"type"}, new String[]{str}, null, arrayList);
    }

    public List<b> af(String str) {
        List arrayList = new ArrayList();
        arrayList.add(a.Equals);
        return super.a(this.gH, new String[]{gD}, new String[]{str}, null, arrayList);
    }

    public List<b> ag(String str) {
        List arrayList = new ArrayList();
        arrayList.add(a.Equals);
        List<b> a = super.a(this.gH, new String[]{"type"}, new String[]{str}, ai(gF), arrayList);
        if (a == null || a.isEmpty()) {
            return null;
        }
        ListIterator listIterator = a.listIterator();
        listIterator.next();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.remove();
        }
        return a;
    }

    public int b(String str, long j) {
        List arrayList = new ArrayList();
        arrayList.add(a.Equals);
        arrayList.add(a.LessThan);
        return super.a(this.gH, new String[]{"type", gF}, new String[]{str, String.valueOf(j)}, arrayList);
    }

    public long b(b bVar) {
        ad(bVar.getType());
        return super.a(this.gH, c(bVar));
    }

    public List<b> bm() {
        return super.ah(this.gH);
    }

    protected String[] bn() {
        return this.gu;
    }

    public List<b> c(String str, long j) {
        List arrayList = new ArrayList();
        arrayList.add(a.Equals);
        arrayList.add(a.GreaterThan);
        return super.a(this.gH, new String[]{"type", gF}, new String[]{str, String.valueOf(j)}, null, arrayList);
    }

    /* renamed from: d */
    protected b b(Cursor cursor) {
        return new b(cursor.getString(cursor.getColumnIndex(gD)), cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex(gE)), m.d(cursor.getLong(cursor.getColumnIndex(gF)) * 1000), cursor.getString(cursor.getColumnIndex(gG)));
    }

    public void delete() {
        super.delete(this.gH);
    }
}
