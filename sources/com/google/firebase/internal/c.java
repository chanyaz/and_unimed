package com.google.firebase.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicReference;

public final class c {
    private static final AtomicReference<c> a = new AtomicReference();

    private c(Context context) {
    }

    public static c a(Context context) {
        a.compareAndSet(null, new c(context));
        return (c) a.get();
    }

    public static void a(@NonNull FirebaseApp firebaseApp) {
    }
}
