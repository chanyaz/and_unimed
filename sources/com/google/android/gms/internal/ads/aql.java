package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class aql implements zzm {
    @Nullable
    @GuardedBy("mLock")
    private aqh a;
    @GuardedBy("mLock")
    private boolean b;
    private final Context c;
    private final Object d = new Object();

    public aql(Context context) {
        this.c = context;
    }

    private final Future<ParcelFileDescriptor> a(zzsg zzsg) {
        Future aqm = new aqm(this);
        BaseConnectionCallbacks aqn = new aqn(this, aqm, zzsg);
        BaseOnConnectionFailedListener aqq = new aqq(this, aqm);
        synchronized (this.d) {
            this.a = new aqh(this.c, au.t().a(), aqn, aqq);
            this.a.g();
        }
        return aqm;
    }

    private final void a() {
        synchronized (this.d) {
            if (this.a == null) {
                return;
            }
            this.a.disconnect();
            this.a = null;
            Binder.flushPendingCommands();
        }
    }

    public final any zzc(apk<?> apk) {
        zzsg a = zzsg.a(apk);
        long intValue = (long) ((Integer) akc.f().a(amn.cK)).intValue();
        long elapsedRealtime = au.l().elapsedRealtime();
        try {
            zzsi zzsi = (zzsi) new zzaev((ParcelFileDescriptor) a(a).get(intValue, TimeUnit.MILLISECONDS)).a(zzsi.CREATOR);
            if (zzsi.a) {
                throw new zzae(zzsi.b);
            }
            any any;
            if (zzsi.e.length != zzsi.f.length) {
                any = null;
            } else {
                Map hashMap = new HashMap();
                for (int i = 0; i < zzsi.e.length; i++) {
                    hashMap.put(zzsi.e[i], zzsi.f[i]);
                }
                any = new any(zzsi.c, zzsi.d, hashMap, zzsi.g, zzsi.h);
            }
            hl.a("Http assets remote cache took " + (au.l().elapsedRealtime() - elapsedRealtime) + "ms");
            return any;
        } catch (InterruptedException e) {
            hl.a("Http assets remote cache took " + (au.l().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (ExecutionException e2) {
            hl.a("Http assets remote cache took " + (au.l().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (TimeoutException e3) {
            hl.a("Http assets remote cache took " + (au.l().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            hl.a("Http assets remote cache took " + (au.l().elapsedRealtime() - elapsedRealtime) + "ms");
        }
    }
}
