package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final class zm<E> extends wt<E> {
    private static final zm<Object> a;
    private final List<E> b;

    static {
        wt zmVar = new zm();
        a = zmVar;
        zmVar.zzaaz();
    }

    zm() {
        this(new ArrayList(10));
    }

    private zm(List<E> list) {
        this.b = list;
    }

    public static <E> zm<E> b() {
        return a;
    }

    public final void add(int i, E e) {
        a();
        this.b.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.b.get(i);
    }

    public final E remove(int i) {
        a();
        E remove = this.b.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        a();
        E e2 = this.b.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.b.size();
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        List arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new zm(arrayList);
    }
}
