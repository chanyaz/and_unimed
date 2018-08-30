package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.r;
import com.google.android.gms.common.internal.ar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ju extends r<ju> {
    private final Map<String, Object> a = new HashMap();

    public final Map<String, Object> a() {
        return Collections.unmodifiableMap(this.a);
    }

    public final /* synthetic */ void a(r rVar) {
        Object obj = (ju) rVar;
        ar.a(obj);
        obj.a.putAll(this.a);
    }

    public final void a(String str, String str2) {
        ar.a(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        ar.a(str, (Object) "Name can not be empty or \"&\"");
        this.a.put(str, str2);
    }

    public final String toString() {
        return r.a((Object) this.a);
    }
}
