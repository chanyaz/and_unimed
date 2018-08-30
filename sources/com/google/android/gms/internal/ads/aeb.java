package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;

public final class aeb extends aez {
    private final Activity d;
    private final View e;

    public aeb(adn adn, String str, String str2, wr wrVar, int i, int i2, View view, Activity activity) {
        super(adn, str, str2, wrVar, i, 62);
        this.e = view;
        this.d = activity;
    }

    protected final void a() {
        if (this.e != null) {
            boolean booleanValue = ((Boolean) akc.f().a(amn.bF)).booleanValue();
            Object[] objArr = (Object[]) this.c.invoke(null, new Object[]{this.e, this.d, Boolean.valueOf(booleanValue)});
            synchronized (this.b) {
                this.b.Q = Long.valueOf(((Long) objArr[0]).longValue());
                this.b.R = Long.valueOf(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.b.S = (String) objArr[2];
                }
            }
        }
    }
}
