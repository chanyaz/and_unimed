package com.google.android.gms.internal.ads;

public final class atl extends ln<zzwb> {
    private final Object a = new Object();
    private final atp b;
    private boolean c;

    public atl(atp atp) {
        this.b = atp;
    }

    public final void c() {
        synchronized (this.a) {
            if (this.c) {
                return;
            }
            this.c = true;
            zza(new atm(this), new lm());
            zza(new atn(this), new ato(this));
        }
    }
}
