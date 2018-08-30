package android.support.v4.widget;

import android.support.annotation.RequiresApi;
import android.widget.PopupWindow;

@RequiresApi(23)
class ac extends ab {
    ac() {
    }

    public void a(PopupWindow popupWindow, int i) {
        popupWindow.setWindowLayoutType(i);
    }

    public void a(PopupWindow popupWindow, boolean z) {
        popupWindow.setOverlapAnchor(z);
    }
}
