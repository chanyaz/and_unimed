package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.stats.b;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class aj implements ServiceConnection {
    @GuardedBy("this")
    int a;
    final Messenger b;
    ao c;
    @GuardedBy("this")
    final Queue<d<?>> d;
    @GuardedBy("this")
    final SparseArray<d<?>> e;
    final /* synthetic */ ah f;

    private aj(ah ahVar) {
        this.f = ahVar;
        this.a = 0;
        this.b = new Messenger(new Handler(Looper.getMainLooper(), new ak(this)));
        this.d = new ArrayDeque();
        this.e = new SparseArray();
    }

    private final void c() {
        this.f.c.execute(new am(this));
    }

    final synchronized void a() {
        if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.a = 3;
            b.a().a(this.f.b, this);
        }
    }

    final synchronized void a(int i) {
        d dVar = (d) this.e.get(i);
        if (dVar != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i);
            this.e.remove(i);
            dVar.a(new zzac(3, "Timed out waiting for response"));
            a();
        }
    }

    final synchronized void a(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "MessengerIpcClient";
            String str3 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        switch (this.a) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.a = 4;
                b.a().a(this.f.b, this);
                zzac zzac = new zzac(i, str);
                for (d a : this.d) {
                    a.a(zzac);
                }
                this.d.clear();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.e.size()) {
                        this.e.clear();
                        break;
                    } else {
                        ((d) this.e.valueAt(i3)).a(zzac);
                        i2 = i3 + 1;
                    }
                }
            case 3:
                this.a = 4;
                break;
            case 4:
                break;
            default:
                throw new IllegalStateException("Unknown state: " + this.a);
        }
    }

    final boolean a(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Received response to request: " + i);
        }
        synchronized (this) {
            d dVar = (d) this.e.get(i);
            if (dVar == null) {
                Log.w("MessengerIpcClient", "Received response for unknown request: " + i);
            } else {
                this.e.remove(i);
                a();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    dVar.a(new zzac(4, "Not supported by GmsCore"));
                } else {
                    dVar.a(data);
                }
            }
        }
        return true;
    }

    final synchronized boolean a(d dVar) {
        boolean z = false;
        boolean z2 = true;
        synchronized (this) {
            switch (this.a) {
                case 0:
                    this.d.add(dVar);
                    if (this.a == 0) {
                        z = true;
                    }
                    ar.a(z);
                    if (Log.isLoggable("MessengerIpcClient", 2)) {
                        Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                    }
                    this.a = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (!b.a().a(this.f.b, intent, (ServiceConnection) this, 1)) {
                        a(0, "Unable to bind to service");
                        break;
                    }
                    this.f.c.schedule(new al(this), 30, TimeUnit.SECONDS);
                    break;
                case 1:
                    this.d.add(dVar);
                    break;
                case 2:
                    this.d.add(dVar);
                    c();
                    break;
                case 3:
                case 4:
                    z2 = false;
                    break;
                default:
                    throw new IllegalStateException("Unknown state: " + this.a);
            }
        }
        return z2;
    }

    final synchronized void b() {
        if (this.a == 1) {
            a(1, "Timed out while binding");
        }
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            a(0, "Null service connection");
        } else {
            try {
                this.c = new ao(iBinder);
                this.a = 2;
                c();
            } catch (RemoteException e) {
                a(0, e.getMessage());
            }
        }
        return;
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        a(2, "Service disconnected");
    }
}
