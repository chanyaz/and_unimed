package com.google.common.collect;

import com.google.common.base.s;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.Nullable;

class u extends AbstractCollection<V> {
    final K b;
    Collection<V> c;
    final com.google.common.collect.j$com.google.common.collect.u d;
    final Collection<V> e;
    final /* synthetic */ j f;

    u(j jVar, @Nullable K k, Collection<V> collection, @Nullable com.google.common.collect.j$com.google.common.collect.u uVar) {
        this.f = jVar;
        this.b = k;
        this.c = collection;
        this.d = uVar;
        this.e = uVar == null ? null : uVar.e();
    }

    void a() {
        if (this.d != null) {
            this.d.a();
            if (this.d.e() != this.e) {
                throw new ConcurrentModificationException();
            }
        } else if (this.c.isEmpty()) {
            Collection collection = (Collection) this.f.a.get(this.b);
            if (collection != null) {
                this.c = collection;
            }
        }
    }

    public boolean add(V v) {
        a();
        boolean isEmpty = this.c.isEmpty();
        boolean add = this.c.add(v);
        if (add) {
            this.f.b = this.f.b + 1;
            if (isEmpty) {
                d();
            }
        }
        return add;
    }

    public boolean addAll(Collection<? extends V> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.c.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        j.a(this.f, this.c.size() - size);
        if (size != 0) {
            return addAll;
        }
        d();
        return addAll;
    }

    void b() {
        if (this.d != null) {
            this.d.b();
        } else if (this.c.isEmpty()) {
            this.f.a.remove(this.b);
        }
    }

    K c() {
        return this.b;
    }

    public void clear() {
        int size = size();
        if (size != 0) {
            this.c.clear();
            j.b(this.f, size);
            b();
        }
    }

    public boolean contains(Object obj) {
        a();
        return this.c.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        a();
        return this.c.containsAll(collection);
    }

    void d() {
        if (this.d != null) {
            this.d.d();
        } else {
            this.f.a.put(this.b, this.c);
        }
    }

    Collection<V> e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        a();
        return this.c.equals(obj);
    }

    com.google.common.collect.j$com.google.common.collect.u f() {
        return this.d;
    }

    public int hashCode() {
        a();
        return this.c.hashCode();
    }

    public Iterator<V> iterator() {
        a();
        return new v(this);
    }

    public boolean remove(Object obj) {
        a();
        boolean remove = this.c.remove(obj);
        if (remove) {
            this.f.b = this.f.b - 1;
            b();
        }
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.c.removeAll(collection);
        if (!removeAll) {
            return removeAll;
        }
        j.a(this.f, this.c.size() - size);
        b();
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        s.a((Object) collection);
        int size = size();
        boolean retainAll = this.c.retainAll(collection);
        if (retainAll) {
            j.a(this.f, this.c.size() - size);
            b();
        }
        return retainAll;
    }

    public int size() {
        a();
        return this.c.size();
    }

    public String toString() {
        a();
        return this.c.toString();
    }
}
