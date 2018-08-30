package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class EnumHashBiMap<K extends Enum<K>, V> extends a<K, V> {
    @GwtIncompatible("only needed in emulated source.")
    private static final long serialVersionUID = 0;
    private transient Class<K> b;

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.b = (Class) objectInputStream.readObject();
        a(jn.a(new EnumMap(this.b)), new HashMap((((Enum[]) this.b.getEnumConstants()).length * 3) / 2));
        hx.a((Map) this, objectInputStream);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.b);
        hx.a((Map) this, objectOutputStream);
    }

    K a(K k) {
        return (Enum) s.a((Object) k);
    }

    /* renamed from: a */
    public V put(K k, @Nullable V v) {
        return super.put(k, v);
    }

    /* renamed from: b */
    public V forcePut(K k, @Nullable V v) {
        return super.forcePut(k, v);
    }
}
