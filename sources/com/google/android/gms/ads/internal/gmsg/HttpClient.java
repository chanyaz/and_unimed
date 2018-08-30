package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.support.annotation.Keep;
import com.appnext.base.a.c.c;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.hr;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzue;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
@KeepName
@zzadh
public class HttpClient implements zzv<zzue> {
    private final Context mContext;
    private final zzang zzyf;

    public HttpClient(Context context, zzang zzang) {
        this.mContext = context;
        this.zzyf = zzang;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc  */
    private final com.google.android.gms.ads.internal.gmsg.c zza(com.google.android.gms.ads.internal.gmsg.b r10) {
        /*
        r9 = this;
        r2 = 0;
        r3 = 0;
        r0 = r10.b();	 Catch:{ Exception -> 0x010f, all -> 0x010a }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x010f, all -> 0x010a }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x010f, all -> 0x010a }
        r1 = com.google.android.gms.ads.internal.au.e();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r4 = r9.mContext;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r5 = r9.zzyf;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r5 = r5.a;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r6 = 0;
        r1.a(r4, r5, r6, r0);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = r10.c();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = (java.util.ArrayList) r1;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r5 = r1.size();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r4 = r2;
    L_0x0025:
        if (r4 >= r5) goto L_0x004e;
    L_0x0027:
        r2 = r1.get(r4);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r4 = r4 + 1;
        r2 = (com.google.android.gms.ads.internal.gmsg.a) r2;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r6 = r2.a();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r2 = r2.b();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r0.addRequestProperty(r6, r2);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        goto L_0x0025;
    L_0x003b:
        r1 = move-exception;
        r2 = r0;
    L_0x003d:
        r0 = new com.google.android.gms.ads.internal.gmsg.c;	 Catch:{ all -> 0x010c }
        r3 = 0;
        r4 = 0;
        r1 = r1.toString();	 Catch:{ all -> 0x010c }
        r0.<init>(r9, r3, r4, r1);	 Catch:{ all -> 0x010c }
        if (r2 == 0) goto L_0x004d;
    L_0x004a:
        r2.disconnect();
    L_0x004d:
        return r0;
    L_0x004e:
        r1 = r10.d();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        if (r1 != 0) goto L_0x0077;
    L_0x0058:
        r1 = 1;
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = r10.d();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r3 = r1.getBytes();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = r3.length;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r0.setFixedLengthStreamingMode(r1);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r2 = r0.getOutputStream();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1.write(r3);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1.close();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
    L_0x0077:
        r4 = new com.google.android.gms.internal.ads.ke;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r4.<init>();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r4.a(r0, r3);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r5.<init>();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = r0.getHeaderFields();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        if (r1 == 0) goto L_0x00d0;
    L_0x008a:
        r1 = r0.getHeaderFields();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = r1.entrySet();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r6 = r1.iterator();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
    L_0x0096:
        r1 = r6.hasNext();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        if (r1 == 0) goto L_0x00d0;
    L_0x009c:
        r1 = r6.next();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r2 = r1.getValue();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r2 = (java.util.List) r2;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r7 = r2.iterator();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
    L_0x00ac:
        r2 = r7.hasNext();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        if (r2 == 0) goto L_0x0096;
    L_0x00b2:
        r2 = r7.next();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r8 = new com.google.android.gms.ads.internal.gmsg.a;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r3 = r1.getKey();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r8.<init>(r3, r2);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r5.add(r8);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        goto L_0x00ac;
    L_0x00c7:
        r1 = move-exception;
        r3 = r0;
        r0 = r1;
    L_0x00ca:
        if (r3 == 0) goto L_0x00cf;
    L_0x00cc:
        r3.disconnect();
    L_0x00cf:
        throw r0;
    L_0x00d0:
        r2 = new com.google.android.gms.ads.internal.gmsg.d;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = r10.a();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r3 = r0.getResponseCode();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        com.google.android.gms.ads.internal.au.e();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r6 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r7 = r0.getInputStream();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r6.<init>(r7);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r6 = com.google.android.gms.internal.ads.ht.a(r6);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r2.<init>(r1, r3, r5, r6);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = r2.b();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r4.a(r0, r1);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = r2.d();	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r4.a(r1);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r1 = new com.google.android.gms.ads.internal.gmsg.c;	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        r3 = 1;
        r4 = 0;
        r1.<init>(r9, r3, r2, r4);	 Catch:{ Exception -> 0x003b, all -> 0x00c7 }
        if (r0 == 0) goto L_0x0107;
    L_0x0104:
        r0.disconnect();
    L_0x0107:
        r0 = r1;
        goto L_0x004d;
    L_0x010a:
        r0 = move-exception;
        goto L_0x00ca;
    L_0x010c:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00ca;
    L_0x010f:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.HttpClient.zza(com.google.android.gms.ads.internal.gmsg.b):com.google.android.gms.ads.internal.gmsg.c");
    }

    private static JSONObject zza(d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", dVar.a());
            if (dVar.d() != null) {
                jSONObject.put("body", dVar.d());
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar : dVar.c()) {
                jSONArray.put(new JSONObject().put(c.gv, aVar.a()).put("value", aVar.b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", dVar.b());
        } catch (Throwable e) {
            kk.b("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    private static b zzc(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            kk.b("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new a(optJSONObject.optString(c.gv), optJSONObject.optString("value")));
            }
        }
        return new b(optString, url, arrayList, optString3);
    }

    @Keep
    @KeepName
    public JSONObject send(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        String str = "";
        try {
            str = jSONObject.optString("http_request_id");
            c zza = zza(zzc(jSONObject));
            if (zza.c()) {
                jSONObject2.put("response", zza(zza.b()));
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("response", new JSONObject().put("http_request_id", str));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza.a());
            }
        } catch (Throwable e) {
            kk.b("Error executing http request.", e);
            try {
                jSONObject2.put("response", new JSONObject().put("http_request_id", str));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", e.toString());
            } catch (Throwable e2) {
                kk.b("Error executing http request.", e2);
            }
        }
        return jSONObject2;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        hr.a(new ae(this, map, (zzue) obj));
    }
}
