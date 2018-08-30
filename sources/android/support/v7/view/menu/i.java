package android.support.v7.view.menu;

import android.support.v7.view.menu.MenuView.ItemView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class i extends BaseAdapter {
    final /* synthetic */ h a;
    private int b = -1;

    public i(h hVar) {
        this.a = hVar;
        a();
    }

    /* renamed from: a */
    public l getItem(int i) {
        ArrayList l = this.a.c.l();
        int i2 = this.a.e + i;
        if (this.b >= 0 && i2 >= this.b) {
            i2++;
        }
        return (l) l.get(i2);
    }

    void a() {
        l r = this.a.c.r();
        if (r != null) {
            ArrayList l = this.a.c.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((l) l.get(i)) == r) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public int getCount() {
        int size = this.a.c.l().size() - this.a.e;
        return this.b < 0 ? size : size - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.a.b.inflate(this.a.g, viewGroup, false) : view;
        ((ItemView) inflate).initialize(getItem(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
