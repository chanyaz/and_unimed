package com.google.android.gms.common.api.internal;

import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

final class cf implements Runnable {
    final /* synthetic */ cd a;
    private final ce b;

    cf(cd cdVar, ce ceVar) {
        this.a = cdVar;
        this.b = ceVar;
    }

    @MainThread
    public final void run() {
        if (this.a.b) {
            ConnectionResult b = this.b.b();
            if (b.a()) {
                this.a.a.startActivityForResult(GoogleApiActivity.a(this.a.a(), b.d(), this.b.a(), false), 1);
            } else if (this.a.d.a(b.c())) {
                this.a.d.a(this.a.a(), this.a.a, b.c(), 2, this.a);
            } else if (b.c() == 18) {
                this.a.d.a(this.a.a().getApplicationContext(), new cg(this, this.a.d.a(this.a.a(), this.a)));
            } else {
                this.a.a(b, this.b.a());
            }
        }
    }
}
