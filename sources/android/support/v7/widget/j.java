package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.y;

class j implements Callback {
    final /* synthetic */ ActionMenuPresenter a;

    j(ActionMenuPresenter actionMenuPresenter) {
        this.a = actionMenuPresenter;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder instanceof y) {
            menuBuilder.p().b(false);
        }
        Callback a = this.a.a();
        if (a != null) {
            a.onCloseMenu(menuBuilder, z);
        }
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            return false;
        }
        this.a.l = ((y) menuBuilder).getItem().getItemId();
        Callback a = this.a.a();
        return a != null ? a.onOpenSubMenu(menuBuilder) : false;
    }
}
