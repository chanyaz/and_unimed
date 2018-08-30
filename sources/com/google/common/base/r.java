package com.google.common.base;

import com.appnext.base.b.c;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class r {
    private static final ThreadLocal<char[]> a = new ThreadLocal<char[]>() {
        /* renamed from: a */
        protected char[] initialValue() {
            return new char[c.jk];
        }
    };

    private r() {
    }

    static long a() {
        return System.nanoTime();
    }
}
