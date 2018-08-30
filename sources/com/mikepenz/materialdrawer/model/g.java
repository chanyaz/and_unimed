package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView.LayoutParams;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.materialdrawer.a.a;
import com.mikepenz.materialdrawer.a.c;
import com.mikepenz.materialdrawer.a.e;
import com.mikepenz.materialdrawer.i;
import com.mikepenz.materialdrawer.j;
import com.mikepenz.materialize.b.d;
import com.mikepenz.materialize.c.b;

public class g extends b<g, i> {
    protected c w;
    private e x;
    private a y = new a();
    private boolean z = false;

    public g(m mVar) {
        this.a = mVar.a;
        this.b = mVar.b;
        this.x = mVar.w;
        this.y = mVar.x;
        this.c = mVar.c;
        this.e = mVar.e;
        this.d = mVar.d;
        this.i = mVar.i;
        this.j = mVar.j;
        this.l = mVar.l;
        this.m = mVar.m;
        this.q = mVar.q;
        this.r = mVar.r;
        this.s = mVar.s;
    }

    public g(s sVar) {
        this.a = sVar.a;
        this.b = sVar.b;
        this.x = sVar.w;
        this.y = sVar.x;
        this.c = sVar.c;
        this.e = sVar.e;
        this.d = sVar.d;
        this.i = sVar.i;
        this.j = sVar.j;
        this.l = sVar.l;
        this.m = sVar.m;
        this.q = sVar.q;
        this.r = sVar.r;
        this.s = sVar.s;
    }

    /* renamed from: a */
    public void bindView(i iVar) {
        Context context = iVar.itemView.getContext();
        if (this.w != null) {
            LayoutParams layoutParams = (LayoutParams) iVar.itemView.getLayoutParams();
            layoutParams.height = this.w.a(context);
            iVar.itemView.setLayoutParams(layoutParams);
        }
        iVar.itemView.setId(hashCode());
        iVar.itemView.setEnabled(isEnabled());
        iVar.itemView.setSelected(isSelected());
        iVar.itemView.setTag(this);
        int d = d(context);
        int e = e(context);
        if (this.z) {
            b.a(iVar.m, b.a(context, a(context), true));
        }
        if (d.b(this.x, iVar.o)) {
            this.y.a(iVar.o);
        }
        com.mikepenz.materialize.b.c.a(com.mikepenz.materialdrawer.a.d.a(getIcon(), context, d, g(), 1), d, com.mikepenz.materialdrawer.a.d.a(h(), context, e, g(), 1), e, g(), iVar.n);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.mikepenz.materialdrawer.g.material_drawer_padding);
        d = context.getResources().getDimensionPixelSize(com.mikepenz.materialdrawer.g.material_mini_drawer_item_padding);
        iVar.itemView.setPadding(dimensionPixelSize, d, dimensionPixelSize, d);
        a(this, iVar.itemView);
    }

    public ViewHolderFactory<i> b() {
        return new h();
    }

    public g b(boolean z) {
        this.z = z;
        return this;
    }

    @LayoutRes
    public int getLayoutRes() {
        return j.material_drawer_item_mini;
    }

    public int getType() {
        return i.material_drawer_item_mini;
    }
}
