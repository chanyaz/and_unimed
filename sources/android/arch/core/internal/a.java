package android.arch.core.internal;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({Scope.LIBRARY_GROUP})
public class a<K, V> extends SafeIterableMap<K, V> {
    private HashMap<K, d<K, V>> a = new HashMap();

    protected d<K, V> a(K k) {
        return (d) this.a.get(k);
    }

    public V a(@NonNull K k, @NonNull V v) {
        d a = a(k);
        if (a != null) {
            return a.b;
        }
        this.a.put(k, b(k, v));
        return null;
    }

    public V b(@NonNull K k) {
        V b = super.b(k);
        this.a.remove(k);
        return b;
    }

    public boolean c(K k) {
        return this.a.containsKey(k);
    }

    public Entry<K, V> d(K k) {
        return c(k) ? ((d) this.a.get(k)).d : null;
    }
}
