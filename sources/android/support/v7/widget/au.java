package android.support.v7.widget;

import android.view.ViewParent;

class au implements Runnable {
    final /* synthetic */ at a;

    au(at atVar) {
        this.a = atVar;
    }

    public void run() {
        ViewParent parent = this.a.c.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
}
