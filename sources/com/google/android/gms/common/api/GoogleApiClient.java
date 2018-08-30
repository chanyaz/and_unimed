package com.google.android.gms.common.api;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.bq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GoogleApiClient {
    @GuardedBy("sAllClients")
    private static final Set<GoogleApiClient> a = Collections.newSetFromMap(new WeakHashMap());

    public interface ConnectionCallbacks {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    public Looper a() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    @NonNull
    public <C extends Client> C a(@NonNull b<C> bVar) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <A extends AnyClient, R extends Result, T extends b<R, A>> T a(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void a(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public void a(bq bqVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KeepForSdk
    public <A extends AnyClient, T extends b<? extends Result, A>> T b(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void b();

    public abstract void b(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public void b(bq bqVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void c();

    public abstract boolean d();
}
