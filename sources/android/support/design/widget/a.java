package android.support.design.widget;

import android.support.v4.view.a.b;
import android.support.v4.view.a.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class a {
    static final Interpolator a = new LinearInterpolator();
    static final Interpolator b = new b();
    static final Interpolator c = new android.support.v4.view.a.a();
    static final Interpolator d = new c();
    static final Interpolator e = new DecelerateInterpolator();

    a() {
    }

    static float a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
