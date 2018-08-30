package com.google.android.gms.internal.ads;

import android.os.RemoteException;

@zzadh
public class awm {
    public static zzzj a(String str) {
        try {
            return new awn((ph) Class.forName(str, false, awm.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable th) {
            RemoteException remoteException = new RemoteException();
        }
    }
}
