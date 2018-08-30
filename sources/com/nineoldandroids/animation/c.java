package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class c implements Cloneable {
    boolean a = false;
    private Interpolator b = null;

    public abstract Object a();

    public Interpolator b() {
        return this.b;
    }

    /* renamed from: c */
    public abstract c clone();
}
