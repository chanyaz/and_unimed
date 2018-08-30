package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final class amo implements Callable<Void> {
    private final /* synthetic */ Context a;

    amo(Context context) {
        this.a = context;
    }

    public final /* synthetic */ Object call() {
        akc.f().a(this.a);
        return null;
    }
}
