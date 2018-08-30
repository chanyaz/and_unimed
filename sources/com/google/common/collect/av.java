package com.google.common.collect;

class av extends au<R, V> {
    final int a;
    final /* synthetic */ ArrayTable b;

    av(ArrayTable arrayTable, int i) {
        this.b = arrayTable;
        super(arrayTable.c);
        this.a = i;
    }

    V a(int i, V v) {
        return this.b.a(i, this.a, v);
    }

    V b(int i) {
        return this.b.a(i, this.a);
    }

    String b() {
        return "Row";
    }
}
