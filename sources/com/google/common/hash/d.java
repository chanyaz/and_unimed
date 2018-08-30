package com.google.common.hash;

import java.io.Serializable;

class d<T> implements Serializable {
    private static final long serialVersionUID = 1;
    final long[] a;
    final int b;
    final Funnel<T> c;
    final Strategy d;

    d(BloomFilter<T> bloomFilter) {
        this.a = bloomFilter.a.a;
        this.b = bloomFilter.b;
        this.c = bloomFilter.c;
        this.d = bloomFilter.d;
    }

    Object readResolve() {
        return new BloomFilter(new f(this.a), this.b, this.c, this.d);
    }
}
