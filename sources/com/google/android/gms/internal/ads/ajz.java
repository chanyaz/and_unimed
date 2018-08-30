package com.google.android.gms.internal.ads;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.c;

final class ajz extends aju<zzqa> {
    private final /* synthetic */ FrameLayout a;
    private final /* synthetic */ FrameLayout b;
    private final /* synthetic */ Context c;
    private final /* synthetic */ ajt d;

    ajz(ajt ajt, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.d = ajt;
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = context;
        super(ajt);
    }

    public final /* synthetic */ Object a() {
        zzqa a = this.d.f.a(this.c, this.a, this.b);
        if (a != null) {
            return a;
        }
        ajt.a(this.c, "native_ad_view_delegate");
        return new alv();
    }

    public final /* synthetic */ Object a(zzld zzld) {
        return zzld.createNativeAdViewDelegate(c.a(this.a), c.a(this.b));
    }
}
