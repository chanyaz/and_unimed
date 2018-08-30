package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
class hl<E> extends ImmutableList<E> {
    private final transient int a;
    private final transient int b;
    private final transient Object[] c;

    hl(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    hl(Object[] objArr, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = objArr;
    }

    int a(Object[] objArr, int i) {
        System.arraycopy(this.c, this.a, objArr, i, this.b);
        return this.b + i;
    }

    /* renamed from: a */
    public jm<E> listIterator(int i) {
        return er.a(this.c, this.a, this.b, i);
    }

    ImmutableList<E> b(int i, int i2) {
        return new hl(this.c, this.a + i, i2 - i);
    }

    boolean c() {
        return this.b != this.c.length;
    }

    public E get(int i) {
        s.a(i, this.b);
        return this.c[this.a + i];
    }

    public int indexOf(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int i = 0; i < this.b; i++) {
            if (this.c[this.a + i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int i = this.b - 1; i >= 0; i--) {
            if (this.c[this.a + i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return this.b;
    }
}
