package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public final class vz implements zzauk {
    private Mac a;
    private final int b;
    private final String c;
    private final Key d;

    public vz(String str, Key key, int i) {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1823053428:
                if (str.equals("HMACSHA1")) {
                    obj = null;
                    break;
                }
                break;
            case 392315118:
                if (str.equals("HMACSHA256")) {
                    obj = 1;
                    break;
                }
                break;
            case 392317873:
                if (str.equals("HMACSHA512")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (i > 20) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case 1:
                if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case 2:
                if (i > 64) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            default:
                String str2 = "unknown Hmac algorithm: ";
                String valueOf = String.valueOf(str);
                throw new NoSuchAlgorithmException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        this.c = str;
        this.b = i;
        this.d = key;
        this.a = (Mac) vp.b.a(str);
        this.a.init(key);
    }

    public final byte[] zzg(byte[] bArr) {
        Mac mac;
        try {
            mac = (Mac) this.a.clone();
        } catch (CloneNotSupportedException e) {
            mac = (Mac) vp.b.a(this.c);
            mac.init(this.d);
        }
        mac.update(bArr);
        Object obj = new byte[this.b];
        System.arraycopy(mac.doFinal(), 0, obj, 0, this.b);
        return obj;
    }
}
