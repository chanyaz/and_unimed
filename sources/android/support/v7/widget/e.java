package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.b;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.u;
import android.support.v7.view.menu.y;
import android.view.View;

class e extends u {
    final /* synthetic */ ActionMenuPresenter a;

    public e(ActionMenuPresenter actionMenuPresenter, Context context, y yVar, View view) {
        this.a = actionMenuPresenter;
        super(context, yVar, view, false, b.actionOverflowMenuStyle);
        if (!((l) yVar.getItem()).i()) {
            a(actionMenuPresenter.g == null ? (View) actionMenuPresenter.f : actionMenuPresenter.g);
        }
        setPresenterCallback(actionMenuPresenter.k);
    }

    protected void d() {
        this.a.i = null;
        this.a.l = 0;
        super.d();
    }
}
