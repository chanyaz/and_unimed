package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;

final class n implements VersionPolicy {
    n() {
    }

    public final a selectModule(Context context, String str, IVersions iVersions) {
        a aVar = new a();
        aVar.a = iVersions.getLocalVersion(context, str);
        if (aVar.a != 0) {
            aVar.b = iVersions.getRemoteVersion(context, str, false);
        } else {
            aVar.b = iVersions.getRemoteVersion(context, str, true);
        }
        if (aVar.a == 0 && aVar.b == 0) {
            aVar.c = 0;
        } else if (aVar.b >= aVar.a) {
            aVar.c = 1;
        } else {
            aVar.c = -1;
        }
        return aVar;
    }
}
