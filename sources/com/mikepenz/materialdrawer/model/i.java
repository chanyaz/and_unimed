package com.mikepenz.materialdrawer.model;

import android.support.v7.widget.ce;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class i extends ce {
    private View m;
    private ImageView n;
    private TextView o;

    public i(View view) {
        super(view);
        this.m = view;
        this.n = (ImageView) view.findViewById(com.mikepenz.materialdrawer.i.material_drawer_icon);
        this.o = (TextView) view.findViewById(com.mikepenz.materialdrawer.i.material_drawer_badge);
    }
}
