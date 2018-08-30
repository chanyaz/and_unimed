package com.google.android.gms.common.api.internal;

import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ar;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ca extends cd {
    private final SparseArray<cb> e = new SparseArray();

    private ca(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.a.addCallback("AutoManageHelper", this);
    }

    public static ca b(l lVar) {
        LifecycleFragment a = LifecycleCallback.a(lVar);
        ca caVar = (ca) a.getCallbackOrNull("AutoManageHelper", ca.class);
        return caVar != null ? caVar : new ca(a);
    }

    @Nullable
    private final cb b(int i) {
        return this.e.size() <= i ? null : (cb) this.e.get(this.e.keyAt(i));
    }

    public final void a(int i) {
        OnConnectionFailedListener onConnectionFailedListener = (cb) this.e.get(i);
        this.e.remove(i);
        if (onConnectionFailedListener != null) {
            onConnectionFailedListener.b.b(onConnectionFailedListener);
            onConnectionFailedListener.b.c();
        }
    }

    public final void a(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        ar.a((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        ar.a(this.e.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        ce ceVar = (ce) this.c.get();
        boolean z = this.b;
        String valueOf = String.valueOf(ceVar);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 49).append("starting AutoManage for client ").append(i).append(" ").append(z).append(" ").append(valueOf).toString());
        this.e.put(i, new cb(this, i, googleApiClient, onConnectionFailedListener));
        if (this.b && ceVar == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf2).length() + 11).append("connecting ").append(valueOf2).toString());
            googleApiClient.b();
        }
    }

    protected final void a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        cb cbVar = (cb) this.e.get(i);
        if (cbVar != null) {
            a(i);
            OnConnectionFailedListener onConnectionFailedListener = cbVar.c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.e.size(); i++) {
            cb b = b(i);
            if (b != null) {
                printWriter.append(str).append("GoogleApiClient #").print(b.a);
                printWriter.println(":");
                b.b.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void b() {
        super.b();
        boolean z = this.b;
        String valueOf = String.valueOf(this.e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (this.c.get() == null) {
            for (int i = 0; i < this.e.size(); i++) {
                cb b = b(i);
                if (b != null) {
                    b.b.b();
                }
            }
        }
    }

    public void d() {
        super.d();
        for (int i = 0; i < this.e.size(); i++) {
            cb b = b(i);
            if (b != null) {
                b.b.c();
            }
        }
    }

    protected final void f() {
        for (int i = 0; i < this.e.size(); i++) {
            cb b = b(i);
            if (b != null) {
                b.b.b();
            }
        }
    }
}
