package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;

public final class Base64Variant implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient int[] _asciiToBase64;
    private final transient byte[] _base64ToAsciiB;
    private final transient char[] _base64ToAsciiC;
    protected final transient int _maxLineLength;
    protected final String _name;
    protected final transient char _paddingChar;
    protected final transient boolean _usesPadding;

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant._usesPadding, base64Variant._paddingChar, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, int i) {
        this._asciiToBase64 = new int[128];
        this._base64ToAsciiC = new char[64];
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        Object obj = base64Variant._base64ToAsciiB;
        System.arraycopy(obj, 0, this._base64ToAsciiB, 0, obj.length);
        obj = base64Variant._base64ToAsciiC;
        System.arraycopy(obj, 0, this._base64ToAsciiC, 0, obj.length);
        obj = base64Variant._asciiToBase64;
        System.arraycopy(obj, 0, this._asciiToBase64, 0, obj.length);
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
    }

    public Base64Variant(String str, String str2, boolean z, char c, int i) {
        int i2 = 0;
        this._asciiToBase64 = new int[128];
        this._base64ToAsciiC = new char[64];
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, this._base64ToAsciiC, 0);
        Arrays.fill(this._asciiToBase64, -1);
        while (i2 < length) {
            char c2 = this._base64ToAsciiC[i2];
            this._base64ToAsciiB[i2] = (byte) c2;
            this._asciiToBase64[c2] = i2;
            i2++;
        }
        if (z) {
            this._asciiToBase64[c] = -2;
        }
    }

    protected void _reportBase64EOF() {
        throw new IllegalArgumentException("Unexpected end-of-String in base64 content");
    }

    protected void _reportInvalidBase64(char c, int i, String str) {
        r0 = c <= ' ' ? "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units" : usesPaddingChar(c) ? "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character" : (!Character.isDefined(c) || Character.isISOControl(c)) ? "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content" : "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        if (str != null) {
            r0 = r0 + ": " + str;
        }
        throw new IllegalArgumentException(r0);
    }

    /* JADX WARNING: Missing block: B:6:0x0018, code:
            r4 = decodeBase64Char(r0);
     */
    /* JADX WARNING: Missing block: B:7:0x001c, code:
            if (r4 >= 0) goto L_0x0021;
     */
    /* JADX WARNING: Missing block: B:8:0x001e, code:
            _reportInvalidBase64(r0, 0, null);
     */
    /* JADX WARNING: Missing block: B:9:0x0021, code:
            if (r1 < r3) goto L_0x0026;
     */
    /* JADX WARNING: Missing block: B:10:0x0023, code:
            _reportBase64EOF();
     */
    /* JADX WARNING: Missing block: B:11:0x0026, code:
            r0 = r1 + 1;
            r1 = r11.charAt(r1);
            r5 = decodeBase64Char(r1);
     */
    /* JADX WARNING: Missing block: B:12:0x0030, code:
            if (r5 >= 0) goto L_0x0036;
     */
    /* JADX WARNING: Missing block: B:13:0x0032, code:
            _reportInvalidBase64(r1, 1, null);
     */
    /* JADX WARNING: Missing block: B:14:0x0036, code:
            r1 = (r4 << 6) | r5;
     */
    /* JADX WARNING: Missing block: B:15:0x0039, code:
            if (r0 < r3) goto L_0x004a;
     */
    /* JADX WARNING: Missing block: B:17:0x003f, code:
            if (usesPadding() != false) goto L_0x0047;
     */
    /* JADX WARNING: Missing block: B:18:0x0041, code:
            r12.append(r1 >> 4);
     */
    /* JADX WARNING: Missing block: B:19:0x0047, code:
            _reportBase64EOF();
     */
    /* JADX WARNING: Missing block: B:20:0x004a, code:
            r4 = r0 + 1;
            r0 = r11.charAt(r0);
            r5 = decodeBase64Char(r0);
     */
    /* JADX WARNING: Missing block: B:21:0x0054, code:
            if (r5 >= 0) goto L_0x0094;
     */
    /* JADX WARNING: Missing block: B:22:0x0056, code:
            if (r5 == -2) goto L_0x005c;
     */
    /* JADX WARNING: Missing block: B:23:0x0058, code:
            _reportInvalidBase64(r0, 2, null);
     */
    /* JADX WARNING: Missing block: B:24:0x005c, code:
            if (r4 < r3) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:25:0x005e, code:
            _reportBase64EOF();
     */
    /* JADX WARNING: Missing block: B:26:0x0061, code:
            r0 = r4 + 1;
            r4 = r11.charAt(r4);
     */
    /* JADX WARNING: Missing block: B:27:0x006b, code:
            if (usesPaddingChar(r4) != false) goto L_0x008d;
     */
    /* JADX WARNING: Missing block: B:28:0x006d, code:
            _reportInvalidBase64(r4, 3, "expected padding character '" + getPaddingChar() + "'");
     */
    /* JADX WARNING: Missing block: B:29:0x008d, code:
            r12.append(r1 >> 4);
     */
    /* JADX WARNING: Missing block: B:30:0x0094, code:
            r1 = (r1 << 6) | r5;
     */
    /* JADX WARNING: Missing block: B:31:0x0098, code:
            if (r4 < r3) goto L_0x00aa;
     */
    /* JADX WARNING: Missing block: B:33:0x009e, code:
            if (usesPadding() != false) goto L_0x00a7;
     */
    /* JADX WARNING: Missing block: B:34:0x00a0, code:
            r12.appendTwoBytes(r1 >> 2);
     */
    /* JADX WARNING: Missing block: B:35:0x00a7, code:
            _reportBase64EOF();
     */
    /* JADX WARNING: Missing block: B:36:0x00aa, code:
            r0 = r4 + 1;
            r4 = r11.charAt(r4);
            r5 = decodeBase64Char(r4);
     */
    /* JADX WARNING: Missing block: B:37:0x00b4, code:
            if (r5 >= 0) goto L_0x00c2;
     */
    /* JADX WARNING: Missing block: B:38:0x00b6, code:
            if (r5 == -2) goto L_0x00bb;
     */
    /* JADX WARNING: Missing block: B:39:0x00b8, code:
            _reportInvalidBase64(r4, 3, null);
     */
    /* JADX WARNING: Missing block: B:40:0x00bb, code:
            r12.appendTwoBytes(r1 >> 2);
     */
    /* JADX WARNING: Missing block: B:41:0x00c2, code:
            r12.appendThreeBytes((r1 << 6) | r5);
     */
    /* JADX WARNING: Missing block: B:52:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:53:?, code:
            return;
     */
    public void decode(java.lang.String r11, com.fasterxml.jackson.core.util.ByteArrayBuilder r12) {
        /*
        r10 = this;
        r9 = 3;
        r2 = 0;
        r8 = -2;
        r7 = 0;
        r3 = r11.length();
        r0 = r2;
    L_0x0009:
        if (r0 >= r3) goto L_0x0013;
    L_0x000b:
        r1 = r0 + 1;
        r0 = r11.charAt(r0);
        if (r1 < r3) goto L_0x0014;
    L_0x0013:
        return;
    L_0x0014:
        r4 = 32;
        if (r0 <= r4) goto L_0x00ca;
    L_0x0018:
        r4 = r10.decodeBase64Char(r0);
        if (r4 >= 0) goto L_0x0021;
    L_0x001e:
        r10._reportInvalidBase64(r0, r2, r7);
    L_0x0021:
        if (r1 < r3) goto L_0x0026;
    L_0x0023:
        r10._reportBase64EOF();
    L_0x0026:
        r0 = r1 + 1;
        r1 = r11.charAt(r1);
        r5 = r10.decodeBase64Char(r1);
        if (r5 >= 0) goto L_0x0036;
    L_0x0032:
        r6 = 1;
        r10._reportInvalidBase64(r1, r6, r7);
    L_0x0036:
        r1 = r4 << 6;
        r1 = r1 | r5;
        if (r0 < r3) goto L_0x004a;
    L_0x003b:
        r4 = r10.usesPadding();
        if (r4 != 0) goto L_0x0047;
    L_0x0041:
        r0 = r1 >> 4;
        r12.append(r0);
        goto L_0x0013;
    L_0x0047:
        r10._reportBase64EOF();
    L_0x004a:
        r4 = r0 + 1;
        r0 = r11.charAt(r0);
        r5 = r10.decodeBase64Char(r0);
        if (r5 >= 0) goto L_0x0094;
    L_0x0056:
        if (r5 == r8) goto L_0x005c;
    L_0x0058:
        r5 = 2;
        r10._reportInvalidBase64(r0, r5, r7);
    L_0x005c:
        if (r4 < r3) goto L_0x0061;
    L_0x005e:
        r10._reportBase64EOF();
    L_0x0061:
        r0 = r4 + 1;
        r4 = r11.charAt(r4);
        r5 = r10.usesPaddingChar(r4);
        if (r5 != 0) goto L_0x008d;
    L_0x006d:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "expected padding character '";
        r5 = r5.append(r6);
        r6 = r10.getPaddingChar();
        r5 = r5.append(r6);
        r6 = "'";
        r5 = r5.append(r6);
        r5 = r5.toString();
        r10._reportInvalidBase64(r4, r9, r5);
    L_0x008d:
        r1 = r1 >> 4;
        r12.append(r1);
        goto L_0x0009;
    L_0x0094:
        r0 = r1 << 6;
        r1 = r0 | r5;
        if (r4 < r3) goto L_0x00aa;
    L_0x009a:
        r0 = r10.usesPadding();
        if (r0 != 0) goto L_0x00a7;
    L_0x00a0:
        r0 = r1 >> 2;
        r12.appendTwoBytes(r0);
        goto L_0x0013;
    L_0x00a7:
        r10._reportBase64EOF();
    L_0x00aa:
        r0 = r4 + 1;
        r4 = r11.charAt(r4);
        r5 = r10.decodeBase64Char(r4);
        if (r5 >= 0) goto L_0x00c2;
    L_0x00b6:
        if (r5 == r8) goto L_0x00bb;
    L_0x00b8:
        r10._reportInvalidBase64(r4, r9, r7);
    L_0x00bb:
        r1 = r1 >> 2;
        r12.appendTwoBytes(r1);
        goto L_0x0009;
    L_0x00c2:
        r1 = r1 << 6;
        r1 = r1 | r5;
        r12.appendThreeBytes(r1);
        goto L_0x0009;
    L_0x00ca:
        r0 = r1;
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.Base64Variant.decode(java.lang.String, com.fasterxml.jackson.core.util.ByteArrayBuilder):void");
    }

    public byte[] decode(String str) {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        decode(str, byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }

    public int decodeBase64Char(char c) {
        return c <= 127 ? this._asciiToBase64[c] : -1;
    }

    public String encode(byte[] bArr, boolean z) {
        int i;
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(((length >> 2) + length) + (length >> 3));
        if (z) {
            stringBuilder.append('\"');
        }
        int i2 = 0;
        int i3 = length - 3;
        int maxLineLength = getMaxLineLength() >> 2;
        while (i2 <= i3) {
            i = i2 + 1;
            int i4 = i + 1;
            i = i4 + 1;
            encodeBase64Chunk(stringBuilder, (((bArr[i2] << 8) | (bArr[i] & 255)) << 8) | (bArr[i4] & 255));
            i2 = maxLineLength - 1;
            if (i2 <= 0) {
                stringBuilder.append('\\');
                stringBuilder.append('n');
                i2 = getMaxLineLength() >> 2;
            }
            maxLineLength = i2;
            i2 = i;
        }
        i = length - i2;
        if (i > 0) {
            maxLineLength = i2 + 1;
            i2 = bArr[i2] << 16;
            if (i == 2) {
                length = maxLineLength + 1;
                i2 |= (bArr[maxLineLength] & 255) << 8;
            }
            encodeBase64Partial(stringBuilder, i2, i);
        }
        if (z) {
            stringBuilder.append('\"');
        }
        return stringBuilder.toString();
    }

    public int encodeBase64Chunk(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = this._base64ToAsciiB[(i >> 18) & 63];
        int i4 = i3 + 1;
        bArr[i3] = this._base64ToAsciiB[(i >> 12) & 63];
        i3 = i4 + 1;
        bArr[i4] = this._base64ToAsciiB[(i >> 6) & 63];
        i4 = i3 + 1;
        bArr[i3] = this._base64ToAsciiB[i & 63];
        return i4;
    }

    public int encodeBase64Chunk(int i, char[] cArr, int i2) {
        int i3 = i2 + 1;
        cArr[i2] = this._base64ToAsciiC[(i >> 18) & 63];
        int i4 = i3 + 1;
        cArr[i3] = this._base64ToAsciiC[(i >> 12) & 63];
        i3 = i4 + 1;
        cArr[i4] = this._base64ToAsciiC[(i >> 6) & 63];
        i4 = i3 + 1;
        cArr[i3] = this._base64ToAsciiC[i & 63];
        return i4;
    }

    public void encodeBase64Chunk(StringBuilder stringBuilder, int i) {
        stringBuilder.append(this._base64ToAsciiC[(i >> 18) & 63]);
        stringBuilder.append(this._base64ToAsciiC[(i >> 12) & 63]);
        stringBuilder.append(this._base64ToAsciiC[(i >> 6) & 63]);
        stringBuilder.append(this._base64ToAsciiC[i & 63]);
    }

    public int encodeBase64Partial(int i, int i2, byte[] bArr, int i3) {
        int i4 = i3 + 1;
        bArr[i3] = this._base64ToAsciiB[(i >> 18) & 63];
        int i5 = i4 + 1;
        bArr[i4] = this._base64ToAsciiB[(i >> 12) & 63];
        if (this._usesPadding) {
            byte b = (byte) this._paddingChar;
            int i6 = i5 + 1;
            bArr[i5] = i2 == 2 ? this._base64ToAsciiB[(i >> 6) & 63] : b;
            i4 = i6 + 1;
            bArr[i6] = b;
            return i4;
        } else if (i2 != 2) {
            return i5;
        } else {
            i4 = i5 + 1;
            bArr[i5] = this._base64ToAsciiB[(i >> 6) & 63];
            return i4;
        }
    }

    public int encodeBase64Partial(int i, int i2, char[] cArr, int i3) {
        int i4 = i3 + 1;
        cArr[i3] = this._base64ToAsciiC[(i >> 18) & 63];
        int i5 = i4 + 1;
        cArr[i4] = this._base64ToAsciiC[(i >> 12) & 63];
        if (this._usesPadding) {
            int i6 = i5 + 1;
            cArr[i5] = i2 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar;
            i4 = i6 + 1;
            cArr[i6] = this._paddingChar;
            return i4;
        } else if (i2 != 2) {
            return i5;
        } else {
            i4 = i5 + 1;
            cArr[i5] = this._base64ToAsciiC[(i >> 6) & 63];
            return i4;
        }
    }

    public void encodeBase64Partial(StringBuilder stringBuilder, int i, int i2) {
        stringBuilder.append(this._base64ToAsciiC[(i >> 18) & 63]);
        stringBuilder.append(this._base64ToAsciiC[(i >> 12) & 63]);
        if (this._usesPadding) {
            stringBuilder.append(i2 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar);
            stringBuilder.append(this._paddingChar);
        } else if (i2 == 2) {
            stringBuilder.append(this._base64ToAsciiC[(i >> 6) & 63]);
        }
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    protected Object readResolve() {
        return Base64Variants.valueOf(this._name);
    }

    public String toString() {
        return this._name;
    }

    public boolean usesPadding() {
        return this._usesPadding;
    }

    public boolean usesPaddingChar(char c) {
        return c == this._paddingChar;
    }

    public boolean usesPaddingChar(int i) {
        return i == this._paddingChar;
    }
}
