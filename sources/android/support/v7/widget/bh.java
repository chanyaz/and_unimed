package android.support.v7.widget;

import android.database.DataSetObserver;

class bh extends DataSetObserver {
    final /* synthetic */ ListPopupWindow a;

    bh(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void onChanged() {
        if (this.a.isShowing()) {
            this.a.a();
        }
    }

    public void onInvalidated() {
        this.a.dismiss();
    }
}
