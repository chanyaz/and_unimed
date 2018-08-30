package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class ahk implements Comparator<agy> {
    public ahk(ahj ahj) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        agy agy = (agy) obj;
        agy agy2 = (agy) obj2;
        if (agy.b() < agy2.b()) {
            return -1;
        }
        if (agy.b() > agy2.b()) {
            return 1;
        }
        if (agy.a() < agy2.a()) {
            return -1;
        }
        if (agy.a() > agy2.a()) {
            return 1;
        }
        float d = (agy.d() - agy.b()) * (agy.c() - agy.a());
        float d2 = (agy2.d() - agy2.b()) * (agy2.c() - agy2.a());
        return d <= d2 ? d < d2 ? 1 : 0 : -1;
    }
}
