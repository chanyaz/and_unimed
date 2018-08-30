package com.mikepenz.fastadapter.helpers;

import android.view.View;
import com.mikepenz.fastadapter.IItem;

public class ClickListenerHelper<Item extends IItem> {

    public interface OnClickListener<Item extends IItem> {
        void onClick(View view, int i, Item item);
    }
}
