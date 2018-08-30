package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.a.b;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.widget.db;

class l implements Delegate {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public Context getActionBarThemedContext() {
        return this.a.o();
    }

    public Drawable getThemeUpIndicator() {
        db a = db.a(getActionBarThemedContext(), null, new int[]{b.homeAsUpIndicator});
        Drawable a2 = a.a(0);
        a.a();
        return a2;
    }

    public boolean isNavigationVisible() {
        ActionBar a = this.a.a();
        return (a == null || (a.a() & 4) == 0) ? false : true;
    }

    public void setActionBarDescription(int i) {
        ActionBar a = this.a.a();
        if (a != null) {
            a.b(i);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, int i) {
        ActionBar a = this.a.a();
        if (a != null) {
            a.b(drawable);
            a.b(i);
        }
    }
}
