package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@GwtCompatible(emulated = true, serializable = true)
public final class HashMultiset<E> extends ab<E> {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0;

    private HashMultiset() {
        super(new HashMap());
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int a = hx.a(objectInputStream);
        a(Maps.a(a));
        hx.a((Multiset) this, objectInputStream, a);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        hx.a((Multiset) this, objectOutputStream);
    }
}
