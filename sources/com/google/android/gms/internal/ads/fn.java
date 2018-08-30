package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;

@zzadh
public final class fn extends ft {
    private volatile zzaht a;
    private volatile zzahw b;
    private volatile zzahu c;
    private volatile zzaia d;

    public fn(zzahu zzahu) {
        this.c = zzahu;
    }

    public final void a(zzaht zzaht) {
        this.a = zzaht;
    }

    public final void a(zzahw zzahw) {
        this.b = zzahw;
    }

    public final void a(zzaia zzaia) {
        this.d = zzaia;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaig zzaig) {
        if (this.c != null) {
            this.c.zzc(zzaig);
        }
    }

    public final void zzc(Bundle bundle) {
        if (this.d != null) {
            this.d.zzc(bundle);
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        if (this.a != null) {
            this.a.zzac(i);
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.b != null) {
            this.b.zza(c.a(iObjectWrapper).getClass().getName(), i);
        }
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        if (this.a != null) {
            this.a.zzpc();
        }
    }

    public final void zzr(IObjectWrapper iObjectWrapper) {
        if (this.b != null) {
            this.b.zzcb(c.a(iObjectWrapper).getClass().getName());
        }
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
        if (this.c != null) {
            this.c.onRewardedVideoAdOpened();
        }
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        if (this.c != null) {
            this.c.onRewardedVideoStarted();
        }
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        if (this.c != null) {
            this.c.onRewardedVideoAdClosed();
        }
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        if (this.c != null) {
            this.c.zzdm();
        }
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        if (this.c != null) {
            this.c.onRewardedVideoAdLeftApplication();
        }
    }

    public final void zzx(IObjectWrapper iObjectWrapper) {
        if (this.c != null) {
            this.c.onRewardedVideoCompleted();
        }
    }
}
