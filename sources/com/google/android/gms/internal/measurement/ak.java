package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ak {
    private final long a = 0;
    private final String b;
    private final String c;
    private final boolean d;
    private long e;
    private final Map<String, String> f;

    public ak(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        ar.a(str);
        ar.a(str2);
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = j2;
        if (map != null) {
            this.f = new HashMap(map);
        } else {
            this.f = Collections.emptyMap();
        }
    }

    public final long a() {
        return this.a;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public final Map<String, String> f() {
        return this.f;
    }
}
