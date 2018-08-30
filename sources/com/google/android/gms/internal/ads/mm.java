package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.p;

@zzadh
public final class mm extends mf {
    @Nullable
    public final me a(Context context, zzapw zzapw, int i, boolean z, ana ana, ms msVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        Object obj = (!p.b() || (applicationInfo != null && applicationInfo.targetSdkVersion < 11)) ? null : 1;
        if (obj == null) {
            return null;
        }
        return new lt(context, z, zzapw.zzud().d(), msVar, new mt(context, zzapw.zztq(), zzapw.zzol(), ana, zzapw.zztn()));
    }
}
