package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class adb {
    private static Cipher b = null;
    private static final Object c = new Object();
    private static final Object d = new Object();
    private final SecureRandom a = null;

    public adb(SecureRandom secureRandom) {
    }

    private static Cipher a() {
        Cipher cipher;
        synchronized (d) {
            if (b == null) {
                b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = b;
        }
        return cipher;
    }

    public final String a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 16) {
            throw new zzcl(this);
        }
        try {
            byte[] doFinal;
            byte[] iv;
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (c) {
                a().init(1, secretKeySpec, null);
                doFinal = a().doFinal(bArr2);
                iv = a().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            doFinal = new byte[length];
            allocate.get(doFinal);
            return acb.a(doFinal, false);
        } catch (Throwable e) {
            throw new zzcl(this, e);
        } catch (Throwable e2) {
            throw new zzcl(this, e2);
        } catch (Throwable e22) {
            throw new zzcl(this, e22);
        } catch (Throwable e222) {
            throw new zzcl(this, e222);
        } catch (Throwable e2222) {
            throw new zzcl(this, e2222);
        }
    }

    public final byte[] a(String str) {
        try {
            byte[] a = acb.a(str, false);
            if (a.length != 32) {
                throw new zzcl(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (Throwable e) {
            throw new zzcl(this, e);
        }
    }

    public final byte[] a(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new zzcl(this);
        }
        try {
            byte[] a = acb.a(str, false);
            if (a.length <= 16) {
                throw new zzcl(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (c) {
                a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                a = a().doFinal(a);
            }
            return a;
        } catch (Throwable e) {
            throw new zzcl(this, e);
        } catch (Throwable e2) {
            throw new zzcl(this, e2);
        } catch (Throwable e22) {
            throw new zzcl(this, e22);
        } catch (Throwable e222) {
            throw new zzcl(this, e222);
        } catch (Throwable e2222) {
            throw new zzcl(this, e2222);
        } catch (Throwable e22222) {
            throw new zzcl(this, e22222);
        } catch (Throwable e222222) {
            throw new zzcl(this, e222222);
        }
    }
}
