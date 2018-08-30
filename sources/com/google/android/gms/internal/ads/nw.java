package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.ads.internal.zzbo;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class nw {
    public static zzanz<zzaqw> a(Context context, zzang zzang, String str, ada ada, br brVar) {
        return kq.a(kq.a(null), new nx(context, ada, zzang, brVar, str), lf.a);
    }

    public static zzaqw a(Context context, op opVar, String str, boolean z, boolean z2, @Nullable ada ada, zzang zzang, ana ana, zzbo zzbo, br brVar, ahx ahx) {
        amn.a(context);
        if (((Boolean) akc.f().a(amn.az)).booleanValue()) {
            return ov.a(context, opVar, str, z2, z, ada, zzang, ana, zzbo, brVar, ahx);
        }
        try {
            return (zzaqw) js.a(new ny(context, opVar, str, z, z2, ada, zzang, ana, zzbo, brVar, ahx));
        } catch (Throwable th) {
            zzarg zzarg = new zzarg("Webview initialization failed.", th);
        }
    }
}
