package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger a = a(0);
    public static final UnsignedInteger b = a(1);
    public static final UnsignedInteger c = a(-1);
    private final int d;

    private UnsignedInteger(int i) {
        this.d = i & -1;
    }

    public static UnsignedInteger a(int i) {
        return new UnsignedInteger(i);
    }

    /* renamed from: a */
    public int compareTo(UnsignedInteger unsignedInteger) {
        s.a((Object) unsignedInteger);
        return e.a(this.d, unsignedInteger.d);
    }

    public String b(int i) {
        return e.b(this.d, i);
    }

    public double doubleValue() {
        return (double) longValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof UnsignedInteger)) {
            return false;
        }
        return this.d == ((UnsignedInteger) obj).d;
    }

    public float floatValue() {
        return (float) longValue();
    }

    public int hashCode() {
        return this.d;
    }

    public int intValue() {
        return this.d;
    }

    public long longValue() {
        return e.b(this.d);
    }

    public String toString() {
        return b(10);
    }
}
