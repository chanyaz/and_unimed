package android.support.design.internal;

import android.support.design.i;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class h extends k {
    public h(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
        super(layoutInflater.inflate(i.design_navigation_item, viewGroup, false));
        this.itemView.setOnClickListener(onClickListener);
    }
}
