package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class cr extends hv {
    cr(hw hwVar) {
        super(hwVar);
    }

    private final Boolean a(double d, ik ikVar) {
        try {
            return a(new BigDecimal(d), ikVar, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean a(long j, ik ikVar) {
        try {
            return a(new BigDecimal(j), ikVar, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean a(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!(z || i == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException e) {
                    zzge().u().a("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean a(String str, ik ikVar) {
        Boolean bool = null;
        if (!ie.j(str)) {
            return bool;
        }
        try {
            return a(new BigDecimal(str), ikVar, 0.0d);
        } catch (NumberFormatException e) {
            return bool;
        }
    }

    @VisibleForTesting
    private final Boolean a(String str, im imVar) {
        int i = 0;
        String str2 = null;
        ar.a((Object) imVar);
        if (str == null || imVar.c == null || imVar.c.intValue() == 0) {
            return null;
        }
        List list;
        if (imVar.c.intValue() == 6) {
            if (imVar.f == null || imVar.f.length == 0) {
                return null;
            }
        } else if (imVar.d == null) {
            return null;
        }
        int intValue = imVar.c.intValue();
        boolean z = imVar.e != null && imVar.e.booleanValue();
        String toUpperCase = (z || intValue == 1 || intValue == 6) ? imVar.d : imVar.d.toUpperCase(Locale.ENGLISH);
        if (imVar.f == null) {
            list = null;
        } else {
            String[] strArr = imVar.f;
            if (z) {
                list = Arrays.asList(strArr);
            } else {
                list = new ArrayList();
                int length = strArr.length;
                while (i < length) {
                    list.add(strArr[i].toUpperCase(Locale.ENGLISH));
                    i++;
                }
            }
        }
        if (intValue == 1) {
            str2 = toUpperCase;
        }
        return a(str, intValue, z, toUpperCase, list, str2);
    }

    /* JADX WARNING: Missing block: B:38:0x007e, code:
            if (r5 != null) goto L_0x0080;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    private static java.lang.Boolean a(java.math.BigDecimal r10, com.google.android.gms.internal.measurement.ik r11, double r12) {
        /*
        r8 = 4;
        r7 = -1;
        r1 = 0;
        r0 = 1;
        r2 = 0;
        com.google.android.gms.common.internal.ar.a(r11);
        r3 = r11.c;
        if (r3 == 0) goto L_0x0014;
    L_0x000c:
        r3 = r11.c;
        r3 = r3.intValue();
        if (r3 != 0) goto L_0x0016;
    L_0x0014:
        r0 = r2;
    L_0x0015:
        return r0;
    L_0x0016:
        r3 = r11.c;
        r3 = r3.intValue();
        if (r3 != r8) goto L_0x0028;
    L_0x001e:
        r3 = r11.f;
        if (r3 == 0) goto L_0x0026;
    L_0x0022:
        r3 = r11.g;
        if (r3 != 0) goto L_0x002e;
    L_0x0026:
        r0 = r2;
        goto L_0x0015;
    L_0x0028:
        r3 = r11.e;
        if (r3 != 0) goto L_0x002e;
    L_0x002c:
        r0 = r2;
        goto L_0x0015;
    L_0x002e:
        r3 = r11.c;
        r6 = r3.intValue();
        r3 = r11.c;
        r3 = r3.intValue();
        if (r3 != r8) goto L_0x0066;
    L_0x003c:
        r3 = r11.f;
        r3 = com.google.android.gms.internal.measurement.ie.j(r3);
        if (r3 == 0) goto L_0x004c;
    L_0x0044:
        r3 = r11.g;
        r3 = com.google.android.gms.internal.measurement.ie.j(r3);
        if (r3 != 0) goto L_0x004e;
    L_0x004c:
        r0 = r2;
        goto L_0x0015;
    L_0x004e:
        r4 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0063 }
        r3 = r11.f;	 Catch:{ NumberFormatException -> 0x0063 }
        r4.<init>(r3);	 Catch:{ NumberFormatException -> 0x0063 }
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0063 }
        r5 = r11.g;	 Catch:{ NumberFormatException -> 0x0063 }
        r3.<init>(r5);	 Catch:{ NumberFormatException -> 0x0063 }
        r5 = r2;
    L_0x005d:
        if (r6 != r8) goto L_0x007e;
    L_0x005f:
        if (r4 != 0) goto L_0x0080;
    L_0x0061:
        r0 = r2;
        goto L_0x0015;
    L_0x0063:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0015;
    L_0x0066:
        r3 = r11.e;
        r3 = com.google.android.gms.internal.measurement.ie.j(r3);
        if (r3 != 0) goto L_0x0070;
    L_0x006e:
        r0 = r2;
        goto L_0x0015;
    L_0x0070:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x007b }
        r4 = r11.e;	 Catch:{ NumberFormatException -> 0x007b }
        r3.<init>(r4);	 Catch:{ NumberFormatException -> 0x007b }
        r4 = r2;
        r5 = r3;
        r3 = r2;
        goto L_0x005d;
    L_0x007b:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0015;
    L_0x007e:
        if (r5 == 0) goto L_0x0083;
    L_0x0080:
        switch(r6) {
            case 1: goto L_0x0085;
            case 2: goto L_0x0092;
            case 3: goto L_0x00a0;
            case 4: goto L_0x00ee;
            default: goto L_0x0083;
        };
    L_0x0083:
        r0 = r2;
        goto L_0x0015;
    L_0x0085:
        r2 = r10.compareTo(r5);
        if (r2 != r7) goto L_0x0090;
    L_0x008b:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x0090:
        r0 = r1;
        goto L_0x008b;
    L_0x0092:
        r2 = r10.compareTo(r5);
        if (r2 != r0) goto L_0x009e;
    L_0x0098:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x009e:
        r0 = r1;
        goto L_0x0098;
    L_0x00a0:
        r2 = 0;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x00e0;
    L_0x00a6:
        r2 = new java.math.BigDecimal;
        r2.<init>(r12);
        r3 = new java.math.BigDecimal;
        r4 = 2;
        r3.<init>(r4);
        r2 = r2.multiply(r3);
        r2 = r5.subtract(r2);
        r2 = r10.compareTo(r2);
        if (r2 != r0) goto L_0x00de;
    L_0x00bf:
        r2 = new java.math.BigDecimal;
        r2.<init>(r12);
        r3 = new java.math.BigDecimal;
        r4 = 2;
        r3.<init>(r4);
        r2 = r2.multiply(r3);
        r2 = r5.add(r2);
        r2 = r10.compareTo(r2);
        if (r2 != r7) goto L_0x00de;
    L_0x00d8:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x00de:
        r0 = r1;
        goto L_0x00d8;
    L_0x00e0:
        r2 = r10.compareTo(r5);
        if (r2 != 0) goto L_0x00ec;
    L_0x00e6:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x00ec:
        r0 = r1;
        goto L_0x00e6;
    L_0x00ee:
        r2 = r10.compareTo(r4);
        if (r2 == r7) goto L_0x0100;
    L_0x00f4:
        r2 = r10.compareTo(r3);
        if (r2 == r0) goto L_0x0100;
    L_0x00fa:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x0100:
        r0 = r1;
        goto L_0x00fa;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cr.a(java.math.BigDecimal, com.google.android.gms.internal.measurement.ik, double):java.lang.Boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:212:0x076a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x076d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0bc2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02ac  */
    @android.support.annotation.WorkerThread
    final com.google.android.gms.internal.measurement.iq[] a(java.lang.String r37, com.google.android.gms.internal.measurement.ir[] r38, com.google.android.gms.internal.measurement.iw[] r39) {
        /*
        r36 = this;
        com.google.android.gms.common.internal.ar.a(r37);
        r26 = new java.util.HashSet;
        r26.<init>();
        r27 = new android.support.v4.util.a;
        r27.<init>();
        r28 = new android.support.v4.util.a;
        r28.<init>();
        r29 = new android.support.v4.util.a;
        r29.<init>();
        r4 = r36.a_();
        r0 = r37;
        r8 = r4.e(r0);
        if (r8 == 0) goto L_0x00e1;
    L_0x0023:
        r4 = r8.keySet();
        r9 = r4.iterator();
    L_0x002b:
        r4 = r9.hasNext();
        if (r4 == 0) goto L_0x00e1;
    L_0x0031:
        r4 = r9.next();
        r4 = (java.lang.Integer) r4;
        r10 = r4.intValue();
        r4 = java.lang.Integer.valueOf(r10);
        r4 = r8.get(r4);
        r4 = (com.google.android.gms.internal.measurement.iv) r4;
        r5 = java.lang.Integer.valueOf(r10);
        r0 = r28;
        r5 = r0.get(r5);
        r5 = (java.util.BitSet) r5;
        r6 = java.lang.Integer.valueOf(r10);
        r0 = r29;
        r6 = r0.get(r6);
        r6 = (java.util.BitSet) r6;
        if (r5 != 0) goto L_0x007b;
    L_0x005f:
        r5 = new java.util.BitSet;
        r5.<init>();
        r6 = java.lang.Integer.valueOf(r10);
        r0 = r28;
        r0.put(r6, r5);
        r6 = new java.util.BitSet;
        r6.<init>();
        r7 = java.lang.Integer.valueOf(r10);
        r0 = r29;
        r0.put(r7, r6);
    L_0x007b:
        r7 = 0;
    L_0x007c:
        r11 = r4.c;
        r11 = r11.length;
        r11 = r11 << 6;
        if (r7 >= r11) goto L_0x00b1;
    L_0x0083:
        r11 = r4.c;
        r11 = com.google.android.gms.internal.measurement.ie.a(r11, r7);
        if (r11 == 0) goto L_0x00ae;
    L_0x008b:
        r11 = r36.zzge();
        r11 = r11.y();
        r12 = "Filter already evaluated. audience ID, filter ID";
        r13 = java.lang.Integer.valueOf(r10);
        r14 = java.lang.Integer.valueOf(r7);
        r11.a(r12, r13, r14);
        r6.set(r7);
        r11 = r4.d;
        r11 = com.google.android.gms.internal.measurement.ie.a(r11, r7);
        if (r11 == 0) goto L_0x00ae;
    L_0x00ab:
        r5.set(r7);
    L_0x00ae:
        r7 = r7 + 1;
        goto L_0x007c;
    L_0x00b1:
        r7 = new com.google.android.gms.internal.measurement.iq;
        r7.<init>();
        r10 = java.lang.Integer.valueOf(r10);
        r0 = r27;
        r0.put(r10, r7);
        r10 = 0;
        r10 = java.lang.Boolean.valueOf(r10);
        r7.f = r10;
        r7.e = r4;
        r4 = new com.google.android.gms.internal.measurement.iv;
        r4.<init>();
        r7.d = r4;
        r4 = r7.d;
        r5 = com.google.android.gms.internal.measurement.ie.a(r5);
        r4.d = r5;
        r4 = r7.d;
        r5 = com.google.android.gms.internal.measurement.ie.a(r6);
        r4.c = r5;
        goto L_0x002b;
    L_0x00e1:
        if (r38 == 0) goto L_0x0787;
    L_0x00e3:
        r10 = 0;
        r8 = 0;
        r5 = 0;
        r30 = new android.support.v4.util.a;
        r30.<init>();
        r0 = r38;
        r0 = r0.length;
        r31 = r0;
        r4 = 0;
        r25 = r4;
    L_0x00f4:
        r0 = r25;
        r1 = r31;
        if (r0 >= r1) goto L_0x0787;
    L_0x00fa:
        r14 = r38[r25];
        r11 = r14.d;
        r12 = r14.c;
        r4 = r36.o();
        r6 = com.google.android.gms.internal.measurement.dg.O;
        r0 = r37;
        r4 = r4.d(r0, r6);
        if (r4 == 0) goto L_0x0ba7;
    L_0x010e:
        r36.l();
        r4 = "_eid";
        r7 = com.google.android.gms.internal.measurement.ie.b(r14, r4);
        r7 = (java.lang.Long) r7;
        if (r7 == 0) goto L_0x014e;
    L_0x011b:
        r4 = 1;
        r6 = r4;
    L_0x011d:
        if (r6 == 0) goto L_0x0151;
    L_0x011f:
        r4 = "_ep";
        r4 = r11.equals(r4);
        if (r4 == 0) goto L_0x0151;
    L_0x0127:
        r4 = 1;
    L_0x0128:
        if (r4 == 0) goto L_0x02f5;
    L_0x012a:
        r36.l();
        r4 = "_en";
        r4 = com.google.android.gms.internal.measurement.ie.b(r14, r4);
        r11 = r4;
        r11 = (java.lang.String) r11;
        r4 = android.text.TextUtils.isEmpty(r11);
        if (r4 == 0) goto L_0x0153;
    L_0x013c:
        r4 = r36.zzge();
        r4 = r4.r();
        r6 = "Extra parameter without an event name. eventId";
        r4.a(r6, r7);
    L_0x0149:
        r4 = r25 + 1;
        r25 = r4;
        goto L_0x00f4;
    L_0x014e:
        r4 = 0;
        r6 = r4;
        goto L_0x011d;
    L_0x0151:
        r4 = 0;
        goto L_0x0128;
    L_0x0153:
        if (r10 == 0) goto L_0x0163;
    L_0x0155:
        if (r5 == 0) goto L_0x0163;
    L_0x0157:
        r16 = r7.longValue();
        r18 = r5.longValue();
        r4 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r4 == 0) goto L_0x0bb3;
    L_0x0163:
        r4 = r36.a_();
        r0 = r37;
        r6 = r4.a(r0, r7);
        if (r6 == 0) goto L_0x0173;
    L_0x016f:
        r4 = r6.first;
        if (r4 != 0) goto L_0x0181;
    L_0x0173:
        r4 = r36.zzge();
        r4 = r4.r();
        r6 = "Extra parameter without existing main event. eventName, eventId";
        r4.a(r6, r11, r7);
        goto L_0x0149;
    L_0x0181:
        r4 = r6.first;
        r4 = (com.google.android.gms.internal.measurement.ir) r4;
        r5 = r6.second;
        r5 = (java.lang.Long) r5;
        r8 = r5.longValue();
        r36.l();
        r5 = "_eid";
        r5 = com.google.android.gms.internal.measurement.ie.b(r4, r5);
        r5 = (java.lang.Long) r5;
        r13 = r5;
        r10 = r4;
    L_0x019a:
        r4 = 1;
        r8 = r8 - r4;
        r4 = 0;
        r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x0202;
    L_0x01a3:
        r5 = r36.a_();
        r5.c();
        r4 = r5.zzge();
        r4 = r4.y();
        r6 = "Clearing complex main event info. appId";
        r0 = r37;
        r4.a(r6, r0);
        r4 = r5.t();	 Catch:{ SQLiteException -> 0x01f3 }
        r6 = "delete from main_event_params where app_id=?";
        r7 = 1;
        r7 = new java.lang.String[r7];	 Catch:{ SQLiteException -> 0x01f3 }
        r15 = 0;
        r7[r15] = r37;	 Catch:{ SQLiteException -> 0x01f3 }
        r4.execSQL(r6, r7);	 Catch:{ SQLiteException -> 0x01f3 }
    L_0x01c8:
        r4 = r10.c;
        r4 = r4.length;
        r5 = r12.length;
        r4 = r4 + r5;
        r6 = new com.google.android.gms.internal.measurement.is[r4];
        r5 = 0;
        r15 = r10.c;
        r0 = r15.length;
        r16 = r0;
        r4 = 0;
        r7 = r4;
    L_0x01d7:
        r0 = r16;
        if (r7 >= r0) goto L_0x020c;
    L_0x01db:
        r17 = r15[r7];
        r36.l();
        r0 = r17;
        r4 = r0.c;
        r4 = com.google.android.gms.internal.measurement.ie.a(r14, r4);
        if (r4 != 0) goto L_0x0bc5;
    L_0x01ea:
        r4 = r5 + 1;
        r6[r5] = r17;
    L_0x01ee:
        r5 = r7 + 1;
        r7 = r5;
        r5 = r4;
        goto L_0x01d7;
    L_0x01f3:
        r4 = move-exception;
        r5 = r5.zzge();
        r5 = r5.r();
        r6 = "Error clearing complex main event";
        r5.a(r6, r4);
        goto L_0x01c8;
    L_0x0202:
        r5 = r36.a_();
        r6 = r37;
        r5.a(r6, r7, r8, r10);
        goto L_0x01c8;
    L_0x020c:
        if (r5 <= 0) goto L_0x02dc;
    L_0x020e:
        r15 = r12.length;
        r4 = 0;
    L_0x0210:
        if (r4 >= r15) goto L_0x021c;
    L_0x0212:
        r16 = r12[r4];
        r7 = r5 + 1;
        r6[r5] = r16;
        r4 = r4 + 1;
        r5 = r7;
        goto L_0x0210;
    L_0x021c:
        r4 = r6.length;
        if (r5 != r4) goto L_0x02d4;
    L_0x021f:
        r4 = r6;
    L_0x0220:
        r19 = r4;
        r20 = r11;
        r21 = r13;
        r22 = r8;
        r24 = r10;
    L_0x022a:
        r4 = r36.a_();
        r5 = r14.d;
        r0 = r37;
        r4 = r4.a(r0, r5);
        if (r4 != 0) goto L_0x0345;
    L_0x0238:
        r4 = r36.zzge();
        r4 = r4.u();
        r5 = "Event aggregate wasn't created during raw event logging. appId, event";
        r6 = com.google.android.gms.internal.measurement.dp.a(r37);
        r7 = r36.k();
        r0 = r20;
        r7 = r7.a(r0);
        r4.a(r5, r6, r7);
        r5 = new com.google.android.gms.internal.measurement.dc;
        r7 = r14.d;
        r8 = 1;
        r10 = 1;
        r4 = r14.e;
        r12 = r4.longValue();
        r14 = 0;
        r16 = 0;
        r17 = 0;
        r18 = 0;
        r6 = r37;
        r5.<init>(r6, r7, r8, r10, r12, r14, r16, r17, r18);
    L_0x026e:
        r4 = r36.a_();
        r4.a(r5);
        r12 = r5.c;
        r0 = r30;
        r1 = r20;
        r4 = r0.get(r1);
        r4 = (java.util.Map) r4;
        if (r4 != 0) goto L_0x0bc2;
    L_0x0283:
        r4 = r36.a_();
        r0 = r37;
        r1 = r20;
        r4 = r4.f(r0, r1);
        if (r4 != 0) goto L_0x0296;
    L_0x0291:
        r4 = new android.support.v4.util.a;
        r4.<init>();
    L_0x0296:
        r0 = r30;
        r1 = r20;
        r0.put(r1, r4);
        r7 = r4;
    L_0x029e:
        r4 = r7.keySet();
        r11 = r4.iterator();
    L_0x02a6:
        r4 = r11.hasNext();
        if (r4 == 0) goto L_0x0bba;
    L_0x02ac:
        r4 = r11.next();
        r4 = (java.lang.Integer) r4;
        r14 = r4.intValue();
        r4 = java.lang.Integer.valueOf(r14);
        r0 = r26;
        r4 = r0.contains(r4);
        if (r4 == 0) goto L_0x034b;
    L_0x02c2:
        r4 = r36.zzge();
        r4 = r4.y();
        r5 = "Skipping failed audience ID";
        r6 = java.lang.Integer.valueOf(r14);
        r4.a(r5, r6);
        goto L_0x02a6;
    L_0x02d4:
        r4 = java.util.Arrays.copyOf(r6, r5);
        r4 = (com.google.android.gms.internal.measurement.is[]) r4;
        goto L_0x0220;
    L_0x02dc:
        r4 = r36.zzge();
        r4 = r4.u();
        r5 = "No unique parameters in main event. eventName";
        r4.a(r5, r11);
        r19 = r12;
        r20 = r11;
        r21 = r13;
        r22 = r8;
        r24 = r10;
        goto L_0x022a;
    L_0x02f5:
        if (r6 == 0) goto L_0x0ba7;
    L_0x02f7:
        r36.l();
        r5 = "_epc";
        r8 = 0;
        r4 = java.lang.Long.valueOf(r8);
        r5 = com.google.android.gms.internal.measurement.ie.b(r14, r5);
        if (r5 != 0) goto L_0x032d;
    L_0x0308:
        r4 = (java.lang.Long) r4;
        r8 = r4.longValue();
        r4 = 0;
        r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x032f;
    L_0x0314:
        r4 = r36.zzge();
        r4 = r4.u();
        r5 = "Complex event with zero extra param count. eventName";
        r4.a(r5, r11);
        r19 = r12;
        r20 = r11;
        r21 = r7;
        r22 = r8;
        r24 = r14;
        goto L_0x022a;
    L_0x032d:
        r4 = r5;
        goto L_0x0308;
    L_0x032f:
        r5 = r36.a_();
        r6 = r37;
        r10 = r14;
        r5.a(r6, r7, r8, r10);
        r19 = r12;
        r20 = r11;
        r21 = r7;
        r22 = r8;
        r24 = r14;
        goto L_0x022a;
    L_0x0345:
        r5 = r4.a();
        goto L_0x026e;
    L_0x034b:
        r4 = java.lang.Integer.valueOf(r14);
        r0 = r27;
        r4 = r0.get(r4);
        r4 = (com.google.android.gms.internal.measurement.iq) r4;
        r5 = java.lang.Integer.valueOf(r14);
        r0 = r28;
        r5 = r0.get(r5);
        r5 = (java.util.BitSet) r5;
        r6 = java.lang.Integer.valueOf(r14);
        r0 = r29;
        r6 = r0.get(r6);
        r6 = (java.util.BitSet) r6;
        if (r4 != 0) goto L_0x0bb6;
    L_0x0371:
        r4 = new com.google.android.gms.internal.measurement.iq;
        r4.<init>();
        r5 = java.lang.Integer.valueOf(r14);
        r0 = r27;
        r0.put(r5, r4);
        r5 = 1;
        r5 = java.lang.Boolean.valueOf(r5);
        r4.f = r5;
        r5 = new java.util.BitSet;
        r5.<init>();
        r4 = java.lang.Integer.valueOf(r14);
        r0 = r28;
        r0.put(r4, r5);
        r6 = new java.util.BitSet;
        r6.<init>();
        r4 = java.lang.Integer.valueOf(r14);
        r0 = r29;
        r0.put(r4, r6);
        r8 = r6;
        r9 = r5;
    L_0x03a4:
        r4 = java.lang.Integer.valueOf(r14);
        r4 = r7.get(r4);
        r4 = (java.util.List) r4;
        r15 = r4.iterator();
    L_0x03b2:
        r4 = r15.hasNext();
        if (r4 == 0) goto L_0x02a6;
    L_0x03b8:
        r4 = r15.next();
        r4 = (com.google.android.gms.internal.measurement.ii) r4;
        r5 = r36.zzge();
        r6 = 2;
        r5 = r5.a(r6);
        if (r5 == 0) goto L_0x0403;
    L_0x03c9:
        r5 = r36.zzge();
        r5 = r5.y();
        r6 = "Evaluating filter. audience, filter, event";
        r10 = java.lang.Integer.valueOf(r14);
        r0 = r4.c;
        r16 = r0;
        r17 = r36.k();
        r0 = r4.d;
        r18 = r0;
        r17 = r17.a(r18);
        r0 = r16;
        r1 = r17;
        r5.a(r6, r10, r0, r1);
        r5 = r36.zzge();
        r5 = r5.y();
        r6 = "Filter definition";
        r10 = r36.k();
        r10 = r10.a(r4);
        r5.a(r6, r10);
    L_0x0403:
        r5 = r4.c;
        if (r5 == 0) goto L_0x0411;
    L_0x0407:
        r5 = r4.c;
        r5 = r5.intValue();
        r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r5 <= r6) goto L_0x0429;
    L_0x0411:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "Invalid event filter ID. appId, id";
        r10 = com.google.android.gms.internal.measurement.dp.a(r37);
        r4 = r4.c;
        r4 = java.lang.String.valueOf(r4);
        r5.a(r6, r10, r4);
        goto L_0x03b2;
    L_0x0429:
        r5 = r4.c;
        r5 = r5.intValue();
        r5 = r9.get(r5);
        if (r5 == 0) goto L_0x044a;
    L_0x0435:
        r5 = r36.zzge();
        r5 = r5.y();
        r6 = "Event filter already evaluated true. audience ID, filter ID";
        r10 = java.lang.Integer.valueOf(r14);
        r4 = r4.c;
        r5.a(r6, r10, r4);
        goto L_0x03b2;
    L_0x044a:
        r5 = r4.f;
        if (r5 == 0) goto L_0x0485;
    L_0x044e:
        r5 = r4.f;
        r0 = r36;
        r5 = r0.a(r12, r5);
        if (r5 != 0) goto L_0x0479;
    L_0x0458:
        r5 = 0;
    L_0x0459:
        r6 = r36.zzge();
        r10 = r6.y();
        r16 = "Event filter result";
        if (r5 != 0) goto L_0x076a;
    L_0x0465:
        r6 = "null";
    L_0x0467:
        r0 = r16;
        r10.a(r0, r6);
        if (r5 != 0) goto L_0x076d;
    L_0x046e:
        r4 = java.lang.Integer.valueOf(r14);
        r0 = r26;
        r0.add(r4);
        goto L_0x03b2;
    L_0x0479:
        r5 = r5.booleanValue();
        if (r5 != 0) goto L_0x0485;
    L_0x047f:
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        goto L_0x0459;
    L_0x0485:
        r6 = new java.util.HashSet;
        r6.<init>();
        r10 = r4.e;
        r0 = r10.length;
        r16 = r0;
        r5 = 0;
    L_0x0490:
        r0 = r16;
        if (r5 >= r0) goto L_0x04c9;
    L_0x0494:
        r17 = r10[r5];
        r0 = r17;
        r0 = r0.f;
        r18 = r0;
        r18 = android.text.TextUtils.isEmpty(r18);
        if (r18 == 0) goto L_0x04bb;
    L_0x04a2:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "null or empty param name in filter. event";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r5.a(r6, r10);
        r5 = 0;
        goto L_0x0459;
    L_0x04bb:
        r0 = r17;
        r0 = r0.f;
        r17 = r0;
        r0 = r17;
        r6.add(r0);
        r5 = r5 + 1;
        goto L_0x0490;
    L_0x04c9:
        r16 = new android.support.v4.util.a;
        r16.<init>();
        r0 = r19;
        r10 = r0.length;
        r5 = 0;
    L_0x04d2:
        if (r5 >= r10) goto L_0x056a;
    L_0x04d4:
        r17 = r19[r5];
        r0 = r17;
        r0 = r0.c;
        r18 = r0;
        r0 = r18;
        r18 = r6.contains(r0);
        if (r18 == 0) goto L_0x0501;
    L_0x04e4:
        r0 = r17;
        r0 = r0.e;
        r18 = r0;
        if (r18 == 0) goto L_0x0504;
    L_0x04ec:
        r0 = r17;
        r0 = r0.c;
        r18 = r0;
        r0 = r17;
        r0 = r0.e;
        r17 = r0;
        r0 = r16;
        r1 = r18;
        r2 = r17;
        r0.put(r1, r2);
    L_0x0501:
        r5 = r5 + 1;
        goto L_0x04d2;
    L_0x0504:
        r0 = r17;
        r0 = r0.f;
        r18 = r0;
        if (r18 == 0) goto L_0x0522;
    L_0x050c:
        r0 = r17;
        r0 = r0.c;
        r18 = r0;
        r0 = r17;
        r0 = r0.f;
        r17 = r0;
        r0 = r16;
        r1 = r18;
        r2 = r17;
        r0.put(r1, r2);
        goto L_0x0501;
    L_0x0522:
        r0 = r17;
        r0 = r0.d;
        r18 = r0;
        if (r18 == 0) goto L_0x0540;
    L_0x052a:
        r0 = r17;
        r0 = r0.c;
        r18 = r0;
        r0 = r17;
        r0 = r0.d;
        r17 = r0;
        r0 = r16;
        r1 = r18;
        r2 = r17;
        r0.put(r1, r2);
        goto L_0x0501;
    L_0x0540:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "Unknown value for param. event, param";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r16 = r36.k();
        r0 = r17;
        r0 = r0.c;
        r17 = r0;
        r16 = r16.b(r17);
        r0 = r16;
        r5.a(r6, r10, r0);
        r5 = 0;
        goto L_0x0459;
    L_0x056a:
        r0 = r4.e;
        r17 = r0;
        r0 = r17;
        r0 = r0.length;
        r18 = r0;
        r5 = 0;
        r10 = r5;
    L_0x0575:
        r0 = r18;
        if (r10 >= r0) goto L_0x0763;
    L_0x0579:
        r32 = r17[r10];
        r5 = java.lang.Boolean.TRUE;
        r0 = r32;
        r6 = r0.e;
        r33 = r5.equals(r6);
        r0 = r32;
        r0 = r0.f;
        r34 = r0;
        r5 = android.text.TextUtils.isEmpty(r34);
        if (r5 == 0) goto L_0x05ab;
    L_0x0591:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "Event has empty param name. event";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r5.a(r6, r10);
        r5 = 0;
        goto L_0x0459;
    L_0x05ab:
        r0 = r16;
        r1 = r34;
        r5 = r0.get(r1);
        r6 = r5 instanceof java.lang.Long;
        if (r6 == 0) goto L_0x0610;
    L_0x05b7:
        r0 = r32;
        r6 = r0.d;
        if (r6 != 0) goto L_0x05e5;
    L_0x05bd:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "No number filter for long param. event, param";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r16 = r36.k();
        r0 = r16;
        r1 = r34;
        r16 = r0.b(r1);
        r0 = r16;
        r5.a(r6, r10, r0);
        r5 = 0;
        goto L_0x0459;
    L_0x05e5:
        r5 = (java.lang.Long) r5;
        r34 = r5.longValue();
        r0 = r32;
        r5 = r0.d;
        r0 = r36;
        r1 = r34;
        r5 = r0.a(r1, r5);
        if (r5 != 0) goto L_0x05fc;
    L_0x05f9:
        r5 = 0;
        goto L_0x0459;
    L_0x05fc:
        r5 = r5.booleanValue();
        if (r5 != 0) goto L_0x060e;
    L_0x0602:
        r5 = 1;
    L_0x0603:
        r5 = r5 ^ r33;
        if (r5 == 0) goto L_0x075e;
    L_0x0607:
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        goto L_0x0459;
    L_0x060e:
        r5 = 0;
        goto L_0x0603;
    L_0x0610:
        r6 = r5 instanceof java.lang.Double;
        if (r6 == 0) goto L_0x066d;
    L_0x0614:
        r0 = r32;
        r6 = r0.d;
        if (r6 != 0) goto L_0x0642;
    L_0x061a:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "No number filter for double param. event, param";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r16 = r36.k();
        r0 = r16;
        r1 = r34;
        r16 = r0.b(r1);
        r0 = r16;
        r5.a(r6, r10, r0);
        r5 = 0;
        goto L_0x0459;
    L_0x0642:
        r5 = (java.lang.Double) r5;
        r34 = r5.doubleValue();
        r0 = r32;
        r5 = r0.d;
        r0 = r36;
        r1 = r34;
        r5 = r0.a(r1, r5);
        if (r5 != 0) goto L_0x0659;
    L_0x0656:
        r5 = 0;
        goto L_0x0459;
    L_0x0659:
        r5 = r5.booleanValue();
        if (r5 != 0) goto L_0x066b;
    L_0x065f:
        r5 = 1;
    L_0x0660:
        r5 = r5 ^ r33;
        if (r5 == 0) goto L_0x075e;
    L_0x0664:
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        goto L_0x0459;
    L_0x066b:
        r5 = 0;
        goto L_0x0660;
    L_0x066d:
        r6 = r5 instanceof java.lang.String;
        if (r6 == 0) goto L_0x0708;
    L_0x0671:
        r0 = r32;
        r6 = r0.c;
        if (r6 == 0) goto L_0x0688;
    L_0x0677:
        r5 = (java.lang.String) r5;
        r0 = r32;
        r6 = r0.c;
        r0 = r36;
        r5 = r0.a(r5, r6);
    L_0x0683:
        if (r5 != 0) goto L_0x06f4;
    L_0x0685:
        r5 = 0;
        goto L_0x0459;
    L_0x0688:
        r0 = r32;
        r6 = r0.d;
        if (r6 == 0) goto L_0x06cc;
    L_0x068e:
        r6 = r5;
        r6 = (java.lang.String) r6;
        r6 = com.google.android.gms.internal.measurement.ie.j(r6);
        if (r6 == 0) goto L_0x06a4;
    L_0x0697:
        r5 = (java.lang.String) r5;
        r0 = r32;
        r6 = r0.d;
        r0 = r36;
        r5 = r0.a(r5, r6);
        goto L_0x0683;
    L_0x06a4:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "Invalid param value for number filter. event, param";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r16 = r36.k();
        r0 = r16;
        r1 = r34;
        r16 = r0.b(r1);
        r0 = r16;
        r5.a(r6, r10, r0);
        r5 = 0;
        goto L_0x0459;
    L_0x06cc:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "No filter for String param. event, param";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r16 = r36.k();
        r0 = r16;
        r1 = r34;
        r16 = r0.b(r1);
        r0 = r16;
        r5.a(r6, r10, r0);
        r5 = 0;
        goto L_0x0459;
    L_0x06f4:
        r5 = r5.booleanValue();
        if (r5 != 0) goto L_0x0706;
    L_0x06fa:
        r5 = 1;
    L_0x06fb:
        r5 = r5 ^ r33;
        if (r5 == 0) goto L_0x075e;
    L_0x06ff:
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        goto L_0x0459;
    L_0x0706:
        r5 = 0;
        goto L_0x06fb;
    L_0x0708:
        if (r5 != 0) goto L_0x0736;
    L_0x070a:
        r5 = r36.zzge();
        r5 = r5.y();
        r6 = "Missing param for filter. event, param";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r16 = r36.k();
        r0 = r16;
        r1 = r34;
        r16 = r0.b(r1);
        r0 = r16;
        r5.a(r6, r10, r0);
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        goto L_0x0459;
    L_0x0736:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "Unknown param type. event, param";
        r10 = r36.k();
        r0 = r20;
        r10 = r10.a(r0);
        r16 = r36.k();
        r0 = r16;
        r1 = r34;
        r16 = r0.b(r1);
        r0 = r16;
        r5.a(r6, r10, r0);
        r5 = 0;
        goto L_0x0459;
    L_0x075e:
        r5 = r10 + 1;
        r10 = r5;
        goto L_0x0575;
    L_0x0763:
        r5 = 1;
        r5 = java.lang.Boolean.valueOf(r5);
        goto L_0x0459;
    L_0x076a:
        r6 = r5;
        goto L_0x0467;
    L_0x076d:
        r6 = r4.c;
        r6 = r6.intValue();
        r8.set(r6);
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x03b2;
    L_0x077c:
        r4 = r4.c;
        r4 = r4.intValue();
        r9.set(r4);
        goto L_0x03b2;
    L_0x0787:
        if (r39 == 0) goto L_0x0a93;
    L_0x0789:
        r11 = new android.support.v4.util.a;
        r11.<init>();
        r0 = r39;
        r12 = r0.length;
        r4 = 0;
        r10 = r4;
    L_0x0793:
        if (r10 >= r12) goto L_0x0a93;
    L_0x0795:
        r13 = r39[r10];
        r4 = r13.d;
        r4 = r11.get(r4);
        r4 = (java.util.Map) r4;
        if (r4 != 0) goto L_0x0ba4;
    L_0x07a1:
        r4 = r36.a_();
        r5 = r13.d;
        r0 = r37;
        r4 = r4.g(r0, r5);
        if (r4 != 0) goto L_0x07b4;
    L_0x07af:
        r4 = new android.support.v4.util.a;
        r4.<init>();
    L_0x07b4:
        r5 = r13.d;
        r11.put(r5, r4);
        r7 = r4;
    L_0x07ba:
        r4 = r7.keySet();
        r14 = r4.iterator();
    L_0x07c2:
        r4 = r14.hasNext();
        if (r4 == 0) goto L_0x0a8e;
    L_0x07c8:
        r4 = r14.next();
        r4 = (java.lang.Integer) r4;
        r15 = r4.intValue();
        r4 = java.lang.Integer.valueOf(r15);
        r0 = r26;
        r4 = r0.contains(r4);
        if (r4 == 0) goto L_0x07f0;
    L_0x07de:
        r4 = r36.zzge();
        r4 = r4.y();
        r5 = "Skipping failed audience ID";
        r6 = java.lang.Integer.valueOf(r15);
        r4.a(r5, r6);
        goto L_0x07c2;
    L_0x07f0:
        r4 = java.lang.Integer.valueOf(r15);
        r0 = r27;
        r4 = r0.get(r4);
        r4 = (com.google.android.gms.internal.measurement.iq) r4;
        r5 = java.lang.Integer.valueOf(r15);
        r0 = r28;
        r5 = r0.get(r5);
        r5 = (java.util.BitSet) r5;
        r6 = java.lang.Integer.valueOf(r15);
        r0 = r29;
        r6 = r0.get(r6);
        r6 = (java.util.BitSet) r6;
        if (r4 != 0) goto L_0x0847;
    L_0x0816:
        r4 = new com.google.android.gms.internal.measurement.iq;
        r4.<init>();
        r5 = java.lang.Integer.valueOf(r15);
        r0 = r27;
        r0.put(r5, r4);
        r5 = 1;
        r5 = java.lang.Boolean.valueOf(r5);
        r4.f = r5;
        r5 = new java.util.BitSet;
        r5.<init>();
        r4 = java.lang.Integer.valueOf(r15);
        r0 = r28;
        r0.put(r4, r5);
        r6 = new java.util.BitSet;
        r6.<init>();
        r4 = java.lang.Integer.valueOf(r15);
        r0 = r29;
        r0.put(r4, r6);
    L_0x0847:
        r4 = java.lang.Integer.valueOf(r15);
        r4 = r7.get(r4);
        r4 = (java.util.List) r4;
        r16 = r4.iterator();
    L_0x0855:
        r4 = r16.hasNext();
        if (r4 == 0) goto L_0x07c2;
    L_0x085b:
        r4 = r16.next();
        r4 = (com.google.android.gms.internal.measurement.il) r4;
        r8 = r36.zzge();
        r9 = 2;
        r8 = r8.a(r9);
        if (r8 == 0) goto L_0x08ac;
    L_0x086c:
        r8 = r36.zzge();
        r8 = r8.y();
        r9 = "Evaluating filter. audience, filter, property";
        r17 = java.lang.Integer.valueOf(r15);
        r0 = r4.c;
        r18 = r0;
        r19 = r36.k();
        r0 = r4.d;
        r20 = r0;
        r19 = r19.c(r20);
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r8.a(r9, r0, r1, r2);
        r8 = r36.zzge();
        r8 = r8.y();
        r9 = "Filter definition";
        r17 = r36.k();
        r0 = r17;
        r17 = r0.a(r4);
        r0 = r17;
        r8.a(r9, r0);
    L_0x08ac:
        r8 = r4.c;
        if (r8 == 0) goto L_0x08ba;
    L_0x08b0:
        r8 = r4.c;
        r8 = r8.intValue();
        r9 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r8 <= r9) goto L_0x08dc;
    L_0x08ba:
        r5 = r36.zzge();
        r5 = r5.u();
        r6 = "Invalid property filter ID. appId, id";
        r8 = com.google.android.gms.internal.measurement.dp.a(r37);
        r4 = r4.c;
        r4 = java.lang.String.valueOf(r4);
        r5.a(r6, r8, r4);
        r4 = java.lang.Integer.valueOf(r15);
        r0 = r26;
        r0.add(r4);
        goto L_0x07c2;
    L_0x08dc:
        r8 = r4.c;
        r8 = r8.intValue();
        r8 = r5.get(r8);
        if (r8 == 0) goto L_0x08ff;
    L_0x08e8:
        r8 = r36.zzge();
        r8 = r8.y();
        r9 = "Property filter already evaluated true. audience ID, filter ID";
        r17 = java.lang.Integer.valueOf(r15);
        r4 = r4.c;
        r0 = r17;
        r8.a(r9, r0, r4);
        goto L_0x0855;
    L_0x08ff:
        r8 = r4.e;
        if (r8 != 0) goto L_0x0941;
    L_0x0903:
        r8 = r36.zzge();
        r8 = r8.u();
        r9 = "Missing property filter. property";
        r17 = r36.k();
        r0 = r13.d;
        r18 = r0;
        r17 = r17.c(r18);
        r0 = r17;
        r8.a(r9, r0);
        r8 = 0;
    L_0x091f:
        r9 = r36.zzge();
        r17 = r9.y();
        r18 = "Property filter result";
        if (r8 != 0) goto L_0x0a71;
    L_0x092b:
        r9 = "null";
    L_0x092d:
        r0 = r17;
        r1 = r18;
        r0.a(r1, r9);
        if (r8 != 0) goto L_0x0a74;
    L_0x0936:
        r4 = java.lang.Integer.valueOf(r15);
        r0 = r26;
        r0.add(r4);
        goto L_0x0855;
    L_0x0941:
        r9 = java.lang.Boolean.TRUE;
        r0 = r8.e;
        r17 = r0;
        r0 = r17;
        r9 = r9.equals(r0);
        r0 = r13.f;
        r17 = r0;
        if (r17 == 0) goto L_0x098d;
    L_0x0953:
        r0 = r8.d;
        r17 = r0;
        if (r17 != 0) goto L_0x0976;
    L_0x0959:
        r8 = r36.zzge();
        r8 = r8.u();
        r9 = "No number filter for long property. property";
        r17 = r36.k();
        r0 = r13.d;
        r18 = r0;
        r17 = r17.c(r18);
        r0 = r17;
        r8.a(r9, r0);
        r8 = 0;
        goto L_0x091f;
    L_0x0976:
        r0 = r13.f;
        r17 = r0;
        r18 = r17.longValue();
        r8 = r8.d;
        r0 = r36;
        r1 = r18;
        r8 = r0.a(r1, r8);
        r8 = a(r8, r9);
        goto L_0x091f;
    L_0x098d:
        r0 = r13.g;
        r17 = r0;
        if (r17 == 0) goto L_0x09cf;
    L_0x0993:
        r0 = r8.d;
        r17 = r0;
        if (r17 != 0) goto L_0x09b7;
    L_0x0999:
        r8 = r36.zzge();
        r8 = r8.u();
        r9 = "No number filter for double property. property";
        r17 = r36.k();
        r0 = r13.d;
        r18 = r0;
        r17 = r17.c(r18);
        r0 = r17;
        r8.a(r9, r0);
        r8 = 0;
        goto L_0x091f;
    L_0x09b7:
        r0 = r13.g;
        r17 = r0;
        r18 = r17.doubleValue();
        r8 = r8.d;
        r0 = r36;
        r1 = r18;
        r8 = r0.a(r1, r8);
        r8 = a(r8, r9);
        goto L_0x091f;
    L_0x09cf:
        r0 = r13.e;
        r17 = r0;
        if (r17 == 0) goto L_0x0a53;
    L_0x09d5:
        r0 = r8.c;
        r17 = r0;
        if (r17 != 0) goto L_0x0a3f;
    L_0x09db:
        r0 = r8.d;
        r17 = r0;
        if (r17 != 0) goto L_0x09ff;
    L_0x09e1:
        r8 = r36.zzge();
        r8 = r8.u();
        r9 = "No string or number filter defined. property";
        r17 = r36.k();
        r0 = r13.d;
        r18 = r0;
        r17 = r17.c(r18);
        r0 = r17;
        r8.a(r9, r0);
    L_0x09fc:
        r8 = 0;
        goto L_0x091f;
    L_0x09ff:
        r0 = r13.e;
        r17 = r0;
        r17 = com.google.android.gms.internal.measurement.ie.j(r17);
        if (r17 == 0) goto L_0x0a1d;
    L_0x0a09:
        r0 = r13.e;
        r17 = r0;
        r8 = r8.d;
        r0 = r36;
        r1 = r17;
        r8 = r0.a(r1, r8);
        r8 = a(r8, r9);
        goto L_0x091f;
    L_0x0a1d:
        r8 = r36.zzge();
        r8 = r8.u();
        r9 = "Invalid user property value for Numeric number filter. property, value";
        r17 = r36.k();
        r0 = r13.d;
        r18 = r0;
        r17 = r17.c(r18);
        r0 = r13.e;
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r8.a(r9, r0, r1);
        goto L_0x09fc;
    L_0x0a3f:
        r0 = r13.e;
        r17 = r0;
        r8 = r8.c;
        r0 = r36;
        r1 = r17;
        r8 = r0.a(r1, r8);
        r8 = a(r8, r9);
        goto L_0x091f;
    L_0x0a53:
        r8 = r36.zzge();
        r8 = r8.u();
        r9 = "User property has no value, property";
        r17 = r36.k();
        r0 = r13.d;
        r18 = r0;
        r17 = r17.c(r18);
        r0 = r17;
        r8.a(r9, r0);
        r8 = 0;
        goto L_0x091f;
    L_0x0a71:
        r9 = r8;
        goto L_0x092d;
    L_0x0a74:
        r9 = r4.c;
        r9 = r9.intValue();
        r6.set(r9);
        r8 = r8.booleanValue();
        if (r8 == 0) goto L_0x0855;
    L_0x0a83:
        r4 = r4.c;
        r4 = r4.intValue();
        r5.set(r4);
        goto L_0x0855;
    L_0x0a8e:
        r4 = r10 + 1;
        r10 = r4;
        goto L_0x0793;
    L_0x0a93:
        r4 = r28.size();
        r8 = new com.google.android.gms.internal.measurement.iq[r4];
        r4 = 0;
        r5 = r28.keySet();
        r9 = r5.iterator();
        r5 = r4;
    L_0x0aa3:
        r4 = r9.hasNext();
        if (r4 == 0) goto L_0x0b9a;
    L_0x0aa9:
        r4 = r9.next();
        r4 = (java.lang.Integer) r4;
        r10 = r4.intValue();
        r4 = java.lang.Integer.valueOf(r10);
        r0 = r26;
        r4 = r0.contains(r4);
        if (r4 != 0) goto L_0x0aa3;
    L_0x0abf:
        r4 = java.lang.Integer.valueOf(r10);
        r0 = r27;
        r4 = r0.get(r4);
        r4 = (com.google.android.gms.internal.measurement.iq) r4;
        if (r4 != 0) goto L_0x0ba1;
    L_0x0acd:
        r4 = new com.google.android.gms.internal.measurement.iq;
        r4.<init>();
        r7 = r4;
    L_0x0ad3:
        r6 = r5 + 1;
        r8[r5] = r7;
        r4 = java.lang.Integer.valueOf(r10);
        r7.c = r4;
        r4 = new com.google.android.gms.internal.measurement.iv;
        r4.<init>();
        r7.d = r4;
        r5 = r7.d;
        r4 = java.lang.Integer.valueOf(r10);
        r0 = r28;
        r4 = r0.get(r4);
        r4 = (java.util.BitSet) r4;
        r4 = com.google.android.gms.internal.measurement.ie.a(r4);
        r5.d = r4;
        r5 = r7.d;
        r4 = java.lang.Integer.valueOf(r10);
        r0 = r29;
        r4 = r0.get(r4);
        r4 = (java.util.BitSet) r4;
        r4 = com.google.android.gms.internal.measurement.ie.a(r4);
        r5.c = r4;
        r5 = r36.a_();
        r4 = r7.d;
        r5.J();
        r5.c();
        com.google.android.gms.common.internal.ar.a(r37);
        com.google.android.gms.common.internal.ar.a(r4);
        r7 = r4.d();	 Catch:{ IOException -> 0x0b70 }
        r7 = new byte[r7];	 Catch:{ IOException -> 0x0b70 }
        r11 = 0;
        r12 = r7.length;	 Catch:{ IOException -> 0x0b70 }
        r11 = com.google.android.gms.internal.measurement.i.a(r7, r11, r12);	 Catch:{ IOException -> 0x0b70 }
        r4.a(r11);	 Catch:{ IOException -> 0x0b70 }
        r11.a();	 Catch:{ IOException -> 0x0b70 }
        r4 = new android.content.ContentValues;
        r4.<init>();
        r11 = "app_id";
        r0 = r37;
        r4.put(r11, r0);
        r11 = "audience_id";
        r10 = java.lang.Integer.valueOf(r10);
        r4.put(r11, r10);
        r10 = "current_results";
        r4.put(r10, r7);
        r7 = r5.t();	 Catch:{ SQLiteException -> 0x0b85 }
        r10 = "audience_filter_values";
        r11 = 0;
        r12 = 5;
        r10 = r7.insertWithOnConflict(r10, r11, r4, r12);	 Catch:{ SQLiteException -> 0x0b85 }
        r12 = -1;
        r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r4 != 0) goto L_0x0b6d;
    L_0x0b5c:
        r4 = r5.zzge();	 Catch:{ SQLiteException -> 0x0b85 }
        r4 = r4.r();	 Catch:{ SQLiteException -> 0x0b85 }
        r7 = "Failed to insert filter results (got -1). appId";
        r10 = com.google.android.gms.internal.measurement.dp.a(r37);	 Catch:{ SQLiteException -> 0x0b85 }
        r4.a(r7, r10);	 Catch:{ SQLiteException -> 0x0b85 }
    L_0x0b6d:
        r5 = r6;
        goto L_0x0aa3;
    L_0x0b70:
        r4 = move-exception;
        r5 = r5.zzge();
        r5 = r5.r();
        r7 = "Configuration loss. Failed to serialize filter results. appId";
        r10 = com.google.android.gms.internal.measurement.dp.a(r37);
        r5.a(r7, r10, r4);
        r5 = r6;
        goto L_0x0aa3;
    L_0x0b85:
        r4 = move-exception;
        r5 = r5.zzge();
        r5 = r5.r();
        r7 = "Error storing filter results. appId";
        r10 = com.google.android.gms.internal.measurement.dp.a(r37);
        r5.a(r7, r10, r4);
        r5 = r6;
        goto L_0x0aa3;
    L_0x0b9a:
        r4 = java.util.Arrays.copyOf(r8, r5);
        r4 = (com.google.android.gms.internal.measurement.iq[]) r4;
        return r4;
    L_0x0ba1:
        r7 = r4;
        goto L_0x0ad3;
    L_0x0ba4:
        r7 = r4;
        goto L_0x07ba;
    L_0x0ba7:
        r19 = r12;
        r20 = r11;
        r21 = r5;
        r22 = r8;
        r24 = r10;
        goto L_0x022a;
    L_0x0bb3:
        r13 = r5;
        goto L_0x019a;
    L_0x0bb6:
        r8 = r6;
        r9 = r5;
        goto L_0x03a4;
    L_0x0bba:
        r5 = r21;
        r8 = r22;
        r10 = r24;
        goto L_0x0149;
    L_0x0bc2:
        r7 = r4;
        goto L_0x029e;
    L_0x0bc5:
        r4 = r5;
        goto L_0x01ee;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.cr.a(java.lang.String, com.google.android.gms.internal.measurement.ir[], com.google.android.gms.internal.measurement.iw[]):com.google.android.gms.internal.measurement.iq[]");
    }

    protected final boolean p() {
        return false;
    }
}
