package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class afo implements zzt {
    private final Map<String, List<apk<?>>> a = new HashMap();
    private final adp b;

    afo(adp adp) {
        this.b = adp;
    }

    private final synchronized boolean a(apk<?> apk) {
        boolean z = false;
        synchronized (this) {
            String e = apk.e();
            if (this.a.containsKey(e)) {
                List list = (List) this.a.get(e);
                if (list == null) {
                    list = new ArrayList();
                }
                apk.b("waiting-for-response");
                list.add(apk);
                this.a.put(e, list);
                if (dc.a) {
                    dc.b("Request for cacheKey=%s is in flight, putting on hold.", e);
                }
                z = true;
            } else {
                this.a.put(e, null);
                apk.a((zzt) this);
                if (dc.a) {
                    dc.b("new request, sending to network %s", e);
                }
            }
        }
        return z;
    }

    public final synchronized void zza(apk<?> apk) {
        String e = apk.e();
        List list = (List) this.a.remove(e);
        if (!(list == null || list.isEmpty())) {
            if (dc.a) {
                dc.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), e);
            }
            apk apk2 = (apk) list.remove(0);
            this.a.put(e, list);
            apk2.a((zzt) this);
            try {
                this.b.c.put(apk2);
            } catch (InterruptedException e2) {
                dc.c("Couldn't add request to queue. %s", e2.toString());
                Thread.currentThread().interrupt();
                this.b.a();
            }
        }
        return;
    }

    public final void zza(apk<?> apk, auj<?> auj) {
        if (auj.b == null || auj.b.a()) {
            zza(apk);
            return;
        }
        List<apk> list;
        String e = apk.e();
        synchronized (this) {
            list = (List) this.a.remove(e);
        }
        if (list != null) {
            if (dc.a) {
                dc.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), e);
            }
            for (apk zzb : list) {
                this.b.e.zzb(zzb, auj);
            }
        }
    }
}
