package com.mikepenz.materialize.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.as;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mikepenz.materialize.i;
import com.mikepenz.materialize.j;

public class ScrimInsetsRelativeLayout extends RelativeLayout implements IScrimInsetsLayout {
    private Drawable a;
    private Rect b;
    private Rect c;
    private OnInsetsCallback d;
    private boolean e;
    private boolean f;
    private boolean g;

    public ScrimInsetsRelativeLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        this.e = true;
        this.f = true;
        this.g = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ScrimInsetsRelativeLayout, i, i.Widget_Materialize_ScrimInsetsRelativeLayout);
        this.a = obtainStyledAttributes.getDrawable(j.ScrimInsetsRelativeLayout_sirl_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.a((View) this, new OnApplyWindowInsetsListener() {
            public as onApplyWindowInsets(View view, as asVar) {
                if (ScrimInsetsRelativeLayout.this.b == null) {
                    ScrimInsetsRelativeLayout.this.b = new Rect();
                }
                ScrimInsetsRelativeLayout.this.b.set(asVar.a(), asVar.b(), asVar.c(), asVar.d());
                ScrimInsetsRelativeLayout.this.setWillNotDraw(ScrimInsetsRelativeLayout.this.a == null);
                ViewCompat.d(ScrimInsetsRelativeLayout.this);
                if (ScrimInsetsRelativeLayout.this.d != null) {
                    ScrimInsetsRelativeLayout.this.d.onInsetsChanged(asVar);
                }
                return asVar.g();
            }
        });
    }

    public void draw(@NonNull Canvas canvas) {
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
