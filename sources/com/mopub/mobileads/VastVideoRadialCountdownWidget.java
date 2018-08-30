package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.RadialCountdownDrawable;

public class VastVideoRadialCountdownWidget extends ImageView {
    @NonNull
    private RadialCountdownDrawable a;
    private int b;

    public VastVideoRadialCountdownWidget(@NonNull Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        int dipsToIntPixels = Dips.dipsToIntPixels(45.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(16.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(16.0f, context);
        int dipsToIntPixels4 = Dips.dipsToIntPixels(5.0f, context);
        this.a = new RadialCountdownDrawable(context);
        setImageDrawable(this.a);
        setPadding(dipsToIntPixels4, dipsToIntPixels4, dipsToIntPixels4, dipsToIntPixels4);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.setMargins(0, dipsToIntPixels2, dipsToIntPixels3, 0);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    void a(int i) {
        this.a.setInitialCountdown(i);
        setVisibility(0);
    }

    void a(int i, int i2) {
        if (i2 < this.b) {
            return;
        }
        if (i - i2 < 0) {
            setVisibility(8);
            return;
        }
        this.a.updateCountdownProgress(i2);
        this.b = i2;
    }

    @Deprecated
    @VisibleForTesting
    RadialCountdownDrawable getImageViewDrawable() {
        return this.a;
    }

    @Deprecated
    @VisibleForTesting
    void setImageViewDrawable(RadialCountdownDrawable radialCountdownDrawable) {
        this.a = radialCountdownDrawable;
    }
}
