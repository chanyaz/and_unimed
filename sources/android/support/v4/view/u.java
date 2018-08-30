package android.support.v4.view;

import android.graphics.Paint;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.View;

@RequiresApi(17)
class u extends t {
    u() {
    }

    public void a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public int k(View view) {
        return view.getLayoutDirection();
    }

    public int l(View view) {
        return view.getPaddingStart();
    }

    public int m(View view) {
        return view.getPaddingEnd();
    }

    public int n(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public boolean o(View view) {
        return view.isPaddingRelative();
    }

    public Display p(View view) {
        return view.getDisplay();
    }
}
