package com.google.android.gms.internal.ads;

import android.content.Context;

@zzadh
public final class gi implements zzft {
    private final Context a;
    private final Object b;
    private String c;
    private boolean d;

    public gi(Context context, String str) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.a = context;
        this.c = str;
        this.d = false;
        this.b = new Object();
    }

    public final void a(String str) {
        this.c = str;
    }

    /* JADX WARNING: Missing block: B:23:?, code:
            return;
     */
    public final void a(boolean r5) {
        /*
        r4 = this;
        r0 = com.google.android.gms.ads.internal.au.B();
        r1 = r4.a;
        r0 = r0.a(r1);
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r1 = r4.b;
        monitor-enter(r1);
        r0 = r4.d;	 Catch:{ all -> 0x0016 }
        if (r0 != r5) goto L_0x0019;
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        goto L_0x000c;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        throw r0;
    L_0x0019:
        r4.d = r5;	 Catch:{ all -> 0x0016 }
        r0 = r4.c;	 Catch:{ all -> 0x0016 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0025;
    L_0x0023:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        goto L_0x000c;
    L_0x0025:
        r0 = r4.d;	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0036;
    L_0x0029:
        r0 = com.google.android.gms.ads.internal.au.B();	 Catch:{ all -> 0x0016 }
        r2 = r4.a;	 Catch:{ all -> 0x0016 }
        r3 = r4.c;	 Catch:{ all -> 0x0016 }
        r0.a(r2, r3);	 Catch:{ all -> 0x0016 }
    L_0x0034:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        goto L_0x000c;
    L_0x0036:
        r0 = com.google.android.gms.ads.internal.au.B();	 Catch:{ all -> 0x0016 }
        r2 = r4.a;	 Catch:{ all -> 0x0016 }
        r3 = r4.c;	 Catch:{ all -> 0x0016 }
        r0.b(r2, r3);	 Catch:{ all -> 0x0016 }
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.gi.a(boolean):void");
    }

    public final void zza(agf agf) {
        a(agf.a);
    }
}
