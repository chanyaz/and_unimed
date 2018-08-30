package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.k;
import android.support.design.l;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.as;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable a;
    Rect b;
    private Rect c;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ScrimInsetsFrameLayout, i, k.Widget_Design_ScrimInsetsFrameLayout);
        this.a = obtainStyledAttributes.getDrawable(l.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        ViewCompat.a((View) this, new OnApplyWindowInsetsListener() {
            public as onApplyWindowInsets(View view, as asVar) {
                if (ScrimInsetsFrameLayout.this.b == null) {
                    ScrimInsetsFrameLayout.this.b = new Rect();
                }
                ScrimInsetsFrameLayout.this.b.set(asVar.a(), asVar.b(), asVar.c(), asVar.d());
                ScrimInsetsFrameLayout.this.a(asVar);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                boolean z = !asVar.e() || ScrimInsetsFrameLayout.this.a == null;
                scrimInsetsFrameLayout.setWillNotDraw(z);
                ViewCompat.d(ScrimInsetsFrameLayout.this);
                return asVar.g();
            }
        });
    }

    protected void a(as asVar) {
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.b != null && this.a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.c.set(0, 0, width, this.b.top);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
            this.c.set(0, height - this.b.bottom, width, height);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
            this.c.set(0, this.b.top, this.b.left, height - this.b.bottom);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
            this.c.set(width - this.b.right, this.b.top, width, height - this.b.bottom);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
            canvas.restoreToCount(save);
        }
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
}
