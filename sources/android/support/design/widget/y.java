package android.support.design.widget;

import android.support.v4.view.ViewCompat;

class y implements Runnable {
    final /* synthetic */ HeaderBehavior a;
    private final CoordinatorLayout b;
    private final V c;

    y(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
        this.a = headerBehavior;
        this.b = coordinatorLayout;
        this.c = v;
    }

    public void run() {
        if (this.c != null && this.a.a != null) {
            if (this.a.a.computeScrollOffset()) {
                this.a.a_(this.b, this.c, this.a.a.getCurrY());
                ViewCompat.a(this.c, (Runnable) this);
                return;
            }
            this.a.a(this.b, this.c);
        }
    }
}
