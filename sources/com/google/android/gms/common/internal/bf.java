package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.b;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

final class bf extends v implements Callback {
    @GuardedBy("mConnectionStatus")
    private final HashMap<w, bg> a = new HashMap();
    private final Context b;
    private final Handler c;
    private final b d;
    private final long e;
    private final long f;

    bf(Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler(context.getMainLooper(), this);
        this.d = b.a();
        this.e = 5000;
        this.f = 300000;
    }

    protected final boolean a(w wVar, ServiceConnection serviceConnection, String str) {
        boolean a;
        ar.a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            bg bgVar = (bg) this.a.get(wVar);
            if (bgVar != null) {
                this.c.removeMessages(0, wVar);
                if (!bgVar.a(serviceConnection)) {
                    bgVar.a(serviceConnection, str);
                    switch (bgVar.b()) {
                        case 1:
                            serviceConnection.onServiceConnected(bgVar.e(), bgVar.d());
                            break;
                        case 2:
                            bgVar.a(str);
                            break;
                    }
                }
                String valueOf = String.valueOf(wVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            bgVar = new bg(this, wVar);
            bgVar.a(serviceConnection, str);
            bgVar.a(str);
            this.a.put(wVar, bgVar);
            a = bgVar.a();
        }
        return a;
    }

    protected final void b(w wVar, ServiceConnection serviceConnection, String str) {
        ar.a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.a) {
            bg bgVar = (bg) this.a.get(wVar);
            String valueOf;
            if (bgVar == null) {
                valueOf = String.valueOf(wVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (bgVar.a(serviceConnection)) {
                bgVar.b(serviceConnection, str);
                if (bgVar.c()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, wVar), this.e);
                }
            } else {
                valueOf = String.valueOf(wVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        w wVar;
        bg bgVar;
        switch (message.what) {
            case 0:
                synchronized (this.a) {
                    wVar = (w) message.obj;
                    bgVar = (bg) this.a.get(wVar);
                    if (bgVar != null && bgVar.c()) {
                        if (bgVar.a()) {
                            bgVar.b("GmsClientSupervisor");
                        }
                        this.a.remove(wVar);
                    }
                }
                return true;
            case 1:
                synchronized (this.a) {
                    wVar = (w) message.obj;
                    bgVar = (bg) this.a.get(wVar);
                    if (bgVar != null && bgVar.b() == 3) {
                        String valueOf = String.valueOf(wVar);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                        ComponentName e = bgVar.e();
                        if (e == null) {
                            e = wVar.b();
                        }
                        bgVar.onServiceDisconnected(e == null ? new ComponentName(wVar.a(), "unknown") : e);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
