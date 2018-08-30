package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class gu extends gy<K> {
    final /* synthetic */ gt a;

    gu(gt gtVar) {
        this.a = gtVar;
    }

    Multiset<K> a() {
        return this.a;
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Collection collection = (Collection) this.a.a.asMap().get(entry.getElement());
        return collection != null && collection.size() == entry.getCount();
    }

    public boolean isEmpty() {
        return this.a.a.isEmpty();
    }

    public Iterator<Entry<K>> iterator() {
        return this.a.a();
    }

    public boolean remove(@Nullable Object obj) {
        if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            Collection collection = (Collection) this.a.a.asMap().get(entry.getElement());
            if (collection != null && collection.size() == entry.getCount()) {
                collection.clear();
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.a.b();
    }
}
