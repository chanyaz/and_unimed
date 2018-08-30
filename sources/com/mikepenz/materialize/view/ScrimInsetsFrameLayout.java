package com.mikepenz.materialize.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.as;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mikepenz.materialize.i;
import com.mikepenz.materialize.j;

public class ScrimInsetsFrameLayout extends FrameLayout implements IScrimInsetsLayout {
    private Drawable a;
    private Rect b;
    private Rect c = new Rect();
    private OnInsetsCallback d;
    private boolean e = true;
    private boolean f = true;
    private boolean g = true;

    public ScrimInsetsFrameLayout(Context context) {
        super(context);
        a(context, null, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ScrimInsetsView, i, i.Widget_Materialize_ScrimInsetsRelativeLayout);
        this.a = obtainStyledAttributes.getDrawable(j.ScrimInsetsView_siv_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.a((View) this, new OnApplyWindowInsetsListener() {
            public as onApplyWindowInsets(View view, as asVar) {
                if (ScrimInsetsFrameLayout.this.b == null) {
                    ScrimInsetsFrameLayout.this.b = new Rect();
                }
                ScrimInsetsFrameLayout.this.b.set(asVar.a(), asVar.b(), asVar.c(), asVar.d());
                ScrimInsetsFrameLayout.this.setWillNotDraw(ScrimInsetsFrameLayout.this.a == null);
                ViewCompat.d(ScrimInsetsFrameLayout.this);
                if (ScrimInsetsFrameLayout.this.d != null) {
                    ScrimInsetsFrameLayout.this.d.onInsetsChanged(asVar);
                }
                return asVar.g();
            }
        });
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.b != null && this.a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            if (!this.g) {
                this.b.top = 0;
                this.b.right = 0;
                this.b.bottom = 0;
                this.b.left = 0;
            }
            if (this.e) {
                this.c.set(0, 0, width, this.b.top);
                this.a.setBounds(this.c);
                this.a.draw(canvas);
            }
            if (this.f) {
                this.c.set(0, height - this.b.bottom, width, height);
                this.a.setBounds(this.c);
                this.a.draw(canvas);
            }
            this.c.set(0, this.b.top, this.b.left, height - this.b.bottom);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
            this.c.set(width - this.b.right, this.b.top, width, height - this.b.bottom);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public Drawable getInsetForeground() {
        return this.a;
    }

    public OnInsetsCallback getOnInsetsCallback() {
        return this.d;
    }

    public ViewGroup getView() {
        return this;
    }

    public boolean isSystemUIVisible() {
        return this.g;
    }

    public boolean isTintNavigationBar() {
        return this.f;
    }

    public boolean isTintStatusBar() {
        return this.e;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.a.setCallback(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.setCallback(null);
        }
    }

    public void setInsetForeground(int i) {
        this.a = new ColorDrawable(i);
    }

    public void setInsetForeground(Drawable drawable) {
        this.a = drawable;
    }

    public void setOnInsetsCallback(OnInsetsCallback onInsetsCallback) {
        this.d = onInsetsCallback;
    }

    public void setSystemUIVisible(boolean z) {
        this.g = z;
    }

    public void setTintNavigationBar(boolean z) {
        this.f = z;
    }

    public void setTintStatusBar(boolean z) {
        this.e = z;
    }
}
