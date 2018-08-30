package com.mikepenz.fastadapter;

import android.support.v7.widget.ce;
import com.mikepenz.fastadapter.FastAdapter.OnBindViewHolderListener;

public class b implements OnBindViewHolderListener {
    final /* synthetic */ FastAdapter a;

    public b(FastAdapter fastAdapter) {
        this.a = fastAdapter;
    }

    public void onBindViewHolder(ce ceVar, int i) {
        this.a.b(i).bindView(ceVar);
    }
}
