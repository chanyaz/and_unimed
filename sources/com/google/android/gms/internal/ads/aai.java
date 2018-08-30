package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class aai extends AbstractList<String> implements zzbcd, RandomAccess {
    private final zzbcd a;

    public aai(zzbcd zzbcd) {
        this.a = zzbcd;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.a.get(i);
    }

    public final Iterator<String> iterator() {
        return new aak(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new aaj(this, i);
    }

    public final int size() {
        return this.a.size();
    }

    public final List<?> zzadw() {
        return this.a.zzadw();
    }

    public final zzbcd zzadx() {
        return this;
    }

    public final void zzap(zzbah zzbah) {
        throw new UnsupportedOperationException();
    }

    public final Object zzcp(int i) {
        return this.a.zzcp(i);
    }
}
