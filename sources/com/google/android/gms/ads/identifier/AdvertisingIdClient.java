package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.d;
import com.google.android.gms.internal.ads_identifier.zze;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@ParametersAreNonnullByDefault
public class AdvertisingIdClient {
    @GuardedBy("this")
    private final Context mContext;
    @Nullable
    @GuardedBy("this")
    private a zze;
    @Nullable
    @GuardedBy("this")
    private zze zzf;
    @GuardedBy("this")
    private boolean zzg;
    private final Object zzh;
    @Nullable
    @GuardedBy("mAutoDisconnectTaskLock")
    private a zzi;
    private final boolean zzj;
    private final long zzk;

    @KeepForSdkWithMembers
    public final class Info {
        private final String zzq;
        private final boolean zzr;

        public Info(String str, boolean z) {
            this.zzq = str;
            this.zzr = z;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            String str = this.zzq;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzr).toString();
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    @VisibleForTesting
    private AdvertisingIdClient(Context context, long j, boolean z, boolean z2) {
        this.zzh = new Object();
        ar.a((Object) context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.mContext = context;
        } else {
            this.mContext = context;
        }
        this.zzg = false;
        this.zzk = j;
        this.zzj = z2;
    }

    @KeepForSdk
    public static Info getAdvertisingIdInfo(Context context) {
        c cVar = new c(context);
        boolean a = cVar.a("gads:ad_id_app_context:enabled", false);
        float a2 = cVar.a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String a3 = cVar.a("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, a, cVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zza(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, a, a2, SystemClock.elapsedRealtime() - elapsedRealtime, a3, null);
            advertisingIdClient.finish();
            return info;
        } catch (Throwable th) {
            advertisingIdClient.finish();
        }
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        c cVar = new c(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, cVar.a("gads:ad_id_app_context:enabled", false), cVar.a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.zza(false);
            boolean zzb = advertisingIdClient.zzb();
            return zzb;
        } finally {
            advertisingIdClient.finish();
        }
    }

    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static a zza(Context context, boolean z) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (g.b().b(context, 12451000)) {
                case 0:
                case 2:
                    String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                    ServiceConnection aVar = new a();
                    Intent intent = new Intent(str);
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (b.a().a(context, intent, aVar, 1)) {
                            return aVar;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    @VisibleForTesting
    private static zze zza(Context context, a aVar) {
        try {
            return d.a(aVar.a(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private final void zza() {
        synchronized (this.zzh) {
            if (this.zzi != null) {
                this.zzi.a.countDown();
                try {
                    this.zzi.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzk > 0) {
                this.zzi = new a(this, this.zzk);
            }
        }
    }

    @VisibleForTesting
    private final void zza(boolean z) {
        ar.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzg) {
                finish();
            }
            this.zze = zza(this.mContext, this.zzj);
            this.zzf = zza(this.mContext, this.zze);
            this.zzg = true;
            if (z) {
                zza();
            }
        }
    }

    @VisibleForTesting
    private final boolean zza(Info info, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > ((double) f)) {
            return false;
        }
        Map hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (!(str == null || str.isEmpty())) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new b(this, hashMap).start();
        return true;
    }

    private final boolean zzb() {
        boolean zzc;
        ar.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    if (this.zzi == null || !this.zzi.b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            ar.a(this.zze);
            ar.a(this.zzf);
            zzc = this.zzf.zzc();
        }
        zza();
        return zzc;
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: Missing block: B:22:?, code:
            return;
     */
    public final void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.ar.c(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zze;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzg;	 Catch:{ Throwable -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.b.a();	 Catch:{ Throwable -> 0x002d }
        r1 = r3.mContext;	 Catch:{ Throwable -> 0x002d }
        r2 = r3.zze;	 Catch:{ Throwable -> 0x002d }
        r0.a(r1, r2);	 Catch:{ Throwable -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.zzg = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzf = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zze = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    @KeepForSdk
    public Info getInfo() {
        Info info;
        ar.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    if (this.zzi == null || !this.zzi.b) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            ar.a(this.zze);
            ar.a(this.zzf);
            info = new Info(this.zzf.getId(), this.zzf.zzb(true));
        }
        zza();
        return info;
    }

    @KeepForSdk
    public void start() {
        zza(true);
    }
}
