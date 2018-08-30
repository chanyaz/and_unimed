package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;

public final class NumberInput {
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);

    private static NumberFormatException _badBD(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (length2 = 0; length2 < length; length2++) {
            int charAt = str.charAt(length2) - str2.charAt(length2);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static boolean inLongRange(char[] cArr, int i, int i2, boolean z) {
        String str = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int charAt = cArr[i + i3] - str.charAt(i3);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    public static int parseAsInt(java.lang.String r6, int r7) {
        /*
        r1 = 1;
        r0 = 0;
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return r7;
    L_0x0005:
        r3 = r6.trim();
        r2 = r3.length();
        if (r2 == 0) goto L_0x0004;
    L_0x000f:
        if (r0 >= r2) goto L_0x0049;
    L_0x0011:
        r4 = r3.charAt(r0);
        r5 = 43;
        if (r4 != r5) goto L_0x0035;
    L_0x0019:
        r2 = r3.substring(r1);
        r1 = r2.length();
    L_0x0021:
        if (r0 >= r1) goto L_0x0040;
    L_0x0023:
        r3 = r2.charAt(r0);
        r4 = 57;
        if (r3 > r4) goto L_0x002f;
    L_0x002b:
        r4 = 48;
        if (r3 >= r4) goto L_0x003d;
    L_0x002f:
        r0 = parseDouble(r2);	 Catch:{ NumberFormatException -> 0x0045 }
        r7 = (int) r0;
        goto L_0x0004;
    L_0x0035:
        r5 = 45;
        if (r4 != r5) goto L_0x0049;
    L_0x0039:
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0021;
    L_0x003d:
        r0 = r0 + 1;
        goto L_0x0021;
    L_0x0040:
        r7 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0047 }
        goto L_0x0004;
    L_0x0045:
        r0 = move-exception;
        goto L_0x0004;
    L_0x0047:
        r0 = move-exception;
        goto L_0x0004;
    L_0x0049:
        r1 = r2;
        r2 = r3;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseAsInt(java.lang.String, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    public static long parseAsLong(java.lang.String r7, long r8) {
        /*
        r1 = 1;
        r0 = 0;
        if (r7 != 0) goto L_0x0005;
    L_0x0004:
        return r8;
    L_0x0005:
        r3 = r7.trim();
        r2 = r3.length();
        if (r2 == 0) goto L_0x0004;
    L_0x000f:
        if (r0 >= r2) goto L_0x0049;
    L_0x0011:
        r4 = r3.charAt(r0);
        r5 = 43;
        if (r4 != r5) goto L_0x0035;
    L_0x0019:
        r2 = r3.substring(r1);
        r1 = r2.length();
    L_0x0021:
        if (r0 >= r1) goto L_0x0040;
    L_0x0023:
        r3 = r2.charAt(r0);
        r4 = 57;
        if (r3 > r4) goto L_0x002f;
    L_0x002b:
        r4 = 48;
        if (r3 >= r4) goto L_0x003d;
    L_0x002f:
        r0 = parseDouble(r2);	 Catch:{ NumberFormatException -> 0x0045 }
        r8 = (long) r0;
        goto L_0x0004;
    L_0x0035:
        r5 = 45;
        if (r4 != r5) goto L_0x0049;
    L_0x0039:
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0021;
    L_0x003d:
        r0 = r0 + 1;
        goto L_0x0021;
    L_0x0040:
        r8 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0047 }
        goto L_0x0004;
    L_0x0045:
        r0 = move-exception;
        goto L_0x0004;
    L_0x0047:
        r0 = move-exception;
        goto L_0x0004;
    L_0x0049:
        r1 = r2;
        r2 = r3;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseAsLong(java.lang.String, long):long");
    }

    public static BigDecimal parseBigDecimal(String str) {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException e) {
            throw _badBD(str);
        }
    }

    public static BigDecimal parseBigDecimal(char[] cArr) {
        return parseBigDecimal(cArr, 0, cArr.length);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i2) {
        try {
            return new BigDecimal(cArr, i, i2);
        } catch (NumberFormatException e) {
            throw _badBD(new String(cArr, i, i2));
        }
    }

    public static double parseDouble(String str) {
        return "2.2250738585072012e-308".equals(str) ? Double.MIN_VALUE : Double.parseDouble(str);
    }

    public static int parseInt(String str) {
        int i = 1;
        int charAt = str.charAt(0);
        int length = str.length();
        int i2 = charAt == 45 ? 1 : 0;
        if (i2 != 0) {
            if (length == 1 || length > 10) {
                return Integer.parseInt(str);
            }
            charAt = str.charAt(1);
            i = 2;
        } else if (length > 9) {
            return Integer.parseInt(str);
        }
        if (charAt > 57 || charAt < 48) {
            return Integer.parseInt(str);
        }
        charAt -= 48;
        if (i < length) {
            int i3 = i + 1;
            char charAt2 = str.charAt(i);
            if (charAt2 > '9' || charAt2 < '0') {
                return Integer.parseInt(str);
            }
            charAt = (charAt * 10) + (charAt2 - 48);
            if (i3 < length) {
                i = i3 + 1;
                char charAt3 = str.charAt(i3);
                if (charAt3 > '9' || charAt3 < '0') {
                    return Integer.parseInt(str);
                }
                charAt = (charAt * 10) + (charAt3 - 48);
                if (i < length) {
                    while (true) {
                        i3 = i + 1;
                        charAt2 = str.charAt(i);
                        if (charAt2 <= '9' && charAt2 >= '0') {
                            charAt = (charAt * 10) + (charAt2 - 48);
                            if (i3 >= length) {
                                break;
                            }
                            i = i3;
                        }
                    }
                    return Integer.parseInt(str);
                }
            }
        }
        return i2 != 0 ? -charAt : charAt;
    }

    public static int parseInt(char[] cArr, int i, int i2) {
        int i3;
        int i4 = cArr[i] - 48;
        if (i2 > 4) {
            i3 = i + 1;
            i3++;
            i3++;
            i = i3 + 1;
            i4 = (((((((i4 * 10) + (cArr[i3] - 48)) * 10) + (cArr[i3] - 48)) * 10) + (cArr[i3] - 48)) * 10) + (cArr[i] - 48);
            i2 -= 4;
            if (i2 > 4) {
                i3 = i + 1;
                i3++;
                i3++;
                return (((((((i4 * 10) + (cArr[i3] - 48)) * 10) + (cArr[i3] - 48)) * 10) + (cArr[i3] - 48)) * 10) + (cArr[i3 + 1] - 48);
            }
        }
        if (i2 <= 1) {
            return i4;
        }
        i3 = i + 1;
        i4 = (i4 * 10) + (cArr[i3] - 48);
        if (i2 <= 2) {
            return i4;
        }
        i3++;
        i4 = (i4 * 10) + (cArr[i3] - 48);
        return i2 > 3 ? (i4 * 10) + (cArr[i3 + 1] - 48) : i4;
    }

    public static long parseLong(String str) {
        return str.length() <= 9 ? (long) parseInt(str) : Long.parseLong(str);
    }

    public static long parseLong(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return ((long) parseInt(cArr, i3 + i, 9)) + (((long) parseInt(cArr, i, i3)) * 1000000000);
    }
}
