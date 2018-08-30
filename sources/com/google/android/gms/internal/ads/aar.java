package com.google.android.gms.internal.ads;

final class aar {
    private static final aas a;

    static {
        Object obj = (aal.a() && aal.b()) ? 1 : null;
        a = obj != null ? new aav() : new aat();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    static int a(java.lang.CharSequence r8) {
        /*
        r7 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r1 = 0;
        r3 = r8.length();
        r0 = r1;
    L_0x0008:
        if (r0 >= r3) goto L_0x007f;
    L_0x000a:
        r2 = r8.charAt(r0);
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r2 >= r4) goto L_0x007f;
    L_0x0012:
        r0 = r0 + 1;
        goto L_0x0008;
    L_0x0015:
        if (r0 >= r3) goto L_0x007d;
    L_0x0017:
        r4 = r8.charAt(r0);
        if (r4 >= r7) goto L_0x0025;
    L_0x001d:
        r4 = 127 - r4;
        r4 = r4 >>> 31;
        r2 = r2 + r4;
        r0 = r0 + 1;
        goto L_0x0015;
    L_0x0025:
        r4 = r8.length();
    L_0x0029:
        if (r0 >= r4) goto L_0x0056;
    L_0x002b:
        r5 = r8.charAt(r0);
        if (r5 >= r7) goto L_0x0039;
    L_0x0031:
        r5 = 127 - r5;
        r5 = r5 >>> 31;
        r1 = r1 + r5;
    L_0x0036:
        r0 = r0 + 1;
        goto L_0x0029;
    L_0x0039:
        r1 = r1 + 2;
        r6 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r6 > r5) goto L_0x0036;
    L_0x0040:
        r6 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r5 > r6) goto L_0x0036;
    L_0x0045:
        r5 = java.lang.Character.codePointAt(r8, r0);
        r6 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r5 >= r6) goto L_0x0053;
    L_0x004d:
        r1 = new com.google.android.gms.internal.ads.aau;
        r1.<init>(r0, r4);
        throw r1;
    L_0x0053:
        r0 = r0 + 1;
        goto L_0x0036;
    L_0x0056:
        r0 = r2 + r1;
    L_0x0058:
        if (r0 >= r3) goto L_0x007c;
    L_0x005a:
        r1 = new java.lang.IllegalArgumentException;
        r2 = (long) r0;
        r4 = 4294967296; // 0x100000000 float:0.0 double:2.121995791E-314;
        r2 = r2 + r4;
        r0 = 54;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r0);
        r0 = "UTF-8 length does not fit in int: ";
        r0 = r4.append(r0);
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x007c:
        return r0;
    L_0x007d:
        r0 = r2;
        goto L_0x0058;
    L_0x007f:
        r2 = r3;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aar.a(java.lang.CharSequence):int");
    }

    static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return a.a(charSequence, bArr, i, i2);
    }

    public static boolean a(byte[] bArr) {
        return a.a(bArr, 0, bArr.length);
    }

    public static boolean a(byte[] bArr, int i, int i2) {
        return a.a(bArr, i, i2);
    }

    private static int b(int i) {
        return i > -12 ? -1 : i;
    }

    private static int b(int i, int i2) {
        return (i > -12 || i2 > -65) ? -1 : (i2 << 8) ^ i;
    }

    private static int b(int i, int i2, int i3) {
        return (i > -12 || i2 > -65 || i3 > -65) ? -1 : ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    private static int c(byte[] bArr, int i, int i2) {
        int i3 = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return b(i3);
            case 1:
                return b(i3, bArr[i]);
            case 2:
                return b(i3, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }
}
