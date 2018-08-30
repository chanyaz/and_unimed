package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;

class l implements Callback {
    final /* synthetic */ ActionMenuView a;

    l(ActionMenuView actionMenuView) {
        this.a = actionMenuView;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.a.b != null && this.a.b.onMenuItemClick(menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        if (this.a.a != null) {
            this.a.a.onMenuModeChange(menuBuilder);
        }
    }
}
