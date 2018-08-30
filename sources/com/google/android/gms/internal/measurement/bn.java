package com.google.android.gms.internal.measurement;

final class bn implements zzbt<bo> {
    private final ah a;
    private final bo b = new bo();

    public bn(ah ahVar) {
        this.a = ahVar;
    }

    public final void zza(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.b.e = z ? 1 : 0;
            return;
        }
        this.a.e().d("Bool xml configuration name not recognized", str);
    }

    public final void zzb(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.b.d = i;
        } else {
            this.a.e().d("Int xml configuration name not recognized", str);
        }
    }

    public final void zzb(String str, String str2) {
    }

    public final void zzc(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.b.a = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.b.b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.b.c = str2;
        } else {
            this.a.e().d("String xml configuration name not recognized", str);
        }
    }

    public final /* synthetic */ zzbr zzdr() {
        return this.b;
    }
}
