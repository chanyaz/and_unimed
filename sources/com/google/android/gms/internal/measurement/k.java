package com.google.android.gms.internal.measurement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class k<M extends j<M>, T> {
    protected final Class<T> a;
    public final int b;
    protected final boolean c;
    private final int d;

    private final Object a(h hVar) {
        String valueOf;
        Class componentType = this.c ? this.a.getComponentType() : this.a;
        try {
            p pVar;
            switch (this.d) {
                case 10:
                    pVar = (p) componentType.newInstance();
                    hVar.a(pVar, this.b >>> 3);
                    return pVar;
                case 11:
                    pVar = (p) componentType.newInstance();
                    hVar.a(pVar);
                    return pVar;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.d);
            }
        } catch (Throwable e) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    protected final int a(Object obj) {
        int i = this.b >>> 3;
        switch (this.d) {
            case 10:
                return (i.b(i) << 1) + ((p) obj).d();
            case 11:
                return i.b(i, (p) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.d);
        }
    }

    final T a(List<r> list) {
        int i = 0;
        if (list == null) {
            return null;
        }
        if (this.c) {
            int i2;
            List arrayList = new ArrayList();
            for (i2 = 0; i2 < list.size(); i2++) {
                r rVar = (r) list.get(i2);
                if (rVar.b.length != 0) {
                    arrayList.add(a(h.a(rVar.b)));
                }
            }
            i2 = arrayList.size();
            if (i2 == 0) {
                return null;
            }
            T cast = this.a.cast(Array.newInstance(this.a.getComponentType(), i2));
            while (i < i2) {
                Array.set(cast, i, arrayList.get(i));
                i++;
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.a.cast(a(h.a(((r) list.get(list.size() - 1)).b)));
        }
    }

    protected final void a(Object obj, i iVar) {
        try {
            iVar.c(this.b);
            switch (this.d) {
                case 10:
                    int i = this.b >>> 3;
                    ((p) obj).a(iVar);
                    iVar.c(i, 4);
                    return;
                case 11:
                    iVar.a((p) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.d);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.d == kVar.d && this.a == kVar.a && this.b == kVar.b && this.c == kVar.c;
    }

    public final int hashCode() {
        return (this.c ? 1 : 0) + ((((((this.d + 1147) * 31) + this.a.hashCode()) * 31) + this.b) * 31);
    }
}
