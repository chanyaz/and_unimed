package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
public final class HashMultimap<K, V> extends an<K, V> {
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0;
    @VisibleForTesting
    transient int a = 2;

    private HashMultimap() {
        super(new HashMap());
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = objectInputStream.readInt();
        int a = hx.a(objectInputStream);
        a(Maps.a(a));
        hx.a((Multimap) this, objectInputStream, a);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.a);
        hx.a((Multimap) this, objectOutputStream);
    }

    /* renamed from: a */
    Set<V> c() {
        return hz.a(this.a);
    }
}
