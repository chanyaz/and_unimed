package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public class e {
    final Object a;

    e(Object obj) {
        this.a = obj;
    }

    public static e a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return VERSION.SDK_INT >= 21 ? new e(CollectionItemInfo.obtain(i, i2, i3, i4, z, z2)) : VERSION.SDK_INT >= 19 ? new e(CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new e(null);
    }
}
