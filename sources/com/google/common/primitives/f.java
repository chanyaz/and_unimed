package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.math.BigInteger;

@GwtCompatible
@Beta
public final class f {
    private static final long[] a = new long[37];
    private static final int[] b = new int[37];
    private static final int[] c = new int[37];

    static {
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; i++) {
            a[i] = b(-1, (long) i);
            b[i] = (int) c(-1, (long) i);
            c[i] = bigInteger.toString(i).length() - 1;
        }
    }

    private f() {
    }

    public static int a(long j, long j2) {
        return c.a(b(j), b(j2));
    }

    public static String a(long j) {
        return a(j, 10);
    }

    public static String a(long j, int i) {
        boolean z = i >= 2 && i <= 36;
        s.a(z, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", Integer.valueOf(i));
        if (j == 0) {
            return "0";
        }
        int i2;
        char[] cArr = new char[64];
        int length = cArr.length;
        if (j < 0) {
            long b = b(j, (long) i);
            length--;
            cArr[length] = Character.forDigit((int) (j - (((long) i) * b)), i);
            i2 = length;
            j = b;
        } else {
            i2 = length;
        }
        while (j > 0) {
            length = i2 - 1;
            cArr[length] = Character.forDigit((int) (j % ((long) i)), i);
            j /= (long) i;
            i2 = length;
        }
        return new String(cArr, i2, cArr.length - i2);
    }

    private static long b(long j) {
        return Long.MIN_VALUE ^ j;
    }

    public static long b(long j, long j2) {
        int i = 1;
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0 : 1;
        } else {
            if (j >= 0) {
                return j / j2;
            }
            long j3 = ((j >>> 1) / j2) << 1;
            if (a(j - (j3 * j2), j2) < 0) {
                i = 0;
            }
            return ((long) i) + j3;
        }
    }

    public static long c(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
        } else {
            if (j >= 0) {
                return j % j2;
            }
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (a(j3, j2) < 0) {
                j2 = 0;
            }
            return j3 - j2;
        }
    }
}
