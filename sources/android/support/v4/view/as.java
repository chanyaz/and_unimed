package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public class as {
    private final Object a;

    private as(Object obj) {
        this.a = obj;
    }

    static as a(Object obj) {
        return obj == null ? null : new as(obj);
    }

    static Object a(as asVar) {
        return asVar == null ? null : asVar.a;
    }

    public int a() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetLeft() : 0;
    }

    public as a(int i, int i2, int i3, int i4) {
        return VERSION.SDK_INT >= 20 ? new as(((WindowInsets) this.a).replaceSystemWindowInsets(i, i2, i3, i4)) : null;
    }

    public int b() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetTop() : 0;
    }

    public int c() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetRight() : 0;
    }

    public int d() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetBottom() : 0;
    }

    public boolean e() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).hasSystemWindowInsets() : false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        as asVar = (as) obj;
        return this.a == null ? asVar.a == null : this.a.equals(asVar.a);
    }

    public boolean f() {
        return VERSION.SDK_INT >= 21 ? ((WindowInsets) this.a).isConsumed() : false;
    }

    public as g() {
        return VERSION.SDK_INT >= 20 ? new as(((WindowInsets) this.a).consumeSystemWindowInsets()) : null;
    }

    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }
}
