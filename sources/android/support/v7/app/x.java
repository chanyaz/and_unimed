package android.support.v7.app;

import android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Menu;
import android.view.Window;

final class x implements Callback {
    final /* synthetic */ AppCompatDelegateImplV9 a;

    x(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
        this.a = appCompatDelegateImplV9;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        Menu menuBuilder2;
        Menu p = menuBuilder2.p();
        boolean z2 = p != menuBuilder2;
        AppCompatDelegateImplV9 appCompatDelegateImplV9 = this.a;
        if (z2) {
            menuBuilder2 = p;
        }
        PanelFeatureState a = appCompatDelegateImplV9.a(menuBuilder2);
        if (a == null) {
            return;
        }
        if (z2) {
            this.a.a(a.a, a, p);
            this.a.a(a, true);
            return;
        }
        this.a.a(a, z);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (menuBuilder == null && this.a.h) {
            Window.Callback r = this.a.r();
            if (!(r == null || this.a.q())) {
                r.onMenuOpened(108, menuBuilder);
            }
        }
        return true;
    }
}
