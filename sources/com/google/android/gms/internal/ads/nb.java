package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;

final class nb implements Runnable {
    private final /* synthetic */ na a;

    nb(na naVar) {
        this.a = naVar;
    }

    public final void run() {
        au.z().b(this.a);
    }
}
