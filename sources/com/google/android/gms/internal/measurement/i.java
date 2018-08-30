package com.google.android.gms.internal.measurement;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class i {
    private final ByteBuffer a;

    private i(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private i(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int a(int i) {
        return i >= 0 ? d(i) : 10;
    }

    public static int a(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0091 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f  */
    private static int a(java.lang.CharSequence r8) {
        /*
        r7 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r1 = 0;
        r3 = r8.length();
        r0 = r1;
    L_0x0008:
        if (r0 >= r3) goto L_0x0094;
    L_0x000a:
        r2 = r8.charAt(r0);
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r2 >= r4) goto L_0x0094;
    L_0x0012:
        r0 = r0 + 1;
        goto L_0x0008;
    L_0x0015:
        if (r0 >= r3) goto L_0x0092;
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
        if (r0 >= r4) goto L_0x006b;
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
        if (r5 >= r6) goto L_0x0068;
    L_0x004d:
        r1 = new java.lang.IllegalArgumentException;
        r2 = 39;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Unpaired surrogate at index ";
        r2 = r3.append(r2);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0068:
        r0 = r0 + 1;
        goto L_0x0036;
    L_0x006b:
        r0 = r2 + r1;
    L_0x006d:
        if (r0 >= r3) goto L_0x0091;
    L_0x006f:
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
    L_0x0091:
        return r0;
    L_0x0092:
        r0 = r2;
        goto L_0x006d;
    L_0x0094:
        r2 = r3;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i.a(java.lang.CharSequence):int");
    }

    public static int a(String str) {
        int a = a((CharSequence) str);
        return a + d(a);
    }

    public static i a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static i a(byte[] bArr, int i, int i2) {
        return new i(bArr, 0, i2);
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i = 0;
        int arrayOffset;
        int remaining;
        char charAt;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byte[] array = byteBuffer.array();
                arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                remaining = byteBuffer.remaining();
                int length = charSequence.length();
                int i2 = arrayOffset + remaining;
                while (i < length && i + arrayOffset < i2) {
                    charAt = charSequence.charAt(i);
                    if (charAt >= 128) {
                        break;
                    }
                    array[arrayOffset + i] = (byte) charAt;
                    i++;
                }
                if (i == length) {
                    i = arrayOffset + length;
                } else {
                    remaining = arrayOffset + i;
                    while (i < length) {
                        char charAt2 = charSequence.charAt(i);
                        int i3;
                        if (charAt2 < 128 && remaining < i2) {
                            arrayOffset = remaining + 1;
                            array[remaining] = (byte) charAt2;
                        } else if (charAt2 < 2048 && remaining <= i2 - 2) {
                            i3 = remaining + 1;
                            array[remaining] = (byte) ((charAt2 >>> 6) | 960);
                            arrayOffset = i3 + 1;
                            array[i3] = (byte) ((charAt2 & 63) | 128);
                        } else if ((charAt2 < 55296 || 57343 < charAt2) && remaining <= i2 - 3) {
                            arrayOffset = remaining + 1;
                            array[remaining] = (byte) ((charAt2 >>> 12) | 480);
                            remaining = arrayOffset + 1;
                            array[arrayOffset] = (byte) (((charAt2 >>> 6) & 63) | 128);
                            arrayOffset = remaining + 1;
                            array[remaining] = (byte) ((charAt2 & 63) | 128);
                        } else if (remaining <= i2 - 4) {
                            if (i + 1 != charSequence.length()) {
                                i++;
                                char charAt3 = charSequence.charAt(i);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int toCodePoint = Character.toCodePoint(charAt2, charAt3);
                                    arrayOffset = remaining + 1;
                                    array[remaining] = (byte) ((toCodePoint >>> 18) | 240);
                                    remaining = arrayOffset + 1;
                                    array[arrayOffset] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                                    i3 = remaining + 1;
                                    array[remaining] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                                    arrayOffset = i3 + 1;
                                    array[i3] = (byte) ((toCodePoint & 63) | 128);
                                }
                            }
                            throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
                        } else {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + remaining);
                        }
                        i++;
                        remaining = arrayOffset;
                    }
                    i = remaining;
                }
                byteBuffer.position(i - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            arrayOffset = charSequence.length();
            while (i < arrayOffset) {
                charAt = charSequence.charAt(i);
                if (charAt < 128) {
                    byteBuffer.put((byte) charAt);
                } else if (charAt < 2048) {
                    byteBuffer.put((byte) ((charAt >>> 6) | 960));
                    byteBuffer.put((byte) ((charAt & 63) | 128));
                } else if (charAt < 55296 || 57343 < charAt) {
                    byteBuffer.put((byte) ((charAt >>> 12) | 480));
                    byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((charAt & 63) | 128));
                } else {
                    if (i + 1 != charSequence.length()) {
                        i++;
                        char charAt4 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(charAt, charAt4)) {
                            remaining = Character.toCodePoint(charAt, charAt4);
                            byteBuffer.put((byte) ((remaining >>> 18) | 240));
                            byteBuffer.put((byte) (((remaining >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((remaining >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((remaining & 63) | 128));
                        }
                    }
                    throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
                }
                i++;
            }
        }
    }

    public static int b(int i) {
        return d(i << 3);
    }

    public static int b(int i, int i2) {
        return b(i) + a(i2);
    }

    public static int b(int i, p pVar) {
        int b = b(i);
        int d = pVar.d();
        return b + (d + d(d));
    }

    public static int b(int i, String str) {
        return b(i) + a(str);
    }

    private final void b(long j) {
        while ((-128 & j) != 0) {
            e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        e((int) j);
    }

    public static int c(int i, long j) {
        return b(i) + a(j);
    }

    public static int d(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    private final void e(int i) {
        byte b = (byte) i;
        if (this.a.hasRemaining()) {
            this.a.put(b);
            return;
        }
        throw new zzabx(this.a.position(), this.a.limit());
    }

    public final void a() {
        if (this.a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.a.remaining())}));
        }
    }

    public final void a(int i, double d) {
        c(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.a.remaining() < 8) {
            throw new zzabx(this.a.position(), this.a.limit());
        }
        this.a.putLong(doubleToLongBits);
    }

    public final void a(int i, float f) {
        c(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.a.remaining() < 4) {
            throw new zzabx(this.a.position(), this.a.limit());
        }
        this.a.putInt(floatToIntBits);
    }

    public final void a(int i, int i2) {
        c(i, 0);
        if (i2 >= 0) {
            c(i2);
        } else {
            b((long) i2);
        }
    }

    public final void a(int i, long j) {
        c(i, 0);
        b(j);
    }

    public final void a(int i, p pVar) {
        c(i, 2);
        a(pVar);
    }

    public final void a(int i, String str) {
        c(i, 2);
        try {
            int d = d(str.length());
            if (d == d(str.length() * 3)) {
                int position = this.a.position();
                if (this.a.remaining() < d) {
                    throw new zzabx(d + position, this.a.limit());
                }
                this.a.position(position + d);
                a((CharSequence) str, this.a);
                int position2 = this.a.position();
                this.a.position(position);
                c((position2 - position) - d);
                this.a.position(position2);
                return;
            }
            c(a((CharSequence) str));
            a((CharSequence) str, this.a);
        } catch (Throwable e) {
            zzabx zzabx = new zzabx(this.a.position(), this.a.limit());
            zzabx.initCause(e);
            throw zzabx;
        }
    }

    public final void a(int i, boolean z) {
        int i2 = 0;
        c(i, 0);
        if (z) {
            i2 = 1;
        }
        byte b = (byte) i2;
        if (this.a.hasRemaining()) {
            this.a.put(b);
            return;
        }
        throw new zzabx(this.a.position(), this.a.limit());
    }

    public final void a(p pVar) {
        c(pVar.c());
        pVar.a(this);
    }

    public final void b(int i, long j) {
        c(i, 0);
        b(j);
    }

    public final void b(byte[] bArr) {
        int length = bArr.length;
        if (this.a.remaining() >= length) {
            this.a.put(bArr, 0, length);
            return;
        }
        throw new zzabx(this.a.position(), this.a.limit());
    }

    public final void c(int i) {
        while ((i & -128) != 0) {
            e((i & 127) | 128);
            i >>>= 7;
        }
        e(i);
    }

    public final void c(int i, int i2) {
        c((i << 3) | i2);
    }
}
