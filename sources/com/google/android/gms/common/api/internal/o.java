package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ar;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

@KeepForSdk
public class o {
    private final Set<ListenerHolder<?>> a = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static <L> ListenerHolder<L> a(@NonNull L l, @NonNull Looper looper, @NonNull String str) {
        ar.a((Object) l, (Object) "Listener must not be null");
        ar.a((Object) looper, (Object) "Looper must not be null");
        ar.a((Object) str, (Object) "Listener type must not be null");
        return new ListenerHolder(looper, l, str);
    }

    @KeepForSdk
    public static <L> m<L> a(@NonNull L l, @NonNull String str) {
        ar.a((Object) l, (Object) "Listener must not be null");
        ar.a((Object) str, (Object) "Listener type must not be null");
        ar.a(str, (Object) "Listener type must not be empty");
        return new m(l, str);
    }

    public final void a() {
        for (ListenerHolder a : this.a) {
            a.a();
        }
        this.a.clear();
    }
}
