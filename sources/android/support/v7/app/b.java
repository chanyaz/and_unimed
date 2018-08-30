package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;

class b implements Delegate {
    final Activity a;
    f b;

    b(Activity activity) {
        this.a = activity;
    }

    public Context getActionBarThemedContext() {
        ActionBar actionBar = this.a.getActionBar();
        return actionBar != null ? actionBar.getThemedContext() : this.a;
    }

    public Drawable getThemeUpIndicator() {
        return e.a(this.a);
    }

    public boolean isNavigationVisible() {
        ActionBar actionBar = this.a.getActionBar();
        return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
    }

    public void setActionBarDescription(int i) {
        this.b = e.a(this.b, this.a, i);
    }

    public void setActionBarUpIndicator(Drawable drawable, int i) {
        ActionBar actionBar = this.a.getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            this.b = e.a(this.b, this.a, drawable, i);
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }
}
