package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.be;
import com.google.android.gms.common.api.internal.bl;
import com.google.android.gms.common.api.internal.bz;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.internal.ar;

@KeepForSdk
public class h<O extends ApiOptions> {
    protected final e a;
    private final Context b;
    private final Api<O> c;
    private final O d = null;
    private final bz<O> e;
    private final Looper f;
    private final int g;
    private final GoogleApiClient h;
    private final StatusExceptionMapper i;

    @KeepForSdk
    protected h(@NonNull Context context, Api<O> api, Looper looper) {
        ar.a((Object) context, (Object) "Null context is not permitted.");
        ar.a((Object) api, (Object) "Api must not be null.");
        ar.a((Object) looper, (Object) "Looper must not be null.");
        this.b = context.getApplicationContext();
        this.c = api;
        this.f = looper;
        this.e = bz.a(api);
        this.h = new be(this);
        this.a = e.a(this.b);
        this.g = this.a.b();
        this.i = new a();
    }

    private final <A extends AnyClient, T extends b<? extends Result, A>> T a(int i, @NonNull T t) {
        t.h();
        this.a.a(this, i, t);
        return t;
    }

    @WorkerThread
    public Client a(Looper looper, f<O> fVar) {
        return this.c.b().a(this.b, looper, e().a(), this.d, fVar, fVar);
    }

    public final Api<O> a() {
        return this.c;
    }

    @KeepForSdk
    public <A extends AnyClient, T extends b<? extends Result, A>> T a(@NonNull T t) {
        return a(0, (b) t);
    }

    public bl a(Context context, Handler handler) {
        return new bl(context, handler, e().a());
    }

    @KeepForSdk
    public <A extends AnyClient, T extends b<? extends Result, A>> T b(@NonNull T t) {
        return a(1, (b) t);
    }

    public final bz<O> b() {
        return this.e;
    }

    public final int c() {
        return this.g;
    }

    @KeepForSdk
    public Looper d() {
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0023  */
    @com.google.android.gms.common.annotation.KeepForSdk
    protected com.google.android.gms.common.internal.o e() {
        /*
        r2 = this;
        r1 = new com.google.android.gms.common.internal.o;
        r1.<init>();
        r0 = r2.d;
        r0 = r0 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
        if (r0 == 0) goto L_0x004e;
    L_0x000b:
        r0 = r2.d;
        r0 = (com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) r0;
        r0 = r0.getGoogleSignInAccount();
        if (r0 == 0) goto L_0x004e;
    L_0x0015:
        r0 = r0.d();
    L_0x0019:
        r1 = r1.a(r0);
        r0 = r2.d;
        r0 = r0 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
        if (r0 == 0) goto L_0x005f;
    L_0x0023:
        r0 = r2.d;
        r0 = (com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) r0;
        r0 = r0.getGoogleSignInAccount();
        if (r0 == 0) goto L_0x005f;
    L_0x002d:
        r0 = r0.l();
    L_0x0031:
        r0 = r1.a(r0);
        r1 = r2.b;
        r1 = r1.getClass();
        r1 = r1.getName();
        r0 = r0.b(r1);
        r1 = r2.b;
        r1 = r1.getPackageName();
        r0 = r0.a(r1);
        return r0;
    L_0x004e:
        r0 = r2.d;
        r0 = r0 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions;
        if (r0 == 0) goto L_0x005d;
    L_0x0054:
        r0 = r2.d;
        r0 = (com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions) r0;
        r0 = r0.getAccount();
        goto L_0x0019;
    L_0x005d:
        r0 = 0;
        goto L_0x0019;
    L_0x005f:
        r0 = java.util.Collections.emptySet();
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.h.e():com.google.android.gms.common.internal.o");
    }
}
