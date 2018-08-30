package com.google.common.cache;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

enum q {
    STRONG {
        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new ad(k, i, referenceEntry);
        }
    },
    STRONG_ACCESS {
        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a(yVar, referenceEntry, referenceEntry2);
            a(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new ab(k, i, referenceEntry);
        }
    },
    STRONG_WRITE {
        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a(yVar, referenceEntry, referenceEntry2);
            b(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new af(k, i, referenceEntry);
        }
    },
    STRONG_ACCESS_WRITE {
        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a(yVar, referenceEntry, referenceEntry2);
            a(referenceEntry, a);
            b(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new ac(k, i, referenceEntry);
        }
    },
    WEAK {
        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new ak(yVar.h, k, i, referenceEntry);
        }
    },
    WEAK_ACCESS {
        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a(yVar, referenceEntry, referenceEntry2);
            a(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new ai(yVar.h, k, i, referenceEntry);
        }
    },
    WEAK_WRITE {
        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a(yVar, referenceEntry, referenceEntry2);
            b(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new am(yVar.h, k, i, referenceEntry);
        }
    },
    WEAK_ACCESS_WRITE {
        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ReferenceEntry<K, V> a = super.a(yVar, referenceEntry, referenceEntry2);
            a(referenceEntry, a);
            b(referenceEntry, a);
            return a;
        }

        <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
            return new aj(yVar.h, k, i, referenceEntry);
        }
    };
    
    static final q[] i = null;

    static {
        i = new q[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
    }

    @GuardedBy("Segment.this")
    <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        return a(yVar, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
    }

    abstract <K, V> ReferenceEntry<K, V> a(y<K, V> yVar, K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry);

    @GuardedBy("Segment.this")
    <K, V> void a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
        LocalCache.a(referenceEntry.getPreviousInAccessQueue(), (ReferenceEntry) referenceEntry2);
        LocalCache.a((ReferenceEntry) referenceEntry2, referenceEntry.getNextInAccessQueue());
        LocalCache.b((ReferenceEntry) referenceEntry);
    }

    @GuardedBy("Segment.this")
    <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
        LocalCache.b(referenceEntry.getPreviousInWriteQueue(), (ReferenceEntry) referenceEntry2);
        LocalCache.b((ReferenceEntry) referenceEntry2, referenceEntry.getNextInWriteQueue());
        LocalCache.c(referenceEntry);
    }
}
