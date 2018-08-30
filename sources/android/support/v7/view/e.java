package android.support.v7.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.s;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.menu.v;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public class e implements Callback {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<d> c = new ArrayList();
    final s<Menu, Menu> d = new s();

    public e(Context context, ActionMode.Callback callback) {
        this.b = context;
        this.a = callback;
    }

    private Menu a(Menu menu) {
        Menu menu2 = (Menu) this.d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = v.a(this.b, (SupportMenu) menu);
        this.d.put(menu, menu2);
        return menu2;
    }

    public ActionMode a(ActionMode actionMode) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) this.c.get(i);
            if (dVar != null && dVar.b == actionMode) {
                return dVar;
            }
        }
        ActionMode dVar2 = new d(this.b, actionMode);
        this.c.add(dVar2);
        return dVar2;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.a.onActionItemClicked(a(actionMode), v.a(this.b, (SupportMenuItem) menuItem));
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.a.onCreateActionMode(a(actionMode), a(menu));
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.a.onDestroyActionMode(a(actionMode));
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.a.onPrepareActionMode(a(actionMode), a(menu));
    }
}
