package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Window;

final class u implements Callback {
    final /* synthetic */ AppCompatDelegateImplV9 a;

    u(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
        this.a = appCompatDelegateImplV9;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        this.a.a(menuBuilder);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        Window.Callback r = this.a.r();
        if (r != null) {
            r.onMenuOpened(108, menuBuilder);
        }
        return true;
    }
}
