package com.google.firebase.iid;

import android.util.Log;

public final class y extends ClassLoader {
    protected final Class<?> loadClass(String str, boolean z) {
        if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
            return super.loadClass(str, z);
        }
        if (FirebaseInstanceId.i()) {
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
        }
        return zzi.class;
    }
}
