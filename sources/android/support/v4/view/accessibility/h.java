package android.support.v4.view.accessibility;

import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;

@RequiresApi(19)
class h extends g {
    h(f fVar) {
        super(fVar);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        b b = this.a.b(i);
        return b == null ? null : b.a();
    }
}
