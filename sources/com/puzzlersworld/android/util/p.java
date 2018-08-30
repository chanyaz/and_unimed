package com.puzzlersworld.android.util;

class p implements Runnable {
    n a;
    int b;
    int c;
    final /* synthetic */ TouchImageView d;

    p(TouchImageView touchImageView, int i, int i2) {
        int i3;
        int i4;
        int k;
        int i5;
        this.d = touchImageView;
        touchImageView.setState(t.FLING);
        this.a = new n(touchImageView, touchImageView.j);
        touchImageView.b.getValues(touchImageView.i);
        int i6 = (int) touchImageView.i[2];
        int i7 = (int) touchImageView.i[5];
        if (touchImageView.getImageWidth() > ((float) touchImageView.p)) {
            i3 = touchImageView.p - ((int) touchImageView.getImageWidth());
            i4 = 0;
        } else {
            i4 = i6;
            i3 = i6;
        }
        if (touchImageView.getImageHeight() > ((float) touchImageView.q)) {
            k = touchImageView.q - ((int) touchImageView.getImageHeight());
            i5 = 0;
        } else {
            i5 = i7;
            k = i7;
        }
        this.a.a(i6, i7, i, i2, i3, i4, k, i5);
        this.b = i6;
        this.c = i7;
    }

    public void a() {
        if (this.a != null) {
            this.d.setState(t.NONE);
            this.a.a(true);
        }
    }

    public void run() {
        if (this.d.B != null) {
            this.d.B.onMove();
        }
        if (this.a.a()) {
            this.a = null;
        } else if (this.a.b()) {
            int c = this.a.c();
            int d = this.a.d();
            int i = c - this.b;
            int i2 = d - this.c;
            this.b = c;
            this.c = d;
            this.d.b.postTranslate((float) i, (float) i2);
            this.d.d();
            this.d.setImageMatrix(this.d.b);
            this.d.a((Runnable) this);
        }
    }
}
