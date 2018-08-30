package android.support.v7.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class bi implements OnScrollListener {
    final /* synthetic */ ListPopupWindow a;

    bi(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.a.j() && this.a.g.getContentView() != null) {
            this.a.f.removeCallbacks(this.a.e);
            this.a.e.run();
        }
    }
}
