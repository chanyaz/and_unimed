package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.PopupWindow;

public final class z {
    static final ad a;

    static {
        if (VERSION.SDK_INT >= 23) {
            a = new ac();
        } else if (VERSION.SDK_INT >= 21) {
            a = new ab();
        } else if (VERSION.SDK_INT >= 19) {
            a = new aa();
        } else {
            a = new ad();
        }
    }

    private z() {
    }

    public static void a(@NonNull PopupWindow popupWindow, int i) {
        a.a(popupWindow, i);
    }

    public static void a(@NonNull PopupWindow popupWindow, @NonNull View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }

    public static void a(@NonNull PopupWindow popupWindow, boolean z) {
        a.a(popupWindow, z);
    }
}
