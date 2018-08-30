package com.google.common.collect;

import java.util.Map;

class ay extends au<R, Map<C, V>> {
    final /* synthetic */ ArrayTable a;

    private ay(ArrayTable arrayTable) {
        this.a = arrayTable;
        super(arrayTable.c);
    }

    Map<C, V> a(int i, Map<C, V> map) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public Map<C, V> put(R r, Map<C, V> map) {
        throw new UnsupportedOperationException();
    }

    String b() {
        return "Row";
    }

    /* renamed from: c */
    Map<C, V> b(int i) {
        return new ax(this.a, i);
    }
}
