package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.c;

final class ajy extends aju<zzkn> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzxn c;
    private final /* synthetic */ ajt d;

    ajy(ajt ajt, Context context, String str, zzxn zzxn) {
        this.d = ajt;
        this.a = context;
        this.b = str;
        this.c = zzxn;
        super(ajt);
    }

    public final /* synthetic */ Object a() {
        zzkn a = this.d.d.a(this.a, this.b, this.c);
        if (a != null) {
            return a;
        }
        ajt.a(this.a, "native_ad");
        return new alp();
    }

    public final /* synthetic */ Object a(zzld zzld) {
        return zzld.createAdLoaderBuilder(c.a(this.a), this.b, this.c, 12451000);
    }
}
