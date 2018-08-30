package com.appnext.base.a.c;

import android.database.Cursor;
import android.text.TextUtils;
import com.appnext.base.a.c.e.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends e<com.appnext.base.a.b.c> {
    private static final String COLUMN_STATUS = "status";
    private static final String gA = "service_key";
    private static final String gB = "exact";
    private static final String gC = "data";
    public static final String gs = "config_table";
    public static final String gv = "key";
    private static final String gw = "sample";
    private static final String gx = "sample_type";
    private static final String gy = "cycle";
    private static final String gz = "cycle_type";
    private String[] gu = new String[]{gv, COLUMN_STATUS, gw, gx, gy, gz, gB, "service_key", "data"};

    public static String bl() {
        return "create table config_table ( key text primary key, status text not null default 'off', sample text not null default '1', sample_type text not null default '',cycle text not null default '1', cycle_type text not null default 'once', exact text not null default 'false', service_key text not null default '', data text not null default '')";
    }

    public long a(JSONObject jSONObject) {
        return super.a(gs, jSONObject);
    }

    public void ab(String str) {
        if (!TextUtils.isEmpty(str)) {
            List arrayList = new ArrayList();
            arrayList.add(a.Equals);
            super.a(gs, new String[]{gv}, new String[]{str}, arrayList);
        }
    }

    public com.appnext.base.a.b.c ac(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List arrayList = new ArrayList();
        arrayList.add(a.Equals);
        List a = super.a(gs, new String[]{gv}, new String[]{str}, null, arrayList);
        return (a == null || a.size() <= 0) ? null : (com.appnext.base.a.b.c) a.get(0);
    }

    public long b(JSONArray jSONArray) {
        return super.a(gs, jSONArray);
    }

    public List<com.appnext.base.a.b.c> bm() {
        return super.ah(gs);
    }

    protected String[] bn() {
        return this.gu;
    }

    /* renamed from: c */
    protected com.appnext.base.a.b.c b(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex(gv));
        return new com.appnext.base.a.b.c(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)), cursor.getString(cursor.getColumnIndex(gw)), cursor.getString(cursor.getColumnIndex(gx)), cursor.getString(cursor.getColumnIndex(gy)), cursor.getString(cursor.getColumnIndex(gz)), Boolean.valueOf(cursor.getString(cursor.getColumnIndex(gB))).booleanValue(), string, cursor.getString(cursor.getColumnIndex("service_key")), cursor.getString(cursor.getColumnIndex("data")));
    }

    public void delete() {
        super.delete(gs);
    }
}
