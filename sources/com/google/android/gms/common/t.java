package com.google.android.gms.common;

import android.support.annotation.NonNull;
import android.util.Log;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class t {
    private static final t b = new t(true, null, null);
    final boolean a;
    private final String c;
    private final Throwable d;

    t(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.a = z;
        this.c = str;
        this.d = th;
    }

    static t a() {
        return b;
    }

    static t a(@NonNull String str) {
        return new t(false, str, null);
    }

    static t a(String str, i iVar, boolean z, boolean z2) {
        return new v(str, iVar, z, z2, null);
    }

    static t a(@NonNull String str, @NonNull Throwable th) {
        return new t(false, str, th);
    }

    @Nullable
    String b() {
        return this.c;
    }

    final void c() {
        if (!this.a) {
            if (this.d != null) {
                Log.d("GoogleCertificatesRslt", b(), this.d);
            } else {
                Log.d("GoogleCertificatesRslt", b());
            }
        }
    }
}
