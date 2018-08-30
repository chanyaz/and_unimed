package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Map.Entry;

class d<K, V> implements Entry<K, V> {
    @NonNull
    final K a;
    @NonNull
    final V b;
    d<K, V> c;
    d<K, V> d;

    d(@NonNull K k, @NonNull V v) {
        this.a = k;
        this.b = v;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a.equals(dVar.a) && this.b.equals(dVar.b);
    }

    @NonNull
    public K getKey() {
        return this.a;
    }

    @NonNull
    public V getValue() {
        return this.b;
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public String toString() {
        return this.a + "=" + this.b;
    }
}
