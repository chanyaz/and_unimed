package com.google.android.gms.common.api.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.tasks.b;

@KeepForSdk
public abstract class r<A extends AnyClient, ResultT> {
    private final Feature[] a = null;
    private final boolean b = false;

    @KeepForSdk
    protected abstract void a(A a, b<ResultT> bVar);

    @Nullable
    public final Feature[] a() {
        return this.a;
    }

    @KeepForSdk
    public boolean b() {
        return this.b;
    }
}
