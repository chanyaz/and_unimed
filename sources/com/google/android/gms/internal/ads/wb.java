package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

public final class wb {
    private static final ThreadLocal<SecureRandom> a = new wc();

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) a.get()).nextBytes(bArr);
        return bArr;
    }

    private static SecureRandom b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
