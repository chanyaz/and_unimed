package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class acd {
    static CountDownLatch a = new CountDownLatch(1);
    private static boolean b = false;
    private static MessageDigest c = null;
    private static final Object d = new Object();
    private static final Object e = new Object();

    private static wr a(long j) {
        wr wrVar = new wr();
        wrVar.k = Long.valueOf(4096);
        return wrVar;
    }

    static String a(wr wrVar, String str) {
        byte[] a;
        byte[] a2 = abj.a((abj) wrVar);
        if (((Boolean) akc.f().a(amn.bL)).booleanValue()) {
            Vector a3 = a(a2, 255);
            if (a3 == null || a3.size() == 0) {
                a = a(abj.a(a(4096)), str, true);
            } else {
                abj abz = new abz();
                abz.a = new byte[a3.size()][];
                Iterator it = a3.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int i2 = i + 1;
                    abz.a[i] = a((byte[]) it.next(), str, false);
                    i = i2;
                }
                abz.b = a(a2);
                a = abj.a(abz);
            }
        } else if (adu.a == null) {
            throw new GeneralSecurityException();
        } else {
            a = adu.a.zzc(a2, str != null ? str.getBytes() : new byte[0]);
            abj abz2 = new abz();
            abz2.a = new byte[][]{a};
            abz2.c = Integer.valueOf(2);
            a = abj.a(abz2);
        }
        return acb.a(a, true);
    }

    private static Vector<byte[]> a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    static void a() {
        synchronized (e) {
            if (!b) {
                b = true;
                new Thread(new acf()).start();
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        byte[] digest;
        synchronized (d) {
            MessageDigest b = b();
            if (b == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            b.reset();
            b.update(bArr);
            digest = c.digest();
        }
        return digest;
    }

    private static byte[] a(byte[] bArr, String str, boolean z) {
        byte[] array;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = abj.a(a(4096));
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(a(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (zzbp zza : new acg().cN) {
            zza.zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new wo(str.getBytes("UTF-8")).a(bArr3);
        }
        return bArr3;
    }

    private static MessageDigest b() {
        a();
        boolean z = false;
        try {
            z = a.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return (z && c != null) ? c : null;
    }
}
