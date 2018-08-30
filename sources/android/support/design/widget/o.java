package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.Comparator;

class o implements Comparator<View> {
    o() {
    }

    /* renamed from: a */
    public int compare(View view, View view2) {
        float z = ViewCompat.z(view);
        float z2 = ViewCompat.z(view2);
        return z > z2 ? -1 : z < z2 ? 1 : 0;
    }
}
