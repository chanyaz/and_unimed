package com.mikepenz.fastadapter.adapters;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.mikepenz.fastadapter.IItem;
import java.util.ArrayList;
import java.util.List;

public class d extends Filter {
    final /* synthetic */ ItemAdapter a;
    private List<Item> b;
    private CharSequence c;

    public d(ItemAdapter itemAdapter) {
        this.a = itemAdapter;
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        if (this.a.getFastAdapter().a()) {
            this.a.getFastAdapter().c();
        }
        this.a.getFastAdapter().f(false);
        this.c = charSequence;
        if (this.b == null) {
            this.b = new ArrayList(this.a.c);
        }
        FilterResults filterResults = new FilterResults();
        if (charSequence == null || charSequence.length() == 0) {
            filterResults.values = this.b;
            filterResults.count = this.b.size();
            this.b = null;
        } else {
            List list;
            List arrayList = new ArrayList();
            if (this.a.f != null) {
                for (IItem iItem : this.b) {
                    if (!this.a.f.filter(iItem, charSequence)) {
                        arrayList.add(iItem);
                    }
                }
                list = arrayList;
            } else {
                list = this.a.c;
            }
            filterResults.values = list;
            filterResults.count = list.size();
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        if (filterResults.values != null) {
            this.a.set((List) filterResults.values);
        }
        if (this.a.a != null) {
            this.a.a.itemsFiltered();
        }
    }
}
