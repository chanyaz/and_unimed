package android.support.v7.widget;

import android.view.View;

class g implements Runnable {
    final /* synthetic */ ActionMenuPresenter a;
    private i b;

    public g(ActionMenuPresenter actionMenuPresenter, i iVar) {
        this.a = actionMenuPresenter;
        this.b = iVar;
    }

    public void run() {
        if (this.a.c != null) {
            this.a.c.f();
        }
        View view = (View) this.a.f;
        if (!(view == null || view.getWindowToken() == null || !this.b.c())) {
            this.a.h = this.b;
        }
        this.a.j = null;
    }
}
