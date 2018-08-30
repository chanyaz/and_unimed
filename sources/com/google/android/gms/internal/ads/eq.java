package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class eq extends ey {
    private final Context a;
    private final Object b;
    private final zzang c;
    @GuardedBy("mLock")
    private final er d;

    public eq(Context context, br brVar, zzxn zzxn, zzang zzang) {
        this(context, zzang, new er(context, brVar, zzjn.a(), zzxn, zzang));
    }

    @VisibleForTesting
    private eq(Context context, zzang zzang, er erVar) {
        this.b = new Object();
        this.a = context;
        this.c = zzang;
        this.d = erVar;
    }

    public final void destroy() {
        zzf(null);
    }

    public final String getMediationAdapterClassName() {
        String mediationAdapterClassName;
        synchronized (this.b) {
            mediationAdapterClassName = this.d.getMediationAdapterClassName();
        }
        return mediationAdapterClassName;
    }

    public final boolean isLoaded() {
        boolean l;
        synchronized (this.b) {
            l = this.d.l();
        }
        return l;
    }

    public final void pause() {
        zzd(null);
    }

    public final void resume() {
        zze(null);
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.b) {
            this.d.setImmersiveMode(z);
        }
    }

    public final void setUserId(String str) {
        synchronized (this.b) {
            this.d.setUserId(str);
        }
    }

    public final void show() {
        synchronized (this.b) {
            this.d.k();
        }
    }

    public final void zza(zzagx zzagx) {
        synchronized (this.b) {
            this.d.a(zzagx);
        }
    }

    public final void zza(zzahe zzahe) {
        synchronized (this.b) {
            this.d.zza(zzahe);
        }
    }

    public final void zza(zzahk zzahk) {
        synchronized (this.b) {
            this.d.a(zzahk);
        }
    }

    public final void zza(zzkx zzkx) {
        if (((Boolean) akc.f().a(amn.aF)).booleanValue()) {
            synchronized (this.b) {
                this.d.zza(zzkx);
            }
        }
    }

    public final Bundle zzba() {
        if (!((Boolean) akc.f().a(amn.aF)).booleanValue()) {
            return new Bundle();
        }
        Bundle zzba;
        synchronized (this.b) {
            zzba = this.d.zzba();
        }
        return zzba;
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        synchronized (this.b) {
            this.d.pause();
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        synchronized (this.b) {
            Context context = iObjectWrapper == null ? null : (Context) c.a(iObjectWrapper);
            if (context != null) {
                try {
                    this.d.a(context);
                } catch (Throwable e) {
                    kk.c("Unable to extract updated context.", e);
                }
            }
            this.d.resume();
        }
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        synchronized (this.b) {
            this.d.destroy();
        }
    }
}
