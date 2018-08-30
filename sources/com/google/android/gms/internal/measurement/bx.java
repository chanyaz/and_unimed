package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.appnext.base.b.c;
import com.google.android.gms.analytics.t;

public final class bx extends af {
    private SharedPreferences a;
    private long b;
    private long c = -1;
    private final bz d = new bz(this, c.jt, ((Long) bk.D.a()).longValue(), null);

    protected bx(ah ahVar) {
        super(ahVar);
    }

    protected final void a() {
        this.a = j().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final void a(String str) {
        t.d();
        y();
        Editor edit = this.a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            e("Failed to commit campaign data");
        }
    }

    public final long b() {
        t.d();
        y();
        if (this.b == 0) {
            long j = this.a.getLong("first_run", 0);
            if (j != 0) {
                this.b = j;
            } else {
                j = i().currentTimeMillis();
                Editor edit = this.a.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    e("Failed to commit first run time");
                }
                this.b = j;
            }
        }
        return this.b;
    }

    public final cf c() {
        return new cf(i(), b());
    }

    public final long d() {
        t.d();
        y();
        if (this.c == -1) {
            this.c = this.a.getLong("last_dispatch", 0);
        }
        return this.c;
    }

    public final void e() {
        t.d();
        y();
        long currentTimeMillis = i().currentTimeMillis();
        Editor edit = this.a.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.c = currentTimeMillis;
    }

    public final String f() {
        t.d();
        y();
        CharSequence string = this.a.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }

    public final bz g() {
        return this.d;
    }
}
