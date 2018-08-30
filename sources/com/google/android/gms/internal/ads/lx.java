package com.google.android.gms.internal.ads;

final class lx implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ lt c;

    lx(lt ltVar, String str, String str2) {
        this.c = ltVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        if (this.c.r != null) {
            this.c.r.zzg(this.a, this.b);
        }
    }
}
