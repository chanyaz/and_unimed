package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class yw extends wt<Long> implements zzbbt<Long>, RandomAccess {
    private static final yw a;
    private long[] b;
    private int c;

    static {
        wt ywVar = new yw();
        a = ywVar;
        ywVar.zzaaz();
    }

    yw() {
        this(new long[10], 0);
    }

    private yw(long[] jArr, int i) {
        this.b = jArr;
        this.c = i;
    }

    private final void a(int i, long j) {
        a();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            Object obj = new long[(((this.c * 3) / 2) + 1)];
            System.arraycopy(this.b, 0, obj, 0, i);
            System.arraycopy(this.b, i, obj, i + 1, this.c - i);
            this.b = obj;
        }
        this.b[i] = j;
        this.c++;
        this.modCount++;
    }

    private final void b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    private final String c(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    public final long a(int i) {
        b(i);
        return this.b[i];
    }

    public final void a(long j) {
        a(this.c, j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        a();
        yk.a((Object) collection);
        if (!(collection instanceof yw)) {
            return super.addAll(collection);
        }
        yw ywVar = (yw) collection;
        if (ywVar.c == 0) {
            return false;
        }
        if (MoPubClientPositioning.NO_REPEAT - this.c < ywVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + ywVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(ywVar.b, 0, this.b, this.c, ywVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yw)) {
            return super.equals(obj);
        }
        yw ywVar = (yw) obj;
        if (this.c != ywVar.c) {
            return false;
        }
        long[] jArr = ywVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(a(i));
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + yk.a(this.b[i2]);
        }
        return i;
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Long.valueOf(this.b[i]))) {
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
        long longValue = ((Long) obj).longValue();
        a();
        b(i);
        long j = this.b[i];
        this.b[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.c;
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i >= this.c) {
            return new yw(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
