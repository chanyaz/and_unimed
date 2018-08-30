package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultimap<K, V> extends an<K, V> {
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 1;
    @VisibleForTesting
    transient int a;
    private transient eu<K, V> b;

    interface ValueSetLink<K, V> {
        ValueSetLink<K, V> getPredecessorInValueSet();

        ValueSetLink<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink);

        void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink);
    }

    private static <K, V> void b(ValueSetLink<K, V> valueSetLink) {
        b(valueSetLink.getPredecessorInValueSet(), valueSetLink.getSuccessorInValueSet());
    }

    private static <K, V> void b(ValueSetLink<K, V> valueSetLink, ValueSetLink<K, V> valueSetLink2) {
        valueSetLink.setSuccessorInValueSet(valueSetLink2);
        valueSetLink2.setPredecessorInValueSet(valueSetLink);
    }

    private static <K, V> void b(eu<K, V> euVar) {
        b(euVar.a(), euVar.b());
    }

    private static <K, V> void b(eu<K, V> euVar, eu<K, V> euVar2) {
        euVar.a(euVar2);
        euVar2.b(euVar);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        int i;
        objectInputStream.defaultReadObject();
        this.b = new eu(null, null, 0, null);
        b(this.b, this.b);
        this.a = objectInputStream.readInt();
        int readInt = objectInputStream.readInt();
        Map linkedHashMap = new LinkedHashMap(Maps.b(readInt));
        for (i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            linkedHashMap.put(readObject, a(readObject));
        }
        readInt = objectInputStream.readInt();
        for (i = 0; i < readInt; i++) {
            Object readObject2 = objectInputStream.readObject();
            ((Collection) linkedHashMap.get(readObject2)).add(objectInputStream.readObject());
        }
        a(linkedHashMap);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.a);
        objectOutputStream.writeInt(keySet().size());
        for (Object writeObject : keySet()) {
            objectOutputStream.writeObject(writeObject);
        }
        objectOutputStream.writeInt(size());
        for (Entry entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    Collection<V> a(K k) {
        return new ev(this, k, this.a);
    }

    /* renamed from: a */
    Set<V> c() {
        return new LinkedHashSet(this.a);
    }

    public void clear() {
        super.clear();
        b(this.b, this.b);
    }

    public Set<Entry<K, V>> entries() {
        return super.entries();
    }

    Iterator<V> g() {
        return Maps.b(h());
    }

    Iterator<Entry<K, V>> h() {
        return new Iterator<Entry<K, V>>() {
            eu<K, V> a = LinkedHashMultimap.this.b.h;
            eu<K, V> b;

            /* renamed from: a */
            public Entry<K, V> next() {
                if (hasNext()) {
                    Entry entry = this.a;
                    this.b = entry;
                    this.a = this.a.h;
                    return entry;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                return this.a != LinkedHashMultimap.this.b;
            }

            public void remove() {
                ba.a(this.b != null);
                LinkedHashMultimap.this.remove(this.b.getKey(), this.b.getValue());
                this.b = null;
            }
        };
    }

    public Set<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        return super.replaceValues((Object) k, (Iterable) iterable);
    }

    public Collection<V> values() {
        return super.values();
    }
}
