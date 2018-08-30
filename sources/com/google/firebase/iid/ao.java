package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class ao {
    private final Messenger a;
    private final zzi b;

    ao(IBinder iBinder) {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.a = new Messenger(iBinder);
            this.b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.b = new zzi(iBinder);
            this.a = null;
        } else {
            String str = "MessengerIpcClient";
            String str2 = "Invalid interface descriptor: ";
            interfaceDescriptor = String.valueOf(interfaceDescriptor);
            Log.w(str, interfaceDescriptor.length() != 0 ? str2.concat(interfaceDescriptor) : new String(str2));
            throw new RemoteException();
        }
    }

    final void a(Message message) {
        if (this.a != null) {
            this.a.send(message);
        } else if (this.b != null) {
            this.b.a(message);
        } else {
            throw new IllegalStateException("Both messengers are null");
        }
    }
}
