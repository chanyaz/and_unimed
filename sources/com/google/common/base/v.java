package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

class v<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0;
    private final Collection<?> a;

    private v(Collection<?> collection) {
        this.a = (Collection) s.a((Object) collection);
    }

    public boolean apply(@Nullable T t) {
        boolean z = false;
        try {
            return this.a.contains(t);
        } catch (NullPointerException e) {
            return z;
        } catch (ClassCastException e2) {
            return z;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        return this.a.equals(((v) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "In(" + this.a + ")";
    }
}
