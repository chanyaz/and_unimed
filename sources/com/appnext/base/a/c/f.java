package com.appnext.base.a.c;

import org.json.JSONArray;

public class f extends d {
    public static final String gs = "offline_data_table";

    public f() {
        super(gs);
    }

    public static String bl() {
        return d.b(gs, true);
    }

    public long a(JSONArray jSONArray) {
        return super.a(gs, jSONArray);
    }
}
