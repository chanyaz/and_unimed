package android.support.v7.view.menu;

import android.support.v7.widget.at;

class b extends at {
    final /* synthetic */ ActionMenuItemView a;

    public b(ActionMenuItemView actionMenuItemView) {
        this.a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public ShowableListMenu a() {
        return this.a.d != null ? this.a.d.a() : null;
    }

    protected boolean b() {
        if (this.a.c == null || !this.a.c.invokeItem(this.a.b)) {
            return false;
        }
        ShowableListMenu a = a();
        return a != null && a.isShowing();
    }
}
