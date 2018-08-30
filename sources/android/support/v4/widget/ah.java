package android.support.v4.widget;

import android.support.v4.widget.SlidingPaneLayout.LayoutParams;
import android.view.View;

class ah extends at {
    final /* synthetic */ SlidingPaneLayout a;

    ah(SlidingPaneLayout slidingPaneLayout) {
        this.a = slidingPaneLayout;
    }

    public int a(View view, int i, int i2) {
        return view.getTop();
    }

    public void a(int i) {
        if (this.a.e.a() != 0) {
            return;
        }
        if (this.a.b == 0.0f) {
            this.a.d(this.a.a);
            this.a.c(this.a.a);
            this.a.f = false;
            return;
        }
        this.a.b(this.a.a);
        this.a.f = true;
    }

    public void a(View view, float f, float f2) {
        int paddingRight;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.a.f()) {
            paddingRight = layoutParams.rightMargin + this.a.getPaddingRight();
            if (f < 0.0f || (f == 0.0f && this.a.b > 0.5f)) {
                paddingRight += this.a.c;
            }
            paddingRight = (this.a.getWidth() - paddingRight) - this.a.a.getWidth();
        } else {
            paddingRight = layoutParams.leftMargin + this.a.getPaddingLeft();
            if (f > 0.0f || (f == 0.0f && this.a.b > 0.5f)) {
                paddingRight += this.a.c;
            }
        }
        this.a.e.a(paddingRight, view.getTop());
        this.a.invalidate();
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.a.a(i);
        this.a.invalidate();
    }

    public boolean a(View view, int i) {
        return this.a.d ? false : ((LayoutParams) view.getLayoutParams()).b;
    }

    public int b(View view) {
        return this.a.c;
    }

    public int b(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.a.a.getLayoutParams();
        int width;
        if (this.a.f()) {
            width = this.a.getWidth() - ((layoutParams.rightMargin + this.a.getPaddingRight()) + this.a.a.getWidth());
            return Math.max(Math.min(i, width), width - this.a.c);
        }
        width = layoutParams.leftMargin + this.a.getPaddingLeft();
        return Math.min(Math.max(i, width), this.a.c + width);
    }

    public void b(int i, int i2) {
        this.a.e.a(this.a.a, i2);
    }

    public void b(View view, int i) {
        this.a.a();
    }
}
