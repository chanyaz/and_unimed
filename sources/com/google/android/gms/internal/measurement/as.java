package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class as extends af {
    private final jc a = new jc();

    as(ah ahVar) {
        super(ahVar);
    }

    protected final void a() {
        m().a().a(this.a);
        ck q = q();
        String c = q.c();
        if (c != null) {
            this.a.a(c);
        }
        String b = q.b();
        if (b != null) {
            this.a.b(b);
        }
    }

    public final jc b() {
        y();
        return this.a;
    }
}
