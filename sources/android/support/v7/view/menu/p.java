package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class p extends f<OnActionExpandListener> implements OnActionExpandListener {
    final /* synthetic */ m a;

    p(m mVar, OnActionExpandListener onActionExpandListener) {
        this.a = mVar;
        super(onActionExpandListener);
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.a.a(menuItem));
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.a.a(menuItem));
    }
}
