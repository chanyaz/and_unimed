package com.mikepenz.fastadapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.ce;
import android.view.View;
import android.view.ViewGroup;

public interface IItem<T, VH extends ce> extends IIdentifyable<T> {
    void bindView(VH vh);

    boolean equals(int i);

    View generateView(Context context);

    View generateView(Context context, ViewGroup viewGroup);

    @LayoutRes
    int getLayoutRes();

    Object getTag();

    @IdRes
    int getType();

    VH getViewHolder(ViewGroup viewGroup);

    boolean isEnabled();

    boolean isSelectable();

    boolean isSelected();

    T withEnabled(boolean z);

    T withSelectable(boolean z);

    T withSetSelected(boolean z);

    T withTag(Object obj);
}
