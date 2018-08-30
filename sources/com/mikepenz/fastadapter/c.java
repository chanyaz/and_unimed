package com.mikepenz.fastadapter;

import android.support.v7.widget.ce;
import android.view.ViewGroup;
import com.mikepenz.fastadapter.FastAdapter.OnCreateViewHolderListener;

public class c implements OnCreateViewHolderListener {
    final /* synthetic */ FastAdapter a;

    public c(FastAdapter fastAdapter) {
        this.a = fastAdapter;
    }

    public ce onPostCreateViewHolder(ce ceVar) {
        return ceVar;
    }

    public ce onPreCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.a.a(i).getViewHolder(viewGroup);
    }
}
