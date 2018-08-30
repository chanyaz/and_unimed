package com.google.common.io;

import com.google.common.base.d;
import com.google.common.base.s;
import java.math.RoundingMode;
import java.util.Arrays;

final class a extends d {
    final int p;
    final int q;
    final int r;
    final int s;
    private final String t;
    private final char[] u;
    private final byte[] v;
    private final boolean[] w;

    a(String str, char[] cArr) {
        int i = 0;
        this.t = (String) s.a((Object) str);
        this.u = (char[]) s.a((Object) cArr);
        try {
            this.q = com.google.common.math.a.a(cArr.length, RoundingMode.UNNECESSARY);
            int min = Math.min(8, Integer.lowestOneBit(this.q));
            this.r = 8 / min;
            this.s = this.q / min;
            this.p = cArr.length - 1;
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (min = 0; min < cArr.length; min++) {
                char c = cArr[min];
                s.a(d.b.b(c), "Non-ASCII character: %s", Character.valueOf(c));
                s.a(bArr[c] == (byte) -1, "Duplicate character: %s", Character.valueOf(c));
                bArr[c] = (byte) min;
            }
            this.v = bArr;
            boolean[] zArr = new boolean[this.r];
            while (i < this.s) {
                zArr[com.google.common.math.a.a(i * 8, this.q, RoundingMode.CEILING)] = true;
                i++;
            }
            this.w = zArr;
        } catch (Throwable e) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
        }
    }

    public boolean b(char c) {
        return d.b.b(c) && this.v[c] != (byte) -1;
    }

    public String toString() {
        return this.t;
    }
}
