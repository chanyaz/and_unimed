package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class v {
    private v() {
    }

    public static Menu a(Context context, SupportMenu supportMenu) {
        return new w(context, supportMenu);
    }

    public static MenuItem a(Context context, SupportMenuItem supportMenuItem) {
        return VERSION.SDK_INT >= 16 ? new r(context, supportMenuItem) : new m(context, supportMenuItem);
    }

    public static SubMenu a(Context context, SupportSubMenu supportSubMenu) {
        return new z(context, supportSubMenu);
    }
}
