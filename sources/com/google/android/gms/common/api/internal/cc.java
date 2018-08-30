package com.google.android.gms.common.api.internal;

import android.support.annotation.Nullable;
import android.support.v4.util.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.h;
import com.google.android.gms.tasks.b;
import java.util.Map;
import java.util.Set;

public final class cc {
    private final a<bz<?>, ConnectionResult> a = new a();
    private final a<bz<?>, String> b = new a();
    private final b<Map<bz<?>, String>> c = new b();
    private int d;
    private boolean e = false;

    public cc(Iterable<? extends h<?>> iterable) {
        for (h b : iterable) {
            this.a.put(b.b(), null);
        }
        this.d = this.a.keySet().size();
    }

    public final Set<bz<?>> a() {
        return this.a.keySet();
    }

    public final void a(bz<?> bzVar, ConnectionResult connectionResult, @Nullable String str) {
        this.a.put(bzVar, connectionResult);
        this.b.put(bzVar, str);
        this.d--;
        if (!connectionResult.b()) {
            this.e = true;
        }
        if (this.d != 0) {
            return;
        }
        if (this.e) {
            this.c.a(new AvailabilityException(this.a));
            return;
        }
        this.c.a(this.b);
    }

    public final com.google.android.gms.tasks.a<Map<bz<?>, String>> b() {
        return this.c.a();
    }
}
