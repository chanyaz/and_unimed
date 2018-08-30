package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.List;

public class f {
    private final Object a;

    public f() {
        if (VERSION.SDK_INT >= 19) {
            this.a = new h(this);
        } else if (VERSION.SDK_INT >= 16) {
            this.a = new g(this);
        } else {
            this.a = null;
        }
    }

    public f(Object obj) {
        this.a = obj;
    }

    @Nullable
    public b a(int i) {
        return null;
    }

    public Object a() {
        return this.a;
    }

    @Nullable
    public List<b> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    @Nullable
    public b b(int i) {
        return null;
    }
}
