package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.VisibleForTesting;

public final class GooglePlayServicesUtil extends k {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = k.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        if (k.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        return e.a().a(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return k.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i) {
        return k.getErrorString(i);
    }

    public static Context getRemoteContext(Context context) {
        return k.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return k.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return k.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return k.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        if (k.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        e a = e.a();
        if (fragment == null) {
            return a.b(activity, i, i2, onCancelListener);
        }
        Dialog a2 = e.a((Context) activity, i, s.a(fragment, e.a().b(activity, i, "d"), i2), onCancelListener);
        if (a2 == null) {
            return false;
        }
        e.a(activity, a2, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        e a = e.a();
        if (k.isPlayServicesPossiblyUpdating(context, i) || k.isPlayStorePossiblyUpdating(context, i)) {
            a.c(context);
        } else {
            a.a(context, i);
        }
    }
}
