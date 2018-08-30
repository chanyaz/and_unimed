package com.google.android.gms.internal.ads;

public class zzae extends Exception {
    private final any a;
    private long b;

    public zzae() {
        this.a = null;
    }

    public zzae(any any) {
        this.a = any;
    }

    public zzae(String str) {
        super(str);
        this.a = null;
    }

    public zzae(Throwable th) {
        super(th);
        this.a = null;
    }

    final void a(long j) {
        this.b = j;
    }
}
