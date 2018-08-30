package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;

final class jd implements zzanj<Throwable, T> {
    private final /* synthetic */ zzalz a;

    jd(jb jbVar, zzalz zzalz) {
        this.a = zzalz;
    }

    public final /* synthetic */ zzanz zzc(Object obj) {
        Throwable th = (Throwable) obj;
        kk.b("Error occurred while dispatching http response in getter.", th);
        au.i().a(th, "HttpGetter.deliverResponse.1");
        return kq.a(this.a.zzny());
    }
}
