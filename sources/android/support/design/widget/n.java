package android.support.design.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

class n implements OnPreDrawListener {
    final /* synthetic */ CoordinatorLayout a;

    n(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    public boolean onPreDraw() {
        this.a.a(0);
        return true;
    }
}
