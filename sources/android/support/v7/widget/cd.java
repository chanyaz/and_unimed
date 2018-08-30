package android.support.v7.widget;

import android.os.Build.VERSION;
import android.support.v4.os.h;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

class cd implements Runnable {
    Interpolator a = RecyclerView.I;
    final /* synthetic */ RecyclerView b;
    private int c;
    private int d;
    private OverScroller e;
    private boolean f = false;
    private boolean g = false;

    cd(RecyclerView recyclerView) {
        this.b = recyclerView;
        this.e = new OverScroller(recyclerView.getContext(), RecyclerView.I);
    }

    private float a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    private int b(int i, int i2, int i3, int i4) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.b.getWidth() : this.b.getHeight();
        int i5 = width / 2;
        float a = (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
        } else {
            round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
        }
        return Math.min(round, 2000);
    }

    private void c() {
        this.g = false;
        this.f = true;
    }

    private void d() {
        this.f = false;
        if (this.g) {
            a();
        }
    }

    void a() {
        if (this.f) {
            this.g = true;
            return;
        }
        this.b.removeCallbacks(this);
        ViewCompat.a(this.b, (Runnable) this);
    }

    public void a(int i, int i2) {
        this.b.setScrollState(2);
        this.d = 0;
        this.c = 0;
        this.e.fling(0, 0, i, i2, Integer.MIN_VALUE, MoPubClientPositioning.NO_REPEAT, Integer.MIN_VALUE, MoPubClientPositioning.NO_REPEAT);
        a();
    }

    public void a(int i, int i2, int i3) {
        a(i, i2, i3, RecyclerView.I);
    }

    public void a(int i, int i2, int i3, int i4) {
        a(i, i2, b(i, i2, i3, i4));
    }

    public void a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.a != interpolator) {
            this.a = interpolator;
            this.e = new OverScroller(this.b.getContext(), interpolator);
        }
        this.b.setScrollState(2);
        this.d = 0;
        this.c = 0;
        this.e.startScroll(0, 0, i, i2, i3);
        if (VERSION.SDK_INT < 23) {
            this.e.computeScrollOffset();
        }
        a();
    }

    public void a(int i, int i2, Interpolator interpolator) {
        int b = b(i, i2, 0, 0);
        if (interpolator == null) {
            interpolator = RecyclerView.I;
        }
        a(i, i2, b, interpolator);
    }

    public void b() {
        this.b.removeCallbacks(this);
        this.e.abortAnimation();
    }

    public void b(int i, int i2) {
        a(i, i2, 0, 0);
    }

    public void run() {
        if (this.b.m == null) {
            b();
            return;
        }
        c();
        this.b.d();
        OverScroller overScroller = this.e;
        SmoothScroller smoothScroller = this.b.m.t;
        if (overScroller.computeScrollOffset()) {
            int i;
            int i2;
            int i3;
            int i4;
            int e;
            int[] a = this.b.aE;
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i5 = currX - this.c;
            int i6 = currY - this.d;
            this.c = currX;
            this.d = currY;
            if (this.b.dispatchNestedPreScroll(i5, i6, a, null, 1)) {
                i = i6 - a[1];
                i2 = i5 - a[0];
            } else {
                i = i6;
                i2 = i5;
            }
            if (this.b.l != null) {
                int i7;
                this.b.e();
                this.b.l();
                h.a("RV Scroll");
                this.b.a(this.b.C);
                if (i2 != 0) {
                    i6 = this.b.m.a(i2, this.b.d, this.b.C);
                    i3 = i2 - i6;
                } else {
                    i3 = 0;
                    i6 = 0;
                }
                if (i != 0) {
                    i5 = this.b.m.b(i, this.b.d, this.b.C);
                    i4 = i - i5;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                h.a();
                this.b.w();
                this.b.m();
                this.b.a(false);
                if (!(smoothScroller == null || smoothScroller.g() || !smoothScroller.h())) {
                    e = this.b.C.e();
                    if (e == 0) {
                        smoothScroller.f();
                        e = i4;
                        i7 = i5;
                        i5 = i6;
                        i6 = i7;
                    } else if (smoothScroller.i() >= e) {
                        smoothScroller.d(e - 1);
                        smoothScroller.a(i2 - i3, i - i4);
                        e = i4;
                        i7 = i5;
                        i5 = i6;
                        i6 = i7;
                    } else {
                        smoothScroller.a(i2 - i3, i - i4);
                    }
                }
                e = i4;
                i7 = i5;
                i5 = i6;
                i6 = i7;
            } else {
                e = 0;
                i3 = 0;
                i6 = 0;
                i5 = 0;
            }
            if (!this.b.o.isEmpty()) {
                this.b.invalidate();
            }
            if (this.b.getOverScrollMode() != 2) {
                this.b.c(i2, i);
            }
            if (!(this.b.dispatchNestedScroll(i5, i6, i3, e, null, 1) || (i3 == 0 && e == 0))) {
                int i8;
                int currVelocity = (int) overScroller.getCurrVelocity();
                if (i3 != currX) {
                    i4 = i3 < 0 ? -currVelocity : i3 > 0 ? currVelocity : 0;
                    i8 = i4;
                } else {
                    i8 = 0;
                }
                if (e == currY) {
                    currVelocity = 0;
                } else if (e < 0) {
                    currVelocity = -currVelocity;
                } else if (e <= 0) {
                    currVelocity = 0;
                }
                if (this.b.getOverScrollMode() != 2) {
                    this.b.d(i8, currVelocity);
                }
                if ((i8 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || e == currY || overScroller.getFinalY() == 0)) {
                    overScroller.abortAnimation();
                }
            }
            if (!(i5 == 0 && i6 == 0)) {
                this.b.i(i5, i6);
            }
            if (!this.b.awakenScrollBars()) {
                this.b.invalidate();
            }
            Object obj = (i != 0 && this.b.m.f() && i6 == i) ? 1 : null;
            Object obj2 = (i2 != 0 && this.b.m.e() && i5 == i2) ? 1 : null;
            obj2 = (!(i2 == 0 && i == 0) && obj2 == null && obj == null) ? null : 1;
            if (overScroller.isFinished() || (obj2 == null && !this.b.hasNestedScrollingParent(1))) {
                this.b.setScrollState(0);
                if (RecyclerView.L) {
                    this.b.B.a();
                }
                this.b.stopNestedScroll(1);
            } else {
                a();
                if (this.b.A != null) {
                    this.b.A.a(this.b, i2, i);
                }
            }
        }
        if (smoothScroller != null) {
            if (smoothScroller.g()) {
                smoothScroller.a(0, 0);
            }
            if (!this.g) {
                smoothScroller.f();
            }
        }
        d();
    }
}
