package android.support.transition;

import android.graphics.PointF;
import android.view.View;

class c {
    private int a;
    private int b;
    private int c;
    private int d;
    private View e;
    private int f;
    private int g;

    c(View view) {
        this.e = view;
    }

    private void a() {
        bb.a(this.e, this.a, this.b, this.c, this.d);
        this.f = 0;
        this.g = 0;
    }

    void a(PointF pointF) {
        this.a = Math.round(pointF.x);
        this.b = Math.round(pointF.y);
        this.f++;
        if (this.f == this.g) {
            a();
        }
    }

    void b(PointF pointF) {
        this.c = Math.round(pointF.x);
        this.d = Math.round(pointF.y);
        this.g++;
        if (this.f == this.g) {
            a();
        }
    }
}
