package dagger.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueMap<K, V> extends LinkedHashMap<K, V> {
    public V put(K k, V v) {
        Object put = super.put(k, v);
        if (put == null) {
            return null;
        }
        super.put(k, put);
        throw new IllegalArgumentException("Duplicate:\n    " + put + "\n    " + v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }
}
