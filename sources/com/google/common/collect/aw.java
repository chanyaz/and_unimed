package com.google.common.collect;

import java.util.Map;

class aw extends au<C, Map<R, V>> {
    final /* synthetic */ ArrayTable a;

    private aw(ArrayTable arrayTable) {
        this.a = arrayTable;
        super(arrayTable.d);
    }

    Map<R, V> a(int i, Map<R, V> map) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public Map<R, V> put(C c, Map<R, V> map) {
        throw new UnsupportedOperationException();
    }

    String b() {
        return "Column";
    }

    /* renamed from: c */
    Map<R, V> b(int i) {
        return new av(this.a, i);
    }
}
