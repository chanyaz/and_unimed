package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.View;

@Deprecated
public class ActionBarDrawerToggle implements DrawerListener {
    private static final int[] b = new int[]{16843531};
    final Activity a;
    private final Delegate c;
    private boolean d;
    private b e;
    private final int f;
    private final int g;
    private a h;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    private void a(int i) {
        ActionBar actionBar;
        if (this.c != null) {
            this.c.setActionBarDescription(i);
        } else if (VERSION.SDK_INT >= 18) {
            actionBar = this.a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        } else {
            if (this.h == null) {
                this.h = new a(this.a);
            }
            if (this.h.a != null) {
                try {
                    actionBar = this.a.getActionBar();
                    this.h.b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                    actionBar.setSubtitle(actionBar.getSubtitle());
                } catch (Throwable e) {
                    Log.w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", e);
                }
            }
        }
    }

    public void onDrawerClosed(View view) {
        this.e.a(0.0f);
        if (this.d) {
            a(this.f);
        }
    }

    public void onDrawerOpened(View view) {
        this.e.a(1.0f);
        if (this.d) {
            a(this.g);
        }
    }

    public void onDrawerSlide(View view, float f) {
        float a = this.e.a();
        this.e.a(f > 0.5f ? Math.max(a, Math.max(0.0f, f - 0.5f) * 2.0f) : Math.min(a, f * 2.0f));
    }

    public void onDrawerStateChanged(int i) {
    }
}
