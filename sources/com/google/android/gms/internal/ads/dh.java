package com.google.android.gms.internal.ads;

final class dh implements zzaoo<zzwb> {
    private final /* synthetic */ dg a;

    dh(dg dgVar) {
        this.a = dgVar;
    }

    public final /* synthetic */ void zze(Object obj) {
        try {
            ((zzwb) obj).zzb("AFMA_getAdapterLessMediationAd", this.a.a);
        } catch (Throwable e) {
            kk.b("Error requesting an ad url", e);
            de.f.b(this.a.b);
        }
    }
}
