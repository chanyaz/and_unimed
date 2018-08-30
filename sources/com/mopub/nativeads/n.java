package com.mopub.nativeads;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

@VisibleForTesting
class n extends Drawable {
    @VisibleForTesting
    final int a;
    @NonNull
    private final RectF b;
    @NonNull
    private final Paint c;

    n(@NonNull Context context) {
        this(context, new RectF(), new Paint());
    }

    n(@NonNull Context context, @NonNull RectF rectF, @NonNull Paint paint) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(rectF);
        Preconditions.checkNotNull(paint);
        this.b = rectF;
        this.c = paint;
        this.c.setColor(CtaButton.BACKGROUND_COLOR);
        this.c.setAlpha(128);
        this.c.setAntiAlias(true);
        this.a = Dips.asIntPixels(5.0f, context);
    }

    public void draw(Canvas canvas) {
        this.b.set(getBounds());
        canvas.drawRoundRect(this.b, (float) this.a, (float) this.a, this.c);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
