package com.mikepenz.materialdrawer.model;

import android.view.View;
import android.widget.TextView;
import com.mikepenz.materialdrawer.i;

public class o extends d {
    private View q;
    private TextView r;

    public o(View view) {
        super(view);
        this.q = view.findViewById(i.material_drawer_badge_container);
        this.r = (TextView) view.findViewById(i.material_drawer_badge);
    }
}
