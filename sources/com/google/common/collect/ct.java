package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

@GwtCompatible(emulated = true, serializable = true)
abstract class ct<E> extends ImmutableList<E> {
    ct() {
    }

    @GwtIncompatible("serialization")
    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    boolean c() {
        return d().c();
    }

    public boolean contains(Object obj) {
        return d().contains(obj);
    }

    abstract ImmutableCollection<E> d();

    public boolean isEmpty() {
        return d().isEmpty();
    }

    public int size() {
        return d().size();
    }

    @GwtIncompatible("serialization")
    Object writeReplace() {
        return new cu(d());
    }
}
