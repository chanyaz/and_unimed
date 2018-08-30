package com.google.android.gms.common.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.e;
import com.google.android.gms.common.g;

public class z {
    private final SparseIntArray a;
    private g b;

    public z() {
        this(e.a());
    }

    public z(@NonNull g gVar) {
        this.a = new SparseIntArray();
        ar.a((Object) gVar);
        this.b = gVar;
    }

    public int a(@NonNull Context context, @NonNull Client client) {
        ar.a((Object) context);
        ar.a((Object) client);
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i = this.a.get(minApkVersion, -1);
        if (i != -1) {
            return i;
        }
        int i2;
        for (i2 = 0; i2 < this.a.size(); i2++) {
            int keyAt = this.a.keyAt(i2);
            if (keyAt > minApkVersion && this.a.get(keyAt) == 0) {
                i2 = 0;
                break;
            }
        }
        i2 = i;
        if (i2 == -1) {
            i2 = this.b.b(context, minApkVersion);
        }
        this.a.put(minApkVersion, i2);
        return i2;
    }

    public void a() {
        this.a.clear();
    }
}
