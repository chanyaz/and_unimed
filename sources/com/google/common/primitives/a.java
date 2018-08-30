package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class a {
    private a() {
    }

    public static int a(boolean z, boolean z2) {
        return z == z2 ? 0 : z ? 1 : -1;
    }
}
