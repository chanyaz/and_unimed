package com.daimajia.slider.library.a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import com.nineoldandroids.a.a;

public class n extends c {
    private static final Matrix c = new Matrix();
    private static final Camera d = new Camera();
    private static final float[] e = new float[2];

    protected static final float a(float f, int i, int i2) {
        c.reset();
        d.save();
        d.rotateY(Math.abs(f));
        d.getMatrix(c);
        d.restore();
        c.preTranslate(((float) (-i)) * 0.5f, ((float) (-i2)) * 0.5f);
        c.postTranslate(((float) i) * 0.5f, ((float) i2) * 0.5f);
        e[0] = (float) i;
        e[1] = (float) i2;
        c.mapPoints(e);
        return (f > 0.0f ? 1.0f : -1.0f) * (((float) i) - e[0]);
    }

    protected void a(View view, float f) {
        float abs = (f < 0.0f ? 30.0f : -30.0f) * Math.abs(f);
        a.i(view, a(abs, view.getWidth(), view.getHeight()));
        a.b(view, ((float) view.getWidth()) * 0.5f);
        a.c(view, 0.0f);
        a.f(view, abs);
    }
}
