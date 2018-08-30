package android.support.v4.widget;

import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout.LayoutParams;
import android.view.View;

@RequiresApi(17)
class ak extends ai {
    ak() {
    }

    public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
        ViewCompat.a(view, ((LayoutParams) view.getLayoutParams()).d);
    }
}
