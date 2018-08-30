package com.daimajia.slider.library.Tricks;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class a extends Scroller {
    private int a;

    public a(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.a = 1000;
    }

    public a(Context context, Interpolator interpolator, int i) {
        this(context, interpolator);
        this.a = i;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.a);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.a);
    }
}
