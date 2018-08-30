package dagger.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

abstract class h<K, V> {
    private final Map<K, V> a = new LinkedHashMap();
    private final Lock b;
    private final Lock c;

    public h() {
        ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.b = reentrantReadWriteLock.readLock();
        this.c = reentrantReadWriteLock.writeLock();
    }

    protected abstract V a(K k);

    public final V b(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        this.b.lock();
        try {
            V v = this.a.get(k);
            if (v == null) {
                this.b.unlock();
                v = a(k);
                if (v == null) {
                    throw new NullPointerException("create returned null");
                }
                this.c.lock();
                try {
                    this.a.put(k, v);
                } finally {
                    this.c.unlock();
                }
            }
            return v;
        } finally {
            this.b.unlock();
        }
    }

    public final String toString() {
        this.b.lock();
        try {
            String obj = this.a.toString();
            return obj;
        } finally {
            this.b.unlock();
        }
    }
}
