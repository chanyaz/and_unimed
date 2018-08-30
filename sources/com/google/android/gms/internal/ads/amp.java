package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.au;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@zzadh
public final class amp {
    private String a;
    private Map<String, String> b;
    private Context c = null;
    private String d = null;

    public amp(Context context, String str) {
        this.c = context;
        this.d = str;
        this.a = (String) akc.f().a(amn.O);
        this.b = new LinkedHashMap();
        this.b.put("s", "gmob_sdk");
        this.b.put("v", "3");
        this.b.put("os", VERSION.RELEASE);
        this.b.put("sdk", VERSION.SDK);
        au.e();
        this.b.put("device", ht.b());
        this.b.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map map = this.b;
        String str2 = "is_lite_sdk";
        au.e();
        map.put(str2, ht.k(context) ? "1" : "0");
        Future a = au.p().a(this.c);
        try {
            a.get();
            this.b.put("network_coarse", Integer.toString(((ec) a.get()).n));
            this.b.put("network_fine", Integer.toString(((ec) a.get()).o));
        } catch (Throwable e) {
            au.i().a(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    final String a() {
        return this.a;
    }

    final Context b() {
        return this.c;
    }

    final String c() {
        return this.d;
    }

    final Map<String, String> d() {
        return this.b;
    }
}
