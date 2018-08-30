package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class p extends c {
    protected void a(View view, float f) {
        if (f >= -1.0f || f <= 1.0f) {
            float height = (float) view.getHeight();
            float max = Math.max(0.85f, 1.0f - Math.abs(f));
            float f2 = ((1.0f - max) * height) / 2.0f;
            float width = (((float) view.getWidth()) * (1.0f - max)) / 2.0f;
            a.c(view, height * 0.5f);
            if (f < 0.0f) {
                a.i(view, width - (f2 / 2.0f));
            } else {
                a.i(view, (-width) + (f2 / 2.0f));
            }
            a.g(view, max);
            a.h(view, max);
            a.a(view, (((max - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
        }
    }
}
