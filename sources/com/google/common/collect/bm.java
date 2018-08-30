package com.google.common.collect;

import com.google.common.base.s;

final class bm<C extends Comparable> extends bi<C> {
    private static final long serialVersionUID = 0;

    bm(C c) {
        super((Comparable) s.a((Object) c));
    }

    void a(StringBuilder stringBuilder) {
        stringBuilder.append('[').append(this.a);
    }

    boolean a(C c) {
        return Range.a(this.a, (Comparable) c) <= 0;
    }

    void b(StringBuilder stringBuilder) {
        stringBuilder.append(this.a).append(')');
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "\\" + this.a + "/";
    }
}
