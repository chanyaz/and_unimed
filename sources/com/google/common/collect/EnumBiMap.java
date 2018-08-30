package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.Map;

@GwtCompatible(emulated = true)
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends a<K, V> {
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = 0;
    private transient Class<K> b;
    private transient Class<V> c;

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.b = (Class) objectInputStream.readObject();
        this.c = (Class) objectInputStream.readObject();
        a(jn.a(new EnumMap(this.b)), jn.a(new EnumMap(this.c)));
        hx.a((Map) this, objectInputStream);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.b);
        objectOutputStream.writeObject(this.c);
        hx.a((Map) this, objectOutputStream);
    }

    K a(K k) {
        return (Enum) s.a((Object) k);
    }

    V b(V v) {
        return (Enum) s.a((Object) v);
    }
}
