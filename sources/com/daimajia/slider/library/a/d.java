package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class d extends c {
    protected void a(View view, float f) {
        a.b(view, f > 0.0f ? 0.0f : (float) view.getWidth());
        a.c(view, 0.0f);
        a.d(view, -90.0f * f);
    }

    public boolean b() {
        return true;
    }
}
