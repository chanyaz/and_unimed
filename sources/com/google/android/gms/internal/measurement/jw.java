package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class jw implements Iterator {
    private int a = 0;
    private final int b = this.c.a();
    private final /* synthetic */ zzyw c;

    jw(zzyw zzyw) {
        this.c = zzyw;
    }

    private final byte a() {
        try {
            zzyw zzyw = this.c;
            int i = this.a;
            this.a = i + 1;
            return zzyw.a(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.a < this.b;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
