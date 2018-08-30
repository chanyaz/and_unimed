package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.d;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzx;
import java.util.HashMap;
import java.util.Map;

public final class o {
    private final zzbj<zzao> a;
    private final Context b;
    private ContentProviderClient c = null;
    private boolean d = false;
    private final Map<m<LocationListener>, t> e = new HashMap();
    private final Map<m<Object>, s> f = new HashMap();
    private final Map<m<d>, p> g = new HashMap();

    public o(Context context, zzbj<zzao> zzbj) {
        this.b = context;
        this.a = zzbj;
    }

    private final t a(ListenerHolder<LocationListener> listenerHolder) {
        t tVar;
        synchronized (this.e) {
            tVar = (t) this.e.get(listenerHolder.b());
            if (tVar == null) {
                tVar = new t(listenerHolder);
            }
            this.e.put(listenerHolder.b(), tVar);
        }
        return tVar;
    }

    private final p b(ListenerHolder<d> listenerHolder) {
        p pVar;
        synchronized (this.g) {
            pVar = (p) this.g.get(listenerHolder.b());
            if (pVar == null) {
                pVar = new p(listenerHolder);
            }
            this.g.put(listenerHolder.b(), pVar);
        }
        return pVar;
    }

    public final Location a() {
        this.a.checkConnected();
        return ((zzao) this.a.getService()).zza(this.b.getPackageName());
    }

    public final void a(PendingIntent pendingIntent, zzaj zzaj) {
        this.a.checkConnected();
        ((zzao) this.a.getService()).zza(new zzbf(2, null, null, pendingIntent, null, zzaj != null ? zzaj.asBinder() : null));
    }

    public final void a(Location location) {
        this.a.checkConnected();
        ((zzao) this.a.getService()).zza(location);
    }

    public final void a(m<LocationListener> mVar, zzaj zzaj) {
        this.a.checkConnected();
        ar.a((Object) mVar, (Object) "Invalid null listener key");
        synchronized (this.e) {
            zzx zzx = (t) this.e.remove(mVar);
            if (zzx != null) {
                zzx.a();
                ((zzao) this.a.getService()).zza(zzbf.a(zzx, zzaj));
            }
        }
    }

    public final void a(zzaj zzaj) {
        this.a.checkConnected();
        ((zzao) this.a.getService()).zza(zzaj);
    }

    public final void a(zzbd zzbd, ListenerHolder<d> listenerHolder, zzaj zzaj) {
        this.a.checkConnected();
        ((zzao) this.a.getService()).zza(new zzbf(1, zzbd, null, null, b(listenerHolder).asBinder(), zzaj != null ? zzaj.asBinder() : null));
    }

    public final void a(LocationRequest locationRequest, PendingIntent pendingIntent, zzaj zzaj) {
        this.a.checkConnected();
        ((zzao) this.a.getService()).zza(new zzbf(1, zzbd.a(locationRequest), null, pendingIntent, null, zzaj != null ? zzaj.asBinder() : null));
    }

    public final void a(LocationRequest locationRequest, ListenerHolder<LocationListener> listenerHolder, zzaj zzaj) {
        this.a.checkConnected();
        ((zzao) this.a.getService()).zza(new zzbf(1, zzbd.a(locationRequest), a((ListenerHolder) listenerHolder).asBinder(), null, null, zzaj != null ? zzaj.asBinder() : null));
    }

    public final void a(boolean z) {
        this.a.checkConnected();
        ((zzao) this.a.getService()).zza(z);
        this.d = z;
    }

    public final LocationAvailability b() {
        this.a.checkConnected();
        return ((zzao) this.a.getService()).zzb(this.b.getPackageName());
    }

    public final void b(m<d> mVar, zzaj zzaj) {
        this.a.checkConnected();
        ar.a((Object) mVar, (Object) "Invalid null listener key");
        synchronized (this.g) {
            zzu zzu = (p) this.g.remove(mVar);
            if (zzu != null) {
                zzu.a();
                ((zzao) this.a.getService()).zza(zzbf.a(zzu, zzaj));
            }
        }
    }

    public final void c() {
        synchronized (this.e) {
            for (zzx zzx : this.e.values()) {
                if (zzx != null) {
                    ((zzao) this.a.getService()).zza(zzbf.a(zzx, null));
                }
            }
            this.e.clear();
        }
        synchronized (this.g) {
            for (zzu zzu : this.g.values()) {
                if (zzu != null) {
                    ((zzao) this.a.getService()).zza(zzbf.a(zzu, null));
                }
            }
            this.g.clear();
        }
        synchronized (this.f) {
            for (s sVar : this.f.values()) {
                if (sVar != null) {
                    ((zzao) this.a.getService()).zza(new zzo(2, null, sVar.asBinder(), null));
                }
            }
            this.f.clear();
        }
    }

    public final void d() {
        if (this.d) {
            a(false);
        }
    }
}
