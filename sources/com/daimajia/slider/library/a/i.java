package com.daimajia.slider.library.a;

import android.os.Build.VERSION;
import android.view.View;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.nineoldandroids.a.a;

public class i extends c {
    private void a(View view) {
        a.i(view, (float) (((ViewPagerEx) view.getParent()).getScrollX() - view.getLeft()));
    }

    private void a(View view, float f, float f2) {
        float f3 = (f == 0.0f || f == 1.0f) ? 1.0f : f2;
        a.g(view, f3);
        if (f == 0.0f || f == 1.0f) {
            f2 = 1.0f;
        }
        a.h(view, f2);
    }

    private void b(View view, float f, float f2) {
        if (f > 0.0f) {
            a.f(view, -180.0f * (1.0f + f2));
        } else {
            a.f(view, 180.0f * (1.0f + f2));
        }
    }

    private void d(View view, float f) {
        if (((double) f) >= 0.5d || ((double) f) <= -0.5d) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
    }

    protected void a(View view, float f) {
        float abs = 1.0f - Math.abs(f);
        if (VERSION.SDK_INT >= 13) {
            view.setCameraDistance(12000.0f);
        }
        d(view, f);
        a(view);
        a(view, f, abs);
        b(view, f, abs);
    }
}
