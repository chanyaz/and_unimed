package com.google.gson.internal.bind.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
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

    /* JADX WARNING: Removed duplicated region for block: B:80:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0223  */
    public static java.util.Date parse(java.lang.String r14, java.text.ParsePosition r15) {
        /*
        r12 = 43;
        r13 = 34;
        r11 = 5;
        r10 = 45;
        r0 = 0;
        r2 = r15.getIndex();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r1 = r2 + 4;
        r6 = parseInt(r14, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = 45;
        r2 = checkOffset(r14, r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r2 == 0) goto L_0x0253;
    L_0x001a:
        r1 = r1 + 1;
        r2 = r1;
    L_0x001d:
        r1 = r2 + 2;
        r7 = parseInt(r14, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = 45;
        r2 = checkOffset(r14, r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r2 == 0) goto L_0x0250;
    L_0x002b:
        r1 = r1 + 1;
        r2 = r1;
    L_0x002e:
        r1 = r2 + 2;
        r8 = parseInt(r14, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = 84;
        r2 = checkOffset(r14, r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r2 != 0) goto L_0x0051;
    L_0x003c:
        r3 = r14.length();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r3 > r1) goto L_0x0051;
    L_0x0042:
        r0 = new java.util.GregorianCalendar;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = r7 + -1;
        r0.<init>(r6, r2, r8);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r15.setIndex(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r0.getTime();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
    L_0x0050:
        return r0;
    L_0x0051:
        if (r2 == 0) goto L_0x024a;
    L_0x0053:
        r2 = r1 + 1;
        r1 = r2 + 2;
        r3 = parseInt(r14, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = 58;
        r2 = checkOffset(r14, r1, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r2 == 0) goto L_0x0247;
    L_0x0063:
        r1 = r1 + 1;
        r2 = r1;
    L_0x0066:
        r1 = r2 + 2;
        r2 = parseInt(r14, r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r4 = 58;
        r4 = checkOffset(r14, r1, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r4 == 0) goto L_0x0076;
    L_0x0074:
        r1 = r1 + 1;
    L_0x0076:
        r4 = r14.length();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r4 <= r1) goto L_0x0241;
    L_0x007c:
        r4 = r14.charAt(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r5 = 90;
        if (r4 == r5) goto L_0x0241;
    L_0x0084:
        if (r4 == r12) goto L_0x0241;
    L_0x0086:
        if (r4 == r10) goto L_0x0241;
    L_0x0088:
        r4 = r1 + 2;
        r1 = parseInt(r14, r1, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r5 = 59;
        if (r1 <= r5) goto L_0x0098;
    L_0x0092:
        r5 = 63;
        if (r1 >= r5) goto L_0x0098;
    L_0x0096:
        r1 = 59;
    L_0x0098:
        r5 = 46;
        r5 = checkOffset(r14, r4, r5);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r5 == 0) goto L_0x023a;
    L_0x00a0:
        r5 = r4 + 1;
        r0 = r5 + 1;
        r4 = indexOfNonDigit(r14, r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r5 + 3;
        r9 = java.lang.Math.min(r4, r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = parseInt(r14, r5, r9);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r5 = r9 - r5;
        switch(r5) {
            case 1: goto L_0x0129;
            case 2: goto L_0x0126;
            default: goto L_0x00b7;
        };	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
    L_0x00b7:
        r5 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r2;
        r2 = r0;
    L_0x00bc:
        r0 = r14.length();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r0 > r1) goto L_0x012c;
    L_0x00c2:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r1 = "No time zone indicator";
        r0.<init>(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        throw r0;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
    L_0x00ca:
        r0 = move-exception;
        r2 = r0;
    L_0x00cc:
        if (r14 != 0) goto L_0x0223;
    L_0x00ce:
        r0 = 0;
    L_0x00cf:
        r1 = r2.getMessage();
        if (r1 == 0) goto L_0x00db;
    L_0x00d5:
        r3 = r1.isEmpty();
        if (r3 == 0) goto L_0x00fc;
    L_0x00db:
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
    L_0x00fc:
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
        r1 = r15.getIndex();
        r3.<init>(r0, r1);
        r3.initCause(r2);
        throw r3;
    L_0x0126:
        r0 = r0 * 10;
        goto L_0x00b7;
    L_0x0129:
        r0 = r0 * 100;
        goto L_0x00b7;
    L_0x012c:
        r0 = r14.charAt(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r9 = 90;
        if (r0 != r9) goto L_0x016c;
    L_0x0134:
        r0 = TIMEZONE_UTC;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r1 = r1 + 1;
    L_0x0138:
        r9 = new java.util.GregorianCalendar;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r9.<init>(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = 0;
        r9.setLenient(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = 1;
        r9.set(r0, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = 2;
        r6 = r7 + -1;
        r9.set(r0, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = 5;
        r9.set(r0, r8);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = 11;
        r9.set(r0, r5);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = 12;
        r9.set(r0, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = 13;
        r9.set(r0, r3);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = 14;
        r9.set(r0, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r15.setIndex(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r9.getTime();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        goto L_0x0050;
    L_0x016c:
        if (r0 == r12) goto L_0x0170;
    L_0x016e:
        if (r0 != r10) goto L_0x0200;
    L_0x0170:
        r0 = r14.substring(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r9 = r0.length();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r9 < r11) goto L_0x0192;
    L_0x017a:
        r9 = r0.length();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r1 = r1 + r9;
        r9 = "+0000";
        r9 = r9.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r9 != 0) goto L_0x018f;
    L_0x0187:
        r9 = "+00:00";
        r9 = r9.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r9 == 0) goto L_0x01a6;
    L_0x018f:
        r0 = TIMEZONE_UTC;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        goto L_0x0138;
    L_0x0192:
        r9 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r9.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r9.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r9 = "00";
        r0 = r0.append(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r0.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        goto L_0x017a;
    L_0x01a6:
        r9 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r9.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r10 = "GMT";
        r9 = r9.append(r10);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r9.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r9 = r0.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = java.util.TimeZone.getTimeZone(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r10 = r0.getID();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r11 = r10.equals(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r11 != 0) goto L_0x0138;
    L_0x01c7:
        r11 = ":";
        r12 = "";
        r10 = r10.replace(r11, r12);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r10 = r10.equals(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        if (r10 != 0) goto L_0x0138;
    L_0x01d5:
        r1 = new java.lang.IndexOutOfBoundsException;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r3 = "Mismatching time zone indicator: ";
        r2 = r2.append(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = r2.append(r9);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r3 = " given, resolves to ";
        r2 = r2.append(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r0.getID();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r2.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r0.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r1.<init>(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        throw r1;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
    L_0x01fc:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00cc;
    L_0x0200:
        r1 = new java.lang.IndexOutOfBoundsException;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r3 = "Invalid time zone indicator '";
        r2 = r2.append(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r2.append(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r2 = "'";
        r0 = r0.append(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r0 = r0.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        r1.<init>(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
        throw r1;	 Catch:{ IndexOutOfBoundsException -> 0x00ca, NumberFormatException -> 0x01fc, IllegalArgumentException -> 0x021f }
    L_0x021f:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00cc;
    L_0x0223:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r13);
        r0 = r0.append(r14);
        r0 = r0.append(r13);
        r0 = r0.toString();
        goto L_0x00cf;
    L_0x023a:
        r5 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r2;
        r2 = r0;
        goto L_0x00bc;
    L_0x0241:
        r4 = r2;
        r5 = r3;
        r2 = r0;
        r3 = r0;
        goto L_0x00bc;
    L_0x0247:
        r2 = r1;
        goto L_0x0066;
    L_0x024a:
        r2 = r0;
        r3 = r0;
        r4 = r0;
        r5 = r0;
        goto L_0x00bc;
    L_0x0250:
        r2 = r1;
        goto L_0x002e;
    L_0x0253:
        r2 = r1;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
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
