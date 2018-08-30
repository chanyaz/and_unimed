package com.google.android.exoplayer.extractor.a;

import com.google.android.exoplayer.util.i;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class j {
    private j() {
    }

    public static UUID a(byte[] bArr) {
        i iVar = new i(bArr);
        if (!a(iVar, null)) {
            return null;
        }
        iVar.b(12);
        return new UUID(iVar.k(), iVar.k());
    }

    private static boolean a(i iVar, UUID uuid) {
        if (iVar.c() < 32) {
            return false;
        }
        iVar.b(0);
        if (iVar.j() != iVar.b() + 4 || iVar.j() != a.I) {
            return false;
        }
        iVar.b(12);
        if (uuid == null) {
            iVar.c(16);
        } else if (!(iVar.k() == uuid.getMostSignificantBits() && iVar.k() == uuid.getLeastSignificantBits())) {
            return false;
        }
        return iVar.j() == iVar.b();
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        int length = bArr.length + 32;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(a.I);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        allocate.putInt(bArr.length);
        allocate.put(bArr);
        return allocate.array();
    }

    public static byte[] a(byte[] bArr, UUID uuid) {
        i iVar = new i(bArr);
        if (!a(iVar, uuid)) {
            return null;
        }
        iVar.b(28);
        int j = iVar.j();
        byte[] bArr2 = new byte[j];
        iVar.a(bArr2, 0, j);
        return bArr2;
    }
}
