package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.materialdrawer.a.a;
import com.mikepenz.materialdrawer.a.e;
import com.mikepenz.materialdrawer.i;
import com.mikepenz.materialdrawer.j;
import com.mikepenz.materialdrawer.model.interfaces.ColorfulBadgeable;
import com.mikepenz.materialize.b.d;

public class m extends c<m, o> implements ColorfulBadgeable<m> {
    protected e w;
    protected a x = new a();

    /* renamed from: a */
    public m withBadgeStyle(a aVar) {
        this.x = aVar;
        return this;
    }

    /* renamed from: a */
    public m withBadge(e eVar) {
        this.w = eVar;
        return this;
    }

    /* renamed from: a */
    public m withBadge(String str) {
        this.w = new e(str);
        return this;
    }

    /* renamed from: a */
    public void bindView(o oVar) {
        Context context = oVar.itemView.getContext();
        a(oVar);
        if (d.b(this.w, oVar.r)) {
            this.x.a(oVar.r, a(b(context), c(context)));
            oVar.q.setVisibility(0);
        } else {
            oVar.q.setVisibility(8);
        }
        if (getTypeface() != null) {
            oVar.r.setTypeface(getTypeface());
        }
        a(this, oVar.itemView);
    }

    public ViewHolderFactory<o> b() {
        return new n();
    }

    /* renamed from: f */
    public m withBadge(@StringRes int i) {
        this.w = new e(i);
        return this;
    }

    public e getBadge() {
        return this.w;
    }

    public a getBadgeStyle() {
        return this.x;
    }

    @LayoutRes
    public int getLayoutRes() {
        return j.material_drawer_item_primary;
    }

    public int getType() {
        return i.material_drawer_item_primary;
    }
}
