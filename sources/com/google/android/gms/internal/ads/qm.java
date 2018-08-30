package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class qm implements zzatz {
    private static final byte[] a = new byte[0];
    private final tu b;
    private final zzatz c;

    public qm(tu tuVar, zzatz zzatz) {
        this.b = tuVar;
        this.c = zzatz;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] toByteArray = qc.b(this.b).toByteArray();
        byte[] zzc = this.c.zzc(toByteArray, a);
        toByteArray = ((zzatz) qc.a(this.b.a(), toByteArray)).zzc(bArr, bArr2);
        return ByteBuffer.allocate((zzc.length + 4) + toByteArray.length).putInt(zzc.length).put(zzc).put(toByteArray).array();
    }
}
