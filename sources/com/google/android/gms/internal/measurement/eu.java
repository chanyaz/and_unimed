package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.k;
import com.google.android.gms.common.l;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class eu extends di {
    private final hw a;
    private Boolean b;
    @Nullable
    private String c;

    public eu(hw hwVar) {
        this(hwVar, null);
    }

    private eu(hw hwVar, @Nullable String str) {
        ar.a((Object) hwVar);
        this.a = hwVar;
        this.c = null;
    }

    @BinderThread
    private final void a(zzdz zzdz, boolean z) {
        ar.a((Object) zzdz);
        a(zzdz.a, false);
        this.a.k().e(zzdz.b);
    }

    @VisibleForTesting
    private final void a(Runnable runnable) {
        ar.a((Object) runnable);
        if (((Boolean) dg.T.b()).booleanValue() && this.a.zzgd().s()) {
            runnable.run();
        } else {
            this.a.zzgd().a(runnable);
        }
    }

    @BinderThread
    private final void a(String str, boolean z) {
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            this.a.zzge().r().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.b == null) {
                    if ("com.google.android.gms".equals(this.c) || t.a(this.a.getContext(), Binder.getCallingUid()) || l.a(this.a.getContext()).a(Binder.getCallingUid())) {
                        z2 = true;
                    }
                    this.b = Boolean.valueOf(z2);
                }
                if (this.b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.a.zzge().r().a("Measurement Service called with invalid calling package. appId", dp.a(str));
                throw e;
            }
        }
        if (this.c == null && k.uidHasPackageName(this.a.getContext(), Binder.getCallingUid(), str)) {
            this.c = str;
        }
        if (!str.equals(this.c)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }

    @BinderThread
    public final List<zzjx> zza(zzdz zzdz, boolean z) {
        Object e;
        a(zzdz, false);
        try {
            List<id> list = (List) this.a.zzgd().a(new fk(this, zzdz)).get();
            List<zzjx> arrayList = new ArrayList(list.size());
            for (id idVar : list) {
                if (z || !ie.h(idVar.c)) {
                    arrayList.add(new zzjx(idVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.a.zzge().r().a("Failed to get user attributes. appId", dp.a(zzdz.a), e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.a.zzge().r().a("Failed to get user attributes. appId", dp.a(zzdz.a), e);
            return null;
        }
    }

    @BinderThread
    public final List<zzed> zza(String str, String str2, zzdz zzdz) {
        Object e;
        a(zzdz, false);
        try {
            return (List) this.a.zzgd().a(new fc(this, zzdz, str, str2)).get();
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        }
        this.a.zzge().r().a("Failed to get conditional user properties", e);
        return Collections.emptyList();
    }

    @BinderThread
    public final List<zzjx> zza(String str, String str2, String str3, boolean z) {
        Object e;
        a(str, true);
        try {
            List<id> list = (List) this.a.zzgd().a(new fb(this, str, str2, str3)).get();
            List<zzjx> arrayList = new ArrayList(list.size());
            for (id idVar : list) {
                if (z || !ie.h(idVar.c)) {
                    arrayList.add(new zzjx(idVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.a.zzge().r().a("Failed to get user attributes. appId", dp.a(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e3) {
            e = e3;
            this.a.zzge().r().a("Failed to get user attributes. appId", dp.a(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) {
        Object e;
        a(zzdz, false);
        try {
            List<id> list = (List) this.a.zzgd().a(new fa(this, zzdz, str, str2)).get();
            List<zzjx> arrayList = new ArrayList(list.size());
            for (id idVar : list) {
                if (z || !ie.h(idVar.c)) {
                    arrayList.add(new zzjx(idVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.a.zzge().r().a("Failed to get user attributes. appId", dp.a(zzdz.a), e);
            return Collections.emptyList();
        } catch (ExecutionException e3) {
            e = e3;
            this.a.zzge().r().a("Failed to get user attributes. appId", dp.a(zzdz.a), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        a(new fm(this, str2, str3, str, j));
    }

    @BinderThread
    public final void zza(zzdz zzdz) {
        a(zzdz, false);
        a(new fl(this, zzdz));
    }

    @BinderThread
    public final void zza(zzed zzed, zzdz zzdz) {
        ar.a((Object) zzed);
        ar.a(zzed.c);
        a(zzdz, false);
        zzed zzed2 = new zzed(zzed);
        zzed2.a = zzdz.a;
        if (zzed.c.a() == null) {
            a(new ew(this, zzed2, zzdz));
        } else {
            a(new ex(this, zzed2, zzdz));
        }
    }

    @BinderThread
    public final void zza(zzeu zzeu, zzdz zzdz) {
        ar.a((Object) zzeu);
        a(zzdz, false);
        a(new ff(this, zzeu, zzdz));
    }

    @BinderThread
    public final void zza(zzeu zzeu, String str, String str2) {
        ar.a((Object) zzeu);
        ar.a(str);
        a(str, true);
        a(new fg(this, zzeu, str));
    }

    @BinderThread
    public final void zza(zzjx zzjx, zzdz zzdz) {
        ar.a((Object) zzjx);
        a(zzdz, false);
        if (zzjx.a() == null) {
            a(new fi(this, zzjx, zzdz));
        } else {
            a(new fj(this, zzjx, zzdz));
        }
    }

    @BinderThread
    public final byte[] zza(zzeu zzeu, String str) {
        Object e;
        ar.a(str);
        ar.a((Object) zzeu);
        a(str, true);
        this.a.zzge().x().a("Log and bundle. event", this.a.l().a(zzeu.a));
        long nanoTime = this.a.zzbt().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.a.zzgd().b(new fh(this, zzeu, str)).get();
            if (bArr == null) {
                this.a.zzge().r().a("Log and bundle returned null. appId", dp.a(str));
                bArr = new byte[0];
            }
            this.a.zzge().x().a("Log and bundle processed. event, size, time_ms", this.a.l().a(zzeu.a), Integer.valueOf(bArr.length), Long.valueOf((this.a.zzbt().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.a.zzge().r().a("Failed to log and bundle. appId, event, error", dp.a(str), this.a.l().a(zzeu.a), e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.a.zzge().r().a("Failed to log and bundle. appId, event, error", dp.a(str), this.a.l().a(zzeu.a), e);
            return null;
        }
    }

    @BinderThread
    public final void zzb(zzdz zzdz) {
        a(zzdz, false);
        a(new ev(this, zzdz));
    }

    @BinderThread
    public final void zzb(zzed zzed) {
        ar.a((Object) zzed);
        ar.a(zzed.c);
        a(zzed.a, true);
        zzed zzed2 = new zzed(zzed);
        if (zzed.c.a() == null) {
            a(new ey(this, zzed2));
        } else {
            a(new ez(this, zzed2));
        }
    }

    @BinderThread
    public final String zzc(zzdz zzdz) {
        a(zzdz, false);
        return this.a.d(zzdz);
    }

    @BinderThread
    public final void zzd(zzdz zzdz) {
        a(zzdz.a, false);
        a(new fe(this, zzdz));
    }

    @BinderThread
    public final List<zzed> zze(String str, String str2, String str3) {
        Object e;
        a(str, true);
        try {
            return (List) this.a.zzgd().a(new fd(this, str, str2, str3)).get();
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        }
        this.a.zzge().r().a("Failed to get conditional user properties", e);
        return Collections.emptyList();
    }
}
