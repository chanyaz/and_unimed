package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class xn implements zzbey {
    private final zzbav a;

    private xn(zzbav zzbav) {
        this.a = (zzbav) yk.a((Object) zzbav, "output");
    }

    public static xn a(zzbav zzbav) {
        return zzbav.a != null ? zzbav.a : new xn(zzbav);
    }

    public final void zza(int i, double d) {
        this.a.a(i, d);
    }

    public final void zza(int i, float f) {
        this.a.a(i, f);
    }

    public final void zza(int i, long j) {
        this.a.a(i, j);
    }

    public final <K, V> void zza(int i, zb<K, V> zbVar, Map<K, V> map) {
        for (Entry entry : map.entrySet()) {
            this.a.a(i, 2);
            this.a.b(za.a(zbVar, entry.getKey(), entry.getValue()));
            za.a(this.a, zbVar, entry.getKey(), entry.getValue());
        }
    }

    public final void zza(int i, zzbah zzbah) {
        this.a.a(i, zzbah);
    }

    public final void zza(int i, Object obj) {
        if (obj instanceof zzbah) {
            this.a.b(i, (zzbah) obj);
        } else {
            this.a.a(i, (zzbcu) obj);
        }
    }

    public final void zza(int i, Object obj, zzbdm zzbdm) {
        this.a.a(i, (zzbcu) obj, zzbdm);
    }

    public final void zza(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof zzbcd) {
            zzbcd zzbcd = (zzbcd) list;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    Object zzcp = zzbcd.zzcp(i3);
                    if (zzcp instanceof String) {
                        this.a.a(i, (String) zzcp);
                    } else {
                        this.a.a(i, (zzbah) zzcp);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
        while (i2 < list.size()) {
            this.a.a(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzbdm zzbdm) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzbdm);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.f(((Integer) list.get(i4)).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.b(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final int zzacn() {
        return yi.j;
    }

    public final void zzb(int i, long j) {
        this.a.b(i, j);
    }

    public final void zzb(int i, Object obj, zzbdm zzbdm) {
        zzbav zzbav = this.a;
        zzbcu zzbcu = (zzbcu) obj;
        zzbav.a(i, 3);
        zzbdm.zza(zzbcu, zzbav.a);
        zzbav.a(i, 4);
    }

    public final void zzb(int i, List<zzbah> list) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.a.a(i, (zzbah) list.get(i3));
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public final void zzb(int i, List<?> list, zzbdm zzbdm) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzbdm);
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.i(((Integer) list.get(i4)).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.d(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.e(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzc(int i, long j) {
        this.a.c(i, j);
    }

    public final void zzc(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.d(((Long) list.get(i4)).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzcm(int i) {
        this.a.a(i, 3);
    }

    public final void zzcn(int i) {
        this.a.a(i, 4);
    }

    public final void zzd(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.e(((Long) list.get(i4)).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.g(((Long) list.get(i4)).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.c(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzf(int i, String str) {
        this.a.a(i, str);
    }

    public final void zzf(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.b(((Float) list.get(i4)).floatValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    public final void zzf(int i, boolean z) {
        this.a.a(i, z);
    }

    public final void zzg(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.b(((Double) list.get(i4)).doubleValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.k(((Integer) list.get(i4)).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.b(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzi(int i, long j) {
        this.a.a(i, j);
    }

    public final void zzi(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.b(((Boolean) list.get(i4)).booleanValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.a(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.a(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void zzj(int i, long j) {
        this.a.c(i, j);
    }

    public final void zzj(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.g(((Integer) list.get(i4)).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.b(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.c(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.j(((Integer) list.get(i4)).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.d(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.e(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.h(((Long) list.get(i4)).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.c(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzm(int i, int i2) {
        this.a.b(i, i2);
    }

    public final void zzm(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.h(((Integer) list.get(i4)).intValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.c(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.d(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, int i2) {
        this.a.c(i, i2);
    }

    public final void zzn(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbav.f(((Long) list.get(i4)).longValue());
            }
            this.a.b(i3);
            while (i2 < list.size()) {
                this.a.b(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.a.b(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzo(int i, int i2) {
        this.a.d(i, i2);
    }

    public final void zzp(int i, int i2) {
        this.a.e(i, i2);
    }

    public final void zzw(int i, int i2) {
        this.a.e(i, i2);
    }

    public final void zzx(int i, int i2) {
        this.a.b(i, i2);
    }
}
