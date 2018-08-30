package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.EnumSet;

@GwtCompatible(emulated = true, serializable = true)
final class dc<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> a;
    private transient int b;

    private dc(EnumSet<E> enumSet) {
        this.a = enumSet;
    }

    static <E extends Enum<E>> ImmutableSet<E> a(EnumSet<E> enumSet) {
        switch (enumSet.size()) {
            case 0:
                return ImmutableSet.g();
            case 1:
                return ImmutableSet.d(eq.b(enumSet));
            default:
                return new dc(enumSet);
        }
    }

    boolean c() {
        return false;
    }

    public boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.a.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return obj == this || this.a.equals(obj);
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return er.a(this.a.iterator());
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        i = this.a.hashCode();
        this.b = i;
        return i;
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public int size() {
        return this.a.size();
    }

    public String toString() {
        return this.a.toString();
    }

    Object writeReplace() {
        return new dd(this.a);
    }
}
