package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

public final class JsonStringEncoder {
    private static final byte[] HB = CharTypes.copyHexBytes();
    private static final char[] HC = CharTypes.copyHexChars();
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal();
    protected ByteArrayBuilder _bytes;
    protected final char[] _qbuf = new char[6];
    protected TextBuffer _text;

    public JsonStringEncoder() {
        this._qbuf[0] = '\\';
        this._qbuf[2] = '0';
        this._qbuf[3] = '0';
    }

    private int _appendByte(int i, int i2, ByteArrayBuilder byteArrayBuilder, int i3) {
        byteArrayBuilder.setCurrentSegmentLength(i3);
        byteArrayBuilder.append(92);
        if (i2 < 0) {
            byteArrayBuilder.append(117);
            if (i > 255) {
                int i4 = i >> 8;
                byteArrayBuilder.append(HB[i4 >> 4]);
                byteArrayBuilder.append(HB[i4 & 15]);
                i &= 255;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byteArrayBuilder.append(HB[i >> 4]);
            byteArrayBuilder.append(HB[i & 15]);
        } else {
            byteArrayBuilder.append((byte) i2);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private int _appendNamed(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int _appendNumeric(int i, char[] cArr) {
        cArr[1] = 'u';
        cArr[4] = HC[i >> 4];
        cArr[5] = HC[i & 15];
        return 6;
    }

    private static int _convert(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return (65536 + ((i - 55296) << 10)) + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void _illegal(int i) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(i));
    }

    public static JsonStringEncoder getInstance() {
        SoftReference softReference = (SoftReference) _threadEncoder.get();
        JsonStringEncoder jsonStringEncoder = softReference == null ? null : (JsonStringEncoder) softReference.get();
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        jsonStringEncoder = new JsonStringEncoder();
        _threadEncoder.set(new SoftReference(jsonStringEncoder));
        return jsonStringEncoder;
    }

    public byte[] encodeAsUTF8(String str) {
        int i;
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder(null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] resetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int length2 = resetAndGetFirstSegment.length;
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (i3 < length) {
            int i4;
            int i5 = i3 + 1;
            i3 = str.charAt(i3);
            int i6 = length2;
            byte[] bArr = resetAndGetFirstSegment;
            int i7 = i2;
            i2 = i6;
            while (i3 <= 127) {
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.finishCurrentSegment();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) i3;
                if (i5 >= length) {
                    i = i4;
                    break loop0;
                }
                i7 = i5 + 1;
                i3 = str.charAt(i5);
                i5 = i7;
                i7 = i4;
            }
            if (i7 >= i2) {
                bArr = byteArrayBuilder.finishCurrentSegment();
                i2 = bArr.length;
                i4 = 0;
            } else {
                i4 = i7;
            }
            if (i3 < 2048) {
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 6) | 192);
                i4 = i3;
                i3 = i5;
            } else if (i3 < 55296 || i3 > 57343) {
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 12) | 224);
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.finishCurrentSegment();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 6) & 63) | 128);
                i7 = i4;
                i4 = i3;
                i3 = i5;
            } else {
                if (i3 > 56319) {
                    _illegal(i3);
                }
                if (i5 >= length) {
                    _illegal(i3);
                }
                int i8 = i5 + 1;
                i3 = _convert(i3, str.charAt(i5));
                if (i3 > 1114111) {
                    _illegal(i3);
                }
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 18) | 240);
                if (i7 >= i2) {
                    bArr = byteArrayBuilder.finishCurrentSegment();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 12) & 63) | 128);
                if (i4 >= i2) {
                    bArr = byteArrayBuilder.finishCurrentSegment();
                    i2 = bArr.length;
                    i7 = 0;
                } else {
                    i7 = i4;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 6) & 63) | 128);
                i7 = i4;
                i4 = i3;
                i3 = i8;
            }
            if (i7 >= i2) {
                bArr = byteArrayBuilder.finishCurrentSegment();
                i2 = bArr.length;
                i7 = 0;
            }
            i5 = i7 + 1;
            bArr[i7] = (byte) ((i4 & 63) | 128);
            resetAndGetFirstSegment = bArr;
            length2 = i2;
            i2 = i5;
        }
        i = i2;
        return this._bytes.completeAndCoalesce(i);
    }

    /* JADX WARNING: Missing block: B:9:0x0028, code:
            r4 = r2 + 1;
            r2 = r12.charAt(r2);
            r9 = r6[r2];
     */
    /* JADX WARNING: Missing block: B:10:0x0030, code:
            if (r9 >= 0) goto L_0x006b;
     */
    /* JADX WARNING: Missing block: B:11:0x0032, code:
            r2 = _appendNumeric(r2, r11._qbuf);
     */
    /* JADX WARNING: Missing block: B:13:0x003b, code:
            if ((r1 + r2) <= r3.length) goto L_0x0072;
     */
    /* JADX WARNING: Missing block: B:14:0x003d, code:
            r9 = r3.length - r1;
     */
    /* JADX WARNING: Missing block: B:15:0x003f, code:
            if (r9 <= 0) goto L_0x0046;
     */
    /* JADX WARNING: Missing block: B:16:0x0041, code:
            java.lang.System.arraycopy(r11._qbuf, 0, r3, r1, r9);
     */
    /* JADX WARNING: Missing block: B:17:0x0046, code:
            r3 = r0.finishCurrentSegment();
            r1 = r2 - r9;
            java.lang.System.arraycopy(r11._qbuf, r9, r3, 0, r1);
     */
    /* JADX WARNING: Missing block: B:18:0x0051, code:
            r2 = r4;
     */
    /* JADX WARNING: Missing block: B:26:0x006b, code:
            r2 = _appendNamed(r9, r11._qbuf);
     */
    /* JADX WARNING: Missing block: B:27:0x0072, code:
            java.lang.System.arraycopy(r11._qbuf, 0, r3, r1, r2);
            r1 = r1 + r2;
     */
    public char[] quoteAsString(java.lang.String r12) {
        /*
        r11 = this;
        r5 = 0;
        r0 = r11._text;
        if (r0 != 0) goto L_0x000d;
    L_0x0005:
        r0 = new com.fasterxml.jackson.core.util.TextBuffer;
        r1 = 0;
        r0.<init>(r1);
        r11._text = r0;
    L_0x000d:
        r3 = r0.emptyAndGetCurrentSegment();
        r6 = com.fasterxml.jackson.core.io.CharTypes.get7BitOutputEscapes();
        r7 = r6.length;
        r8 = r12.length();
        r1 = r5;
        r2 = r5;
    L_0x001c:
        if (r2 >= r8) goto L_0x0063;
    L_0x001e:
        r9 = r12.charAt(r2);
        if (r9 >= r7) goto L_0x0053;
    L_0x0024:
        r4 = r6[r9];
        if (r4 == 0) goto L_0x0053;
    L_0x0028:
        r4 = r2 + 1;
        r2 = r12.charAt(r2);
        r9 = r6[r2];
        if (r9 >= 0) goto L_0x006b;
    L_0x0032:
        r9 = r11._qbuf;
        r2 = r11._appendNumeric(r2, r9);
    L_0x0038:
        r9 = r1 + r2;
        r10 = r3.length;
        if (r9 <= r10) goto L_0x0072;
    L_0x003d:
        r9 = r3.length;
        r9 = r9 - r1;
        if (r9 <= 0) goto L_0x0046;
    L_0x0041:
        r10 = r11._qbuf;
        java.lang.System.arraycopy(r10, r5, r3, r1, r9);
    L_0x0046:
        r3 = r0.finishCurrentSegment();
        r1 = r2 - r9;
        r2 = r11._qbuf;
        java.lang.System.arraycopy(r2, r9, r3, r5, r1);
    L_0x0051:
        r2 = r4;
        goto L_0x001c;
    L_0x0053:
        r4 = r3.length;
        if (r1 < r4) goto L_0x0079;
    L_0x0056:
        r3 = r0.finishCurrentSegment();
        r4 = r5;
    L_0x005b:
        r1 = r4 + 1;
        r3[r4] = r9;
        r2 = r2 + 1;
        if (r2 < r8) goto L_0x001e;
    L_0x0063:
        r0.setCurrentLength(r1);
        r0 = r0.contentsAsArray();
        return r0;
    L_0x006b:
        r2 = r11._qbuf;
        r2 = r11._appendNamed(r9, r2);
        goto L_0x0038;
    L_0x0072:
        r9 = r11._qbuf;
        java.lang.System.arraycopy(r9, r5, r3, r1, r2);
        r1 = r1 + r2;
        goto L_0x0051;
    L_0x0079:
        r4 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    public byte[] quoteAsUTF8(String str) {
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder(null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] resetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int i = 0;
        int i2 = 0;
        loop0:
        while (i2 < length) {
            char charAt;
            int i3;
            int[] iArr = CharTypes.get7BitOutputEscapes();
            while (true) {
                charAt = str.charAt(i2);
                if (charAt <= 127 && iArr[charAt] == 0) {
                    if (i >= resetAndGetFirstSegment.length) {
                        resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        i3 = 0;
                    } else {
                        i3 = i;
                    }
                    i = i3 + 1;
                    resetAndGetFirstSegment[i3] = (byte) charAt;
                    i2++;
                    if (i2 >= length) {
                        break loop0;
                    }
                }
            }
            if (i >= resetAndGetFirstSegment.length) {
                resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                i = 0;
            }
            i3 = i2 + 1;
            charAt = str.charAt(i2);
            if (charAt <= 127) {
                i = _appendByte(charAt, iArr[charAt], byteArrayBuilder, i);
                resetAndGetFirstSegment = byteArrayBuilder.getCurrentSegment();
                i2 = i3;
            } else {
                byte[] bArr;
                int i4;
                int i5;
                if (charAt <= 2047) {
                    i2 = i + 1;
                    resetAndGetFirstSegment[i] = (byte) ((charAt >> 6) | 192);
                    bArr = resetAndGetFirstSegment;
                    i4 = (charAt & 63) | 128;
                } else if (charAt < 55296 || charAt > 57343) {
                    i2 = i + 1;
                    resetAndGetFirstSegment[i] = (byte) ((charAt >> 12) | 224);
                    if (i2 >= resetAndGetFirstSegment.length) {
                        resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                    resetAndGetFirstSegment[i] = (byte) (((charAt >> 6) & 63) | 128);
                    bArr = resetAndGetFirstSegment;
                    i4 = (charAt & 63) | 128;
                } else {
                    if (charAt > 56319) {
                        _illegal(charAt);
                    }
                    if (i3 >= length) {
                        _illegal(charAt);
                    }
                    i5 = i3 + 1;
                    i3 = _convert(charAt, str.charAt(i3));
                    if (i3 > 1114111) {
                        _illegal(i3);
                    }
                    i2 = i + 1;
                    resetAndGetFirstSegment[i] = (byte) ((i3 >> 18) | 240);
                    if (i2 >= resetAndGetFirstSegment.length) {
                        resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                    resetAndGetFirstSegment[i] = (byte) (((i3 >> 12) & 63) | 128);
                    if (i2 >= resetAndGetFirstSegment.length) {
                        resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                    resetAndGetFirstSegment[i] = (byte) (((i3 >> 6) & 63) | 128);
                    i3 = i5;
                    byte[] bArr2 = resetAndGetFirstSegment;
                    i4 = (i3 & 63) | 128;
                    bArr = bArr2;
                }
                if (i2 >= bArr.length) {
                    bArr = byteArrayBuilder.finishCurrentSegment();
                    i2 = 0;
                }
                i5 = i2 + 1;
                bArr[i2] = (byte) i4;
                resetAndGetFirstSegment = bArr;
                i2 = i3;
                i = i5;
            }
        }
        return this._bytes.completeAndCoalesce(i);
    }
}
