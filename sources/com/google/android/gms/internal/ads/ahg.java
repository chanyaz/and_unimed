package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;

public final class ahg {
    final long a;
    final String b;
    final int c;

    ahg(long j, String str, int i) {
        this.a = j;
        this.b = str;
        this.c = i;
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj == null || !(obj instanceof ahg)) ? false : ((ahg) obj).a == this.a && ((ahg) obj).c == this.c;
    }

    public final int hashCode() {
        return (int) this.a;
    }
}
