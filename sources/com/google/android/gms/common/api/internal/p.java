package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.b;

@KeepForSdk
public abstract class p<A extends AnyClient, L> {
    private final ListenerHolder<L> a;

    @KeepForSdk
    public void a() {
        this.a.a();
    }

    @KeepForSdk
    protected abstract void a(A a, b<Void> bVar);
}
