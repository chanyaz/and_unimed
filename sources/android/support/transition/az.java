package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class az extends ViewGroup {
    static Method a;
    ViewGroup b;
    View c;
    ArrayList<Drawable> d = null;
    ay e;

    static {
        try {
            a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
        } catch (NoSuchMethodException e) {
        }
    }

    az(Context context, ViewGroup viewGroup, View view, ay ayVar) {
        super(context);
        this.b = viewGroup;
        this.c = view;
        setRight(viewGroup.getWidth());
        setBottom(viewGroup.getHeight());
        viewGroup.addView(this);
        this.e = ayVar;
    }

    private void a(int[] iArr) {
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        this.b.getLocationOnScreen(iArr2);
        this.c.getLocationOnScreen(iArr3);
        iArr[0] = iArr3[0] - iArr2[0];
        iArr[1] = iArr3[1] - iArr2[1];
    }

    public void a() {
        removeAllViews();
        if (this.d != null) {
            this.d.clear();
        }
    }

    public void a(Drawable drawable) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (!this.d.contains(drawable)) {
            this.d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }
    }

    public void a(View view) {
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (!(viewGroup == this.b || viewGroup.getParent() == null || !ViewCompat.B(viewGroup))) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr);
                this.b.getLocationOnScreen(iArr2);
                ViewCompat.e(view, iArr[0] - iArr2[0]);
                ViewCompat.d(view, iArr[1] - iArr2[1]);
            }
            viewGroup.removeView(view);
            if (view.getParent() != null) {
                viewGroup.removeView(view);
            }
        }
        super.addView(view, getChildCount() - 1);
    }

    public void b(Drawable drawable) {
        if (this.d != null) {
            this.d.remove(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(null);
        }
    }

    public void b(View view) {
        super.removeView(view);
        if (b()) {
            this.b.removeView(this);
        }
    }

    boolean b() {
        return getChildCount() == 0 && (this.d == null || this.d.size() == 0);
    }

    protected void dispatchDraw(Canvas canvas) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        this.b.getLocationOnScreen(iArr);
        this.c.getLocationOnScreen(iArr2);
        canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
        canvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
        super.dispatchDraw(canvas);
        int size = this.d == null ? 0 : this.d.size();
        for (int i = 0; i < size; i++) {
            ((Drawable) this.d.get(i)).draw(canvas);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if (this.b != null) {
            rect.offset(iArr[0], iArr[1]);
            if (this.b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                a(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
        }
        return null;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidate(drawable.getBounds());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || (this.d != null && this.d.contains(drawable));
    }
}
