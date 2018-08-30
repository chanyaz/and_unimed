package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;

@RequiresApi(21)
class f extends g {
    f() {
    }

    public void a(LayoutInflater layoutInflater, Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
