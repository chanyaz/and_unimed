package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.l;

public final class alx extends alf {
    private final l a;

    public alx(l lVar) {
        this.a = lVar;
    }

    public final void onVideoEnd() {
        this.a.d();
    }

    public final void onVideoMute(boolean z) {
        this.a.a(z);
    }

    public final void onVideoPause() {
        this.a.c();
    }

    public final void onVideoPlay() {
        this.a.b();
    }

    public final void onVideoStart() {
        this.a.a();
    }
}
