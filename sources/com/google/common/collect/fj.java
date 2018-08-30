package com.google.common.collect;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

enum fj {
    STRONG {
        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new fw(k, i, referenceEntry);
        }
    },
    STRONG_EXPIRABLE {
        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a((fs) fsVar, (ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            a(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new fy(k, i, referenceEntry);
        }
    },
    STRONG_EVICTABLE {
        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a((fs) fsVar, (ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            b(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new fx(k, i, referenceEntry);
        }
    },
    STRONG_EXPIRABLE_EVICTABLE {
        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a((fs) fsVar, (ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            a(referenceEntry, a);
            b(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new fz(k, i, referenceEntry);
        }
    },
    WEAK {
        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new gd(fsVar.g, k, i, referenceEntry);
        }
    },
    WEAK_EXPIRABLE {
        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a((fs) fsVar, (ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            a(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new gf(fsVar.g, k, i, referenceEntry);
        }
    },
    WEAK_EVICTABLE {
        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a((fs) fsVar, (ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            b(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new ge(fsVar.g, k, i, referenceEntry);
        }
    },
    WEAK_EXPIRABLE_EVICTABLE {
        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a((fs) fsVar, (ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
            a(referenceEntry, a);
            b(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new gg(fsVar.g, k, i, referenceEntry);
        }
    };
    
    static final fj[][] i = null;

    static {
        r0 = new fj[3][];
        r0[0] = new fj[]{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE};
        r0[1] = new fj[0];
        r0[2] = new fj[]{WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE};
        i = r0;
    }

    static fj a(fv fvVar, boolean z, boolean z2) {
        int i = 0;
        int i2 = z ? 1 : 0;
        if (z2) {
            i = 2;
        }
        return i[fvVar.ordinal()][i | i2];
    }

    @GuardedBy("Segment.this")
    <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        return a(fsVar, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
    }

    abstract <K, V> ReferenceEntry<K, V> a(fs<K, V> fsVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry);

    @GuardedBy("Segment.this")
    <K, V> void a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry2.setExpirationTime(referenceEntry.getExpirationTime());
        MapMakerInternalMap.a(referenceEntry.getPreviousExpirable(), (ReferenceEntry) referenceEntry2);
        MapMakerInternalMap.a((ReferenceEntry) referenceEntry2, referenceEntry.getNextExpirable());
        MapMakerInternalMap.d(referenceEntry);
    }

    @GuardedBy("Segment.this")
    <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        MapMakerInternalMap.b(referenceEntry.getPreviousEvictable(), referenceEntry2);
        MapMakerInternalMap.b(referenceEntry2, referenceEntry.getNextEvictable());
        MapMakerInternalMap.e(referenceEntry);
    }
}
