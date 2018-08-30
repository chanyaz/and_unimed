package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.r;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class je extends r<je> {
    private Map<Integer, String> a = new HashMap(4);

    public final Map<Integer, String> a() {
        return Collections.unmodifiableMap(this.a);
    }

    public final /* synthetic */ void a(r rVar) {
        ((je) rVar).a.putAll(this.a);
    }

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 9).append("dimension").append(valueOf).toString(), entry.getValue());
        }
        return r.a((Object) hashMap);
    }
}
