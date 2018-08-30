package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.d;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

class ad {
    private static Method a;
    private static boolean b;

    ad() {
    }

    public void a(PopupWindow popupWindow, int i) {
        if (!b) {
            try {
                a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                a.setAccessible(true);
            } catch (Exception e) {
            }
            b = true;
        }
        if (a != null) {
            try {
                a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }

    public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if ((d.a(i3, ViewCompat.f(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    public void a(PopupWindow popupWindow, boolean z) {
    }
}
