package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class ai implements SlidingPanelLayoutImpl {
    ai() {
    }

    public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
        ViewCompat.a(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
}
