package com.appnext.base.operations.imp;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.appnext.base.b;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.g;
import com.appnext.base.b.h;
import com.appnext.base.b.i;
import com.appnext.base.b.j;
import com.appnext.base.b.j.c;
import com.appnext.base.b.k;
import com.appnext.base.b.l;
import com.appnext.base.operations.a;
import com.appnext.base.receivers.imp.wfcn;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class wpul extends a implements c {
    private static final String hA = "ext_range";
    private static final long hB = 600000;
    private static final String he = wpul.class.getSimpleName();
    private static WifiManager ho = null;
    private static final String hq = (he + "LocationCurrentLocation");
    private static final String hs = (he + "DB_Semaphore");
    private static final String hw = "level";
    private static final String hx = "level_local";
    private static final String hy = "level_local_con";
    private static final String hz = "level_local_ext";
    private j gZ = null;
    private List<ScanResult> hC;
    private boolean hD = false;
    private String hd = null;
    private WifiScanAvailable hp;
    private boolean hr = false;
    private final String ht = (he + "_last_scan_results");
    private final String hu = (he + "_last_sent_scan_results");
    private final String hv = (he + "_is_in_place");

    class LocationModel {
        private double hF;
        private double hG;

        public LocationModel(double d, double d2) {
            this.hF = d;
            this.hG = d2;
        }

        public double ca() {
            return this.hF;
        }

        public double cb() {
            return this.hG;
        }
    }

    class WifiScanAvailable extends BroadcastReceiver {
        private WifiScanAvailable() {
        }

        /* synthetic */ WifiScanAvailable(wpul wpul, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onReceive(Context context, Intent intent) {
            try {
                d.getContext().unregisterReceiver(wpul.this.hp);
                if (!wpul.this.hD) {
                    wpul.this.hD = true;
                    g.cC().b(new Runnable() {
                        public void run() {
                            try {
                                wpul.this.bW();
                            } catch (Throwable th) {
                                k.e(wpul.hs, String.valueOf(false), com.appnext.base.b.c.a.Boolean);
                                b.a(th);
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                b.a(th);
            }
        }
    }

    public wpul(com.appnext.base.a.b.c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    private String a(Location location, JSONArray jSONArray, boolean z, boolean z2) {
        int i = 1;
        try {
            JSONObject jSONObject = new JSONObject();
            double d = 1000.1d;
            jSONObject.put(i.ki, location != null ? location.getLatitude() : 1000.1d);
            String str = "long";
            if (location != null) {
                d = location.getLongitude();
            }
            jSONObject.put(str, d);
            jSONObject.put("acc", location != null ? (int) location.getAccuracy() : 0);
            if (z2) {
                jSONObject.put("dnv", 1);
            }
            jSONObject.put("wl", jSONArray);
            String str2 = "wpxt";
            if (!z) {
                i = 0;
            }
            jSONObject.put(str2, i);
            return jSONObject.toString();
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }

    private String a(Set<String> set) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (String append : set) {
            stringBuilder.append(append);
            if (i != set.size()) {
                stringBuilder.append(",");
                i++;
            }
        }
        return stringBuilder.toString();
    }

    private void a(Location location, String str) {
        k.e(str + "Lat", String.valueOf(location.getLatitude()), com.appnext.base.b.c.a.Double);
        k.e(str + "Long", String.valueOf(location.getLongitude()), com.appnext.base.b.c.a.Double);
    }

    private void a(Location location, List<ScanResult> list, boolean z, boolean z2) {
        try {
            int b = bw().b(hw, 6);
            JSONArray jSONArray = new JSONArray();
            if (!(list == null || list.isEmpty())) {
                Set hashSet = new HashSet();
                for (ScanResult scanResult : list) {
                    String b2 = b(scanResult);
                    if (!hashSet.contains(b2) && WifiManager.calculateSignalLevel(scanResult.level, 100) >= b) {
                        hashSet.add(b2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bssid", scanResult.BSSID);
                        jSONObject.put("ssid", scanResult.SSID);
                        jSONObject.put("strength", scanResult.level);
                        if (VERSION.SDK_INT >= 17) {
                            jSONObject.put("age", (int) (((SystemClock.elapsedRealtime() * 1000) - scanResult.timestamp) / 1000000));
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            }
            this.hd = a(location, jSONArray, z, z2);
            b();
        } catch (Throwable th) {
        }
    }

    private boolean a(LocationModel locationModel, LocationModel locationModel2) {
        if (locationModel != null && locationModel2 == null) {
            return true;
        }
        try {
            float[] fArr = new float[3];
            int b = bw().b(hA, 150);
            Location.distanceBetween(locationModel2.ca(), locationModel2.cb(), locationModel.ca(), locationModel.cb(), fArr);
            if (Math.abs(fArr[0]) > ((float) b)) {
                return true;
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return false;
    }

    private boolean a(Set<String> set, String str) {
        if (set != null) {
            try {
                if (set.size() != 0) {
                    Set am = am(str);
                    if (am == null || am.size() == 0) {
                        return false;
                    }
                    int i = 0;
                    for (String trim : set) {
                        i = am.contains(trim.trim()) ? i + 1 : i;
                    }
                    if (i != 0) {
                        if (((double) (((float) i) / ((float) am.size()))) < 0.75d) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private Set<String> am(String str) {
        try {
            Object a = k.a(str, com.appnext.base.b.c.a.Set);
            return (a == null || !(a instanceof Set)) ? null : (Set) a;
        } catch (Throwable th) {
            return null;
        }
    }

    private LocationModel an(String str) {
        try {
            Object a = k.a(str + "Long", com.appnext.base.b.c.a.Double);
            if (a == null || !(a instanceof Double)) {
                return null;
            }
            double doubleValue = ((Double) a).doubleValue();
            a = k.a(str + "Lat", com.appnext.base.b.c.a.Double);
            if (a == null || !(a instanceof Double)) {
                return null;
            }
            return new LocationModel(((Double) a).doubleValue(), doubleValue);
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    private String b(ScanResult scanResult) {
        try {
            return h.cD().aA(scanResult.BSSID);
        } catch (Throwable th) {
            return "";
        }
    }

    private void b(Location location) {
        try {
            if (bY()) {
                bC();
                return;
            }
            d(true);
            a(location, this.hC, false, false);
            if (location != null) {
                a(location, hq);
            }
            c(f(this.hC));
            bC();
        } catch (Throwable th) {
            b.a(th);
            bC();
        }
    }

    private void b(Set<String> set) {
        k.e(this.ht, a((Set) set), com.appnext.base.b.c.a.Set);
    }

    private boolean b(Set<String> set, String str) {
        if (set != null) {
            try {
                if (set.size() != 0) {
                    Set am = am(str);
                    if (am == null || am.size() == 0) {
                        return false;
                    }
                    int i = 0;
                    for (String trim : set) {
                        i = am.contains(trim.trim()) ? i + 1 : i;
                    }
                    if (i != 0) {
                        if (((double) (((float) i) / ((float) am.size()))) >= 0.15d) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private Boolean bV() {
        try {
            Object a = k.a(com.appnext.base.b.c.jN, com.appnext.base.b.c.a.Boolean);
            if (a != null && (a instanceof Boolean)) {
                return (Boolean) a;
            }
        } catch (Throwable th) {
        }
        return Boolean.valueOf(false);
    }

    private void bW() {
        try {
            this.hC = ho.getScanResults();
            if (this.hC == null) {
                bC();
                return;
            }
            boolean bY = bY();
            int b = bw().b(hx, 70);
            if (i.cE().getBoolean(wfcn.iN, false)) {
                if (bY) {
                    bC();
                    return;
                }
                b = bw().b(hy, 50);
            }
            int b2 = bY ? bw().b(hz, 25) : b;
            Iterator listIterator = this.hC.listIterator();
            while (listIterator.hasNext()) {
                if (WifiManager.calculateSignalLevel(((ScanResult) listIterator.next()).level, 100) <= b2) {
                    listIterator.remove();
                }
            }
            if (this.hC.size() == 0) {
                bC();
                return;
            }
            Set f = f(this.hC);
            Location cG;
            j jVar;
            if (bY) {
                if (!b(f, this.hu)) {
                    bC();
                } else if (bX()) {
                    cG = j.cG();
                    if (d(cG)) {
                        jVar = new j();
                        jVar.a((c) this);
                        jVar.init();
                        return;
                    }
                    c(cG);
                } else {
                    c(null);
                }
            } else if (bV().booleanValue()) {
                bC();
            } else {
                l.k(he, "Searching for new location");
                boolean a = a(f, this.ht);
                b(f);
                if (!a) {
                    bC();
                } else if (bX()) {
                    cG = j.cG();
                    if (d(cG)) {
                        jVar = new j();
                        jVar.a((c) this);
                        jVar.init();
                        return;
                    }
                    b(cG);
                } else {
                    b(null);
                }
            }
        } catch (Throwable th) {
            k.e(hs, String.valueOf(false), com.appnext.base.b.c.a.Boolean);
            l.k(he, th.getMessage());
        }
    }

    private boolean bX() {
        try {
            return !f.g(d.getContext(), "android.permission.ACCESS_FINE_LOCATION") ? false : ((LocationManager) d.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean bY() {
        try {
            Object a = k.a(this.hv, com.appnext.base.b.c.a.Boolean);
            return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    private void c(Location location) {
        if (location != null) {
            try {
                if (!a(new LocationModel(location.getLatitude(), location.getLongitude()), an(hq))) {
                    Set<String> am = am(this.hu);
                    Set f = f(this.hC);
                    a(location, this.hC, false, true);
                    if (am != null) {
                        for (String add : am) {
                            f.add(add);
                        }
                        c(f);
                    }
                    bC();
                    return;
                }
            } catch (Throwable th) {
                b.a(th);
                bC();
                return;
            }
        }
        d(false);
        a(location, this.hC, true, false);
        bC();
    }

    private void c(Set<String> set) {
        k.e(this.hu, a((Set) set), com.appnext.base.b.c.a.Set);
    }

    private void d(boolean z) {
        k.e(this.hv, String.valueOf(z), com.appnext.base.b.c.a.Boolean);
    }

    private boolean d(Location location) {
        return location == null || location.getAccuracy() > 70.0f || System.currentTimeMillis() - location.getTime() > bw().a("timeout", (long) hB);
    }

    private Set<String> f(List<ScanResult> list) {
        if (list == null) {
            return null;
        }
        try {
            Set<String> hashSet = new HashSet();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                CharSequence charSequence = ((ScanResult) list.get(i)).SSID;
                if (!TextUtils.isEmpty(charSequence)) {
                    hashSet.add(charSequence);
                }
            }
            return hashSet;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public void a(final Location location) {
        try {
            if (!this.hr) {
                this.hr = true;
                if (this.gZ != null) {
                    this.gZ.a(null);
                    this.gZ.cF();
                    this.gZ = null;
                }
                g.cC().b(new Runnable() {
                    public void run() {
                        try {
                            if (wpul.this.bY()) {
                                wpul.this.c(location);
                            } else {
                                wpul.this.b(location);
                            }
                        } catch (Throwable th) {
                            k.e(wpul.hs, String.valueOf(false), com.appnext.base.b.c.a.Boolean);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            k.e(hs, String.valueOf(false), com.appnext.base.b.c.a.Boolean);
        }
    }

    @SuppressLint({"all"})
    public void bB() {
        try {
            l.k(he, "strart operation");
            if (hasPermission()) {
                Object a = k.a(hs, com.appnext.base.b.c.a.Boolean);
                if (a != null && (a instanceof Boolean) && ((Boolean) a).booleanValue()) {
                    bC();
                    return;
                }
                k.e(hs, String.valueOf(true), com.appnext.base.b.c.a.Boolean);
                ho = (WifiManager) d.getContext().getApplicationContext().getSystemService("wifi");
                if (ho.isWifiEnabled()) {
                    this.hp = new WifiScanAvailable(this, null);
                    d.getContext().registerReceiver(this.hp, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
                    Date date = new Date();
                    ho.startScan();
                    return;
                }
                bC();
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }

    public void bC() {
        try {
            synchronized (this) {
                if (this.gZ != null) {
                    this.gZ.a(null);
                    this.gZ.cF();
                    this.gZ = null;
                }
            }
            k.e(hs, String.valueOf(false), com.appnext.base.b.c.a.Boolean);
        } catch (Throwable th) {
            try {
                b.a(th);
            } finally {
                com.appnext.base.b.c.a aVar = null;
                k.e(hs, String.valueOf(false), com.appnext.base.b.c.a.Boolean);
            }
        }
    }

    protected com.appnext.base.b.c.a bD() {
        return com.appnext.base.b.c.a.JSONObject;
    }

    protected List<com.appnext.base.a.b.b> getData() {
        if (TextUtils.isEmpty(this.hd)) {
            return null;
        }
        List<com.appnext.base.a.b.b> arrayList = new ArrayList();
        arrayList.add(new com.appnext.base.a.b.b(wpul.class.getSimpleName(), this.hd, com.appnext.base.b.c.a.JSONObject.getType()));
        return arrayList;
    }

    public boolean hasPermission() {
        return (VERSION.SDK_INT != 23 || f.g(d.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && f.g(d.getContext().getApplicationContext(), "android.permission.ACCESS_WIFI_STATE") && f.g(d.getContext().getApplicationContext(), "android.permission.CHANGE_WIFI_STATE");
    }

    public void onError(String str) {
        try {
            g.cC().b(new Runnable() {
                public void run() {
                    try {
                        if (wpul.this.bY()) {
                            wpul.this.c(null);
                        } else {
                            wpul.this.b(null);
                        }
                    } catch (Throwable th) {
                        k.e(wpul.hs, String.valueOf(false), com.appnext.base.b.c.a.Boolean);
                    }
                }
            });
        } catch (Throwable th) {
        }
    }
}
