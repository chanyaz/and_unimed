package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@zzadh
public final class iw extends gl {
    private final Context a;

    private iw(Context context, zzar zzar) {
        super(zzar);
        this.a = context;
    }

    public static ast a(Context context) {
        ast ast = new ast(new jh(new File(context.getCacheDir(), "admob_volley")), new iw(context, new on()));
        ast.a();
        return ast;
    }

    public final any zzc(apk<?> apk) {
        if (apk.h() && apk.c() == 0) {
            if (Pattern.matches((String) akc.f().a(amn.cJ), apk.e())) {
                akc.a();
                if (kb.c(this.a)) {
                    any zzc = new aql(this.a).zzc(apk);
                    String valueOf;
                    if (zzc != null) {
                        String str = "Got gmscore asset response: ";
                        valueOf = String.valueOf(apk.e());
                        hl.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        return zzc;
                    }
                    String str2 = "Failed to get gmscore asset response: ";
                    valueOf = String.valueOf(apk.e());
                    hl.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
        return super.zzc(apk);
    }
}
