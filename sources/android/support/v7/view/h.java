package android.support.v7.view;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.a.k;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.m;
import android.support.v7.widget.an;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

class h {
    private String A;
    private String B;
    private CharSequence C;
    private CharSequence D;
    private ColorStateList E = null;
    private Mode F = null;
    ActionProvider a;
    final /* synthetic */ f b;
    private Menu c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private CharSequence m;
    private CharSequence n;
    private int o;
    private char p;
    private int q;
    private char r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private String z;

    public h(f fVar, Menu menu) {
        this.b = fVar;
        this.c = menu;
        a();
    }

    private char a(String str) {
        return str == null ? 0 : str.charAt(0);
    }

    private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Constructor constructor = this.b.e.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    private void a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
        if (this.x >= 0) {
            menuItem.setShowAsAction(this.x);
        }
        if (this.B != null) {
            if (this.b.e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new g(this.b.a(), this.B));
        }
        if (menuItem instanceof l) {
            l lVar = (l) menuItem;
        }
        if (this.t >= 2) {
            if (menuItem instanceof l) {
                ((l) menuItem).a(true);
            } else if (menuItem instanceof m) {
                ((m) menuItem).a(true);
            }
        }
        if (this.z != null) {
            menuItem.setActionView((View) a(this.z, f.a, this.b.c));
        } else {
            z = false;
        }
        if (this.y > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(this.y);
            }
        }
        if (this.a != null) {
            MenuItemCompat.a(menuItem, this.a);
        }
        MenuItemCompat.a(menuItem, this.C);
        MenuItemCompat.b(menuItem, this.D);
        MenuItemCompat.b(menuItem, this.p, this.q);
        MenuItemCompat.a(menuItem, this.r, this.s);
        if (this.F != null) {
            MenuItemCompat.a(menuItem, this.F);
        }
        if (this.E != null) {
            MenuItemCompat.a(menuItem, this.E);
        }
    }

    public void a() {
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = true;
        this.i = true;
    }

    public void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.b.e.obtainStyledAttributes(attributeSet, k.MenuGroup);
        this.d = obtainStyledAttributes.getResourceId(k.MenuGroup_android_id, 0);
        this.e = obtainStyledAttributes.getInt(k.MenuGroup_android_menuCategory, 0);
        this.f = obtainStyledAttributes.getInt(k.MenuGroup_android_orderInCategory, 0);
        this.g = obtainStyledAttributes.getInt(k.MenuGroup_android_checkableBehavior, 0);
        this.h = obtainStyledAttributes.getBoolean(k.MenuGroup_android_visible, true);
        this.i = obtainStyledAttributes.getBoolean(k.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }

    public void b() {
        this.j = true;
        a(this.c.add(this.d, this.k, this.l, this.m));
    }

    public void b(AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = this.b.e.obtainStyledAttributes(attributeSet, k.MenuItem);
        this.k = obtainStyledAttributes.getResourceId(k.MenuItem_android_id, 0);
        this.l = (obtainStyledAttributes.getInt(k.MenuItem_android_menuCategory, this.e) & -65536) | (obtainStyledAttributes.getInt(k.MenuItem_android_orderInCategory, this.f) & 65535);
        this.m = obtainStyledAttributes.getText(k.MenuItem_android_title);
        this.n = obtainStyledAttributes.getText(k.MenuItem_android_titleCondensed);
        this.o = obtainStyledAttributes.getResourceId(k.MenuItem_android_icon, 0);
        this.p = a(obtainStyledAttributes.getString(k.MenuItem_android_alphabeticShortcut));
        this.q = obtainStyledAttributes.getInt(k.MenuItem_alphabeticModifiers, 4096);
        this.r = a(obtainStyledAttributes.getString(k.MenuItem_android_numericShortcut));
        this.s = obtainStyledAttributes.getInt(k.MenuItem_numericModifiers, 4096);
        if (obtainStyledAttributes.hasValue(k.MenuItem_android_checkable)) {
            this.t = obtainStyledAttributes.getBoolean(k.MenuItem_android_checkable, false) ? 1 : 0;
        } else {
            this.t = this.g;
        }
        this.u = obtainStyledAttributes.getBoolean(k.MenuItem_android_checked, false);
        this.v = obtainStyledAttributes.getBoolean(k.MenuItem_android_visible, this.h);
        this.w = obtainStyledAttributes.getBoolean(k.MenuItem_android_enabled, this.i);
        this.x = obtainStyledAttributes.getInt(k.MenuItem_showAsAction, -1);
        this.B = obtainStyledAttributes.getString(k.MenuItem_android_onClick);
        this.y = obtainStyledAttributes.getResourceId(k.MenuItem_actionLayout, 0);
        this.z = obtainStyledAttributes.getString(k.MenuItem_actionViewClass);
        this.A = obtainStyledAttributes.getString(k.MenuItem_actionProviderClass);
        if (this.A == null) {
            z = false;
        }
        if (z && this.y == 0 && this.z == null) {
            this.a = (ActionProvider) a(this.A, f.b, this.b.d);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.a = null;
        }
        this.C = obtainStyledAttributes.getText(k.MenuItem_contentDescription);
        this.D = obtainStyledAttributes.getText(k.MenuItem_tooltipText);
        if (obtainStyledAttributes.hasValue(k.MenuItem_iconTintMode)) {
            this.F = an.a(obtainStyledAttributes.getInt(k.MenuItem_iconTintMode, -1), this.F);
        } else {
            this.F = null;
        }
        if (obtainStyledAttributes.hasValue(k.MenuItem_iconTint)) {
            this.E = obtainStyledAttributes.getColorStateList(k.MenuItem_iconTint);
        } else {
            this.E = null;
        }
        obtainStyledAttributes.recycle();
        this.j = false;
    }

    public SubMenu c() {
        this.j = true;
        SubMenu addSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
        a(addSubMenu.getItem());
        return addSubMenu;
    }

    public boolean d() {
        return this.j;
    }
}
