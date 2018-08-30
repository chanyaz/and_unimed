package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class bt {
    public static final Status a = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] c = new BasePendingResult[0];
    @VisibleForTesting
    final Set<BasePendingResult<?>> b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzcn d = new bu(this);
    private final Map<b<?>, Client> e;

    public bt(Map<b<?>, Client> map) {
        this.e = map;
    }

    public final void a() {
        zzcn zzcn = null;
        for (PendingResult pendingResult : (BasePendingResult[]) this.b.toArray(c)) {
            pendingResult.a(zzcn);
            if (pendingResult.c() != null) {
                pendingResult.a((ResultCallback) zzcn);
                IBinder serviceBrokerBinder = ((Client) this.e.get(((b) pendingResult).d())).getServiceBrokerBinder();
                if (pendingResult.f()) {
                    pendingResult.a(new bv(pendingResult, zzcn, serviceBrokerBinder, zzcn));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    pendingResult.a(zzcn);
                    pendingResult.a();
                    zzcn.a(pendingResult.c().intValue());
                } else {
                    zzcn bvVar = new bv(pendingResult, zzcn, serviceBrokerBinder, zzcn);
                    pendingResult.a(bvVar);
                    try {
                        serviceBrokerBinder.linkToDeath(bvVar, 0);
                    } catch (RemoteException e) {
                        pendingResult.a();
                        zzcn.a(pendingResult.c().intValue());
                    }
                }
                this.b.remove(pendingResult);
            } else if (pendingResult.g()) {
                this.b.remove(pendingResult);
            }
        }
    }

    final void a(BasePendingResult<? extends Result> basePendingResult) {
        this.b.add(basePendingResult);
        basePendingResult.a(this.d);
    }

    public final void b() {
        for (BasePendingResult a : (BasePendingResult[]) this.b.toArray(c)) {
            a.a(a);
        }
    }
}
