package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;

public final class aew extends aez {
    private final View d;

    public aew(adn adn, String str, String str2, wr wrVar, int i, int i2, View view) {
        super(adn, str, str2, wrVar, i, 57);
        this.d = view;
    }

    protected final void a() {
        if (this.d != null) {
            DisplayMetrics displayMetrics = this.a.a().getResources().getDisplayMetrics();
            adx adx = new adx((String) this.c.invoke(null, new Object[]{this.d, displayMetrics}));
            yo yoVar = new yo();
            yoVar.a = adx.a;
            yoVar.b = adx.b;
            yoVar.c = adx.c;
            this.b.M = yoVar;
        }
    }
}
