package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;

public abstract class u<T extends IInterface> extends BaseGmsClient<T> implements Client, GmsClientEventState {
    private final n e;
    private final Set<Scope> f;
    private final Account g;

    protected u(Context context, Looper looper, int i, n nVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, v.a(context), e.a(), i, nVar, (ConnectionCallbacks) ar.a((Object) connectionCallbacks), (OnConnectionFailedListener) ar.a((Object) onConnectionFailedListener));
    }

    @VisibleForTesting
    protected u(Context context, Looper looper, v vVar, e eVar, int i, n nVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, vVar, eVar, i, a(connectionCallbacks), a(onConnectionFailedListener), nVar.g());
        this.e = nVar;
        this.g = nVar.a();
        this.f = b(nVar.d());
    }

    @Nullable
    private static BaseConnectionCallbacks a(ConnectionCallbacks connectionCallbacks) {
        return connectionCallbacks == null ? null : new bd(connectionCallbacks);
    }

    @Nullable
    private static BaseOnConnectionFailedListener a(OnConnectionFailedListener onConnectionFailedListener) {
        return onConnectionFailedListener == null ? null : new be(onConnectionFailedListener);
    }

    private final Set<Scope> b(@NonNull Set<Scope> set) {
        Set<Scope> a = a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    @NonNull
    protected Set<Scope> a(@NonNull Set<Scope> set) {
        return set;
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public final Account i() {
        return this.g;
    }

    public Feature[] j() {
        return new Feature[0];
    }

    protected final Set<Scope> q() {
        return this.f;
    }
}
