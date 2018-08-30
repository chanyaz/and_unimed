package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class bc<T> extends hd<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> a;

    bc(Comparator<T> comparator) {
        this.a = (Comparator) s.a((Object) comparator);
    }

    public int compare(T t, T t2) {
        return this.a.compare(t, t2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bc)) {
            return false;
        }
        return this.a.equals(((bc) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
