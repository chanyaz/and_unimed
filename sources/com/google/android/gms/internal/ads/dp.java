package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;

@zzadh
public final class dp {
    public final zzafy a = null;
    public final zzhn b;
    public final zzajc c;
    public final zzmz d;
    public final ej e;
    public final zzwu f;
    public final zzagi g;
    public final zzagj h;
    public final zzaav i;
    public final zzajg j;
    public final boolean k;
    public final zzafr l;

    private dp(zzafy zzafy, zzhn zzhn, zzajc zzajc, zzmz zzmz, ej ejVar, zzwu zzwu, zzagi zzagi, zzagj zzagj, zzaav zzaav, zzajg zzajg, boolean z, zzafr zzafr) {
        this.b = zzhn;
        this.c = zzajc;
        this.d = zzmz;
        this.e = ejVar;
        this.f = zzwu;
        this.g = zzagi;
        this.h = zzagj;
        this.i = zzaav;
        this.j = zzajg;
        this.k = true;
        this.l = zzafr;
    }

    public static dp a(Context context) {
        au.C().a(context);
        zzafr enVar = new en(context);
        return new dp(null, new ahv(), new go(), new amb(), new eh(context, enVar.zzog()), new aug(), new el(), new em(), new r(), new gp(), true, enVar);
    }
}
