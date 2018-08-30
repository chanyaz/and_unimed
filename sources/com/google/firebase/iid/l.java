package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.util.s;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.b;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

final class l {
    private static int a = 0;
    private static PendingIntent b;
    @GuardedBy("responseCallbacks")
    private final s<String, b<Bundle>> c = new s();
    private final Context d;
    private final f e;
    private Messenger f;
    private Messenger g;
    private zzi h;

    public l(Context context, f fVar) {
        this.d = context;
        this.e = fVar;
        this.f = new Messenger(new m(this, Looper.getMainLooper()));
    }

    private static synchronized String a() {
        String num;
        synchronized (l.class) {
            int i = a;
            a = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private static synchronized void a(Context context, Intent intent) {
        synchronized (l.class) {
            if (b == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                b = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", b);
        }
    }

    private final void a(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new y());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof zzi) {
                this.h = (zzi) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.g = (Messenger) parcelableExtra;
            }
        }
        intent = (Intent) message.obj;
        String action = intent.getAction();
        String stringExtra;
        String valueOf;
        String str;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            CharSequence stringExtra2 = intent.getStringExtra("registration_id");
            if (stringExtra2 == null) {
                stringExtra2 = intent.getStringExtra("unregistered");
            }
            if (stringExtra2 == null) {
                stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    valueOf = String.valueOf(intent.getExtras());
                    Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    str = "FirebaseInstanceId";
                    String str2 = "Received InstanceID error ";
                    action = String.valueOf(stringExtra);
                    Log.d(str, action.length() != 0 ? str2.concat(action) : new String(str2));
                }
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (split.length <= 2 || !"ID".equals(split[1])) {
                        action = "FirebaseInstanceId";
                        str = "Unexpected structured response ";
                        valueOf = String.valueOf(stringExtra);
                        Log.w(action, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        return;
                    }
                    stringExtra = split[2];
                    action = split[3];
                    if (action.startsWith(":")) {
                        action = action.substring(1);
                    }
                    a(stringExtra, intent.putExtra("error", action).getExtras());
                    return;
                }
                synchronized (this.c) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.c.size()) {
                            a((String) this.c.b(i2), intent.getExtras());
                            i = i2 + 1;
                        }
                    }
                }
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra2);
            if (matcher.matches()) {
                action = matcher.group(1);
                stringExtra = matcher.group(2);
                Bundle extras = intent.getExtras();
                extras.putString("registration_id", stringExtra);
                a(action, extras);
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                stringExtra = "FirebaseInstanceId";
                str = "Unexpected response string: ";
                valueOf = String.valueOf(stringExtra2);
                Log.d(stringExtra, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
            stringExtra = "FirebaseInstanceId";
            str = "Unexpected response action: ";
            valueOf = String.valueOf(action);
            Log.d(stringExtra, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private final void a(String str, Bundle bundle) {
        synchronized (this.c) {
            b bVar = (b) this.c.remove(str);
            if (bVar == null) {
                String str2 = "FirebaseInstanceId";
                String str3 = "Missing callback for ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return;
            }
            bVar.a((Object) bundle);
        }
    }

    private final Bundle b(Bundle bundle) {
        Bundle c = c(bundle);
        if (c == null || !c.containsKey("google.messenger")) {
            return c;
        }
        c = c(bundle);
        return (c == null || !c.containsKey("google.messenger")) ? c : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cf A:{SYNTHETIC} */
    private final android.os.Bundle c(android.os.Bundle r10) {
        /*
        r9 = this;
        r8 = 3;
        r7 = 2;
        r1 = a();
        r0 = new com.google.android.gms.tasks.b;
        r0.<init>();
        r2 = r9.c;
        monitor-enter(r2);
        r3 = r9.c;	 Catch:{ all -> 0x0024 }
        r3.put(r1, r0);	 Catch:{ all -> 0x0024 }
        monitor-exit(r2);	 Catch:{ all -> 0x0024 }
        r2 = r9.e;
        r2 = r2.a();
        if (r2 != 0) goto L_0x0027;
    L_0x001c:
        r0 = new java.io.IOException;
        r1 = "MISSING_INSTANCEID_SERVICE";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0024 }
        throw r0;
    L_0x0027:
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "com.google.android.gms";
        r2.setPackage(r3);
        r3 = r9.e;
        r3 = r3.a();
        if (r3 != r7) goto L_0x00d6;
    L_0x0039:
        r3 = "com.google.iid.TOKEN_REQUEST";
        r2.setAction(r3);
    L_0x003e:
        r2.putExtras(r10);
        r3 = r9.d;
        a(r3, r2);
        r3 = "kid";
        r4 = java.lang.String.valueOf(r1);
        r4 = r4.length();
        r4 = r4 + 5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "|ID|";
        r4 = r5.append(r4);
        r4 = r4.append(r1);
        r5 = "|";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r2.putExtra(r3, r4);
        r3 = "FirebaseInstanceId";
        r3 = android.util.Log.isLoggable(r3, r8);
        if (r3 == 0) goto L_0x00a0;
    L_0x0076:
        r3 = "FirebaseInstanceId";
        r4 = r2.getExtras();
        r4 = java.lang.String.valueOf(r4);
        r5 = java.lang.String.valueOf(r4);
        r5 = r5.length();
        r5 = r5 + 8;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "Sending ";
        r5 = r6.append(r5);
        r4 = r5.append(r4);
        r4 = r4.toString();
        android.util.Log.d(r3, r4);
    L_0x00a0:
        r3 = "google.messenger";
        r4 = r9.f;
        r2.putExtra(r3, r4);
        r3 = r9.g;
        if (r3 != 0) goto L_0x00af;
    L_0x00ab:
        r3 = r9.h;
        if (r3 == 0) goto L_0x00f3;
    L_0x00af:
        r3 = android.os.Message.obtain();
        r3.obj = r2;
        r4 = r9.g;	 Catch:{ RemoteException -> 0x00e3 }
        if (r4 == 0) goto L_0x00dd;
    L_0x00b9:
        r4 = r9.g;	 Catch:{ RemoteException -> 0x00e3 }
        r4.send(r3);	 Catch:{ RemoteException -> 0x00e3 }
    L_0x00be:
        r0 = r0.a();	 Catch:{ InterruptedException -> 0x010a, TimeoutException -> 0x012f, ExecutionException -> 0x0125 }
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x010a, TimeoutException -> 0x012f, ExecutionException -> 0x0125 }
        r0 = com.google.android.gms.tasks.Tasks.a(r0, r2, r4);	 Catch:{ InterruptedException -> 0x010a, TimeoutException -> 0x012f, ExecutionException -> 0x0125 }
        r0 = (android.os.Bundle) r0;	 Catch:{ InterruptedException -> 0x010a, TimeoutException -> 0x012f, ExecutionException -> 0x0125 }
        r2 = r9.c;
        monitor-enter(r2);
        r3 = r9.c;	 Catch:{ all -> 0x0107 }
        r3.remove(r1);	 Catch:{ all -> 0x0107 }
        monitor-exit(r2);	 Catch:{ all -> 0x0107 }
        return r0;
    L_0x00d6:
        r3 = "com.google.android.c2dm.intent.REGISTER";
        r2.setAction(r3);
        goto L_0x003e;
    L_0x00dd:
        r4 = r9.h;	 Catch:{ RemoteException -> 0x00e3 }
        r4.a(r3);	 Catch:{ RemoteException -> 0x00e3 }
        goto L_0x00be;
    L_0x00e3:
        r3 = move-exception;
        r3 = "FirebaseInstanceId";
        r3 = android.util.Log.isLoggable(r3, r8);
        if (r3 == 0) goto L_0x00f3;
    L_0x00ec:
        r3 = "FirebaseInstanceId";
        r4 = "Messenger failed, fallback to startService";
        android.util.Log.d(r3, r4);
    L_0x00f3:
        r3 = r9.e;
        r3 = r3.a();
        if (r3 != r7) goto L_0x0101;
    L_0x00fb:
        r3 = r9.d;
        r3.sendBroadcast(r2);
        goto L_0x00be;
    L_0x0101:
        r3 = r9.d;
        r3.startService(r2);
        goto L_0x00be;
    L_0x0107:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0107 }
        throw r0;
    L_0x010a:
        r0 = move-exception;
    L_0x010b:
        r0 = "FirebaseInstanceId";
        r2 = "No response";
        android.util.Log.w(r0, r2);	 Catch:{ all -> 0x011a }
        r0 = new java.io.IOException;	 Catch:{ all -> 0x011a }
        r2 = "TIMEOUT";
        r0.<init>(r2);	 Catch:{ all -> 0x011a }
        throw r0;	 Catch:{ all -> 0x011a }
    L_0x011a:
        r0 = move-exception;
        r2 = r9.c;
        monitor-enter(r2);
        r3 = r9.c;	 Catch:{ all -> 0x012c }
        r3.remove(r1);	 Catch:{ all -> 0x012c }
        monitor-exit(r2);	 Catch:{ all -> 0x012c }
        throw r0;
    L_0x0125:
        r0 = move-exception;
        r2 = new java.io.IOException;	 Catch:{ all -> 0x011a }
        r2.<init>(r0);	 Catch:{ all -> 0x011a }
        throw r2;	 Catch:{ all -> 0x011a }
    L_0x012c:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x012c }
        throw r0;
    L_0x012f:
        r0 = move-exception;
        goto L_0x010b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.l.c(android.os.Bundle):android.os.Bundle");
    }

    final Bundle a(Bundle bundle) {
        Exception e;
        if (this.e.d() < 12000000) {
            return b(bundle);
        }
        try {
            return (Bundle) Tasks.a(ah.a(this.d).b(1, bundle));
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(e);
            Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf).toString());
        }
        return ((e.getCause() instanceof zzac) && ((zzac) e.getCause()).a() == 4) ? b(bundle) : null;
    }
}
