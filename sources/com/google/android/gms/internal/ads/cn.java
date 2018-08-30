package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import com.appnext.base.b.c;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzadh
public final class cn extends cj implements BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    private Context a;
    private zzang b;
    private zzaol<zzaef> c;
    private final zzadx d;
    private final Object e = new Object();
    @VisibleForTesting
    private co f;

    public cn(Context context, zzang zzang, zzaol<zzaef> zzaol, zzadx zzadx) {
        super(zzaol, zzadx);
        this.a = context;
        this.b = zzang;
        this.c = zzaol;
        this.d = zzadx;
        this.f = new co(context, ((Boolean) akc.f().a(amn.G)).booleanValue() ? au.t().a() : context.getMainLooper(), this, this);
        this.f.g();
    }

    public final void a() {
        synchronized (this.e) {
            if (this.f.isConnected() || this.f.isConnecting()) {
                this.f.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public final zzaen b() {
        zzaen r;
        synchronized (this.e) {
            try {
                r = this.f.r();
            } catch (IllegalStateException e) {
            } catch (DeadObjectException e2) {
            }
        }
        return r;
        r = null;
        return r;
    }

    public final void onConnected(Bundle bundle) {
        zznt();
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        kk.b("Cannot connect to remote service, fallback to local instance.");
        new cm(this.a, this.c, this.d).zznt();
        Bundle bundle = new Bundle();
        bundle.putString(c.jD, "gms_connection_failed_fallback_to_local");
        au.e().b(this.a, this.b.a, "gmob-apps", bundle, true);
    }

    public final void onConnectionSuspended(int i) {
        kk.b("Disconnected from remote ad request service.");
    }
}
