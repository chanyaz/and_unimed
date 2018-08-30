package com.google.android.gms.internal.ads;

final /* synthetic */ class atc implements Runnable {
    private final zzuu a;

    private atc(zzuu zzuu) {
        this.a = zzuu;
    }

    static Runnable a(zzuu zzuu) {
        return new atc(zzuu);
    }

    public final void run() {
        this.a.destroy();
    }
}
