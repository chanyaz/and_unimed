package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class q extends f<OnMenuItemClickListener> implements OnMenuItemClickListener {
    final /* synthetic */ m a;

    q(m mVar, OnMenuItemClickListener onMenuItemClickListener) {
        this.a = mVar;
        super(onMenuItemClickListener);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.a.a(menuItem));
    }
}
