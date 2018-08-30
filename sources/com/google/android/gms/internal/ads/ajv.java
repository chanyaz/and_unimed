package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.c;

final class ajv extends aju<zzks> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzjn b;
    private final /* synthetic */ String c;
    private final /* synthetic */ zzxn d;
    private final /* synthetic */ ajt e;

    ajv(ajt ajt, Context context, zzjn zzjn, String str, zzxn zzxn) {
        this.e = ajt;
        this.a = context;
        this.b = zzjn;
        this.c = str;
        this.d = zzxn;
        super(ajt);
    }

    public final /* synthetic */ Object a() {
        zzks a = this.e.c.a(this.a, this.b, this.c, this.d, 1);
        if (a != null) {
            return a;
        }
        ajt.a(this.a, "banner");
        return new alt();
    }

    public final /* synthetic */ Object a(zzld zzld) {
        return zzld.createBannerAdManager(c.a(this.a), this.b, this.c, this.d, 12451000);
    }
}
