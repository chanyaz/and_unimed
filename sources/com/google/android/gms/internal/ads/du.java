package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.appnext.base.b.c;
import com.appnext.base.b.i;
import com.appnext.core.Ad;
import com.google.android.gms.ads.internal.au;
import com.mopub.mobileads.VastIconXmlManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
public final class du {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd", Locale.US);

    /* JADX WARNING: Removed duplicated region for block: B:62:0x016b A:{Catch:{ JSONException -> 0x0288 }} */
    public static com.google.android.gms.internal.ads.zzaej a(android.content.Context r54, com.google.android.gms.internal.ads.zzaef r55, java.lang.String r56) {
        /*
        r28 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0288 }
        r0 = r28;
        r1 = r56;
        r0.<init>(r1);	 Catch:{ JSONException -> 0x0288 }
        r4 = "ad_base_url";
        r5 = 0;
        r0 = r28;
        r6 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "ad_url";
        r5 = 0;
        r0 = r28;
        r7 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "ad_size";
        r5 = 0;
        r0 = r28;
        r19 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "ad_slot_size";
        r0 = r28;
        r1 = r19;
        r43 = r0.optString(r4, r1);	 Catch:{ JSONException -> 0x0288 }
        if (r55 == 0) goto L_0x00e2;
    L_0x0030:
        r0 = r55;
        r4 = r0.m;	 Catch:{ JSONException -> 0x0288 }
        if (r4 == 0) goto L_0x00e2;
    L_0x0036:
        r27 = 1;
    L_0x0038:
        r4 = "ad_json";
        r5 = 0;
        r0 = r28;
        r5 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        if (r5 != 0) goto L_0x004c;
    L_0x0043:
        r4 = "ad_html";
        r5 = 0;
        r0 = r28;
        r5 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
    L_0x004c:
        if (r5 != 0) goto L_0x0057;
    L_0x004e:
        r4 = "body";
        r5 = 0;
        r0 = r28;
        r5 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
    L_0x0057:
        if (r5 != 0) goto L_0x0067;
    L_0x0059:
        r4 = "ads";
        r0 = r28;
        r4 = r0.has(r4);	 Catch:{ JSONException -> 0x0288 }
        if (r4 == 0) goto L_0x0067;
    L_0x0063:
        r5 = r28.toString();	 Catch:{ JSONException -> 0x0288 }
    L_0x0067:
        r20 = -1;
        r4 = "debug_dialog";
        r8 = 0;
        r0 = r28;
        r22 = r0.optString(r4, r8);	 Catch:{ JSONException -> 0x0288 }
        r4 = "debug_signals";
        r8 = 0;
        r0 = r28;
        r45 = r0.optString(r4, r8);	 Catch:{ JSONException -> 0x0288 }
        r4 = "interstitial_timeout";
        r0 = r28;
        r4 = r0.has(r4);	 Catch:{ JSONException -> 0x0288 }
        if (r4 == 0) goto L_0x00e6;
    L_0x0085:
        r4 = "interstitial_timeout";
        r0 = r28;
        r8 = r0.getDouble(r4);	 Catch:{ JSONException -> 0x0288 }
        r10 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r8 = r8 * r10;
        r0 = (long) r8;	 Catch:{ JSONException -> 0x0288 }
        r16 = r0;
    L_0x0096:
        r4 = "orientation";
        r8 = 0;
        r0 = r28;
        r4 = r0.optString(r4, r8);	 Catch:{ JSONException -> 0x0288 }
        r18 = -1;
        r8 = "portrait";
        r8 = r8.equals(r4);	 Catch:{ JSONException -> 0x0288 }
        if (r8 == 0) goto L_0x00e9;
    L_0x00a9:
        r4 = com.google.android.gms.ads.internal.au.g();	 Catch:{ JSONException -> 0x0288 }
        r18 = r4.b();	 Catch:{ JSONException -> 0x0288 }
    L_0x00b1:
        r4 = 0;
        r8 = android.text.TextUtils.isEmpty(r5);	 Catch:{ JSONException -> 0x0288 }
        if (r8 == 0) goto L_0x02c4;
    L_0x00b8:
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ JSONException -> 0x0288 }
        if (r8 != 0) goto L_0x02c4;
    L_0x00be:
        r0 = r55;
        r4 = r0.k;	 Catch:{ JSONException -> 0x0288 }
        r6 = r4.a;	 Catch:{ JSONException -> 0x0288 }
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r12 = 0;
        r4 = r55;
        r5 = r54;
        r4 = com.google.android.gms.internal.ads.dq.a(r4, r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ JSONException -> 0x0288 }
        r6 = r4.a;	 Catch:{ JSONException -> 0x0288 }
        r7 = r4.b;	 Catch:{ JSONException -> 0x0288 }
        r0 = r4.m;	 Catch:{ JSONException -> 0x0288 }
        r20 = r0;
    L_0x00d9:
        if (r7 != 0) goto L_0x00fa;
    L_0x00db:
        r4 = new com.google.android.gms.internal.ads.zzaej;	 Catch:{ JSONException -> 0x0288 }
        r5 = 0;
        r4.<init>(r5);	 Catch:{ JSONException -> 0x0288 }
    L_0x00e1:
        return r4;
    L_0x00e2:
        r27 = 0;
        goto L_0x0038;
    L_0x00e6:
        r16 = -1;
        goto L_0x0096;
    L_0x00e9:
        r8 = "landscape";
        r4 = r8.equals(r4);	 Catch:{ JSONException -> 0x0288 }
        if (r4 == 0) goto L_0x00b1;
    L_0x00f1:
        r4 = com.google.android.gms.ads.internal.au.g();	 Catch:{ JSONException -> 0x0288 }
        r18 = r4.a();	 Catch:{ JSONException -> 0x0288 }
        goto L_0x00b1;
    L_0x00fa:
        r5 = "click_urls";
        r0 = r28;
        r5 = r0.optJSONArray(r5);	 Catch:{ JSONException -> 0x0288 }
        if (r4 != 0) goto L_0x02a8;
    L_0x0104:
        r8 = 0;
    L_0x0105:
        if (r5 == 0) goto L_0x010b;
    L_0x0107:
        r8 = a(r5, r8);	 Catch:{ JSONException -> 0x0288 }
    L_0x010b:
        r5 = "impression_urls";
        r0 = r28;
        r5 = r0.optJSONArray(r5);	 Catch:{ JSONException -> 0x0288 }
        if (r4 != 0) goto L_0x02ac;
    L_0x0115:
        r9 = 0;
    L_0x0116:
        if (r5 == 0) goto L_0x011c;
    L_0x0118:
        r9 = a(r5, r9);	 Catch:{ JSONException -> 0x0288 }
    L_0x011c:
        r5 = "downloaded_impression_urls";
        r0 = r28;
        r5 = r0.optJSONArray(r5);	 Catch:{ JSONException -> 0x0288 }
        if (r4 != 0) goto L_0x02b0;
    L_0x0126:
        r51 = 0;
    L_0x0128:
        if (r5 == 0) goto L_0x0130;
    L_0x012a:
        r0 = r51;
        r51 = a(r5, r0);	 Catch:{ JSONException -> 0x0288 }
    L_0x0130:
        r5 = "manual_impression_urls";
        r0 = r28;
        r5 = r0.optJSONArray(r5);	 Catch:{ JSONException -> 0x0288 }
        if (r4 != 0) goto L_0x02b6;
    L_0x013a:
        r15 = 0;
    L_0x013b:
        if (r5 == 0) goto L_0x0141;
    L_0x013d:
        r15 = a(r5, r15);	 Catch:{ JSONException -> 0x0288 }
    L_0x0141:
        if (r4 == 0) goto L_0x02c0;
    L_0x0143:
        r5 = r4.k;	 Catch:{ JSONException -> 0x0288 }
        r10 = -1;
        if (r5 == r10) goto L_0x014c;
    L_0x0148:
        r0 = r4.k;	 Catch:{ JSONException -> 0x0288 }
        r18 = r0;
    L_0x014c:
        r10 = r4.f;	 Catch:{ JSONException -> 0x0288 }
        r12 = 0;
        r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r5 <= 0) goto L_0x02c0;
    L_0x0154:
        r10 = r4.f;	 Catch:{ JSONException -> 0x0288 }
    L_0x0156:
        r4 = "active_view";
        r0 = r28;
        r25 = r0.optString(r4);	 Catch:{ JSONException -> 0x0288 }
        r24 = 0;
        r4 = "ad_is_javascript";
        r5 = 0;
        r0 = r28;
        r23 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        if (r23 == 0) goto L_0x0174;
    L_0x016b:
        r4 = "ad_passback_url";
        r5 = 0;
        r0 = r28;
        r24 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
    L_0x0174:
        r4 = "mediation";
        r5 = 0;
        r0 = r28;
        r12 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "custom_render_allowed";
        r5 = 0;
        r0 = r28;
        r26 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "content_url_opted_out";
        r5 = 1;
        r0 = r28;
        r29 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "content_vertical_opted_out";
        r5 = 1;
        r0 = r28;
        r46 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "prefetch";
        r5 = 0;
        r0 = r28;
        r30 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "refresh_interval_milliseconds";
        r16 = -1;
        r0 = r28;
        r1 = r16;
        r16 = r0.optLong(r4, r1);	 Catch:{ JSONException -> 0x0288 }
        r4 = "mediation_config_cache_time_milliseconds";
        r32 = -1;
        r0 = r28;
        r1 = r32;
        r13 = r0.optLong(r4, r1);	 Catch:{ JSONException -> 0x0288 }
        r4 = "gws_query_id";
        r5 = "";
        r0 = r28;
        r31 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "height";
        r5 = "fluid";
        r32 = "";
        r0 = r28;
        r1 = r32;
        r5 = r0.optString(r5, r1);	 Catch:{ JSONException -> 0x0288 }
        r32 = r4.equals(r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "native_express";
        r5 = 0;
        r0 = r28;
        r33 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "video_start_urls";
        r0 = r28;
        r4 = r0.optJSONArray(r4);	 Catch:{ JSONException -> 0x0288 }
        r5 = 0;
        r35 = a(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "video_complete_urls";
        r0 = r28;
        r4 = r0.optJSONArray(r4);	 Catch:{ JSONException -> 0x0288 }
        r5 = 0;
        r36 = a(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "rewards";
        r0 = r28;
        r4 = r0.optJSONArray(r4);	 Catch:{ JSONException -> 0x0288 }
        r34 = com.google.android.gms.internal.ads.zzaig.a(r4);	 Catch:{ JSONException -> 0x0288 }
        r4 = "use_displayed_impression";
        r5 = 0;
        r0 = r28;
        r37 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "auto_protection_configuration";
        r0 = r28;
        r4 = r0.optJSONObject(r4);	 Catch:{ JSONException -> 0x0288 }
        r38 = com.google.android.gms.internal.ads.zzael.a(r4);	 Catch:{ JSONException -> 0x0288 }
        r4 = "set_cookie";
        r5 = "";
        r0 = r28;
        r40 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "remote_ping_urls";
        r0 = r28;
        r4 = r0.optJSONArray(r4);	 Catch:{ JSONException -> 0x0288 }
        r5 = 0;
        r41 = a(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "safe_browsing";
        r0 = r28;
        r4 = r0.optJSONObject(r4);	 Catch:{ JSONException -> 0x0288 }
        r44 = com.google.android.gms.internal.ads.zzaiq.a(r4);	 Catch:{ JSONException -> 0x0288 }
        r4 = "render_in_browser";
        r0 = r55;
        r5 = r0.K;	 Catch:{ JSONException -> 0x0288 }
        r0 = r28;
        r42 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "custom_close_blocked";
        r0 = r28;
        r48 = r0.optBoolean(r4);	 Catch:{ JSONException -> 0x0288 }
        r4 = "enable_omid";
        r5 = 0;
        r0 = r28;
        r50 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "omid_settings";
        r5 = 0;
        r0 = r28;
        r53 = r0.optString(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = "disable_closable_area";
        r5 = 0;
        r0 = r28;
        r52 = r0.optBoolean(r4, r5);	 Catch:{ JSONException -> 0x0288 }
        r4 = new com.google.android.gms.internal.ads.zzaej;	 Catch:{ JSONException -> 0x0288 }
        r0 = r55;
        r0 = r0.p;	 Catch:{ JSONException -> 0x0288 }
        r28 = r0;
        r0 = r55;
        r0 = r0.G;	 Catch:{ JSONException -> 0x0288 }
        r39 = r0;
        r0 = r55;
        r0 = r0.U;	 Catch:{ JSONException -> 0x0288 }
        r47 = r0;
        r49 = 0;
        r5 = r55;
        r4.<init>(r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53);	 Catch:{ JSONException -> 0x0288 }
        goto L_0x00e1;
    L_0x0288:
        r4 = move-exception;
        r5 = "Could not parse the inline ad response: ";
        r4 = r4.getMessage();
        r4 = java.lang.String.valueOf(r4);
        r6 = r4.length();
        if (r6 == 0) goto L_0x02ba;
    L_0x0299:
        r4 = r5.concat(r4);
    L_0x029d:
        com.google.android.gms.internal.ads.kk.e(r4);
        r4 = new com.google.android.gms.internal.ads.zzaej;
        r5 = 0;
        r4.<init>(r5);
        goto L_0x00e1;
    L_0x02a8:
        r8 = r4.c;	 Catch:{ JSONException -> 0x0288 }
        goto L_0x0105;
    L_0x02ac:
        r9 = r4.e;	 Catch:{ JSONException -> 0x0288 }
        goto L_0x0116;
    L_0x02b0:
        r0 = r4.R;	 Catch:{ JSONException -> 0x0288 }
        r51 = r0;
        goto L_0x0128;
    L_0x02b6:
        r15 = r4.i;	 Catch:{ JSONException -> 0x0288 }
        goto L_0x013b;
    L_0x02ba:
        r4 = new java.lang.String;
        r4.<init>(r5);
        goto L_0x029d;
    L_0x02c0:
        r10 = r16;
        goto L_0x0156;
    L_0x02c4:
        r7 = r5;
        goto L_0x00d9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.du.a(android.content.Context, com.google.android.gms.internal.ads.zzaef, java.lang.String):com.google.android.gms.internal.ads.zzaej");
    }

    private static Integer a(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    @Nullable
    private static List<String> a(@Nullable JSONArray jSONArray, @Nullable List<String> list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    @Nullable
    private static JSONArray a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    @Nullable
    public static JSONObject a(Context context, do doVar) {
        Object obj;
        Object obj2;
        String str;
        zzaef zzaef = doVar.j;
        Location location = doVar.d;
        ec ecVar = doVar.k;
        Bundle bundle = doVar.a;
        JSONObject jSONObject = doVar.l;
        Map hashMap = new HashMap();
        hashMap.put("extra_caps", akc.f().a(amn.bT));
        if (doVar.c.size() > 0) {
            hashMap.put("eid", TextUtils.join(",", doVar.c));
        }
        if (zzaef.b != null) {
            hashMap.put("ad_pos", zzaef.b);
        }
        zzjj zzjj = zzaef.c;
        String a = hf.a();
        if (a != null) {
            hashMap.put("abf", a);
        }
        if (zzjj.b != -1) {
            hashMap.put("cust_age", a.format(new Date(zzjj.b)));
        }
        if (zzjj.c != null) {
            hashMap.put("extras", zzjj.c);
        }
        if (zzjj.d != -1) {
            hashMap.put("cust_gender", Integer.valueOf(zzjj.d));
        }
        if (zzjj.e != null) {
            hashMap.put("kw", zzjj.e);
        }
        if (zzjj.g != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zzjj.g));
        }
        if (zzjj.f) {
            if (((Boolean) akc.f().a(amn.dk)).booleanValue()) {
                hashMap.put("test_request", Boolean.valueOf(true));
            } else {
                hashMap.put("adtest", c.jx);
            }
        }
        if (zzjj.a >= 2) {
            if (zzjj.h) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(zzjj.i)) {
                hashMap.put("ppid", zzjj.i);
            }
        }
        if (zzjj.a >= 3 && zzjj.l != null) {
            hashMap.put("url", zzjj.l);
        }
        if (zzjj.a >= 5) {
            if (zzjj.n != null) {
                hashMap.put("custom_targeting", zzjj.n);
            }
            if (zzjj.o != null) {
                hashMap.put("category_exclusions", zzjj.o);
            }
            if (zzjj.p != null) {
                hashMap.put("request_agent", zzjj.p);
            }
        }
        if (zzjj.a >= 6 && zzjj.q != null) {
            hashMap.put("request_pkg", zzjj.q);
        }
        if (zzjj.a >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(zzjj.r));
        }
        if (zzaef.d.g != null) {
            obj = null;
            obj2 = null;
            for (zzjn zzjn : zzaef.d.g) {
                if (!zzjn.i && obj2 == null) {
                    hashMap.put("format", zzjn.a);
                    obj2 = 1;
                }
                if (zzjn.i && obj == null) {
                    hashMap.put("fluid", VastIconXmlManager.HEIGHT);
                    obj = 1;
                }
                if (obj2 != null && obj != null) {
                    break;
                }
            }
        } else {
            hashMap.put("format", zzaef.d.a);
            if (zzaef.d.i) {
                hashMap.put("fluid", VastIconXmlManager.HEIGHT);
            }
        }
        if (zzaef.d.e == -1) {
            hashMap.put("smart_w", "full");
        }
        if (zzaef.d.b == -2) {
            hashMap.put("smart_h", "auto");
        }
        if (zzaef.d.g != null) {
            StringBuilder stringBuilder = new StringBuilder();
            obj = null;
            for (zzjn zzjn2 : zzaef.d.g) {
                if (zzjn2.i) {
                    obj = 1;
                } else {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(zzjn2.e == -1 ? (int) (((float) zzjn2.f) / ecVar.s) : zzjn2.e);
                    stringBuilder.append("x");
                    stringBuilder.append(zzjn2.b == -2 ? (int) (((float) zzjn2.c) / ecVar.s) : zzjn2.b);
                }
            }
            if (obj != null) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.insert(0, "|");
                }
                stringBuilder.insert(0, "320x50");
            }
            hashMap.put("sz", stringBuilder);
        }
        if (zzaef.m != 0) {
            hashMap.put("native_version", Integer.valueOf(zzaef.m));
            hashMap.put("native_templates", zzaef.n);
            str = "native_image_orientation";
            zzpl zzpl = zzaef.y;
            if (zzpl != null) {
                switch (zzpl.c) {
                    case 0:
                        obj = "any";
                        break;
                    case 1:
                        obj = Ad.ORIENTATION_PORTRAIT;
                        break;
                    case 2:
                        obj = Ad.ORIENTATION_LANDSCAPE;
                        break;
                    default:
                        obj = Ad.ORIENTATION_DEFAULT;
                        break;
                }
            }
            obj = "any";
            hashMap.put(str, obj);
            if (!zzaef.z.isEmpty()) {
                hashMap.put("native_custom_templates", zzaef.z);
            }
            if (zzaef.a >= 24) {
                hashMap.put("max_num_ads", Integer.valueOf(zzaef.Y));
            }
            if (!TextUtils.isEmpty(zzaef.W)) {
                try {
                    hashMap.put("native_advanced_settings", new JSONArray(zzaef.W));
                } catch (Throwable e) {
                    kk.c("Problem creating json from native advanced settings", e);
                }
            }
        }
        try {
            Bundle bundle2;
            if (zzaef.V != null && zzaef.V.size() > 0) {
                for (Integer num : zzaef.V) {
                    if (num.intValue() == 2) {
                        hashMap.put("iba", Boolean.valueOf(true));
                    } else if (num.intValue() == 1) {
                        hashMap.put("ina", Boolean.valueOf(true));
                    }
                }
            }
            if (zzaef.d.j) {
                hashMap.put("ene", Boolean.valueOf(true));
            }
            if (((Boolean) akc.f().a(amn.ax)).booleanValue()) {
                hashMap.put("xsrve", Boolean.valueOf(true));
            }
            if (zzaef.O != null) {
                hashMap.put("is_icon_ad", Boolean.valueOf(true));
                hashMap.put("icon_ad_expansion_behavior", Integer.valueOf(zzaef.O.a));
            }
            hashMap.put("slotname", zzaef.e);
            hashMap.put("pn", zzaef.f.packageName);
            if (zzaef.g != null) {
                hashMap.put("vc", Integer.valueOf(zzaef.g.versionCode));
            }
            hashMap.put("ms", doVar.h);
            hashMap.put("seq_num", zzaef.i);
            hashMap.put("session_id", zzaef.j);
            hashMap.put("js", zzaef.k.a);
            ek ekVar = doVar.e;
            Bundle bundle3 = zzaef.M;
            Bundle bundle4 = doVar.b;
            hashMap.put("am", Integer.valueOf(ecVar.a));
            hashMap.put("cog", a(ecVar.b));
            hashMap.put("coh", a(ecVar.c));
            if (!TextUtils.isEmpty(ecVar.d)) {
                hashMap.put("carrier", ecVar.d);
            }
            hashMap.put("gl", ecVar.e);
            if (ecVar.f) {
                hashMap.put("simulator", Integer.valueOf(1));
            }
            if (ecVar.g) {
                hashMap.put("is_sidewinder", Integer.valueOf(1));
            }
            hashMap.put("ma", a(ecVar.h));
            hashMap.put("sp", a(ecVar.i));
            hashMap.put("hl", ecVar.j);
            if (!TextUtils.isEmpty(ecVar.k)) {
                hashMap.put("mv", ecVar.k);
            }
            hashMap.put("muv", Integer.valueOf(ecVar.m));
            if (ecVar.n != -2) {
                hashMap.put("cnt", Integer.valueOf(ecVar.n));
            }
            hashMap.put("gnt", Integer.valueOf(ecVar.o));
            hashMap.put("pt", Integer.valueOf(ecVar.p));
            hashMap.put("rm", Integer.valueOf(ecVar.q));
            hashMap.put("riv", Integer.valueOf(ecVar.r));
            Bundle bundle5 = new Bundle();
            bundle5.putString("build_build", ecVar.z);
            bundle5.putString("build_device", ecVar.A);
            Bundle bundle6 = new Bundle();
            bundle6.putBoolean("is_charging", ecVar.w);
            bundle6.putDouble("battery_level", ecVar.v);
            bundle5.putBundle("battery", bundle6);
            bundle6 = new Bundle();
            bundle6.putInt("active_network_state", ecVar.y);
            bundle6.putBoolean("active_network_metered", ecVar.x);
            if (ekVar != null) {
                bundle2 = new Bundle();
                bundle2.putInt("predicted_latency_micros", ekVar.a);
                bundle2.putLong("predicted_down_throughput_bps", ekVar.b);
                bundle2.putLong("predicted_up_throughput_bps", ekVar.c);
                bundle6.putBundle("predictions", bundle2);
            }
            bundle5.putBundle("network", bundle6);
            Bundle bundle7 = new Bundle();
            bundle7.putBoolean("is_browser_custom_tabs_capable", ecVar.B);
            bundle5.putBundle("browser", bundle7);
            if (bundle3 != null) {
                String str2 = "android_mem_info";
                bundle2 = new Bundle();
                bundle2.putString("runtime_free", Long.toString(bundle3.getLong("runtime_free_memory", -1)));
                bundle2.putString("runtime_max", Long.toString(bundle3.getLong("runtime_max_memory", -1)));
                bundle2.putString("runtime_total", Long.toString(bundle3.getLong("runtime_total_memory", -1)));
                bundle2.putString("web_view_count", Integer.toString(bundle3.getInt("web_view_count", 0)));
                MemoryInfo memoryInfo = (MemoryInfo) bundle3.getParcelable("debug_memory_info");
                if (memoryInfo != null) {
                    bundle2.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
                    bundle2.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
                    bundle2.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
                    bundle2.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
                    bundle2.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
                    bundle2.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
                    bundle2.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
                    bundle2.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
                    bundle2.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
                }
                bundle5.putBundle(str2, bundle2);
            }
            bundle7 = new Bundle();
            bundle7.putBundle("parental_controls", bundle4);
            if (!TextUtils.isEmpty(ecVar.l)) {
                bundle7.putString("package_version", ecVar.l);
            }
            bundle5.putBundle("play_store", bundle7);
            hashMap.put("device", bundle5);
            bundle4 = new Bundle();
            bundle4.putString("doritos", doVar.f);
            bundle4.putString("doritos_v2", doVar.g);
            if (((Boolean) akc.f().a(amn.aJ)).booleanValue()) {
                obj2 = null;
                boolean z = false;
                if (doVar.i != null) {
                    obj2 = doVar.i.getId();
                    z = doVar.i.isLimitAdTrackingEnabled();
                }
                if (TextUtils.isEmpty(obj2)) {
                    akc.a();
                    bundle4.putString("pdid", kb.b(context));
                    bundle4.putString("pdidtype", "ssaid");
                } else {
                    bundle4.putString("rdid", obj2);
                    bundle4.putBoolean("is_lat", z);
                    bundle4.putString("idtype", "adid");
                }
            }
            hashMap.put("pii", bundle4);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (location != null) {
                a((HashMap) hashMap, location);
            } else if (zzaef.c.a >= 2 && zzaef.c.k != null) {
                a((HashMap) hashMap, zzaef.c.k);
            }
            if (zzaef.a >= 2) {
                hashMap.put("quality_signals", zzaef.l);
            }
            if (zzaef.a >= 4 && zzaef.p) {
                hashMap.put("forceHttps", Boolean.valueOf(zzaef.p));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (zzaef.a >= 5) {
                hashMap.put("u_sd", Float.valueOf(zzaef.s));
                hashMap.put("sh", Integer.valueOf(zzaef.r));
                hashMap.put("sw", Integer.valueOf(zzaef.q));
            } else {
                hashMap.put("u_sd", Float.valueOf(ecVar.s));
                hashMap.put("sh", Integer.valueOf(ecVar.u));
                hashMap.put("sw", Integer.valueOf(ecVar.t));
            }
            if (zzaef.a >= 6) {
                if (!TextUtils.isEmpty(zzaef.t)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(zzaef.t));
                    } catch (Throwable e2) {
                        kk.c("Problem serializing view hierarchy to JSON", e2);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(zzaef.u));
            }
            if (zzaef.a >= 7) {
                hashMap.put("request_id", zzaef.v);
            }
            if (zzaef.a >= 12 && !TextUtils.isEmpty(zzaef.B)) {
                hashMap.put("anchor", zzaef.B);
            }
            if (zzaef.a >= 13) {
                hashMap.put("android_app_volume", Float.valueOf(zzaef.C));
            }
            if (zzaef.a >= 18) {
                hashMap.put("android_app_muted", Boolean.valueOf(zzaef.I));
            }
            if (zzaef.a >= 14 && zzaef.D > 0) {
                hashMap.put("target_api", Integer.valueOf(zzaef.D));
            }
            if (zzaef.a >= 15) {
                hashMap.put("scroll_index", Integer.valueOf(zzaef.E == -1 ? -1 : zzaef.E));
            }
            if (zzaef.a >= 16) {
                hashMap.put("_activity_context", Boolean.valueOf(zzaef.F));
            }
            if (zzaef.a >= 18) {
                if (!TextUtils.isEmpty(zzaef.J)) {
                    try {
                        hashMap.put("app_settings", new JSONObject(zzaef.J));
                    } catch (Throwable e22) {
                        kk.c("Problem creating json from app settings", e22);
                    }
                }
                hashMap.put("render_in_browser", Boolean.valueOf(zzaef.K));
            }
            if (zzaef.a >= 18) {
                hashMap.put("android_num_video_cache_tasks", Integer.valueOf(zzaef.L));
            }
            zzang zzang = zzaef.k;
            boolean z2 = zzaef.Z;
            boolean z3 = doVar.m;
            boolean z4 = zzaef.ab;
            bundle = new Bundle();
            bundle7 = new Bundle();
            bundle7.putString("cl", "193400285");
            bundle7.putString("rapid_rc", "dev");
            bundle7.putString("rapid_rollup", "HEAD");
            bundle.putBundle("build_meta", bundle7);
            bundle.putString("mf", Boolean.toString(((Boolean) akc.f().a(amn.bV)).booleanValue()));
            bundle.putBoolean("instant_app", z2);
            bundle.putBoolean("lite", zzang.e);
            bundle.putBoolean("local_service", z3);
            bundle.putBoolean("is_privileged_process", z4);
            hashMap.put("sdk_env", bundle);
            hashMap.put("cache_state", jSONObject);
            if (zzaef.a >= 19) {
                hashMap.put("gct", zzaef.N);
            }
            if (zzaef.a >= 21 && zzaef.P) {
                hashMap.put("de", "1");
            }
            if (((Boolean) akc.f().a(amn.aT)).booleanValue()) {
                a = zzaef.d.a;
                obj2 = (a.equals("interstitial_mb") || a.equals("reward_mb")) ? 1 : null;
                bundle4 = zzaef.Q;
                obj = bundle4 != null ? 1 : null;
                if (!(obj2 == null || obj == null)) {
                    bundle7 = new Bundle();
                    bundle7.putBundle("interstitial_pool", bundle4);
                    hashMap.put("counters", bundle7);
                }
            }
            if (zzaef.R != null) {
                hashMap.put("gmp_app_id", zzaef.R);
            }
            if (zzaef.S == null) {
                hashMap.put("fbs_aiid", "");
            } else if ("TIME_OUT".equals(zzaef.S)) {
                hashMap.put("sai_timeout", akc.f().a(amn.av));
            } else {
                hashMap.put("fbs_aiid", zzaef.S);
            }
            if (zzaef.T != null) {
                hashMap.put("fbs_aeid", zzaef.T);
            }
            if (zzaef.a >= 24) {
                hashMap.put("disable_ml", Boolean.valueOf(zzaef.aa));
            }
            a = (String) akc.f().a(amn.E);
            if (!(a == null || a.isEmpty())) {
                if (VERSION.SDK_INT >= ((Integer) akc.f().a(amn.F)).intValue()) {
                    HashMap hashMap2 = new HashMap();
                    for (String str3 : a.split(",")) {
                        hashMap2.put(str3, jz.a(str3));
                    }
                    hashMap.put("video_decoders", hashMap2);
                }
            }
            if (((Boolean) akc.f().a(amn.dg)).booleanValue()) {
                hashMap.put("omid_v", au.u().b(context));
            }
            if (!(zzaef.ac == null || zzaef.ac.isEmpty())) {
                hashMap.put("android_permissions", zzaef.ac);
            }
            if (kk.a(2)) {
                str = "Ad Request JSON: ";
                a = String.valueOf(au.e().a(hashMap).toString(2));
                hl.a(a.length() != 0 ? str.concat(a) : new String(str));
            }
            return au.e().a(hashMap);
        } catch (JSONException e3) {
            str = "Problem serializing ad request to JSON: ";
            a = String.valueOf(e3.getMessage());
            kk.e(a.length() != 0 ? str.concat(a) : new String(str));
            return null;
        }
    }

    public static JSONObject a(zzaej zzaej) {
        JSONObject jSONObject = new JSONObject();
        if (zzaej.a != null) {
            jSONObject.put("ad_base_url", zzaej.a);
        }
        if (zzaej.l != null) {
            jSONObject.put("ad_size", zzaej.l);
        }
        jSONObject.put("native", zzaej.s);
        if (zzaej.s) {
            jSONObject.put("ad_json", zzaej.b);
        } else {
            jSONObject.put("ad_html", zzaej.b);
        }
        if (zzaej.n != null) {
            jSONObject.put("debug_dialog", zzaej.n);
        }
        if (zzaej.L != null) {
            jSONObject.put("debug_signals", zzaej.L);
        }
        if (zzaej.f != -1) {
            jSONObject.put("interstitial_timeout", ((double) zzaej.f) / 1000.0d);
        }
        if (zzaej.k == au.g().b()) {
            jSONObject.put("orientation", Ad.ORIENTATION_PORTRAIT);
        } else if (zzaej.k == au.g().a()) {
            jSONObject.put("orientation", Ad.ORIENTATION_LANDSCAPE);
        }
        if (zzaej.c != null) {
            jSONObject.put("click_urls", a(zzaej.c));
        }
        if (zzaej.e != null) {
            jSONObject.put("impression_urls", a(zzaej.e));
        }
        if (zzaej.R != null) {
            jSONObject.put("downloaded_impression_urls", a(zzaej.R));
        }
        if (zzaej.i != null) {
            jSONObject.put("manual_impression_urls", a(zzaej.i));
        }
        if (zzaej.q != null) {
            jSONObject.put("active_view", zzaej.q);
        }
        jSONObject.put("ad_is_javascript", zzaej.o);
        if (zzaej.p != null) {
            jSONObject.put("ad_passback_url", zzaej.p);
        }
        jSONObject.put("mediation", zzaej.g);
        jSONObject.put("custom_render_allowed", zzaej.r);
        jSONObject.put("content_url_opted_out", zzaej.u);
        jSONObject.put("content_vertical_opted_out", zzaej.M);
        jSONObject.put("prefetch", zzaej.v);
        if (zzaej.j != -1) {
            jSONObject.put("refresh_interval_milliseconds", zzaej.j);
        }
        if (zzaej.h != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", zzaej.h);
        }
        if (!TextUtils.isEmpty(zzaej.x)) {
            jSONObject.put("gws_query_id", zzaej.x);
        }
        jSONObject.put("fluid", zzaej.y ? VastIconXmlManager.HEIGHT : "");
        jSONObject.put("native_express", zzaej.z);
        if (zzaej.B != null) {
            jSONObject.put("video_start_urls", a(zzaej.B));
        }
        if (zzaej.C != null) {
            jSONObject.put("video_complete_urls", a(zzaej.C));
        }
        if (zzaej.A != null) {
            zzaig zzaig = zzaej.A;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rb_type", zzaig.a);
            jSONObject2.put("rb_amount", zzaig.b);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("rewards", jSONArray);
        }
        jSONObject.put("use_displayed_impression", zzaej.D);
        jSONObject.put("auto_protection_configuration", zzaej.E);
        jSONObject.put("render_in_browser", zzaej.I);
        jSONObject.put("disable_closable_area", zzaej.S);
        return jSONObject;
    }

    private static void a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put(i.ki, valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put(c.ju, valueOf2);
        hashMap.put("uule", hashMap2);
    }
}
