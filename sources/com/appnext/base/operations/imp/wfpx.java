package com.appnext.base.operations.imp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.appnext.base.a.b.c;
import com.appnext.base.b;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.g;
import com.appnext.base.b.h;
import com.appnext.base.b.l;
import com.appnext.base.operations.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class wfpx extends a {
    private String hd;
    private Context mContext = d.getContext();

    public wfpx(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected String a(ScanResult scanResult) {
        return scanResult.SSID;
    }

    protected Object al(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ssid", str);
        } catch (Throwable th) {
            b.a(th);
        }
        return jSONObject;
    }

    @SuppressLint({"MissingPermission"})
    public void bB() {
        try {
            if (hasPermission()) {
                g.cC().b(new Runnable() {
                    public void run() {
                        try {
                            WifiManager wifiManager = (WifiManager) wfpx.this.mContext.getApplicationContext().getSystemService("wifi");
                            if (wfpx.this.hasPermission() && wifiManager.isWifiEnabled()) {
                                List<ScanResult> scanResults = wifiManager.getScanResults();
                                if (scanResults == null || scanResults.isEmpty()) {
                                    wfpx.this.hd = null;
                                } else {
                                    Set hashSet = new HashSet();
                                    JSONArray jSONArray = new JSONArray();
                                    for (ScanResult scanResult : scanResults) {
                                        String a = wfpx.this.a(scanResult);
                                        int calculateSignalLevel = WifiManager.calculateSignalLevel(scanResult.level, 100);
                                        if (!hashSet.contains(a) && wfpx.this.e(calculateSignalLevel).booleanValue()) {
                                            l.k(getClass().getSimpleName(), "SSID: " + scanResult.SSID + " BSSID: " + scanResult.BSSID + " Level: " + calculateSignalLevel + " Hash: " + h.cD().aA(scanResult.BSSID));
                                            hashSet.add(a);
                                            jSONArray.put(wfpx.this.al(a));
                                        }
                                    }
                                    if (jSONArray.length() == 0) {
                                        wfpx.this.hd = null;
                                    }
                                    wfpx.this.hd = jSONArray.toString();
                                }
                            } else {
                                wfpx.this.hd = null;
                            }
                            wfpx.this.b();
                        } catch (Throwable th) {
                            b.a(th);
                        }
                    }
                }, 20000);
            } else {
                com.appnext.base.operations.d.bG().a(this);
            }
        } catch (Throwable th) {
            b.a(th);
            this.hd = null;
        }
    }

    public void bC() {
    }

    protected com.appnext.base.b.c.a bD() {
        return com.appnext.base.b.c.a.JSONArray;
    }

    protected Boolean e(int i) {
        return Boolean.valueOf(true);
    }

    protected List<com.appnext.base.a.b.b> getData() {
        if (this.hd.isEmpty()) {
            return null;
        }
        List<com.appnext.base.a.b.b> arrayList = new ArrayList();
        arrayList.add(new com.appnext.base.a.b.b(bw().getKey(), this.hd, com.appnext.base.b.c.a.JSONArray.getType()));
        return arrayList;
    }

    public boolean hasPermission() {
        return (VERSION.SDK_INT != 23 || f.g(d.getContext(), "android.permission.ACCESS_FINE_LOCATION")) ? f.g(this.mContext.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE") : false;
    }
}
