package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class wx extends wt<Boolean> implements zzbbt<Boolean>, RandomAccess {
    private static final wx a;
    private boolean[] b;
    private int c;

    static {
        wt wxVar = new wx();
        a = wxVar;
        wxVar.zzaaz();
    }

    wx() {
        this(new boolean[10], 0);
    }

    private wx(boolean[] zArr, int i) {
        this.b = zArr;
        this.c = i;
    }

    private final void a(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    private final void a(int i, boolean z) {
        a();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(b(i));
        }
        if (this.c < this.b.length) {
            System.arraycopy(this.b, i, this.b, i + 1, this.c - i);
        } else {
            Object obj = new boolean[(((this.c * 3) / 2) + 1)];
            System.arraycopy(this.b, 0, obj, 0, i);
            System.arraycopy(this.b, i, obj, i + 1, this.c - i);
            this.b = obj;
        }
        this.b[i] = z;
        this.c++;
        this.modCount++;
    }

    private final String b(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    public final void a(boolean z) {
        a(this.c, z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        a();
        yk.a((Object) collection);
        if (!(collection instanceof wx)) {
            return super.addAll(collection);
        }
        wx wxVar = (wx) collection;
        if (wxVar.c == 0) {
            return false;
        }
        if (MoPubClientPositioning.NO_REPEAT - this.c < wxVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + wxVar.c;
        if (i > this.b.length) {
            this.b = Arrays.copyOf(this.b, i);
        }
        System.arraycopy(wxVar.b, 0, this.b, this.c, wxVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wx)) {
            return super.equals(obj);
        }
        wx wxVar = (wx) obj;
        if (this.c != wxVar.c) {
            return false;
        }
        boolean[] zArr = wxVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        a(i);
        return Boolean.valueOf(this.b[i]);
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
            if (obj.equals(Boolean.valueOf(this.b[i]))) {
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        a(i);
        boolean z = this.b[i];
        this.b[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.c;
    }

    public final /* synthetic */ zzbbt zzbm(int i) {
        if (i >= this.c) {
            return new wx(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
