package android.support.design.internal;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.l;
import android.view.MenuItem;
import android.view.SubMenu;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class a extends MenuBuilder {
    public a(Context context) {
        super(context);
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        g();
        MenuItem a = super.a(i, i2, i3, charSequence);
        if (a instanceof l) {
            ((l) a).a(true);
        }
        h();
        return a;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }
}
