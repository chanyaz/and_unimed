package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;

@RequiresApi(18)
class c implements Delegate {
    final Activity a;

    c(Activity activity) {
        this.a = activity;
    }

    public Context getActionBarThemedContext() {
        ActionBar actionBar = this.a.getActionBar();
        return actionBar != null ? actionBar.getThemedContext() : this.a;
    }

    public Drawable getThemeUpIndicator() {
        TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{16843531}, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public boolean isNavigationVisible() {
        ActionBar actionBar = this.a.getActionBar();
        return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
    }

    public void setActionBarDescription(int i) {
        ActionBar actionBar = this.a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, int i) {
        ActionBar actionBar = this.a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
    }
}
