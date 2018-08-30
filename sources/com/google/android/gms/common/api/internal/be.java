package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.h;

public final class be<O extends ApiOptions> extends y {
    private final h<O> a;

    public be(h<O> hVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.a = hVar;
    }

    public final Looper a() {
        return this.a.d();
    }

    public final <A extends AnyClient, R extends Result, T extends b<R, A>> T a(@NonNull T t) {
        return this.a.a(t);
    }

    public final void a(bq bqVar) {
    }

    public final <A extends AnyClient, T extends b<? extends Result, A>> T b(@NonNull T t) {
        return this.a.b(t);
    }

    public final void b(bq bqVar) {
    }
}
