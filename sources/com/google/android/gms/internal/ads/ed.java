package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.p;
import java.util.Locale;

public final class ed {
    private String A;
    private boolean B;
    private int a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private String g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private double m;
    private boolean n;
    private String o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private boolean t;
    private boolean u;
    private String v;
    private String w;
    private float x;
    private int y;
    private int z;

    public ed(Context context) {
        boolean z = true;
        PackageManager packageManager = context.getPackageManager();
        a(context);
        b(context);
        c(context);
        Locale locale = Locale.getDefault();
        this.q = a(packageManager, "geo:0,0?q=donuts") != null;
        if (a(packageManager, "http://www.google.com") == null) {
            z = false;
        }
        this.r = z;
        this.s = locale.getCountry();
        akc.a();
        this.t = kb.a();
        this.u = g.c(context);
        this.v = locale.getLanguage();
        this.w = b(context, packageManager);
        this.A = a(context, packageManager);
        Resources resources = context.getResources();
        if (resources != null) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (displayMetrics != null) {
                this.x = displayMetrics.density;
                this.y = displayMetrics.widthPixels;
                this.z = displayMetrics.heightPixels;
            }
        }
    }

    public ed(Context context, ec ecVar) {
        context.getPackageManager();
        a(context);
        b(context);
        c(context);
        this.o = Build.FINGERPRINT;
        this.p = Build.DEVICE;
        boolean z = p.c() && ani.a(context);
        this.B = z;
        this.q = ecVar.b;
        this.r = ecVar.c;
        this.s = ecVar.e;
        this.t = ecVar.f;
        this.u = ecVar.g;
        this.v = ecVar.j;
        this.w = ecVar.k;
        this.A = ecVar.l;
        this.x = ecVar.s;
        this.y = ecVar.t;
        this.z = ecVar.u;
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            au.i().a(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static String a(Context context, PackageManager packageManager) {
        try {
            PackageInfo b = c.b(context).b("com.android.vending", 128);
            if (b == null) {
                return null;
            }
            int i = b.versionCode;
            String str = b.packageName;
            return new StringBuilder(String.valueOf(str).length() + 12).append(i).append(".").append(str).toString();
        } catch (Exception e) {
            return null;
        }
    }

    private final void a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.a = audioManager.getMode();
                this.b = audioManager.isMusicActive();
                this.c = audioManager.isSpeakerphoneOn();
                this.d = audioManager.getStreamVolume(3);
                this.e = audioManager.getRingerMode();
                this.f = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                au.i().a(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.a = -2;
        this.b = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    private static String b(Context context, PackageManager packageManager) {
        ResolveInfo a = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null) {
            return null;
        }
        ActivityInfo activityInfo = a.activityInfo;
        if (activityInfo == null) {
            return null;
        }
        try {
            PackageInfo b = c.b(context).b(activityInfo.packageName, 0);
            if (b == null) {
                return null;
            }
            int i = b.versionCode;
            String str = activityInfo.packageName;
            return new StringBuilder(String.valueOf(str).length() + 12).append(i).append(".").append(str).toString();
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @TargetApi(16)
    private final void b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.g = telephonyManager.getNetworkOperator();
        this.i = telephonyManager.getNetworkType();
        this.j = telephonyManager.getPhoneType();
        this.h = -2;
        this.k = false;
        this.l = -1;
        au.e();
        if (ht.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.h = activeNetworkInfo.getType();
                this.l = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.h = -1;
            }
            if (VERSION.SDK_INT >= 16) {
                this.k = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void c(Context context) {
        boolean z = false;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.n = z;
            return;
        }
        this.m = -1.0d;
        this.n = false;
    }

    public final ec a() {
        return new ec(this.a, this.q, this.r, this.g, this.s, this.t, this.u, this.b, this.c, this.v, this.w, this.A, this.d, this.h, this.i, this.j, this.e, this.f, this.x, this.y, this.z, this.m, this.n, this.k, this.l, this.o, this.B, this.p);
    }
}
