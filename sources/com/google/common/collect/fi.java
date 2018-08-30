package com.google.common.collect;

import com.google.common.base.Equivalence;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

abstract class fi<K, V> extends bx<K, V> implements Serializable {
    private static final long serialVersionUID = 3;
    final fv a;
    final fv b;
    final Equivalence<Object> c;
    final Equivalence<Object> d;
    final long e;
    final long f;
    final int g;
    final int h;
    final RemovalListener<? super K, ? super V> i;
    transient ConcurrentMap<K, V> j;

    fi(fv fvVar, fv fvVar2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap) {
        this.a = fvVar;
        this.b = fvVar2;
        this.c = equivalence;
        this.d = equivalence2;
        this.e = j;
        this.f = j2;
        this.g = i;
        this.h = i2;
        this.i = removalListener;
        this.j = concurrentMap;
    }

    MapMaker a(ObjectInputStream objectInputStream) {
        MapMaker c = new MapMaker().a(objectInputStream.readInt()).a(this.a).b(this.b).a(this.c).c(this.h);
        c.a(this.i);
        if (this.e > 0) {
            c.a(this.e, TimeUnit.NANOSECONDS);
        }
        if (this.f > 0) {
            c.b(this.f, TimeUnit.NANOSECONDS);
        }
        if (this.g != -1) {
            c.b(this.g);
        }
        return c;
    }

    void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.j.size());
        for (Entry entry : this.j.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
        objectOutputStream.writeObject(null);
    }

    void b(ObjectInputStream objectInputStream) {
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                this.j.put(readObject, objectInputStream.readObject());
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    protected ConcurrentMap<K, V> b() {
        return this.j;
    }
}
