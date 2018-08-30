package com.google.common.cache;

final class ao<K, V> extends ae<K, V> {
    final int b;

    ao(V v, int i) {
        super(v);
        this.b = i;
    }

    public int getWeight() {
        return this.b;
    }
}
