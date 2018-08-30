package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;

class r {
    public static final int NOT_FOUND = -1;
    @NonNull
    private final int[] a = new int[200];
    @NonNull
    private final int[] b = new int[200];
    private int c = 0;
    @NonNull
    private final int[] d = new int[200];
    @NonNull
    private final int[] e = new int[200];
    @NonNull
    private final NativeAd[] f = new NativeAd[200];
    private int g = 0;

    private r(@NonNull int[] iArr) {
        this.c = Math.min(iArr.length, 200);
        System.arraycopy(iArr, 0, this.b, 0, this.c);
        System.arraycopy(iArr, 0, this.a, 0, this.c);
    }

    private static int a(int[] iArr, int i, int i2) {
        int a = a(iArr, 0, i, i2);
        if (a < 0) {
            return a ^ -1;
        }
        int i3 = iArr[a];
        while (a >= 0 && iArr[a] == i3) {
            a--;
        }
        return a + 1;
    }

    private static int a(int[] iArr, int i, int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = i;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else if (i7 <= i3) {
                return i6;
            } else {
                i4 = i6 - 1;
            }
        }
        return i5 ^ -1;
    }

    @NonNull
    static r a() {
        return new r(new int[0]);
    }

    @NonNull
    static r a(@NonNull MoPubClientPositioning moPubClientPositioning) {
        int i;
        int i2 = 0;
        List<Integer> a = moPubClientPositioning.a();
        int b = moPubClientPositioning.b();
        int size = b == MoPubClientPositioning.NO_REPEAT ? a.size() : 200;
        int[] iArr = new int[size];
        int i3 = 0;
        for (Integer intValue : a) {
            i3 = intValue.intValue() - i2;
            i = i2 + 1;
            iArr[i2] = i3;
            i2 = i;
        }
        while (i2 < size) {
            i3 = (i3 + b) - 1;
            i = i2 + 1;
            iArr[i2] = i3;
            i2 = i;
        }
        return new r(iArr);
    }

    private static int b(int[] iArr, int i, int i2) {
        int a = a(iArr, 0, i, i2);
        if (a < 0) {
            return a ^ -1;
        }
        int i3 = iArr[a];
        while (a < i && iArr[a] == i3) {
            a++;
        }
        return a;
    }

    int a(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        int[] iArr = new int[this.g];
        int[] iArr2 = new int[this.g];
        int i6 = 0;
        for (i3 = 0; i3 < this.g; i3++) {
            i4 = this.d[i3];
            int i7 = this.e[i3];
            if (i <= i7 && i7 < i2) {
                iArr[i6] = i4;
                iArr2[i6] = i7 - i6;
                this.f[i3].destroy();
                this.f[i3] = null;
                i6++;
            } else if (i6 > 0) {
                int i8 = i3 - i6;
                this.d[i8] = i4;
                this.e[i8] = i7 - i6;
                this.f[i8] = this.f[i3];
            }
        }
        if (i6 == 0) {
            return 0;
        }
        i4 = a(this.b, this.c, iArr2[0]);
        for (i3 = this.c - 1; i3 >= i4; i3--) {
            this.a[i3 + i6] = this.a[i3];
            this.b[i3 + i6] = this.b[i3] - i6;
        }
        while (i5 < i6) {
            this.a[i4 + i5] = iArr[i5];
            this.b[i4 + i5] = iArr2[i5];
            i5++;
        }
        this.c += i6;
        this.g -= i6;
        return i6;
    }

    void a(int i, NativeAd nativeAd) {
        int a = a(this.b, this.c, i);
        if (a == this.c || this.b[a] != i) {
            MoPubLog.w("Attempted to insert an ad at an invalid position");
            return;
        }
        int[] iArr;
        int i2 = this.a[a];
        int b = b(this.d, this.g, i2);
        if (b < this.g) {
            int i3 = this.g - b;
            System.arraycopy(this.d, b, this.d, b + 1, i3);
            System.arraycopy(this.e, b, this.e, b + 1, i3);
            System.arraycopy(this.f, b, this.f, b + 1, i3);
        }
        this.d[b] = i2;
        this.e[b] = i;
        this.f[b] = nativeAd;
        this.g++;
        i2 = (this.c - a) - 1;
        System.arraycopy(this.b, a + 1, this.b, a, i2);
        System.arraycopy(this.a, a + 1, this.a, a, i2);
        this.c--;
        while (a < this.c) {
            iArr = this.b;
            iArr[a] = iArr[a] + 1;
            a++;
        }
        for (a = b + 1; a < this.g; a++) {
            iArr = this.e;
            iArr[a] = iArr[a] + 1;
        }
    }

    boolean a(int i) {
        return a(this.b, 0, this.c, i) >= 0;
    }

    int b(int i) {
        int b = b(this.b, this.c, i);
        return b == this.c ? -1 : this.b[b];
    }

    void b(int i, int i2) {
        j(i);
        i(i2);
    }

    @NonNull
    int[] b() {
        Object obj = new int[this.g];
        System.arraycopy(this.e, 0, obj, 0, this.g);
        return obj;
    }

    void c() {
        if (this.g != 0) {
            a(0, this.e[this.g - 1] + 1);
        }
    }

    boolean c(int i) {
        return a(this.e, 0, this.g, i) >= 0;
    }

    @Nullable
    NativeAd d(int i) {
        int a = a(this.e, 0, this.g, i);
        return a < 0 ? null : this.f[a];
    }

    int e(int i) {
        int a = a(this.e, 0, this.g, i);
        return a < 0 ? i - (a ^ -1) : -1;
    }

    int f(int i) {
        return b(this.d, this.g, i) + i;
    }

    int g(int i) {
        if (i == 0) {
            return 0;
        }
        int e = e(i - 1);
        return e != -1 ? e + 1 : -1;
    }

    int h(int i) {
        return i == 0 ? 0 : f(i - 1) + 1;
    }

    void i(int i) {
        int a;
        int[] iArr;
        for (a = a(this.a, this.c, i); a < this.c; a++) {
            iArr = this.a;
            iArr[a] = iArr[a] + 1;
            iArr = this.b;
            iArr[a] = iArr[a] + 1;
        }
        for (a = a(this.d, this.g, i); a < this.g; a++) {
            iArr = this.d;
            iArr[a] = iArr[a] + 1;
            iArr = this.e;
            iArr[a] = iArr[a] + 1;
        }
    }

    void j(int i) {
        int b;
        int[] iArr;
        for (b = b(this.a, this.c, i); b < this.c; b++) {
            iArr = this.a;
            iArr[b] = iArr[b] - 1;
            iArr = this.b;
            iArr[b] = iArr[b] - 1;
        }
        for (b = b(this.d, this.g, i); b < this.g; b++) {
            iArr = this.d;
            iArr[b] = iArr[b] - 1;
            iArr = this.e;
            iArr[b] = iArr[b] - 1;
        }
    }
}
