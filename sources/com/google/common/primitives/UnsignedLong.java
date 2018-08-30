package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
public final class UnsignedLong extends Number implements Serializable, Comparable<UnsignedLong> {
    public static final UnsignedLong a = new UnsignedLong(0);
    public static final UnsignedLong b = new UnsignedLong(1);
    public static final UnsignedLong c = new UnsignedLong(-1);
    private final long d;

    private UnsignedLong(long j) {
        this.d = j;
    }

    /* renamed from: a */
    public int compareTo(UnsignedLong unsignedLong) {
        s.a((Object) unsignedLong);
        return f.a(this.d, unsignedLong.d);
    }

    public double doubleValue() {
        double d = (double) (this.d & Long.MAX_VALUE);
        return this.d < 0 ? d + 9.223372036854776E18d : d;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof UnsignedLong)) {
            return false;
        }
        return this.d == ((UnsignedLong) obj).d;
    }

    public float floatValue() {
        float f = (float) (this.d & Long.MAX_VALUE);
        return this.d < 0 ? f + 9.223372E18f : f;
    }

    public int hashCode() {
        return c.a(this.d);
    }

    public int intValue() {
        return (int) this.d;
    }

    public long longValue() {
        return this.d;
    }

    public String toString() {
        return f.a(this.d);
    }
}
