package android.support.v4.graphics;

import android.graphics.Path;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.ArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public class b {
    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static Path a(String str) {
        Path path = new Path();
        d[] b = b(str);
        if (b == null) {
            return null;
        }
        try {
            d.a(b, path);
            return path;
        } catch (Throwable e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    private static void a(java.lang.String r7, int r8, android.support.v4.graphics.c r9) {
        /*
        r1 = 0;
        r5 = 1;
        r9.b = r1;
        r0 = r1;
        r2 = r1;
        r3 = r1;
        r4 = r8;
    L_0x0008:
        r6 = r7.length();
        if (r4 >= r6) goto L_0x0018;
    L_0x000e:
        r6 = r7.charAt(r4);
        switch(r6) {
            case 32: goto L_0x001b;
            case 44: goto L_0x001b;
            case 45: goto L_0x001e;
            case 46: goto L_0x0027;
            case 69: goto L_0x0031;
            case 101: goto L_0x0031;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r1;
    L_0x0016:
        if (r3 == 0) goto L_0x0033;
    L_0x0018:
        r9.a = r4;
        return;
    L_0x001b:
        r0 = r1;
        r3 = r5;
        goto L_0x0016;
    L_0x001e:
        if (r4 == r8) goto L_0x0015;
    L_0x0020:
        if (r0 != 0) goto L_0x0015;
    L_0x0022:
        r9.b = r5;
        r0 = r1;
        r3 = r5;
        goto L_0x0016;
    L_0x0027:
        if (r2 != 0) goto L_0x002c;
    L_0x0029:
        r0 = r1;
        r2 = r5;
        goto L_0x0016;
    L_0x002c:
        r9.b = r5;
        r0 = r1;
        r3 = r5;
        goto L_0x0016;
    L_0x0031:
        r0 = r5;
        goto L_0x0016;
    L_0x0033:
        r4 = r4 + 1;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.b.a(java.lang.String, int, android.support.v4.graphics.c):void");
    }

    private static void a(ArrayList<d> arrayList, char c, float[] fArr) {
        arrayList.add(new d(c, fArr));
    }

    public static boolean a(d[] dVarArr, d[] dVarArr2) {
        if (dVarArr == null || dVarArr2 == null || dVarArr.length != dVarArr2.length) {
            return false;
        }
        int i = 0;
        while (i < dVarArr.length) {
            if (dVarArr[i].a != dVarArr2[i].a || dVarArr[i].b.length != dVarArr2[i].b.length) {
                return false;
            }
            i++;
        }
        return true;
    }

    static float[] a(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new float[i3];
        System.arraycopy(fArr, i, obj, 0, length);
        return obj;
    }

    public static d[] a(d[] dVarArr) {
        if (dVarArr == null) {
            return null;
        }
        d[] dVarArr2 = new d[dVarArr.length];
        for (int i = 0; i < dVarArr.length; i++) {
            dVarArr2[i] = new d(dVarArr[i]);
        }
        return dVarArr2;
    }

    public static void b(d[] dVarArr, d[] dVarArr2) {
        for (int i = 0; i < dVarArr2.length; i++) {
            dVarArr[i].a = dVarArr2[i].a;
            for (int i2 = 0; i2 < dVarArr2[i].b.length; i2++) {
                dVarArr[i].b[i2] = dVarArr2[i].b[i2];
            }
        }
    }

    public static d[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a = a(str, i);
            String trim = str.substring(i2, a).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), c(trim));
            }
            i = a + 1;
            i2 = a;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (d[]) arrayList.toArray(new d[arrayList.size()]);
    }

    private static float[] c(String str) {
        int i = 0;
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            c cVar = new c();
            int length = str.length();
            int i2 = 1;
            while (i2 < length) {
                int i3;
                a(str, i2, cVar);
                int i4 = cVar.a;
                if (i2 < i4) {
                    i3 = i + 1;
                    fArr[i] = Float.parseFloat(str.substring(i2, i4));
                } else {
                    i3 = i;
                }
                if (cVar.b) {
                    i2 = i4;
                    i = i3;
                } else {
                    i2 = i4 + 1;
                    i = i3;
                }
            }
            return a(fArr, 0, i);
        } catch (Throwable e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }
}
