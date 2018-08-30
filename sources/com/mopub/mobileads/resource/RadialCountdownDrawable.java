package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Numbers;
import com.mopub.mobileads.resource.DrawableConstants.RadialCountdown;

public class RadialCountdownDrawable extends BaseWidgetDrawable {
    @NonNull
    private final Paint a = new Paint();
    @NonNull
    private final Paint b;
    @NonNull
    private final Paint c;
    @NonNull
    private Rect d;
    private int e;
    private int f;
    private float g;

    public RadialCountdownDrawable(@NonNull Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, context);
        float dipsToFloatPixels = Dips.dipsToFloatPixels(18.0f, context);
        this.a.setColor(-1);
        this.a.setAlpha(128);
        this.a.setStyle(RadialCountdown.BACKGROUND_STYLE);
        this.a.setStrokeWidth((float) dipsToIntPixels);
        this.a.setAntiAlias(true);
        this.b = new Paint();
        this.b.setColor(-1);
        this.b.setAlpha(255);
        this.b.setStyle(RadialCountdown.PROGRESS_STYLE);
        this.b.setStrokeWidth((float) dipsToIntPixels);
        this.b.setAntiAlias(true);
        this.c = new Paint();
        this.c.setColor(-1);
        this.c.setTextAlign(RadialCountdown.TEXT_ALIGN);
        this.c.setTextSize(dipsToFloatPixels);
        this.c.setAntiAlias(true);
        this.d = new Rect();
    }

    public void draw(Canvas canvas) {
        int centerX = getBounds().centerX();
        int centerY = getBounds().centerY();
        canvas.drawCircle((float) centerX, (float) centerY, (float) Math.min(centerX, centerY), this.a);
        a(canvas, this.c, this.d, String.valueOf(this.f));
        canvas.drawArc(new RectF(getBounds()), -90.0f, this.g, false, this.b);
    }

    @Deprecated
    @VisibleForTesting
    public int getInitialCountdownMilliseconds() {
        return this.e;
    }

    public void setInitialCountdown(int i) {
        this.e = i;
    }

    public void updateCountdownProgress(int i) {
        this.f = (int) Numbers.convertMillisecondsToSecondsRoundedUp((long) (this.e - i));
        this.g = (360.0f * ((float) i)) / ((float) this.e);
        invalidateSelf();
    }
}
