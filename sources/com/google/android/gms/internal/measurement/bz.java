package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.UUID;

public final class bz {
    private final String a;
    private final long b;
    private final /* synthetic */ bx c;

    private bz(bx bxVar, String str, long j) {
        this.c = bxVar;
        ar.a(str);
        ar.b(j > 0);
        this.a = str;
        this.b = j;
    }

    /* synthetic */ bz(bx bxVar, String str, long j, by byVar) {
        this(bxVar, str, j);
    }

    private final void b() {
        long currentTimeMillis = this.c.i().currentTimeMillis();
        Editor edit = this.c.a.edit();
        edit.remove(e());
        edit.remove(f());
        edit.putLong(d(), currentTimeMillis);
        edit.commit();
    }

    private final long c() {
        return this.c.a.getLong(d(), 0);
    }

    private final String d() {
        return String.valueOf(this.a).concat(":start");
    }

    private final String e() {
        return String.valueOf(this.a).concat(":count");
    }

    @VisibleForTesting
    private final String f() {
        return String.valueOf(this.a).concat(":value");
    }

    public final Pair<String, Long> a() {
        long c = c();
        c = c == 0 ? 0 : Math.abs(c - this.c.i().currentTimeMillis());
        if (c < this.b) {
            return null;
        }
        if (c > (this.b << 1)) {
            b();
            return null;
        }
        String string = this.c.a.getString(f(), null);
        long j = this.c.a.getLong(e(), 0);
        b();
        return (string == null || j <= 0) ? null : new Pair(string, Long.valueOf(j));
    }

    public final void a(String str) {
        if (c() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.c.a.getLong(e(), 0);
            if (j <= 0) {
                Editor edit = this.c.a.edit();
                edit.putString(f(), str);
                edit.putLong(e(), 1);
                edit.apply();
                return;
            }
            Object obj = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1) ? 1 : null;
            Editor edit2 = this.c.a.edit();
            if (obj != null) {
                edit2.putString(f(), str);
            }
            edit2.putLong(e(), j + 1);
            edit2.apply();
        }
    }
}
