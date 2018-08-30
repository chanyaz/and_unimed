package com.google.android.gms.internal.measurement;

final class fg implements Runnable {
    private final /* synthetic */ zzeu a;
    private final /* synthetic */ String b;
    private final /* synthetic */ eu c;

    fg(eu euVar, zzeu zzeu, String str) {
        this.c = euVar;
        this.a = zzeu;
        this.b = str;
    }

    public final void run() {
        this.c.a.D();
        this.c.a.a(this.a, this.b);
    }
}
