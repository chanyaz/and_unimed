package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.widget.z;
import android.support.v7.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean a = (VERSION.SDK_INT < 21);
    private boolean b;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        db a = db.a(context, attributeSet, k.PopupWindow, i, i2);
        if (a.g(k.PopupWindow_overlapAnchor)) {
            a(a.a(k.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.a(k.PopupWindow_android_popupBackground));
        a.a();
    }

    private void a(boolean z) {
        if (a) {
            this.b = z;
        } else {
            z.a((PopupWindow) this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (a && this.b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height = (a && this.b) ? i2 - view.getHeight() : i2;
        super.update(view, i, height, i3, i4);
    }
}
