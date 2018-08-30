package com.google.common.base;

import java.util.Arrays;

class g extends d {
    private final char[] p;
    private final char[] q;

    g(String str, char[] cArr, char[] cArr2) {
        super(str);
        this.p = cArr;
        this.q = cArr2;
        s.a(cArr.length == cArr2.length);
        for (int i = 0; i < cArr.length; i++) {
            s.a(cArr[i] <= cArr2[i]);
            if (i + 1 < cArr.length) {
                s.a(cArr2[i] < cArr[i + 1]);
            }
        }
    }

    public boolean b(char c) {
        int binarySearch = Arrays.binarySearch(this.p, c);
        if (binarySearch >= 0) {
            return true;
        }
        binarySearch = (binarySearch ^ -1) - 1;
        return binarySearch >= 0 && c <= this.q[binarySearch];
    }
}
