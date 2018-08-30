package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class acz extends acy {
    private acz(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static acz a(String str, Context context, boolean z) {
        acy.a(context, z);
        return new acz(context, str, z);
    }

    protected final List<Callable<Void>> a(adn adn, wr wrVar, tf tfVar) {
        if (adn.c() == null || !this.r) {
            return super.a(adn, wrVar, tfVar);
        }
        int n = adn.n();
        List<Callable<Void>> arrayList = new ArrayList();
        arrayList.addAll(super.a(adn, wrVar, tfVar));
        arrayList.add(new aei(adn, "1QeH3Cf7T53ayw17Ebbo9YTdhU+IFx0X5nCtC5gZQym4uicOVPXxYWmMK9k58i8n", "bHJRpFJ+2R5LAbYQUBDMyfYpLd1oiGixlpIqMJOBQPY=", wrVar, n, 24));
        return arrayList;
    }
}
