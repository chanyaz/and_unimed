package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.ap;
import java.lang.reflect.Array;
import java.util.Arrays;

@VisibleForTesting
public final class b {
    private b() {
    }

    public static <T> int a(T[] tArr, T t) {
        int i = 0;
        int length = tArr != null ? tArr.length : 0;
        while (i < length) {
            if (ap.a(tArr[i], t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void a(StringBuilder stringBuilder, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Double.toString(dArr[i]));
        }
    }

    public static void a(StringBuilder stringBuilder, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Float.toString(fArr[i]));
        }
    }

    public static void a(StringBuilder stringBuilder, int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Integer.toString(iArr[i]));
        }
    }

    public static void a(StringBuilder stringBuilder, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(jArr[i]));
        }
    }

    public static <T> void a(StringBuilder stringBuilder, T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(tArr[i].toString());
        }
    }

    public static void a(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"").append(strArr[i]).append("\"");
        }
    }

    public static void a(StringBuilder stringBuilder, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Boolean.toString(zArr[i]));
        }
    }

    public static <T> T[] a(T[] tArr, int i) {
        return tArr == null ? null : i != tArr.length ? Arrays.copyOf(tArr, i) : tArr;
    }

    public static <T> T[] a(T[] tArr, T... tArr2) {
        int i = 0;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || tArr2.length == 0) {
            return Arrays.copyOf(tArr, tArr.length);
        }
        int i2;
        Object[] objArr = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
        int i3;
        int i4;
        if (tArr2.length == 1) {
            int length = tArr.length;
            i3 = 0;
            i2 = 0;
            while (i3 < length) {
                Object obj = tArr[i3];
                if (ap.a(tArr2[0], obj)) {
                    i4 = i2;
                } else {
                    i4 = i2 + 1;
                    objArr[i2] = obj;
                }
                i3++;
                i2 = i4;
            }
        } else {
            i3 = tArr.length;
            i2 = 0;
            while (i < i3) {
                Object obj2 = tArr[i];
                if (b(tArr2, obj2)) {
                    i4 = i2;
                } else {
                    i4 = i2 + 1;
                    objArr[i2] = obj2;
                }
                i++;
                i2 = i4;
            }
        }
        return a(objArr, i2);
    }

    public static <T> T[] a(T[]... tArr) {
        if (tArr.length == 0) {
            return (Object[]) Array.newInstance(tArr.getClass(), 0);
        }
        int i;
        int i2 = 0;
        for (T[] length : tArr) {
            i2 += length.length;
        }
        Object copyOf = Arrays.copyOf(tArr[0], i2);
        i2 = tArr[0].length;
        for (i = 1; i < tArr.length; i++) {
            Object obj = tArr[i];
            System.arraycopy(obj, 0, copyOf, i2, obj.length);
            i2 += obj.length;
        }
        return copyOf;
    }

    public static <T> boolean b(T[] tArr, T t) {
        return a((Object[]) tArr, (Object) t) >= 0;
    }
}
