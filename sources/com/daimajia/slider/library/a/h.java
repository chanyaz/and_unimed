package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class h extends c {
    protected void a(View view, float f) {
        float f2 = 180.0f * f;
        float f3 = (f2 > 90.0f || f2 < -90.0f) ? 0.0f : 1.0f;
        a.a(view, f3);
        a.c(view, ((float) view.getHeight()) * 0.5f);
        a.b(view, ((float) view.getWidth()) * 0.5f);
        a.f(view, f2);
    }
}
