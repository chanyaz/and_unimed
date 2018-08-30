package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.SignInResponse;

final class bo implements Runnable {
    private final /* synthetic */ SignInResponse a;
    private final /* synthetic */ bl b;

    bo(bl blVar, SignInResponse signInResponse) {
        this.b = blVar;
        this.a = signInResponse;
    }

    public final void run() {
        this.b.a(this.a);
    }
}
