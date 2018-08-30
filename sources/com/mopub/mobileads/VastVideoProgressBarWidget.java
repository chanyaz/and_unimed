package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.ProgressBarDrawable;

public class VastVideoProgressBarWidget extends ImageView {
    @NonNull
    private ProgressBarDrawable a;
    private final int b;

    public VastVideoProgressBarWidget(@NonNull Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        this.a = new ProgressBarDrawable(context);
        setImageDrawable(this.a);
        this.b = Dips.dipsToIntPixels(4.0f, context);
    }

    public void calibrateAndMakeVisible(int i, int i2) {
        this.a.setDurationAndSkipOffset(i, i2);
        setVisibility(0);
    }

    @Deprecated
    @VisibleForTesting
    ProgressBarDrawable getImageViewDrawable() {
        return this.a;
    }

    public void reset() {
        this.a.reset();
        this.a.setProgress(0);
    }

    public void setAnchorId(int i) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.b);
        layoutParams.addRule(8, i);
        setLayoutParams(layoutParams);
    }

    @Deprecated
    @VisibleForTesting
    void setImageViewDrawable(@NonNull ProgressBarDrawable progressBarDrawable) {
        this.a = progressBarDrawable;
    }

    public void updateProgress(int i) {
        this.a.setProgress(i);
    }
}
