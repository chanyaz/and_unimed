package android.support.v4.widget;

import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;

class q extends at {
    final /* synthetic */ DrawerLayout a;
    private final int b;
    private as c;
    private final Runnable d = new Runnable() {
        public void run() {
            q.this.b();
        }
    };

    q(DrawerLayout drawerLayout, int i) {
        this.a = drawerLayout;
        this.b = i;
    }

    private void c() {
        int i = 3;
        if (this.b == 3) {
            i = 5;
        }
        View c = this.a.c(i);
        if (c != null) {
            this.a.i(c);
        }
    }

    public int a(View view, int i, int i2) {
        return view.getTop();
    }

    public void a() {
        this.a.removeCallbacks(this.d);
    }

    public void a(int i) {
        this.a.a(this.b, i, this.c.c());
    }

    public void a(int i, int i2) {
        this.a.postDelayed(this.d, 160);
    }

    public void a(as asVar) {
        this.c = asVar;
    }

    public void a(View view, float f, float f2) {
        int i;
        float d = this.a.d(view);
        int width = view.getWidth();
        if (this.a.a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                i -= width;
            }
        }
        this.c.a(i, view.getTop());
        this.a.invalidate();
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        int width = view.getWidth();
        float width2 = this.a.a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (this.a.getWidth() - i)) / ((float) width);
        this.a.b(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        this.a.invalidate();
    }

    public boolean a(View view, int i) {
        return this.a.g(view) && this.a.a(view, this.b) && this.a.a(view) == 0;
    }

    public int b(View view) {
        return this.a.g(view) ? view.getWidth() : 0;
    }

    public int b(View view, int i, int i2) {
        if (this.a.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    void b() {
        View view;
        int i;
        int i2 = 0;
        int b = this.c.b();
        boolean z = this.b == 3;
        if (z) {
            View c = this.a.c(3);
            if (c != null) {
                i2 = -c.getWidth();
            }
            i2 += b;
            view = c;
            i = i2;
        } else {
            i2 = this.a.getWidth() - b;
            view = this.a.c(5);
            i = i2;
        }
        if (view == null) {
            return;
        }
        if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.a.a(view) == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.c.a(view, i, view.getTop());
            layoutParams.c = true;
            this.a.invalidate();
            c();
            this.a.d();
        }
    }

    public void b(int i, int i2) {
        View c = (i & 1) == 1 ? this.a.c(3) : this.a.c(5);
        if (c != null && this.a.a(c) == 0) {
            this.c.a(c, i2);
        }
    }

    public void b(View view, int i) {
        ((LayoutParams) view.getLayoutParams()).c = false;
        c();
    }

    public boolean b(int i) {
        return false;
    }
}
