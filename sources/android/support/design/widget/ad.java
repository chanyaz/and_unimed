package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class ad implements Runnable {
    final /* synthetic */ SwipeDismissBehavior a;
    private final View b;
    private final boolean c;

    ad(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.a = swipeDismissBehavior;
        this.b = view;
        this.c = z;
    }

    public void run() {
        if (this.a.b != null && this.a.b.a(true)) {
            ViewCompat.a(this.b, (Runnable) this);
        } else if (this.c && this.a.c != null) {
            this.a.c.onDismiss(this.b);
        }
    }
}
