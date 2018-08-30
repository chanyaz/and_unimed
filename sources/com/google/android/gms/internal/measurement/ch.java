package com.google.android.gms.internal.measurement;

final class ch extends ae implements zzbt<ci> {
    private final ci a = new ci();

    public ch(ah ahVar) {
        super(ahVar);
    }

    public final void zza(String str, boolean z) {
        int i = 1;
        ci ciVar;
        if ("ga_autoActivityTracking".equals(str)) {
            ciVar = this.a;
            if (!z) {
                i = 0;
            }
            ciVar.d = i;
        } else if ("ga_anonymizeIp".equals(str)) {
            ciVar = this.a;
            if (!z) {
                i = 0;
            }
            ciVar.e = i;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            ciVar = this.a;
            if (!z) {
                i = 0;
            }
            ciVar.f = i;
        } else {
            d("bool configuration name not recognized", str);
        }
    }

    public final void zzb(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.a.c = i;
        } else {
            d("int configuration name not recognized", str);
        }
    }

    public final void zzb(String str, String str2) {
        this.a.g.put(str, str2);
    }

    public final void zzc(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.a.a = str2;
        } else if ("ga_sampleFrequency".equals(str)) {
            try {
                this.a.b = Double.parseDouble(str2);
            } catch (NumberFormatException e) {
                c("Error parsing ga_sampleFrequency value", str2, e);
            }
        } else {
            d("string configuration name not recognized", str);
        }
    }

    public final /* synthetic */ zzbr zzdr() {
        return this.a;
    }
}
