package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.mikepenz.materialdrawer.a.b;
import com.mikepenz.materialdrawer.a.e;
import com.mikepenz.materialize.b.a;
import com.mikepenz.materialize.b.d;

public abstract class c<T, VH extends d> extends b<T, VH> {
    private e w;
    private b x;

    protected void a(d dVar) {
        Context context = dVar.itemView.getContext();
        dVar.itemView.setId(hashCode());
        dVar.itemView.setSelected(isSelected());
        dVar.itemView.setEnabled(isEnabled());
        dVar.itemView.setTag(this);
        int a = a(context);
        ColorStateList a2 = a(b(context), c(context));
        int d = d(context);
        int e = e(context);
        com.mikepenz.materialize.c.b.a(dVar.m, com.mikepenz.materialize.c.b.a(context, a, true));
        d.a(getName(), dVar.o);
        d.b(m(), dVar.p);
        dVar.o.setTextColor(a2);
        a.a(n(), dVar.p, a2);
        if (getTypeface() != null) {
            dVar.o.setTypeface(getTypeface());
            dVar.p.setTypeface(getTypeface());
        }
        Drawable a3 = com.mikepenz.materialdrawer.a.d.a(getIcon(), context, d, g(), 1);
        if (a3 != null) {
            com.mikepenz.materialize.b.c.a(a3, d, com.mikepenz.materialdrawer.a.d.a(h(), context, e, g(), 1), e, g(), dVar.n);
        } else {
            com.mikepenz.materialdrawer.a.d.a(getIcon(), dVar.n, d, g(), 1);
        }
        com.mikepenz.materialdrawer.util.b.a(dVar.m, this.v);
    }

    public e m() {
        return this.w;
    }

    public b n() {
        return this.x;
    }
}
