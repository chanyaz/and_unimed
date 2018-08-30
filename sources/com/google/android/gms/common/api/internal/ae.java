package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.ar;
import java.lang.ref.WeakReference;

final class ae implements ConnectionProgressReportCallbacks {
    private final WeakReference<ac> a;
    private final Api<?> b;
    private final boolean c;

    public ae(ac acVar, Api<?> api, boolean z) {
        this.a = new WeakReference(acVar);
        this.b = api;
        this.c = z;
    }

    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        boolean z = false;
        ac acVar = (ac) this.a.get();
        if (acVar != null) {
            if (Looper.myLooper() == acVar.a.d.a()) {
                z = true;
            }
            ar.a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            acVar.b.lock();
            try {
                if (acVar.a(0)) {
                    if (!connectionResult.b()) {
                        acVar.a(connectionResult, this.b, this.c);
                    }
                    if (acVar.a()) {
                        acVar.b();
                    }
                    acVar.b.unlock();
                }
            } finally {
                acVar.b.unlock();
            }
        }
    }
}
