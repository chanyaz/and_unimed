package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class l extends Handler {
    private final /* synthetic */ BaseGmsClient a;

    public l(BaseGmsClient baseGmsClient, Looper looper) {
        this.a = baseGmsClient;
        super(looper);
    }

    private static void a(Message message) {
        e eVar = (e) message.obj;
        eVar.a();
        eVar.c();
    }

    private static boolean b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    public final void handleMessage(Message message) {
        PendingIntent pendingIntent = null;
        ConnectionResult d;
        if (this.a.c.get() != message.arg1) {
            if (b(message)) {
                a(message);
            }
        } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.a.isConnecting()) {
            a(message);
        } else if (message.what == 4) {
            this.a.A = new ConnectionResult(message.arg2);
            if (!this.a.s() || this.a.B) {
                d = this.a.A != null ? this.a.A : new ConnectionResult(8);
                this.a.b.onReportServiceBinding(d);
                this.a.a(d);
                return;
            }
            this.a.b(3, null);
        } else if (message.what == 5) {
            d = this.a.A != null ? this.a.A : new ConnectionResult(8);
            this.a.b.onReportServiceBinding(d);
            this.a.a(d);
        } else if (message.what == 3) {
            if (message.obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) message.obj;
            }
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
            this.a.b.onReportServiceBinding(connectionResult);
            this.a.a(connectionResult);
        } else if (message.what == 6) {
            this.a.b(5, null);
            if (this.a.w != null) {
                this.a.w.onConnectionSuspended(message.arg2);
            }
            this.a.a(message.arg2);
            this.a.a(5, 1, null);
        } else if (message.what == 2 && !this.a.isConnected()) {
            a(message);
        } else if (b(message)) {
            ((e) message.obj).b();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
        }
    }
}
