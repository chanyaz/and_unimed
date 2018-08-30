package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class vo implements zzatz {
    private final zzazi a;
    private final zzauk b;
    private final int c;

    public vo(zzazi zzazi, zzauk zzauk, int i) {
        this.a = zzazi;
        this.b = zzauk;
        this.c = i;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] zzk = this.a.zzk(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(8 * ((long) bArr2.length)).array(), 8);
        copyOf = this.b.zzg(ve.a(bArr2, zzk, copyOf));
        return ve.a(zzk, copyOf);
    }
}
