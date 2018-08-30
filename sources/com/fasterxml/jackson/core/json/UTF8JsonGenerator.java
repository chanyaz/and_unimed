package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class UTF8JsonGenerator extends JsonGeneratorImpl {
    private static final byte[] FALSE_BYTES = new byte[]{(byte) 102, (byte) 97, (byte) 108, (byte) 115, (byte) 101};
    private static final byte[] HEX_CHARS = CharTypes.copyHexBytes();
    private static final byte[] NULL_BYTES = new byte[]{(byte) 110, (byte) 117, (byte) 108, (byte) 108};
    private static final byte[] TRUE_BYTES = new byte[]{(byte) 116, (byte) 114, (byte) 117, (byte) 101};
    protected boolean _bufferRecyclable = true;
    protected char[] _charBuffer;
    protected final int _charBufferLength;
    protected byte[] _outputBuffer;
    protected final int _outputEnd;
    protected final int _outputMaxContiguous;
    protected final OutputStream _outputStream;
    protected int _outputTail;

    public UTF8JsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, OutputStream outputStream) {
        super(iOContext, i, objectCodec);
        this._outputStream = outputStream;
        this._outputBuffer = iOContext.allocWriteEncodingBuffer();
        this._outputEnd = this._outputBuffer.length;
        this._outputMaxContiguous = this._outputEnd >> 3;
        this._charBuffer = iOContext.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
        if (isEnabled(Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(127);
        }
    }

    private final int _handleLongCustomEscape(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        int length = bArr2.length;
        if (i + length > i2) {
            this._outputTail = i;
            _flushBuffer();
            i4 = this._outputTail;
            if (length > bArr.length) {
                this._outputStream.write(bArr2, 0, length);
                return i4;
            }
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        } else {
            i4 = i;
        }
        if ((i3 * 6) + i4 <= i2) {
            return i4;
        }
        _flushBuffer();
        return this._outputTail;
    }

    private final int _outputMultiByteChar(int i, int i2) {
        byte[] bArr = this._outputBuffer;
        int i3;
        int i4;
        if (i < 55296 || i > 57343) {
            i3 = i2 + 1;
            bArr[i2] = (byte) ((i >> 12) | 224);
            i4 = i3 + 1;
            bArr[i3] = (byte) (((i >> 6) & 63) | 128);
            i3 = i4 + 1;
            bArr[i4] = (byte) ((i & 63) | 128);
            return i3;
        }
        i3 = i2 + 1;
        bArr[i2] = (byte) 92;
        i4 = i3 + 1;
        bArr[i3] = (byte) 117;
        i3 = i4 + 1;
        bArr[i4] = HEX_CHARS[(i >> 12) & 15];
        i4 = i3 + 1;
        bArr[i3] = HEX_CHARS[(i >> 8) & 15];
        int i5 = i4 + 1;
        bArr[i4] = HEX_CHARS[(i >> 4) & 15];
        i3 = i5 + 1;
        bArr[i5] = HEX_CHARS[i & 15];
        return i3;
    }

    private final int _outputRawMultiByteChar(int i, char[] cArr, int i2, int i3) {
        if (i < 55296 || i > 57343) {
            byte[] bArr = this._outputBuffer;
            int i4 = this._outputTail;
            this._outputTail = i4 + 1;
            bArr[i4] = (byte) ((i >> 12) | 224);
            i4 = this._outputTail;
            this._outputTail = i4 + 1;
            bArr[i4] = (byte) (((i >> 6) & 63) | 128);
            i4 = this._outputTail;
            this._outputTail = i4 + 1;
            bArr[i4] = (byte) ((i & 63) | 128);
            return i2;
        }
        if (i2 >= i3 || cArr == null) {
            _reportError("Split surrogate on writeRaw() input (last character)");
        }
        _outputSurrogates(i, cArr[i2]);
        return i2 + 1;
    }

    private final int _readMore(InputStream inputStream, byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (i < i2) {
            i4 = i6 + 1;
            i5 = i + 1;
            bArr[i6] = bArr[i];
            i6 = i4;
            i = i5;
        }
        i4 = Math.min(i3, bArr.length);
        do {
            i5 = i4 - i6;
            if (i5 != 0) {
                i5 = inputStream.read(bArr, i6, i5);
                if (i5 < 0) {
                    break;
                }
                i6 += i5;
            } else {
                break;
            }
        } while (i6 < 3);
        return i6;
    }

    private final void _writeBytes(byte[] bArr) {
        int length = bArr.length;
        if (this._outputTail + length > this._outputEnd) {
            _flushBuffer();
            if (length > 512) {
                this._outputStream.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this._outputBuffer, this._outputTail, length);
        this._outputTail = length + this._outputTail;
    }

    private final int _writeCustomEscape(byte[] bArr, int i, SerializableString serializableString, int i2) {
        Object asUnquotedUTF8 = serializableString.asUnquotedUTF8();
        int length = asUnquotedUTF8.length;
        if (length > 6) {
            return _handleLongCustomEscape(bArr, i, this._outputEnd, asUnquotedUTF8, i2);
        }
        System.arraycopy(asUnquotedUTF8, 0, bArr, i, length);
        return length + i;
    }

    private final void _writeCustomStringSegment2(String str, int i, int i2) {
        if (this._outputTail + ((i2 - i) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int i3 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        char c = this._maximumNonEscapedChar <= 0 ? 65535 : this._maximumNonEscapedChar;
        CharacterEscapes characterEscapes = this._characterEscapes;
        while (i < i2) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            int i5;
            SerializableString escapeSequence;
            if (charAt <= 127) {
                if (iArr[charAt] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[charAt];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else if (i5 == -2) {
                        escapeSequence = characterEscapes.getEscapeSequence(charAt);
                        if (escapeSequence == null) {
                            _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(charAt) + ", although was supposed to have one");
                        }
                        i3 = _writeCustomEscape(bArr, i3, escapeSequence, i2 - i4);
                        i = i4;
                    } else {
                        i3 = _writeGenericEscape(charAt, i3);
                        i = i4;
                    }
                }
            } else if (charAt > c) {
                i3 = _writeGenericEscape(charAt, i3);
                i = i4;
            } else {
                escapeSequence = characterEscapes.getEscapeSequence(charAt);
                if (escapeSequence != null) {
                    i3 = _writeCustomEscape(bArr, i3, escapeSequence, i2 - i4);
                    i = i4;
                } else {
                    if (charAt <= 2047) {
                        i5 = i3 + 1;
                        bArr[i3] = (byte) ((charAt >> 6) | 192);
                        i3 = i5 + 1;
                        bArr[i5] = (byte) ((charAt & 63) | 128);
                    } else {
                        i3 = _outputMultiByteChar(charAt, i3);
                    }
                    i = i4;
                }
            }
        }
        this._outputTail = i3;
    }

    private final void _writeCustomStringSegment2(char[] cArr, int i, int i2) {
        if (this._outputTail + ((i2 - i) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int i3 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        char c = this._maximumNonEscapedChar <= 0 ? 65535 : this._maximumNonEscapedChar;
        CharacterEscapes characterEscapes = this._characterEscapes;
        while (i < i2) {
            int i4 = i + 1;
            char c2 = cArr[i];
            int i5;
            SerializableString escapeSequence;
            if (c2 <= 127) {
                if (iArr[c2] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) c2;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[c2];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else if (i5 == -2) {
                        escapeSequence = characterEscapes.getEscapeSequence(c2);
                        if (escapeSequence == null) {
                            _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(c2) + ", although was supposed to have one");
                        }
                        i3 = _writeCustomEscape(bArr, i3, escapeSequence, i2 - i4);
                        i = i4;
                    } else {
                        i3 = _writeGenericEscape(c2, i3);
                        i = i4;
                    }
                }
            } else if (c2 > c) {
                i3 = _writeGenericEscape(c2, i3);
                i = i4;
            } else {
                escapeSequence = characterEscapes.getEscapeSequence(c2);
                if (escapeSequence != null) {
                    i3 = _writeCustomEscape(bArr, i3, escapeSequence, i2 - i4);
                    i = i4;
                } else {
                    if (c2 <= 2047) {
                        i5 = i3 + 1;
                        bArr[i3] = (byte) ((c2 >> 6) | 192);
                        i3 = i5 + 1;
                        bArr[i5] = (byte) ((c2 & 63) | 128);
                    } else {
                        i3 = _outputMultiByteChar(c2, i3);
                    }
                    i = i4;
                }
            }
        }
        this._outputTail = i3;
    }

    private int _writeGenericEscape(int i, int i2) {
        byte[] bArr = this._outputBuffer;
        int i3 = i2 + 1;
        bArr[i2] = (byte) 92;
        int i4 = i3 + 1;
        bArr[i3] = (byte) 117;
        int i5;
        if (i > 255) {
            i5 = (i >> 8) & 255;
            int i6 = i4 + 1;
            bArr[i4] = HEX_CHARS[i5 >> 4];
            i3 = i6 + 1;
            bArr[i6] = HEX_CHARS[i5 & 15];
            i &= 255;
        } else {
            i5 = i4 + 1;
            bArr[i4] = (byte) 48;
            i3 = i5 + 1;
            bArr[i5] = (byte) 48;
        }
        i4 = i3 + 1;
        bArr[i3] = HEX_CHARS[i >> 4];
        i3 = i4 + 1;
        bArr[i4] = HEX_CHARS[i & 15];
        return i3;
    }

    private final void _writeNull() {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(NULL_BYTES, 0, this._outputBuffer, this._outputTail, 4);
        this._outputTail += 4;
    }

    private final void _writeQuotedInt(int i) {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = (byte) 34;
        this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        bArr = this._outputBuffer;
        i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = (byte) 34;
    }

    private final void _writeQuotedLong(long j) {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
        this._outputTail = NumberOutput.outputLong(j, this._outputBuffer, this._outputTail);
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
    }

    private final void _writeQuotedRaw(String str) {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
        writeRaw(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
    }

    private final void _writeQuotedShort(short s) {
        if (this._outputTail + 8 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
        this._outputTail = NumberOutput.outputInt((int) s, this._outputBuffer, this._outputTail);
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
    }

    /* JADX WARNING: Missing block: B:5:0x0013, code:
            if ((r6._outputTail + 3) < r6._outputEnd) goto L_0x0018;
     */
    /* JADX WARNING: Missing block: B:6:0x0015, code:
            _flushBuffer();
     */
    /* JADX WARNING: Missing block: B:7:0x0018, code:
            r1 = r0 + 1;
            r0 = r7[r0];
     */
    /* JADX WARNING: Missing block: B:8:0x001e, code:
            if (r0 >= 2048) goto L_0x0051;
     */
    /* JADX WARNING: Missing block: B:9:0x0020, code:
            r4 = r6._outputTail;
            r6._outputTail = r4 + 1;
            r3[r4] = (byte) ((r0 >> 6) | 192);
            r4 = r6._outputTail;
            r6._outputTail = r4 + 1;
            r3[r4] = (byte) ((r0 & 63) | 128);
            r0 = r1;
     */
    /* JADX WARNING: Missing block: B:15:0x0051, code:
            r0 = _outputRawMultiByteChar(r0, r7, r1, r9);
     */
    private final void _writeSegmentedRaw(char[] r7, int r8, int r9) {
        /*
        r6 = this;
        r2 = r6._outputEnd;
        r3 = r6._outputBuffer;
        r0 = r8;
    L_0x0005:
        if (r0 >= r9) goto L_0x0050;
    L_0x0007:
        r1 = r7[r0];
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r1 < r4) goto L_0x003c;
    L_0x000d:
        r1 = r6._outputTail;
        r1 = r1 + 3;
        r4 = r6._outputEnd;
        if (r1 < r4) goto L_0x0018;
    L_0x0015:
        r6._flushBuffer();
    L_0x0018:
        r1 = r0 + 1;
        r0 = r7[r0];
        r4 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        if (r0 >= r4) goto L_0x0051;
    L_0x0020:
        r4 = r6._outputTail;
        r5 = r4 + 1;
        r6._outputTail = r5;
        r5 = r0 >> 6;
        r5 = r5 | 192;
        r5 = (byte) r5;
        r3[r4] = r5;
        r4 = r6._outputTail;
        r5 = r4 + 1;
        r6._outputTail = r5;
        r0 = r0 & 63;
        r0 = r0 | 128;
        r0 = (byte) r0;
        r3[r4] = r0;
        r0 = r1;
        goto L_0x0005;
    L_0x003c:
        r4 = r6._outputTail;
        if (r4 < r2) goto L_0x0043;
    L_0x0040:
        r6._flushBuffer();
    L_0x0043:
        r4 = r6._outputTail;
        r5 = r4 + 1;
        r6._outputTail = r5;
        r1 = (byte) r1;
        r3[r4] = r1;
        r0 = r0 + 1;
        if (r0 < r9) goto L_0x0007;
    L_0x0050:
        return;
    L_0x0051:
        r0 = r6._outputRawMultiByteChar(r0, r7, r1, r9);
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8JsonGenerator._writeSegmentedRaw(char[], int, int):void");
    }

    private final void _writeStringSegment(String str, int i, int i2) {
        int i3 = i2 + i;
        int i4 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i3) {
            char charAt = str.charAt(i);
            if (charAt > 127 || iArr[charAt] != 0) {
                break;
            }
            int i5 = i4 + 1;
            bArr[i4] = (byte) charAt;
            i++;
            i4 = i5;
        }
        this._outputTail = i4;
        if (i >= i3) {
            return;
        }
        if (this._characterEscapes != null) {
            _writeCustomStringSegment2(str, i, i3);
        } else if (this._maximumNonEscapedChar == 0) {
            _writeStringSegment2(str, i, i3);
        } else {
            _writeStringSegmentASCII2(str, i, i3);
        }
    }

    private final void _writeStringSegment(char[] cArr, int i, int i2) {
        int i3 = i2 + i;
        int i4 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i3) {
            char c = cArr[i];
            if (c > 127 || iArr[c] != 0) {
                break;
            }
            int i5 = i4 + 1;
            bArr[i4] = (byte) c;
            i++;
            i4 = i5;
        }
        this._outputTail = i4;
        if (i >= i3) {
            return;
        }
        if (this._characterEscapes != null) {
            _writeCustomStringSegment2(cArr, i, i3);
        } else if (this._maximumNonEscapedChar == 0) {
            _writeStringSegment2(cArr, i, i3);
        } else {
            _writeStringSegmentASCII2(cArr, i, i3);
        }
    }

    private final void _writeStringSegment2(String str, int i, int i2) {
        if (this._outputTail + ((i2 - i) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int i3 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i2) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            int i5;
            if (charAt > 127) {
                if (charAt <= 2047) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((charAt & 63) | 128);
                } else {
                    i3 = _outputMultiByteChar(charAt, i3);
                }
                i = i4;
            } else if (iArr[charAt] == 0) {
                i5 = i3 + 1;
                bArr[i3] = (byte) charAt;
                i3 = i5;
                i = i4;
            } else {
                i5 = iArr[charAt];
                if (i5 > 0) {
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) 92;
                    i3 = i6 + 1;
                    bArr[i6] = (byte) i5;
                    i = i4;
                } else {
                    i3 = _writeGenericEscape(charAt, i3);
                    i = i4;
                }
            }
        }
        this._outputTail = i3;
    }

    private final void _writeStringSegment2(char[] cArr, int i, int i2) {
        if (this._outputTail + ((i2 - i) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int i3 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        while (i < i2) {
            int i4 = i + 1;
            char c = cArr[i];
            int i5;
            if (c > 127) {
                if (c <= 2047) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((c >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((c & 63) | 128);
                } else {
                    i3 = _outputMultiByteChar(c, i3);
                }
                i = i4;
            } else if (iArr[c] == 0) {
                i5 = i3 + 1;
                bArr[i3] = (byte) c;
                i3 = i5;
                i = i4;
            } else {
                i5 = iArr[c];
                if (i5 > 0) {
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) 92;
                    i3 = i6 + 1;
                    bArr[i6] = (byte) i5;
                    i = i4;
                } else {
                    i3 = _writeGenericEscape(c, i3);
                    i = i4;
                }
            }
        }
        this._outputTail = i3;
    }

    private final void _writeStringSegmentASCII2(String str, int i, int i2) {
        if (this._outputTail + ((i2 - i) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int i3 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        char c = this._maximumNonEscapedChar;
        while (i < i2) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            int i5;
            if (charAt <= 127) {
                if (iArr[charAt] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[charAt];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else {
                        i3 = _writeGenericEscape(charAt, i3);
                        i = i4;
                    }
                }
            } else if (charAt > c) {
                i3 = _writeGenericEscape(charAt, i3);
                i = i4;
            } else {
                if (charAt <= 2047) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((charAt >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((charAt & 63) | 128);
                } else {
                    i3 = _outputMultiByteChar(charAt, i3);
                }
                i = i4;
            }
        }
        this._outputTail = i3;
    }

    private final void _writeStringSegmentASCII2(char[] cArr, int i, int i2) {
        if (this._outputTail + ((i2 - i) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int i3 = this._outputTail;
        byte[] bArr = this._outputBuffer;
        int[] iArr = this._outputEscapes;
        char c = this._maximumNonEscapedChar;
        while (i < i2) {
            int i4 = i + 1;
            char c2 = cArr[i];
            int i5;
            if (c2 <= 127) {
                if (iArr[c2] == 0) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) c2;
                    i3 = i5;
                    i = i4;
                } else {
                    i5 = iArr[c2];
                    if (i5 > 0) {
                        int i6 = i3 + 1;
                        bArr[i3] = (byte) 92;
                        i3 = i6 + 1;
                        bArr[i6] = (byte) i5;
                        i = i4;
                    } else {
                        i3 = _writeGenericEscape(c2, i3);
                        i = i4;
                    }
                }
            } else if (c2 > c) {
                i3 = _writeGenericEscape(c2, i3);
                i = i4;
            } else {
                if (c2 <= 2047) {
                    i5 = i3 + 1;
                    bArr[i3] = (byte) ((c2 >> 6) | 192);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) ((c2 & 63) | 128);
                } else {
                    i3 = _outputMultiByteChar(c2, i3);
                }
                i = i4;
            }
        }
        this._outputTail = i3;
    }

    private final void _writeStringSegments(String str, int i, int i2) {
        do {
            int min = Math.min(this._outputMaxContiguous, i2);
            if (this._outputTail + min > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(str, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    private final void _writeStringSegments(String str, boolean z) {
        byte[] bArr;
        int i;
        if (z) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            bArr = this._outputBuffer;
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) 34;
        }
        i = str.length();
        int i2 = 0;
        while (i > 0) {
            int min = Math.min(this._outputMaxContiguous, i);
            if (this._outputTail + min > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(str, i2, min);
            i2 += min;
            i -= min;
        }
        if (z) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            bArr = this._outputBuffer;
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) 34;
        }
    }

    private final void _writeStringSegments(char[] cArr, int i, int i2) {
        do {
            int min = Math.min(this._outputMaxContiguous, i2);
            if (this._outputTail + min > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cArr, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    private final void _writeUnq(SerializableString serializableString) {
        int appendQuotedUTF8 = serializableString.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (appendQuotedUTF8 < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail = appendQuotedUTF8 + this._outputTail;
        }
    }

    protected final void _flushBuffer() {
        int i = this._outputTail;
        if (i > 0) {
            this._outputTail = 0;
            this._outputStream.write(this._outputBuffer, 0, i);
        }
    }

    protected final void _outputSurrogates(int i, int i2) {
        int _decodeSurrogate = _decodeSurrogate(i, i2);
        if (this._outputTail + 4 > this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr[i3] = (byte) ((_decodeSurrogate >> 18) | 240);
        i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr[i3] = (byte) (((_decodeSurrogate >> 12) & 63) | 128);
        i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr[i3] = (byte) (((_decodeSurrogate >> 6) & 63) | 128);
        i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr[i3] = (byte) ((_decodeSurrogate & 63) | 128);
    }

    protected void _releaseBuffers() {
        byte[] bArr = this._outputBuffer;
        if (bArr != null && this._bufferRecyclable) {
            this._outputBuffer = null;
            this._ioContext.releaseWriteEncodingBuffer(bArr);
        }
        char[] cArr = this._charBuffer;
        if (cArr != null) {
            this._charBuffer = null;
            this._ioContext.releaseConcatBuffer(cArr);
        }
    }

    protected final void _verifyPrettyValueWrite(String str, int i) {
        switch (i) {
            case 0:
                if (this._writeContext.inArray()) {
                    this._cfgPrettyPrinter.beforeArrayValues(this);
                    return;
                } else if (this._writeContext.inObject()) {
                    this._cfgPrettyPrinter.beforeObjectEntries(this);
                    return;
                } else {
                    return;
                }
            case 1:
                this._cfgPrettyPrinter.writeArrayValueSeparator(this);
                return;
            case 2:
                this._cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
                return;
            case 3:
                this._cfgPrettyPrinter.writeRootValueSeparator(this);
                return;
            default:
                _throwInternal();
                return;
        }
    }

    protected final void _verifyValueWrite(String str) {
        int writeValue = this._writeContext.writeValue();
        if (writeValue == 5) {
            _reportError("Can not " + str + ", expecting field name");
        }
        if (this._cfgPrettyPrinter == null) {
            byte b;
            switch (writeValue) {
                case 1:
                    b = (byte) 44;
                    break;
                case 2:
                    b = (byte) 58;
                    break;
                case 3:
                    if (this._rootValueSeparator != null) {
                        byte[] asUnquotedUTF8 = this._rootValueSeparator.asUnquotedUTF8();
                        if (asUnquotedUTF8.length > 0) {
                            _writeBytes(asUnquotedUTF8);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            this._outputBuffer[this._outputTail] = b;
            this._outputTail++;
            return;
        }
        _verifyPrettyValueWrite(str, writeValue);
    }

    protected final int _writeBinary(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) {
        int i;
        int i2;
        int i3 = -3;
        int i4 = this._outputEnd - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i7 > i3) {
                i6 = _readMore(inputStream, bArr, i7, i6, bArr.length);
                if (i6 < 3) {
                    break;
                }
                i3 = i6 - 3;
                i7 = 0;
            }
            if (this._outputTail > i4) {
                _flushBuffer();
            }
            i = i7 + 1;
            i2 = bArr[i7] << 8;
            int i8 = i + 1;
            i7 = i8 + 1;
            i5 += 3;
            this._outputTail = base64Variant.encodeBase64Chunk((((bArr[i] & 255) | i2) << 8) | (bArr[i8] & 255), this._outputBuffer, this._outputTail);
            i = maxLineLength - 1;
            if (i <= 0) {
                byte[] bArr2 = this._outputBuffer;
                i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr2[i2] = (byte) 92;
                bArr2 = this._outputBuffer;
                i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr2[i2] = (byte) 110;
                i = base64Variant.getMaxLineLength() >> 2;
            }
            maxLineLength = i;
        }
        if (0 >= i6) {
            return i5;
        }
        if (this._outputTail > i4) {
            _flushBuffer();
        }
        i3 = bArr[0] << 16;
        if (1 < i6) {
            i = ((bArr[1] & 255) << 8) | i3;
            i3 = 2;
        } else {
            i = i3;
            i3 = 1;
        }
        i2 = i5 + i3;
        this._outputTail = base64Variant.encodeBase64Partial(i, i3, this._outputBuffer, this._outputTail);
        return i2;
    }

    protected final int _writeBinary(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = -3;
        int i6 = this._outputEnd - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i7 = i;
        while (i7 > 2) {
            if (i3 > i5) {
                i4 = _readMore(inputStream, bArr, i3, i4, i7);
                i3 = 0;
                if (i4 < 3) {
                    break;
                }
                i5 = i4 - 3;
            }
            if (this._outputTail > i6) {
                _flushBuffer();
            }
            i2 = i3 + 1;
            int i8 = bArr[i3] << 8;
            int i9 = i2 + 1;
            i3 = i9 + 1;
            i7 -= 3;
            this._outputTail = base64Variant.encodeBase64Chunk((((bArr[i2] & 255) | i8) << 8) | (bArr[i9] & 255), this._outputBuffer, this._outputTail);
            i2 = maxLineLength - 1;
            if (i2 <= 0) {
                byte[] bArr2 = this._outputBuffer;
                i8 = this._outputTail;
                this._outputTail = i8 + 1;
                bArr2[i8] = (byte) 92;
                bArr2 = this._outputBuffer;
                i8 = this._outputTail;
                this._outputTail = i8 + 1;
                bArr2[i8] = (byte) 110;
                i2 = base64Variant.getMaxLineLength() >> 2;
            }
            maxLineLength = i2;
        }
        if (i7 <= 0) {
            return i7;
        }
        i5 = _readMore(inputStream, bArr, i3, i4, i7);
        if (i5 <= 0) {
            return i7;
        }
        if (this._outputTail > i6) {
            _flushBuffer();
        }
        i2 = bArr[0] << 16;
        if (1 < i5) {
            i2 |= (bArr[1] & 255) << 8;
            i5 = 2;
        } else {
            i5 = 1;
        }
        this._outputTail = base64Variant.encodeBase64Partial(i2, i5, this._outputBuffer, this._outputTail);
        return i7 - i5;
    }

    protected final void _writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i2 - 3;
        int i5 = this._outputEnd - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        while (i <= i4) {
            if (this._outputTail > i5) {
                _flushBuffer();
            }
            i3 = i + 1;
            int i6 = bArr[i] << 8;
            int i7 = i3 + 1;
            i = i7 + 1;
            this._outputTail = base64Variant.encodeBase64Chunk((((bArr[i3] & 255) | i6) << 8) | (bArr[i7] & 255), this._outputBuffer, this._outputTail);
            maxLineLength--;
            if (maxLineLength <= 0) {
                byte[] bArr2 = this._outputBuffer;
                i3 = this._outputTail;
                this._outputTail = i3 + 1;
                bArr2[i3] = (byte) 92;
                bArr2 = this._outputBuffer;
                i3 = this._outputTail;
                this._outputTail = i3 + 1;
                bArr2[i3] = (byte) 110;
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
        }
        i4 = i2 - i;
        if (i4 > 0) {
            if (this._outputTail > i5) {
                _flushBuffer();
            }
            i5 = i + 1;
            maxLineLength = bArr[i] << 16;
            if (i4 == 2) {
                i3 = i5 + 1;
                maxLineLength |= (bArr[i5] & 255) << 8;
            }
            this._outputTail = base64Variant.encodeBase64Partial(maxLineLength, i4, this._outputBuffer, this._outputTail);
        }
    }

    protected final void _writePPFieldName(SerializableString serializableString) {
        Object obj = 1;
        int writeFieldName = this._writeContext.writeFieldName(serializableString.getValue());
        if (writeFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (writeFieldName == 1) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (this._cfgUnqNames) {
            obj = null;
        }
        if (obj != null) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) 34;
        }
        _writeBytes(serializableString.asQuotedUTF8());
        if (obj != null) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            writeFieldName = this._outputTail;
            this._outputTail = writeFieldName + 1;
            bArr2[writeFieldName] = (byte) 34;
        }
    }

    protected final void _writePPFieldName(String str) {
        int writeFieldName = this._writeContext.writeFieldName(str);
        if (writeFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (writeFieldName == 1) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (this._cfgUnqNames) {
            _writeStringSegments(str, false);
            return;
        }
        writeFieldName = str.length();
        if (writeFieldName > this._charBufferLength) {
            _writeStringSegments(str, true);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
        str.getChars(0, writeFieldName, this._charBuffer, 0);
        if (writeFieldName <= this._outputMaxContiguous) {
            if (this._outputTail + writeFieldName > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(this._charBuffer, 0, writeFieldName);
        } else {
            _writeStringSegments(this._charBuffer, 0, writeFieldName);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = (byte) 34;
    }

    public void close() {
        super.close();
        if (this._outputBuffer != null && isEnabled(Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext outputContext = getOutputContext();
                if (!outputContext.inArray()) {
                    if (!outputContext.inObject()) {
                        break;
                    }
                    writeEndObject();
                } else {
                    writeEndArray();
                }
            }
        }
        _flushBuffer();
        this._outputTail = 0;
        if (this._outputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(Feature.AUTO_CLOSE_TARGET)) {
                this._outputStream.close();
            } else if (isEnabled(Feature.FLUSH_PASSED_TO_STREAM)) {
                this._outputStream.flush();
            }
        }
        _releaseBuffers();
    }

    public void flush() {
        _flushBuffer();
        if (this._outputStream != null && isEnabled(Feature.FLUSH_PASSED_TO_STREAM)) {
            this._outputStream.flush();
        }
    }

    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) {
        _verifyValueWrite("write a binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = (byte) 34;
        byte[] allocBase64Buffer = this._ioContext.allocBase64Buffer();
        if (i < 0) {
            try {
                i = _writeBinary(base64Variant, inputStream, allocBase64Buffer);
            } catch (Throwable th) {
                this._ioContext.releaseBase64Buffer(allocBase64Buffer);
            }
        } else {
            int _writeBinary = _writeBinary(base64Variant, inputStream, allocBase64Buffer, i);
            if (_writeBinary > 0) {
                _reportError("Too few bytes available: missing " + _writeBinary + " bytes (out of " + i + ")");
            }
        }
        this._ioContext.releaseBase64Buffer(allocBase64Buffer);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = (byte) 34;
        return i;
    }

    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        _verifyValueWrite("write a binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr2[i3] = (byte) 34;
        _writeBinary(base64Variant, bArr, i, i + i2);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr2 = this._outputBuffer;
        i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr2[i3] = (byte) 34;
    }

    public void writeBoolean(boolean z) {
        _verifyValueWrite("write a boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        Object obj = z ? TRUE_BYTES : FALSE_BYTES;
        int length = obj.length;
        System.arraycopy(obj, 0, this._outputBuffer, this._outputTail, length);
        this._outputTail += length;
    }

    public final void writeEndArray() {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) 93;
        }
        this._writeContext = this._writeContext.clearAndGetParent();
    }

    public final void writeEndObject() {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) 125;
        }
        this._writeContext = this._writeContext.clearAndGetParent();
    }

    public void writeFieldName(SerializableString serializableString) {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(serializableString);
            return;
        }
        byte[] bArr;
        int i;
        int writeFieldName = this._writeContext.writeFieldName(serializableString.getValue());
        if (writeFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (writeFieldName == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            bArr = this._outputBuffer;
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) 44;
        }
        if (this._cfgUnqNames) {
            _writeUnq(serializableString);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
        writeFieldName = serializableString.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (writeFieldName < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail = writeFieldName + this._outputTail;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
    }

    public void writeFieldName(String str) {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(str);
            return;
        }
        byte[] bArr;
        int i;
        int writeFieldName = this._writeContext.writeFieldName(str);
        if (writeFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (writeFieldName == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            bArr = this._outputBuffer;
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) 44;
        }
        if (this._cfgUnqNames) {
            _writeStringSegments(str, false);
            return;
        }
        writeFieldName = str.length();
        if (writeFieldName > this._charBufferLength) {
            _writeStringSegments(str, true);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = (byte) 34;
        if (writeFieldName <= this._outputMaxContiguous) {
            if (this._outputTail + writeFieldName > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(str, 0, writeFieldName);
        } else {
            _writeStringSegments(str, 0, writeFieldName);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
    }

    public void writeNull() {
        _verifyValueWrite("write a null");
        _writeNull();
    }

    public void writeNumber(double d) {
        if (this._cfgNumbersAsStrings || ((Double.isNaN(d) || Double.isInfinite(d)) && Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this._features))) {
            writeString(String.valueOf(d));
            return;
        }
        _verifyValueWrite("write a number");
        writeRaw(String.valueOf(d));
    }

    public void writeNumber(float f) {
        if (this._cfgNumbersAsStrings || ((Float.isNaN(f) || Float.isInfinite(f)) && Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(this._features))) {
            writeString(String.valueOf(f));
            return;
        }
        _verifyValueWrite("write a number");
        writeRaw(String.valueOf(f));
    }

    public void writeNumber(int i) {
        _verifyValueWrite("write a number");
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
        } else {
            this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        }
    }

    public void writeNumber(long j) {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedLong(j);
            return;
        }
        if (this._outputTail + 21 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputLong(j, this._outputBuffer, this._outputTail);
    }

    public void writeNumber(String str) {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(str);
        } else {
            writeRaw(str);
        }
    }

    public void writeNumber(BigDecimal bigDecimal) {
        _verifyValueWrite("write a number");
        if (bigDecimal == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(Feature.WRITE_BIGDECIMAL_AS_PLAIN.enabledIn(this._features) ? bigDecimal.toPlainString() : bigDecimal.toString());
        } else if (Feature.WRITE_BIGDECIMAL_AS_PLAIN.enabledIn(this._features)) {
            writeRaw(bigDecimal.toPlainString());
        } else {
            writeRaw(bigDecimal.toString());
        }
    }

    public void writeNumber(BigInteger bigInteger) {
        _verifyValueWrite("write a number");
        if (bigInteger == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(bigInteger.toString());
        } else {
            writeRaw(bigInteger.toString());
        }
    }

    public void writeNumber(short s) {
        _verifyValueWrite("write a number");
        if (this._outputTail + 6 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedShort(s);
        } else {
            this._outputTail = NumberOutput.outputInt((int) s, this._outputBuffer, this._outputTail);
        }
    }

    public void writeRaw(char c) {
        if (this._outputTail + 3 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i;
        if (c <= 127) {
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) c;
        } else if (c < 2048) {
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) ((c >> 6) | 192);
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = (byte) ((c & 63) | 128);
        } else {
            _outputRawMultiByteChar(c, null, 0, 0);
        }
    }

    public void writeRaw(SerializableString serializableString) {
        byte[] asUnquotedUTF8 = serializableString.asUnquotedUTF8();
        if (asUnquotedUTF8.length > 0) {
            _writeBytes(asUnquotedUTF8);
        }
    }

    public void writeRaw(String str) {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this._charBuffer;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            str.getChars(i, i + length2, cArr, 0);
            writeRaw(cArr, 0, length2);
            i += length2;
            length -= length2;
        }
    }

    /* JADX WARNING: Missing block: B:10:0x0020, code:
            r1 = r0 + 1;
            r0 = r7[r0];
     */
    /* JADX WARNING: Missing block: B:11:0x0026, code:
            if (r0 >= 2048) goto L_0x0058;
     */
    /* JADX WARNING: Missing block: B:12:0x0028, code:
            r3 = r6._outputBuffer;
            r4 = r6._outputTail;
            r6._outputTail = r4 + 1;
            r3[r4] = (byte) ((r0 >> 6) | 192);
            r3 = r6._outputBuffer;
            r4 = r6._outputTail;
            r6._outputTail = r4 + 1;
            r3[r4] = (byte) ((r0 & 63) | 128);
            r0 = r1;
     */
    /* JADX WARNING: Missing block: B:15:0x0058, code:
            r0 = _outputRawMultiByteChar(r0, r7, r1, r2);
     */
    public final void writeRaw(char[] r7, int r8, int r9) {
        /*
        r6 = this;
        r0 = r9 + r9;
        r0 = r0 + r9;
        r1 = r6._outputTail;
        r1 = r1 + r0;
        r2 = r6._outputEnd;
        if (r1 <= r2) goto L_0x0015;
    L_0x000a:
        r1 = r6._outputEnd;
        if (r1 >= r0) goto L_0x0012;
    L_0x000e:
        r6._writeSegmentedRaw(r7, r8, r9);
    L_0x0011:
        return;
    L_0x0012:
        r6._flushBuffer();
    L_0x0015:
        r2 = r9 + r8;
        r0 = r8;
    L_0x0018:
        if (r0 >= r2) goto L_0x0011;
    L_0x001a:
        r1 = r7[r0];
        r3 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r1 <= r3) goto L_0x0048;
    L_0x0020:
        r1 = r0 + 1;
        r0 = r7[r0];
        r3 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        if (r0 >= r3) goto L_0x0058;
    L_0x0028:
        r3 = r6._outputBuffer;
        r4 = r6._outputTail;
        r5 = r4 + 1;
        r6._outputTail = r5;
        r5 = r0 >> 6;
        r5 = r5 | 192;
        r5 = (byte) r5;
        r3[r4] = r5;
        r3 = r6._outputBuffer;
        r4 = r6._outputTail;
        r5 = r4 + 1;
        r6._outputTail = r5;
        r0 = r0 & 63;
        r0 = r0 | 128;
        r0 = (byte) r0;
        r3[r4] = r0;
        r0 = r1;
        goto L_0x0018;
    L_0x0048:
        r3 = r6._outputBuffer;
        r4 = r6._outputTail;
        r5 = r4 + 1;
        r6._outputTail = r5;
        r1 = (byte) r1;
        r3[r4] = r1;
        r0 = r0 + 1;
        if (r0 < r2) goto L_0x001a;
    L_0x0057:
        goto L_0x0011;
    L_0x0058:
        r0 = r6._outputRawMultiByteChar(r0, r7, r1, r2);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8JsonGenerator.writeRaw(char[], int, int):void");
    }

    public void writeRawValue(SerializableString serializableString) {
        _verifyValueWrite("write a raw (unencoded) value");
        byte[] asUnquotedUTF8 = serializableString.asUnquotedUTF8();
        if (asUnquotedUTF8.length > 0) {
            _writeBytes(asUnquotedUTF8);
        }
    }

    public final void writeStartArray() {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 91;
    }

    public final void writeStartObject() {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 123;
    }

    public final void writeString(SerializableString serializableString) {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
        int appendQuotedUTF8 = serializableString.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (appendQuotedUTF8 < 0) {
            _writeBytes(serializableString.asQuotedUTF8());
        } else {
            this._outputTail = appendQuotedUTF8 + this._outputTail;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
    }

    public void writeString(String str) {
        _verifyValueWrite("write a string");
        if (str == null) {
            _writeNull();
            return;
        }
        int length = str.length();
        if (length > this._outputMaxContiguous) {
            _writeStringSegments(str, true);
            return;
        }
        if (this._outputTail + length >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = (byte) 34;
        _writeStringSegment(str, 0, length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = (byte) 34;
    }

    public void writeString(char[] cArr, int i, int i2) {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr[i3] = (byte) 34;
        if (i2 <= this._outputMaxContiguous) {
            if (this._outputTail + i2 > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cArr, i, i2);
        } else {
            _writeStringSegments(cArr, i, i2);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr[i3] = (byte) 34;
    }
}
