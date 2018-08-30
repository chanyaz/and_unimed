package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
final class b {
    private b() {
    }

    static int a(@Nullable String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    static void a(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    static void b(boolean z) {
        if (!z) {
            throw new ArithmeticException("overflow");
        }
    }
}
