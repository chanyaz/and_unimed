package com.mikepenz.fastadapter.adapters;

import com.mikepenz.fastadapter.IItem;

public class b<Item extends IItem> extends ItemAdapter<Item> {
    public int getOrder() {
        return 1000;
    }
}
