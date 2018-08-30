package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CtaButtonDrawable;

public class VastVideoCtaButtonWidget extends ImageView {
    @NonNull
    private CtaButtonDrawable a;
    @NonNull
    private final LayoutParams b;
    @NonNull
    private final LayoutParams c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h = false;

    public VastVideoCtaButtonWidget(@NonNull Context context, int i, boolean z, boolean z2) {
        super(context);
        this.f = z;
        this.g = z2;
        setId((int) Utils.generateUniqueId());
        int dipsToIntPixels = Dips.dipsToIntPixels(150.0f, context);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(38.0f, context);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(16.0f, context);
        this.a = new CtaButtonDrawable(context);
        setImageDrawable(this.a);
        this.b = new LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        this.b.setMargins(dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3);
        this.b.addRule(8, i);
        this.b.addRule(7, i);
        this.c = new LayoutParams(dipsToIntPixels, dipsToIntPixels2);
        this.c.setMargins(dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3, dipsToIntPixels3);
        this.c.addRule(12);
        this.c.addRule(11);
        c();
    }

    private void c() {
        if (!this.g) {
            setVisibility(8);
        } else if (!this.d) {
            setVisibility(4);
        } else if (this.e && this.f && !this.h) {
            setVisibility(8);
        } else {
            switch (getResources().getConfiguration().orientation) {
                case 0:
                    MoPubLog.d("Screen orientation undefined: CTA button widget defaulting to portrait layout");
                    setLayoutParams(this.c);
                    break;
                case 1:
                    setLayoutParams(this.c);
                    break;
                case 2:
                    setLayoutParams(this.b);
                    break;
                case 3:
                    MoPubLog.d("Screen orientation is deprecated ORIENTATION_SQUARE: CTA button widget defaulting to portrait layout");
                    setLayoutParams(this.c);
                    break;
                default:
                    MoPubLog.d("Unrecognized screen orientation: CTA button widget defaulting to portrait layout");
                    setLayoutParams(this.c);
                    break;
            }
            setVisibility(0);
        }
    }

    void a() {
        this.d = true;
        c();
    }

    void a(@NonNull String str) {
        this.a.setCtaText(str);
    }

    void b() {
        this.d = true;
        this.e = true;
        c();
    }

    @Deprecated
    @VisibleForTesting
    String getCtaText() {
        return this.a.getCtaText();
    }

    boolean getHasSocialActions() {
        return this.h;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    void setHasSocialActions(boolean z) {
        this.h = z;
    }
}
