package com.mikepenz.fastadapter.adapters;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItem;

public class a<Item extends IItem> extends FastAdapter<Item> {
    private final ItemAdapter<Item> a = new ItemAdapter();

    public a() {
        this.a.a((FastAdapter) this);
    }

    public a<Item> a(int i, Item item) {
        this.a.set(i, (IItem) item);
        return this;
    }
}
