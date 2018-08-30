package com.mikepenz.materialdrawer.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.mikepenz.materialdrawer.h;
import com.mikepenz.materialize.c.b;

public class a {
    private int a = h.material_drawer_badge;
    private Drawable b;
    private b c;
    private b d;
    private b e;
    private c f;
    private c g = c.a(2);
    private c h = c.a(3);
    private c i = c.a(20);

    public int a() {
        return this.a;
    }

    public void a(TextView textView) {
        a(textView, null);
    }

    public void a(TextView textView, ColorStateList colorStateList) {
        Context context = textView.getContext();
        if (this.b == null) {
            b.a((View) textView, new com.mikepenz.materialdrawer.model.a.a(this).a(context));
        } else {
            b.a((View) textView, this.b);
        }
        if (this.e != null) {
            com.mikepenz.materialize.b.a.a(this.e, textView, null);
        } else if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        int a = this.h.a(context);
        int a2 = this.g.a(context);
        textView.setPadding(a, a2, a, a2);
        textView.setMinWidth(this.i.a(context));
    }

    public b b() {
        return this.c;
    }

    public b c() {
        return this.d;
    }

    public c d() {
        return this.f;
    }
}
