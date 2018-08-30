package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class vk {
    private ECPublicKey a;

    public vk(ECPublicKey eCPublicKey) {
        this.a = eCPublicKey;
    }

    public final vl a(String str, byte[] bArr, byte[] bArr2, int i, zzayw zzayw) {
        KeyPair a = vm.a(this.a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) a.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) a.getPrivate();
        ECPublicKey eCPublicKey2 = this.a;
        ECParameterSpec params = eCPublicKey2.getParams();
        ECParameterSpec params2 = eCPrivateKey.getParams();
        if (params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor()) {
            Object toByteArray;
            byte[] bArr3;
            byte[] a2 = vm.a(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            vm.a(w, curve);
            int a3 = vm.a(curve);
            Object obj;
            switch (vn.a[zzayw.ordinal()]) {
                case 1:
                    obj = new byte[((a3 * 2) + 1)];
                    Object toByteArray2 = w.getAffineX().toByteArray();
                    toByteArray = w.getAffineY().toByteArray();
                    System.arraycopy(toByteArray, 0, obj, ((a3 * 2) + 1) - toByteArray.length, toByteArray.length);
                    System.arraycopy(toByteArray2, 0, obj, (a3 + 1) - toByteArray2.length, toByteArray2.length);
                    obj[0] = (byte) 4;
                    bArr3 = obj;
                    break;
                case 2:
                    bArr3 = new byte[(a3 + 1)];
                    obj = w.getAffineX().toByteArray();
                    System.arraycopy(obj, 0, bArr3, (a3 + 1) - obj.length, obj.length);
                    bArr3[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                    break;
                default:
                    String valueOf = String.valueOf(zzayw);
                    throw new GeneralSecurityException(new StringBuilder(String.valueOf(valueOf).length() + 15).append("invalid format:").append(valueOf).toString());
            }
            byte[] a4 = ve.a(bArr3, a2);
            Mac mac = (Mac) vp.b.a(str);
            if (i > mac.getMacLength() * 255) {
                throw new GeneralSecurityException("size too large");
            }
            if (bArr == null || bArr.length == 0) {
                mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
            } else {
                mac.init(new SecretKeySpec(bArr, str));
            }
            toByteArray = new byte[i];
            mac.init(new SecretKeySpec(mac.doFinal(a4), str));
            a4 = new byte[0];
            int i2 = 1;
            int i3 = 0;
            while (true) {
                mac.update(a4);
                mac.update(bArr2);
                mac.update((byte) i2);
                a4 = mac.doFinal();
                if (a4.length + i3 < i) {
                    System.arraycopy(a4, 0, toByteArray, i3, a4.length);
                    i3 += a4.length;
                    i2++;
                } else {
                    System.arraycopy(a4, 0, toByteArray, i3, i - i3);
                    return new vl(bArr3, toByteArray);
                }
            }
        }
        throw new GeneralSecurityException("invalid public key spec");
    }
}
