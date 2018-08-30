package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class k extends c {
    protected void a(View view, float f) {
        float height = (float) view.getHeight();
        float f2 = (-15.0f * f) * -1.25f;
        a.b(view, ((float) view.getWidth()) * 0.5f);
        a.c(view, height);
        a.d(view, f2);
    }

    protected boolean b() {
        return true;
    }
}
