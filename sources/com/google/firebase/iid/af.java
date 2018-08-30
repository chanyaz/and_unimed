package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

final class af {
    private final KeyPair a;
    private final long b;

    @VisibleForTesting
    af(KeyPair keyPair, long j) {
        this.a = keyPair;
        this.b = j;
    }

    private final String b() {
        return Base64.encodeToString(this.a.getPublic().getEncoded(), 11);
    }

    private final String c() {
        return Base64.encodeToString(this.a.getPrivate().getEncoded(), 11);
    }

    final KeyPair a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof af)) {
            return false;
        }
        af afVar = (af) obj;
        return this.b == afVar.b && this.a.getPublic().equals(afVar.a.getPublic()) && this.a.getPrivate().equals(afVar.a.getPrivate());
    }

    public final int hashCode() {
        return ap.a(this.a.getPublic(), this.a.getPrivate(), Long.valueOf(this.b));
    }
}
