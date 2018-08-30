package com.mikepenz.materialdrawer.model;

import android.support.v7.widget.ce;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mikepenz.materialdrawer.i;

public class r extends ce {
    private View m;
    private ImageView n;
    private TextView o;
    private TextView p;

    private r(View view) {
        super(view);
        this.m = view;
        this.n = (ImageView) view.findViewById(i.material_drawer_profileIcon);
        this.o = (TextView) view.findViewById(i.material_drawer_name);
        this.p = (TextView) view.findViewById(i.material_drawer_email);
    }
}
