package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@zzadh
@TargetApi(17)
public final class ju {
    private static ju b = null;
    String a;

    private ju() {
    }

    public static ju a() {
        if (b == null) {
            b = new ju();
        }
        return b;
    }
}
