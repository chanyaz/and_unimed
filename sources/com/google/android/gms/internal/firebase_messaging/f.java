package com.google.android.gms.internal.firebase_messaging;

public final class f {
    private static final h a;
    private static final int b;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    static {
        /*
        r2 = 1;
        r1 = 0;
        r0 = a();	 Catch:{ Throwable -> 0x0075 }
        if (r0 == 0) goto L_0x001d;
    L_0x0008:
        r1 = r0.intValue();	 Catch:{ Throwable -> 0x002e }
        r3 = 19;
        if (r1 < r3) goto L_0x001d;
    L_0x0010:
        r1 = new com.google.android.gms.internal.firebase_messaging.l;	 Catch:{ Throwable -> 0x002e }
        r1.<init>();	 Catch:{ Throwable -> 0x002e }
    L_0x0015:
        a = r1;
        if (r0 != 0) goto L_0x0070;
    L_0x0019:
        r0 = r2;
    L_0x001a:
        b = r0;
        return;
    L_0x001d:
        r1 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic";
        r1 = java.lang.Boolean.getBoolean(r1);	 Catch:{ Throwable -> 0x002e }
        if (r1 != 0) goto L_0x0068;
    L_0x0025:
        r1 = r2;
    L_0x0026:
        if (r1 == 0) goto L_0x006a;
    L_0x0028:
        r1 = new com.google.android.gms.internal.firebase_messaging.k;	 Catch:{ Throwable -> 0x002e }
        r1.<init>();	 Catch:{ Throwable -> 0x002e }
        goto L_0x0015;
    L_0x002e:
        r1 = move-exception;
    L_0x002f:
        r3 = java.lang.System.err;
        r4 = com.google.android.gms.internal.firebase_messaging.g.class;
        r4 = r4.getName();
        r5 = java.lang.String.valueOf(r4);
        r5 = r5.length();
        r5 = r5 + 132;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ";
        r5 = r6.append(r5);
        r4 = r5.append(r4);
        r5 = "will be used. The error is: ";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.println(r4);
        r3 = java.lang.System.err;
        r1.printStackTrace(r3);
        r1 = new com.google.android.gms.internal.firebase_messaging.g;
        r1.<init>();
        goto L_0x0015;
    L_0x0068:
        r1 = 0;
        goto L_0x0026;
    L_0x006a:
        r1 = new com.google.android.gms.internal.firebase_messaging.g;	 Catch:{ Throwable -> 0x002e }
        r1.<init>();	 Catch:{ Throwable -> 0x002e }
        goto L_0x0015;
    L_0x0070:
        r0 = r0.intValue();
        goto L_0x001a;
    L_0x0075:
        r0 = move-exception;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_messaging.f.<clinit>():void");
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static void a(Throwable th, Throwable th2) {
        a.a(th, th2);
    }
}
