package android.support.v7.view.menu;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView.ItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class d implements MenuPresenter {
    protected Context a;
    protected Context b;
    protected MenuBuilder c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected MenuView f;
    private Callback g;
    private int h;
    private int i;
    private int j;

    public d(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    public Callback a() {
        return this.g;
    }

    public ItemView a(ViewGroup viewGroup) {
        return (ItemView) this.d.inflate(this.i, viewGroup, false);
    }

    public View a(l lVar, View view, ViewGroup viewGroup) {
        ItemView a = view instanceof ItemView ? (ItemView) view : a(viewGroup);
        a(lVar, a);
        return (View) a;
    }

    public void a(int i) {
        this.j = i;
    }

    public abstract void a(l lVar, ItemView itemView);

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    public boolean a(int i, l lVar) {
        return true;
    }

    protected boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
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
        if (this.f == null) {
            this.f = (MenuView) this.d.inflate(this.h, viewGroup, false);
            this.f.initialize(this.c);
            updateMenuView(true);
        }
        return this.f;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (this.g != null) {
            this.g.onCloseMenu(menuBuilder, z);
        }
    }

    public boolean onSubMenuSelected(y yVar) {
        return this.g != null ? this.g.onOpenSubMenu(yVar) : false;
    }

    public void setCallback(Callback callback) {
        this.g = callback;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup != null) {
            int i;
            if (this.c != null) {
                this.c.j();
                ArrayList i2 = this.c.i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    l lVar = (l) i2.get(i3);
                    if (a(i, lVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        l itemData = childAt instanceof ItemView ? ((ItemView) childAt).getItemData() : null;
                        View a = a(lVar, childAt, viewGroup);
                        if (lVar != itemData) {
                            a.setPressed(false);
                            a.jumpDrawablesToCurrentState();
                        }
                        if (a != childAt) {
                            a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }
}
