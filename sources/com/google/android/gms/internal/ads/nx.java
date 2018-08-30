package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.br;

final /* synthetic */ class nx implements zzanj {
    private final Context a;
    private final ada b;
    private final zzang c;
    private final br d;
    private final String e;

    nx(Context context, ada ada, zzang zzang, br brVar, String str) {
        this.a = context;
        this.b = ada;
        this.c = zzang;
        this.d = brVar;
        this.e = str;
    }

    public final zzanz zzc(Object obj) {
        Context context = this.a;
        ada ada = this.b;
        zzang zzang = this.c;
        br brVar = this.d;
        String str = this.e;
        au.f();
        zzaqw a = nw.a(context, op.a(), "", false, false, ada, zzang, null, null, brVar, ahx.a());
        zzanz a2 = lj.a(a);
        a.zzuf().zza(new nz(a2));
        a.loadUrl(str);
        return a2;
    }
}
