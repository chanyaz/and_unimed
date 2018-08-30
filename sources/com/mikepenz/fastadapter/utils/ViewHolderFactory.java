package com.mikepenz.fastadapter.utils;

import android.support.v7.widget.ce;
import android.view.View;

public interface ViewHolderFactory<T extends ce> {
    T create(View view);
}
