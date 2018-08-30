package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.common.util.p;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@TargetApi(21)
@ParametersAreNonnullByDefault
final class gh {
    private static final Map<String, String> a;
    private final Context b;
    private final List<String> c;
    private final fx d;

    static {
        Map hashMap = new HashMap();
        if (p.i()) {
            hashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            hashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        a = hashMap;
    }

    gh(Context context, List<String> list, fx fxVar) {
        this.b = context;
        this.c = list;
        this.d = fxVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    final java.util.List<java.lang.String> a(java.lang.String[] r11) {
        /*
        r10 = this;
        r2 = 1;
        r1 = 0;
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = r11.length;
        r3 = r1;
    L_0x0009:
        if (r3 >= r5) goto L_0x007f;
    L_0x000b:
        r6 = r11[r3];
        r0 = r10.c;
        r7 = r0.iterator();
    L_0x0013:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x006f;
    L_0x0019:
        r0 = r7.next();
        r0 = (java.lang.String) r0;
        r8 = r0.equals(r6);
        if (r8 == 0) goto L_0x004d;
    L_0x0025:
        r0 = r2;
    L_0x0026:
        if (r0 == 0) goto L_0x0079;
    L_0x0028:
        r0 = a;
        r0 = r0.containsKey(r6);
        if (r0 == 0) goto L_0x0043;
    L_0x0030:
        com.google.android.gms.ads.internal.au.e();
        r7 = r10.b;
        r0 = a;
        r0 = r0.get(r6);
        r0 = (java.lang.String) r0;
        r0 = com.google.android.gms.internal.ads.ht.a(r7, r0);
        if (r0 == 0) goto L_0x0071;
    L_0x0043:
        r0 = r2;
    L_0x0044:
        if (r0 == 0) goto L_0x0073;
    L_0x0046:
        r4.add(r6);
    L_0x0049:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0009;
    L_0x004d:
        r8 = "android.webkit.resource.";
        r8 = java.lang.String.valueOf(r8);
        r0 = java.lang.String.valueOf(r0);
        r9 = r0.length();
        if (r9 == 0) goto L_0x0069;
    L_0x005d:
        r0 = r8.concat(r0);
    L_0x0061:
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x0013;
    L_0x0067:
        r0 = r2;
        goto L_0x0026;
    L_0x0069:
        r0 = new java.lang.String;
        r0.<init>(r8);
        goto L_0x0061;
    L_0x006f:
        r0 = r1;
        goto L_0x0026;
    L_0x0071:
        r0 = r1;
        goto L_0x0044;
    L_0x0073:
        r0 = r10.d;
        r0.b(r6);
        goto L_0x0049;
    L_0x0079:
        r0 = r10.d;
        r0.a(r6);
        goto L_0x0049;
    L_0x007f:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.gh.a(java.lang.String[]):java.util.List<java.lang.String>");
    }
}
