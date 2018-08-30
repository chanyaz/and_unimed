package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.s;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.a.d;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.n;
import com.google.android.gms.common.util.g;
import javax.annotation.concurrent.GuardedBy;

public final class q {
    @GuardedBy("sCache")
    private static final s<String, String> a = new s();

    private q() {
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return c.b(context).b(packageName).toString();
        } catch (NameNotFoundException e) {
        } catch (NullPointerException e2) {
        }
        CharSequence charSequence = context.getApplicationInfo().name;
        return !TextUtils.isEmpty(charSequence) ? charSequence : packageName;
    }

    @Nullable
    public static String a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(d.common_google_play_services_install_title);
            case 2:
                return resources.getString(d.common_google_play_services_update_title);
            case 3:
                return resources.getString(d.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return a(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return a(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return a(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    @Nullable
    private static String a(Context context, String str) {
        synchronized (a) {
            String str2 = (String) a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            String str3;
            String str4;
            if (identifier == 0) {
                str3 = "GoogleApiAvailability";
                str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            Object string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            a.put(str, string);
            return string;
        }
    }

    private static String a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a = a(context, str);
        if (a == null) {
            a = resources.getString(n.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a, new Object[]{str2});
    }

    public static String b(Context context) {
        return context.getResources().getString(d.common_google_play_services_notification_channel_name);
    }

    @NonNull
    public static String b(Context context, int i) {
        String a = i == 6 ? a(context, "common_google_play_services_resolution_required_title") : a(context, i);
        return a == null ? context.getResources().getString(d.common_google_play_services_notification_ticker) : a;
    }

    @NonNull
    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        String a = a(context);
        switch (i) {
            case 1:
                return resources.getString(d.common_google_play_services_install_text, new Object[]{a});
            case 2:
                if (g.b(context)) {
                    return resources.getString(d.common_google_play_services_wear_update_text);
                }
                return resources.getString(d.common_google_play_services_update_text, new Object[]{a});
            case 3:
                return resources.getString(d.common_google_play_services_enable_text, new Object[]{a});
            case 5:
                return a(context, "common_google_play_services_invalid_account_text", a);
            case 7:
                return a(context, "common_google_play_services_network_error_text", a);
            case 9:
                return resources.getString(d.common_google_play_services_unsupported_text, new Object[]{a});
            case 16:
                return a(context, "common_google_play_services_api_unavailable_text", a);
            case 17:
                return a(context, "common_google_play_services_sign_in_failed_text", a);
            case 18:
                return resources.getString(d.common_google_play_services_updating_text, new Object[]{a});
            case 20:
                return a(context, "common_google_play_services_restricted_profile_text", a);
            default:
                return resources.getString(n.common_google_play_services_unknown_issue, new Object[]{a});
        }
    }

    @NonNull
    public static String d(Context context, int i) {
        return i == 6 ? a(context, "common_google_play_services_resolution_required_text", a(context)) : c(context, i);
    }

    @NonNull
    public static String e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(d.common_google_play_services_install_button);
            case 2:
                return resources.getString(d.common_google_play_services_update_button);
            case 3:
                return resources.getString(d.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
