package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class hw<T> extends hd<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final hd<? super T> a;

    hw(hd<? super T> hdVar) {
        this.a = (hd) s.a((Object) hdVar);
    }

    public <S extends T> hd<S> a() {
        return this.a;
    }

    public int compare(T t, T t2) {
        return this.a.compare(t2, t);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof hw)) {
            return false;
        }
        return this.a.equals(((hw) obj).a);
    }

    public int hashCode() {
        return -this.a.hashCode();
    }

    public String toString() {
        return this.a + ".reverse()";
    }
}
