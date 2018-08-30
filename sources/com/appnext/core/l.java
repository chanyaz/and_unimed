package com.appnext.core;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;

public class l {
    private static l mc;
    private int ec = 24;
    private HashMap<String, SharedPreferences> md = new HashMap();

    private l() {
    }

    public static synchronized l dg() {
        l lVar;
        synchronized (l.class) {
            if (mc == null) {
                mc = new l();
            }
            lVar = mc;
        }
        return lVar;
    }

    public void aR(String str) {
        ((SharedPreferences) this.md.get(str)).edit().clear().apply();
    }

    public void c(int i) {
        this.ec = i;
    }

    public void i(final Context context, final String str) {
        if (!this.md.containsKey(str.replace("/", ""))) {
            new Thread(new Runnable() {
                public void run() {
                    l.this.md.put(str, context.getSharedPreferences("apnxt_cap" + str.replace("/", ""), 0));
                }
            }).start();
        }
    }

    public void q(String str, String str2) {
        ((SharedPreferences) this.md.get(str2)).edit().putLong(str, System.currentTimeMillis()).apply();
    }

    public boolean r(String str, String str2) {
        long j = ((SharedPreferences) this.md.get(str2)).getLong(str, -1);
        return j != -1 && System.currentTimeMillis() - ((long) (3600000 * this.ec)) <= j;
    }

    public boolean s(String str, String str2) {
        long j = ((SharedPreferences) this.md.get(str2)).getLong(str, -1);
        return j != -1 && System.currentTimeMillis() - 120000 <= j;
    }
}
