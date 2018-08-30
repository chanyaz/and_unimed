package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

class e implements SupportRemove<K, V>, Iterator<Entry<K, V>> {
    final /* synthetic */ SafeIterableMap a;
    private d<K, V> b;
    private boolean c;

    private e(SafeIterableMap safeIterableMap) {
        this.a = safeIterableMap;
        this.c = true;
    }

    /* renamed from: a */
    public Entry<K, V> next() {
        if (this.c) {
            this.c = false;
            this.b = this.a.a;
        } else {
            this.b = this.b != null ? this.b.c : null;
        }
        return this.b;
    }

    public boolean hasNext() {
        return this.c ? this.a.a != null : (this.b == null || this.b.c == null) ? false : true;
    }

    public void supportRemove(@NonNull d<K, V> dVar) {
        if (dVar == this.b) {
            this.b = this.b.d;
            this.c = this.b == null;
        }
    }
}
