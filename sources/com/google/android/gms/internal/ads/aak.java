package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class aak implements Iterator<String> {
    private Iterator<String> a = this.b.a.iterator();
    private final /* synthetic */ aai b;

    aak(aai aai) {
        this.b = aai;
    }

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
