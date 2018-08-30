package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;

public final class ed {
    @VisibleForTesting
    private final String a;
    private final String b;
    private final String c;
    private final long d;
    private final /* synthetic */ dz e;

    private ed(dz dzVar, String str, long j) {
        this.e = dzVar;
        ar.a(str);
        ar.b(j > 0);
        this.a = String.valueOf(str).concat(":start");
        this.b = String.valueOf(str).concat(":count");
        this.c = String.valueOf(str).concat(":value");
        this.d = j;
    }

    /* synthetic */ ed(dz dzVar, String str, long j, ea eaVar) {
        this(dzVar, str, j);
    }

    @WorkerThread
    private final void b() {
        this.e.c();
        long currentTimeMillis = this.e.zzbt().currentTimeMillis();
        Editor edit = this.e.y().edit();
        edit.remove(this.b);
        edit.remove(this.c);
        edit.putLong(this.a, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    private final long c() {
        return this.e.y().getLong(this.a, 0);
    }

    @WorkerThread
    public final Pair<String, Long> a() {
        this.e.c();
        this.e.c();
        long c = c();
        if (c == 0) {
            b();
            c = 0;
        } else {
            c = Math.abs(c - this.e.zzbt().currentTimeMillis());
        }
        if (c < this.d) {
            return null;
        }
        if (c > (this.d << 1)) {
            b();
            return null;
        }
        String string = this.e.y().getString(this.c, null);
        long j = this.e.y().getLong(this.b, 0);
        b();
        return (string == null || j <= 0) ? dz.a : new Pair(string, Long.valueOf(j));
    }

    @WorkerThread
    public final void a(String str, long j) {
        this.e.c();
        if (c() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.e.y().getLong(this.b, 0);
        if (j2 <= 0) {
            Editor edit = this.e.y().edit();
            edit.putString(this.c, str);
            edit.putLong(this.b, 1);
            edit.apply();
            return;
        }
        Object obj = (this.e.l().s().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / (j2 + 1) ? 1 : null;
        Editor edit2 = this.e.y().edit();
        if (obj != null) {
            edit2.putString(this.c, str);
        }
        edit2.putLong(this.b, j2 + 1);
        edit2.apply();
    }
}
