package com.appnext.base.b;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.appnext.base.services.OperationService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.i;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;
import java.util.List;

public class a {
    protected static final String TAG = a.class.getSimpleName();
    private GoogleApiClient iW;
    private b iX;
    private a iY = null;
    private long iZ;
    private c ja;

    class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                d.init(context);
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(c.jB);
                synchronized (a.this) {
                    a.this.g(parcelableArrayListExtra);
                }
            }
        }
    }

    class b implements ConnectionCallbacks, OnConnectionFailedListener {
        private b() {
        }

        /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onConnected(Bundle bundle) {
            synchronized (a.this) {
                a.this.cs();
            }
        }

        public void onConnectionFailed(@Nullable ConnectionResult connectionResult) {
            synchronized (a.this) {
                if (connectionResult != null) {
                    try {
                        a.this.aq(connectionResult.e());
                    } catch (Throwable th) {
                        a.this.aq(a.TAG + " Error connecting GoogleApiClient");
                    }
                } else {
                    a.this.aq(a.TAG + " Error connecting GoogleApiClient");
                }
            }
        }

        public void onConnectionSuspended(int i) {
            synchronized (a.this) {
                if (a.this.iW != null) {
                    a.this.iW.b();
                }
            }
        }
    }

    public interface c {
        void h(List<DetectedActivity> list);

        void onError(String str);
    }

    private void aq(String str) {
        if (this.ja != null) {
            this.ja.onError(str);
        }
    }

    private boolean cr() {
        try {
            this.iX = new b(this, null);
            this.iW = new i(d.getContext()).a(this.iX).a(this.iX).a(com.google.android.gms.location.a.a).b();
            return true;
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return false;
        }
    }

    @SuppressLint({"all"})
    private void cs() {
        try {
            if (!hasPermission()) {
                aq(TAG + " No permissions for activity recognition.");
            } else if (this.iW == null || !this.iW.d()) {
                aq(TAG + " Google Api Client not connected.");
            } else {
                this.iY = new a(this, null);
                android.support.v4.content.c.a(d.getContext()).a(this.iY, new IntentFilter(c.jA));
                com.google.android.gms.location.a.b.requestActivityUpdates(this.iW, this.iZ, cu()).a(new ResultCallback<Status>() {
                    public void onResult(@NonNull Status status) {
                        synchronized (a.this) {
                            if (!status.c()) {
                                a.this.aq(a.TAG + " " + status.a());
                            }
                        }
                    }
                });
            }
        } catch (Throwable th) {
            aq(TAG + " Google Api Client not connected.");
        }
    }

    @SuppressLint({"all"})
    private void ct() {
        try {
            if (this.iW == null) {
                return;
            }
            if (!this.iW.d()) {
                this.iW.c();
                this.iW = null;
                this.iX = null;
            } else if (hasPermission()) {
                com.google.android.gms.location.a.b.removeActivityUpdates(this.iW, cu()).a(new ResultCallback<Status>() {
                    public void onResult(@NonNull Status status) {
                        try {
                            if (a.this.iW != null && a.this.iW.d()) {
                                a.this.iW.c();
                            }
                            a.this.iW = null;
                            a.this.iX = null;
                        } catch (Throwable th) {
                            com.appnext.base.b.a(th);
                        }
                    }
                });
            } else {
                this.iW.c();
                this.iW = null;
                this.iX = null;
            }
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
        }
    }

    private PendingIntent cu() {
        Intent intent = new Intent(d.getContext(), OperationService.class);
        intent.putExtra(c.jz, c.jz);
        return PendingIntent.getService(d.getContext(), 0, intent, 134217728);
    }

    private void g(ArrayList<DetectedActivity> arrayList) {
        if (this.ja != null) {
            this.ja.h(arrayList);
        }
    }

    private static boolean hasPermission() {
        return f.g(d.getContext(), "com.google.android.gms.permission.ACTIVITY_RECOGNITION");
    }

    public void a(c cVar) {
        this.ja = cVar;
    }

    public void b(long j) {
        synchronized (this) {
            this.iZ = j;
            if (cr()) {
                this.iW.b();
            } else {
                aq(TAG + " Google Api ActivityRecognition not available.");
            }
        }
    }

    public void stop() {
        synchronized (this) {
            if (this.iY != null) {
                android.support.v4.content.c.a(d.getContext()).a(this.iY);
                this.iY = null;
            }
            ct();
        }
    }
}
