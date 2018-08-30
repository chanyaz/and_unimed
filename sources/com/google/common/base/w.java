package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class w<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0;
    private final T a;

    private w(T t) {
        this.a = t;
    }

    public boolean apply(T t) {
        return this.a.equals(t);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        return this.a.equals(((w) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "IsEqualTo(" + this.a + ")";
    }
}
