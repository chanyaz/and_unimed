package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
abstract class aju<T> {
    private final /* synthetic */ ajt a;

    aju(ajt ajt) {
        this.a = ajt;
    }

    @Nullable
    protected abstract T a();

    @Nullable
    protected abstract T a(zzld zzld);

    @Nullable
    protected final T b() {
        T t = null;
        zzld a = this.a.b();
        if (a == null) {
            kk.e("ClientApi class cannot be loaded.");
            return t;
        }
        try {
            return a(a);
        } catch (Throwable e) {
            kk.c("Cannot invoke local loader using ClientApi class", e);
            return t;
        }
    }

    @Nullable
    protected final T c() {
        try {
            return a();
        } catch (Throwable e) {
            kk.c("Cannot invoke remote loader", e);
            return null;
        }
    }
}
