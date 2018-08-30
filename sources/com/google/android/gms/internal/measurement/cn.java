package com.google.android.gms.internal.measurement;

final class cn implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ long b;
    private final /* synthetic */ cl c;

    cn(cl clVar, String str, long j) {
        this.c = clVar;
        this.a = str;
        this.b = j;
    }

    public final void run() {
        this.c.b(this.a, this.b);
    }
}
