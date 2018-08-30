package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.b;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.u;
import android.view.View;

class i extends u {
    final /* synthetic */ ActionMenuPresenter a;

    public i(ActionMenuPresenter actionMenuPresenter, Context context, MenuBuilder menuBuilder, View view, boolean z) {
        this.a = actionMenuPresenter;
        super(context, menuBuilder, view, z, b.actionOverflowMenuStyle);
        a(8388613);
        setPresenterCallback(actionMenuPresenter.k);
    }

    protected void d() {
        if (this.a.c != null) {
            this.a.c.close();
        }
        this.a.h = null;
        super.d();
    }
}
