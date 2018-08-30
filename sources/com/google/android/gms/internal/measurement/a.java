package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.analytics.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class a extends r<a> {
    private final List<com.google.android.gms.analytics.a.a> a = new ArrayList();
    private final List<c> b = new ArrayList();
    private final Map<String, List<com.google.android.gms.analytics.a.a>> c = new HashMap();
    private b d;

    public final b a() {
        return this.d;
    }

    public final /* synthetic */ void a(r rVar) {
        a aVar = (a) rVar;
        aVar.a.addAll(this.a);
        aVar.b.addAll(this.b);
        for (Entry entry : this.c.entrySet()) {
            String str = (String) entry.getKey();
            for (com.google.android.gms.analytics.a.a aVar2 : (List) entry.getValue()) {
                if (aVar2 != null) {
                    Object obj;
                    if (str == null) {
                        obj = "";
                    } else {
                        String obj2 = str;
                    }
                    if (!aVar.c.containsKey(obj2)) {
                        aVar.c.put(obj2, new ArrayList());
                    }
                    ((List) aVar.c.get(obj2)).add(aVar2);
                }
            }
        }
        if (this.d != null) {
            aVar.d = this.d;
        }
    }

    public final List<com.google.android.gms.analytics.a.a> b() {
        return Collections.unmodifiableList(this.a);
    }

    public final Map<String, List<com.google.android.gms.analytics.a.a>> c() {
        return this.c;
    }

    public final List<c> d() {
        return Collections.unmodifiableList(this.b);
    }

    public final String toString() {
        Map hashMap = new HashMap();
        if (!this.a.isEmpty()) {
            hashMap.put("products", this.a);
        }
        if (!this.b.isEmpty()) {
            hashMap.put("promotions", this.b);
        }
        if (!this.c.isEmpty()) {
            hashMap.put("impressions", this.c);
        }
        hashMap.put("productAction", this.d);
        return r.a((Object) hashMap);
    }
}
