package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class as extends i {
    private WeakReference<ao> a;

    as(ao aoVar) {
        this.a = new WeakReference(aoVar);
    }

    public final void a() {
        ao aoVar = (ao) this.a.get();
        if (aoVar != null) {
            aoVar.j();
        }
    }
}
