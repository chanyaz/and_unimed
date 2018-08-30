package com.google.android.gms.common.api.internal;

import android.support.v4.util.b;
import com.google.android.gms.common.ConnectionResult;

public class w extends cd {
    private final b<bz<?>> e;
    private e f;

    private final void i() {
        if (!this.e.isEmpty()) {
            this.f.a(this);
        }
    }

    protected final void a(ConnectionResult connectionResult, int i) {
        this.f.b(connectionResult, i);
    }

    public final void b() {
        super.b();
        i();
    }

    public final void c() {
        super.c();
        i();
    }

    public void d() {
        super.d();
        this.f.b(this);
    }

    protected final void f() {
        this.f.c();
    }

    final b<bz<?>> g() {
        return this.e;
    }
}
