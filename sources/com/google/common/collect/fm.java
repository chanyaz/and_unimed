package com.google.common.collect;

import java.util.AbstractQueue;
import java.util.Iterator;

final class fm<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
    final ReferenceEntry<K, V> a = new fh<K, V>() {
        ReferenceEntry<K, V> a = this;
        ReferenceEntry<K, V> b = this;

        public ReferenceEntry<K, V> getNextEvictable() {
            return this.a;
        }

        public ReferenceEntry<K, V> getPreviousEvictable() {
            return this.b;
        }

        public void setNextEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.a = referenceEntry;
        }

        public void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry) {
            this.b = referenceEntry;
        }
    };

    fm() {
    }

    /* renamed from: a */
    public ReferenceEntry<K, V> peek() {
        ReferenceEntry<K, V> nextEvictable = this.a.getNextEvictable();
        return nextEvictable == this.a ? null : nextEvictable;
    }

    /* renamed from: a */
    public boolean offer(ReferenceEntry<K, V> referenceEntry) {
        MapMakerInternalMap.b(referenceEntry.getPreviousEvictable(), referenceEntry.getNextEvictable());
        MapMakerInternalMap.b(this.a.getPreviousEvictable(), referenceEntry);
        MapMakerInternalMap.b(referenceEntry, this.a);
        return true;
    }

    /* renamed from: b */
    public ReferenceEntry<K, V> poll() {
        ReferenceEntry<K, V> nextEvictable = this.a.getNextEvictable();
        if (nextEvictable == this.a) {
            return null;
        }
        remove(nextEvictable);
        return nextEvictable;
    }

    public void clear() {
        ReferenceEntry nextEvictable = this.a.getNextEvictable();
        while (nextEvictable != this.a) {
            ReferenceEntry nextEvictable2 = nextEvictable.getNextEvictable();
            MapMakerInternalMap.e(nextEvictable);
            nextEvictable = nextEvictable2;
        }
        this.a.setNextEvictable(this.a);
        this.a.setPreviousEvictable(this.a);
    }

    public boolean contains(Object obj) {
        return ((ReferenceEntry) obj).getNextEvictable() != fr.INSTANCE;
    }

    public boolean isEmpty() {
        return this.a.getNextEvictable() == this.a;
    }

    public Iterator<ReferenceEntry<K, V>> iterator() {
        return new am<ReferenceEntry<K, V>>(peek()) {
            protected ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                ReferenceEntry<K, V> nextEvictable = referenceEntry.getNextEvictable();
                return nextEvictable == fm.this.a ? null : nextEvictable;
            }
        };
    }

    public boolean remove(Object obj) {
        ReferenceEntry referenceEntry = (ReferenceEntry) obj;
        ReferenceEntry previousEvictable = referenceEntry.getPreviousEvictable();
        ReferenceEntry nextEvictable = referenceEntry.getNextEvictable();
        MapMakerInternalMap.b(previousEvictable, nextEvictable);
        MapMakerInternalMap.e(referenceEntry);
        return nextEvictable != fr.INSTANCE;
    }

    public int size() {
        int i = 0;
        for (ReferenceEntry nextEvictable = this.a.getNextEvictable(); nextEvictable != this.a; nextEvictable = nextEvictable.getNextEvictable()) {
            i++;
        }
        return i;
    }
}
