package com.mikepenz.materialdrawer.model.a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;

public class a {
    private com.mikepenz.materialdrawer.a.a a;

    public a(com.mikepenz.materialdrawer.a.a aVar) {
        this.a = aVar;
    }

    public StateListDrawable a(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = (GradientDrawable) android.support.v4.content.a.a(context, this.a.a());
        GradientDrawable gradientDrawable2 = (GradientDrawable) gradientDrawable.getConstantState().newDrawable().mutate();
        com.mikepenz.materialize.b.a.a(this.a.b(), context, gradientDrawable);
        if (this.a.c() == null) {
            com.mikepenz.materialize.b.a.a(this.a.b(), context, gradientDrawable2);
        } else {
            com.mikepenz.materialize.b.a.a(this.a.c(), context, gradientDrawable2);
        }
        if (this.a.d() != null) {
            gradientDrawable.setCornerRadius((float) this.a.d().a(context));
            gradientDrawable2.setCornerRadius((float) this.a.d().a(context));
        }
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
        return stateListDrawable;
    }
}
