package android.support.v7.widget;

import android.support.v4.view.ViewCompat;

class bk implements Runnable {
    final /* synthetic */ ListPopupWindow a;

    bk(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void run() {
        if (this.a.c != null && ViewCompat.B(this.a.c) && this.a.c.getCount() > this.a.c.getChildCount() && this.a.c.getChildCount() <= this.a.d) {
            this.a.g.setInputMethodMode(2);
            this.a.a();
        }
    }
}
