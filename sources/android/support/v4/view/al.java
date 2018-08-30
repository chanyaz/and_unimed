package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class al {
    static final ao a;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new an();
        } else if (VERSION.SDK_INT >= 19) {
            a = new am();
        } else {
            a = new ao();
        }
    }

    private al() {
    }

    public static void a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i);
        } else if (i == 0) {
            a.a(viewParent, view);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            a.a(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            a.a(viewParent, view, i, i2, iArr);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        return a.a(viewParent, view, f, f2);
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return a.a(viewParent, view, f, f2, z);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i, int i2) {
        return viewParent instanceof NestedScrollingParent2 ? ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i, i2) : i2 == 0 ? a.a(viewParent, view, view2, i) : false;
    }

    public static void b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i, i2);
        } else if (i2 == 0) {
            a.b(viewParent, view, view2, i);
        }
    }
}
