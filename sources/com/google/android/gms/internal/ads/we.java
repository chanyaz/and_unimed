package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;

abstract class we implements zzatz {
    private final byte[] a;
    private final wd b;
    private final wd c;

    we(byte[] bArr) {
        this.a = (byte[]) bArr.clone();
        this.b = a(bArr, 1);
        this.c = a(bArr, 0);
    }

    abstract wd a(byte[] bArr, int i);

    public byte[] zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        this.b.a();
        if (length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer allocate = ByteBuffer.allocate((bArr.length + this.b.a()) + 16);
        if (allocate.remaining() < (bArr.length + this.b.a()) + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        length = allocate.position();
        this.b.a(allocate, bArr);
        allocate.position(length);
        byte[] bArr3 = new byte[this.b.a()];
        allocate.get(bArr3);
        allocate.limit(allocate.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr4 = new byte[32];
        this.c.a(bArr3, 0).get(bArr4);
        length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
        int remaining = allocate.remaining();
        int i = remaining % 16 == 0 ? remaining : (remaining + 16) - (remaining % 16);
        ByteBuffer order = ByteBuffer.allocate((length + i) + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr2);
        order.position(length);
        order.put(allocate);
        order.position(length + i);
        order.putLong((long) bArr2.length);
        order.putLong((long) remaining);
        bArr3 = wa.a(bArr4, order.array());
        allocate.limit(allocate.limit() + 16);
        allocate.put(bArr3);
        return allocate.array();
    }
}
