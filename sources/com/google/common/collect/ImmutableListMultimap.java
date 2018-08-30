package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0;

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
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
            j.b(readObject, ImmutableList.a(objArr));
            i += readInt2;
        }
        try {
            dt.a.a((Object) this, j.b());
            dt.b.a((Object) this, i);
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        hx.a((Multimap) this, objectOutputStream);
    }

    /* renamed from: a */
    public ImmutableList<V> get(@Nullable K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.a.get(k);
        return immutableList == null ? ImmutableList.e() : immutableList;
    }

    @Deprecated
    /* renamed from: a */
    public ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* renamed from: b */
    public ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }
}
