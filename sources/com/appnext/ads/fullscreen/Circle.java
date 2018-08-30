package com.appnext.ads.fullscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.appnext.core.g;

@SuppressLint({"ViewConstructor"})
public class Circle extends View {
    private static final int ds = 180;
    private Paint dt;
    private RectF du;
    private float dv;

    public Circle(Context context) {
        super(context);
        init(context);
    }

    public Circle(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private static int a(Context context, float f) {
        return g.a(context, f);
    }

    private void init(Context context) {
        float a = (float) a(context, 5.0f);
        this.dt = new Paint();
        this.dt.setAntiAlias(true);
        this.dt.setStyle(Style.STROKE);
        this.dt.setStrokeWidth(a);
        this.dt.setColor(-1);
        this.dt.setShadowLayer(2.0f, 2.0f, 2.0f, Color.argb(128, 0, 0, 0));
        setLayerType(1, this.dt);
        this.du = new RectF(a, a, ((float) a(context, 20.0f)) + a, ((float) a(context, 20.0f)) + a);
        this.dv = 360.0f;
    }

    public float getAngle() {
        return this.dv;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.du, 180.0f, this.dv, false, this.dt);
    }

    public void setAngle(float f) {
        this.dv = f;
    }
}
