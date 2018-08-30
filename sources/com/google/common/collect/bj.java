package com.google.common.collect;

final class bj extends bi<Comparable<?>> {
    private static final bj b = new bj();
    private static final long serialVersionUID = 0;

    private bj() {
        super(null);
    }

    private Object readResolve() {
        return b;
    }

    /* renamed from: a */
    public int compareTo(bi<Comparable<?>> biVar) {
        return biVar == this ? 0 : 1;
    }

    void a(StringBuilder stringBuilder) {
        throw new AssertionError();
    }

    boolean a(Comparable<?> comparable) {
        return false;
    }

    void b(StringBuilder stringBuilder) {
        stringBuilder.append("+∞)");
    }

    public String toString() {
        return "+∞";
    }
}
