package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;

final class ad implements Callback {
    final /* synthetic */ ab a;

    ad(ab abVar) {
        this.a = abVar;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        if (this.a.c == null) {
            return;
        }
        if (this.a.a.isOverflowMenuShowing()) {
            this.a.c.onPanelClosed(108, menuBuilder);
        } else if (this.a.c.onPreparePanel(0, null, menuBuilder)) {
            this.a.c.onMenuOpened(108, menuBuilder);
        }
    }
}
