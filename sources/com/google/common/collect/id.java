package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class id<E> extends ImmutableList<E> {
    final transient E a;

    id(E e) {
        this.a = s.a((Object) e);
    }

    int a(Object[] objArr, int i) {
        objArr[i] = this.a;
        return i + 1;
    }

    /* renamed from: a */
    public ImmutableList<E> subList(int i, int i2) {
        s.a(i, i2, 1);
        return i == i2 ? ImmutableList.e() : this;
    }

    boolean c() {
        return false;
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.equals(obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        return list.size() == 1 && this.a.equals(list.get(0));
    }

    public E get(int i) {
        s.a(i, 1);
        return this.a;
    }

    public ImmutableList<E> h() {
        return this;
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return er.a(this.a);
    }

    public int hashCode() {
        return this.a.hashCode() + 31;
    }

    public int indexOf(@Nullable Object obj) {
        return this.a.equals(obj) ? 0 : -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public int lastIndexOf(@Nullable Object obj) {
        return indexOf(obj);
    }

    public int size() {
        return 1;
    }

    public String toString() {
        String obj = this.a.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }
}
