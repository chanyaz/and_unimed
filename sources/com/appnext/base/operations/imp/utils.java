package com.appnext.base.operations.imp;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.appnext.base.b;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.k;
import com.appnext.base.operations.c;
import java.util.ArrayList;
import java.util.List;

public class utils extends c {
    private static final String KEY = utils.class.getSimpleName();

    public utils(com.appnext.base.a.b.c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    private String bM() {
        PackageManager packageManager = d.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
        return resolveActivity.activityInfo == null ? null : resolveActivity.activityInfo.packageName;
    }

    private boolean bN() {
        Boolean valueOf = Boolean.valueOf(false);
        try {
            valueOf = Boolean.valueOf(f.i(d.getContext()));
        } catch (Throwable th) {
            b.a(th);
        }
        return valueOf.booleanValue();
    }

    private String bO() {
        try {
            PackageManager packageManager = d.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            return String.valueOf(packageManager.queryIntentActivities(intent, 0).size());
        } catch (Throwable th) {
            return "0";
        }
    }

    private String bP() {
        try {
            Display defaultDisplay = ((WindowManager) d.getContext().getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            int i = displayMetrics.widthPixels;
            return i + "x" + displayMetrics.heightPixels;
        } catch (Throwable th) {
            return "";
        }
    }

    private String bQ() {
        try {
            return "" + d.getContext().getResources().getDisplayMetrics().densityDpi;
        } catch (Throwable th) {
            return "";
        }
    }

    private String bR() {
        try {
            return "" + d.getContext().getResources().getConfiguration().fontScale;
        } catch (Throwable th) {
            return "";
        }
    }

    private String bS() {
        try {
            PackageManager packageManager = d.getContext().getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            return "" + packageManager.queryIntentActivities(intent, 0).size();
        } catch (Throwable th) {
            return "";
        }
    }

    private String bT() {
        boolean z = true;
        try {
            if (VERSION.SDK_INT < 17) {
                if (System.getInt(d.getContext().getContentResolver(), "airplane_mode_on", 0) == 0) {
                    z = false;
                }
                return String.valueOf(z);
            }
            if (Global.getInt(d.getContext().getContentResolver(), "airplane_mode_on", 0) == 0) {
                z = false;
            }
            return String.valueOf(z);
        } catch (Throwable th) {
            return "";
        }
    }

    private String bU() {
        try {
            AudioManager audioManager = (AudioManager) d.getContext().getSystemService("audio");
            return audioManager != null ? String.valueOf(audioManager.getRingerMode()) : "";
        } catch (Throwable th) {
            return "";
        }
    }

    private String getDeviceName() {
        Object obj = null;
        if (f.g(d.getContext().getApplicationContext(), "android.permission.BLUETOOTH")) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    obj = defaultAdapter.getName();
                }
            } catch (Throwable th) {
            }
        }
        return TextUtils.isEmpty(obj) ? Build.BRAND : obj;
    }

    protected String aX() {
        return utils.class.getSimpleName();
    }

    public void bC() {
    }

    protected boolean bF() {
        return true;
    }

    protected List<com.appnext.base.a.b.b> getData() {
        try {
            List<com.appnext.base.a.b.b> arrayList = new ArrayList();
            Object cA = f.cA();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "dos", cA, a.String.getType()));
            }
            cA = Build.MODEL;
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "dmod", cA, a.String.getType()));
            }
            cA = f.cB();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "slang", cA, a.String.getType()));
            }
            cA = f.h(d.getContext());
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "mop", cA, a.String.getType()));
            }
            cA = getDeviceName();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "dname", cA, a.String.getType()));
            }
            arrayList.add(new com.appnext.base.a.b.b(KEY, "duse", String.valueOf(bN()), a.Boolean.getType()));
            cA = k.cO();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "tzone", cA, a.String.getType()));
            }
            cA = bM();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "deflun", cA, a.String.getType()));
            }
            cA = bO();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "inslun", cA, a.String.getType()));
            }
            cA = bQ();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "dpi", cA, a.String.getType()));
            }
            cA = bP();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "res", cA, a.String.getType()));
            }
            cA = bR();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "fsc", cA, a.String.getType()));
            }
            cA = bS();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "noa", cA, a.Integer.getType()));
            }
            cA = bU();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "rmo", cA, a.Integer.getType()));
            }
            cA = bT();
            if (!TextUtils.isEmpty(cA)) {
                arrayList.add(new com.appnext.base.a.b.b(KEY, "flm", cA, a.Boolean.getType()));
            }
            return arrayList.size() == 0 ? null : arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean hasPermission() {
        return bE();
    }
}
