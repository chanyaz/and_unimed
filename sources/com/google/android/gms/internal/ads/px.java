package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class px {
    private ua a;

    private px(ua uaVar) {
        this.a = uaVar;
    }

    static final px a(ua uaVar) {
        if (uaVar != null && uaVar.c() > 0) {
            return new px(uaVar);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    final ua a() {
        return this.a;
    }

    public final String toString() {
        return qd.a(this.a).toString();
    }
}
