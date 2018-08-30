package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

public class d {
    final Object a;

    d(Object obj) {
        this.a = obj;
    }

    public static d a(int i, int i2, boolean z, int i3) {
        return VERSION.SDK_INT >= 21 ? new d(CollectionInfo.obtain(i, i2, z, i3)) : VERSION.SDK_INT >= 19 ? new d(CollectionInfo.obtain(i, i2, z)) : new d(null);
    }
}
