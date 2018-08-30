package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class yb extends wt<Float> implements zzbbt<Float>, RandomAccess {
    private static final yb a;
    private float[] b;
    private int c;

    static {
        wt ybVar = new yb();
        a = ybVar;
        ybVar.zzaaz();
    }

    yb() {
        this(new float[10], 0);
    }

    private yb(float[] fArr, int i) {
        this.b = fArr;
        this.c = i;
    }

    private final void a(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    private final void a(int i, float f) {
        a();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(b(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            Object obj = new float[(((this.c * 3) / 2) + 1)];
            System.arraycopy(this.b, 0, obj, 0, i);
            System.arraycopy(this.b, i, obj, i + 1, this.c - i);
            this.b = obj;
        }
        this.b[i] = f;
        this.c++;
        this.modCount++;
    }

    private final String b(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    public final void a(float f) {
        a(this.c, f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Float) obj).floatValue());
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        a();
        yk.a((Object) collection);
        if (!(collection instanceof yb)) {
            return super.addAll(collection);
        }
        yb ybVar = (yb) collection;
        if (ybVar.c == 0) {
            return false;
        }
        if (MoPubClientPositioning.NO_REPEAT - this.c < ybVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + ybVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(ybVar.b, 0, this.b, this.c, ybVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yb)) {
            return super.equals(obj);
        }
        yb ybVar = (yb) obj;
        if (this.c != ybVar.c) {
            return false;
        }
        float[] fArr = ybVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        a(i);
        return Float.valueOf(this.b[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.b[i2]);
        }
        return i;
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Float.valueOf(this.b[i]))) {
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
        float floatValue = ((Float) obj).floatValue();
        a();
        a(i);
        float f = this.b[i];
        this.b[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.c;
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i >= this.c) {
            return new yb(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
