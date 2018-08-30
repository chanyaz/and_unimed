package com.google.android.gms.internal.ads;

@zzadh
public final class ahj {
    private final agz a;
    private final int b;
    private String c;
    private String d;
    private final boolean e = false;
    private final int f;
    private final int g;

    public ahj(int i, int i2, int i3) {
        this.b = i;
        if (i2 > 64 || i2 < 0) {
            this.f = 64;
        } else {
            this.f = i2;
        }
        if (i3 <= 0) {
            this.g = 1;
        } else {
            this.g = i3;
        }
        this.a = new ahh(this.f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x010f A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af  */
    public final java.lang.String a(java.util.ArrayList<java.lang.String> r14, java.util.ArrayList<com.google.android.gms.internal.ads.agy> r15) {
        /*
        r13 = this;
        r12 = 32;
        r4 = 1;
        r2 = 0;
        r0 = new com.google.android.gms.internal.ads.ahk;
        r0.<init>(r13);
        java.util.Collections.sort(r15, r0);
        r7 = new java.util.HashSet;
        r7.<init>();
        r1 = r2;
    L_0x0012:
        r0 = r15.size();
        if (r1 >= r0) goto L_0x0115;
    L_0x0018:
        r0 = r15.get(r1);
        r0 = (com.google.android.gms.internal.ads.agy) r0;
        r0 = r0.e();
        r0 = r14.get(r0);
        r0 = (java.lang.CharSequence) r0;
        r3 = java.text.Normalizer.Form.NFKC;
        r0 = java.text.Normalizer.normalize(r0, r3);
        r3 = java.util.Locale.US;
        r0 = r0.toLowerCase(r3);
        r3 = "\n";
        r8 = r0.split(r3);
        r0 = r8.length;
        if (r0 == 0) goto L_0x0113;
    L_0x003d:
        r0 = r2;
    L_0x003e:
        r3 = r8.length;
        if (r0 >= r3) goto L_0x0113;
    L_0x0041:
        r6 = r8[r0];
        r3 = "'";
        r3 = r6.indexOf(r3);
        r5 = -1;
        if (r3 == r5) goto L_0x0146;
    L_0x004c:
        r9 = new java.lang.StringBuilder;
        r9.<init>(r6);
        r3 = r4;
        r5 = r2;
    L_0x0053:
        r10 = r3 + 2;
        r11 = r9.length();
        if (r10 > r11) goto L_0x009c;
    L_0x005b:
        r10 = r9.charAt(r3);
        r11 = 39;
        if (r10 != r11) goto L_0x0095;
    L_0x0063:
        r5 = r3 + -1;
        r5 = r9.charAt(r5);
        if (r5 == r12) goto L_0x0098;
    L_0x006b:
        r5 = r3 + 1;
        r5 = r9.charAt(r5);
        r10 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        if (r5 == r10) goto L_0x007f;
    L_0x0075:
        r5 = r3 + 1;
        r5 = r9.charAt(r5);
        r10 = 83;
        if (r5 != r10) goto L_0x0098;
    L_0x007f:
        r5 = r3 + 2;
        r10 = r9.length();
        if (r5 == r10) goto L_0x008f;
    L_0x0087:
        r5 = r3 + 2;
        r5 = r9.charAt(r5);
        if (r5 != r12) goto L_0x0098;
    L_0x008f:
        r9.insert(r3, r12);
        r3 = r3 + 2;
    L_0x0094:
        r5 = r4;
    L_0x0095:
        r3 = r3 + 1;
        goto L_0x0053;
    L_0x0098:
        r9.setCharAt(r3, r12);
        goto L_0x0094;
    L_0x009c:
        if (r5 == 0) goto L_0x00d5;
    L_0x009e:
        r3 = r9.toString();
    L_0x00a2:
        if (r3 == 0) goto L_0x0146;
    L_0x00a4:
        r13.d = r3;
    L_0x00a6:
        r9 = com.google.android.gms.internal.ads.ahd.a(r3, r4);
        r3 = r9.length;
        r5 = r13.g;
        if (r3 < r5) goto L_0x010f;
    L_0x00af:
        r3 = r2;
    L_0x00b0:
        r5 = r9.length;
        if (r3 >= r5) goto L_0x0105;
    L_0x00b3:
        r5 = "";
        r6 = r2;
    L_0x00b6:
        r10 = r13.g;
        if (r6 >= r10) goto L_0x0143;
    L_0x00ba:
        r10 = r3 + r6;
        r11 = r9.length;
        if (r10 < r11) goto L_0x00d7;
    L_0x00bf:
        r6 = r2;
    L_0x00c0:
        if (r6 == 0) goto L_0x0105;
    L_0x00c2:
        r7.add(r5);
        r5 = r7.size();
        r6 = r13.b;
        if (r5 < r6) goto L_0x0102;
    L_0x00cd:
        r0 = r2;
    L_0x00ce:
        if (r0 == 0) goto L_0x0115;
    L_0x00d0:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0012;
    L_0x00d5:
        r3 = 0;
        goto L_0x00a2;
    L_0x00d7:
        if (r6 <= 0) goto L_0x00e3;
    L_0x00d9:
        r5 = java.lang.String.valueOf(r5);
        r10 = " ";
        r5 = r5.concat(r10);
    L_0x00e3:
        r10 = java.lang.String.valueOf(r5);
        r5 = r3 + r6;
        r5 = r9[r5];
        r5 = java.lang.String.valueOf(r5);
        r11 = r5.length();
        if (r11 == 0) goto L_0x00fc;
    L_0x00f5:
        r5 = r10.concat(r5);
    L_0x00f9:
        r6 = r6 + 1;
        goto L_0x00b6;
    L_0x00fc:
        r5 = new java.lang.String;
        r5.<init>(r10);
        goto L_0x00f9;
    L_0x0102:
        r3 = r3 + 1;
        goto L_0x00b0;
    L_0x0105:
        r3 = r7.size();
        r5 = r13.b;
        if (r3 < r5) goto L_0x010f;
    L_0x010d:
        r0 = r2;
        goto L_0x00ce;
    L_0x010f:
        r0 = r0 + 1;
        goto L_0x003e;
    L_0x0113:
        r0 = r4;
        goto L_0x00ce;
    L_0x0115:
        r1 = new com.google.android.gms.internal.ads.ahc;
        r1.<init>();
        r0 = "";
        r13.c = r0;
        r2 = r7.iterator();
    L_0x0122:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x013e;
    L_0x0128:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r3 = r13.a;	 Catch:{ IOException -> 0x0138 }
        r0 = r3.a(r0);	 Catch:{ IOException -> 0x0138 }
        r1.a(r0);	 Catch:{ IOException -> 0x0138 }
        goto L_0x0122;
    L_0x0138:
        r0 = move-exception;
        r2 = "Error while writing hash to byteStream";
        com.google.android.gms.internal.ads.kk.b(r2, r0);
    L_0x013e:
        r0 = r1.toString();
        return r0;
    L_0x0143:
        r6 = r4;
        goto L_0x00c0;
    L_0x0146:
        r3 = r6;
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahj.a(java.util.ArrayList, java.util.ArrayList):java.lang.String");
    }
}
