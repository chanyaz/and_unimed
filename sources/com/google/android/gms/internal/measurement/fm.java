package com.google.android.gms.internal.measurement;

final class fm implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ long d;
    private final /* synthetic */ eu e;

    fm(eu euVar, String str, String str2, String str3, long j) {
        this.e = euVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }

    public final void run() {
        if (this.a == null) {
            this.e.a.F().n().a(this.b, null);
            return;
        }
        this.e.a.F().n().a(this.b, new gk(this.c, this.a, this.d));
    }
}
