package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@GwtCompatible(emulated = true, serializable = true)
public final class ArrayListMultimap<K, V> extends i<K, V> {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0;
    @VisibleForTesting
    transient int a = 3;

    private ArrayListMultimap() {
        super(new HashMap());
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
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
    List<V> c() {
        return new ArrayList(this.a);
    }
}
