package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;

final class h implements IVersions {
    h() {
    }

    public final int getLocalVersion(Context context, String str) {
        return DynamiteModule.a(context, str);
    }

    public final int getRemoteVersion(Context context, String str, boolean z) {
        return DynamiteModule.a(context, str, z);
    }
}
