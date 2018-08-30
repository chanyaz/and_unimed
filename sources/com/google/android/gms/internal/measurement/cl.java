package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.v4.util.a;
import com.google.android.gms.common.internal.ar;
import java.util.Map;

public final class cl extends fn {
    private final Map<String, Long> a = new a();
    private final Map<String, Integer> b = new a();
    private long c;

    public cl(es esVar) {
        super(esVar);
    }

    @WorkerThread
    private final void a(long j, gk gkVar) {
        if (gkVar == null) {
            zzge().y().a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzge().y().a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            gl.a(gkVar, bundle, true);
            e().a("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void a(String str, long j) {
        c();
        ar.a(str);
        if (this.b.isEmpty()) {
            this.c = j;
        }
        Integer num = (Integer) this.b.get(str);
        if (num != null) {
            this.b.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.b.size() >= 100) {
            zzge().u().a("Too many ads visible");
        } else {
            this.b.put(str, Integer.valueOf(1));
            this.a.put(str, Long.valueOf(j));
        }
    }

    @WorkerThread
    private final void a(String str, long j, gk gkVar) {
        if (gkVar == null) {
            zzge().y().a("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzge().y().a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            gl.a(gkVar, bundle, true);
            e().a("am", "_xu", bundle);
        }
    }

    @WorkerThread
    private final void b(long j) {
        for (String put : this.a.keySet()) {
            this.a.put(put, Long.valueOf(j));
        }
        if (!this.a.isEmpty()) {
            this.c = j;
        }
    }

    @WorkerThread
    private final void b(String str, long j) {
        c();
        ar.a(str);
        Integer num = (Integer) this.b.get(str);
        if (num != null) {
            gk r = i().r();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.b.remove(str);
                Long l = (Long) this.a.get(str);
                if (l == null) {
                    zzge().r().a("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.a.remove(str);
                    a(str, longValue, r);
                }
                if (!this.b.isEmpty()) {
                    return;
                }
                if (this.c == 0) {
                    zzge().r().a("First ad exposure time was never set");
                    return;
                }
                a(j - this.c, r);
                this.c = 0;
                return;
            }
            this.b.put(str, Integer.valueOf(intValue));
            return;
        }
        zzge().r().a("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    @WorkerThread
    public final void a(long j) {
        gk r = i().r();
        for (String str : this.a.keySet()) {
            a(str, j - ((Long) this.a.get(str)).longValue(), r);
        }
        if (!this.a.isEmpty()) {
            a(j - this.c, r);
        }
        b(j);
    }

    public final void a(String str) {
        if (str == null || str.length() == 0) {
            zzge().r().a("Ad unit id must be a non-empty string");
            return;
        }
        zzgd().a(new cm(this, str, zzbt().elapsedRealtime()));
    }

    public final void b(String str) {
        if (str == null || str.length() == 0) {
            zzge().r().a("Ad unit id must be a non-empty string");
            return;
        }
        zzgd().a(new cn(this, str, zzbt().elapsedRealtime()));
    }
}
