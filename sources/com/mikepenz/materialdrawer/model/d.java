package com.mikepenz.materialdrawer.model;

import android.support.v7.widget.ce;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikepenz.materialdrawer.i;

public class d extends ce {
    protected View m;
    protected ImageView n;
    protected TextView o;
    protected TextView p;

    public d(View view) {
        super(view);
        this.m = view;
        this.n = (ImageView) view.findViewById(i.material_drawer_icon);
        this.o = (TextView) view.findViewById(i.material_drawer_name);
        this.p = (TextView) view.findViewById(i.material_drawer_description);
    }
}
