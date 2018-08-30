package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.an;
import android.support.v4.app.ao;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.a.c;
import com.google.android.gms.a.d;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.p;

public class e extends g {
    public static final int a = g.b;
    private static final Object c = new Object();
    private static final e d = new e();
    @GuardedBy("mLock")
    private String e;

    e() {
    }

    static Dialog a(Context context, int i, s sVar, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(q.c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence e = q.e(context, i);
        if (e != null) {
            builder.setPositiveButton(e, sVar);
        }
        e = q.a(context, i);
        if (e != null) {
            builder.setTitle(e);
        }
        return builder.create();
    }

    public static e a() {
        return d;
    }

    @TargetApi(26)
    private final String a(Context context, NotificationManager notificationManager) {
        ar.a(p.l());
        String c = c();
        if (c == null) {
            c = "com.google.android.gms.availability";
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(c);
            CharSequence b = q.b(context);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(c, b, 4));
            } else if (!b.equals(notificationChannel.getName())) {
                notificationChannel.setName(b);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        return c;
    }

    static void a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.a(dialog, onCancelListener).a(((FragmentActivity) activity).e(), str);
            return;
        }
        c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void a(Context context, int i, String str, PendingIntent pendingIntent) {
        if (i == 18) {
            c(context);
        } else if (pendingIntent != null) {
            Notification build;
            int i2;
            CharSequence b = q.b(context, i);
            CharSequence d = q.d(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (g.a(context)) {
                ar.a(p.h());
                Notification.Builder style = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(b).setStyle(new BigTextStyle().bigText(d));
                if (g.b(context)) {
                    style.addAction(c.common_full_open_on_phone, resources.getString(d.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
                if (p.l() && p.l()) {
                    style.setChannelId(a(context, notificationManager));
                }
                build = style.build();
            } else {
                ao a = new ao(context).a(17301642).c(resources.getString(d.common_google_play_services_notification_ticker)).a(System.currentTimeMillis()).a(true).a(pendingIntent).a(b).b(d).b(true).a(new an().a(d));
                if (p.l() && p.l()) {
                    a.b(a(context, notificationManager));
                }
                build = a.a();
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    i2 = 10436;
                    k.zzbt.set(false);
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            if (str == null) {
                notificationManager.notify(i2, build);
            } else {
                notificationManager.notify(str, i2, build);
            }
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    @VisibleForTesting(otherwise = 2)
    private final String c() {
        String str;
        synchronized (c) {
            str = this.e;
        }
        return str;
    }

    public int a(Context context) {
        return super.a(context);
    }

    public Dialog a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return a((Context) activity, i, s.a(activity, b(activity, i, "d"), i2), onCancelListener);
    }

    public Dialog a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(q.c(activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @Nullable
    public PendingIntent a(Context context, int i, int i2) {
        return super.a(context, i, i2);
    }

    @Nullable
    public PendingIntent a(Context context, int i, int i2, @Nullable String str) {
        return super.a(context, i, i2, str);
    }

    @Nullable
    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        return connectionResult.a() ? connectionResult.d() : a(context, connectionResult.c(), 0);
    }

    @Nullable
    public GooglePlayServicesUpdatedReceiver a(Context context, i iVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver googlePlayServicesUpdatedReceiver = new GooglePlayServicesUpdatedReceiver(iVar);
        context.registerReceiver(googlePlayServicesUpdatedReceiver, intentFilter);
        googlePlayServicesUpdatedReceiver.a(context);
        if (a(context, "com.google.android.gms")) {
            return googlePlayServicesUpdatedReceiver;
        }
        iVar.a();
        googlePlayServicesUpdatedReceiver.a();
        return null;
    }

    public void a(Context context, int i) {
        a(context, i, null);
    }

    public void a(Context context, int i, String str) {
        a(context, i, str, a(context, i, 0, "n"));
    }

    public final boolean a(int i) {
        return super.a(i);
    }

    public boolean a(Activity activity, @NonNull LifecycleFragment lifecycleFragment, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = a((Context) activity, i, s.a(lifecycleFragment, b(activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public boolean a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = a(context, connectionResult);
        if (a == null) {
            return false;
        }
        a(context, connectionResult.c(), null, GoogleApiActivity.a(context, a, i));
        return true;
    }

    public int b(Context context) {
        return super.b(context);
    }

    public int b(Context context, int i) {
        return super.b(context, i);
    }

    @Nullable
    @Deprecated
    public Intent b(int i) {
        return super.b(i);
    }

    @Nullable
    public Intent b(Context context, int i, @Nullable String str) {
        return super.b(context, i, str);
    }

    public boolean b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public final String c(int i) {
        return super.c(i);
    }

    final void c(Context context) {
        new f(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public boolean c(Context context, int i) {
        return super.c(context, i);
    }
}
