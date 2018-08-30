package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class n extends ActionProvider {
    final android.view.ActionProvider a;
    final /* synthetic */ m b;

    public n(m mVar, Context context, android.view.ActionProvider actionProvider) {
        this.b = mVar;
        super(context);
        this.a = actionProvider;
    }

    public View a() {
        return this.a.onCreateActionView();
    }

    public void a(SubMenu subMenu) {
        this.a.onPrepareSubMenu(this.b.a(subMenu));
    }

    public boolean d() {
        return this.a.onPerformDefaultAction();
    }

    public boolean e() {
        return this.a.hasSubMenu();
    }
}
