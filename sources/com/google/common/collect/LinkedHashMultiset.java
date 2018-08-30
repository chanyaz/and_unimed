package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedHashMap;

@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultiset<E> extends ab<E> {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0;

    private LinkedHashMultiset() {
        super(new LinkedHashMap());
    }

    private LinkedHashMultiset(int i) {
        super(new LinkedHashMap(Maps.b(i)));
    }

    public static <E> LinkedHashMultiset<E> a(int i) {
        return new LinkedHashMultiset(i);
    }

    public static <E> LinkedHashMultiset<E> a(Iterable<? extends E> iterable) {
        Collection a = a(gv.a((Iterable) iterable));
        eq.a(a, (Iterable) iterable);
        return a;
    }

    public static <E> LinkedHashMultiset<E> e() {
        return new LinkedHashMultiset();
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int a = hx.a(objectInputStream);
        a(new LinkedHashMap(Maps.b(a)));
        hx.a((Multiset) this, objectInputStream, a);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        hx.a((Multiset) this, objectOutputStream);
    }
}
