package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.a.h;
import android.support.v7.view.menu.MenuView.ItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public class j extends BaseAdapter {
    static final int a = h.abc_popup_menu_item_layout;
    MenuBuilder b;
    private int c = -1;
    private boolean d;
    private final boolean e;
    private final LayoutInflater f;

    public j(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z) {
        this.e = z;
        this.f = layoutInflater;
        this.b = menuBuilder;
        b();
    }

    public MenuBuilder a() {
        return this.b;
    }

    /* renamed from: a */
    public l getItem(int i) {
        ArrayList l = this.e ? this.b.l() : this.b.i();
        if (this.c >= 0 && i >= this.c) {
            i++;
        }
        return (l) l.get(i);
    }

    public void a(boolean z) {
        this.d = z;
    }

    void b() {
        l r = this.b.r();
        if (r != null) {
            ArrayList l = this.b.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((l) l.get(i)) == r) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    public int getCount() {
        ArrayList l = this.e ? this.b.l() : this.b.i();
        return this.c < 0 ? l.size() : l.size() - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f.inflate(a, viewGroup, false) : view;
        ItemView itemView = (ItemView) inflate;
        if (this.d) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        itemView.initialize(getItem(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
