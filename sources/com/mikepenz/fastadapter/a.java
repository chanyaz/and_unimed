package com.mikepenz.fastadapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.bo;
import android.support.v7.widget.bq;
import android.support.v7.widget.ce;
import android.view.ViewGroup;
import java.util.List;

public abstract class a<Item extends IItem> extends bo implements IAdapter<Item> {
    private FastAdapter<Item> a;

    public a a(FastAdapter fastAdapter) {
        this.a = fastAdapter;
        this.a.a(this);
        return this;
    }

    public a a(IAdapter iAdapter) {
        this.a = iAdapter.getFastAdapter();
        this.a.a(this);
        return this;
    }

    public void a(Item item) {
        this.a.a((IItem) item);
    }

    public void a(Iterable<Item> iterable) {
        if (iterable != null) {
            for (Item a : iterable) {
                a((IItem) a);
            }
        }
    }

    public FastAdapter<Item> getFastAdapter() {
        return this.a;
    }

    public Item getItem(int i) {
        return this.a.b(i);
    }

    public int getItemCount() {
        return this.a.getItemCount();
    }

    public long getItemId(int i) {
        return this.a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.a.getItemViewType(i);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.a.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(ce ceVar, int i) {
        this.a.onBindViewHolder(ceVar, i);
    }

    public void onBindViewHolder(ce ceVar, int i, List list) {
        this.a.onBindViewHolder(ceVar, i, list);
    }

    public ce onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.a.onCreateViewHolder(viewGroup, i);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.a.onDetachedFromRecyclerView(recyclerView);
    }

    public boolean onFailedToRecycleView(ce ceVar) {
        return this.a.onFailedToRecycleView(ceVar);
    }

    public void onViewAttachedToWindow(ce ceVar) {
        this.a.onViewAttachedToWindow(ceVar);
    }

    public void onViewDetachedFromWindow(ce ceVar) {
        this.a.onViewDetachedFromWindow(ceVar);
    }

    public void onViewRecycled(ce ceVar) {
        this.a.onViewRecycled(ceVar);
    }

    public void registerAdapterDataObserver(bq bqVar) {
        super.registerAdapterDataObserver(bqVar);
        if (this.a != null) {
            this.a.registerAdapterDataObserver(bqVar);
        }
    }

    public void setHasStableIds(boolean z) {
        this.a.setHasStableIds(z);
    }

    public void unregisterAdapterDataObserver(bq bqVar) {
        super.unregisterAdapterDataObserver(bqVar);
        if (this.a != null) {
            this.a.unregisterAdapterDataObserver(bqVar);
        }
    }
}
