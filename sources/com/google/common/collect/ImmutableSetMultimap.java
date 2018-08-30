package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.o;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> c;
    private transient ImmutableSet<Entry<K, V>> d;

    private static <V> ImmutableSet<V> a(@Nullable Comparator<? super V> comparator) {
        return comparator == null ? ImmutableSet.g() : ImmutableSortedSet.a((Comparator) comparator);
    }

    private static <V> ImmutableSet<V> a(@Nullable Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? ImmutableSet.a((Collection) collection) : ImmutableSortedSet.a((Comparator) comparator, (Collection) collection);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
        di j = ImmutableMap.j();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException("Invalid value count " + readInt2);
            }
            Object[] objArr = new Object[readInt2];
            for (int i3 = 0; i3 < readInt2; i3++) {
                objArr[i3] = objectInputStream.readObject();
            }
            ImmutableSet a = a(comparator, Arrays.asList(objArr));
            if (a.size() != objArr.length) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
            }
            j.b(readObject, a);
            i += readInt2;
        }
        try {
            dt.a.a((Object) this, j.b());
            dt.b.a((Object) this, i);
            dt.c.a((Object) this, a(comparator));
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(t());
        hx.a((Multimap) this, objectOutputStream);
    }

    /* renamed from: a */
    public ImmutableSet<V> get(@Nullable K k) {
        return (ImmutableSet) o.b((ImmutableSet) this.a.get(k), this.c);
    }

    @Deprecated
    /* renamed from: a */
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* renamed from: b */
    public ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: s */
    public ImmutableSet<Entry<K, V>> entries() {
        ImmutableSet<Entry<K, V>> immutableSet = this.d;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = new ef(this);
        this.d = immutableSet;
        return immutableSet;
    }

    @Nullable
    Comparator<? super V> t() {
        return this.c instanceof ImmutableSortedSet ? ((ImmutableSortedSet) this.c).comparator() : null;
    }
}
