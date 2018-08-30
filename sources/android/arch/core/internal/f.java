package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class f<K, V> implements SupportRemove<K, V>, Iterator<Entry<K, V>> {
    d<K, V> a;
    d<K, V> b;

    f(d<K, V> dVar, d<K, V> dVar2) {
        this.a = dVar2;
        this.b = dVar;
    }

    private d<K, V> b() {
        return (this.b == this.a || this.a == null) ? null : a(this.b);
    }

    abstract d<K, V> a(d<K, V> dVar);

    /* renamed from: a */
    public Entry<K, V> next() {
        Entry entry = this.b;
        this.b = b();
        return entry;
    }

    abstract d<K, V> b(d<K, V> dVar);

    public boolean hasNext() {
        return this.b != null;
    }

    public void supportRemove(@NonNull d<K, V> dVar) {
        if (this.a == dVar && dVar == this.b) {
            this.b = null;
            this.a = null;
        }
        if (this.a == dVar) {
            this.a = b(this.a);
        }
        if (this.b == dVar) {
            this.b = b();
        }
    }
}
