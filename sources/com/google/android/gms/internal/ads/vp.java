package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class vp<T_WRAPPER extends zzayz<T_ENGINE>, T_ENGINE> {
    public static final vp<vr, Cipher> a = new vp(new vr());
    public static final vp<vv, Mac> b = new vp(new vv());
    public static final vp<vs, KeyAgreement> c = new vp(new vs());
    public static final vp<vu, KeyPairGenerator> d = new vp(new vu());
    public static final vp<vt, KeyFactory> e = new vp(new vt());
    private static final Logger f = Logger.getLogger(vp.class.getName());
    private static final List<Provider> g;
    private static final vp<vx, Signature> h = new vp(new vx());
    private static final vp<vw, MessageDigest> i = new vp(new vw());
    private T_WRAPPER j;
    private List<Provider> k = g;
    private boolean l = true;

    static {
        if (wf.a()) {
            String[] strArr = new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL"};
            List arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                Provider provider = Security.getProvider(strArr[i]);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{r4}));
                }
            }
            g = arrayList;
        } else {
            g = new ArrayList();
        }
    }

    private vp(T_WRAPPER t_wrapper) {
        this.j = t_wrapper;
    }

    private final boolean a(String str, Provider provider) {
        try {
            this.j.zzb(str, provider);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final T_ENGINE a(String str) {
        for (Provider provider : this.k) {
            if (a(str, provider)) {
                return this.j.zzb(str, provider);
            }
        }
        if (this.l) {
            return this.j.zzb(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }
}
