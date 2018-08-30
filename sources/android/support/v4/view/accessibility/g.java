package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(16)
class g extends AccessibilityNodeProvider {
    final f a;

    g(f fVar) {
        this.a = fVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        b a = this.a.a(i);
        return a == null ? null : a.a();
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        List a = this.a.a(str, i);
        if (a == null) {
            return null;
        }
        List<AccessibilityNodeInfo> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((b) a.get(i2)).a());
        }
        return arrayList;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.a.a(i, i2, bundle);
    }
}
