package com.puzzlersworld.android.util;

import android.graphics.PointF;
import android.view.animation.AccelerateDecelerateInterpolator;

class o implements Runnable {
    final /* synthetic */ TouchImageView a;
    private long b;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private AccelerateDecelerateInterpolator h = new AccelerateDecelerateInterpolator();
    private PointF i;
    private PointF j;

    o(TouchImageView touchImageView, float f, float f2, float f3, boolean z) {
        this.a = touchImageView;
        touchImageView.setState(t.ANIMATE_ZOOM);
        this.b = System.currentTimeMillis();
        this.c = touchImageView.a;
        this.d = f;
        this.g = z;
        PointF a = touchImageView.a(f2, f3, false);
        this.e = a.x;
        this.f = a.y;
        this.i = touchImageView.a(this.e, this.f);
        this.j = new PointF((float) (touchImageView.p / 2), (float) (touchImageView.q / 2));
    }

    private float a() {
        return this.h.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.b)) / 500.0f));
    }

    private void a(float f) {
        float f2 = this.i.x + ((this.j.x - this.i.x) * f);
        float f3 = this.i.y + ((this.j.y - this.i.y) * f);
        PointF a = this.a.a(this.e, this.f);
        this.a.b.postTranslate(f2 - a.x, f3 - a.y);
    }

    private double b(float f) {
        return ((double) (this.c + ((this.d - this.c) * f))) / ((double) this.a.a);
    }

    public void run() {
        float a = a();
        this.a.a(b(a), this.e, this.f, this.g);
        a(a);
        this.a.e();
        this.a.setImageMatrix(this.a.b);
        if (this.a.B != null) {
            this.a.B.onMove();
        }
        if (a < 1.0f) {
            this.a.a((Runnable) this);
        } else {
            this.a.setState(t.NONE);
        }
    }
}
