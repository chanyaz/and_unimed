package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.ar;

public final class ej {
    private final zzge a;

    public ej(zzge zzge) {
        ar.a((Object) zzge);
        this.a = zzge;
    }

    public static boolean a(Context context) {
        ar.a((Object) context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
            return receiverInfo != null && receiverInfo.enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    @MainThread
    public final void a(Context context, Intent intent) {
        hw a = es.a(context);
        dp zzge = a.zzge();
        if (intent == null) {
            zzge.u().a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzge.y().a("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzge.y().a("Starting wakeful intent.");
            this.a.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                a.zzgd().a(new ek(this, a, zzge));
            } catch (Exception e) {
                zzge.u().a("Install Referrer Reporter encountered a problem", e);
            }
            PendingResult doGoAsync = this.a.doGoAsync();
            action = intent.getStringExtra("referrer");
            if (action == null) {
                zzge.y().a("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            zzge.w().a("Install referrer extras are", action);
            if (!action.contains("?")) {
                String str = "?";
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            Bundle a2 = a.k().a(Uri.parse(action));
            if (a2 == null) {
                zzge.y().a("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                zzge.u().a("Install referrer is missing timestamp");
            }
            a.zzgd().a(new el(this, a, longExtra, a2, context, zzge, doGoAsync));
        }
    }
}
