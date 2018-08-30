package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
final class cs {
    private static int a = 1073741824;

    private cs() {
    }

    static int a(int i) {
        return 461845907 * Integer.rotateLeft(-862048943 * i, 15);
    }

    static int a(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (((double) highestOneBit) * d))) {
            return highestOneBit;
        }
        highestOneBit <<= 1;
        return highestOneBit > 0 ? highestOneBit : a;
    }

    static int a(@Nullable Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }

    static boolean a(int i, int i2, double d) {
        return ((double) i) > ((double) i2) * d && i2 < a;
    }
}
