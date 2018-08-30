package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;

final class ac implements Callback {
    final /* synthetic */ ab a;
    private boolean b;

    ac(ab abVar) {
        this.a = abVar;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (!this.b) {
            this.b = true;
            this.a.a.dismissPopupMenus();
            if (this.a.c != null) {
                this.a.c.onPanelClosed(108, menuBuilder);
            }
            this.b = false;
        }
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        if (this.a.c == null) {
            return false;
        }
        this.a.c.onMenuOpened(108, menuBuilder);
        return true;
    }
}
