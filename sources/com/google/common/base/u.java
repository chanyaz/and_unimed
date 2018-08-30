package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class u<A, B> implements Predicate<A>, Serializable {
    private static final long serialVersionUID = 0;
    final Predicate<B> a;
    final Function<A, ? extends B> b;

    private u(Predicate<B> predicate, Function<A, ? extends B> function) {
        this.a = (Predicate) s.a((Object) predicate);
        this.b = (Function) s.a((Object) function);
    }

    public boolean apply(@Nullable A a) {
        return this.a.apply(this.b.apply(a));
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.b.equals(uVar.b) && this.a.equals(uVar.a);
    }

    public int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    public String toString() {
        return this.a.toString() + "(" + this.b.toString() + ")";
    }
}
