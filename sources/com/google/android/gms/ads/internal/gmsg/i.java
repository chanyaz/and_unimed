package com.google.android.gms.ads.internal.gmsg;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.bs;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.ada;
import com.google.android.gms.internal.ads.b;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzarr;
import com.google.android.gms.internal.ads.zzars;
import com.google.android.gms.internal.ads.zzarw;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzcj;
import com.google.android.gms.internal.ads.zzjd;
import java.util.Map;

@zzadh
public final class i<T extends zzarr & zzars & zzarw & zzarz & zzasb> implements zzv<T> {
    private final Context a;
    private final ada b;
    private final zzang c;
    private final zzt d;
    private final zzjd e;
    private final zzn f;
    private final zzb g;
    private final zzd h;
    private final bs i;
    private final b j;
    private final zzaqw k = null;

    public i(Context context, zzang zzang, ada ada, zzt zzt, zzjd zzjd, zzb zzb, zzd zzd, zzn zzn, bs bsVar, b bVar) {
        this.a = context;
        this.c = zzang;
        this.b = ada;
        this.d = zzt;
        this.e = zzjd;
        this.g = zzb;
        this.h = zzd;
        this.i = bsVar;
        this.j = bVar;
        this.f = zzn;
    }

    @VisibleForTesting
    static String a(Context context, ada ada, String str, View view, @Nullable Activity activity) {
        if (ada == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (ada.b(parse)) {
                parse = ada.a(parse, context, view, activity);
            }
            return parse.toString();
        } catch (zzcj e) {
            return str;
        } catch (Throwable e2) {
            au.i().a(e2, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
            return str;
        }
    }

    private final void a(boolean z) {
        if (this.j != null) {
            this.j.a(z);
        }
    }

    private static boolean a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return au.g().b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return au.g().a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return au.g().c();
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0121 A:{SYNTHETIC, Splitter: B:43:0x0121} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0146  */
    public final /* synthetic */ void zza(java.lang.Object r10, java.util.Map r11) {
        /*
        r9 = this;
        r5 = 1;
        r4 = 0;
        r10 = (com.google.android.gms.internal.ads.zzarr) r10;
        r1 = "u";
        r1 = r11.get(r1);
        r1 = (java.lang.String) r1;
        r2 = r10.getContext();
        r3 = com.google.android.gms.internal.ads.gn.a(r1, r2);
        r1 = "a";
        r1 = r11.get(r1);
        r1 = (java.lang.String) r1;
        if (r1 != 0) goto L_0x0024;
    L_0x001e:
        r1 = "Action missing from an open GMSG.";
        com.google.android.gms.internal.ads.kk.e(r1);
    L_0x0023:
        return;
    L_0x0024:
        r2 = r9.i;
        if (r2 == 0) goto L_0x0036;
    L_0x0028:
        r2 = r9.i;
        r2 = r2.b();
        if (r2 != 0) goto L_0x0036;
    L_0x0030:
        r1 = r9.i;
        r1.a(r3);
        goto L_0x0023;
    L_0x0036:
        r2 = "expand";
        r2 = r2.equalsIgnoreCase(r1);
        if (r2 == 0) goto L_0x005e;
    L_0x003e:
        r1 = r10;
        r1 = (com.google.android.gms.internal.ads.zzars) r1;
        r1 = r1.zzuj();
        if (r1 == 0) goto L_0x004d;
    L_0x0047:
        r1 = "Cannot expand WebView that is already expanded.";
        com.google.android.gms.internal.ads.kk.e(r1);
        goto L_0x0023;
    L_0x004d:
        r9.a(r4);
        r10 = (com.google.android.gms.internal.ads.zzarw) r10;
        r1 = a(r11);
        r2 = b(r11);
        r10.zza(r1, r2);
        goto L_0x0023;
    L_0x005e:
        r2 = "webapp";
        r2 = r2.equalsIgnoreCase(r1);
        if (r2 == 0) goto L_0x0097;
    L_0x0066:
        r9.a(r4);
        if (r3 == 0) goto L_0x0079;
    L_0x006b:
        r10 = (com.google.android.gms.internal.ads.zzarw) r10;
        r1 = a(r11);
        r2 = b(r11);
        r10.zza(r1, r2, r3);
        goto L_0x0023;
    L_0x0079:
        r10 = (com.google.android.gms.internal.ads.zzarw) r10;
        r3 = a(r11);
        r4 = b(r11);
        r1 = "html";
        r1 = r11.get(r1);
        r1 = (java.lang.String) r1;
        r2 = "baseurl";
        r2 = r11.get(r2);
        r2 = (java.lang.String) r2;
        r10.zza(r3, r4, r1, r2);
        goto L_0x0023;
    L_0x0097:
        r2 = "app";
        r1 = r2.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x00f3;
    L_0x009f:
        r2 = "true";
        r1 = "system_browser";
        r1 = r11.get(r1);
        r1 = (java.lang.String) r1;
        r1 = r2.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x00f3;
    L_0x00af:
        r9.a(r5);
        r10.getContext();
        r1 = android.text.TextUtils.isEmpty(r3);
        if (r1 == 0) goto L_0x00c2;
    L_0x00bb:
        r1 = "Destination url cannot be empty.";
        com.google.android.gms.internal.ads.kk.e(r1);
        goto L_0x0023;
    L_0x00c2:
        r2 = new com.google.android.gms.ads.internal.gmsg.j;
        r3 = r10.getContext();
        r1 = r10;
        r1 = (com.google.android.gms.internal.ads.zzarz) r1;
        r4 = r1.zzui();
        r1 = r10;
        r1 = (com.google.android.gms.internal.ads.zzasb) r1;
        r1 = r1.getView();
        r2.<init>(r3, r4, r1);
        r1 = r2.a(r11);
        r10 = (com.google.android.gms.internal.ads.zzarw) r10;	 Catch:{ ActivityNotFoundException -> 0x00e9 }
        r2 = new com.google.android.gms.ads.internal.overlay.zzc;	 Catch:{ ActivityNotFoundException -> 0x00e9 }
        r2.<init>(r1);	 Catch:{ ActivityNotFoundException -> 0x00e9 }
        r10.zza(r2);	 Catch:{ ActivityNotFoundException -> 0x00e9 }
        goto L_0x0023;
    L_0x00e9:
        r1 = move-exception;
        r1 = r1.getMessage();
        com.google.android.gms.internal.ads.kk.e(r1);
        goto L_0x0023;
    L_0x00f3:
        r9.a(r5);
        r1 = "intent_url";
        r1 = r11.get(r1);
        r1 = (java.lang.String) r1;
        r2 = 0;
        r4 = android.text.TextUtils.isEmpty(r1);
        if (r4 != 0) goto L_0x0166;
    L_0x0105:
        r4 = 0;
        r1 = android.content.Intent.parseUri(r1, r4);	 Catch:{ URISyntaxException -> 0x0152 }
        r5 = r1;
    L_0x010b:
        if (r5 == 0) goto L_0x0144;
    L_0x010d:
        r1 = r5.getData();
        if (r1 == 0) goto L_0x0144;
    L_0x0113:
        r2 = r5.getData();
        r4 = r2.toString();
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 != 0) goto L_0x019c;
    L_0x0121:
        r6 = r10.getContext();	 Catch:{ Exception -> 0x016e }
        r0 = r10;
        r0 = (com.google.android.gms.internal.ads.zzarz) r0;	 Catch:{ Exception -> 0x016e }
        r1 = r0;
        r7 = r1.zzui();	 Catch:{ Exception -> 0x016e }
        r0 = r10;
        r0 = (com.google.android.gms.internal.ads.zzasb) r0;	 Catch:{ Exception -> 0x016e }
        r1 = r0;
        r1 = r1.getView();	 Catch:{ Exception -> 0x016e }
        r8 = r10.zzto();	 Catch:{ Exception -> 0x016e }
        r1 = a(r6, r7, r4, r1, r8);	 Catch:{ Exception -> 0x016e }
    L_0x013d:
        r1 = android.net.Uri.parse(r1);	 Catch:{ Exception -> 0x017f }
    L_0x0141:
        r5.setData(r1);
    L_0x0144:
        if (r5 == 0) goto L_0x01a4;
    L_0x0146:
        r10 = (com.google.android.gms.internal.ads.zzarw) r10;
        r1 = new com.google.android.gms.ads.internal.overlay.zzc;
        r1.<init>(r5);
        r10.zza(r1);
        goto L_0x0023;
    L_0x0152:
        r4 = move-exception;
        r5 = "Error parsing the url: ";
        r1 = java.lang.String.valueOf(r1);
        r6 = r1.length();
        if (r6 == 0) goto L_0x0168;
    L_0x015f:
        r1 = r5.concat(r1);
    L_0x0163:
        com.google.android.gms.internal.ads.kk.b(r1, r4);
    L_0x0166:
        r5 = r2;
        goto L_0x010b;
    L_0x0168:
        r1 = new java.lang.String;
        r1.<init>(r5);
        goto L_0x0163;
    L_0x016e:
        r1 = move-exception;
        r6 = "Error occurred while adding signals.";
        com.google.android.gms.internal.ads.kk.b(r6, r1);
        r6 = com.google.android.gms.ads.internal.au.i();
        r7 = "OpenGmsgHandler.onGmsg";
        r6.a(r1, r7);
        r1 = r4;
        goto L_0x013d;
    L_0x017f:
        r4 = move-exception;
        r6 = "Error parsing the uri: ";
        r1 = java.lang.String.valueOf(r1);
        r7 = r1.length();
        if (r7 == 0) goto L_0x019e;
    L_0x018c:
        r1 = r6.concat(r1);
    L_0x0190:
        com.google.android.gms.internal.ads.kk.b(r1, r4);
        r1 = com.google.android.gms.ads.internal.au.i();
        r6 = "OpenGmsgHandler.onGmsg";
        r1.a(r4, r6);
    L_0x019c:
        r1 = r2;
        goto L_0x0141;
    L_0x019e:
        r1 = new java.lang.String;
        r1.<init>(r6);
        goto L_0x0190;
    L_0x01a4:
        r1 = android.text.TextUtils.isEmpty(r3);
        if (r1 != 0) goto L_0x01c4;
    L_0x01aa:
        r2 = r10.getContext();
        r1 = r10;
        r1 = (com.google.android.gms.internal.ads.zzarz) r1;
        r4 = r1.zzui();
        r1 = r10;
        r1 = (com.google.android.gms.internal.ads.zzasb) r1;
        r1 = r1.getView();
        r5 = r10.zzto();
        r3 = a(r2, r4, r3, r1, r5);
    L_0x01c4:
        r10 = (com.google.android.gms.internal.ads.zzarw) r10;
        r1 = new com.google.android.gms.ads.internal.overlay.zzc;
        r2 = "i";
        r2 = r11.get(r2);
        r2 = (java.lang.String) r2;
        r4 = "m";
        r4 = r11.get(r4);
        r4 = (java.lang.String) r4;
        r5 = "p";
        r5 = r11.get(r5);
        r5 = (java.lang.String) r5;
        r6 = "c";
        r6 = r11.get(r6);
        r6 = (java.lang.String) r6;
        r7 = "f";
        r7 = r11.get(r7);
        r7 = (java.lang.String) r7;
        r8 = "e";
        r8 = r11.get(r8);
        r8 = (java.lang.String) r8;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        r10.zza(r1);
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.i.zza(java.lang.Object, java.util.Map):void");
    }
}
