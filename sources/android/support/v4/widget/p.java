package android.support.v4.widget;

import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.view.View;

final class p extends a {
    p() {
    }

    public void a(View view, b bVar) {
        super.a(view, bVar);
        if (!DrawerLayout.l(view)) {
            bVar.c(null);
        }
    }
}
