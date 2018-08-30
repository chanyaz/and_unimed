package com.google.android.gms.analytics.a;

import com.google.android.gms.analytics.r;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@VisibleForTesting
public class b {
    private Map<String, String> a;

    @VisibleForTesting
    public final Map<String, String> a() {
        return new HashMap(this.a);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.a.entrySet()) {
            if (((String) entry.getKey()).startsWith("&")) {
                hashMap.put(((String) entry.getKey()).substring(1), (String) entry.getValue());
            } else {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return r.a(hashMap);
    }
}
