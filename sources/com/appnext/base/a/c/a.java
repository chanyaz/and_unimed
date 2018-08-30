package com.appnext.base.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class a extends e<com.appnext.base.a.b.a> {
    private static final String COLUMN_PACKAGE_NAME = "p";
    public static final String gs = "category_table";
    private static final String gt = "c";
    private String[] gu = new String[]{COLUMN_PACKAGE_NAME, gt};

    private ContentValues b(com.appnext.base.a.b.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PACKAGE_NAME, aVar.getPackageName());
        contentValues.put(gt, aVar.aW());
        return contentValues;
    }

    public static String bl() {
        return "create table category_table ( p text, c integer)";
    }

    public void Z(String str) {
        List arrayList = new ArrayList();
        arrayList.add(com.appnext.base.a.c.e.a.Equals);
        super.a(gs, new String[]{COLUMN_PACKAGE_NAME}, new String[]{str}, arrayList);
    }

    public long a(com.appnext.base.a.b.a aVar) {
        return super.a(gs, b(aVar));
    }

    public long a(JSONArray jSONArray) {
        return super.a(gs, jSONArray);
    }

    /* renamed from: a */
    protected com.appnext.base.a.b.a b(Cursor cursor) {
        return new com.appnext.base.a.b.a(cursor.getString(cursor.getColumnIndex(COLUMN_PACKAGE_NAME)), Integer.valueOf(cursor.getInt(cursor.getColumnIndex(gt))));
    }

    public List<com.appnext.base.a.b.a> aa(String str) {
        List arrayList = new ArrayList();
        arrayList.add(com.appnext.base.a.c.e.a.Equals);
        return super.a(gs, new String[]{COLUMN_PACKAGE_NAME}, new String[]{str}, null, arrayList);
    }

    public List<com.appnext.base.a.b.a> bm() {
        return super.ah(gs);
    }

    protected String[] bn() {
        return this.gu;
    }

    public void delete() {
        super.delete(gs);
    }
}
