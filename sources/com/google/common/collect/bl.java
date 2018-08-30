package com.google.common.collect;

final class bl extends bi<Comparable<?>> {
    private static final bl b = new bl();
    private static final long serialVersionUID = 0;

    private bl() {
        super(null);
    }

    private Object readResolve() {
        return b;
    }

    /* renamed from: a */
    public int compareTo(bi<Comparable<?>> biVar) {
        return biVar == this ? 0 : -1;
    }

    void a(StringBuilder stringBuilder) {
        stringBuilder.append("(-∞");
    }

    boolean a(Comparable<?> comparable) {
        return true;
    }

    void b(StringBuilder stringBuilder) {
        throw new AssertionError();
    }

    public String toString() {
        return "-∞";
    }
}
