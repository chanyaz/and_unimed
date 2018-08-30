package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

final class hx {
    private hx() {
    }

    static int a(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    static <T> hy<T> a(Class<T> cls, String str) {
        try {
            return new hy(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    static <K, V> void a(Multimap<K, V> multimap, ObjectInputStream objectInputStream) {
        a((Multimap) multimap, objectInputStream, objectInputStream.readInt());
    }

    static <K, V> void a(Multimap<K, V> multimap, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            Collection collection = multimap.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    static <K, V> void a(Multimap<K, V> multimap, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(multimap.asMap().size());
        for (Entry entry : multimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            for (Object writeObject : (Collection) entry.getValue()) {
                objectOutputStream.writeObject(writeObject);
            }
        }
    }

    static <E> void a(Multiset<E> multiset, ObjectInputStream objectInputStream) {
        a((Multiset) multiset, objectInputStream, objectInputStream.readInt());
    }

    static <E> void a(Multiset<E> multiset, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            multiset.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static <E> void a(Multiset<E> multiset, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(multiset.entrySet().size());
        for (Multiset.Entry entry : multiset.entrySet()) {
            objectOutputStream.writeObject(entry.getElement());
            objectOutputStream.writeInt(entry.getCount());
        }
    }

    static <K, V> void a(Map<K, V> map, ObjectInputStream objectInputStream) {
        a((Map) map, objectInputStream, objectInputStream.readInt());
    }

    static <K, V> void a(Map<K, V> map, ObjectInputStream objectInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    static <K, V> void a(Map<K, V> map, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }
}
