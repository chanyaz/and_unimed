package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.a.a;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.as;
import android.support.v4.view.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    final Rect a = new Rect();
    final Rect b = new Rect();
    private int c = 0;
    private int d;

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int c(int i) {
        return i == 0 ? 8388659 : i;
    }

    float a(View view) {
        return 1.0f;
    }

    final int a() {
        return this.c;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View b = b(coordinatorLayout.c(view));
            if (b != null) {
                if (ViewCompat.r(b) && !ViewCompat.r(view)) {
                    ViewCompat.b(view, true);
                    if (ViewCompat.r(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.a(view, i, i2, MeasureSpec.makeMeasureSpec(b(b) + (size - b.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    int b(View view) {
        return view.getMeasuredHeight();
    }

    abstract View b(List<View> list);

    public final void b(int i) {
        this.d = i;
    }

    protected void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b = b(coordinatorLayout.c(view));
        if (b != null) {
            m mVar = (m) view.getLayoutParams();
            Rect rect = this.a;
            rect.set(coordinatorLayout.getPaddingLeft() + mVar.leftMargin, b.getBottom() + mVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - mVar.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - mVar.bottomMargin);
            as lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || !ViewCompat.r(coordinatorLayout) || ViewCompat.r(view))) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.b;
            d.a(c(mVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = c(b);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.c = rect2.top - b.getBottom();
            return;
        }
        super.b(coordinatorLayout, view, i);
        this.c = 0;
    }

    final int c(View view) {
        return this.d == 0 ? 0 : a.a((int) (a(view) * ((float) this.d)), 0, this.d);
    }

    public final int d() {
        return this.d;
    }
}
