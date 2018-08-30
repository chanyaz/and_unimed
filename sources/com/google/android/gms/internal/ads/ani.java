package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.b;
import android.support.customtabs.e;
import android.support.customtabs.f;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class ani implements zzbfy {
    @Nullable
    private f a;
    @Nullable
    private b b;
    @Nullable
    private e c;
    @Nullable
    private zzoi d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(abx.a(context));
            }
        }
        return false;
    }

    public final void a(Activity activity) {
        if (this.c != null) {
            activity.unbindService(this.c);
            this.b = null;
            this.a = null;
            this.c = null;
        }
    }

    public final void a(zzoi zzoi) {
        this.d = zzoi;
    }

    public final boolean a(Uri uri, Bundle bundle, List<Bundle> list) {
        if (this.b == null) {
            return false;
        }
        if (this.b == null) {
            this.a = null;
        } else if (this.a == null) {
            this.a = this.b.a(null);
        }
        f fVar = this.a;
        return fVar != null ? fVar.a(uri, null, null) : false;
    }

    public final void b(Activity activity) {
        if (this.b == null) {
            String a = abx.a(activity);
            if (a != null) {
                this.c = new aby(this);
                b.a(activity, a, this.c);
            }
        }
    }

    public final void zza(b bVar) {
        this.b = bVar;
        this.b.a(0);
        if (this.d != null) {
            this.d.zzjp();
        }
    }

    public final void zzjo() {
        this.b = null;
        this.a = null;
        if (this.d != null) {
            this.d.zzjq();
        }
    }
}
