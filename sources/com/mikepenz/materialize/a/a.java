package com.mikepenz.materialize.a;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

@SuppressLint({"InlinedApi"})
public class a extends StateListDrawable {
    private int a;
    private int b;

    public a(Drawable drawable, int i, int i2) {
        Drawable mutate = drawable.mutate();
        addState(new int[]{16842913}, mutate);
        addState(new int[0], mutate);
        this.a = i;
        this.b = i2;
    }

    public a(Drawable drawable, Drawable drawable2, int i, int i2) {
        Drawable mutate = drawable.mutate();
        int[] iArr = new int[]{16842913};
        addState(iArr, drawable2.mutate());
        addState(new int[0], mutate);
        this.a = i;
        this.b = i2;
    }

    public boolean isStateful() {
        return true;
    }

    protected boolean onStateChange(int[] iArr) {
        Object obj = null;
        for (int i : iArr) {
            if (i == 16842913) {
                obj = 1;
            }
        }
        if (obj != null) {
            super.setColorFilter(this.b, Mode.SRC_IN);
        } else {
            super.setColorFilter(this.a, Mode.SRC_IN);
        }
        return super.onStateChange(iArr);
    }
}
