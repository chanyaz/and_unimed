package com.google.android.gms.internal.ads;

public final class aid {
    private final byte[] a;
    private int b;
    private int c;
    private final /* synthetic */ aib d;

    private aid(aib aib, byte[] bArr) {
        this.d = aib;
        this.a = bArr;
    }

    /* synthetic */ aid(aib aib, byte[] bArr, aic aic) {
        this(aib, bArr);
    }

    public final aid a(int i) {
        this.b = i;
        return this;
    }

    public final synchronized void a() {
        try {
            if (this.d.b) {
                this.d.a.zzc(this.a);
                this.d.a.zzg(this.b);
                this.d.a.zzh(this.c);
                this.d.a.zza(null);
                this.d.a.zzbd();
            }
        } catch (Throwable e) {
            kk.a("Clearcut log failed", e);
        }
        return;
    }

    public final aid b(int i) {
        this.c = i;
        return this;
    }
}
