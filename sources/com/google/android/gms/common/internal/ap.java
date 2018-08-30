package com.google.android.gms.common.internal;

import android.support.annotation.Nullable;
import java.util.Arrays;

public final class ap {
    private ap() {
        throw new AssertionError("Uninstantiable");
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static aq a(Object obj) {
        return new aq(obj, null);
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
