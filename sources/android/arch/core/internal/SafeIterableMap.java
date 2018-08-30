package android.arch.core.internal;

import android.arch.core.internal.SafeIterableMap$android.arch.core.internal.e;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@RestrictTo({Scope.LIBRARY_GROUP})
public class SafeIterableMap<K, V> implements Iterable<Entry<K, V>> {
    private d<K, V> a;
    private d<K, V> b;
    private WeakHashMap<SupportRemove<K, V>, Boolean> c = new WeakHashMap();
    private int d = 0;

    interface SupportRemove<K, V> {
        void supportRemove(@NonNull d<K, V> dVar);
    }

    public int a() {
        return this.d;
    }

    protected d<K, V> a(K k) {
        d<K, V> dVar = this.a;
        while (dVar != null && !dVar.a.equals(k)) {
            dVar = dVar.c;
        }
        return dVar;
    }

    public V a(@NonNull K k, @NonNull V v) {
        d a = a((Object) k);
        if (a != null) {
            return a.b;
        }
        b(k, v);
        return null;
    }

    protected d<K, V> b(@NonNull K k, @NonNull V v) {
        d<K, V> dVar = new d(k, v);
        this.d++;
        if (this.b == null) {
            this.a = dVar;
            this.b = this.a;
        } else {
            this.b.c = dVar;
            dVar.d = this.b;
            this.b = dVar;
        }
        return dVar;
    }

    public V b(@NonNull K k) {
        d a = a((Object) k);
        if (a == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            for (SupportRemove supportRemove : this.c.keySet()) {
                supportRemove.supportRemove(a);
            }
        }
        if (a.d != null) {
            a.d.c = a.c;
        } else {
            this.a = a.c;
        }
        if (a.c != null) {
            a.c.d = a.d;
        } else {
            this.b = a.d;
        }
        a.c = null;
        a.d = null;
        return a.b;
    }

    public Iterator<Entry<K, V>> b() {
        Iterator cVar = new c(this.b, this.a);
        this.c.put(cVar, Boolean.valueOf(false));
        return cVar;
    }

    public e c() {
        e eVar = new e(this);
        this.c.put(eVar, Boolean.valueOf(false));
        return eVar;
    }

    public Entry<K, V> d() {
        return this.a;
    }

    public Entry<K, V> e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (a() != safeIterableMap.a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = it2.next();
            if (entry == null && next != null) {
                return false;
            }
            if (entry != null && !entry.equals(next)) {
                return false;
            }
        }
        boolean z = (it.hasNext() || it2.hasNext()) ? false : true;
        return z;
    }

    @NonNull
    public Iterator<Entry<K, V>> iterator() {
        Iterator bVar = new b(this.a, this.b);
        this.c.put(bVar, Boolean.valueOf(false));
        return bVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
