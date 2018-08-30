package com.appnext.base.a.b;

import android.text.TextUtils;
import org.json.JSONObject;

public class c extends d {
    private String gf;
    private String gg;
    private String gh;
    private String gi;
    private String gj;
    private String gk;
    private boolean gl;
    private String gm;
    private JSONObject gn;

    public c(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8) {
        this.gf = str;
        this.gg = str2;
        this.gh = str3;
        this.gi = str4;
        this.gj = str5;
        this.gk = str6;
        this.gl = z;
        this.gm = str7;
        if (TextUtils.isEmpty(str8)) {
            this.gn = null;
            return;
        }
        try {
            this.gn = new JSONObject(str8);
        } catch (Throwable th) {
            this.gn = null;
        }
    }

    private boolean Y(String str) {
        return (this.gn == null || !this.gn.has(str) || this.gn.isNull(str)) ? false : true;
    }

    public long a(String str, long j) {
        if (!Y(str)) {
            return j;
        }
        try {
            return this.gn.getLong(str);
        } catch (Throwable th) {
            return j;
        }
    }

    public boolean a(String str, boolean z) {
        if (!Y(str)) {
            return z;
        }
        try {
            return this.gn.getBoolean(str);
        } catch (Throwable th) {
            return z;
        }
    }

    public int b(String str, int i) {
        if (!Y(str)) {
            return i;
        }
        try {
            return this.gn.getInt(str);
        } catch (Throwable th) {
            return i;
        }
    }

    public String ba() {
        return this.gf;
    }

    public String bb() {
        return this.gg;
    }

    public String bc() {
        return this.gh;
    }

    public String bd() {
        return this.gi;
    }

    public String be() {
        return this.gj;
    }

    public String bf() {
        return this.gm;
    }

    public boolean bg() {
        return this.gl;
    }

    public JSONObject bh() {
        return this.gn;
    }

    public String e(String str, String str2) {
        if (!Y(str)) {
            return str2;
        }
        try {
            return this.gn.getString(str);
        } catch (Throwable th) {
            return str2;
        }
    }

    public String getKey() {
        return this.gk;
    }
}
