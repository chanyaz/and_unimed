package com.google.common.collect;

import com.google.common.base.Equivalence;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentMap;

final class ft<K, V> extends fi<K, V> {
    private static final long serialVersionUID = 3;

    ft(fv fvVar, fv fvVar2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap) {
        super(fvVar, fvVar2, equivalence, equivalence2, j, j2, i, i2, removalListener, concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.j = a(objectInputStream).k();
        b(objectInputStream);
    }

    private Object readResolve() {
        return this.j;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        a(objectOutputStream);
    }
}
