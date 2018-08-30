package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;

final class k implements VersionPolicy {
    k() {
    }

    public final a selectModule(Context context, String str, IVersions iVersions) {
        a aVar = new a();
        aVar.a = iVersions.getLocalVersion(context, str);
        aVar.b = iVersions.getRemoteVersion(context, str, true);
        if (aVar.a == 0 && aVar.b == 0) {
            aVar.c = 0;
        } else if (aVar.a >= aVar.b) {
            aVar.c = -1;
        } else {
            aVar.c = 1;
        }
        return aVar;
    }
}
