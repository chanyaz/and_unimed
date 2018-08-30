package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.support.v7.widget.dd;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window.Callback;
import java.util.ArrayList;

class ab extends ActionBar {
    DecorToolbar a;
    boolean b;
    Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<OnMenuVisibilityListener> f = new ArrayList();
    private final Runnable g = new Runnable() {
        public void run() {
            ab.this.l();
        }
    };
    private final OnMenuItemClickListener h = new OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ab.this.c.onMenuItemSelected(0, menuItem);
        }
    };

    ab(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.a = new dd(toolbar, false);
        this.c = new ae(this, callback);
        this.a.setWindowCallback(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.a.setWindowTitle(charSequence);
    }

    private Menu m() {
        if (!this.d) {
            this.a.setMenuCallbacks(new ac(this), new ad(this));
            this.d = true;
        }
        return this.a.getMenu();
    }

    public int a() {
        return this.a.getDisplayOptions();
    }

    public void a(float f) {
        ViewCompat.a(this.a.getViewGroup(), f);
    }

    public void a(int i) {
        this.a.setNavigationIcon(i);
    }

    public void a(int i, int i2) {
        this.a.setDisplayOptions((this.a.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(@Nullable Drawable drawable) {
        this.a.setBackgroundDrawable(drawable);
    }

    public void a(CharSequence charSequence) {
        this.a.setTitle(charSequence);
    }

    public void a(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu m = m();
        if (m == null) {
            return false;
        }
        m.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return m.performShortcut(i, keyEvent, 0);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            f();
        }
        return true;
    }

    public int b() {
        return this.a.getHeight();
    }

    public void b(int i) {
        this.a.setNavigationContentDescription(i);
    }

    public void b(Drawable drawable) {
        this.a.setNavigationIcon(drawable);
    }

    public void b(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    public void b(boolean z) {
    }

    public void c() {
        this.a.setVisibility(0);
    }

    public void d() {
        this.a.setVisibility(8);
    }

    public void d(boolean z) {
    }

    public Context e() {
        return this.a.getContext();
    }

    public void e(boolean z) {
    }

    public void f(boolean z) {
        if (z != this.e) {
            this.e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                ((OnMenuVisibilityListener) this.f.get(i)).onMenuVisibilityChanged(z);
            }
        }
    }

    public boolean f() {
        return this.a.showOverflowMenu();
    }

    public boolean g() {
        return this.a.hideOverflowMenu();
    }

    public boolean h() {
        this.a.getViewGroup().removeCallbacks(this.g);
        ViewCompat.a(this.a.getViewGroup(), this.g);
        return true;
    }

    public boolean i() {
        if (!this.a.hasExpandedActionView()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    void j() {
        this.a.getViewGroup().removeCallbacks(this.g);
    }

    public Callback k() {
        return this.c;
    }

    void l() {
        Menu m = m();
        MenuBuilder menuBuilder = m instanceof MenuBuilder ? (MenuBuilder) m : null;
        if (menuBuilder != null) {
            menuBuilder.g();
        }
        try {
            m.clear();
            if (!(this.c.onCreatePanelMenu(0, m) && this.c.onPreparePanel(0, null, m))) {
                m.clear();
            }
            if (menuBuilder != null) {
                menuBuilder.h();
            }
        } catch (Throwable th) {
            if (menuBuilder != null) {
                menuBuilder.h();
            }
        }
    }
}
