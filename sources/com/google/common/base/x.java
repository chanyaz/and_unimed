package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class x<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0;
    final Predicate<T> a;

    x(Predicate<T> predicate) {
        this.a = (Predicate) s.a((Object) predicate);
    }

    public boolean apply(@Nullable T t) {
        return !this.a.apply(t);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        return this.a.equals(((x) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode() ^ -1;
    }

    public String toString() {
        return "Not(" + this.a.toString() + ")";
    }
}
