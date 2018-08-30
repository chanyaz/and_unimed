package com.daimajia.slider.library.a;

import android.view.View;

public class a extends c {
    protected void a(View view, float f) {
        com.nineoldandroids.a.a.b(view, f < 0.0f ? 0.0f : (float) view.getWidth());
        com.nineoldandroids.a.a.g(view, f < 0.0f ? 1.0f + f : 1.0f - f);
    }
}
