package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.design.e;
import android.support.design.i;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.as;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.y;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

@RestrictTo({Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter implements MenuPresenter {
    LinearLayout a;
    MenuBuilder b;
    d c;
    LayoutInflater d;
    int e;
    boolean f;
    ColorStateList g;
    ColorStateList h;
    Drawable i;
    int j;
    final OnClickListener k = new OnClickListener() {
        public void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            NavigationMenuPresenter.this.a(true);
            l itemData = navigationMenuItemView.getItemData();
            boolean a = NavigationMenuPresenter.this.b.a((MenuItem) itemData, NavigationMenuPresenter.this, 0);
            if (itemData != null && itemData.isCheckable() && a) {
                NavigationMenuPresenter.this.c.a(itemData);
            }
            NavigationMenuPresenter.this.a(false);
            NavigationMenuPresenter.this.updateMenuView(false);
        }
    };
    private NavigationMenuView l;
    private Callback m;
    private int n;
    private int o;

    interface NavigationMenuItem {
    }

    public int a() {
        return this.a.getChildCount();
    }

    public void a(int i) {
        this.n = i;
    }

    public void a(@Nullable ColorStateList colorStateList) {
        this.h = colorStateList;
        updateMenuView(false);
    }

    public void a(@Nullable Drawable drawable) {
        this.i = drawable;
        updateMenuView(false);
    }

    public void a(as asVar) {
        int b = asVar.b();
        if (this.o != b) {
            this.o = b;
            if (this.a.getChildCount() == 0) {
                this.l.setPadding(0, this.o, 0, this.l.getPaddingBottom());
            }
        }
        ViewCompat.b(this.a, asVar);
    }

    public void a(l lVar) {
        this.c.a(lVar);
    }

    public void a(@NonNull View view) {
        this.a.addView(view);
        this.l.setPadding(0, 0, 0, this.l.getPaddingBottom());
    }

    public void a(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }

    @Nullable
    public ColorStateList b() {
        return this.h;
    }

    public View b(@LayoutRes int i) {
        View inflate = this.d.inflate(i, this.a, false);
        a(inflate);
        return inflate;
    }

    public void b(@Nullable ColorStateList colorStateList) {
        this.g = colorStateList;
        updateMenuView(false);
    }

    @Nullable
    public ColorStateList c() {
        return this.g;
    }

    public void c(@StyleRes int i) {
        this.e = i;
        this.f = true;
        updateMenuView(false);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, l lVar) {
        return false;
    }

    @Nullable
    public Drawable d() {
        return this.i;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, l lVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.n;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.l == null) {
            this.l = (NavigationMenuView) this.d.inflate(i.design_navigation_menu, viewGroup, false);
            if (this.c == null) {
                this.c = new d(this);
            }
            this.a = (LinearLayout) this.d.inflate(i.design_navigation_item_header, this.l, false);
            this.l.setAdapter(this.c);
        }
        return this.l;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.d = LayoutInflater.from(context);
        this.b = menuBuilder;
        this.j = context.getResources().getDimensionPixelOffset(e.design_navigation_separator_vertical_padding);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.m != null) {
            this.m.onCloseMenu(menuBuilder, z);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.l.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.c.a(bundle2);
            }
            sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray != null) {
                this.a.restoreHierarchyState(sparseParcelableArray);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        SparseArray sparseArray;
        Parcelable bundle = new Bundle();
        if (this.l != null) {
            sparseArray = new SparseArray();
            this.l.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.c != null) {
            bundle.putBundle("android:menu:adapter", this.c.b());
        }
        if (this.a == null) {
            return bundle;
        }
        sparseArray = new SparseArray();
        this.a.saveHierarchyState(sparseArray);
        bundle.putSparseParcelableArray("android:menu:header", sparseArray);
        return bundle;
    }

    public boolean onSubMenuSelected(y yVar) {
        return false;
    }

    public void setCallback(Callback callback) {
        this.m = callback;
    }

    public void updateMenuView(boolean z) {
        if (this.c != null) {
            this.c.a();
        }
    }
}
