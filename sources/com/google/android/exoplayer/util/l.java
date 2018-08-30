package com.google.android.exoplayer.util;

import android.net.Uri;
import android.text.TextUtils;

public final class l {
    private l() {
    }

    public static Uri a(String str, String str2) {
        return Uri.parse(b(str, str2));
    }

    private static String a(StringBuilder stringBuilder, int i, int i2) {
        if (i >= i2) {
            return stringBuilder.toString();
        }
        if (stringBuilder.charAt(i) == '/') {
            i++;
        }
        int i3 = i;
        int i4 = i;
        int i5 = i2;
        while (i3 <= i5) {
            int i6;
            if (i3 == i5) {
                i6 = i3;
            } else if (stringBuilder.charAt(i3) == '/') {
                i6 = i3 + 1;
            } else {
                i3++;
            }
            if (i3 == i4 + 1 && stringBuilder.charAt(i4) == '.') {
                stringBuilder.delete(i4, i6);
                i5 -= i6 - i4;
            } else if (i3 == i4 + 2 && stringBuilder.charAt(i4) == '.' && stringBuilder.charAt(i4 + 1) == '.') {
                i4 = stringBuilder.lastIndexOf("/", i4 - 2) + 1;
                i3 = i4 > i ? i4 : i;
                stringBuilder.delete(i3, i6);
                i5 -= i6 - i3;
            } else {
                i4 = i3 + 1;
            }
            int i7 = i4;
            i4 = i4;
            i3 = i7;
        }
        return stringBuilder.toString();
    }

    private static int[] a(String str) {
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        indexOf = str.indexOf(63);
        if (indexOf == -1 || indexOf > length) {
            indexOf = length;
        }
        int indexOf2 = str.indexOf(47);
        if (indexOf2 == -1 || indexOf2 > indexOf) {
            indexOf2 = indexOf;
        }
        int indexOf3 = str.indexOf(58);
        if (indexOf3 > indexOf2) {
            indexOf3 = -1;
        }
        indexOf2 = (indexOf3 + 2 < indexOf && str.charAt(indexOf3 + 1) == '/' && str.charAt(indexOf3 + 2) == '/') ? 1 : 0;
        if (indexOf2 != 0) {
            indexOf2 = str.indexOf(47, indexOf3 + 3);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                indexOf2 = indexOf;
            }
        } else {
            indexOf2 = indexOf3 + 1;
        }
        iArr[0] = indexOf3;
        iArr[1] = indexOf2;
        iArr[2] = indexOf;
        iArr[3] = length;
        return iArr;
    }

    public static String b(String str, String str2) {
        CharSequence str3;
        StringBuilder stringBuilder = new StringBuilder();
        if (str3 == null) {
            str3 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] a = a(str2);
        if (a[0] != -1) {
            stringBuilder.append(str2);
            a(stringBuilder, a[1], a[2]);
            return stringBuilder.toString();
        }
        int[] a2 = a(str3);
        if (a[3] == 0) {
            return stringBuilder.append(str3, 0, a2[3]).append(str2).toString();
        }
        if (a[2] == 0) {
            return stringBuilder.append(str3, 0, a2[2]).append(str2).toString();
        }
        int i;
        if (a[1] != 0) {
            i = a2[0] + 1;
            stringBuilder.append(str3, 0, i).append(str2);
            return a(stringBuilder, a[1] + i, i + a[2]);
        } else if (a[1] != a[2] && str2.charAt(a[1]) == '/') {
            stringBuilder.append(str3, 0, a2[1]).append(str2);
            return a(stringBuilder, a2[1], a[2] + a2[1]);
        } else if (a2[0] + 2 >= a2[1] || a2[1] != a2[2]) {
            i = str3.lastIndexOf(47, a2[2] - 1);
            i = i == -1 ? a2[1] : i + 1;
            stringBuilder.append(str3, 0, i).append(str2);
            return a(stringBuilder, a2[1], i + a[2]);
        } else {
            stringBuilder.append(str3, 0, a2[1]).append('/').append(str2);
            return a(stringBuilder, a2[1], (a[2] + a2[1]) + 1);
        }
    }
}
