package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class abh implements Cloneable {
    private abf<?, ?> a;
    private Object b;
    private List<abl> c = new ArrayList();

    abh() {
    }

    private final byte[] b() {
        byte[] bArr = new byte[a()];
        a(abd.a(bArr));
        return bArr;
    }

    private final abh c() {
        int i = 0;
        abh abh = new abh();
        try {
            abh.a = this.a;
            if (this.c == null) {
                abh.c = null;
            } else {
                abh.c.addAll(this.c);
            }
            if (this.b != null) {
                Object obj;
                int i2;
                if (this.b instanceof abj) {
                    abh.b = (abj) ((abj) this.b).clone();
                } else if (this.b instanceof byte[]) {
                    abh.b = ((byte[]) this.b).clone();
                } else if (this.b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.b;
                    obj = new byte[bArr.length][];
                    abh.b = obj;
                    while (true) {
                        i2 = i;
                        if (i2 >= bArr.length) {
                            break;
                        }
                        obj[i2] = (byte[]) bArr[i2].clone();
                        i = i2 + 1;
                    }
                } else if (this.b instanceof boolean[]) {
                    abh.b = ((boolean[]) this.b).clone();
                } else if (this.b instanceof int[]) {
                    abh.b = ((int[]) this.b).clone();
                } else if (this.b instanceof long[]) {
                    abh.b = ((long[]) this.b).clone();
                } else if (this.b instanceof float[]) {
                    abh.b = ((float[]) this.b).clone();
                } else if (this.b instanceof double[]) {
                    abh.b = ((double[]) this.b).clone();
                } else if (this.b instanceof abj[]) {
                    abj[] abjArr = (abj[]) this.b;
                    obj = new abj[abjArr.length];
                    abh.b = obj;
                    while (true) {
                        i2 = i;
                        if (i2 >= abjArr.length) {
                            break;
                        }
                        obj[i2] = (abj) abjArr[i2].clone();
                        i = i2 + 1;
                    }
                }
            }
            return abh;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    final int a() {
        int i = 0;
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        Iterator it = this.c.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            abl abl = (abl) it.next();
            i = (abl.b.length + (abd.d(abl.a) + 0)) + i2;
        }
    }

    final void a(abd abd) {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        for (abl abl : this.c) {
            abd.c(abl.a);
            abd.c(abl.b);
        }
    }

    final void a(abl abl) {
        if (this.c != null) {
            this.c.add(abl);
        } else if (this.b instanceof abj) {
            byte[] bArr = abl.b;
            abb a = abb.a(bArr, 0, bArr.length);
            int g = a.g();
            if (g != bArr.length - abd.a(g)) {
                throw zzbfh.a();
            }
            abj a2 = ((abj) this.b).a(a);
            this.a = this.a;
            this.b = a2;
            this.c = null;
        } else if (this.b instanceof abj[]) {
            Collections.singletonList(abl);
            throw new NoSuchMethodError();
        } else {
            Collections.singletonList(abl);
            throw new NoSuchMethodError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abh)) {
            return false;
        }
        abh abh = (abh) obj;
        if (this.b != null && abh.b != null) {
            return this.a == abh.a ? !this.a.a.isArray() ? this.b.equals(abh.b) : this.b instanceof byte[] ? Arrays.equals((byte[]) this.b, (byte[]) abh.b) : this.b instanceof int[] ? Arrays.equals((int[]) this.b, (int[]) abh.b) : this.b instanceof long[] ? Arrays.equals((long[]) this.b, (long[]) abh.b) : this.b instanceof float[] ? Arrays.equals((float[]) this.b, (float[]) abh.b) : this.b instanceof double[] ? Arrays.equals((double[]) this.b, (double[]) abh.b) : this.b instanceof boolean[] ? Arrays.equals((boolean[]) this.b, (boolean[]) abh.b) : Arrays.deepEquals((Object[]) this.b, (Object[]) abh.b) : false;
        } else {
            if (this.c != null && abh.c != null) {
                return this.c.equals(abh.c);
            }
            try {
                return Arrays.equals(b(), abh.b());
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
