package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@VisibleForTesting
public class f<T extends f> {
    private Map<String, String> a = new HashMap();
    private b b;
    private Map<String, List<a>> c = new HashMap();
    private List<c> d = new ArrayList();
    private List<a> e = new ArrayList();

    protected f() {
    }

    public final T a(String str, String str2) {
        if (str != null) {
            this.a.put(str, str2);
        } else {
            bs.b("HitBuilder.set() called with a null paramName.");
        }
        return this;
    }

    public Map<String, String> a() {
        Map<String, String> hashMap = new HashMap(this.a);
        if (this.b != null) {
            hashMap.putAll(this.b.a());
        }
        int i = 1;
        for (c a : this.d) {
            hashMap.putAll(a.a(n.e(i)));
            i++;
        }
        i = 1;
        for (a a2 : this.e) {
            hashMap.putAll(a2.a(n.c(i)));
            i++;
        }
        int i2 = 1;
        for (Entry entry : this.c.entrySet()) {
            List<a> list = (List) entry.getValue();
            String h = n.h(i2);
            int i3 = 1;
            for (a aVar : list) {
                String valueOf = String.valueOf(h);
                String valueOf2 = String.valueOf(n.g(i3));
                hashMap.putAll(aVar.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                i3++;
            }
            if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                String valueOf3 = String.valueOf(h);
                String valueOf4 = String.valueOf("nm");
                hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry.getKey());
            }
            i2++;
        }
        return hashMap;
    }
}
