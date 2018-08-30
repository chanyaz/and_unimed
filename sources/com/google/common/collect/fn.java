package com.google.common.collect;

import java.util.AbstractQueue;
import java.util.Iterator;

final class fn<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
    final ReferenceEntry<K, V> a = new fh<K, V>() {
        ReferenceEntry<K, V> a = this;
        ReferenceEntry<K, V> b = this;

        public long getExpirationTime() {
            return Long.MAX_VALUE;
        }

        public ReferenceEntry<K, V> getNextExpirable() {
            return this.a;
        }

        public ReferenceEntry<K, V> getPreviousExpirable() {
            return this.b;
        }

        public void setExpirationTime(long j) {
        }

        public void setNextExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.a = referenceEntry;
        }

        public void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry) {
            this.b = referenceEntry;
        }
    };

    fn() {
    }

    /* renamed from: a */
    public ReferenceEntry<K, V> peek() {
        ReferenceEntry<K, V> nextExpirable = this.a.getNextExpirable();
        return nextExpirable == this.a ? null : nextExpirable;
    }

    /* renamed from: a */
    public boolean offer(ReferenceEntry<K, V> referenceEntry) {
        MapMakerInternalMap.a(referenceEntry.getPreviousExpirable(), referenceEntry.getNextExpirable());
        MapMakerInternalMap.a(this.a.getPreviousExpirable(), (ReferenceEntry) referenceEntry);
        MapMakerInternalMap.a((ReferenceEntry) referenceEntry, this.a);
        return true;
    }

    /* renamed from: b */
    public ReferenceEntry<K, V> poll() {
        ReferenceEntry<K, V> nextExpirable = this.a.getNextExpirable();
        if (nextExpirable == this.a) {
            return null;
        }
        remove(nextExpirable);
        return nextExpirable;
    }

    public void clear() {
        ReferenceEntry nextExpirable = this.a.getNextExpirable();
        while (nextExpirable != this.a) {
            ReferenceEntry nextExpirable2 = nextExpirable.getNextExpirable();
            MapMakerInternalMap.d(nextExpirable);
            nextExpirable = nextExpirable2;
        }
        this.a.setNextExpirable(this.a);
        this.a.setPreviousExpirable(this.a);
    }

    public boolean contains(Object obj) {
        return ((ReferenceEntry) obj).getNextExpirable() != fr.INSTANCE;
    }

    public boolean isEmpty() {
        return this.a.getNextExpirable() == this.a;
    }

    public Iterator<ReferenceEntry<K, V>> iterator() {
        return new am<ReferenceEntry<K, V>>(peek()) {
            protected ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                ReferenceEntry<K, V> nextExpirable = referenceEntry.getNextExpirable();
                return nextExpirable == fn.this.a ? null : nextExpirable;
            }
        };
    }

    public boolean remove(Object obj) {
        ReferenceEntry referenceEntry = (ReferenceEntry) obj;
        ReferenceEntry previousExpirable = referenceEntry.getPreviousExpirable();
        ReferenceEntry nextExpirable = referenceEntry.getNextExpirable();
        MapMakerInternalMap.a(previousExpirable, nextExpirable);
        MapMakerInternalMap.d(referenceEntry);
        return nextExpirable != fr.INSTANCE;
    }

    public int size() {
        int i = 0;
        for (ReferenceEntry nextExpirable = this.a.getNextExpirable(); nextExpirable != this.a; nextExpirable = nextExpirable.getNextExpirable()) {
            i++;
        }
        return i;
    }
}
