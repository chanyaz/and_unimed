package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.ads.internal.zzbo;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ov {
    public static zzaqw a(Context context, op opVar, String str, boolean z, boolean z2, @Nullable ada ada, zzang zzang, ana ana, zzbo zzbo, br brVar, ahx ahx) {
        try {
            return (zzaqw) js.a(new ow(context, opVar, str, z, z2, ada, zzang, ana, zzbo, brVar, ahx));
        } catch (Throwable th) {
            au.i().a(th, "AdWebViewFactory.newAdWebView2");
            zzarg zzarg = new zzarg("Webview initialization failed.", th);
        }
    }
}
