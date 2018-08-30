package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

final class aam extends aap {
    aam(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte a(Object obj, long j) {
        return aal.x ? aal.k(obj, j) : aal.l(obj, j);
    }

    public final void a(Object obj, long j, byte b) {
        if (aal.x) {
            aal.c(obj, j, b);
        } else {
            aal.d(obj, j, b);
        }
    }

    public final void a(Object obj, long j, double d) {
        a(obj, j, Double.doubleToLongBits(d));
    }

    public final void a(Object obj, long j, float f) {
        a(obj, j, Float.floatToIntBits(f));
    }

    public final void a(Object obj, long j, boolean z) {
        if (aal.x) {
            aal.d(obj, j, z);
        } else {
            aal.e(obj, j, z);
        }
    }

    public final boolean b(Object obj, long j) {
        return aal.x ? aal.m(obj, j) : aal.n(obj, j);
    }

    public final float c(Object obj, long j) {
        return Float.intBitsToFloat(e(obj, j));
    }

    public final double d(Object obj, long j) {
        return Double.longBitsToDouble(f(obj, j));
    }
}
