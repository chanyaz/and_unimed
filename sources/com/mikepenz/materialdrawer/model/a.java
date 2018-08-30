package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.v7.widget.ce;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.fastadapter.utils.b;
import com.mikepenz.materialdrawer.Drawer.OnDrawerItemClickListener;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.OnPostBindViewListener;
import com.mikepenz.materialdrawer.model.interfaces.Selectable;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import java.util.List;

public abstract class a<T, VH extends ce> implements IExpandable<T, IDrawerItem>, IDrawerItem<T, VH>, Selectable<T>, Tagable<T> {
    protected long a = -1;
    protected Object b;
    protected boolean c = true;
    protected boolean d = false;
    protected boolean e = true;
    public OnDrawerItemClickListener f = null;
    protected OnPostBindViewListener g = null;
    protected List<IDrawerItem> h;
    private boolean i = false;

    public OnDrawerItemClickListener a() {
        return this.f;
    }

    public void a(IDrawerItem iDrawerItem, View view) {
        if (this.g != null) {
            this.g.onBindView(iDrawerItem, view);
        }
    }

    public abstract ViewHolderFactory<VH> b();

    public boolean equals(int i) {
        return ((long) i) == this.a;
    }

    public boolean equals(long j) {
        return j == this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a == ((a) obj).a;
    }

    public View generateView(Context context) {
        ce create = b().create(LayoutInflater.from(context).inflate(getLayoutRes(), null, false));
        bindView(create);
        return create.itemView;
    }

    public View generateView(Context context, ViewGroup viewGroup) {
        ce create = b().create(LayoutInflater.from(context).inflate(getLayoutRes(), viewGroup, false));
        bindView(create);
        return create.itemView;
    }

    public long getIdentifier() {
        return this.a;
    }

    public List<IDrawerItem> getSubItems() {
        return this.h;
    }

    public Object getTag() {
        return this.b;
    }

    public VH getViewHolder(ViewGroup viewGroup) {
        return b().create(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutRes(), viewGroup, false));
    }

    public int hashCode() {
        return Long.valueOf(this.a).hashCode();
    }

    public boolean isAutoExpanding() {
        return true;
    }

    public boolean isEnabled() {
        return this.c;
    }

    public boolean isExpanded() {
        return this.i;
    }

    public boolean isSelectable() {
        return this.e;
    }

    public boolean isSelected() {
        return this.d;
    }

    public T withEnabled(boolean z) {
        this.c = z;
        return this;
    }

    public T withIdentifier(long j) {
        this.a = j;
        return this;
    }

    public T withIsExpanded(boolean z) {
        this.i = z;
        return this;
    }

    public T withSelectable(boolean z) {
        this.e = z;
        return this;
    }

    public T withSetSelected(boolean z) {
        this.d = z;
        return this;
    }

    public T withSubItems(List<IDrawerItem> list) {
        this.h = b.a((List) list);
        return this;
    }

    public T withTag(Object obj) {
        this.b = obj;
        return this;
    }
}
