package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class an {
    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;

    public an(View view) {
        this.a = view;
    }

    private void d() {
        ViewCompat.d(this.a, this.d - (this.a.getTop() - this.b));
        ViewCompat.e(this.a, this.e - (this.a.getLeft() - this.c));
    }

    public void a() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
        d();
    }

    public boolean a(int i) {
        if (this.d == i) {
            return false;
        }
        this.d = i;
        d();
        return true;
    }

    public int b() {
        return this.d;
    }

    public boolean b(int i) {
        if (this.e == i) {
            return false;
        }
        this.e = i;
        d();
        return true;
    }

    public int c() {
        return this.b;
    }
}
