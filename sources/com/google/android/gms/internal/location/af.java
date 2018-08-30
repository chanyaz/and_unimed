package com.google.android.gms.internal.location;

import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ar;

public final class af {
    public static Looper a() {
        ar.a(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }

    public static Looper a(@Nullable Looper looper) {
        return looper != null ? looper : a();
    }
}
