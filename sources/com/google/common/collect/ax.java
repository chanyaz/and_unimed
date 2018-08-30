package com.google.common.collect;

class ax extends au<C, V> {
    final int a;
    final /* synthetic */ ArrayTable b;

    ax(ArrayTable arrayTable, int i) {
        this.b = arrayTable;
        super(arrayTable.d);
        this.a = i;
    }

    V a(int i, V v) {
        return this.b.a(this.a, i, v);
    }

    V b(int i) {
        return this.b.a(this.a, i);
    }

    String b() {
        return "Column";
    }
}
