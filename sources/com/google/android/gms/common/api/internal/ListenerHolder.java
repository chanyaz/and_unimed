package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ar;

@KeepForSdk
public final class ListenerHolder<L> {
    private final n a;
    private volatile L b;
    private final m<L> c;

    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(L l);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    @KeepForSdk
    ListenerHolder(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.a = new n(this, looper);
        this.b = ar.a((Object) l, (Object) "Listener must not be null");
        this.c = new m(l, ar.a(str));
    }

    @KeepForSdk
    public final void a() {
        this.b = null;
    }

    @KeepForSdk
    public final void a(Notifier<? super L> notifier) {
        ar.a((Object) notifier, (Object) "Notifier must not be null");
        this.a.sendMessage(this.a.obtainMessage(1, notifier));
    }

    @KeepForSdk
    @NonNull
    public final m<L> b() {
        return this.c;
    }

    @KeepForSdk
    final void b(Notifier<? super L> notifier) {
        Object obj = this.b;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }
}
