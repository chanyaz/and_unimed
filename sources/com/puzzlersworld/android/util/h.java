package com.puzzlersworld.android.util;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class h implements ListAdapter, SpinnerAdapter {
    protected SpinnerAdapter a;
    protected Context b;
    protected int c;
    protected int d;
    protected LayoutInflater e;
    private String f;
    private View g;

    public h(SpinnerAdapter spinnerAdapter, int i, int i2, Context context) {
        this.g = null;
        this.a = spinnerAdapter;
        this.b = context;
        this.c = i;
        this.d = i2;
        this.e = LayoutInflater.from(context);
    }

    public h(SpinnerAdapter spinnerAdapter, int i, Context context, String str) {
        this(spinnerAdapter, i, -1, context);
        this.f = str;
    }

    public View a() {
        return this.g;
    }

    protected View a(ViewGroup viewGroup) {
        if (this.g == null) {
            this.g = this.e.inflate(this.c, viewGroup, false);
            if (this.g instanceof TextView) {
                ((TextView) this.g).setText(this.f);
            }
        }
        return this.g;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    protected View b(ViewGroup viewGroup) {
        return this.e.inflate(this.d, viewGroup, false);
    }

    public int getCount() {
        int count = this.a.getCount();
        return count == 0 ? 0 : count + 1;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return i == 0 ? this.d == -1 ? new View(this.b) : b(viewGroup) : this.a.getDropDownView(i - 1, null, viewGroup);
    }

    public Object getItem(int i) {
        return i == 0 ? null : this.a.getItem(i - 1);
    }

    public long getItemId(int i) {
        return i >= 1 ? this.a.getItemId(i - 1) : (long) (i - 1);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return i == 0 ? a(viewGroup) : this.a.getView(i - 1, null, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return this.a.hasStableIds();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public boolean isEnabled(int i) {
        return i != 0;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.a.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.a.unregisterDataSetObserver(dataSetObserver);
    }
}
