package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.a;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.p;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class d {
    private static d a;
    private final Context b;
    private Bundle c;
    private Method d;
    private Method e;
    private final AtomicInteger f = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private d(Context context) {
        this.b = context.getApplicationContext();
    }

    @TargetApi(26)
    private final Notification a(CharSequence charSequence, String str, int i, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        Builder smallIcon = new Builder(this.b).setAutoCancel(true).setSmallIcon(i);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.d == null) {
                this.d = a("setChannelId");
            }
            if (this.d == null) {
                this.d = a("setChannel");
            }
            if (this.d == null) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel");
            } else {
                try {
                    this.d.invoke(smallIcon, new Object[]{str2});
                } catch (Throwable e) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
                } catch (Throwable e2) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e2);
                } catch (Throwable e22) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e22);
                } catch (Throwable e222) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e222);
                }
            }
        }
        return smallIcon.build();
    }

    private final Bundle a() {
        if (this.c != null) {
            return this.c;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return Bundle.EMPTY;
        }
        this.c = applicationInfo.metaData;
        return this.c;
    }

    static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    static String a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    @TargetApi(26)
    private static Method a(String str) {
        try {
            return Builder.class.getMethod(str, new Class[]{String.class});
        } catch (NoSuchMethodException e) {
        } catch (SecurityException e2) {
        }
        return null;
    }

    private static void a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    @TargetApi(26)
    private final boolean a(int i) {
        if (VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.b.getResources().getDrawable(i, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i);
            return false;
        } catch (NotFoundException e) {
            return false;
        }
    }

    static boolean a(Bundle bundle) {
        return "1".equals(a(bundle, "gcm.n.e")) || a(bundle, "gcm.n.icon") != null;
    }

    @Nullable
    static Uri b(@NonNull Bundle bundle) {
        Object a = a(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(a)) {
            a = a(bundle, "gcm.n.link");
        }
        return !TextUtils.isEmpty(a) ? Uri.parse(a) : null;
    }

    private final Integer b(String str) {
        Integer num = null;
        if (VERSION.SDK_INT < 21) {
            return num;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException e) {
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 54).append("Color ").append(str).append(" not valid. Notification will use default color.").toString());
            }
        }
        int i = a().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i == 0) {
            return num;
        }
        try {
            return Integer.valueOf(a.c(this.b, i));
        } catch (NotFoundException e2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return num;
        }
    }

    static String b(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    @TargetApi(26)
    private final String c(String str) {
        if (!p.l()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.b.getSystemService(NotificationManager.class);
        try {
            if (this.e == null) {
                this.e = notificationManager.getClass().getMethod("getNotificationChannel", new Class[]{String.class});
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.e.invoke(notificationManager, new Object[]{str}) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 122).append("Notification Channel requested (").append(str).append(") has not been created by the app. Manifest configuration, or default, value will be used.").toString());
            }
            Object string = a().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else {
                if (this.e.invoke(notificationManager, new Object[]{string}) != null) {
                    return string;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (this.e.invoke(notificationManager, new Object[]{"fcm_fallback_notification_channel"}) == null) {
                Object newInstance = Class.forName("android.app.NotificationChannel").getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE}).newInstance(new Object[]{"fcm_fallback_notification_channel", this.b.getString(c.fcm_fallback_notification_channel_label), Integer.valueOf(3)});
                notificationManager.getClass().getMethod("createNotificationChannel", new Class[]{r2}).invoke(notificationManager, new Object[]{newInstance});
            }
            return "fcm_fallback_notification_channel";
        } catch (Throwable e) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
            return null;
        } catch (Throwable e2) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e2);
            return null;
        } catch (Throwable e22) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e22);
            return null;
        } catch (Throwable e222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e222);
            return null;
        } catch (Throwable e2222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e2222);
            return null;
        } catch (Throwable e22222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e22222);
            return null;
        } catch (Throwable e222222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e222222);
            return null;
        } catch (Throwable e2222222) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e2222222);
            return null;
        }
    }

    static Object[] c(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String a = a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(a);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException e) {
            valueOf = "FirebaseMessaging";
            String valueOf3 = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_args");
            valueOf2 = (valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3)).substring(6);
            Log.w(valueOf, new StringBuilder((String.valueOf(valueOf2).length() + 41) + String.valueOf(a).length()).append("Malformed ").append(valueOf2).append(": ").append(a).append("  Default value will be used.").toString());
            return null;
        }
    }

    static String d(Bundle bundle) {
        Object a = a(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(a) ? a(bundle, "gcm.n.sound") : a;
    }

    private final String d(Bundle bundle, String str) {
        Object a = a(bundle, str);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String b = b(bundle, str);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        Resources resources = this.b.getResources();
        int identifier = resources.getIdentifier(b, "string", this.b.getPackageName());
        String valueOf;
        if (identifier == 0) {
            String str2 = "FirebaseMessaging";
            valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("_loc_key");
            valueOf2 = (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).substring(6);
            Log.w(str2, new StringBuilder((String.valueOf(valueOf2).length() + 49) + String.valueOf(b).length()).append(valueOf2).append(" resource not found: ").append(b).append(" Default value will be used.").toString());
            return null;
        }
        Object[] c = c(bundle, str);
        if (c == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, c);
        } catch (Throwable e) {
            valueOf = Arrays.toString(c);
            Log.w("FirebaseMessaging", new StringBuilder((String.valueOf(b).length() + 58) + String.valueOf(valueOf).length()).append("Missing format argument for ").append(b).append(": ").append(valueOf).append(" Default value will be used.").toString(), e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    final boolean c(android.os.Bundle r14) {
        /*
        r13 = this;
        r6 = 0;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r9 = 1;
        r10 = 0;
        r0 = "1";
        r1 = "gcm.n.noui";
        r1 = a(r14, r1);
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0015;
    L_0x0013:
        r0 = r9;
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = r13.b;
        r1 = "keyguard";
        r0 = r0.getSystemService(r1);
        r0 = (android.app.KeyguardManager) r0;
        r0 = r0.inKeyguardRestrictedInputMode();
        if (r0 != 0) goto L_0x0065;
    L_0x0025:
        r0 = com.google.android.gms.common.util.p.i();
        if (r0 != 0) goto L_0x0030;
    L_0x002b:
        r0 = 10;
        android.os.SystemClock.sleep(r0);
    L_0x0030:
        r1 = android.os.Process.myPid();
        r0 = r13.b;
        r2 = "activity";
        r0 = r0.getSystemService(r2);
        r0 = (android.app.ActivityManager) r0;
        r0 = r0.getRunningAppProcesses();
        if (r0 == 0) goto L_0x0065;
    L_0x0044:
        r2 = r0.iterator();
    L_0x0048:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0065;
    L_0x004e:
        r0 = r2.next();
        r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0;
        r3 = r0.pid;
        if (r3 != r1) goto L_0x0048;
    L_0x0058:
        r0 = r0.importance;
        r1 = 100;
        if (r0 != r1) goto L_0x0063;
    L_0x005e:
        r0 = r9;
    L_0x005f:
        if (r0 == 0) goto L_0x0067;
    L_0x0061:
        r0 = r10;
        goto L_0x0014;
    L_0x0063:
        r0 = r10;
        goto L_0x005f;
    L_0x0065:
        r0 = r10;
        goto L_0x005f;
    L_0x0067:
        r0 = "gcm.n.title";
        r1 = r13.d(r14, r0);
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x0083;
    L_0x0073:
        r0 = r13.b;
        r0 = r0.getApplicationInfo();
        r1 = r13.b;
        r1 = r1.getPackageManager();
        r1 = r0.loadLabel(r1);
    L_0x0083:
        r0 = "gcm.n.body";
        r2 = r13.d(r14, r0);
        r0 = "gcm.n.icon";
        r0 = a(r14, r0);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 != 0) goto L_0x01c1;
    L_0x0095:
        r3 = r13.b;
        r4 = r3.getResources();
        r3 = "drawable";
        r5 = r13.b;
        r5 = r5.getPackageName();
        r3 = r4.getIdentifier(r0, r3, r5);
        if (r3 == 0) goto L_0x0185;
    L_0x00a9:
        r5 = r13.a(r3);
        if (r5 == 0) goto L_0x0185;
    L_0x00af:
        r0 = "gcm.n.color";
        r0 = a(r14, r0);
        r4 = r13.b(r0);
        r0 = d(r14);
        r5 = android.text.TextUtils.isEmpty(r0);
        if (r5 == 0) goto L_0x01e9;
    L_0x00c3:
        r5 = r6;
    L_0x00c4:
        r0 = "gcm.n.click_action";
        r7 = a(r14, r0);
        r0 = android.text.TextUtils.isEmpty(r7);
        if (r0 != 0) goto L_0x0248;
    L_0x00d0:
        r0 = new android.content.Intent;
        r0.<init>(r7);
        r7 = r13.b;
        r7 = r7.getPackageName();
        r0.setPackage(r7);
        r7 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r7);
        r7 = r0;
    L_0x00e4:
        if (r7 != 0) goto L_0x0280;
    L_0x00e6:
        r0 = r6;
    L_0x00e7:
        r7 = com.google.firebase.messaging.FirebaseMessagingService.b(r14);
        if (r7 == 0) goto L_0x0312;
    L_0x00ed:
        r6 = new android.content.Intent;
        r7 = "com.google.firebase.messaging.NOTIFICATION_OPEN";
        r6.<init>(r7);
        a(r6, r14);
        r7 = "pending_intent";
        r6.putExtra(r7, r0);
        r0 = r13.b;
        r7 = r13.f;
        r7 = r7.incrementAndGet();
        r6 = com.google.firebase.iid.n.a(r0, r7, r6, r12);
        r0 = new android.content.Intent;
        r7 = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        r0.<init>(r7);
        a(r0, r14);
        r7 = r13.b;
        r8 = r13.f;
        r8 = r8.incrementAndGet();
        r7 = com.google.firebase.iid.n.a(r7, r8, r0, r12);
    L_0x011e:
        r0 = com.google.android.gms.common.util.p.l();
        if (r0 == 0) goto L_0x02c6;
    L_0x0124:
        r0 = r13.b;
        r0 = r0.getApplicationInfo();
        r0 = r0.targetSdkVersion;
        r8 = 25;
        if (r0 <= r8) goto L_0x02c6;
    L_0x0130:
        r0 = "gcm.n.android_channel_id";
        r0 = a(r14, r0);
        r8 = r13.c(r0);
        r0 = r13;
        r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8);
        r1 = r0;
    L_0x0140:
        r0 = "gcm.n.tag";
        r2 = a(r14, r0);
        r0 = "FirebaseMessaging";
        r3 = 3;
        r0 = android.util.Log.isLoggable(r0, r3);
        if (r0 == 0) goto L_0x0156;
    L_0x014f:
        r0 = "FirebaseMessaging";
        r3 = "Showing notification";
        android.util.Log.d(r0, r3);
    L_0x0156:
        r0 = r13.b;
        r3 = "notification";
        r0 = r0.getSystemService(r3);
        r0 = (android.app.NotificationManager) r0;
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 == 0) goto L_0x017f;
    L_0x0166:
        r2 = android.os.SystemClock.uptimeMillis();
        r4 = 37;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "FCM-Notification:";
        r4 = r5.append(r4);
        r2 = r4.append(r2);
        r2 = r2.toString();
    L_0x017f:
        r0.notify(r2, r10, r1);
        r0 = r9;
        goto L_0x0014;
    L_0x0185:
        r3 = "mipmap";
        r5 = r13.b;
        r5 = r5.getPackageName();
        r3 = r4.getIdentifier(r0, r3, r5);
        if (r3 == 0) goto L_0x0199;
    L_0x0193:
        r4 = r13.a(r3);
        if (r4 != 0) goto L_0x00af;
    L_0x0199:
        r3 = "FirebaseMessaging";
        r4 = java.lang.String.valueOf(r0);
        r4 = r4.length();
        r4 = r4 + 61;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Icon resource ";
        r4 = r5.append(r4);
        r0 = r4.append(r0);
        r4 = " not found. Notification will use default icon.";
        r0 = r0.append(r4);
        r0 = r0.toString();
        android.util.Log.w(r3, r0);
    L_0x01c1:
        r0 = r13.a();
        r3 = "com.google.firebase.messaging.default_notification_icon";
        r0 = r0.getInt(r3, r10);
        if (r0 == 0) goto L_0x01d3;
    L_0x01cd:
        r3 = r13.a(r0);
        if (r3 != 0) goto L_0x01db;
    L_0x01d3:
        r0 = r13.b;
        r0 = r0.getApplicationInfo();
        r0 = r0.icon;
    L_0x01db:
        if (r0 == 0) goto L_0x01e3;
    L_0x01dd:
        r3 = r13.a(r0);
        if (r3 != 0) goto L_0x01e6;
    L_0x01e3:
        r0 = 17301651; // 0x1080093 float:2.4979667E-38 double:8.5481514E-317;
    L_0x01e6:
        r3 = r0;
        goto L_0x00af;
    L_0x01e9:
        r5 = "default";
        r5 = r5.equals(r0);
        if (r5 != 0) goto L_0x0241;
    L_0x01f1:
        r5 = r13.b;
        r5 = r5.getResources();
        r7 = "raw";
        r8 = r13.b;
        r8 = r8.getPackageName();
        r5 = r5.getIdentifier(r0, r7, r8);
        if (r5 == 0) goto L_0x0241;
    L_0x0205:
        r5 = r13.b;
        r5 = r5.getPackageName();
        r7 = java.lang.String.valueOf(r5);
        r7 = r7.length();
        r7 = r7 + 24;
        r8 = java.lang.String.valueOf(r0);
        r8 = r8.length();
        r7 = r7 + r8;
        r8 = new java.lang.StringBuilder;
        r8.<init>(r7);
        r7 = "android.resource://";
        r7 = r8.append(r7);
        r5 = r7.append(r5);
        r7 = "/raw/";
        r5 = r5.append(r7);
        r0 = r5.append(r0);
        r0 = r0.toString();
        r5 = android.net.Uri.parse(r0);
        goto L_0x00c4;
    L_0x0241:
        r0 = 2;
        r5 = android.media.RingtoneManager.getDefaultUri(r0);
        goto L_0x00c4;
    L_0x0248:
        r7 = b(r14);
        if (r7 == 0) goto L_0x0264;
    L_0x024e:
        r0 = new android.content.Intent;
        r8 = "android.intent.action.VIEW";
        r0.<init>(r8);
        r8 = r13.b;
        r8 = r8.getPackageName();
        r0.setPackage(r8);
        r0.setData(r7);
        r7 = r0;
        goto L_0x00e4;
    L_0x0264:
        r0 = r13.b;
        r0 = r0.getPackageManager();
        r7 = r13.b;
        r7 = r7.getPackageName();
        r0 = r0.getLaunchIntentForPackage(r7);
        if (r0 != 0) goto L_0x027d;
    L_0x0276:
        r7 = "FirebaseMessaging";
        r8 = "No activity found to launch app";
        android.util.Log.w(r7, r8);
    L_0x027d:
        r7 = r0;
        goto L_0x00e4;
    L_0x0280:
        r0 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r7.addFlags(r0);
        r0 = new android.os.Bundle;
        r0.<init>(r14);
        com.google.firebase.messaging.FirebaseMessagingService.a(r0);
        r7.putExtras(r0);
        r0 = r0.keySet();
        r8 = r0.iterator();
    L_0x0298:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x02b8;
    L_0x029e:
        r0 = r8.next();
        r0 = (java.lang.String) r0;
        r11 = "gcm.n.";
        r11 = r0.startsWith(r11);
        if (r11 != 0) goto L_0x02b4;
    L_0x02ac:
        r11 = "gcm.notification.";
        r11 = r0.startsWith(r11);
        if (r11 == 0) goto L_0x0298;
    L_0x02b4:
        r7.removeExtra(r0);
        goto L_0x0298;
    L_0x02b8:
        r0 = r13.b;
        r8 = r13.f;
        r8 = r8.incrementAndGet();
        r0 = android.app.PendingIntent.getActivity(r0, r8, r7, r12);
        goto L_0x00e7;
    L_0x02c6:
        r0 = new android.support.v4.app.ao;
        r8 = r13.b;
        r0.<init>(r8);
        r0 = r0.a(r9);
        r0 = r0.a(r3);
        r3 = android.text.TextUtils.isEmpty(r1);
        if (r3 != 0) goto L_0x02de;
    L_0x02db:
        r0.a(r1);
    L_0x02de:
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 != 0) goto L_0x02f3;
    L_0x02e4:
        r0.b(r2);
        r1 = new android.support.v4.app.an;
        r1.<init>();
        r1 = r1.a(r2);
        r0.a(r1);
    L_0x02f3:
        if (r4 == 0) goto L_0x02fc;
    L_0x02f5:
        r1 = r4.intValue();
        r0.b(r1);
    L_0x02fc:
        if (r5 == 0) goto L_0x0301;
    L_0x02fe:
        r0.a(r5);
    L_0x0301:
        if (r6 == 0) goto L_0x0306;
    L_0x0303:
        r0.a(r6);
    L_0x0306:
        if (r7 == 0) goto L_0x030b;
    L_0x0308:
        r0.b(r7);
    L_0x030b:
        r0 = r0.a();
        r1 = r0;
        goto L_0x0140;
    L_0x0312:
        r7 = r6;
        r6 = r0;
        goto L_0x011e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.d.c(android.os.Bundle):boolean");
    }
}
