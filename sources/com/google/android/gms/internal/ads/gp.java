package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

@zzadh
public final class gp implements zzajg {
    public final zzanz<String> zza(String str, PackageInfo packageInfo) {
        return kq.a((Object) str);
    }

    public final zzanz<Info> zzae(Context context) {
        zzanz lkVar = new lk();
        akc.a();
        if (kb.f(context)) {
            hr.a(new gq(this, context, lkVar));
        }
        return lkVar;
    }
}
