package android.support.v4.widget;

import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

@RequiresApi(21)
class ab extends aa {
    private static Field a;

    static {
        try {
            a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    ab() {
    }

    public void a(PopupWindow popupWindow, boolean z) {
        if (a != null) {
            try {
                a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
