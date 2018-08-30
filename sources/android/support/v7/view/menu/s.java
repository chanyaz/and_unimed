package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

class s extends n implements VisibilityListener {
    ActionProvider.VisibilityListener c;
    final /* synthetic */ r d;

    public s(r rVar, Context context, android.view.ActionProvider actionProvider) {
        this.d = rVar;
        super(rVar, context, actionProvider);
    }

    public View a(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }

    public void a(ActionProvider.VisibilityListener visibilityListener) {
        VisibilityListener thisR;
        this.c = visibilityListener;
        android.view.ActionProvider actionProvider = this.a;
        if (visibilityListener == null) {
            thisR = null;
        }
        actionProvider.setVisibilityListener(thisR);
    }

    public boolean b() {
        return this.a.overridesItemVisibility();
    }

    public boolean c() {
        return this.a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        if (this.c != null) {
            this.c.onActionProviderVisibilityChanged(z);
        }
    }
}
