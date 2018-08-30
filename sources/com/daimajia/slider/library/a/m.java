package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class m extends c {
    protected void a(View view, float f) {
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = ((float) (-view.getWidth())) * f;
        }
        a.i(view, f2);
    }
}
