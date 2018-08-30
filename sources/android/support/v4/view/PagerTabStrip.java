package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class PagerTabStrip extends PagerTitleStrip {
    private int g = this.f;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private final Paint m = new Paint();
    private final Rect n = new Rect();
    private int o = 255;
    private boolean p = false;
    private boolean q = false;
    private int r;
    private boolean s;
    private float t;
    private float u;
    private int v;

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m.setColor(this.g);
        float f = context.getResources().getDisplayMetrics().density;
        this.h = (int) ((3.0f * f) + 0.5f);
        this.i = (int) ((6.0f * f) + 0.5f);
        this.j = (int) (64.0f * f);
        this.l = (int) ((16.0f * f) + 0.5f);
        this.r = (int) ((1.0f * f) + 0.5f);
        this.k = (int) ((f * 32.0f) + 0.5f);
        this.v = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.a.setCurrentItem(PagerTabStrip.this.a.getCurrentItem() - 1);
            }
        });
        this.d.setFocusable(true);
        this.d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.a.setCurrentItem(PagerTabStrip.this.a.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.p = true;
        }
    }

    void a(int i, float f, boolean z) {
        Rect rect = this.n;
        int height = getHeight();
        int i2 = height - this.h;
        rect.set(this.c.getLeft() - this.l, i2, this.c.getRight() + this.l, height);
        super.a(i, f, z);
        this.o = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.c.getLeft() - this.l, i2, this.c.getRight() + this.l, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.p;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.k);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.g;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.l;
        int right = this.c.getRight() + this.l;
        int i = height - this.h;
        this.m.setColor((this.o << 24) | (this.g & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.m);
        if (this.p) {
            this.m.setColor(CtaButton.BACKGROUND_COLOR | (this.g & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.r), (float) (getWidth() - getPaddingRight()), (float) height, this.m);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.s) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.t = x;
                this.u = y;
                this.s = false;
                break;
            case 1:
                if (x >= ((float) (this.c.getLeft() - this.l))) {
                    if (x > ((float) (this.c.getRight() + this.l))) {
                        this.a.setCurrentItem(this.a.getCurrentItem() + 1);
                        break;
                    }
                }
                this.a.setCurrentItem(this.a.getCurrentItem() - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.t) > ((float) this.v) || Math.abs(y - this.u) > ((float) this.v)) {
                    this.s = true;
                    break;
                }
        }
        return true;
    }

    public void setBackgroundColor(@ColorInt int i) {
        super.setBackgroundColor(i);
        if (!this.q) {
            this.p = (CtaButton.BACKGROUND_COLOR & i) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.q) {
            this.p = drawable == null;
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (!this.q) {
            this.p = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.p = z;
        this.q = true;
        invalidate();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.i) {
            i4 = this.i;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(@ColorInt int i) {
        this.g = i;
        this.m.setColor(this.g);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i) {
        setTabIndicatorColor(a.c(getContext(), i));
    }

    public void setTextSpacing(int i) {
        if (i < this.j) {
            i = this.j;
        }
        super.setTextSpacing(i);
    }
}
