package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.materialdrawer.a.c;
import com.mikepenz.materialdrawer.e;
import com.mikepenz.materialdrawer.f;
import com.mikepenz.materialdrawer.g;
import com.mikepenz.materialdrawer.i;
import com.mikepenz.materialdrawer.j;
import com.mikepenz.materialize.c.b;

public class ContainerDrawerItem extends a<ContainerDrawerItem, f> {
    private c i;
    private View j;
    private Position k = Position.TOP;
    private boolean l = true;

    public enum Position {
        TOP,
        BOTTOM,
        NONE
    }

    public ContainerDrawerItem a(View view) {
        this.j = view;
        return this;
    }

    public ContainerDrawerItem a(c cVar) {
        this.i = cVar;
        return this;
    }

    public ContainerDrawerItem a(Position position) {
        this.k = position;
        return this;
    }

    public ContainerDrawerItem a(boolean z) {
        this.l = z;
        return this;
    }

    /* renamed from: a */
    public void bindView(f fVar) {
        Context context = fVar.itemView.getContext();
        fVar.itemView.setId(hashCode());
        fVar.m.setEnabled(false);
        if (this.j.getParent() != null) {
            ((ViewGroup) this.j.getParent()).removeView(this.j);
        }
        if (this.i != null) {
            LayoutParams layoutParams = (LayoutParams) fVar.m.getLayoutParams();
            layoutParams.height = this.i.a(context);
            fVar.m.setLayoutParams(layoutParams);
        }
        ((ViewGroup) fVar.m).removeAllViews();
        int i = this.l ? 1 : 0;
        View view = new View(context);
        view.setMinimumHeight(i);
        view.setBackgroundColor(b.a(context, e.material_drawer_divider, f.material_drawer_divider));
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) b.a((float) i, context));
        if (this.k == Position.TOP) {
            ((ViewGroup) fVar.m).addView(this.j, -1, -2);
            layoutParams2.bottomMargin = context.getResources().getDimensionPixelSize(g.material_drawer_padding);
            ((ViewGroup) fVar.m).addView(view, layoutParams2);
        } else if (this.k == Position.BOTTOM) {
            layoutParams2.topMargin = context.getResources().getDimensionPixelSize(g.material_drawer_padding);
            ((ViewGroup) fVar.m).addView(view, layoutParams2);
            ((ViewGroup) fVar.m).addView(this.j);
        } else {
            ((ViewGroup) fVar.m).addView(this.j);
        }
        a(this, fVar.itemView);
    }

    public ViewHolderFactory<f> b() {
        return new e();
    }

    @LayoutRes
    public int getLayoutRes() {
        return j.material_drawer_item_container;
    }

    public int getType() {
        return i.material_drawer_item_container;
    }
}
