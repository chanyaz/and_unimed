package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class ie<E> extends ImmutableSet<E> {
    final transient E a;
    private transient int b;

    ie(E e) {
        this.a = s.a((Object) e);
    }

    ie(E e, int i) {
        this.a = e;
        this.b = i;
    }

    int a(Object[] objArr, int i) {
        objArr[i] = this.a;
        return i + 1;
    }

    boolean c() {
        return false;
    }

    public boolean contains(Object obj) {
        return this.a.equals(obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        return set.size() == 1 && this.a.equals(set.iterator().next());
    }

    boolean f_() {
        return this.b != 0;
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return er.a(this.a);
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        i = this.a.hashCode();
        this.b = i;
        return i;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        String obj = this.a.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }
}
