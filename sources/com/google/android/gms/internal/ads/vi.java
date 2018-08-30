package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.interfaces.ECPublicKey;

public final class vi implements zzauf {
    private static final byte[] a = new byte[0];
    private final vk b;
    private final String c;
    private final byte[] d;
    private final zzayw e;
    private final zzayn f;

    public vi(ECPublicKey eCPublicKey, byte[] bArr, String str, zzayw zzayw, zzayn zzayn) {
        vm.a(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.b = new vk(eCPublicKey);
        this.d = bArr;
        this.c = str;
        this.e = zzayw;
        this.f = zzayn;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        vl a = this.b.a(this.c, this.d, bArr2, this.f.zzwm(), this.e);
        byte[] zzc = this.f.zzi(a.b()).zzc(bArr, a);
        byte[] a2 = a.a();
        return ByteBuffer.allocate(a2.length + zzc.length).put(a2).put(zzc).array();
    }
}
