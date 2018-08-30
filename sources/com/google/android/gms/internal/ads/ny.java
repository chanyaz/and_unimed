package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.ads.internal.zzbo;
import java.util.concurrent.Callable;

final /* synthetic */ class ny implements Callable {
    private final Context a;
    private final op b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final ada f;
    private final zzang g;
    private final ana h;
    private final zzbo i;
    private final br j;
    private final ahx k;

    ny(Context context, op opVar, String str, boolean z, boolean z2, ada ada, zzang zzang, ana ana, zzbo zzbo, br brVar, ahx ahx) {
        this.a = context;
        this.b = opVar;
        this.c = str;
        this.d = z;
        this.e = z2;
        this.f = ada;
        this.g = zzang;
        this.h = ana;
        this.i = zzbo;
        this.j = brVar;
        this.k = ahx;
    }

    public final Object call() {
        Context context = this.a;
        op opVar = this.b;
        String str = this.c;
        boolean z = this.d;
        boolean z2 = this.e;
        zzaqw oaVar = new oa(ob.a(context, opVar, str, z, z2, this.f, this.g, this.h, this.i, this.j, this.k));
        oaVar.setWebViewClient(au.g().a(oaVar, z2));
        oaVar.setWebChromeClient(new nj(oaVar));
        return oaVar;
    }
}
