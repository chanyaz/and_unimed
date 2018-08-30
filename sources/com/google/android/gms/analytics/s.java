package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

public class s<T extends s> {
    protected final q a;
    private final t b;
    private final List<zzh> c = new ArrayList();

    @VisibleForTesting
    protected s(t tVar, Clock clock) {
        ar.a((Object) tVar);
        this.b = tVar;
        q qVar = new q(this, clock);
        qVar.j();
        this.a = qVar;
    }

    protected void a(q qVar) {
    }

    protected final void b(q qVar) {
        for (zzh zza : this.c) {
            zza.zza(this, qVar);
        }
    }

    public q h() {
        q a = this.a.a();
        b(a);
        return a;
    }

    protected final t i() {
        return this.b;
    }
}
