package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class br extends ImmutableSet<Object> {
    static final br a = new br();
    private static final long serialVersionUID = 0;

    private br() {
    }

    int a(Object[] objArr, int i) {
        return i;
    }

    public ImmutableList<Object> b() {
        return ImmutableList.e();
    }

    boolean c() {
        return false;
    }

    public boolean contains(@Nullable Object obj) {
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof Set ? ((Set) obj).isEmpty() : false;
    }

    boolean f_() {
        return true;
    }

    /* renamed from: h_ */
    public jl<Object> iterator() {
        return er.a();
    }

    public final int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    Object readResolve() {
        return a;
    }

    public int size() {
        return 0;
    }

    public String toString() {
        return "[]";
    }
}
