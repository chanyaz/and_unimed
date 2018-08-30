package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import java.util.concurrent.TimeUnit;

@zzadh
public final class mt {
    private final Context a;
    private final String b;
    private final zzang c;
    @Nullable
    private final amy d;
    @Nullable
    private final ana e;
    private final ix f = new ja().a("min_1", Double.MIN_VALUE, 1.0d).a("1_5", 1.0d, 5.0d).a("5_10", 5.0d, 10.0d).a("10_20", 10.0d, 20.0d).a("20_30", 20.0d, 30.0d).a("30_max", 30.0d, Double.MAX_VALUE).a();
    private final long[] g;
    private final String[] h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m;
    private me n;
    private boolean o;
    private boolean p;
    private long q = -1;

    public mt(Context context, zzang zzang, String str, @Nullable ana ana, @Nullable amy amy) {
        this.a = context;
        this.c = zzang;
        this.b = str;
        this.e = ana;
        this.d = amy;
        String str2 = (String) akc.f().a(amn.u);
        if (str2 == null) {
            this.h = new String[0];
            this.g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.h = new String[split.length];
        this.g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.g[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                kk.c("Unable to parse frame hash target time number.", e);
                this.g[i] = -1;
            }
        }
    }

    public final void a() {
        if (this.i && !this.j) {
            amt.a(this.e, this.d, "vfr2");
            this.j = true;
        }
    }

    public final void a(me meVar) {
        amt.a(this.e, this.d, "vpc2");
        this.i = true;
        if (this.e != null) {
            this.e.a("vpn", meVar.a());
        }
        this.n = meVar;
    }

    public final void b() {
        if (((Boolean) akc.f().a(amn.t)).booleanValue() && !this.o) {
            String valueOf;
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.b);
            bundle.putString("player", this.n.a());
            for (iz izVar : this.f.a()) {
                String valueOf2 = String.valueOf("fps_c_");
                valueOf = String.valueOf(izVar.a);
                bundle.putString(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2), Integer.toString(izVar.c));
                valueOf2 = String.valueOf("fps_p_");
                valueOf = String.valueOf(izVar.a);
                bundle.putString(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2), Double.toString(izVar.b));
            }
            for (int i = 0; i < this.g.length; i++) {
                valueOf = this.h[i];
                if (valueOf != null) {
                    String valueOf3 = String.valueOf(Long.valueOf(this.g[i]));
                    bundle.putString(new StringBuilder(String.valueOf(valueOf3).length() + 3).append("fh_").append(valueOf3).toString(), valueOf);
                }
            }
            au.e().a(this.a, this.c.a, "gmob-apps", bundle, true);
            this.o = true;
        }
    }

    public final void b(me meVar) {
        if (this.k && !this.l) {
            if (hl.a() && !this.l) {
                hl.a("VideoMetricsMixin first frame");
            }
            amt.a(this.e, this.d, "vff2");
            this.l = true;
        }
        long nanoTime = au.l().nanoTime();
        if (this.m && this.p && this.q != -1) {
            this.f.a(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.q)));
        }
        this.p = this.m;
        this.q = nanoTime;
        long longValue = ((Long) akc.f().a(amn.v)).longValue();
        long currentPosition = (long) meVar.getCurrentPosition();
        int i = 0;
        while (i < this.h.length) {
            if (this.h[i] != null || longValue <= Math.abs(currentPosition - this.g[i])) {
                i++;
            } else {
                String[] strArr = this.h;
                Bitmap bitmap = meVar.getBitmap(8, 8);
                currentPosition = 0;
                longValue = 63;
                int i2 = 0;
                while (i2 < 8) {
                    int i3 = 0;
                    long j = currentPosition;
                    while (true) {
                        currentPosition = longValue;
                        if (i3 >= 8) {
                            break;
                        }
                        int pixel = bitmap.getPixel(i3, i2);
                        j |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1 : 0) << ((int) currentPosition);
                        i3++;
                        longValue = currentPosition - 1;
                    }
                    i2++;
                    longValue = currentPosition;
                    currentPosition = j;
                }
                strArr[i] = String.format("%016X", new Object[]{Long.valueOf(currentPosition)});
                return;
            }
        }
    }

    public final void c() {
        this.m = true;
        if (this.j && !this.k) {
            amt.a(this.e, this.d, "vfp2");
            this.k = true;
        }
    }

    public final void d() {
        this.m = false;
    }
}
