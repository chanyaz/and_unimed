package com.mikepenz.materialdrawer.util;

import android.view.View;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class DrawerItemViewHelper {

    public interface OnDrawerItemClickListener {
        void onItemClick(View view, IDrawerItem iDrawerItem);
    }
}
