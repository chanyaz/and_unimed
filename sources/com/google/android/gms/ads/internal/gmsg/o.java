package com.google.android.gms.ads.internal.gmsg;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.my;
import com.google.android.gms.internal.ads.mz;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzarr;
import com.google.android.gms.internal.ads.zzue;
import java.util.HashMap;
import java.util.Map;

@zzadh
public final class o {
    public static final zzv<zzaqw> a = p.a;
    public static final zzv<zzaqw> b = q.a;
    public static final zzv<zzaqw> c = r.a;
    public static final zzv<zzaqw> d = new w();
    public static final zzv<zzaqw> e = new x();
    public static final zzv<zzaqw> f = s.a;
    public static final zzv<Object> g = new y();
    public static final zzv<zzaqw> h = new z();
    public static final zzv<zzaqw> i = t.a;
    public static final zzv<zzaqw> j = new aa();
    public static final zzv<zzaqw> k = new ab();
    public static final zzv<zzapw> l = new my();
    public static final zzv<zzapw> m = new mz();
    public static final zzv<zzaqw> n = new n();
    public static final k o = new k();
    public static final zzv<zzaqw> p = new ac();
    public static final zzv<zzaqw> q = new ad();
    public static final zzv<zzaqw> r = new v();
    private static final zzv<Object> s = new u();

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
    static final /* synthetic */ void b(com.google.android.gms.internal.ads.zzarr r16, java.util.Map r17) {
        /*
        r1 = r16.getContext();
        r4 = r1.getPackageManager();
        r1 = "data";
        r0 = r17;
        r1 = r0.get(r1);
        r1 = (java.lang.String) r1;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00cb }
        r2.<init>(r1);	 Catch:{ JSONException -> 0x00cb }
        r1 = "intents";
        r5 = r2.getJSONArray(r1);	 Catch:{ JSONException -> 0x00db }
        r6 = new org.json.JSONObject;
        r6.<init>();
        r1 = 0;
    L_0x0023:
        r2 = r5.length();
        if (r1 >= r2) goto L_0x0118;
    L_0x0029:
        r2 = r5.getJSONObject(r1);	 Catch:{ JSONException -> 0x00eb }
        r3 = "id";
        r7 = r2.optString(r3);
        r3 = "u";
        r8 = r2.optString(r3);
        r3 = "i";
        r9 = r2.optString(r3);
        r3 = "m";
        r10 = r2.optString(r3);
        r3 = "p";
        r11 = r2.optString(r3);
        r3 = "c";
        r12 = r2.optString(r3);
        r3 = "f";
        r2.optString(r3);
        r3 = "e";
        r2.optString(r3);
        r3 = "intent_url";
        r2 = r2.optString(r3);
        r3 = 0;
        r13 = android.text.TextUtils.isEmpty(r2);
        if (r13 != 0) goto L_0x0106;
    L_0x0068:
        r13 = 0;
        r2 = android.content.Intent.parseUri(r2, r13);	 Catch:{ URISyntaxException -> 0x00f2 }
    L_0x006d:
        if (r2 != 0) goto L_0x00bb;
    L_0x006f:
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = android.text.TextUtils.isEmpty(r8);
        if (r3 != 0) goto L_0x0081;
    L_0x007a:
        r3 = android.net.Uri.parse(r8);
        r2.setData(r3);
    L_0x0081:
        r3 = android.text.TextUtils.isEmpty(r9);
        if (r3 != 0) goto L_0x008a;
    L_0x0087:
        r2.setAction(r9);
    L_0x008a:
        r3 = android.text.TextUtils.isEmpty(r10);
        if (r3 != 0) goto L_0x0093;
    L_0x0090:
        r2.setType(r10);
    L_0x0093:
        r3 = android.text.TextUtils.isEmpty(r11);
        if (r3 != 0) goto L_0x009c;
    L_0x0099:
        r2.setPackage(r11);
    L_0x009c:
        r3 = android.text.TextUtils.isEmpty(r12);
        if (r3 != 0) goto L_0x00bb;
    L_0x00a2:
        r3 = "/";
        r8 = 2;
        r3 = r12.split(r3, r8);
        r8 = r3.length;
        r9 = 2;
        if (r8 != r9) goto L_0x00bb;
    L_0x00ad:
        r8 = new android.content.ComponentName;
        r9 = 0;
        r9 = r3[r9];
        r10 = 1;
        r3 = r3[r10];
        r8.<init>(r9, r3);
        r2.setComponent(r8);
    L_0x00bb:
        r3 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2 = r4.resolveActivity(r2, r3);
        if (r2 == 0) goto L_0x010f;
    L_0x00c3:
        r2 = 1;
    L_0x00c4:
        r6.put(r7, r2);	 Catch:{ JSONException -> 0x0111 }
    L_0x00c7:
        r1 = r1 + 1;
        goto L_0x0023;
    L_0x00cb:
        r1 = move-exception;
        r16 = (com.google.android.gms.internal.ads.zzue) r16;
        r1 = "openableIntents";
        r2 = new org.json.JSONObject;
        r2.<init>();
        r0 = r16;
        r0.zza(r1, r2);
    L_0x00da:
        return;
    L_0x00db:
        r1 = move-exception;
        r16 = (com.google.android.gms.internal.ads.zzue) r16;
        r1 = "openableIntents";
        r2 = new org.json.JSONObject;
        r2.<init>();
        r0 = r16;
        r0.zza(r1, r2);
        goto L_0x00da;
    L_0x00eb:
        r2 = move-exception;
        r3 = "Error parsing the intent data.";
        com.google.android.gms.internal.ads.kk.b(r3, r2);
        goto L_0x00c7;
    L_0x00f2:
        r13 = move-exception;
        r14 = "Error parsing the url: ";
        r2 = java.lang.String.valueOf(r2);
        r15 = r2.length();
        if (r15 == 0) goto L_0x0109;
    L_0x00ff:
        r2 = r14.concat(r2);
    L_0x0103:
        com.google.android.gms.internal.ads.kk.b(r2, r13);
    L_0x0106:
        r2 = r3;
        goto L_0x006d;
    L_0x0109:
        r2 = new java.lang.String;
        r2.<init>(r14);
        goto L_0x0103;
    L_0x010f:
        r2 = 0;
        goto L_0x00c4;
    L_0x0111:
        r2 = move-exception;
        r3 = "Error constructing openable urls response.";
        com.google.android.gms.internal.ads.kk.b(r3, r2);
        goto L_0x00c7;
    L_0x0118:
        r16 = (com.google.android.gms.internal.ads.zzue) r16;
        r1 = "openableIntents";
        r0 = r16;
        r0.zza(r1, r6);
        goto L_0x00da;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.o.b(com.google.android.gms.internal.ads.zzarr, java.util.Map):void");
    }

    static final /* synthetic */ void c(zzarr zzarr, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            kk.e("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        Map hashMap = new HashMap();
        PackageManager packageManager = zzarr.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
        }
        ((zzue) zzarr).zza("openableURLs", hashMap);
    }
}
