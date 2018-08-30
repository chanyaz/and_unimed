package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.dynamic.c;

final class akb extends aju<zzaap> {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ ajt b;

    akb(ajt ajt, Activity activity) {
        this.b = ajt;
        this.a = activity;
        super(ajt);
    }

    public final /* synthetic */ Object a() {
        zzaap a = this.b.h.a(this.a);
        if (a != null) {
            return a;
        }
        ajt.a(this.a, "ad_overlay");
        return null;
    }

    public final /* synthetic */ Object a(zzld zzld) {
        return zzld.createAdOverlay(c.a(this.a));
    }
}
