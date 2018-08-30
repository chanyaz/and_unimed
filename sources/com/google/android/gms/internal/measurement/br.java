package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class br {
    private final long a;
    private final int b;
    private double c;
    private long d;
    private final Object e;
    private final String f;
    private final Clock g;

    private br(int i, long j, String str, Clock clock) {
        this.e = new Object();
        this.b = 60;
        this.c = (double) this.b;
        this.a = 2000;
        this.f = str;
        this.g = clock;
    }

    public br(String str, Clock clock) {
        this(60, 2000, str, clock);
    }

    public final boolean a() {
        boolean z;
        synchronized (this.e) {
            long currentTimeMillis = this.g.currentTimeMillis();
            if (this.c < ((double) this.b)) {
                double d = ((double) (currentTimeMillis - this.d)) / ((double) this.a);
                if (d > 0.0d) {
                    this.c = Math.min((double) this.b, d + this.c);
                }
            }
            this.d = currentTimeMillis;
            if (this.c >= 1.0d) {
                this.c -= 1.0d;
                z = true;
            } else {
                String str = this.f;
                bs.b(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
                z = false;
            }
        }
        return z;
    }
}
