package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class ag extends LinearLayout {
    int a = -1;
    float b;
    final /* synthetic */ TabLayout c;
    private int d;
    private final Paint e;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private ValueAnimator i;

    ag(TabLayout tabLayout, Context context) {
        this.c = tabLayout;
        super(context);
        setWillNotDraw(false);
        this.e = new Paint();
    }

    private void c() {
        int i;
        int i2;
        View childAt = getChildAt(this.a);
        if (childAt == null || childAt.getWidth() <= 0) {
            i = -1;
            i2 = -1;
        } else {
            i2 = childAt.getLeft();
            i = childAt.getRight();
            if (this.b > 0.0f && this.a < getChildCount() - 1) {
                View childAt2 = getChildAt(this.a + 1);
                i2 = (int) ((((float) i2) * (1.0f - this.b)) + (this.b * ((float) childAt2.getLeft())));
                i = (int) ((((float) i) * (1.0f - this.b)) + (((float) childAt2.getRight()) * this.b));
            }
        }
        a(i2, i);
    }

    void a(int i) {
        if (this.e.getColor() != i) {
            this.e.setColor(i);
            ViewCompat.d(this);
        }
    }

    void a(int i, float f) {
        if (this.i != null && this.i.isRunning()) {
            this.i.cancel();
        }
        this.a = i;
        this.b = f;
        c();
    }

    void a(int i, int i2) {
        if (i != this.g || i2 != this.h) {
            this.g = i;
            this.h = i2;
            ViewCompat.d(this);
        }
    }

    boolean a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getWidth() <= 0) {
                return true;
            }
        }
        return false;
    }

    float b() {
        return ((float) this.a) + this.b;
    }

    void b(int i) {
        if (this.d != i) {
            this.d = i;
            ViewCompat.d(this);
        }
    }

    void b(final int i, int i2) {
        if (this.i != null && this.i.isRunning()) {
            this.i.cancel();
        }
        Object obj = ViewCompat.f(this) == 1 ? 1 : null;
        View childAt = getChildAt(i);
        if (childAt == null) {
            c();
            return;
        }
        int i3;
        int i4;
        final int left = childAt.getLeft();
        final int right = childAt.getRight();
        if (Math.abs(i - this.a) <= 1) {
            i3 = this.g;
            i4 = this.h;
        } else {
            int b = this.c.b(24);
            if (i < this.a) {
                if (obj != null) {
                    i4 = left - b;
                    i3 = i4;
                } else {
                    i4 = right + b;
                    i3 = i4;
                }
            } else if (obj != null) {
                i4 = right + b;
                i3 = i4;
            } else {
                i4 = left - b;
                i3 = i4;
            }
        }
        if (i3 != left || i4 != right) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.i = valueAnimator;
            valueAnimator.setInterpolator(a.b);
            valueAnimator.setDuration((long) i2);
            valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    ag.this.a(a.a(i3, left, animatedFraction), a.a(i4, right, animatedFraction));
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    ag.this.a = i;
                    ag.this.b = 0.0f;
                }
            });
            valueAnimator.start();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g >= 0 && this.h > this.g) {
            canvas.drawRect((float) this.g, (float) (getHeight() - this.d), (float) this.h, (float) getHeight(), this.e);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.i == null || !this.i.isRunning()) {
            c();
            return;
        }
        this.i.cancel();
        b(this.a, Math.round(((float) this.i.getDuration()) * (1.0f - this.i.getAnimatedFraction())));
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i) == 1073741824 && this.c.l == 1 && this.c.k == 1) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                i3++;
                i4 = childAt.getVisibility() == 0 ? Math.max(i4, childAt.getMeasuredWidth()) : i4;
            }
            if (i4 > 0) {
                if (i4 * childCount <= getMeasuredWidth() - (this.c.b(16) * 2)) {
                    i3 = 0;
                    while (i3 < childCount) {
                        boolean z2;
                        LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                        if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                            z2 = z;
                        } else {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                        i3++;
                        z = z2;
                    }
                } else {
                    this.c.k = 0;
                    this.c.a(false);
                    z = true;
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (VERSION.SDK_INT < 23 && this.f != i) {
            requestLayout();
            this.f = i;
        }
    }
}
