package com.google.android.gms.internal.measurement;

final class fs implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Object c;
    private final /* synthetic */ long d;
    private final /* synthetic */ fq e;

    fs(fq fqVar, String str, String str2, Object obj, long j) {
        this.e = fqVar;
        this.a = str;
        this.b = str2;
        this.c = obj;
        this.d = j;
    }

    public final void run() {
        this.e.a(this.a, this.b, this.c, this.d);
    }
}
