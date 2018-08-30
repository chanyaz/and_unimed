package com.appnext.base.receivers.imp;

import android.text.TextUtils;
import com.appnext.base.a.a;
import com.appnext.base.b;
import com.appnext.base.b.a.c;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.i;
import com.appnext.base.b.k;
import com.appnext.base.b.l;
import com.google.android.gms.location.DetectedActivity;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class dmstat implements c, com.appnext.base.receivers.c {
    private static final int MINUTE = 60000;
    protected static final String TAG = dmstat.class.getSimpleName();
    private static final String hV = "threshold";
    private static final String hW = "wpuld";
    private static final String hX = "wpulw";
    private static final String hY = "last_dmstat";
    private static final String hZ = "value";
    private static final String ia = "accuracy";
    private static final int ib = 75;
    private static final int ic = 15;
    private static final int id = 35;
    private static final int ie = 2;
    private com.appnext.base.a.b.c gP = a.aM().aR().ac(TAG);
    private int if = 75;
    private int ig = 15;
    private int ih = 35;
    private com.appnext.base.b.a ii = null;

    class DetectedActivityComparator implements Comparator<DetectedActivity> {
        private DetectedActivityComparator() {
        }

        /* synthetic */ DetectedActivityComparator(dmstat dmstat, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: a */
        public int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            return detectedActivity.b() > detectedActivity2.b() ? 1 : 0;
        }
    }

    private String a(DetectedActivity detectedActivity, List<DetectedActivity> list) {
        if (detectedActivity == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a(detectedActivity.a(), detectedActivity.b()));
        if (list != null && list.size() > 0) {
            for (int i = 0; i < 1; i++) {
                DetectedActivity detectedActivity2 = (DetectedActivity) list.get(i);
                if (detectedActivity2 != null && detectedActivity.b() - detectedActivity2.b() <= 10) {
                    jSONArray.put(a(detectedActivity2.a(), detectedActivity2.b()));
                }
            }
        }
        String string = i.cE().getString(hY, null);
        i.cE().putString(hY, jSONArray.toString());
        if (string == null) {
            return jSONArray.toString();
        }
        try {
            JSONArray jSONArray2 = new JSONArray(string);
            if (jSONArray2.length() != jSONArray.length()) {
                return jSONArray.toString();
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (jSONArray2.getJSONObject(i2).getInt(hZ) != jSONArray.getJSONObject(i2).getInt(hZ)) {
                    return jSONArray.toString();
                }
            }
            return null;
        } catch (Throwable th) {
            return jSONArray.toString();
        }
    }

    private JSONObject a(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(hZ, i);
            jSONObject.put(ia, i2);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void ao(String str) {
        if (!TextUtils.isEmpty(str)) {
            k.d(TAG, str, com.appnext.base.b.c.a.JSONArray);
        }
    }

    private void g(List<DetectedActivity> list) {
        Iterator listIterator = list.listIterator();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (listIterator.hasNext()) {
            DetectedActivity detectedActivity = (DetectedActivity) listIterator.next();
            int a = detectedActivity.a();
            if (detectedActivity.b() > this.ig && (a == 0 || a == 1)) {
                z3 = true;
            }
            if (detectedActivity.b() > this.ih && (a == 7 || a == 8)) {
                z2 = true;
            }
            boolean z4 = (detectedActivity.b() == 100 && a == 3) ? true : z;
            if (z2 || (z4 && !z3)) {
                k.e(com.appnext.base.b.c.jN, String.valueOf(false), com.appnext.base.b.c.a.Boolean);
                return;
            }
            if (z3) {
                k.e(com.appnext.base.b.c.jN, String.valueOf(true), com.appnext.base.b.c.a.Boolean);
            }
            z = z4;
        }
    }

    public void bB() {
        try {
            if (hasPermission()) {
                synchronized (this) {
                    long longValue;
                    try {
                        longValue = Long.valueOf(this.gP.bb()).longValue() * 60000;
                    } catch (Throwable th) {
                        longValue = 600000;
                    }
                    this.ii = new com.appnext.base.b.a();
                    this.ii.a((c) this);
                    this.ii.b(longValue);
                }
            }
        } catch (Throwable th2) {
            b.a(th2);
        }
    }

    public void bC() {
        synchronized (this) {
            if (this.ii != null) {
                this.ii.a(null);
                this.ii.stop();
                this.ii = null;
            }
        }
    }

    public void h(List<DetectedActivity> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    DetectedActivity detectedActivity;
                    if (this.gP == null) {
                        this.if = 75;
                        this.ig = 15;
                        this.ih = 35;
                    } else {
                        this.if = this.gP.b(hV, 75);
                        this.ig = this.gP.b(hW, 15);
                        this.ih = this.gP.b(hX, 35);
                    }
                    Collections.sort(list, new DetectedActivityComparator(this, null));
                    Iterator listIterator = list.listIterator();
                    while (listIterator.hasNext()) {
                        detectedActivity = (DetectedActivity) listIterator.next();
                        int a = detectedActivity.a();
                        if (detectedActivity.b() < this.if || !(a == 0 || a == 3 || a == 1 || a == 7 || a == 8)) {
                            listIterator.remove();
                        }
                    }
                    g(list);
                    if (list.size() != 0) {
                        detectedActivity = (DetectedActivity) list.get(0);
                        list.remove(0);
                        final String a2 = a(detectedActivity, (List) list);
                        new Thread(new Runnable() {
                            public void run() {
                                dmstat.this.ao(a2);
                            }
                        }).start();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                l.n(TAG, th.toString());
                return;
            } finally {
                new Thread(/* anonymous class already generated */).start();
            }
        }
        new Thread(/* anonymous class already generated */).start();
    }

    public boolean hasPermission() {
        return f.g(d.getContext(), "com.google.android.gms.permission.ACTIVITY_RECOGNITION");
    }

    public void onError(String str) {
    }

    public boolean register() {
        bB();
        return true;
    }

    public void unregister() {
        bC();
    }
}
