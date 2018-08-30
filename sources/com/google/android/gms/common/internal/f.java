package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class f extends ae {
    private BaseGmsClient a;
    private final int b;

    public f(@NonNull BaseGmsClient baseGmsClient, int i) {
        this.a = baseGmsClient;
        this.b = i;
    }

    @BinderThread
    public final void onAccountValidationComplete(int i, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @BinderThread
    public final void onPostInitComplete(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        ar.a(this.a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.a(i, iBinder, bundle, this.b);
        this.a = null;
    }

    @BinderThread
    public final void onPostInitCompleteWithConnectionInfo(int i, @NonNull IBinder iBinder, @NonNull ConnectionInfo connectionInfo) {
        ar.a(this.a, (Object) "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        ar.a((Object) connectionInfo);
        this.a.a(connectionInfo);
        onPostInitComplete(i, iBinder, connectionInfo.a());
    }
}
