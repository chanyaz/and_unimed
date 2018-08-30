package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.Clock;

final class hr {
    private final Clock a;
    private long b;

    public hr(Clock clock) {
        ar.a((Object) clock);
        this.a = clock;
    }

    public final void a() {
        this.b = this.a.elapsedRealtime();
    }

    public final boolean a(long j) {
        return this.b == 0 || this.a.elapsedRealtime() - this.b >= 3600000;
    }

    public final void b() {
        this.b = 0;
    }
}
