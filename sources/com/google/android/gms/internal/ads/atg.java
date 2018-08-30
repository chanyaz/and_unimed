package com.google.android.gms.internal.ads;

final /* synthetic */ class atg implements Runnable {
    private final zzuu a;

    private atg(zzuu zzuu) {
        this.a = zzuu;
    }

    static Runnable a(zzuu zzuu) {
        return new atg(zzuu);
    }

    public final void run() {
        this.a.destroy();
    }
}
