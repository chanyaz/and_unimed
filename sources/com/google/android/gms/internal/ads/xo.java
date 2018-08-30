package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class xo extends wt<Double> implements zzbbt<Double>, RandomAccess {
    private static final xo a;
    private double[] b;
    private int c;

    static {
        wt xoVar = new xo();
        a = xoVar;
        xoVar.zzaaz();
    }

    xo() {
        this(new double[10], 0);
    }

    private xo(double[] dArr, int i) {
        this.b = dArr;
        this.c = i;
    }

    private final void a(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    private final void a(int i, double d) {
        a();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(b(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            Object obj = new double[(((this.c * 3) / 2) + 1)];
            System.arraycopy(this.b, 0, obj, 0, i);
            System.arraycopy(this.b, i, obj, i + 1, this.c - i);
            this.b = obj;
        }
        this.b[i] = d;
        this.c++;
        this.modCount++;
    }

    private final String b(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    public final void a(double d) {
        a(this.c, d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        a();
        yk.a((Object) collection);
        if (!(collection instanceof xo)) {
            return super.addAll(collection);
        }
        xo xoVar = (xo) collection;
        if (xoVar.c == 0) {
            return false;
        }
        if (MoPubClientPositioning.NO_REPEAT - this.c < xoVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + xoVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(xoVar.b, 0, this.b, this.c, xoVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xo)) {
            return super.equals(obj);
        }
        xo xoVar = (xo) obj;
        if (this.c != xoVar.c) {
            return false;
        }
        double[] dArr = xoVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        a(i);
        return Double.valueOf(this.b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + yk.a(Double.doubleToLongBits(this.b[i2]));
        }
        return i;
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Double.valueOf(this.b[i]))) {
                System.arraycopy(this.b, i + 1, this.b, i, this.c - i);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    protected final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.b, i2, this.b, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        a();
        a(i);
        double d = this.b[i];
        this.b[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.c;
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i >= this.c) {
            return new xo(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
