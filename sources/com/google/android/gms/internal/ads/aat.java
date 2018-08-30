package com.google.android.gms.internal.ads;

final class aat extends aas {
    aat() {
    }

    final int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i2;
        while (i4 < i3 && bArr[i4] >= (byte) 0) {
            i4++;
        }
        if (i4 >= i3) {
            return 0;
        }
        while (i4 < i3) {
            int i5 = i4 + 1;
            byte b = bArr[i4];
            int i6;
            byte b2;
            if (b >= (byte) 0) {
                i4 = i5;
            } else if (b < (byte) -32) {
                if (i5 >= i3) {
                    return b;
                }
                if (b >= (byte) -62) {
                    i4 = i5 + 1;
                    if (bArr[i5] > (byte) -65) {
                    }
                }
                return -1;
            } else if (b < (byte) -16) {
                if (i5 >= i3 - 1) {
                    return aar.c(bArr, i5, i3);
                }
                i6 = i5 + 1;
                b2 = bArr[i5];
                if (b2 <= (byte) -65 && ((b != (byte) -32 || b2 >= (byte) -96) && (b != (byte) -19 || b2 < (byte) -96))) {
                    i4 = i6 + 1;
                    if (bArr[i6] > (byte) -65) {
                    }
                }
                return -1;
            } else if (i5 >= i3 - 2) {
                return aar.c(bArr, i5, i3);
            } else {
                i6 = i5 + 1;
                b2 = bArr[i5];
                if (b2 <= (byte) -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                    i5 = i6 + 1;
                    if (bArr[i6] <= (byte) -65) {
                        i4 = i5 + 1;
                        if (bArr[i5] > (byte) -65) {
                        }
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char charAt;
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            charAt = charSequence.charAt(i3);
            if (charAt >= 128) {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            int i7;
            if (charAt2 < 128 && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 2048 && i5 <= i4 - 2) {
                i7 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        i7 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = i7 + 1;
                        bArr[i7] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new aau(i3 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || (i3 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            } else {
                throw new aau(i3, length);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }
}
