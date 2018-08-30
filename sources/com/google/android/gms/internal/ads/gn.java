package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;

@zzadh
public final class gn {
    public static Uri a(Uri uri, Context context) {
        if (!au.B().f(context) || !TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            return uri;
        }
        String j = au.B().j(context);
        uri = a(uri.toString(), "fbs_aeid", j);
        au.B().d(context, j);
        return uri;
    }

    @VisibleForTesting
    private static Uri a(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(str.substring(0, indexOf + 1)).append(str2).append("=").append(str3).append("&").append(str.substring(indexOf + 1)).toString()) : Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    public static String a(String str, Context context) {
        if (!au.B().a(context) || TextUtils.isEmpty(str)) {
            return str;
        }
        String j = au.B().j(context);
        if (j == null) {
            return str;
        }
        if (((Boolean) akc.f().a(amn.at)).booleanValue()) {
            String str2 = (String) akc.f().a(amn.au);
            if (!str.contains(str2)) {
                return str;
            }
            if (au.e().d(str)) {
                au.B().d(context, j);
                return str.replace(str2, j);
            } else if (!au.e().e(str)) {
                return str;
            } else {
                au.B().e(context, j);
                return str.replace(str2, j);
            }
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            if (au.e().d(str)) {
                au.B().d(context, j);
                return a(str, "fbs_aeid", j).toString();
            } else if (!au.e().e(str)) {
                return str;
            } else {
                au.B().e(context, j);
                return a(str, "fbs_aeid", j).toString();
            }
        }
    }

    public static String b(String str, Context context) {
        if (!au.B().a(context) || TextUtils.isEmpty(str)) {
            return str;
        }
        Object j = au.B().j(context);
        if (j == null || !au.e().e(str)) {
            return str;
        }
        if (!((Boolean) akc.f().a(amn.at)).booleanValue()) {
            return !str.contains("fbs_aeid") ? a(str, "fbs_aeid", j).toString() : str;
        } else {
            String str2 = (String) akc.f().a(amn.au);
            return str.contains(str2) ? str.replace(str2, j) : str;
        }
    }
}
