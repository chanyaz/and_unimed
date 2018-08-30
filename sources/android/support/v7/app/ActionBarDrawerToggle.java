package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class ActionBarDrawerToggle implements DrawerListener {
    boolean a;
    OnClickListener b;
    private final Delegate c;
    private final DrawerLayout d;
    private DrawerArrowDrawable e;
    private boolean f;
    private Drawable g;
    private final int h;
    private final int i;
    private boolean j;

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i, @StringRes int i2) {
        this(activity, toolbar, drawerLayout, null, i, i2);
    }

    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i, @StringRes int i2) {
        this.f = true;
        this.a = true;
        this.j = false;
        if (toolbar != null) {
            this.c = new d(toolbar);
            toolbar.setNavigationOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (ActionBarDrawerToggle.this.a) {
                        ActionBarDrawerToggle.this.b();
                    } else if (ActionBarDrawerToggle.this.b != null) {
                        ActionBarDrawerToggle.this.b.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.c = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else if (VERSION.SDK_INT >= 18) {
            this.c = new c(activity);
        } else {
            this.c = new b(activity);
        }
        this.d = drawerLayout;
        this.h = i;
        this.i = i2;
        if (drawerArrowDrawable == null) {
            this.e = new DrawerArrowDrawable(this.c.getActionBarThemedContext());
        } else {
            this.e = drawerArrowDrawable;
        }
        this.g = d();
    }

    private void a(float f) {
        if (f == 1.0f) {
            this.e.b(true);
        } else if (f == 0.0f) {
            this.e.b(false);
        }
        this.e.c(f);
    }

    public void a() {
        if (this.d.g(8388611)) {
            a(1.0f);
        } else {
            a(0.0f);
        }
        if (this.a) {
            a(this.e, this.d.g(8388611) ? this.i : this.h);
        }
    }

    void a(int i) {
        this.c.setActionBarDescription(i);
    }

    void a(Drawable drawable, int i) {
        if (!(this.j || this.c.isNavigationVisible())) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.j = true;
        }
        this.c.setActionBarUpIndicator(drawable, i);
    }

    public void a(OnClickListener onClickListener) {
        this.b = onClickListener;
    }

    public void a(boolean z) {
        if (z != this.a) {
            if (z) {
                a(this.e, this.d.g(8388611) ? this.i : this.h);
            } else {
                a(this.g, 0);
            }
            this.a = z;
        }
    }

    void b() {
        int a = this.d.a(8388611);
        if (this.d.h(8388611) && a != 2) {
            this.d.f(8388611);
        } else if (a != 1) {
            this.d.e(8388611);
        }
    }

    public boolean c() {
        return this.a;
    }

    Drawable d() {
        return this.c.getThemeUpIndicator();
    }

    public void onDrawerClosed(View view) {
        a(0.0f);
        if (this.a) {
            a(this.h);
        }
    }

    public void onDrawerOpened(View view) {
        a(1.0f);
        if (this.a) {
            a(this.i);
        }
    }

    public void onDrawerSlide(View view, float f) {
        if (this.f) {
            a(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            a(0.0f);
        }
    }

    public void onDrawerStateChanged(int i) {
    }
}
