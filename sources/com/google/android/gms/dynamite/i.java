package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;

final class i implements VersionPolicy {
    i() {
    }

    public final a selectModule(Context context, String str, IVersions iVersions) {
        a aVar = new a();
        aVar.b = iVersions.getRemoteVersion(context, str, true);
        if (aVar.b != 0) {
            aVar.c = 1;
        } else {
            aVar.a = iVersions.getLocalVersion(context, str);
            if (aVar.a != 0) {
                aVar.c = -1;
            }
        }
        return aVar;
    }
}
