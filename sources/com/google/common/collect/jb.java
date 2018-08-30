package com.google.common.collect;

abstract class jb<T> extends ia<T> {
    final /* synthetic */ il b;

    private jb(il ilVar) {
        this.b = ilVar;
    }

    public void clear() {
        this.b.a.clear();
    }

    public boolean isEmpty() {
        return this.b.a.isEmpty();
    }
}
