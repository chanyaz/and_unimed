package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(19)
class w extends v {
    w() {
    }

    public void a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public void b(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public boolean r(View view) {
        return view.isLaidOut();
    }

    public boolean s(View view) {
        return view.isAttachedToWindow();
    }
}
