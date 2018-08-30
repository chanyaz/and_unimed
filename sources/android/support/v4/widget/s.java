package android.support.v4.widget;

import android.support.annotation.RequiresApi;
import android.widget.EdgeEffect;

@RequiresApi(21)
class s extends t {
    s() {
    }

    public void a(EdgeEffect edgeEffect, float f, float f2) {
        edgeEffect.onPull(f, f2);
    }
}
