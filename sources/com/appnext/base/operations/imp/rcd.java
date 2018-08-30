package com.appnext.base.operations.imp;

import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.a.c.d;
import com.appnext.base.operations.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class rcd extends e {
    public static final String DATA = "data";
    private List<b> ha;
    private String hd;

    public rcd(c cVar, Bundle bundle) {
        super(cVar, bundle);
        if (bundle != null) {
            this.hd = bundle.getString("data");
        }
    }

    protected boolean bz() {
        return (this.ha == null || this.ha.isEmpty()) ? false : true;
    }

    protected List<b> getData() {
        try {
            this.ha = new ArrayList();
            JSONArray jSONArray = new JSONArray(this.hd);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                try {
                    this.ha.add(new b(jSONObject.getString(d.gD), jSONObject.getString("type"), jSONObject.getString(d.gE), jSONObject.getString(d.gG)));
                } catch (Throwable th) {
                }
            }
            return this.ha;
        } catch (Throwable th2) {
            return null;
        }
    }

    public boolean hasPermission() {
        return true;
    }
}
