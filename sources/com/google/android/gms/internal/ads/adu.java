package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

final class adu {
    static zzauf a;

    static boolean a(adn adn) {
        if (a != null) {
            return true;
        }
        String str = (String) akc.f().a(amn.bK);
        if (str == null || str.length() == 0) {
            if (adn == null) {
                str = null;
            } else {
                Method a = adn.a("4o7tecxtkw7XaNt5hPj+0H1LvOi0SgxCIJTY9VcbazM/HSl/sFlxBFwnc8glnvoB", "RgSY6YxU2k1vLXOV3vapBnQwJDzYDlmX50wbm2tDcnw=");
                str = a == null ? null : (String) a.invoke(null, new Object[0]);
            }
            if (str == null) {
                return false;
            }
        }
        try {
            try {
                px a2 = pz.a(acb.a(str, true));
                for (tx txVar : qr.a.a()) {
                    if (txVar.b().isEmpty()) {
                        throw new GeneralSecurityException("Missing type_url.");
                    } else if (txVar.a().isEmpty()) {
                        throw new GeneralSecurityException("Missing primitive_name.");
                    } else if (txVar.e().isEmpty()) {
                        throw new GeneralSecurityException("Missing catalogue_name.");
                    } else {
                        qc.a(txVar.b(), qc.a(txVar.e()).zzb(txVar.b(), txVar.a(), txVar.c()), txVar.d());
                    }
                }
                a = qu.a(a2);
                return a != null;
            } catch (GeneralSecurityException e) {
                return false;
            }
        } catch (IllegalArgumentException e2) {
            return false;
        }
    }
}
