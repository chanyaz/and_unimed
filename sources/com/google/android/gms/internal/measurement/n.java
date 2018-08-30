package com.google.android.gms.internal.measurement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class n implements Cloneable {
    private k<?, ?> a;
    private Object b;
    private List<r> c = new ArrayList();

    n() {
    }

    private final byte[] b() {
        byte[] bArr = new byte[a()];
        a(i.a(bArr));
        return bArr;
    }

    private final n c() {
        int i = 0;
        n nVar = new n();
        try {
            nVar.a = this.a;
            if (this.c == null) {
                nVar.c = null;
            } else {
                nVar.c.addAll(this.c);
            }
            if (this.b != null) {
                Object obj;
                int i2;
                if (this.b instanceof p) {
                    nVar.b = (p) ((p) this.b).clone();
                } else if (this.b instanceof byte[]) {
                    nVar.b = ((byte[]) this.b).clone();
                } else if (this.b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.b;
                    obj = new byte[bArr.length][];
                    nVar.b = obj;
                    while (true) {
                        i2 = i;
                        if (i2 >= bArr.length) {
                            break;
                        }
                        obj[i2] = (byte[]) bArr[i2].clone();
                        i = i2 + 1;
                    }
                } else if (this.b instanceof boolean[]) {
                    nVar.b = ((boolean[]) this.b).clone();
                } else if (this.b instanceof int[]) {
                    nVar.b = ((int[]) this.b).clone();
                } else if (this.b instanceof long[]) {
                    nVar.b = ((long[]) this.b).clone();
                } else if (this.b instanceof float[]) {
                    nVar.b = ((float[]) this.b).clone();
                } else if (this.b instanceof double[]) {
                    nVar.b = ((double[]) this.b).clone();
                } else if (this.b instanceof p[]) {
                    p[] pVarArr = (p[]) this.b;
                    obj = new p[pVarArr.length];
                    nVar.b = obj;
                    while (true) {
                        i2 = i;
                        if (i2 >= pVarArr.length) {
                            break;
                        }
                        obj[i2] = (p) pVarArr[i2].clone();
                        i = i2 + 1;
                    }
                }
            }
            return nVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    final int a() {
        int i = 0;
        int i2;
        if (this.b != null) {
            k kVar = this.a;
            Object obj = this.b;
            if (!kVar.c) {
                return kVar.a(obj);
            }
            int length = Array.getLength(obj);
            for (i2 = 0; i2 < length; i2++) {
                if (Array.get(obj, i2) != null) {
                    i += kVar.a(Array.get(obj, i2));
                }
            }
            return i;
        }
        Iterator it = this.c.iterator();
        while (true) {
            i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            r rVar = (r) it.next();
            i = (rVar.b.length + (i.d(rVar.a) + 0)) + i2;
        }
    }

    final void a(i iVar) {
        if (this.b != null) {
            k kVar = this.a;
            Object obj = this.b;
            if (kVar.c) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        kVar.a(obj2, iVar);
                    }
                }
                return;
            }
            kVar.a(obj, iVar);
            return;
        }
        for (r rVar : this.c) {
            iVar.c(rVar.a);
            iVar.b(rVar.b);
        }
    }

    final void a(r rVar) {
        if (this.c != null) {
            this.c.add(rVar);
            return;
        }
        Object a;
        if (this.b instanceof p) {
            byte[] bArr = rVar.b;
            h a2 = h.a(bArr, 0, bArr.length);
            int d = a2.d();
            if (d != bArr.length - i.a(d)) {
                throw zzacd.a();
            }
            a = ((p) this.b).a(a2);
        } else if (this.b instanceof p[]) {
            p[] pVarArr = (p[]) this.a.a(Collections.singletonList(rVar));
            p[] pVarArr2 = (p[]) this.b;
            p[] a3 = (p[]) Arrays.copyOf(pVarArr2, pVarArr2.length + pVarArr.length);
            System.arraycopy(pVarArr, 0, a3, pVarArr2.length, pVarArr.length);
        } else {
            a3 = this.a.a(Collections.singletonList(rVar));
        }
        this.a = this.a;
        this.b = a3;
        this.c = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.b != null && nVar.b != null) {
            return this.a == nVar.a ? !this.a.a.isArray() ? this.b.equals(nVar.b) : this.b instanceof byte[] ? Arrays.equals((byte[]) this.b, (byte[]) nVar.b) : this.b instanceof int[] ? Arrays.equals((int[]) this.b, (int[]) nVar.b) : this.b instanceof long[] ? Arrays.equals((long[]) this.b, (long[]) nVar.b) : this.b instanceof float[] ? Arrays.equals((float[]) this.b, (float[]) nVar.b) : this.b instanceof double[] ? Arrays.equals((double[]) this.b, (double[]) nVar.b) : this.b instanceof boolean[] ? Arrays.equals((boolean[]) this.b, (boolean[]) nVar.b) : Arrays.deepEquals((Object[]) this.b, (Object[]) nVar.b) : false;
        } else {
            if (this.c != null && nVar.c != null) {
                return this.c.equals(nVar.c);
            }
            try {
                return Arrays.equals(b(), nVar.b());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
