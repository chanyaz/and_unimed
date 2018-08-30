package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

@zzadh
public final class ahe extends agz {
    private MessageDigest b;

    public final byte[] a(String str) {
        byte[] array;
        int i = 0;
        String[] split = str.split(" ");
        int a;
        if (split.length == 1) {
            a = ahd.a(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(a);
            array = allocate.array();
        } else if (split.length < 5) {
            byte[] bArr = new byte[(split.length << 1)];
            for (a = 0; a < split.length; a++) {
                int a2 = ahd.a(split[a]);
                a2 = (a2 >> 16) ^ (65535 & a2);
                byte[] bArr2 = new byte[]{(byte) a2, (byte) (a2 >> 8)};
                bArr[a << 1] = bArr2[0];
                bArr[(a << 1) + 1] = bArr2[1];
            }
            array = bArr;
        } else {
            array = new byte[split.length];
            while (i < split.length) {
                int a3 = ahd.a(split[i]);
                array[i] = (byte) ((a3 >> 24) ^ (((a3 & 255) ^ ((a3 >> 8) & 255)) ^ ((a3 >> 16) & 255)));
                i++;
            }
        }
        this.b = a();
        synchronized (this.a) {
            if (this.b == null) {
                array = new byte[0];
            } else {
                this.b.reset();
                this.b.update(array);
                Object digest = this.b.digest();
                array = new byte[(digest.length > 4 ? 4 : digest.length)];
                System.arraycopy(digest, 0, array, 0, array.length);
            }
        }
        return array;
    }
}
