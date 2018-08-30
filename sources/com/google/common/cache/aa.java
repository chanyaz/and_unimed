package com.google.common.cache;

enum aa {
    STRONG {
        <K, V> ValueReference<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, V v, int i) {
            return i == 1 ? new ae(v) : new ao(v, i);
        }
    },
    SOFT {
        <K, V> ValueReference<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, V v, int i) {
            return i == 1 ? new z(yVar.i, v, referenceEntry) : new an(yVar.i, v, referenceEntry, i);
        }
    },
    WEAK {
        <K, V> ValueReference<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, V v, int i) {
            return i == 1 ? new al(yVar.i, v, referenceEntry) : new ap(yVar.i, v, referenceEntry, i);
        }
    };

    abstract <K, V> ValueReference<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, V v, int i);
}
