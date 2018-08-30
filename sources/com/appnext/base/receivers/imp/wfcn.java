package com.appnext.base.receivers.imp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Handler;
import android.text.TextUtils;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.e;
import com.appnext.base.b.f;
import com.appnext.base.b.i;
import com.appnext.base.b.l;
import com.appnext.base.receivers.b;

public class wfcn extends b {
    public static final String he = wfcn.class.getSimpleName();
    public static final String iM = "LAST_WIFI_CONNECTION";
    public static final String iN = (he + "IS_CONNENTED");
    private static final String iO = "<unknown ssid>";

    public IntentFilter getBRFilter() {
        try {
            return !hasPermission() ? null : new IntentFilter("android.net.wifi.STATE_CHANGE");
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return null;
        }
    }

    public boolean hasPermission() {
        return f.g(d.getContext().getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE");
    }

    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
            l.k("Receiver", he);
            if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                c av = e.cy().av(he);
                if (av != null && !com.appnext.base.b.c.jy.equalsIgnoreCase(av.ba())) {
                    if (hasPermission()) {
                        Boolean valueOf;
                        String str = "";
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null && networkInfo.isConnected() && networkInfo.getDetailedState() == DetailedState.CONNECTED) {
                            valueOf = Boolean.valueOf(true);
                            str = networkInfo.getExtraInfo();
                            if (!TextUtils.isEmpty(str) && !str.equals(iO)) {
                                str = str.replace("\"", "");
                                i.cE().putString(iM, str);
                            } else {
                                return;
                            }
                        } else if (networkInfo.getDetailedState() == DetailedState.DISCONNECTED) {
                            valueOf = Boolean.valueOf(false);
                            str = i.cE().getString(iM, "");
                        } else {
                            return;
                        }
                        final boolean booleanValue = valueOf.booleanValue();
                        i.cE().putBoolean(iN, valueOf.booleanValue());
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                wfcn.this.a(wfcn.he, wfcn.this.a(Boolean.valueOf(booleanValue), str), a.JSONArray);
                            }
                        }, 15000);
                        return;
                    }
                    l.m(he, "No permission granted android.permission.ACCESS_NETWORK_STATE");
                }
            }
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }
}
