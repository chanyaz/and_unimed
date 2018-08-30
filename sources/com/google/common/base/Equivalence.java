package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Equivalence<T> {

    public final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> a;
        @Nullable
        private final T b;

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Wrapper) {
                Wrapper wrapper = (Wrapper) obj;
                if (this.a.equals(wrapper.a)) {
                    return this.a.a(this.b, wrapper.b);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.a.a(this.b);
        }

        public String toString() {
            return this.a + ".wrap(" + this.b + ")";
        }
    }

    protected Equivalence() {
    }

    public static Equivalence<Object> a() {
        return h.a;
    }

    public static Equivalence<Object> b() {
        return i.a;
    }

    public final int a(@Nullable T t) {
        return t == null ? 0 : b(t);
    }

    public final boolean a(@Nullable T t, @Nullable T t2) {
        return t == t2 ? true : (t == null || t2 == null) ? false : b(t, t2);
    }

    protected abstract int b(T t);

    protected abstract boolean b(T t, T t2);
}
