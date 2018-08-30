package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public abstract class agz {
    @Nullable
    private static MessageDigest b = null;
    protected Object a = new Object();

    @Nullable
    protected final MessageDigest a() {
        MessageDigest messageDigest;
        synchronized (this.a) {
            if (b != null) {
                messageDigest = b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        b = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = b;
            }
        }
        return messageDigest;
    }

    abstract byte[] a(String str);
}
