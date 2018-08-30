package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.view.PointerIcon;

public final class q {
    private Object a;

    private q(Object obj) {
        this.a = obj;
    }

    public static q a(Context context, int i) {
        return VERSION.SDK_INT >= 24 ? new q(PointerIcon.getSystemIcon(context, i)) : new q(null);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public Object a() {
        return this.a;
    }
}
