package android.support.v4.widget;

import android.view.View;

class ag implements Runnable {
    final View a;
    final /* synthetic */ SlidingPaneLayout b;

    ag(SlidingPaneLayout slidingPaneLayout, View view) {
        this.b = slidingPaneLayout;
        this.a = view;
    }

    public void run() {
        if (this.a.getParent() == this.b) {
            this.a.setLayerType(0, null);
            this.b.e(this.a);
        }
        this.b.g.remove(this);
    }
}
