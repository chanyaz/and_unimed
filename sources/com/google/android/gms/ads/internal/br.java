package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.aib;
import com.google.android.gms.internal.ads.gd;
import com.google.android.gms.internal.ads.ge;
import com.google.android.gms.internal.ads.mf;
import com.google.android.gms.internal.ads.mm;
import com.google.android.gms.internal.ads.mx;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzaqm;

@zzadh
public final class br {
    public final zzaqm a;
    public final mf b;
    public final zzaiu c;
    public final aib d;

    private br(zzaqm zzaqm, mf mfVar, zzaiu zzaiu, aib aib) {
        this.a = zzaqm;
        this.b = mfVar;
        this.c = zzaiu;
        this.d = aib;
    }

    public static br a(Context context) {
        return new br(new mx(), new mm(), new gd(new ge()), new aib(context));
    }
}
