package com.mikepenz.materialdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.materialdrawer.a.c;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem.Position;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import java.util.List;

public class Drawer {
    protected final b a;
    private OnDrawerItemClickListener b;
    private OnDrawerItemLongClickListener c;
    private List<IDrawerItem> d;
    private Bundle e;

    public interface OnDrawerItemClickListener {
        boolean onItemClick(View view, int i, IDrawerItem iDrawerItem);
    }

    public interface OnDrawerItemLongClickListener {
        boolean onItemLongClick(View view, int i, IDrawerItem iDrawerItem);
    }

    public interface OnDrawerItemSelectedListener {
        void onItemSelected(AdapterView<?> adapterView, View view, int i, long j, IDrawerItem iDrawerItem);

        void onNothingSelected(AdapterView<?> adapterView);
    }

    public interface OnDrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);
    }

    public interface OnDrawerNavigationListener {
        boolean onNavigationClickListener(View view);
    }

    protected Drawer(b bVar) {
        this.a = bVar;
    }

    private void a(@NonNull List<IDrawerItem> list, boolean z) {
        if (!(this.d == null || z)) {
            this.d = list;
        }
        this.a.b().setNewList(list);
    }

    private View k() {
        return this.a.O;
    }

    protected b a() {
        return this.a;
    }

    public void a(@NonNull View view, boolean z, boolean z2) {
        a(view, z, z2, null);
    }

    public void a(@NonNull View view, boolean z, boolean z2, c cVar) {
        this.a.c().clear();
        if (z) {
            this.a.c().add(new ContainerDrawerItem().a(view).a(z2).a(cVar).a(Position.TOP));
        } else {
            this.a.c().add(new ContainerDrawerItem().a(view).a(z2).a(cVar).a(Position.NONE));
        }
        this.a.U.setPadding(this.a.U.getPaddingLeft(), 0, this.a.U.getPaddingRight(), this.a.U.getPaddingBottom());
    }

    public void a(OnDrawerItemClickListener onDrawerItemClickListener) {
        this.a.ai = onDrawerItemClickListener;
    }

    public void a(@NonNull OnDrawerItemClickListener onDrawerItemClickListener, OnDrawerItemLongClickListener onDrawerItemLongClickListener, @NonNull List<IDrawerItem> list, int i) {
        if (!i()) {
            this.b = g();
            this.c = h();
            this.e = c().b(new Bundle());
            c().f(false);
            this.d = d();
        }
        a(onDrawerItemClickListener);
        a(onDrawerItemLongClickListener);
        a((List) list, true);
        a(i, false);
        if (e() != null) {
            e().setVisibility(8);
        }
        if (k() != null) {
            k().setVisibility(8);
        }
    }

    public void a(OnDrawerItemLongClickListener onDrawerItemLongClickListener) {
        this.a.aj = onDrawerItemLongClickListener;
    }

    public void a(@NonNull List<IDrawerItem> list) {
        a((List) list, false);
    }

    public void a(@NonNull IDrawerItem... iDrawerItemArr) {
        this.a.b().add((IItem[]) iDrawerItemArr);
    }

    public boolean a(int i) {
        return a(i, true);
    }

    public boolean a(int i, boolean z) {
        if (this.a.U != null) {
            this.a.X.c();
            this.a.X.a(i, false);
            if (this.a.ai != null && z && i >= 0) {
                this.a.ai.onItemClick(null, i, (IDrawerItem) this.a.X.b(i));
            }
            this.a.h();
        }
        return false;
    }

    public void b() {
        if (this.a.p != null) {
            this.a.p.f(this.a.w.intValue());
        }
    }

    public FastAdapter<IDrawerItem> c() {
        return this.a.X;
    }

    public List<IDrawerItem> d() {
        return this.a.b().getAdapterItems();
    }

    public View e() {
        return this.a.M;
    }

    public ActionBarDrawerToggle f() {
        return this.a.B;
    }

    public OnDrawerItemClickListener g() {
        return this.a.ai;
    }

    public OnDrawerItemLongClickListener h() {
        return this.a.aj;
    }

    public boolean i() {
        return (this.b == null && this.d == null && this.e == null) ? false : true;
    }

    public void j() {
        if (i()) {
            a(this.b);
            a(this.c);
            a(this.d, true);
            c().a(this.e);
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.a.U.c(0);
            if (e() != null) {
                e().setVisibility(0);
            }
            if (k() != null) {
                k().setVisibility(0);
            }
            if (this.a.x != null && this.a.x.a != null) {
                this.a.x.a.o = false;
            }
        }
    }
}
