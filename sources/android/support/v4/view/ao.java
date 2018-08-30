package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ao {
    ao() {
    }

    public void a(ViewParent viewParent, View view) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
        }
    }

    public void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public boolean a(ViewParent viewParent, View view, float f, float f2) {
        return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2) : false;
    }

    public boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z) : false;
    }

    public boolean a(ViewParent viewParent, View view, View view2, int i) {
        return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i) : false;
    }

    public void b(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof NestedScrollingParent) {
            ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
        }
    }
}
