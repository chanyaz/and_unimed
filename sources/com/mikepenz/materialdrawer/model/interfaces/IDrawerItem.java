package com.mikepenz.materialdrawer.model.interfaces;

import android.content.Context;
import android.support.v7.widget.ce;
import android.view.View;
import android.view.ViewGroup;
import com.mikepenz.fastadapter.IItem;

public interface IDrawerItem<T, VH extends ce> extends IItem<T, VH> {
    void bindView(VH vh);

    boolean equals(long j);

    View generateView(Context context);

    View generateView(Context context, ViewGroup viewGroup);

    int getLayoutRes();

    Object getTag();

    int getType();

    VH getViewHolder(ViewGroup viewGroup);

    boolean isEnabled();

    boolean isSelectable();

    boolean isSelected();

    T withSelectable(boolean z);

    T withSetSelected(boolean z);
}
