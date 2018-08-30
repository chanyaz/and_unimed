package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants.ProgressBar;

public class ProgressBarDrawable extends BaseWidgetDrawable {
    @NonNull
    private final Paint a = new Paint();
    @NonNull
    private final Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private final int h;

    public ProgressBarDrawable(@NonNull Context context) {
        this.a.setColor(-1);
        this.a.setAlpha(128);
        this.a.setStyle(ProgressBar.BACKGROUND_STYLE);
        this.a.setAntiAlias(true);
        this.b = new Paint();
        this.b.setColor(ProgressBar.PROGRESS_COLOR);
        this.b.setAlpha(255);
        this.b.setStyle(ProgressBar.PROGRESS_STYLE);
        this.b.setAntiAlias(true);
        this.h = Dips.dipsToIntPixels(4.0f, context);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.a);
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) getBounds().left, (float) getBounds().top, ((float) getBounds().right) * (((float) this.e) / ((float) this.c)), (float) getBounds().bottom, this.b);
        if (this.d > 0 && this.d < this.c) {
            float f = this.g * ((float) getBounds().right);
            canvas.drawRect(f, (float) getBounds().top, f + ((float) this.h), (float) getBounds().bottom, this.b);
        }
    }

    @VisibleForTesting
    public void forceCompletion() {
        this.e = this.c;
    }

    @Deprecated
    @VisibleForTesting
    public int getCurrentProgress() {
        return this.e;
    }

    @Deprecated
    @VisibleForTesting
    public float getSkipRatio() {
        return this.g;
    }

    public void reset() {
        this.f = 0;
    }

    public void setDurationAndSkipOffset(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.g = ((float) this.d) / ((float) this.c);
    }

    public void setProgress(int i) {
        if (i >= this.f) {
            this.e = i;
            this.f = i;
        } else if (i != 0) {
            MoPubLog.d(String.format("Progress not monotonically increasing: last = %d, current = %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(i)}));
            forceCompletion();
        }
        invalidateSelf();
    }
}
