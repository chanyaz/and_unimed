package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.ap;

public final class bz<O extends ApiOptions> {
    private final boolean a = true;
    private final int b;
    private final Api<O> c;
    private final O d;

    private bz(Api<O> api) {
        this.c = api;
        this.d = null;
        this.b = System.identityHashCode(this);
    }

    public static <O extends ApiOptions> bz<O> a(Api<O> api) {
        return new bz(api);
    }

    public final String a() {
        return this.c.d();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bz)) {
            return false;
        }
        bz bzVar = (bz) obj;
        return !this.a && !bzVar.a && ap.a(this.c, bzVar.c) && ap.a(this.d, bzVar.d);
    }

    public final int hashCode() {
        return this.b;
    }
}
