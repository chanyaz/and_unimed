package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class yj extends wt<Integer> implements zzbbt<Integer>, RandomAccess {
    private static final yj a;
    private int[] b;
    private int c;

    static {
        wt yjVar = new yj();
        a = yjVar;
        yjVar.zzaaz();
    }

    yj() {
        this(new int[10], 0);
    }

    private yj(int[] iArr, int i) {
        this.b = iArr;
        this.c = i;
    }

    private final void a(int i, int i2) {
        a();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(d(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            Object obj = new int[(((this.c * 3) / 2) + 1)];
            System.arraycopy(this.b, 0, obj, 0, i);
            System.arraycopy(this.b, i, obj, i + 1, this.c - i);
            this.b = obj;
        }
        this.b[i] = i2;
        this.c++;
        this.modCount++;
    }

    private final void c(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    private final String d(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    public final int a(int i) {
        c(i);
        return this.b[i];
    }

    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        a();
        yk.a((Object) collection);
        if (!(collection instanceof yj)) {
            return super.addAll(collection);
        }
        yj yjVar = (yj) collection;
        if (yjVar.c == 0) {
            return false;
        }
        if (MoPubClientPositioning.NO_REPEAT - this.c < yjVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + yjVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(yjVar.b, 0, this.b, this.c, yjVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    public final void b(int i) {
        a(this.c, i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yj)) {
            return super.equals(obj);
        }
        yj yjVar = (yj) obj;
        if (this.c != yjVar.c) {
            return false;
        }
        int[] iArr = yjVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(a(i));
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.b[i2];
        }
        return i;
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Integer.valueOf(this.b[i]))) {
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
        int intValue = ((Integer) obj).intValue();
        a();
        c(i);
        int i2 = this.b[i];
        this.b[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.c;
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i >= this.c) {
            return new yj(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
