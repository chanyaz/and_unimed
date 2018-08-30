package android.support.v7.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.y;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;

class dc implements MenuPresenter {
    MenuBuilder a;
    l b;
    final /* synthetic */ Toolbar c;

    dc(Toolbar toolbar) {
        this.c = toolbar;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, l lVar) {
        if (this.c.b instanceof CollapsibleActionView) {
            ((CollapsibleActionView) this.c.b).onActionViewCollapsed();
        }
        this.c.removeView(this.c.b);
        this.c.removeView(this.c.a);
        this.c.b = null;
        this.c.m();
        this.b = null;
        this.c.requestLayout();
        lVar.e(false);
        return true;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, l lVar) {
        this.c.j();
        ViewParent parent = this.c.a.getParent();
        if (parent != this.c) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.c.a);
            }
            this.c.addView(this.c.a);
        }
        this.c.b = lVar.getActionView();
        this.b = lVar;
        parent = this.c.b.getParent();
        if (parent != this.c) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.c.b);
            }
            LayoutParams k = this.c.generateDefaultLayoutParams();
            k.a = 8388611 | (this.c.c & 112);
            k.b = 2;
            this.c.b.setLayoutParams(k);
            this.c.addView(this.c.b);
        }
        this.c.l();
        this.c.requestLayout();
        lVar.e(true);
        if (this.c.b instanceof CollapsibleActionView) {
            ((CollapsibleActionView) this.c.b).onActionViewExpanded();
        }
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        return null;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (!(this.a == null || this.b == null)) {
            this.a.d(this.b);
        }
        this.a = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(y yVar) {
        return false;
    }

    public void setCallback(Callback callback) {
    }

    public void updateMenuView(boolean z) {
        Object obj = null;
        if (this.b != null) {
            if (this.a != null) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    if (this.a.getItem(i) == this.b) {
                        obj = 1;
                        break;
                    }
                }
            }
            if (obj == null) {
                collapseItemActionView(this.a, this.b);
            }
        }
    }
}
