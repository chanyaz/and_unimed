package com.appnext.base.receivers;

import android.content.Context;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class b extends a {
    protected String a(Boolean bool, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("connected", bool);
            jSONObject.put("name", str);
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
        return jSONArray.toString();
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }
}
