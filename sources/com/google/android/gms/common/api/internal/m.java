package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class m<L> {
    private final L a;
    private final String b;

    @KeepForSdk
    m(L l, String str) {
        this.a = l;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.a == mVar.a && this.b.equals(mVar.b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.a) * 31) + this.b.hashCode();
    }
}
