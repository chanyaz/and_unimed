package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

class c<K, V> extends a<K, V> {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0;

    private c(Map<K, V> map, a<V, K> aVar) {
        super(map, aVar);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        a((a) objectInputStream.readObject());
    }

    @GwtIncompatible("java.io.ObjectOuputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(inverse());
    }

    K a(K k) {
        return this.a.b((Object) k);
    }

    V b(V v) {
        return this.a.a((Object) v);
    }

    @GwtIncompatible("Not needed in the emulated source.")
    Object readResolve() {
        return inverse().inverse();
    }
}
