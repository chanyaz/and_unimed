package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class acf implements Runnable {
    private acf() {
    }

    public final void run() {
        try {
            acd.c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        } finally {
            acd.a.countDown();
        }
    }
}
