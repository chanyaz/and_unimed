package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class asy {
    private final Object a;
    private final Context b;
    private final String c;
    private final zzang d;
    private zzalo<zzuu> e;
    private zzalo<zzuu> f;
    @Nullable
    private atp g;
    private int h;

    public asy(Context context, zzang zzang, String str) {
        this.a = new Object();
        this.h = 1;
        this.c = str;
        this.b = context.getApplicationContext();
        this.d = zzang;
        this.e = new atk();
        this.f = new atk();
    }

    public asy(Context context, zzang zzang, String str, zzalo<zzuu> zzalo, zzalo<zzuu> zzalo2) {
        this(context, zzang, str);
        this.e = zzalo;
        this.f = zzalo2;
    }

    protected final atp a(@Nullable ada ada) {
        ln atp = new atp(this.f);
        lf.a.execute(new asz(this, ada, atp));
        atp.zza(new ath(this, atp), new ati(this, atp));
        return atp;
    }

    public final atl b(@Nullable ada ada) {
        atl c;
        synchronized (this.a) {
            if (this.g == null || this.g.b() == -1) {
                this.h = 2;
                this.g = a(null);
                c = this.g.c();
            } else if (this.h == 0) {
                c = this.g.c();
            } else if (this.h == 1) {
                this.h = 2;
                a(null);
                c = this.g.c();
            } else if (this.h == 2) {
                c = this.g.c();
            } else {
                c = this.g.c();
            }
        }
        return c;
    }
}
