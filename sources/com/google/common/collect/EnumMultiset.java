package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;

@GwtCompatible(emulated = true)
public final class EnumMultiset<E extends Enum<E>> extends ab<E> {
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0;
    private transient Class<E> a;

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Class) objectInputStream.readObject();
        a(jn.a(new EnumMap(this.a)));
        hx.a((Multiset) this, objectInputStream);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
        hx.a((Multiset) this, objectOutputStream);
    }
}
