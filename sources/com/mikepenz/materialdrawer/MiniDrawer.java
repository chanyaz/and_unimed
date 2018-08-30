package com.mikepenz.materialdrawer;

import android.support.annotation.NonNull;
import android.view.View;
import com.mikepenz.fastadapter.adapters.a;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;
import com.mikepenz.materialdrawer.model.g;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.j;
import com.mikepenz.materialdrawer.model.m;
import com.mikepenz.materialdrawer.model.p;
import com.mikepenz.materialdrawer.model.s;

public class MiniDrawer {
    protected a<IDrawerItem> a;
    protected boolean b = true;
    private Drawer c;
    private AccountHeader d;
    private ICrossfader e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = true;

    public interface OnMiniDrawerItemClickListener {
        boolean onItemClick(View view, int i, IDrawerItem iDrawerItem, int i2);
    }

    public MiniDrawer a(@NonNull AccountHeader accountHeader) {
        this.d = accountHeader;
        return this;
    }

    public MiniDrawer a(@NonNull Drawer drawer) {
        this.c = drawer;
        return this;
    }

    public MiniDrawer a(boolean z) {
        this.b = z;
        return this;
    }

    public IDrawerItem a(IDrawerItem iDrawerItem) {
        if (iDrawerItem instanceof s) {
            return this.h ? new g((s) iDrawerItem).b(this.i) : null;
        } else {
            if (iDrawerItem instanceof m) {
                return new g((m) iDrawerItem).b(this.i);
            }
            if (!(iDrawerItem instanceof p)) {
                return null;
            }
            IDrawerItem jVar = new j((p) iDrawerItem);
            jVar.withEnabled(this.j);
            return jVar;
        }
    }

    public void a() {
        if (this.e != null && this.e.isCrossfaded()) {
            this.e.crossfade();
        }
        if (this.d != null) {
            IProfile b = this.d.b();
            if (b instanceof IDrawerItem) {
                this.a.a(0, a((IDrawerItem) b));
            }
        }
    }

    public void a(long j) {
        int itemCount = this.a.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            IDrawerItem iDrawerItem = (IDrawerItem) this.a.b(i);
            if (iDrawerItem.getIdentifier() == j && !iDrawerItem.isSelected()) {
                this.a.c();
                this.a.g(i);
            }
        }
    }

    public boolean b(IDrawerItem iDrawerItem) {
        if (!iDrawerItem.isSelectable()) {
            return true;
        }
        if (this.e != null && this.e.isCrossfaded()) {
            this.e.crossfade();
        }
        a(iDrawerItem.getIdentifier());
        return false;
    }
}
