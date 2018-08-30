package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class l extends c {
    private long a;
    private long b;
    private int c = 0;

    l(int i) {
        super(16);
        this.a = (long) i;
        this.b = (long) i;
    }

    private static long a(long j) {
        long j2 = ((j >>> 33) ^ j) * -49064778989728563L;
        j2 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j2 ^ (j2 >>> 33);
    }

    private void a(long j, long j2) {
        this.a ^= b(j);
        this.a = Long.rotateLeft(this.a, 27);
        this.a += this.b;
        this.a = (this.a * 5) + 1390208809;
        this.b ^= c(j2);
        this.b = Long.rotateLeft(this.b, 31);
        this.b += this.a;
        this.b = (this.b * 5) + 944331445;
    }

    private static long b(long j) {
        return Long.rotateLeft(-8663945395140668459L * j, 31) * 5545529020109919103L;
    }

    private static long c(long j) {
        return Long.rotateLeft(5545529020109919103L * j, 33) * -8663945395140668459L;
    }

    public g a() {
        this.a ^= (long) this.c;
        this.b ^= (long) this.c;
        this.a += this.b;
        this.b += this.a;
        this.a = a(this.a);
        this.b = a(this.b);
        this.a += this.b;
        this.b += this.a;
        return g.a(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.a).putLong(this.b).array());
    }

    protected void a(ByteBuffer byteBuffer) {
        a(byteBuffer.getLong(), byteBuffer.getLong());
        this.c += 16;
    }

    /* JADX WARNING: Missing block: B:5:0x0035, code:
            r0 = r0 ^ (((long) com.google.common.primitives.d.a(r13.get(13))) << 40);
     */
    /* JADX WARNING: Missing block: B:6:0x0042, code:
            r0 = r0 ^ (((long) com.google.common.primitives.d.a(r13.get(12))) << 32);
     */
    /* JADX WARNING: Missing block: B:7:0x004f, code:
            r0 = r0 ^ (((long) com.google.common.primitives.d.a(r13.get(11))) << 24);
     */
    /* JADX WARNING: Missing block: B:8:0x005c, code:
            r0 = r0 ^ (((long) com.google.common.primitives.d.a(r13.get(10))) << 16);
     */
    /* JADX WARNING: Missing block: B:9:0x0069, code:
            r0 = r0 ^ (((long) com.google.common.primitives.d.a(r13.get(9))) << 8);
     */
    /* JADX WARNING: Missing block: B:10:0x0076, code:
            r0 = r0 ^ ((long) com.google.common.primitives.d.a(r13.get(8)));
     */
    /* JADX WARNING: Missing block: B:11:0x0080, code:
            r2 = 0 ^ r13.getLong();
     */
    /* JADX WARNING: Missing block: B:12:0x0085, code:
            r12.a = b(r2) ^ r12.a;
            r12.b = c(r0) ^ r12.b;
     */
    /* JADX WARNING: Missing block: B:13:0x0097, code:
            return;
     */
    /* JADX WARNING: Missing block: B:15:0x00a6, code:
            r2 = r2 ^ (((long) com.google.common.primitives.d.a(r13.get(5))) << 40);
     */
    /* JADX WARNING: Missing block: B:16:0x00b2, code:
            r2 = r2 ^ (((long) com.google.common.primitives.d.a(r13.get(4))) << 32);
     */
    /* JADX WARNING: Missing block: B:17:0x00be, code:
            r2 = r2 ^ (((long) com.google.common.primitives.d.a(r13.get(3))) << 24);
     */
    /* JADX WARNING: Missing block: B:18:0x00ca, code:
            r2 = r2 ^ (((long) com.google.common.primitives.d.a(r13.get(2))) << 16);
     */
    /* JADX WARNING: Missing block: B:19:0x00d6, code:
            r2 = r2 ^ (((long) com.google.common.primitives.d.a(r13.get(1))) << 8);
     */
    /* JADX WARNING: Missing block: B:20:0x00e2, code:
            r2 = r2 ^ ((long) com.google.common.primitives.d.a(r13.get(0)));
     */
    protected void b(java.nio.ByteBuffer r13) {
        /*
        r12 = this;
        r11 = 40;
        r10 = 32;
        r9 = 24;
        r8 = 16;
        r7 = 8;
        r2 = 0;
        r0 = 0;
        r4 = r12.c;
        r5 = r13.remaining();
        r4 = r4 + r5;
        r12.c = r4;
        r4 = r13.remaining();
        switch(r4) {
            case 1: goto L_0x00e2;
            case 2: goto L_0x00d6;
            case 3: goto L_0x00ca;
            case 4: goto L_0x00be;
            case 5: goto L_0x00b2;
            case 6: goto L_0x00a6;
            case 7: goto L_0x0098;
            case 8: goto L_0x0080;
            case 9: goto L_0x0076;
            case 10: goto L_0x0069;
            case 11: goto L_0x005c;
            case 12: goto L_0x004f;
            case 13: goto L_0x0042;
            case 14: goto L_0x0035;
            case 15: goto L_0x0026;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = new java.lang.AssertionError;
        r1 = "Should never get here.";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r4 = 14;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r6 = 48;
        r4 = r4 << r6;
        r0 = r0 ^ r4;
    L_0x0035:
        r4 = 13;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r11;
        r0 = r0 ^ r4;
    L_0x0042:
        r4 = 12;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r10;
        r0 = r0 ^ r4;
    L_0x004f:
        r4 = 11;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r9;
        r0 = r0 ^ r4;
    L_0x005c:
        r4 = 10;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r8;
        r0 = r0 ^ r4;
    L_0x0069:
        r4 = 9;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r7;
        r0 = r0 ^ r4;
    L_0x0076:
        r4 = r13.get(r7);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r0 = r0 ^ r4;
    L_0x0080:
        r4 = r13.getLong();
        r2 = r2 ^ r4;
    L_0x0085:
        r4 = r12.a;
        r2 = b(r2);
        r2 = r2 ^ r4;
        r12.a = r2;
        r2 = r12.b;
        r0 = c(r0);
        r0 = r0 ^ r2;
        r12.b = r0;
        return;
    L_0x0098:
        r4 = 6;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r6 = 48;
        r4 = r4 << r6;
        r2 = r2 ^ r4;
    L_0x00a6:
        r4 = 5;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r11;
        r2 = r2 ^ r4;
    L_0x00b2:
        r4 = 4;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r10;
        r2 = r2 ^ r4;
    L_0x00be:
        r4 = 3;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r9;
        r2 = r2 ^ r4;
    L_0x00ca:
        r4 = 2;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r8;
        r2 = r2 ^ r4;
    L_0x00d6:
        r4 = 1;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r4 = r4 << r7;
        r2 = r2 ^ r4;
    L_0x00e2:
        r4 = 0;
        r4 = r13.get(r4);
        r4 = com.google.common.primitives.d.a(r4);
        r4 = (long) r4;
        r2 = r2 ^ r4;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.l.b(java.nio.ByteBuffer):void");
    }
}
