package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ar;

public final class AdView extends BaseAdView {
    public AdView(Context context) {
        super(context, 0);
        ar.a((Object) context, (Object) "Context cannot be null");
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
    }

    public final k getVideoController() {
        return this.a != null ? this.a.k() : null;
    }
}
