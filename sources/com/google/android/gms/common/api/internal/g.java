package com.google.android.gms.common.api.internal;

import com.appnext.base.a.c.c;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ap;

final class g {
    private final bz<?> a;
    private final Feature b;

    private g(bz<?> bzVar, Feature feature) {
        this.a = bzVar;
        this.b = feature;
    }

    /* synthetic */ g(bz bzVar, Feature feature, ax axVar) {
        this(bzVar, feature);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return ap.a(this.a, gVar.a) && ap.a(this.b, gVar.b);
    }

    public final int hashCode() {
        return ap.a(this.a, this.b);
    }

    public final String toString() {
        return ap.a((Object) this).a(c.gv, this.a).a("feature", this.b).toString();
    }
}
