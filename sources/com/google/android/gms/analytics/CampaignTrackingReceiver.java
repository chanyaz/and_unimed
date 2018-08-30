package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.ah;
import com.google.android.gms.internal.measurement.bd;
import com.google.android.gms.internal.measurement.cj;

@VisibleForTesting
public class CampaignTrackingReceiver extends BroadcastReceiver {
    private static Boolean a;

    public static boolean a(Context context) {
        ar.a((Object) context);
        if (a != null) {
            return a.booleanValue();
        }
        boolean a = cj.a(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        a = Boolean.valueOf(a);
        return a;
    }

    protected void a(Context context, String str) {
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        ah a = ah.a(context);
        ae e = a.e();
        if (intent == null) {
            e.e("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        e.a("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            e.e("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        a(context, stringExtra);
        int c = bd.c();
        if (stringExtra.length() > c) {
            e.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(c));
            stringExtra = stringExtra.substring(0, c);
        }
        a.h().a(stringExtra, new m(this, goAsync()));
    }
}
