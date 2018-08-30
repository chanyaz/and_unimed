package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;

public abstract class zzyw implements Serializable, Iterable<Byte> {
    public static final zzyw a = new kb(kg.b);
    private static final zzza b = (jv.a() ? new kc() : new jx());
    private int c = 0;

    zzyw() {
    }

    static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((((i | i2) | i4) | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    public abstract byte a(int i);

    public abstract int a();

    protected abstract int a(int i, int i2, int i3);

    public abstract zzyw a(int i, int i2);

    protected final int b() {
        return this.c;
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            i = a();
            i = a(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new jw(this);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a())});
    }
}
