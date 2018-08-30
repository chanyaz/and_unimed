package com.google.common.collect;

import com.appnext.base.a.c.c;
import com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
class hg<K, V> extends ImmutableBiMap<K, V> {
    private final transient dk<K, V>[] a;
    private final transient dk<K, V>[] b;
    private final transient dk<K, V>[] c;
    private final transient int d;
    private final transient int e;
    private transient ImmutableBiMap<V, K> f;

    hg(int i, dl<?, ?>[] dlVarArr) {
        int a = cs.a(i, 1.2d);
        this.d = a - 1;
        dk[] a2 = a(a);
        dk[] a3 = a(a);
        dk[] a4 = a(i);
        int i2 = 0;
        a = 0;
        while (true) {
            int i3 = a;
            int i4 = i2;
            if (i3 < i) {
                Object obj;
                dk obj2;
                hk hkVar = dlVarArr[i3];
                Object key = hkVar.getKey();
                Object value = hkVar.getValue();
                int hashCode = key.hashCode();
                int hashCode2 = value.hashCode();
                int a5 = cs.a(hashCode) & this.d;
                int a6 = cs.a(hashCode2) & this.d;
                dk dkVar = a2[a5];
                for (obj2 = dkVar; obj2 != null; obj2 = obj2.a()) {
                    ImmutableMap.a(!key.equals(obj2.getKey()), c.gv, hkVar, obj2);
                }
                dk dkVar2 = a3[a6];
                for (obj2 = dkVar2; obj2 != null; obj2 = obj2.b()) {
                    ImmutableMap.a(!value.equals(obj2.getValue()), "value", hkVar, obj2);
                }
                hk hkVar2 = (dkVar == null && dkVar2 == null) ? hkVar : new hk(hkVar, dkVar, dkVar2);
                a2[a5] = hkVar2;
                a3[a6] = hkVar2;
                a4[i3] = hkVar2;
                i2 = i4 + (hashCode ^ hashCode2);
                a = i3 + 1;
            } else {
                this.a = a2;
                this.b = a3;
                this.c = a4;
                this.e = i4;
                return;
            }
        }
    }

    private static <K, V> dk<K, V>[] a(int i) {
        return new dk[i];
    }

    ImmutableSet<Entry<K, V>> c() {
        return new dm<K, V>() {
            ImmutableMap<K, V> e() {
                return hg.this;
            }

            ImmutableList<Entry<K, V>> f() {
                return new hf((ImmutableCollection) this, hg.this.c);
            }

            boolean f_() {
                return true;
            }

            /* renamed from: h_ */
            public jl<Entry<K, V>> iterator() {
                return b().iterator();
            }

            public int hashCode() {
                return hg.this.e;
            }
        };
    }

    boolean e() {
        return false;
    }

    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        for (dk dkVar = this.a[cs.a(obj.hashCode()) & this.d]; dkVar != null; dkVar = dkVar.a()) {
            if (obj.equals(dkVar.getKey())) {
                return dkVar.getValue();
            }
        }
        return null;
    }

    /* renamed from: i_ */
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> immutableBiMap = this.f;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        immutableBiMap = new hh(this, null);
        this.f = immutableBiMap;
        return immutableBiMap;
    }

    public int size() {
        return this.c.length;
    }
}
