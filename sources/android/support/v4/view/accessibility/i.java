package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public class i {
    private final AccessibilityRecord a;

    @Deprecated
    public i(Object obj) {
        this.a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static i a() {
        return new i(AccessibilityRecord.obtain());
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public void a(int i) {
        this.a.setItemCount(i);
    }

    @Deprecated
    public void a(boolean z) {
        this.a.setScrollable(z);
    }

    @Deprecated
    public void b(int i) {
        this.a.setFromIndex(i);
    }

    @Deprecated
    public void c(int i) {
        this.a.setToIndex(i);
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == null ? iVar.a == null : this.a.equals(iVar.a);
    }

    @Deprecated
    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }
}
