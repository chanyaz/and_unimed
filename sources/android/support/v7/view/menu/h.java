package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

@RestrictTo({Scope.LIBRARY_GROUP})
public class h implements MenuPresenter, OnItemClickListener {
    Context a;
    LayoutInflater b;
    MenuBuilder c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    i h;
    private Callback i;
    private int j;

    public h(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    public h(Context context, int i) {
        this(i, 0);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new i(this);
        }
        return this.h;
    }

    public void a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        if (this.d != null) {
            this.d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, l lVar) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, l lVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.j;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(android.support.v7.a.h.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new i(this);
            }
            this.d.setAdapter(this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.f != 0) {
            this.a = new ContextThemeWrapper(context, this.f);
            this.b = LayoutInflater.from(this.a);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(this.a);
            }
        }
        this.c = menuBuilder;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.i != null) {
            this.i.onCloseMenu(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.getItem(i), (MenuPresenter) this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        b((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.d == null) {
            return null;
        }
        Parcelable bundle = new Bundle();
        a(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(y yVar) {
        if (!yVar.hasVisibleItems()) {
            return false;
        }
        new k(yVar).a(null);
        if (this.i != null) {
            this.i.onOpenSubMenu(yVar);
        }
        return true;
    }

    public void setCallback(Callback callback) {
        this.i = callback;
    }

    public void updateMenuView(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }
}
