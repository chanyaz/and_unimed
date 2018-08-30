package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.util.VisibleForTesting;

public class b {
    @VisibleForTesting
    private static int a = 31;
    private int b = 1;

    public int a() {
        return this.b;
    }

    public b a(Object obj) {
        this.b = (obj == null ? 0 : obj.hashCode()) + (this.b * a);
        return this;
    }

    public b a(boolean z) {
        this.b = (z ? 1 : 0) + (this.b * a);
        return this;
    }
}
