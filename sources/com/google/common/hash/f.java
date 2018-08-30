package com.google.common.hash;

import com.google.common.base.s;
import java.util.Arrays;

class f {
    final long[] a;
    int b;

    f(long[] jArr) {
        int i = 0;
        s.a(jArr.length > 0, (Object) "data length is zero!");
        this.a = jArr;
        int i2 = 0;
        while (i < jArr.length) {
            i2 += Long.bitCount(jArr[i]);
            i++;
        }
        this.b = i2;
    }

    int a() {
        return this.a.length * 64;
    }

    boolean a(int i) {
        if (b(i)) {
            return false;
        }
        long[] jArr = this.a;
        int i2 = i >> 6;
        jArr[i2] = jArr[i2] | (1 << i);
        this.b++;
        return true;
    }

    boolean b(int i) {
        return (this.a[i >> 6] & (1 << i)) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return Arrays.equals(this.a, ((f) obj).a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }
}
