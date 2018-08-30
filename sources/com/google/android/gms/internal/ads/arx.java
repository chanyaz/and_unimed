package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.l;

final class arx {
    l a;
    @Nullable
    zzjj b;
    aqs c;
    long d;
    boolean e;
    boolean f;
    private final /* synthetic */ arw g;

    arx(arw arw, aqr aqr) {
        this.g = arw;
        this.a = aqr.b(arw.c);
        this.c = new aqs();
        aqs aqs = this.c;
        a aVar = this.a;
        aVar.zza(new aqt(aqs));
        aVar.zza(new arb(aqs));
        aVar.zza(new ard(aqs));
        aVar.zza(new arf(aqs));
        aVar.zza(new arh(aqs));
    }

    arx(arw arw, aqr aqr, zzjj zzjj) {
        this(arw, aqr);
        this.b = zzjj;
    }

    final boolean a() {
        if (this.e) {
            return false;
        }
        this.f = this.a.zzb(aru.b(this.b != null ? this.b : this.g.b));
        this.e = true;
        this.d = au.l().currentTimeMillis();
        return true;
    }
}
