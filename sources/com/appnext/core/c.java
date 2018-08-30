package com.appnext.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class c {
    private static int kG = 200;
    private final HashMap<Ad, a> kH = new HashMap();

    public interface a {
        <T> void a(T t);

        void error(String str);
    }

    private long a(Ad ad, String str) {
        return Long.valueOf(d(ad).get(str)).longValue();
    }

    private AppnextAd a(AppnextAd appnextAd, AppnextAd appnextAd2) {
        return appnextAd.getRevenueType().equals(appnextAd2.getRevenueType()) ? Float.parseFloat(appnextAd.getRevenueRate()) < Float.parseFloat(appnextAd2.getRevenueRate()) ? appnextAd2 : appnextAd : appnextAd.getRevenueType().equals("cpc") ? appnextAd : appnextAd2;
    }

    private AppnextAd b(ArrayList<AppnextAd> arrayList, AppnextAd appnextAd) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AppnextAd appnextAd2 = (AppnextAd) it.next();
            if (appnextAd2.getAdPackage().equals(appnextAd.getAdPackage())) {
                return appnextAd2;
            }
        }
        return null;
    }

    private void b(Context context, Ad ad, String str, a aVar, boolean z) {
        final Ad ad2 = ad;
        final Context context2 = context;
        final a aVar2 = aVar;
        final String str2 = str;
        final boolean z2 = z;
        new Thread() {
            /* JADX WARNING: Missing block: B:21:?, code:
            r0 = new java.util.ArrayList();
            r2 = r8.kJ.a(r3, r2, r5, r0);
            com.appnext.core.g.X("AdsManager request url: " + r2);
            r0 = com.appnext.core.g.a(r2, r0, r8.kJ.o());
            com.appnext.core.g.X(r0);
     */
            /* JADX WARNING: Missing block: B:24:0x00c6, code:
            if (r0.equals("{}") != false) goto L_0x00d0;
     */
            /* JADX WARNING: Missing block: B:26:0x00ce, code:
            if (r8.kJ.h(r0) == false) goto L_0x0141;
     */
            /* JADX WARNING: Missing block: B:27:0x00d0, code:
            r8.kJ.a(com.appnext.core.AppnextError.NO_ADS, r0, r2);
     */
            /* JADX WARNING: Missing block: B:35:0x0106, code:
            r0 = move-exception;
     */
            /* JADX WARNING: Missing block: B:36:0x0107, code:
            com.appnext.core.g.c(r0);
            r8.kJ.a(com.appnext.core.AppnextError.TIMEOUT, com.appnext.core.g.b(r0), r2, 0);
     */
            /* JADX WARNING: Missing block: B:37:0x011a, code:
            r0 = move-exception;
     */
            /* JADX WARNING: Missing block: B:38:0x011b, code:
            com.appnext.core.g.c(r0);
            r8.kJ.a(com.appnext.core.AppnextError.CONNECTION_ERROR, com.appnext.core.g.b(r0), r2, 0);
     */
            /* JADX WARNING: Missing block: B:39:0x012e, code:
            r0 = move-exception;
     */
            /* JADX WARNING: Missing block: B:40:0x012f, code:
            com.appnext.core.g.c(r0);
            r8.kJ.a(com.appnext.core.AppnextError.INTERNAL_ERROR, com.appnext.core.g.b(r0), r2);
     */
            /* JADX WARNING: Missing block: B:42:?, code:
            r2 = r8.kJ.a(r3, r2, r0, com.appnext.core.c.V());
     */
            /* JADX WARNING: Missing block: B:43:0x014f, code:
            if (r2 != null) goto L_0x016f;
     */
            /* JADX WARNING: Missing block: B:45:?, code:
            r8.kJ.a(com.appnext.core.AppnextError.NO_ADS, r0, r2);
     */
            /* JADX WARNING: Missing block: B:46:0x015c, code:
            r0 = move-exception;
     */
            /* JADX WARNING: Missing block: B:47:0x015d, code:
            com.appnext.core.g.c(r0);
            r8.kJ.a(com.appnext.core.AppnextError.INTERNAL_ERROR, com.appnext.core.g.b(r0), r2);
     */
            /* JADX WARNING: Missing block: B:49:0x0173, code:
            if (r2.size() != 0) goto L_0x0180;
     */
            /* JADX WARNING: Missing block: B:50:0x0175, code:
            r8.kJ.b(com.appnext.core.AppnextError.NO_ADS, r2);
     */
            /* JADX WARNING: Missing block: B:51:0x0180, code:
            ((com.appnext.core.a) com.appnext.core.c.a(r8.kJ).get(r2)).h(r2);
     */
            /* JADX WARNING: Missing block: B:52:0x0193, code:
            if (r6 == false) goto L_0x01af;
     */
            /* JADX WARNING: Missing block: B:54:0x0196, code:
            if (r1 >= 3) goto L_0x01af;
     */
            /* JADX WARNING: Missing block: B:56:?, code:
            r8.kJ.a(r3, r2, (com.appnext.core.a) com.appnext.core.c.a(r8.kJ).get(r2));
     */
            /* JADX WARNING: Missing block: B:58:?, code:
            ((com.appnext.core.a) com.appnext.core.c.a(r8.kJ).get(r2)).setState(2);
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.appnext.core.c.2.AnonymousClass1(r8));
     */
            /* JADX WARNING: Missing block: B:59:0x01d2, code:
            com.appnext.core.g.X("finished loading ads");
     */
            /* JADX WARNING: Missing block: B:68:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:70:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:71:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:72:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:73:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:74:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:75:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:76:?, code:
            return;
     */
            /* JADX WARNING: Missing block: B:77:?, code:
            return;
     */
            public void run() {
                /*
                r8 = this;
                r7 = 2;
                r4 = 1;
                r1 = 0;
                super.run();
                r0 = r2;	 Catch:{ Throwable -> 0x01e1 }
                r2 = r3;	 Catch:{ Throwable -> 0x01e1 }
                r2 = com.appnext.core.g.A(r2);	 Catch:{ Throwable -> 0x01e1 }
                r0.setSessionId(r2);	 Catch:{ Throwable -> 0x01e1 }
            L_0x0011:
                r0 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r2 = r0.kH;	 Catch:{ Throwable -> 0x00db }
                monitor-enter(r2);	 Catch:{ Throwable -> 0x00db }
                r0 = com.appnext.core.c.this;	 Catch:{ all -> 0x0103 }
                r0 = r0.kH;	 Catch:{ all -> 0x0103 }
                r3 = r2;	 Catch:{ all -> 0x0103 }
                r0 = r0.containsKey(r3);	 Catch:{ all -> 0x0103 }
                if (r0 == 0) goto L_0x0053;
            L_0x0026:
                r0 = com.appnext.core.c.this;	 Catch:{ all -> 0x0103 }
                r0 = r0.kH;	 Catch:{ all -> 0x0103 }
                r3 = r2;	 Catch:{ all -> 0x0103 }
                r0 = r0.get(r3);	 Catch:{ all -> 0x0103 }
                r0 = (com.appnext.core.a) r0;	 Catch:{ all -> 0x0103 }
                r0 = r0.getState();	 Catch:{ all -> 0x0103 }
                if (r0 != r4) goto L_0x0053;
            L_0x003a:
                r0 = r4;	 Catch:{ all -> 0x0103 }
                if (r0 == 0) goto L_0x0051;
            L_0x003e:
                r0 = com.appnext.core.c.this;	 Catch:{ all -> 0x0103 }
                r0 = r0.kH;	 Catch:{ all -> 0x0103 }
                r1 = r2;	 Catch:{ all -> 0x0103 }
                r0 = r0.get(r1);	 Catch:{ all -> 0x0103 }
                r0 = (com.appnext.core.a) r0;	 Catch:{ all -> 0x0103 }
                r1 = r4;	 Catch:{ all -> 0x0103 }
                r0.a(r1);	 Catch:{ all -> 0x0103 }
            L_0x0051:
                monitor-exit(r2);	 Catch:{ all -> 0x0103 }
            L_0x0052:
                return;
            L_0x0053:
                r0 = "start loading ads";
                com.appnext.core.g.X(r0);	 Catch:{ all -> 0x0103 }
                r0 = new com.appnext.core.a;	 Catch:{ all -> 0x0103 }
                r0.<init>();	 Catch:{ all -> 0x0103 }
                r3 = r4;	 Catch:{ all -> 0x0103 }
                r0.a(r3);	 Catch:{ all -> 0x0103 }
                r3 = r5;	 Catch:{ all -> 0x0103 }
                r0.setPlacementID(r3);	 Catch:{ all -> 0x0103 }
                r3 = 1;
                r0.setState(r3);	 Catch:{ all -> 0x0103 }
                r3 = com.appnext.core.c.this;	 Catch:{ all -> 0x0103 }
                r3 = r3.kH;	 Catch:{ all -> 0x0103 }
                r4 = r2;	 Catch:{ all -> 0x0103 }
                r3 = r3.containsKey(r4);	 Catch:{ all -> 0x0103 }
                if (r3 == 0) goto L_0x0084;
            L_0x0079:
                r3 = com.appnext.core.c.this;	 Catch:{ all -> 0x0103 }
                r3 = r3.kH;	 Catch:{ all -> 0x0103 }
                r4 = r2;	 Catch:{ all -> 0x0103 }
                r3.remove(r4);	 Catch:{ all -> 0x0103 }
            L_0x0084:
                r3 = com.appnext.core.c.this;	 Catch:{ all -> 0x0103 }
                r4 = r2;	 Catch:{ all -> 0x0103 }
                r3.a(r4, r0);	 Catch:{ all -> 0x0103 }
                monitor-exit(r2);	 Catch:{ all -> 0x0103 }
                r0 = new java.util.ArrayList;	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r0.<init>();	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r2 = com.appnext.core.c.this;	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r3 = r3;	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r4 = r2;	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r5 = r5;	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r2 = r2.a(r3, r4, r5, r0);	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r3 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r3.<init>();	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r4 = "AdsManager request url: ";
                r3 = r3.append(r4);	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r3 = r3.append(r2);	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r3 = r3.toString();	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                com.appnext.core.g.X(r3);	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r3 = com.appnext.core.c.this;	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r3 = r3.o();	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r0 = com.appnext.core.g.a(r2, r0, r3);	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                com.appnext.core.g.X(r0);	 Catch:{ SocketTimeoutException -> 0x0106, UnknownHostException -> 0x011a, Throwable -> 0x012e }
                r2 = "{}";
                r2 = r0.equals(r2);	 Catch:{ Throwable -> 0x00db }
                if (r2 != 0) goto L_0x00d0;
            L_0x00c8:
                r2 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r2 = r2.h(r0);	 Catch:{ Throwable -> 0x00db }
                if (r2 == 0) goto L_0x0141;
            L_0x00d0:
                r1 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r2 = "No Ads";
                r3 = r2;	 Catch:{ Throwable -> 0x00db }
                r1.a(r2, r0, r3);	 Catch:{ Throwable -> 0x00db }
                goto L_0x0052;
            L_0x00db:
                r0 = move-exception;
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r2 = "finished custom after load with error ";
                r1 = r1.append(r2);
                r2 = com.appnext.core.g.b(r0);
                r1 = r1.append(r2);
                r1 = r1.toString();
                com.appnext.core.g.X(r1);
                r1 = com.appnext.core.c.this;
                r0 = r0.getMessage();
                r2 = r2;
                r1.b(r0, r2);
                goto L_0x0052;
            L_0x0103:
                r0 = move-exception;
                monitor-exit(r2);	 Catch:{ all -> 0x0103 }
                throw r0;	 Catch:{ Throwable -> 0x00db }
            L_0x0106:
                r0 = move-exception;
                com.appnext.core.g.c(r0);	 Catch:{ Throwable -> 0x00db }
                r1 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r2 = "Timeout";
                r0 = com.appnext.core.g.b(r0);	 Catch:{ Throwable -> 0x00db }
                r3 = r2;	 Catch:{ Throwable -> 0x00db }
                r4 = 0;
                r1.a(r2, r0, r3, r4);	 Catch:{ Throwable -> 0x00db }
                goto L_0x0052;
            L_0x011a:
                r0 = move-exception;
                com.appnext.core.g.c(r0);	 Catch:{ Throwable -> 0x00db }
                r1 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r2 = "Connection Error";
                r0 = com.appnext.core.g.b(r0);	 Catch:{ Throwable -> 0x00db }
                r3 = r2;	 Catch:{ Throwable -> 0x00db }
                r4 = 0;
                r1.a(r2, r0, r3, r4);	 Catch:{ Throwable -> 0x00db }
                goto L_0x0052;
            L_0x012e:
                r0 = move-exception;
                com.appnext.core.g.c(r0);	 Catch:{ Throwable -> 0x00db }
                r1 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r2 = "Internal error";
                r0 = com.appnext.core.g.b(r0);	 Catch:{ Throwable -> 0x00db }
                r3 = r2;	 Catch:{ Throwable -> 0x00db }
                r1.a(r2, r0, r3);	 Catch:{ Throwable -> 0x00db }
                goto L_0x0052;
            L_0x0141:
                r2 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x015c }
                r3 = r3;	 Catch:{ Throwable -> 0x015c }
                r4 = r2;	 Catch:{ Throwable -> 0x015c }
                r5 = com.appnext.core.c.kG;	 Catch:{ Throwable -> 0x015c }
                r2 = r2.a(r3, r4, r0, r5);	 Catch:{ Throwable -> 0x015c }
                if (r2 != 0) goto L_0x016f;
            L_0x0151:
                r1 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r2 = "No Ads";
                r3 = r2;	 Catch:{ Throwable -> 0x00db }
                r1.a(r2, r0, r3);	 Catch:{ Throwable -> 0x00db }
                goto L_0x0052;
            L_0x015c:
                r0 = move-exception;
                com.appnext.core.g.c(r0);	 Catch:{ Throwable -> 0x00db }
                r1 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r2 = "Internal error";
                r0 = com.appnext.core.g.b(r0);	 Catch:{ Throwable -> 0x00db }
                r3 = r2;	 Catch:{ Throwable -> 0x00db }
                r1.a(r2, r0, r3);	 Catch:{ Throwable -> 0x00db }
                goto L_0x0052;
            L_0x016f:
                r0 = r2.size();	 Catch:{ Throwable -> 0x00db }
                if (r0 != 0) goto L_0x0180;
            L_0x0175:
                r0 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r1 = "No Ads";
                r2 = r2;	 Catch:{ Throwable -> 0x00db }
                r0.b(r1, r2);	 Catch:{ Throwable -> 0x00db }
                goto L_0x0052;
            L_0x0180:
                r0 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r0 = r0.kH;	 Catch:{ Throwable -> 0x00db }
                r3 = r2;	 Catch:{ Throwable -> 0x00db }
                r0 = r0.get(r3);	 Catch:{ Throwable -> 0x00db }
                r0 = (com.appnext.core.a) r0;	 Catch:{ Throwable -> 0x00db }
                r0.h(r2);	 Catch:{ Throwable -> 0x00db }
                r0 = r6;	 Catch:{ Throwable -> 0x00db }
                if (r0 == 0) goto L_0x01af;
            L_0x0195:
                r2 = 3;
            L_0x0196:
                if (r1 >= r2) goto L_0x01af;
            L_0x0198:
                r3 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x01d9 }
                r4 = r3;	 Catch:{ Throwable -> 0x01d9 }
                r5 = r2;	 Catch:{ Throwable -> 0x01d9 }
                r0 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x01d9 }
                r0 = r0.kH;	 Catch:{ Throwable -> 0x01d9 }
                r6 = r2;	 Catch:{ Throwable -> 0x01d9 }
                r0 = r0.get(r6);	 Catch:{ Throwable -> 0x01d9 }
                r0 = (com.appnext.core.a) r0;	 Catch:{ Throwable -> 0x01d9 }
                r3.a(r4, r5, r0);	 Catch:{ Throwable -> 0x01d9 }
            L_0x01af:
                r0 = com.appnext.core.c.this;	 Catch:{ Throwable -> 0x00db }
                r0 = r0.kH;	 Catch:{ Throwable -> 0x00db }
                r1 = r2;	 Catch:{ Throwable -> 0x00db }
                r0 = r0.get(r1);	 Catch:{ Throwable -> 0x00db }
                r0 = (com.appnext.core.a) r0;	 Catch:{ Throwable -> 0x00db }
                r1 = 2;
                r0.setState(r1);	 Catch:{ Throwable -> 0x00db }
                r0 = new android.os.Handler;	 Catch:{ Throwable -> 0x00db }
                r1 = android.os.Looper.getMainLooper();	 Catch:{ Throwable -> 0x00db }
                r0.<init>(r1);	 Catch:{ Throwable -> 0x00db }
                r1 = new com.appnext.core.c$2$1;	 Catch:{ Throwable -> 0x00db }
                r1.<init>();	 Catch:{ Throwable -> 0x00db }
                r0.post(r1);	 Catch:{ Throwable -> 0x00db }
                r0 = "finished loading ads";
                com.appnext.core.g.X(r0);
                goto L_0x0052;
            L_0x01d9:
                r0 = move-exception;
                if (r1 != r7) goto L_0x01dd;
            L_0x01dc:
                throw r0;	 Catch:{ Throwable -> 0x00db }
            L_0x01dd:
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x0196;
            L_0x01e1:
                r0 = move-exception;
                goto L_0x0011;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.c.2.run():void");
            }
        }.start();
    }

    protected void V(String str) {
        l.dg().aR(str);
    }

    protected abstract String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList);

    protected ArrayList<? extends i> a(final Context context, Ad ad, String str, int i) {
        ArrayList arrayList = new ArrayList();
        final StringBuilder stringBuilder = new StringBuilder();
        JSONArray jSONArray = new JSONObject(str).getJSONArray("apps");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= jSONArray.length()) {
                break;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            g.X(jSONObject.toString());
            try {
                Object obj = (AppnextAd) g(jSONObject.toString());
                obj.setAdID(arrayList.size());
                obj.setPlacementID(ad.getPlacementID());
                if (a(context, (i) obj)) {
                    AppnextAd b = b(arrayList, (AppnextAd) obj);
                    if (b != null) {
                        arrayList.remove(b);
                        obj = a(b, (AppnextAd) obj);
                    }
                    arrayList.add(obj);
                } else {
                    stringBuilder.append(obj.getBannerID()).append(",");
                }
                if (arrayList.size() == i) {
                    break;
                }
                i2 = i3 + 1;
            } catch (Throwable th) {
                g.c(th);
            }
        }
        new Thread(new Runnable() {
            public void run() {
                try {
                    String stringBuilder = stringBuilder.toString();
                    if (stringBuilder.length() != 0) {
                        HashMap hashMap = new HashMap();
                        String u = g.u(context);
                        if (!u.equals("")) {
                            hashMap.put("aid", u);
                            hashMap.put("bids", stringBuilder.substring(0, stringBuilder.length() - 1));
                            g.a("https://admin.appnext.com/AdminService.asmx/bns", hashMap);
                        }
                    }
                } catch (Throwable th) {
                    g.c(th);
                }
            }
        }).start();
        return arrayList;
    }

    protected abstract void a(Context context, Ad ad, a aVar);

    public void a(Context context, Ad ad, String str, a aVar) {
        a(context, ad, str, aVar, true);
    }

    public void a(Context context, Ad ad, String str, a aVar, boolean z) {
        final Ad ad2 = ad;
        final Context context2 = context;
        final a aVar2 = aVar;
        final String str2 = str;
        final boolean z2 = z;
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (c.this.a(ad2) || (c.this.b(ad2) && c.this.c(ad2))) {
                        c.this.a(context2, ad2, c.this.j(ad2));
                    }
                } catch (Throwable th) {
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        try {
                            if (c.this.a(ad2) || (c.this.b(ad2) && c.this.c(ad2))) {
                                ArrayList cQ = ((a) c.this.kH.get(ad2)).cQ();
                                if (cQ.size() == 0) {
                                    aVar2.error(AppnextError.NO_ADS);
                                    return;
                                } else if (!c.this.a(context2, ad2, cQ)) {
                                    c.this.V(str2);
                                } else if (aVar2 != null) {
                                    aVar2.a(cQ);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            if (aVar2 != null) {
                                aVar2.error(AppnextError.NO_ADS);
                            }
                        }
                        if (g.cZ().equals("")) {
                            g.v(context2);
                            c.this.b(context2, ad2, str2, aVar2, z2);
                            return;
                        }
                        c.this.b(context2, ad2, str2, aVar2, z2);
                    }
                });
            }
        }).start();
    }

    protected void a(Ad ad, a aVar) {
        this.kH.put(ad, aVar);
    }

    protected abstract void a(Ad ad, String str, String str2);

    protected void a(String str, Ad ad) {
        l.dg().q(str, ad.getPlacementID());
    }

    protected abstract <T> void a(String str, Ad ad, T t);

    protected void a(String str, String str2, Ad ad) {
        a(str, str2, ad, 2);
    }

    protected void a(String str, String str2, Ad ad, int i) {
        final Ad ad2 = ad;
        final int i2 = i;
        final String str3 = str;
        final String str4 = str2;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                a aVar = (a) c.this.kH.get(ad2);
                if (aVar != null) {
                    if (aVar.cQ() == null) {
                        aVar.h(new ArrayList());
                    } else {
                        aVar.h(aVar.cQ());
                    }
                    aVar.setState(i2);
                    aVar.aH(str3);
                    c.this.a(ad2, str3 + " " + str4, aVar.getPlacementID());
                }
            }
        });
    }

    protected abstract boolean a(Context context, Ad ad, ArrayList<?> arrayList);

    protected abstract boolean a(Context context, i iVar);

    protected boolean a(Ad ad) {
        try {
            return b(ad) && c(ad);
        } catch (Throwable th) {
            g.c(th);
            return false;
        }
    }

    protected void b(String str, Ad ad) {
        a(str, "", ad);
    }

    protected boolean b(Ad ad) {
        return (this.kH == null || !this.kH.containsKey(ad) || this.kH.get(ad) == null || ((a) this.kH.get(ad)).getState() != 2 || ((a) this.kH.get(ad)).cQ() == null) ? false : true;
    }

    public void c(Context context, Ad ad, String str) {
        if (this.kH.containsKey(ad)) {
            this.kH.remove(ad);
        }
        b(context, ad, str, null, true);
    }

    protected boolean c(Ad ad) {
        boolean z = true;
        if (i(ad) == 0) {
            return (this.kH != null && this.kH.containsKey(ad) && ((a) this.kH.get(ad)).cQ().size() == 0) ? ((a) this.kH.get(ad)).cP().longValue() + 60000 > System.currentTimeMillis() : false;
        } else {
            if (this.kH == null || !this.kH.containsKey(ad) || ((a) this.kH.get(ad)).cP().longValue() + i(ad) <= System.currentTimeMillis()) {
                z = false;
            }
            return z;
        }
    }

    protected boolean c(String str, String str2) {
        return l.dg().r(str, str2);
    }

    protected HashMap<Ad, a> cR() {
        return this.kH;
    }

    protected abstract r d(Ad ad);

    public String d(AppnextAd appnextAd) {
        return appnextAd.getAdJSON();
    }

    protected String d(ArrayList<AppnextAd> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(new JSONObject(((AppnextAd) it.next()).getAdJSON()));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apps", jSONArray);
            return jSONObject.toString().replace(" ", "\\u2028").replace(" ", "\\u2029");
        } catch (Throwable th) {
            return "";
        }
    }

    public i g(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppnextAd appnextAd = (AppnextAd) n.a(AppnextAd.class, jSONObject);
            if (appnextAd == null) {
                return appnextAd;
            }
            appnextAd.setAdJSON(jSONObject.toString());
            if (!appnextAd.getStoreRating().equals("")) {
                return appnextAd;
            }
            appnextAd.setStoreRating("0");
            return appnextAd;
        } catch (Throwable th) {
            return null;
        }
    }

    protected boolean h(String str) {
        try {
            return new JSONObject(str).has("rnd");
        } catch (Throwable th) {
            return true;
        }
    }

    protected long i(Ad ad) {
        try {
            return d(ad).get("_cachingRequest") == null ? a(ad, "ads_caching_time_minutes") * 60000 : 1000 * a(ad, "_cachingRequest");
        } catch (Throwable th) {
            return a(ad, "ads_caching_time_minutes") * 60000;
        }
    }

    protected a j(Ad ad) {
        return (a) this.kH.get(ad);
    }

    protected int o() {
        return 8000;
    }
}
