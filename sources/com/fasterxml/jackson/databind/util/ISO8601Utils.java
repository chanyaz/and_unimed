package com.fasterxml.jackson.databind.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    @Deprecated
    private static final TimeZone TIMEZONE_GMT = TimeZone.getTimeZone("GMT");
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    private static final TimeZone TIMEZONE_Z = TIMEZONE_UTC;

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        Calendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder stringBuilder = new StringBuilder((timeZone.getRawOffset() == 0 ? "Z".length() : "+hh:mm".length()) + ("yyyy-MM-ddThh:mm:ss".length() + (z ? ".sss".length() : 0)));
        padInt(stringBuilder, gregorianCalendar.get(1), "yyyy".length());
        stringBuilder.append('-');
        padInt(stringBuilder, gregorianCalendar.get(2) + 1, "MM".length());
        stringBuilder.append('-');
        padInt(stringBuilder, gregorianCalendar.get(5), "dd".length());
        stringBuilder.append('T');
        padInt(stringBuilder, gregorianCalendar.get(11), "hh".length());
        stringBuilder.append(':');
        padInt(stringBuilder, gregorianCalendar.get(12), "mm".length());
        stringBuilder.append(':');
        padInt(stringBuilder, gregorianCalendar.get(13), "ss".length());
        if (z) {
            stringBuilder.append('.');
            padInt(stringBuilder, gregorianCalendar.get(14), "sss".length());
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int abs = Math.abs((offset / 60000) / 60);
            int abs2 = Math.abs((offset / 60000) % 60);
            stringBuilder.append(offset < 0 ? '-' : '+');
            padInt(stringBuilder, abs, "hh".length());
            stringBuilder.append(':');
            padInt(stringBuilder, abs2, "mm".length());
        } else {
            stringBuilder.append('Z');
        }
        return stringBuilder.toString();
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder stringBuilder, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(num);
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0205  */
    public static java.util.Date parse(java.lang.String r13, java.text.ParsePosition r14) {
        /*
        r5 = 59;
        r11 = 43;
        r10 = 45;
        r0 = 0;
        r2 = r14.getIndex();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r1 = r2 + 4;
        r6 = parseInt(r13, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = 45;
        r2 = checkOffset(r13, r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r2 == 0) goto L_0x0239;
    L_0x0019:
        r1 = r1 + 1;
        r2 = r1;
    L_0x001c:
        r1 = r2 + 2;
        r7 = parseInt(r13, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = 45;
        r2 = checkOffset(r13, r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r2 == 0) goto L_0x0236;
    L_0x002a:
        r1 = r1 + 1;
        r2 = r1;
    L_0x002d:
        r1 = r2 + 2;
        r8 = parseInt(r13, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = 84;
        r2 = checkOffset(r13, r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r2 != 0) goto L_0x0050;
    L_0x003b:
        r3 = r13.length();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r3 > r1) goto L_0x0050;
    L_0x0041:
        r0 = new java.util.GregorianCalendar;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = r7 + -1;
        r0.<init>(r6, r2, r8);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r14.setIndex(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r0.getTime();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
    L_0x004f:
        return r0;
    L_0x0050:
        if (r2 == 0) goto L_0x0230;
    L_0x0052:
        r2 = r1 + 1;
        r1 = r2 + 2;
        r3 = parseInt(r13, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = 58;
        r2 = checkOffset(r13, r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r2 == 0) goto L_0x022d;
    L_0x0062:
        r1 = r1 + 1;
        r2 = r1;
    L_0x0065:
        r1 = r2 + 2;
        r2 = parseInt(r13, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r4 = 58;
        r4 = checkOffset(r13, r1, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r4 == 0) goto L_0x0075;
    L_0x0073:
        r1 = r1 + 1;
    L_0x0075:
        r4 = r13.length();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r4 <= r1) goto L_0x0227;
    L_0x007b:
        r4 = r13.charAt(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r9 = 90;
        if (r4 == r9) goto L_0x0227;
    L_0x0083:
        if (r4 == r11) goto L_0x0227;
    L_0x0085:
        if (r4 == r10) goto L_0x0227;
    L_0x0087:
        r4 = r1 + 2;
        r1 = parseInt(r13, r1, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r1 <= r5) goto L_0x0094;
    L_0x008f:
        r9 = 63;
        if (r1 >= r9) goto L_0x0094;
    L_0x0093:
        r1 = r5;
    L_0x0094:
        r5 = 46;
        r5 = checkOffset(r13, r4, r5);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r5 == 0) goto L_0x0220;
    L_0x009c:
        r5 = r4 + 1;
        r0 = r5 + 1;
        r4 = indexOfNonDigit(r13, r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r5 + 3;
        r9 = java.lang.Math.min(r4, r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = parseInt(r13, r5, r9);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r5 = r9 - r5;
        switch(r5) {
            case 1: goto L_0x0125;
            case 2: goto L_0x0122;
            default: goto L_0x00b3;
        };	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
    L_0x00b3:
        r5 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r2;
        r2 = r0;
    L_0x00b8:
        r0 = r13.length();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r0 > r1) goto L_0x0128;
    L_0x00be:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r1 = "No time zone indicator";
        r0.<init>(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        throw r0;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
    L_0x00c6:
        r0 = move-exception;
        r2 = r0;
    L_0x00c8:
        if (r13 != 0) goto L_0x0205;
    L_0x00ca:
        r0 = 0;
    L_0x00cb:
        r1 = r2.getMessage();
        if (r1 == 0) goto L_0x00d7;
    L_0x00d1:
        r3 = r1.isEmpty();
        if (r3 == 0) goto L_0x00f8;
    L_0x00d7:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "(";
        r1 = r1.append(r3);
        r3 = r2.getClass();
        r3 = r3.getName();
        r1 = r1.append(r3);
        r3 = ")";
        r1 = r1.append(r3);
        r1 = r1.toString();
    L_0x00f8:
        r3 = new java.text.ParseException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Failed to parse date [";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r4 = "]: ";
        r0 = r0.append(r4);
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = r14.getIndex();
        r3.<init>(r0, r1);
        r3.initCause(r2);
        throw r3;
    L_0x0122:
        r0 = r0 * 10;
        goto L_0x00b3;
    L_0x0125:
        r0 = r0 * 100;
        goto L_0x00b3;
    L_0x0128:
        r0 = r13.charAt(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r9 = 90;
        if (r0 != r9) goto L_0x0168;
    L_0x0130:
        r0 = TIMEZONE_Z;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r1 = r1 + 1;
    L_0x0134:
        r9 = new java.util.GregorianCalendar;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r9.<init>(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = 0;
        r9.setLenient(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = 1;
        r9.set(r0, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = 2;
        r6 = r7 + -1;
        r9.set(r0, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = 5;
        r9.set(r0, r8);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = 11;
        r9.set(r0, r5);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = 12;
        r9.set(r0, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = 13;
        r9.set(r0, r3);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = 14;
        r9.set(r0, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r14.setIndex(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r9.getTime();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        goto L_0x004f;
    L_0x0168:
        if (r0 == r11) goto L_0x016c;
    L_0x016a:
        if (r0 != r10) goto L_0x01e2;
    L_0x016c:
        r0 = r13.substring(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r9 = r0.length();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r1 = r1 + r9;
        r9 = "+0000";
        r9 = r9.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r9 != 0) goto L_0x0185;
    L_0x017d:
        r9 = "+00:00";
        r9 = r9.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r9 == 0) goto L_0x0188;
    L_0x0185:
        r0 = TIMEZONE_Z;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        goto L_0x0134;
    L_0x0188:
        r9 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r9.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r10 = "GMT";
        r9 = r9.append(r10);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r9.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r9 = r0.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = java.util.TimeZone.getTimeZone(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r10 = r0.getID();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r11 = r10.equals(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r11 != 0) goto L_0x0134;
    L_0x01a9:
        r11 = ":";
        r12 = "";
        r10 = r10.replace(r11, r12);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r10 = r10.equals(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        if (r10 != 0) goto L_0x0134;
    L_0x01b7:
        r1 = new java.lang.IndexOutOfBoundsException;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r3 = "Mismatching time zone indicator: ";
        r2 = r2.append(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = r2.append(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r3 = " given, resolves to ";
        r2 = r2.append(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r0.getID();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r2.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r0.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r1.<init>(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        throw r1;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
    L_0x01de:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00c8;
    L_0x01e2:
        r1 = new java.lang.IndexOutOfBoundsException;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r3 = "Invalid time zone indicator '";
        r2 = r2.append(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r2.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r2 = "'";
        r0 = r0.append(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r0 = r0.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        r1.<init>(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
        throw r1;	 Catch:{ IndexOutOfBoundsException -> 0x00c6, NumberFormatException -> 0x01de, IllegalArgumentException -> 0x0201 }
    L_0x0201:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00c8;
    L_0x0205:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = 34;
        r0 = r0.append(r1);
        r0 = r0.append(r13);
        r1 = "'";
        r0 = r0.append(r1);
        r0 = r0.toString();
        goto L_0x00cb;
    L_0x0220:
        r5 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r2;
        r2 = r0;
        goto L_0x00b8;
    L_0x0227:
        r4 = r2;
        r5 = r3;
        r2 = r0;
        r3 = r0;
        goto L_0x00b8;
    L_0x022d:
        r2 = r1;
        goto L_0x0065;
    L_0x0230:
        r2 = r0;
        r3 = r0;
        r4 = r0;
        r5 = r0;
        goto L_0x00b8;
    L_0x0236:
        r2 = r1;
        goto L_0x002d;
    L_0x0239:
        r2 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i, int i2) {
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i3;
        int i4 = 0;
        if (i < i2) {
            i3 = i + 1;
            i4 = Character.digit(str.charAt(i), 10);
            if (i4 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -i4;
        } else {
            i3 = i;
        }
        while (i3 < i2) {
            int i5 = i3 + 1;
            i3 = Character.digit(str.charAt(i3), 10);
            if (i3 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - i3;
            i3 = i5;
        }
        return -i4;
    }
}
