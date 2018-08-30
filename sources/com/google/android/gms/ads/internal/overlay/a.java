package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.hl;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
public final class a {
    private static boolean a(Context context, Intent intent, zzt zzt) {
        try {
            String str = "Launching an intent: ";
            String valueOf = String.valueOf(intent.toURI());
            hl.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            au.e();
            ht.a(context, intent);
            if (zzt != null) {
                zzt.zzbl();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            kk.e(e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, zzc zzc, zzt zzt) {
        if (zzc == null) {
            kk.e("No intent data for launcher overlay.");
            return false;
        }
        amn.a(context);
        if (zzc.f != null) {
            return a(context, zzc.f, zzt);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzc.a)) {
            kk.e("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(zzc.b)) {
            intent.setData(Uri.parse(zzc.a));
        } else {
            intent.setDataAndType(Uri.parse(zzc.a), zzc.b);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.c)) {
            intent.setPackage(zzc.c);
        }
        if (!TextUtils.isEmpty(zzc.d)) {
            String[] split = zzc.d.split("/", 2);
            if (split.length < 2) {
                String str = "Could not parse component name from open GMSG: ";
                String valueOf = String.valueOf(zzc.d);
                kk.e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        Object obj = zzc.e;
        if (!TextUtils.isEmpty(obj)) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(obj);
            } catch (NumberFormatException e) {
                kk.e("Could not parse intent flags.");
                parseInt = 0;
            }
            intent.addFlags(parseInt);
        }
        if (((Boolean) akc.f().a(amn.cN)).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) akc.f().a(amn.cM)).booleanValue()) {
                au.e();
                ht.b(context, intent);
            }
        }
        return a(context, intent, zzt);
    }
}
