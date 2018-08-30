package com.google.common.collect;

final class bk<C extends Comparable> extends bi<C> {
    private static final long serialVersionUID = 0;

    void a(StringBuilder stringBuilder) {
        stringBuilder.append('(').append(this.a);
    }

    boolean a(C c) {
        return Range.a(this.a, (Comparable) c) < 0;
    }

    void b(StringBuilder stringBuilder) {
        stringBuilder.append(this.a).append(']');
    }

    public int hashCode() {
        return this.a.hashCode() ^ -1;
    }

    public String toString() {
        return "/" + this.a + "\\";
    }
}
