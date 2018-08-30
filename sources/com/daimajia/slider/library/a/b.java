package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class b extends c {
    private static final float a(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    protected void a(View view, float f) {
        float f2 = 1.0f;
        float height = (float) view.getHeight();
        float width = (float) view.getWidth();
        if (f >= 0.0f) {
            f2 = Math.abs(1.0f - f);
        }
        f2 = a(f2, 0.5f);
        a.g(view, f2);
        a.h(view, f2);
        a.b(view, width * 0.5f);
        a.c(view, height * 0.5f);
        a.i(view, f < 0.0f ? width * f : ((-width) * f) * 0.25f);
    }
}
