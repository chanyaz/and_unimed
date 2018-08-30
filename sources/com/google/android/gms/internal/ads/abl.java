package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class abl {
    final int a;
    final byte[] b;

    abl(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abl)) {
            return false;
        }
        abl abl = (abl) obj;
        return this.a == abl.a && Arrays.equals(this.b, abl.b);
    }

    public final int hashCode() {
        return ((this.a + 527) * 31) + Arrays.hashCode(this.b);
    }
}
