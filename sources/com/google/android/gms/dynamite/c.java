package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;

final class c implements IVersions {
    private final int a;
    private final int b = 0;

    public c(int i, int i2) {
        this.a = i;
    }

    public final int getLocalVersion(Context context, String str) {
        return this.a;
    }

    public final int getRemoteVersion(Context context, String str, boolean z) {
        return 0;
    }
}
