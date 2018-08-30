package com.github.ksoichiro.android.observablescrollview;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class b implements Filterable, WrapperListAdapter {
    static final ArrayList<a> a = new ArrayList();
    ArrayList<a> b;
    ArrayList<a> c;
    boolean d;
    private final DataSetObservable e = new DataSetObservable();
    private final ListAdapter f;
    private int g = 1;
    private int h = -1;
    private final boolean i;
    private boolean j = true;
    private boolean k = false;

    public b(ArrayList<a> arrayList, ArrayList<a> arrayList2, ListAdapter listAdapter) {
        boolean z = true;
        this.f = listAdapter;
        this.i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.b = a;
        } else {
            this.b = arrayList;
        }
        if (arrayList2 == null) {
            this.c = a;
        } else {
            this.c = arrayList2;
        }
        if (!(a(this.b) && a(this.c))) {
            z = false;
        }
        this.d = z;
    }

    private boolean a(ArrayList<a> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((a) it.next()).c) {
                    return false;
                }
            }
        }
        return true;
    }

    private int d() {
        return (int) (Math.ceil((double) ((1.0f * ((float) this.f.getCount())) / ((float) this.g))) * ((double) this.g));
    }

    public int a() {
        return this.b.size();
    }

    public void a(int i) {
        if (i >= 1 && this.g != i) {
            this.g = i;
            c();
        }
    }

    public boolean areAllItemsEnabled() {
        return this.f == null || (this.d && this.f.areAllItemsEnabled());
    }

    public int b() {
        return this.c.size();
    }

    public void c() {
        this.e.notifyChanged();
    }

    public int getCount() {
        return this.f != null ? ((b() + a()) * this.g) + d() : (b() + a()) * this.g;
    }

    public Filter getFilter() {
        return this.i ? ((Filterable) this.f).getFilter() : null;
    }

    public Object getItem(int i) {
        int a = a() * this.g;
        if (i < a) {
            return i % this.g == 0 ? ((a) this.b.get(i / this.g)).b : null;
        } else {
            int i2 = i - a;
            a = 0;
            if (this.f != null) {
                a = d();
                if (i2 < a) {
                    return i2 < this.f.getCount() ? this.f.getItem(i2) : null;
                }
            }
            a = i2 - a;
            return a % this.g == 0 ? ((a) this.c.get(a)).b : null;
        }
    }

    public long getItemId(int i) {
        int a = a() * this.g;
        if (this.f != null && i >= a) {
            a = i - a;
            if (a < this.f.getCount()) {
                return this.f.getItemId(a);
            }
        }
        return -1;
    }

    public int getItemViewType(int i) {
        int i2 = 0;
        int a = a() * this.g;
        int viewTypeCount = this.f == null ? 0 : this.f.getViewTypeCount() - 1;
        int i3 = -2;
        if (this.j && i < a) {
            if (i == 0 && this.k) {
                i3 = (((this.b.size() + viewTypeCount) + this.c.size()) + 1) + 1;
            }
            if (i % this.g != 0) {
                i3 = ((i / this.g) + 1) + viewTypeCount;
            }
        }
        a = i - a;
        if (this.f != null) {
            i2 = d();
            if (a >= 0 && a < i2) {
                if (a < this.f.getCount()) {
                    i3 = this.f.getItemViewType(a);
                } else if (this.j) {
                    i3 = (this.b.size() + viewTypeCount) + 1;
                }
            }
        }
        if (!this.j) {
            return i3;
        }
        i2 = a - i2;
        return (i2 < 0 || i2 >= getCount() || i2 % this.g == 0) ? i3 : ((viewTypeCount + this.b.size()) + 1) + ((i2 / this.g) + 1);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int a = a() * this.g;
        View view2;
        if (i < a) {
            view2 = ((a) this.b.get(i / this.g)).a;
            if (i % this.g == 0) {
                return view2;
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            view.setMinimumHeight(view2.getHeight());
            return view;
        }
        int i2 = i - a;
        a = 0;
        if (this.f != null) {
            a = d();
            if (i2 < a) {
                if (i2 < this.f.getCount()) {
                    return this.f.getView(i2, view, viewGroup);
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(this.h);
                return view;
            }
        }
        a = i2 - a;
        if (a < getCount()) {
            view2 = ((a) this.c.get(a / this.g)).a;
            if (i % this.g == 0) {
                return view2;
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            view.setMinimumHeight(view2.getHeight());
            return view;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public int getViewTypeCount() {
        int viewTypeCount = this.f == null ? 1 : this.f.getViewTypeCount();
        if (!this.j) {
            return viewTypeCount;
        }
        int size = (this.b.size() + 1) + this.c.size();
        if (this.k) {
            size++;
        }
        return viewTypeCount + size;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f;
    }

    public boolean hasStableIds() {
        return this.f != null && this.f.hasStableIds();
    }

    public boolean isEmpty() {
        return this.f == null || this.f.isEmpty();
    }

    public boolean isEnabled(int i) {
        int a = a() * this.g;
        if (i < a) {
            boolean z = i % this.g == 0 && ((a) this.b.get(i / this.g)).c;
            return z;
        }
        int i2 = i - a;
        if (this.f != null) {
            a = d();
            if (i2 < a) {
                return i2 < this.f.getCount() && this.f.isEnabled(i2);
            }
        } else {
            a = 0;
        }
        a = i2 - a;
        return a % this.g == 0 && ((a) this.c.get(a / this.g)).c;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.e.registerObserver(dataSetObserver);
        if (this.f != null) {
            this.f.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.e.unregisterObserver(dataSetObserver);
        if (this.f != null) {
            this.f.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
