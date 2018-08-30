package uk.co.senab.photoview;

import android.view.View;

class b implements Runnable {
    final /* synthetic */ PhotoViewAttacher a;
    private final float b;
    private final float c;
    private final long d = System.currentTimeMillis();
    private final float e;
    private final float f;

    public b(PhotoViewAttacher photoViewAttacher, float f, float f2, float f3, float f4) {
        this.a = photoViewAttacher;
        this.b = f3;
        this.c = f4;
        this.e = f;
        this.f = f2;
    }

    private float a() {
        return PhotoViewAttacher.a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.d)) * 1.0f) / 200.0f));
    }

    public void run() {
        View b = this.a.b();
        if (b != null) {
            float a = a();
            float scale = (this.e + ((this.f - this.e) * a)) / this.a.getScale();
            this.a.l.postScale(scale, scale, this.b, this.c);
            this.a.g();
            if (a < 1.0f) {
                a.a(b, this);
            }
        }
    }
}
