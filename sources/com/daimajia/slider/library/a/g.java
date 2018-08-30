package com.daimajia.slider.library.a;

import android.view.View;
import com.nineoldandroids.a.a;

public class g extends c {
    protected void a(View view, float f) {
        if (f < -1.0f || f > 1.0f) {
            a.a(view, 0.6f);
        } else if (f <= 0.0f || f <= 1.0f) {
            a.a(view, f <= 0.0f ? f + 1.0f : 1.0f - f);
        } else if (f == 0.0f) {
            a.a(view, 1.0f);
        }
    }
}
