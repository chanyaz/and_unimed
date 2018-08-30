package com.google.common.collect;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class fs<K, V> extends ReentrantLock {
    final MapMakerInternalMap<K, V> a;
    volatile int b;
    int c;
    int d;
    volatile AtomicReferenceArray<ReferenceEntry<K, V>> e;
    final int f;
    final ReferenceQueue<K> g;
    final ReferenceQueue<V> h;
    final Queue<ReferenceEntry<K, V>> i;
    final AtomicInteger j = new AtomicInteger();
    @GuardedBy("Segment.this")
    final Queue<ReferenceEntry<K, V>> k;
    @GuardedBy("Segment.this")
    final Queue<ReferenceEntry<K, V>> l;

    fs(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
        ReferenceQueue referenceQueue = null;
        this.a = mapMakerInternalMap;
        this.f = i2;
        a(a(i));
        this.g = mapMakerInternalMap.e() ? new ReferenceQueue() : null;
        if (mapMakerInternalMap.f()) {
            referenceQueue = new ReferenceQueue();
        }
        this.h = referenceQueue;
        Queue concurrentLinkedQueue = (mapMakerInternalMap.a() || mapMakerInternalMap.d()) ? new ConcurrentLinkedQueue() : MapMakerInternalMap.i();
        this.i = concurrentLinkedQueue;
        this.k = mapMakerInternalMap.a() ? new fm() : MapMakerInternalMap.i();
        this.l = mapMakerInternalMap.b() ? new fn() : MapMakerInternalMap.i();
    }

    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        ValueReference valueReference = referenceEntry.getValueReference();
        Object obj = valueReference.get();
        if (obj == null && !valueReference.isComputingReference()) {
            return null;
        }
        ReferenceEntry<K, V> a = this.a.n.a(this, (ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
        a.setValueReference(valueReference.copyFor(this.h, obj, a));
        return a;
    }

    ReferenceEntry<K, V> a(Object obj, int i) {
        if (this.b != 0) {
            for (ReferenceEntry<K, V> b = b(i); b != null; b = b.getNext()) {
                if (b.getHash() == i) {
                    Object key = b.getKey();
                    if (key == null) {
                        a();
                    } else if (this.a.e.a(obj, key)) {
                        return b;
                    }
                }
            }
        }
        return null;
    }

    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> a(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        return this.a.n.a(this, k, i, referenceEntry);
    }

    V a(K k, int i, V v) {
        lock();
        try {
            o();
            AtomicReferenceArray atomicReferenceArray = this.e;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.e.a(k, key)) {
                    ValueReference valueReference = referenceEntry2.getValueReference();
                    V v2 = valueReference.get();
                    if (v2 == null) {
                        if (a(valueReference)) {
                            int i2 = this.b - 1;
                            this.c++;
                            a(key, i, (Object) v2, ff.COLLECTED);
                            int i3 = this.b - 1;
                            atomicReferenceArray.set(length, b(referenceEntry, referenceEntry2));
                            this.b = i3;
                        }
                        unlock();
                        p();
                        return null;
                    }
                    this.c++;
                    a((Object) k, i, (Object) v2, ff.REPLACED);
                    a(referenceEntry2, (Object) v);
                    unlock();
                    p();
                    return v2;
                }
            }
            unlock();
            p();
            return null;
        } catch (Throwable th) {
            unlock();
            p();
        }
    }

    V a(K k, int i, V v, boolean z) {
        V v2 = null;
        lock();
        try {
            o();
            int i2 = this.b + 1;
            if (i2 > this.d) {
                l();
                i2 = this.b + 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.e;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.e.a(k, key)) {
                    ValueReference valueReference = referenceEntry2.getValueReference();
                    Object obj = valueReference.get();
                    if (obj == null) {
                        this.c++;
                        a(referenceEntry2, (Object) v);
                        if (!valueReference.isComputingReference()) {
                            a((Object) k, i, obj, ff.COLLECTED);
                            i2 = this.b;
                        } else if (k()) {
                            i2 = this.b + 1;
                        }
                        this.b = i2;
                        return v2;
                    } else if (z) {
                        b(referenceEntry2);
                        unlock();
                        p();
                        return obj;
                    } else {
                        this.c++;
                        v2 = ff.REPLACED;
                        a((Object) k, i, obj, (ff) v2);
                        a(referenceEntry2, (Object) v);
                        unlock();
                        p();
                        return obj;
                    }
                }
            }
            this.c++;
            referenceEntry = a((Object) k, i, referenceEntry);
            a(referenceEntry, (Object) v);
            atomicReferenceArray.set(length, referenceEntry);
            this.b = k() ? this.b + 1 : i2;
            unlock();
            p();
            return null;
        } finally {
            unlock();
            p();
        }
    }

    AtomicReferenceArray<ReferenceEntry<K, V>> a(int i) {
        return new AtomicReferenceArray(i);
    }

    void a() {
        if (tryLock()) {
            try {
                b();
            } finally {
                unlock();
            }
        }
    }

    void a(ReferenceEntry<K, V> referenceEntry) {
        if (this.a.d()) {
            a((ReferenceEntry) referenceEntry, this.a.j);
        }
        this.i.add(referenceEntry);
    }

    void a(ReferenceEntry<K, V> referenceEntry, long j) {
        referenceEntry.setExpirationTime(this.a.o.a() + j);
    }

    void a(ReferenceEntry<K, V> referenceEntry, ff ffVar) {
        a(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), ffVar);
    }

    @GuardedBy("Segment.this")
    void a(ReferenceEntry<K, V> referenceEntry, V v) {
        referenceEntry.setValueReference(this.a.h.a(this, referenceEntry, v));
        c(referenceEntry);
    }

    void a(@Nullable K k, int i, @Nullable V v, ff ffVar) {
        if (this.a.l != MapMakerInternalMap.q) {
            this.a.l.offer(new fg(k, v, ffVar));
        }
    }

    void a(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
        this.d = (atomicReferenceArray.length() * 3) / 4;
        if (this.d == this.f) {
            this.d++;
        }
        this.e = atomicReferenceArray;
    }

    boolean a(ReferenceEntry<K, V> referenceEntry, int i) {
        lock();
        try {
            int i2 = this.b - 1;
            AtomicReferenceArray atomicReferenceArray = this.e;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.c++;
                    a(referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), ff.COLLECTED);
                    referenceEntry2 = b(referenceEntry2, referenceEntry3);
                    int i3 = this.b - 1;
                    atomicReferenceArray.set(length, referenceEntry2);
                    this.b = i3;
                    return true;
                }
            }
            unlock();
            p();
            return false;
        } finally {
            unlock();
            p();
        }
    }

    @GuardedBy("Segment.this")
    boolean a(ReferenceEntry<K, V> referenceEntry, int i, ff ffVar) {
        int i2 = this.b - 1;
        AtomicReferenceArray atomicReferenceArray = this.e;
        int length = i & (atomicReferenceArray.length() - 1);
        ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
        for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
            if (referenceEntry3 == referenceEntry) {
                this.c++;
                a(referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), ffVar);
                referenceEntry2 = b(referenceEntry2, referenceEntry3);
                int i3 = this.b - 1;
                atomicReferenceArray.set(length, referenceEntry2);
                this.b = i3;
                return true;
            }
        }
        return false;
    }

    boolean a(ValueReference<K, V> valueReference) {
        return !valueReference.isComputingReference() && valueReference.get() == null;
    }

    boolean a(K k, int i, ValueReference<K, V> valueReference) {
        lock();
        try {
            int i2 = this.b - 1;
            AtomicReferenceArray atomicReferenceArray = this.e;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            ReferenceEntry referenceEntry2 = referenceEntry;
            while (referenceEntry2 != null) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() != i || key == null || !this.a.e.a(k, key)) {
                    referenceEntry2 = referenceEntry2.getNext();
                } else if (referenceEntry2.getValueReference() == valueReference) {
                    this.c++;
                    a((Object) k, i, valueReference.get(), ff.COLLECTED);
                    int i3 = this.b - 1;
                    atomicReferenceArray.set(length, b(referenceEntry, referenceEntry2));
                    this.b = i3;
                    return true;
                } else {
                    unlock();
                    if (!isHeldByCurrentThread()) {
                        p();
                    }
                    return false;
                }
            }
            unlock();
            if (!isHeldByCurrentThread()) {
                p();
            }
            return false;
        } finally {
            unlock();
            if (!isHeldByCurrentThread()) {
                p();
            }
        }
    }

    boolean a(K k, int i, V v, V v2) {
        lock();
        try {
            o();
            AtomicReferenceArray atomicReferenceArray = this.e;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.e.a(k, key)) {
                    ValueReference valueReference = referenceEntry2.getValueReference();
                    Object obj = valueReference.get();
                    if (obj == null) {
                        if (a(valueReference)) {
                            int i2 = this.b - 1;
                            this.c++;
                            a(key, i, obj, ff.COLLECTED);
                            referenceEntry = b(referenceEntry, referenceEntry2);
                            int i3 = this.b - 1;
                            atomicReferenceArray.set(length, referenceEntry);
                            this.b = i3;
                        }
                        unlock();
                        p();
                        return false;
                    } else if (this.a.f.a(v, obj)) {
                        this.c++;
                        a((Object) k, i, obj, ff.REPLACED);
                        a(referenceEntry2, (Object) v2);
                        unlock();
                        p();
                        return true;
                    } else {
                        b(referenceEntry2);
                        unlock();
                        p();
                        return false;
                    }
                }
            }
            unlock();
            p();
            return false;
        } catch (Throwable th) {
            unlock();
            p();
        }
    }

    ReferenceEntry<K, V> b(int i) {
        AtomicReferenceArray atomicReferenceArray = this.e;
        return (ReferenceEntry) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i);
    }

    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        this.k.remove(referenceEntry2);
        this.l.remove(referenceEntry2);
        int i = this.b;
        ReferenceEntry<K, V> next = referenceEntry2.getNext();
        ReferenceEntry referenceEntry3;
        while (referenceEntry3 != referenceEntry2) {
            int i2;
            ReferenceEntry<K, V> a = a(referenceEntry3, (ReferenceEntry) next);
            if (a != null) {
                i2 = i;
            } else {
                d(referenceEntry3);
                ReferenceEntry<K, V> referenceEntry4 = next;
                i2 = i - 1;
                a = referenceEntry4;
            }
            referenceEntry3 = referenceEntry3.getNext();
            i = i2;
            next = a;
        }
        this.b = i;
        return next;
    }

    ReferenceEntry<K, V> b(Object obj, int i) {
        ReferenceEntry<K, V> a = a(obj, i);
        if (a == null) {
            return null;
        }
        if (!this.a.b() || !this.a.c((ReferenceEntry) a)) {
            return a;
        }
        i();
        return null;
    }

    @GuardedBy("Segment.this")
    void b() {
        if (this.a.e()) {
            c();
        }
        if (this.a.f()) {
            d();
        }
    }

    @GuardedBy("Segment.this")
    void b(ReferenceEntry<K, V> referenceEntry) {
        this.k.add(referenceEntry);
        if (this.a.d()) {
            a((ReferenceEntry) referenceEntry, this.a.j);
            this.l.add(referenceEntry);
        }
    }

    boolean b(Object obj, int i, Object obj2) {
        lock();
        try {
            o();
            int i2 = this.b - 1;
            AtomicReferenceArray atomicReferenceArray = this.e;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.e.a(obj, key)) {
                    ff ffVar;
                    ValueReference valueReference = referenceEntry2.getValueReference();
                    Object obj3 = valueReference.get();
                    if (this.a.f.a(obj2, obj3)) {
                        ffVar = ff.EXPLICIT;
                    } else if (a(valueReference)) {
                        ffVar = ff.COLLECTED;
                    } else {
                        unlock();
                        p();
                        return false;
                    }
                    this.c++;
                    a(key, i, obj3, ffVar);
                    referenceEntry = b(referenceEntry, referenceEntry2);
                    int i3 = this.b - 1;
                    atomicReferenceArray.set(length, referenceEntry);
                    this.b = i3;
                    boolean z = ffVar == ff.EXPLICIT;
                    unlock();
                    p();
                    return z;
                }
            }
            unlock();
            p();
            return false;
        } catch (Throwable th) {
            unlock();
            p();
        }
    }

    V c(Object obj, int i) {
        try {
            ReferenceEntry b = b(obj, i);
            if (b == null) {
                return null;
            }
            V v = b.getValueReference().get();
            if (v != null) {
                a(b);
            } else {
                a();
            }
            n();
            return v;
        } finally {
            n();
        }
    }

    @GuardedBy("Segment.this")
    void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            Reference poll = this.g.poll();
            if (poll != null) {
                this.a.a((ReferenceEntry) poll);
                i = i2 + 1;
                if (i == 16) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @GuardedBy("Segment.this")
    void c(ReferenceEntry<K, V> referenceEntry) {
        h();
        this.k.add(referenceEntry);
        if (this.a.b()) {
            a((ReferenceEntry) referenceEntry, this.a.d() ? this.a.j : this.a.k);
            this.l.add(referenceEntry);
        }
    }

    @GuardedBy("Segment.this")
    void d() {
        int i = 0;
        while (true) {
            int i2 = i;
            Reference poll = this.h.poll();
            if (poll != null) {
                this.a.a((ValueReference) poll);
                i = i2 + 1;
                if (i == 16) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    void d(ReferenceEntry<K, V> referenceEntry) {
        a((ReferenceEntry) referenceEntry, ff.COLLECTED);
        this.k.remove(referenceEntry);
        this.l.remove(referenceEntry);
    }

    boolean d(Object obj, int i) {
        boolean z = false;
        try {
            if (this.b != 0) {
                ReferenceEntry b = b(obj, i);
                if (b != null) {
                    if (b.getValueReference().get() != null) {
                        z = true;
                    }
                    n();
                }
            } else {
                n();
            }
            return z;
        } finally {
            n();
        }
    }

    V e(ReferenceEntry<K, V> referenceEntry) {
        if (referenceEntry.getKey() == null) {
            a();
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        if (v == null) {
            a();
            return null;
        } else if (!this.a.b() || !this.a.c((ReferenceEntry) referenceEntry)) {
            return v;
        } else {
            i();
            return null;
        }
    }

    V e(Object obj, int i) {
        lock();
        try {
            o();
            int i2 = this.b - 1;
            AtomicReferenceArray atomicReferenceArray = this.e;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                V hash = referenceEntry2.getHash();
                if (hash == i && key != null) {
                    hash = this.a.e.a(obj, key);
                    if (hash != null) {
                        ff ffVar;
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        hash = valueReference.get();
                        if (hash != null) {
                            ffVar = ff.EXPLICIT;
                        } else if (a(valueReference)) {
                            ffVar = ff.COLLECTED;
                        } else {
                            unlock();
                            p();
                            return null;
                        }
                        this.c++;
                        a(key, i, (Object) hash, ffVar);
                        int i3 = this.b - 1;
                        atomicReferenceArray.set(length, b(referenceEntry, referenceEntry2));
                        this.b = i3;
                        return hash;
                    }
                }
            }
            unlock();
            p();
            return null;
        } finally {
            unlock();
            p();
        }
    }

    void e() {
        if (this.a.e()) {
            f();
        }
        if (this.a.f()) {
            g();
        }
    }

    void f() {
        do {
        } while (this.g.poll() != null);
    }

    void g() {
        do {
        } while (this.h.poll() != null);
    }

    @GuardedBy("Segment.this")
    void h() {
        while (true) {
            ReferenceEntry referenceEntry = (ReferenceEntry) this.i.poll();
            if (referenceEntry != null) {
                if (this.k.contains(referenceEntry)) {
                    this.k.add(referenceEntry);
                }
                if (this.a.d() && this.l.contains(referenceEntry)) {
                    this.l.add(referenceEntry);
                }
            } else {
                return;
            }
        }
    }

    void i() {
        if (tryLock()) {
            try {
                j();
            } finally {
                unlock();
            }
        }
    }

    @GuardedBy("Segment.this")
    void j() {
        h();
        if (!this.l.isEmpty()) {
            long a = this.a.o.a();
            ReferenceEntry referenceEntry;
            do {
                referenceEntry = (ReferenceEntry) this.l.peek();
                if (referenceEntry == null || !this.a.a(referenceEntry, a)) {
                    return;
                }
            } while (a(referenceEntry, referenceEntry.getHash(), ff.EXPIRED));
            throw new AssertionError();
        }
    }

    @GuardedBy("Segment.this")
    boolean k() {
        if (!this.a.a() || this.b < this.f) {
            return false;
        }
        h();
        ReferenceEntry referenceEntry = (ReferenceEntry) this.k.remove();
        if (a(referenceEntry, referenceEntry.getHash(), ff.SIZE)) {
            return true;
        }
        throw new AssertionError();
    }

    @GuardedBy("Segment.this")
    void l() {
        AtomicReferenceArray atomicReferenceArray = this.e;
        int length = atomicReferenceArray.length();
        if (length < 1073741824) {
            int i = this.b;
            AtomicReferenceArray a = a(length << 1);
            this.d = (a.length() * 3) / 4;
            int length2 = a.length() - 1;
            int i2 = 0;
            while (i2 < length) {
                int i3;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i2);
                if (referenceEntry != null) {
                    ReferenceEntry next = referenceEntry.getNext();
                    int hash = referenceEntry.getHash() & length2;
                    if (next == null) {
                        a.set(hash, referenceEntry);
                        i3 = i;
                    } else {
                        ReferenceEntry referenceEntry2;
                        ReferenceEntry referenceEntry3 = referenceEntry;
                        while (next != null) {
                            i3 = next.getHash() & length2;
                            if (i3 != hash) {
                                referenceEntry2 = next;
                            } else {
                                i3 = hash;
                                referenceEntry2 = referenceEntry3;
                            }
                            next = next.getNext();
                            referenceEntry3 = referenceEntry2;
                            hash = i3;
                        }
                        a.set(hash, referenceEntry3);
                        referenceEntry2 = referenceEntry;
                        i3 = i;
                        while (referenceEntry2 != referenceEntry3) {
                            int i4;
                            int hash2 = referenceEntry2.getHash() & length2;
                            referenceEntry = a(referenceEntry2, (ReferenceEntry) a.get(hash2));
                            if (referenceEntry != null) {
                                a.set(hash2, referenceEntry);
                                i4 = i3;
                            } else {
                                d(referenceEntry2);
                                i4 = i3 - 1;
                            }
                            referenceEntry2 = referenceEntry2.getNext();
                            i3 = i4;
                        }
                    }
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
            this.e = a;
            this.b = i;
        }
    }

    void m() {
        if (this.b != 0) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.e;
                if (this.a.l != MapMakerInternalMap.q) {
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (!referenceEntry.getValueReference().isComputingReference()) {
                                a(referenceEntry, ff.EXPLICIT);
                            }
                        }
                    }
                }
                for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                    atomicReferenceArray.set(i2, null);
                }
                e();
                this.k.clear();
                this.l.clear();
                this.j.set(0);
                this.c++;
                this.b = 0;
            } finally {
                unlock();
                p();
            }
        }
    }

    void n() {
        if ((this.j.incrementAndGet() & 63) == 0) {
            q();
        }
    }

    @GuardedBy("Segment.this")
    void o() {
        r();
    }

    void p() {
        s();
    }

    void q() {
        r();
        s();
    }

    void r() {
        if (tryLock()) {
            try {
                b();
                j();
                this.j.set(0);
            } finally {
                unlock();
            }
        }
    }

    void s() {
        if (!isHeldByCurrentThread()) {
            this.a.j();
        }
    }
}
