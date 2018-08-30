package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class bw<A extends b<? extends Result, AnyClient>> extends aq {
    private final A a;

    public bw(int i, A a) {
        super(i);
        this.a = a;
    }

    public final void a(@NonNull Status status) {
        this.a.setFailedResult(status);
    }

    public final void a(f<?> fVar) {
        try {
            this.a.a(fVar.b());
        } catch (RuntimeException e) {
            a(e);
        }
    }

    public final void a(@NonNull t tVar, boolean z) {
        tVar.a(this.a, z);
    }

    public final void a(@NonNull RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        this.a.setFailedResult(new Status(10, new StringBuilder((String.valueOf(simpleName).length() + 2) + String.valueOf(localizedMessage).length()).append(simpleName).append(": ").append(localizedMessage).toString()));
    }
}
