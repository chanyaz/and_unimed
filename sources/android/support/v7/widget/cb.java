package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;

public class cb {
    private int a;
    private int b;
    private int c;
    private int d;
    private Interpolator e;
    private boolean f;
    private int g;

    public cb(int i, int i2) {
        this(i, i2, Integer.MIN_VALUE, null);
    }

    public cb(int i, int i2, int i3, Interpolator interpolator) {
        this.d = -1;
        this.f = false;
        this.g = 0;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.e = interpolator;
    }

    private void b() {
        if (this.e != null && this.c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (this.c < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(int i, int i2, int i3, Interpolator interpolator) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.e = interpolator;
        this.f = true;
    }

    void a(RecyclerView recyclerView) {
        if (this.d >= 0) {
            int i = this.d;
            this.d = -1;
            recyclerView.b(i);
            this.f = false;
        } else if (this.f) {
            b();
            if (this.e != null) {
                recyclerView.z.a(this.a, this.b, this.c, this.e);
            } else if (this.c == Integer.MIN_VALUE) {
                recyclerView.z.b(this.a, this.b);
            } else {
                recyclerView.z.a(this.a, this.b, this.c);
            }
            this.g++;
            if (this.g > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f = false;
        } else {
            this.g = 0;
        }
    }

    boolean a() {
        return this.d >= 0;
    }
}
