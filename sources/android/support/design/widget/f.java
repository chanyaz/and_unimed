package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class f implements Runnable {
    final /* synthetic */ BottomSheetBehavior a;
    private final View b;
    private final int c;

    f(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.a = bottomSheetBehavior;
        this.b = view;
        this.c = i;
    }

    public void run() {
        if (this.a.e == null || !this.a.e.a(true)) {
            this.a.c(this.c);
        } else {
            ViewCompat.a(this.b, (Runnable) this);
        }
    }
}
