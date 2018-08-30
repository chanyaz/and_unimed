package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;

public final class c {
    private static final Object f = new Object();
    private static c g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<e>> b = new HashMap();
    private final HashMap<String, ArrayList<e>> c = new HashMap();
    private final ArrayList<d> d = new ArrayList();
    private final Handler e;

    private c(Context context) {
        this.a = context;
        this.e = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        c.this.a();
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    @NonNull
    public static c a(@NonNull Context context) {
        c cVar;
        synchronized (f) {
            if (g == null) {
                g = new c(context.getApplicationContext());
            }
            cVar = g;
        }
        return cVar;
    }

    /* JADX WARNING: Missing block: B:10:0x001b, code:
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:12:0x001d, code:
            if (r1 >= r4.length) goto L_0x0001;
     */
    /* JADX WARNING: Missing block: B:13:0x001f, code:
            r5 = r4[r1];
            r6 = r5.b.size();
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:14:0x0028, code:
            if (r3 >= r6) goto L_0x0046;
     */
    /* JADX WARNING: Missing block: B:15:0x002a, code:
            r0 = (android.support.v4.content.e) r5.b.get(r3);
     */
    /* JADX WARNING: Missing block: B:16:0x0034, code:
            if (r0.d != false) goto L_0x003f;
     */
    /* JADX WARNING: Missing block: B:17:0x0036, code:
            r0.b.onReceive(r9.a, r5.a);
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code:
            r3 = r3 + 1;
     */
    /* JADX WARNING: Missing block: B:23:0x0046, code:
            r1 = r1 + 1;
     */
    private void a() {
        /*
        r9 = this;
        r2 = 0;
    L_0x0001:
        r1 = r9.b;
        monitor-enter(r1);
        r0 = r9.d;	 Catch:{ all -> 0x0043 }
        r0 = r0.size();	 Catch:{ all -> 0x0043 }
        if (r0 > 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        return;
    L_0x000e:
        r4 = new android.support.v4.content.d[r0];	 Catch:{ all -> 0x0043 }
        r0 = r9.d;	 Catch:{ all -> 0x0043 }
        r0.toArray(r4);	 Catch:{ all -> 0x0043 }
        r0 = r9.d;	 Catch:{ all -> 0x0043 }
        r0.clear();	 Catch:{ all -> 0x0043 }
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        r1 = r2;
    L_0x001c:
        r0 = r4.length;
        if (r1 >= r0) goto L_0x0001;
    L_0x001f:
        r5 = r4[r1];
        r0 = r5.b;
        r6 = r0.size();
        r3 = r2;
    L_0x0028:
        if (r3 >= r6) goto L_0x0046;
    L_0x002a:
        r0 = r5.b;
        r0 = r0.get(r3);
        r0 = (android.support.v4.content.e) r0;
        r7 = r0.d;
        if (r7 != 0) goto L_0x003f;
    L_0x0036:
        r0 = r0.b;
        r7 = r9.a;
        r8 = r5.a;
        r0.onReceive(r7, r8);
    L_0x003f:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0028;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.c.a():void");
    }

    public void a(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.b) {
            ArrayList arrayList = (ArrayList) this.b.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                e eVar = (e) arrayList.get(size);
                eVar.d = true;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= eVar.a.countActions()) {
                        break;
                    }
                    String action = eVar.a.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.c.get(action);
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            e eVar2 = (e) arrayList2.get(size2);
                            if (eVar2.b == broadcastReceiver) {
                                eVar2.d = true;
                                arrayList2.remove(size2);
                            }
                        }
                        if (arrayList2.size() <= 0) {
                            this.c.remove(action);
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public void a(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.b) {
            e eVar = new e(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(eVar);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i2);
                    arrayList = (ArrayList) this.c.get(action);
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                        this.c.put(action, arrayList);
                    }
                    arrayList.add(eVar);
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:63:?, code:
            return false;
     */
    public boolean a(@android.support.annotation.NonNull android.content.Intent r17) {
        /*
        r16 = this;
        r0 = r16;
        r13 = r0.b;
        monitor-enter(r13);
        r2 = r17.getAction();	 Catch:{ all -> 0x0103 }
        r0 = r16;
        r1 = r0.a;	 Catch:{ all -> 0x0103 }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x0103 }
        r0 = r17;
        r3 = r0.resolveTypeIfNeeded(r1);	 Catch:{ all -> 0x0103 }
        r5 = r17.getData();	 Catch:{ all -> 0x0103 }
        r4 = r17.getScheme();	 Catch:{ all -> 0x0103 }
        r6 = r17.getCategories();	 Catch:{ all -> 0x0103 }
        r1 = r17.getFlags();	 Catch:{ all -> 0x0103 }
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x00c9;
    L_0x002b:
        r1 = 1;
        r12 = r1;
    L_0x002d:
        if (r12 == 0) goto L_0x005d;
    L_0x002f:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0103 }
        r7.<init>();	 Catch:{ all -> 0x0103 }
        r8 = "Resolving type ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0103 }
        r7 = r7.append(r3);	 Catch:{ all -> 0x0103 }
        r8 = " scheme ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0103 }
        r7 = r7.append(r4);	 Catch:{ all -> 0x0103 }
        r8 = " of intent ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0103 }
        r0 = r17;
        r7 = r7.append(r0);	 Catch:{ all -> 0x0103 }
        r7 = r7.toString();	 Catch:{ all -> 0x0103 }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x0103 }
    L_0x005d:
        r0 = r16;
        r1 = r0.c;	 Catch:{ all -> 0x0103 }
        r7 = r17.getAction();	 Catch:{ all -> 0x0103 }
        r1 = r1.get(r7);	 Catch:{ all -> 0x0103 }
        r0 = r1;
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x0103 }
        r8 = r0;
        if (r8 == 0) goto L_0x016e;
    L_0x006f:
        if (r12 == 0) goto L_0x0089;
    L_0x0071:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0103 }
        r7.<init>();	 Catch:{ all -> 0x0103 }
        r9 = "Action list: ";
        r7 = r7.append(r9);	 Catch:{ all -> 0x0103 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x0103 }
        r7 = r7.toString();	 Catch:{ all -> 0x0103 }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x0103 }
    L_0x0089:
        r10 = 0;
        r1 = 0;
        r11 = r1;
    L_0x008c:
        r1 = r8.size();	 Catch:{ all -> 0x0103 }
        if (r11 >= r1) goto L_0x0133;
    L_0x0092:
        r1 = r8.get(r11);	 Catch:{ all -> 0x0103 }
        r0 = r1;
        r0 = (android.support.v4.content.e) r0;	 Catch:{ all -> 0x0103 }
        r9 = r0;
        if (r12 == 0) goto L_0x00b6;
    L_0x009c:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0103 }
        r7.<init>();	 Catch:{ all -> 0x0103 }
        r14 = "Matching against filter ";
        r7 = r7.append(r14);	 Catch:{ all -> 0x0103 }
        r14 = r9.a;	 Catch:{ all -> 0x0103 }
        r7 = r7.append(r14);	 Catch:{ all -> 0x0103 }
        r7 = r7.toString();	 Catch:{ all -> 0x0103 }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x0103 }
    L_0x00b6:
        r1 = r9.c;	 Catch:{ all -> 0x0103 }
        if (r1 == 0) goto L_0x00cd;
    L_0x00ba:
        if (r12 == 0) goto L_0x0125;
    L_0x00bc:
        r1 = "LocalBroadcastManager";
        r7 = "  Filter's target already added";
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x0103 }
        r1 = r10;
    L_0x00c4:
        r7 = r11 + 1;
        r11 = r7;
        r10 = r1;
        goto L_0x008c;
    L_0x00c9:
        r1 = 0;
        r12 = r1;
        goto L_0x002d;
    L_0x00cd:
        r1 = r9.a;	 Catch:{ all -> 0x0103 }
        r7 = "LocalBroadcastManager";
        r1 = r1.match(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0103 }
        if (r1 < 0) goto L_0x0106;
    L_0x00d7:
        if (r12 == 0) goto L_0x00f5;
    L_0x00d9:
        r7 = "LocalBroadcastManager";
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0103 }
        r14.<init>();	 Catch:{ all -> 0x0103 }
        r15 = "  Filter matched!  match=0x";
        r14 = r14.append(r15);	 Catch:{ all -> 0x0103 }
        r1 = java.lang.Integer.toHexString(r1);	 Catch:{ all -> 0x0103 }
        r1 = r14.append(r1);	 Catch:{ all -> 0x0103 }
        r1 = r1.toString();	 Catch:{ all -> 0x0103 }
        android.util.Log.v(r7, r1);	 Catch:{ all -> 0x0103 }
    L_0x00f5:
        if (r10 != 0) goto L_0x0171;
    L_0x00f7:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0103 }
        r1.<init>();	 Catch:{ all -> 0x0103 }
    L_0x00fc:
        r1.add(r9);	 Catch:{ all -> 0x0103 }
        r7 = 1;
        r9.c = r7;	 Catch:{ all -> 0x0103 }
        goto L_0x00c4;
    L_0x0103:
        r1 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x0103 }
        throw r1;
    L_0x0106:
        if (r12 == 0) goto L_0x0125;
    L_0x0108:
        switch(r1) {
            case -4: goto L_0x012a;
            case -3: goto L_0x0127;
            case -2: goto L_0x012d;
            case -1: goto L_0x0130;
            default: goto L_0x010b;
        };
    L_0x010b:
        r1 = "unknown reason";
    L_0x010d:
        r7 = "LocalBroadcastManager";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0103 }
        r9.<init>();	 Catch:{ all -> 0x0103 }
        r14 = "  Filter did not match: ";
        r9 = r9.append(r14);	 Catch:{ all -> 0x0103 }
        r1 = r9.append(r1);	 Catch:{ all -> 0x0103 }
        r1 = r1.toString();	 Catch:{ all -> 0x0103 }
        android.util.Log.v(r7, r1);	 Catch:{ all -> 0x0103 }
    L_0x0125:
        r1 = r10;
        goto L_0x00c4;
    L_0x0127:
        r1 = "action";
        goto L_0x010d;
    L_0x012a:
        r1 = "category";
        goto L_0x010d;
    L_0x012d:
        r1 = "data";
        goto L_0x010d;
    L_0x0130:
        r1 = "type";
        goto L_0x010d;
    L_0x0133:
        if (r10 == 0) goto L_0x016e;
    L_0x0135:
        r1 = 0;
        r2 = r1;
    L_0x0137:
        r1 = r10.size();	 Catch:{ all -> 0x0103 }
        if (r2 >= r1) goto L_0x014a;
    L_0x013d:
        r1 = r10.get(r2);	 Catch:{ all -> 0x0103 }
        r1 = (android.support.v4.content.e) r1;	 Catch:{ all -> 0x0103 }
        r3 = 0;
        r1.c = r3;	 Catch:{ all -> 0x0103 }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0137;
    L_0x014a:
        r0 = r16;
        r1 = r0.d;	 Catch:{ all -> 0x0103 }
        r2 = new android.support.v4.content.d;	 Catch:{ all -> 0x0103 }
        r0 = r17;
        r2.<init>(r0, r10);	 Catch:{ all -> 0x0103 }
        r1.add(r2);	 Catch:{ all -> 0x0103 }
        r0 = r16;
        r1 = r0.e;	 Catch:{ all -> 0x0103 }
        r2 = 1;
        r1 = r1.hasMessages(r2);	 Catch:{ all -> 0x0103 }
        if (r1 != 0) goto L_0x016b;
    L_0x0163:
        r0 = r16;
        r1 = r0.e;	 Catch:{ all -> 0x0103 }
        r2 = 1;
        r1.sendEmptyMessage(r2);	 Catch:{ all -> 0x0103 }
    L_0x016b:
        r1 = 1;
        monitor-exit(r13);	 Catch:{ all -> 0x0103 }
    L_0x016d:
        return r1;
    L_0x016e:
        monitor-exit(r13);	 Catch:{ all -> 0x0103 }
        r1 = 0;
        goto L_0x016d;
    L_0x0171:
        r1 = r10;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.c.a(android.content.Intent):boolean");
    }
}
