package com.google.android.gms.internal.ads;

final class jf implements zzy {
    private final /* synthetic */ String a;
    private final /* synthetic */ ji b;

    jf(jb jbVar, String str, ji jiVar) {
        this.a = str;
        this.b = jiVar;
    }

    public final void zzd(zzae zzae) {
        String str = this.a;
        String zzae2 = zzae.toString();
        kk.e(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(zzae2).length()).append("Failed to load URL: ").append(str).append("\n").append(zzae2).toString());
        this.b.zzb(null);
    }
}
