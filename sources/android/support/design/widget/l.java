package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class l implements OnHierarchyChangeListener {
    final /* synthetic */ CoordinatorLayout a;

    l(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.a.e != null) {
            this.a.e.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        this.a.a(2);
        if (this.a.e != null) {
            this.a.e.onChildViewRemoved(view, view2);
        }
    }
}
