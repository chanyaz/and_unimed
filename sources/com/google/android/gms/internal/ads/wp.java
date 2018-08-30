package com.google.android.gms.internal.ads;

public abstract class wp<MessageType extends wp<MessageType, BuilderType>, BuilderType extends wq<MessageType, BuilderType>> implements zzbcu {
    private static boolean zzdpg = false;
    protected int zzdpf = 0;

    void a(int i) {
        throw new UnsupportedOperationException();
    }

    int h() {
        throw new UnsupportedOperationException();
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzacw()];
            zzbav a = zzbav.a(bArr);
            zzb(a);
            a.b();
            return bArr;
        } catch (Throwable e) {
            String str = "byte array";
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder((String.valueOf(name).length() + 62) + String.valueOf(str).length()).append("Serializing ").append(name).append(" to a ").append(str).append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    public final zzbah zzaav() {
        try {
            xc b = zzbah.b(zzacw());
            zzb(b.b());
            return b.a();
        } catch (Throwable e) {
            String str = "ByteString";
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder((String.valueOf(name).length() + 62) + String.valueOf(str).length()).append("Serializing ").append(name).append(" to a ").append(str).append(" threw an IOException (should never happen).").toString(), e);
        }
    }
}
