package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class ahb implements Comparator<ahg> {
    ahb(aha aha) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ahg ahg = (ahg) obj;
        ahg ahg2 = (ahg) obj2;
        int i = ahg.c - ahg2.c;
        return i != 0 ? i : (int) (ahg.a - ahg2.a);
    }
}
