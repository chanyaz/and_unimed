package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.widget.Toolbar;

class d implements Delegate {
    final Toolbar a;
    final Drawable b;
    final CharSequence c;

    d(Toolbar toolbar) {
        this.a = toolbar;
        this.b = toolbar.getNavigationIcon();
        this.c = toolbar.getNavigationContentDescription();
    }

    public Context getActionBarThemedContext() {
        return this.a.getContext();
    }

    public Drawable getThemeUpIndicator() {
        return this.b;
    }

    public boolean isNavigationVisible() {
        return true;
    }

    public void setActionBarDescription(@StringRes int i) {
        if (i == 0) {
            this.a.setNavigationContentDescription(this.c);
        } else {
            this.a.setNavigationContentDescription(i);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, @StringRes int i) {
        this.a.setNavigationIcon(drawable);
        setActionBarDescription(i);
    }
}
