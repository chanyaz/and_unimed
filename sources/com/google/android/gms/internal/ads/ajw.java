package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.c;

final class ajw extends aju<zzks> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzjn b;
    private final /* synthetic */ String c;
    private final /* synthetic */ ajt d;

    ajw(ajt ajt, Context context, zzjn zzjn, String str) {
        this.d = ajt;
        this.a = context;
        this.b = zzjn;
        this.c = str;
        super(ajt);
    }

    public final /* synthetic */ Object a() {
        zzks a = this.d.c.a(this.a, this.b, this.c, null, 3);
        if (a != null) {
            return a;
        }
        ajt.a(this.a, "search");
        return new alt();
    }

    public final /* synthetic */ Object a(zzld zzld) {
        return zzld.createSearchAdManager(c.a(this.a), this.b, this.c, 12451000);
    }
}
