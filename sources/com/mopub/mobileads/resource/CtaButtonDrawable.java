package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class CtaButtonDrawable extends BaseWidgetDrawable {
    @NonNull
    private final Paint a = new Paint();
    @NonNull
    private final Paint b;
    @NonNull
    private final Paint c;
    @NonNull
    private final RectF d;
    @NonNull
    private final Rect e;
    private final int f;
    private String g;

    public CtaButtonDrawable(@NonNull Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(2.0f, context);
        float dipsToFloatPixels = Dips.dipsToFloatPixels(15.0f, context);
        this.a.setColor(CtaButton.BACKGROUND_COLOR);
        this.a.setAlpha(51);
        this.a.setStyle(CtaButton.BACKGROUND_STYLE);
        this.a.setAntiAlias(true);
        this.b = new Paint();
        this.b.setColor(-1);
        this.b.setAlpha(51);
        this.b.setStyle(CtaButton.OUTLINE_STYLE);
        this.b.setStrokeWidth((float) dipsToIntPixels);
        this.b.setAntiAlias(true);
        this.c = new Paint();
        this.c.setColor(-1);
        this.c.setTextAlign(CtaButton.TEXT_ALIGN);
        this.c.setTypeface(CtaButton.TEXT_TYPEFACE);
        this.c.setTextSize(dipsToFloatPixels);
        this.c.setAntiAlias(true);
        this.e = new Rect();
        this.g = CtaButton.DEFAULT_CTA_TEXT;
        this.d = new RectF();
        this.f = Dips.dipsToIntPixels(6.0f, context);
    }

    public void draw(Canvas canvas) {
        this.d.set(getBounds());
        canvas.drawRoundRect(this.d, (float) this.f, (float) this.f, this.a);
        canvas.drawRoundRect(this.d, (float) this.f, (float) this.f, this.b);
        a(canvas, this.c, this.e, this.g);
    }

    @Deprecated
    @VisibleForTesting
    public String getCtaText() {
        return this.g;
    }

    public void setCtaText(@NonNull String str) {
        this.g = str;
        invalidateSelf();
    }
}
