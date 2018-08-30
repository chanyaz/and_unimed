package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class o extends c {
    protected void a(View view, float f) {
        float abs = f < 0.0f ? f + 1.0f : Math.abs(1.0f - f);
        a.g(view, abs);
        a.h(view, abs);
        a.b(view, ((float) view.getWidth()) * 0.5f);
        a.c(view, ((float) view.getHeight()) * 0.5f);
        abs = (f < -1.0f || f > 1.0f) ? 0.0f : 1.0f - (abs - 1.0f);
        a.a(view, abs);
    }
}
