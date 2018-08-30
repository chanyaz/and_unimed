package com.mikepenz.materialdrawer.model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import com.mikepenz.materialdrawer.e;
import com.mikepenz.materialdrawer.f;
import com.mikepenz.materialdrawer.i;
import com.mikepenz.materialdrawer.j;
import com.mikepenz.materialize.b.a;

public class s extends m {
    protected int b(Context context) {
        return isEnabled() ? a.a(d(), context, e.material_drawer_secondary_text, f.material_drawer_secondary_text) : a.a(f(), context, e.material_drawer_hint_text, f.material_drawer_hint_text);
    }

    @LayoutRes
    public int getLayoutRes() {
        return j.material_drawer_item_secondary;
    }

    public int getType() {
        return i.material_drawer_item_secondary;
    }
}
