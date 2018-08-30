package com.google.android.gms.internal.ads;

import android.provider.Settings.SettingNotFoundException;
import java.lang.reflect.InvocationTargetException;

public final class aec extends aez {
    public aec(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 49);
    }

    protected final void a() {
        this.b.F = Integer.valueOf(2);
        try {
            this.b.F = Integer.valueOf(((Boolean) this.c.invoke(null, new Object[]{this.a.a()})).booleanValue() ? 1 : 0);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
