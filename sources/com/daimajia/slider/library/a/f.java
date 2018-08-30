package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class f extends c {
    protected void a(View view, float f) {
        if (f <= 0.0f) {
            a.i(view, 0.0f);
            a.g(view, 1.0f);
            a.h(view, 1.0f);
        } else if (f <= 1.0f) {
            float abs = 0.75f + (0.25f * (1.0f - Math.abs(f)));
            a.a(view, 1.0f - f);
            a.c(view, 0.5f * ((float) view.getHeight()));
            a.i(view, ((float) view.getWidth()) * (-f));
            a.g(view, abs);
            a.h(view, abs);
        }
    }

    protected boolean b() {
        return true;
    }
}
