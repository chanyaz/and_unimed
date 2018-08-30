package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;

@GwtCompatible
final class ba {
    ba() {
    }

    static int a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    static void a(boolean z) {
        s.b(z, (Object) "no calls to next() since the last call to remove()");
    }
}
