package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;

public final class cn<O extends ApiOptions> extends h<O> {
    private final Client b;
    private final ci c;
    private final n d;
    private final a<? extends SignInClient, c> e;

    public cn(@NonNull Context context, Api<O> api, Looper looper, @NonNull Client client, @NonNull ci ciVar, n nVar, a<? extends SignInClient, c> aVar) {
        super(context, api, looper);
        this.b = client;
        this.c = ciVar;
        this.d = nVar;
        this.e = aVar;
        this.a.a((h) this);
    }

    public final Client a(Looper looper, f<O> fVar) {
        this.c.a(fVar);
        return this.b;
    }

    public final bl a(Context context, Handler handler) {
        return new bl(context, handler, this.d, this.e);
    }

    public final Client f() {
        return this.b;
    }
}
