package com.google.android.gms.internal.ads;

public final class vq {
    public static int a(int i) {
        if ((i >= 0 && i <= 2) || (i >= 1000 && i <= 1000)) {
            return i;
        }
        throw new IllegalArgumentException(i + " is not a valid enum EnumBoolean");
    }

    public static int b(int i) {
        if (i >= 0 && i <= 2) {
            return i;
        }
        throw new IllegalArgumentException(i + " is not a valid enum ProtoName");
    }

    public static int c(int i) {
        if (i >= 0 && i <= 3) {
            return i;
        }
        throw new IllegalArgumentException(i + " is not a valid enum EncryptionMethod");
    }
}
