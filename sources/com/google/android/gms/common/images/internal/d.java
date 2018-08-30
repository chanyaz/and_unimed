package com.google.android.gms.common.images.internal;

import com.google.android.gms.common.internal.ap;

public final class d {
    public final int a;
    public final int b;

    public d(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        d dVar = (d) obj;
        return dVar.a == this.a && dVar.b == this.b;
    }

    public final int hashCode() {
        return ap.a(Integer.valueOf(this.a), Integer.valueOf(this.b));
    }
}
