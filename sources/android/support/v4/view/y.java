package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(23)
class y extends x {
    y() {
    }

    public void a(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }

    public void c(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public void d(View view, int i) {
        view.offsetTopAndBottom(i);
    }
}
