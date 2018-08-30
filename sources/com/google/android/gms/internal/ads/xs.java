package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class xs {
    static final xs a = new xs(true);
    private static volatile boolean b = false;
    private static final Class<?> c = b();
    private final Map<xt, yh<?, ?>> d;

    xs() {
        this.d = new HashMap();
    }

    private xs(boolean z) {
        this.d = Collections.emptyMap();
    }

    public static xs a() {
        return xr.a();
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public final <ContainingType extends zzbcu> yh<ContainingType, ?> a(ContainingType containingType, int i) {
        return (yh) this.d.get(new xt(containingType, i));
    }
}
