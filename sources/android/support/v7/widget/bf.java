package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class bf extends SmoothScroller {
    protected final LinearInterpolator a = new LinearInterpolator();
    protected final DecelerateInterpolator b = new DecelerateInterpolator();
    protected PointF c;
    protected int d = 0;
    protected int e = 0;
    private final float f;

    public bf(Context context) {
        this.f = a(context.getResources().getDisplayMetrics());
    }

    private int a(int i, int i2) {
        int i3 = i - i2;
        return i * i3 <= 0 ? 0 : i3;
    }

    protected float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    protected int a(int i) {
        return (int) Math.ceil(((double) b(i)) / 0.3356d);
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int a(View view, int i) {
        LayoutManager e = e();
        if (e == null || !e.f()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return a(e.i(view) - layoutParams.topMargin, e.k(view) + layoutParams.bottomMargin, e.C(), e.A() - e.E(), i);
    }

    protected void a() {
    }

    protected void a(int i, int i2, State state, cb cbVar) {
        if (j() == 0) {
            f();
            return;
        }
        this.d = a(this.d, i);
        this.e = a(this.e, i2);
        if (this.d == 0 && this.e == 0) {
            a(cbVar);
        }
    }

    protected void a(cb cbVar) {
        PointF c = c(i());
        if (c == null || (c.x == 0.0f && c.y == 0.0f)) {
            cbVar.a(i());
            f();
            return;
        }
        a(c);
        this.c = c;
        this.d = (int) (c.x * 10000.0f);
        this.e = (int) (c.y * 10000.0f);
        cbVar.a((int) (((float) this.d) * 1.2f), (int) (((float) this.e) * 1.2f), (int) (((float) b(10000)) * 1.2f), this.a);
    }

    protected void a(View view, State state, cb cbVar) {
        int b = b(view, c());
        int a = a(view, d());
        int a2 = a((int) Math.sqrt((double) ((b * b) + (a * a))));
        if (a2 > 0) {
            cbVar.a(-b, -a, a2, this.b);
        }
    }

    protected int b(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f));
    }

    public int b(View view, int i) {
        LayoutManager e = e();
        if (e == null || !e.e()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return a(e.h(view) - layoutParams.leftMargin, e.j(view) + layoutParams.rightMargin, e.B(), e.z() - e.D(), i);
    }

    protected void b() {
        this.e = 0;
        this.d = 0;
        this.c = null;
    }

    protected int c() {
        return (this.c == null || this.c.x == 0.0f) ? 0 : this.c.x > 0.0f ? 1 : -1;
    }

    @Nullable
    public PointF c(int i) {
        LayoutManager e = e();
        if (e instanceof ScrollVectorProvider) {
            return ((ScrollVectorProvider) e).computeScrollVectorForPosition(i);
        }
        Log.w("LinearSmoothScroller", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
        return null;
    }

    protected int d() {
        return (this.c == null || this.c.y == 0.0f) ? 0 : this.c.y > 0.0f ? 1 : -1;
    }
}
