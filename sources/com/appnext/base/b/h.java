package com.appnext.base.b;

import android.text.TextUtils;
import android.util.Base64;
import com.appnext.base.b;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class h {
    private static final String TAG = "Generator";
    private static final String gk = "fqJfdzGDvfwbedsKSUGty3VZ9taXxMVw";
    private static final h jW = new h();

    private h() {
        init();
    }

    private String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append('0');
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString();
    }

    private byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        int i = 0;
        while (i < bArr3.length) {
            bArr3[i] = i < bArr.length ? bArr[i] : bArr2[i - bArr.length];
            i++;
        }
        return bArr3;
    }

    public static h cD() {
        return jW;
    }

    private void init() {
    }

    public String aA(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            CRC32 crc32 = new CRC32();
            crc32.update(str.getBytes());
            return Long.toHexString(crc32.getValue());
        } catch (Throwable th) {
            return null;
        }
    }

    public String aB(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec(gk.getBytes("utf-8"), "AES"), new IvParameterSpec(bArr));
            return Base64.encodeToString(a(bArr, instance.doFinal(str.getBytes("utf-8"))), 2);
        } catch (Throwable th) {
            b.a(th);
            return str2;
        }
    }

    public String aC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
            byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, decode.length);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, new SecretKeySpec(gk.getBytes("utf-8"), "AES"), new IvParameterSpec(copyOfRange));
            return new String(instance.doFinal(copyOfRange2), "utf-8");
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public String aD(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            return a(instance.digest());
        } catch (Throwable th) {
            return null;
        }
    }

    public Long az(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            CRC32 crc32 = new CRC32();
            crc32.update(str.getBytes());
            return Long.valueOf(crc32.getValue());
        } catch (Throwable th) {
            return null;
        }
    }

    public byte[] h(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec(Base64.decode(str2, 2), "AES"), new IvParameterSpec(bArr));
            return a(bArr, instance.doFinal(str.getBytes("UTF-8")));
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }
}
