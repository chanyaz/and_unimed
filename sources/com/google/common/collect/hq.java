package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;

@GwtCompatible(emulated = true, serializable = true)
final class hq<E> extends ImmutableSet<E> {
    @VisibleForTesting
    final transient Object[] a;
    private final Object[] b;
    private final transient int c;
    private final transient int d;

    hq(Object[] objArr, int i, Object[] objArr2, int i2) {
        this.b = objArr;
        this.a = objArr2;
        this.c = i2;
        this.d = i;
    }

    int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.b.length);
        return this.b.length + i;
    }

    boolean c() {
        return false;
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int a = cs.a(obj.hashCode());
        while (true) {
            Object obj2 = this.a[this.c & a];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a++;
        }
    }

    ImmutableList<E> f() {
        return new hf((ImmutableCollection) this, this.b);
    }

    boolean f_() {
        return true;
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return er.a(this.b);
    }

    public int hashCode() {
        return this.d;
    }

    public int size() {
        return this.b.length;
    }
}
