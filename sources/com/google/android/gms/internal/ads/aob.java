package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class aob {
    private final WeakReference<zzaqw> a;
    private String b;

    public aob(zzaqw zzaqw) {
        this.a = new WeakReference(zzaqw);
    }

    public final void a(zzacm zzacm) {
        zzacm.zza("/loadHtml", new aoc(this, zzacm));
        zzacm.zza("/showOverlay", new aoe(this, zzacm));
        zzacm.zza("/hideOverlay", new aof(this, zzacm));
        zzaqw zzaqw = (zzaqw) this.a.get();
        if (zzaqw != null) {
            zzaqw.zza("/sendMessageToSdk", new aog(this, zzacm));
        }
    }
}
