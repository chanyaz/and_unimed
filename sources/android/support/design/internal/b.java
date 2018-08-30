package android.support.design.internal;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.y;
import android.view.SubMenu;

@RestrictTo({Scope.LIBRARY_GROUP})
public class b extends MenuBuilder {
    public b(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        l lVar = (l) a(i, i2, i3, charSequence);
        y lVar2 = new l(e(), this, lVar);
        lVar.a(lVar2);
        return lVar2;
    }
}
