package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.aw;

@KeepForSdk
public abstract class b<R extends Result, A extends AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
    @KeepForSdk
    private final com.google.android.gms.common.api.b<A> b;
    @KeepForSdk
    private final Api<?> c;

    @KeepForSdk
    protected b(@NonNull Api<?> api, @NonNull GoogleApiClient googleApiClient) {
        super((GoogleApiClient) ar.a((Object) googleApiClient, (Object) "GoogleApiClient must not be null"));
        ar.a((Object) api, (Object) "Api must not be null");
        this.b = api.c();
        this.c = api;
    }

    @KeepForSdk
    private void a(@NonNull RemoteException remoteException) {
        setFailedResult(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    @KeepForSdk
    public final void a(@NonNull A a) {
        AnyClient a2;
        if (a2 instanceof aw) {
            a2 = ((aw) a2).r();
        }
        try {
            b(a2);
        } catch (RemoteException e) {
            a(e);
            throw e;
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    @KeepForSdk
    protected void a(@NonNull R r) {
    }

    @KeepForSdk
    protected abstract void b(@NonNull A a);

    @KeepForSdk
    public final com.google.android.gms.common.api.b<A> d() {
        return this.b;
    }

    @KeepForSdk
    public final Api<?> e() {
        return this.c;
    }

    @KeepForSdk
    public final void setFailedResult(@NonNull Status status) {
        ar.b(!status.c(), "Failed result must not be success");
        Result b = b(status);
        setResult(b);
        a(b);
    }
}
