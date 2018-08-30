package android.support.v4.util;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

final class l implements Iterator<Entry<K, V>>, Entry<K, V> {
    int a;
    int b;
    boolean c = false;
    final /* synthetic */ h d;

    l(h hVar) {
        this.d = hVar;
        this.a = hVar.a() - 1;
        this.b = -1;
    }

    /* renamed from: a */
    public Entry<K, V> next() {
        if (hasNext()) {
            this.b++;
            this.c = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(c.a(entry.getKey(), this.d.a(this.b, 0)) && c.a(entry.getValue(), this.d.a(this.b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public K getKey() {
        if (this.c) {
            return this.d.a(this.b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V getValue() {
        if (this.c) {
            return this.d.a(this.b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.b < this.a;
    }

    public int hashCode() {
        int i = 0;
        if (this.c) {
            Object a = this.d.a(this.b, 0);
            Object a2 = this.d.a(this.b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public void remove() {
        if (this.c) {
            this.d.a(this.b);
            this.b--;
            this.a--;
            this.c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public V setValue(V v) {
        if (this.c) {
            return this.d.a(this.b, (Object) v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
