package com.google.common.collect;

import com.google.common.base.Equivalence;

enum fv {
    STRONG {
        Equivalence<Object> a() {
            return Equivalence.a();
        }

        <K, V> ValueReference<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, V v) {
            return new ga(v);
        }
    },
    SOFT {
        Equivalence<Object> a() {
            return Equivalence.b();
        }

        <K, V> ValueReference<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, V v) {
            return new fu(fsVar.h, v, referenceEntry);
        }
    },
    WEAK {
        Equivalence<Object> a() {
            return Equivalence.b();
        }

        <K, V> ValueReference<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, V v) {
            return new gh(fsVar.h, v, referenceEntry);
        }
    };

    abstract Equivalence<Object> a();

    abstract <K, V> ValueReference<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, V v);
}
