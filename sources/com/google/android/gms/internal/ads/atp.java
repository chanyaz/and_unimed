package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.ar;

public final class atp extends ln<zzuu> {
    private final Object a = new Object();
    private zzalo<zzuu> b;
    private boolean c;
    private int d;

    public atp(zzalo<zzuu> zzalo) {
        this.b = zzalo;
        this.c = false;
        this.d = 0;
    }

    private final void f() {
        synchronized (this.a) {
            ar.a(this.d >= 0);
            if (this.c && this.d == 0) {
                hl.a("No reference is left (including root). Cleaning up engine.");
                zza(new ats(this), new lm());
            } else {
                hl.a("There are still references to the engine. Not destroying.");
            }
        }
    }

    public final atl c() {
        atl atl = new atl(this);
        synchronized (this.a) {
            zza(new atq(this, atl), new atr(this, atl));
            ar.a(this.d >= 0);
            this.d++;
        }
        return atl;
    }

    protected final void d() {
        synchronized (this.a) {
            ar.a(this.d > 0);
            hl.a("Releasing 1 reference for JS Engine");
            this.d--;
            f();
        }
    }

    public final void e() {
        boolean z = true;
        synchronized (this.a) {
            if (this.d < 0) {
                z = false;
            }
            ar.a(z);
            hl.a("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.c = true;
            f();
        }
    }
}
