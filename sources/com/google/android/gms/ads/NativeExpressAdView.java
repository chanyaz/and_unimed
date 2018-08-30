package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
public final class NativeExpressAdView extends BaseAdView {
    public NativeExpressAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 1);
    }

    public final k getVideoController() {
        return this.a.k();
    }

    public final m getVideoOptions() {
        return this.a.m();
    }

    public final void setVideoOptions(m mVar) {
        this.a.a(mVar);
    }
}
