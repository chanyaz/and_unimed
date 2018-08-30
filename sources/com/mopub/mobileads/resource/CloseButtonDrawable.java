package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.mopub.mobileads.resource.DrawableConstants.CloseButton;

public class CloseButtonDrawable extends BaseWidgetDrawable {
    private final Paint a;
    private final float b;

    public CloseButtonDrawable() {
        this(8.0f);
    }

    public CloseButtonDrawable(float f) {
        this.b = f / 2.0f;
        this.a = new Paint();
        this.a.setColor(-1);
        this.a.setStrokeWidth(f);
        this.a.setStrokeCap(CloseButton.STROKE_CAP);
    }

    public void draw(Canvas canvas) {
        int width = getBounds().width();
        int height = getBounds().height();
        canvas.drawLine(0.0f + this.b, ((float) height) - this.b, ((float) width) - this.b, 0.0f + this.b, this.a);
        canvas.drawLine(0.0f + this.b, 0.0f + this.b, ((float) width) - this.b, ((float) height) - this.b, this.a);
    }
}
