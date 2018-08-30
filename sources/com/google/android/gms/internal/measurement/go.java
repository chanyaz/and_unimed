package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Intent;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class go extends fo {
    private final hc a;
    private zzey b;
    private volatile Boolean c;
    private final cy d;
    private final hr e;
    private final List<Runnable> f = new ArrayList();
    private final cy g;

    protected go(es esVar) {
        super(esVar);
        this.e = new hr(esVar.zzbt());
        this.a = new hc(this);
        this.d = new gp(this, esVar);
        this.g = new gu(this, esVar);
    }

    @WorkerThread
    private final void E() {
        c();
        zzge().y().a("Processing queued up service tasks", Integer.valueOf(this.f.size()));
        for (Runnable run : this.f) {
            try {
                run.run();
            } catch (Exception e) {
                zzge().r().a("Task exception while flushing queue", e);
            }
        }
        this.f.clear();
        this.g.c();
    }

    @Nullable
    @WorkerThread
    private final zzdz a(boolean z) {
        return f().a(z ? zzge().z() : null);
    }

    @WorkerThread
    private final void a(ComponentName componentName) {
        c();
        if (this.b != null) {
            this.b = null;
            zzge().y().a("Disconnected from device MeasurementService", componentName);
            c();
            v();
        }
    }

    @WorkerThread
    private final void a(Runnable runnable) {
        c();
        if (r()) {
            runnable.run();
        } else if (((long) this.f.size()) >= 1000) {
            zzge().r().a("Discarding data. Max runnable queue size reached");
        } else {
            this.f.add(runnable);
            this.g.a(60000);
            v();
        }
    }

    @WorkerThread
    private final void y() {
        c();
        this.e.a();
        this.d.a(((Long) dg.H.b()).longValue());
    }

    @WorkerThread
    private final void z() {
        c();
        if (r()) {
            zzge().y().a("Inactivity, disconnecting from the service");
            x();
        }
    }

    @WorkerThread
    protected final void a(gk gkVar) {
        c();
        B();
        a(new gt(this, gkVar));
    }

    @WorkerThread
    protected final void a(zzed zzed) {
        ar.a((Object) zzed);
        c();
        B();
        a(new gx(this, true, j().a(zzed), new zzed(zzed), a(true), zzed));
    }

    @WorkerThread
    protected final void a(zzeu zzeu, String str) {
        ar.a((Object) zzeu);
        c();
        B();
        a(new gw(this, true, j().a(zzeu), zzeu, a(true), str));
    }

    @WorkerThread
    @VisibleForTesting
    protected final void a(zzey zzey) {
        c();
        ar.a((Object) zzey);
        this.b = zzey;
        y();
        E();
    }

    @WorkerThread
    @VisibleForTesting
    final void a(zzey zzey, AbstractSafeParcelable abstractSafeParcelable, zzdz zzdz) {
        c();
        B();
        int i = 100;
        for (int i2 = 0; i2 < 1001 && i == 100; i2++) {
            List arrayList = new ArrayList();
            Object a = j().a(100);
            if (a != null) {
                arrayList.addAll(a);
                i = a.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                a = arrayList2.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) a;
                if (abstractSafeParcelable2 instanceof zzeu) {
                    try {
                        zzey.zza((zzeu) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e) {
                        zzge().r().a("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjx) {
                    try {
                        zzey.zza((zzjx) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e2) {
                        zzge().r().a("Failed to send attribute to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzed) {
                    try {
                        zzey.zza((zzed) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e22) {
                        zzge().r().a("Failed to send conditional property to the service", e22);
                    }
                } else {
                    zzge().r().a("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    @WorkerThread
    protected final void a(zzjx zzjx) {
        c();
        B();
        a(new ha(this, j().a(zzjx), zzjx, a(true)));
    }

    @WorkerThread
    public final void a(AtomicReference<String> atomicReference) {
        c();
        B();
        a(new gr(this, atomicReference, a(false)));
    }

    @WorkerThread
    protected final void a(AtomicReference<List<zzed>> atomicReference, String str, String str2, String str3) {
        c();
        B();
        a(new gy(this, atomicReference, str, str2, str3, a(false)));
    }

    @WorkerThread
    protected final void a(AtomicReference<List<zzjx>> atomicReference, String str, String str2, String str3, boolean z) {
        c();
        B();
        a(new gz(this, atomicReference, str, str2, str3, z, a(false)));
    }

    @WorkerThread
    protected final void a(AtomicReference<List<zzjx>> atomicReference, boolean z) {
        c();
        B();
        a(new hb(this, atomicReference, a(false), z));
    }

    protected final boolean p() {
        return false;
    }

    @WorkerThread
    public final boolean r() {
        c();
        B();
        return this.b != null;
    }

    @WorkerThread
    protected final void s() {
        c();
        B();
        a(new gv(this, a(true)));
    }

    @WorkerThread
    protected final void t() {
        c();
        B();
        zzdz a = a(false);
        j().r();
        a(new gq(this, a));
    }

    @WorkerThread
    protected final void u() {
        c();
        B();
        a(new gs(this, a(true)));
    }

    @WorkerThread
    final void v() {
        Object obj = 1;
        c();
        B();
        if (!r()) {
            if (this.c == null) {
                boolean z;
                c();
                B();
                Boolean t = n().t();
                if (t == null || !t.booleanValue()) {
                    Object obj2;
                    if (f().v() != 1) {
                        zzge().y().a("Checking service availability");
                        int b = g.b().b(l().getContext(), 12451);
                        int obj22;
                        switch (b) {
                            case 0:
                                zzge().y().a("Service available");
                                obj22 = 1;
                                z = true;
                                break;
                            case 1:
                                zzge().y().a("Service missing");
                                obj22 = 1;
                                z = false;
                                break;
                            case 2:
                                zzge().x().a("Service container out of date");
                                if (l().t() >= 12600) {
                                    t = n().t();
                                    z = t == null || t.booleanValue();
                                    obj22 = null;
                                    break;
                                }
                                obj22 = 1;
                                z = false;
                                break;
                            case 3:
                                zzge().u().a("Service disabled");
                                obj22 = null;
                                z = false;
                                break;
                            case 9:
                                zzge().u().a("Service invalid");
                                obj22 = null;
                                z = false;
                                break;
                            case 18:
                                zzge().u().a("Service updating");
                                obj22 = 1;
                                z = true;
                                break;
                            default:
                                zzge().u().a("Unexpected service status", Integer.valueOf(b));
                                obj22 = null;
                                z = false;
                                break;
                        }
                    }
                    obj22 = 1;
                    z = true;
                    if (obj22 != null) {
                        n().a(z);
                    }
                } else {
                    z = true;
                }
                this.c = Boolean.valueOf(z);
            }
            if (this.c.booleanValue()) {
                this.a.a();
                return;
            }
            List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                obj = null;
            }
            if (obj != null) {
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.a.a(intent);
                return;
            }
            zzge().r().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        }
    }

    final Boolean w() {
        return this.c;
    }

    @WorkerThread
    public final void x() {
        c();
        B();
        try {
            b.a().a(getContext(), this.a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.b = null;
    }
}
