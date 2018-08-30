package com.google.android.gms.analytics.a;

import com.google.android.gms.analytics.r;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@VisibleForTesting
public class a {
    private Map<String, String> a = new HashMap();

    public final Map<String, String> a(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return r.a(this.a);
    }
}
