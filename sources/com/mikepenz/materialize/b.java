package com.mikepenz.materialize;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.content.a;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.mikepenz.materialize.view.IScrimInsetsLayout;
import com.mikepenz.materialize.view.ScrimInsetsFrameLayout;

public class b {
    protected Activity a;
    protected ViewGroup b;
    protected ViewGroup c;
    protected IScrimInsetsLayout d;
    protected boolean e = true;
    protected int f = 0;
    protected int g = -1;
    protected boolean h = false;
    protected boolean i = false;
    protected boolean j = false;
    protected boolean k = true;
    protected boolean l = false;
    protected boolean m = false;
    protected boolean n = false;
    protected boolean o = false;
    protected boolean p = false;
    protected boolean q = false;
    protected ViewGroup r = null;
    protected LayoutParams s = null;

    public a a() {
        if (this.a == null) {
            throw new RuntimeException("please pass an activity");
        }
        if (this.e) {
            this.d = (ScrimInsetsFrameLayout) this.a.getLayoutInflater().inflate(h.materialize, this.b, false);
            if (this.b == null || this.b.getChildCount() == 0) {
                throw new RuntimeException("You have to set your layout for this activity with setContentView() first. Or you build the drawer on your own with .buildView()");
            }
            View childAt = this.b.getChildAt(0);
            boolean z = childAt.getId() == g.materialize_root;
            if (this.f == 0 && this.g != -1) {
                this.f = a.c(this.a, this.g);
            } else if (this.f == 0) {
                this.f = com.mikepenz.materialize.c.b.a(this.a, d.colorPrimaryDark, e.materialize_primary_dark);
            }
            this.d.setInsetForeground(this.f);
            this.d.setTintStatusBar(this.k);
            this.d.setTintNavigationBar(this.o);
            IScrimInsetsLayout iScrimInsetsLayout = this.d;
            boolean z2 = (this.p || this.q) ? false : true;
            iScrimInsetsLayout.setSystemUIVisible(z2);
            if (z) {
                this.b.removeAllViews();
            } else {
                this.b.removeView(childAt);
            }
            this.d.getView().addView(childAt, new FrameLayout.LayoutParams(-1, -1));
            this.c = this.d.getView();
            if (this.r != null) {
                this.c = this.r;
                this.c.addView(this.d.getView(), new LayoutParams(-1, -1));
            }
            this.c.setId(g.materialize_root);
            if (this.s == null) {
                this.s = new LayoutParams(-1, -1);
            }
            this.b.addView(this.c, this.s);
        } else if (this.r == null) {
            throw new RuntimeException("please pass a container");
        } else {
            View childAt2 = this.b.getChildAt(0);
            this.b.removeView(childAt2);
            this.r.addView(childAt2, new FrameLayout.LayoutParams(-1, -1));
            if (this.s == null) {
                this.s = new LayoutParams(-1, -1);
            }
            this.b.addView(this.r, this.s);
        }
        if (this.q && VERSION.SDK_INT >= 16) {
            this.a.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        if (this.i && VERSION.SDK_INT >= 21) {
            com.mikepenz.materialize.c.b.a(this.a, false);
        }
        if (this.l && VERSION.SDK_INT >= 21) {
            com.mikepenz.materialize.c.b.b(this.a, true);
        }
        if ((this.h || this.m) && VERSION.SDK_INT >= 21) {
            this.a.getWindow().addFlags(Integer.MIN_VALUE);
        }
        if (this.h && VERSION.SDK_INT >= 21) {
            com.mikepenz.materialize.c.b.a(this.a, false);
            this.a.getWindow().setStatusBarColor(0);
        }
        if (this.m && VERSION.SDK_INT >= 21) {
            com.mikepenz.materialize.c.b.b(this.a, true);
            this.a.getWindow().setNavigationBarColor(0);
        }
        int c = (!this.j || VERSION.SDK_INT < 21) ? 0 : com.mikepenz.materialize.c.b.c(this.a);
        int a = (!this.n || VERSION.SDK_INT < 21) ? 0 : com.mikepenz.materialize.c.b.a(this.a);
        if (this.j || (this.n && VERSION.SDK_INT >= 21)) {
            this.d.getView().setPadding(0, c, 0, a);
        }
        this.a = null;
        return new a(this);
    }

    public b a(Activity activity) {
        this.b = (ViewGroup) activity.findViewById(16908290);
        this.a = activity;
        return this;
    }

    public b a(ViewGroup viewGroup) {
        this.b = viewGroup;
        return this;
    }

    public b a(boolean z) {
        this.e = z;
        return this;
    }

    public b b(ViewGroup viewGroup) {
        this.r = viewGroup;
        return this;
    }

    public b b(boolean z) {
        this.h = z;
        return this;
    }

    public b c(boolean z) {
        this.k = z;
        return this;
    }

    public b d(boolean z) {
        this.l = z;
        return this;
    }

    public b e(boolean z) {
        this.o = z;
        if (z) {
            d(true);
        }
        return this;
    }

    public b f(boolean z) {
        this.p = z;
        if (z) {
            d(true);
            c(false);
            e(false);
        }
        return this;
    }

    public b g(boolean z) {
        this.q = z;
        if (z) {
            f(z);
        }
        return this;
    }
}
