package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.c;
import com.mopub.common.AdType;

final class ajx extends aju<zzks> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzjn b;
    private final /* synthetic */ String c;
    private final /* synthetic */ zzxn d;
    private final /* synthetic */ ajt e;

    ajx(ajt ajt, Context context, zzjn zzjn, String str, zzxn zzxn) {
        this.e = ajt;
        this.a = context;
        this.b = zzjn;
        this.c = str;
        this.d = zzxn;
        super(ajt);
    }

    public final /* synthetic */ Object a() {
        zzks a = this.e.c.a(this.a, this.b, this.c, this.d, 2);
        if (a != null) {
            return a;
        }
        ajt.a(this.a, AdType.INTERSTITIAL);
        return new alt();
    }

    public final /* synthetic */ Object a(zzld zzld) {
        return zzld.createInterstitialAdManager(c.a(this.a), this.b, this.c, this.d, 12451000);
    }
}
