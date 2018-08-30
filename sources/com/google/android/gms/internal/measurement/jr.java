package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.r;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class jr extends r<jr> {
    private Map<Integer, Double> a = new HashMap(4);

    public final Map<Integer, Double> a() {
        return Collections.unmodifiableMap(this.a);
    }

    public final /* synthetic */ void a(r rVar) {
        ((jr) rVar).a.putAll(this.a);
    }

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 6).append("metric").append(valueOf).toString(), entry.getValue());
        }
        return r.a((Object) hashMap);
    }
}
