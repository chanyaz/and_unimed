package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.g;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public abstract class BaseGmsClient<T extends IInterface> {
    public static final String[] d = new String[]{"service_esmobile", "service_googleme"};
    private static final Feature[] e = new Feature[0];
    private ConnectionResult A;
    private boolean B;
    private volatile ConnectionInfo C;
    final Handler a;
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks b;
    @VisibleForTesting
    protected AtomicInteger c;
    private int f;
    private long g;
    private long h;
    private int i;
    private long j;
    @VisibleForTesting
    private y k;
    private final Context l;
    private final Looper m;
    private final v n;
    private final g o;
    private final Object p;
    private final Object q;
    @GuardedBy("mServiceBrokerLock")
    private IGmsServiceBroker r;
    @GuardedBy("mLock")
    private T s;
    private final ArrayList<com/google/android/gms/common/internal/e<?>> t;
    @GuardedBy("mLock")
    private com.google.android.gms.common.internal.BaseGmsClient$com.google.android.gms.common.internal.g u;
    @GuardedBy("mLock")
    private int v;
    private final BaseConnectionCallbacks w;
    private final BaseOnConnectionFailedListener x;
    private final int y;
    private final String z;

    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(@NonNull ConnectionResult connectionResult);
    }

    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    public interface BaseConnectionCallbacks {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, v.a(context), g.b(), i, (BaseConnectionCallbacks) ar.a((Object) baseConnectionCallbacks), (BaseOnConnectionFailedListener) ar.a((Object) baseOnConnectionFailedListener), str);
    }

    @VisibleForTesting
    protected BaseGmsClient(Context context, Looper looper, v vVar, g gVar, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.p = new Object();
        this.q = new Object();
        this.t = new ArrayList();
        this.v = 1;
        this.A = null;
        this.B = false;
        this.C = null;
        this.c = new AtomicInteger(0);
        this.l = (Context) ar.a((Object) context, (Object) "Context must not be null");
        this.m = (Looper) ar.a((Object) looper, (Object) "Looper must not be null");
        this.n = (v) ar.a((Object) vVar, (Object) "Supervisor must not be null");
        this.o = (g) ar.a((Object) gVar, (Object) "API availability must not be null");
        this.a = new l(this, looper);
        this.y = i;
        this.w = baseConnectionCallbacks;
        this.x = baseOnConnectionFailedListener;
        this.z = str;
    }

    private final void a(ConnectionInfo connectionInfo) {
        this.C = connectionInfo;
    }

    private final boolean a(int i, int i2, T t) {
        boolean z;
        synchronized (this.p) {
            if (this.v != i) {
                z = false;
            } else {
                b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private final void b(int i, T t) {
        boolean z = true;
        if ((i == 4) != (t != null)) {
            z = false;
        }
        ar.b(z);
        synchronized (this.p) {
            this.v = i;
            this.s = t;
            a(i, (IInterface) t);
            switch (i) {
                case 1:
                    if (this.u != null) {
                        this.n.b(a(), b(), c(), this.u, e());
                        this.u = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    String a;
                    String b;
                    if (!(this.u == null || this.k == null)) {
                        a = this.k.a();
                        b = this.k.b();
                        Log.e("GmsClient", new StringBuilder((String.valueOf(a).length() + 70) + String.valueOf(b).length()).append("Calling connect() while still connected, missing disconnect() for ").append(a).append(" on ").append(b).toString());
                        this.n.b(this.k.a(), this.k.b(), this.k.c(), this.u, e());
                        this.c.incrementAndGet();
                    }
                    this.u = new g(this, this.c.get());
                    y yVar = (this.v != 3 || f() == null) ? new y(b(), a(), false, c()) : new y(h().getPackageName(), f(), true, c());
                    this.k = yVar;
                    if (!this.n.a(this.k.a(), this.k.b(), this.k.c(), this.u, e())) {
                        a = this.k.a();
                        b = this.k.b();
                        Log.e("GmsClient", new StringBuilder((String.valueOf(a).length() + 34) + String.valueOf(b).length()).append("unable to connect to service: ").append(a).append(" on ").append(b).toString());
                        a(16, null, this.c.get());
                        break;
                    }
                    break;
                case 4:
                    a((IInterface) t);
                    break;
            }
        }
    }

    private final void c(int i) {
        int i2;
        if (r()) {
            i2 = 5;
            this.B = true;
        } else {
            i2 = 4;
        }
        this.a.sendMessage(this.a.obtainMessage(i2, this.c.get(), 16));
    }

    private final boolean r() {
        boolean z;
        synchronized (this.p) {
            z = this.v == 3;
        }
        return z;
    }

    private final boolean s() {
        if (this.B || TextUtils.isEmpty(d()) || TextUtils.isEmpty(f())) {
            return false;
        }
        try {
            Class.forName(d());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @Nullable
    protected abstract T a(IBinder iBinder);

    @NonNull
    protected abstract String a();

    @CallSuper
    protected void a(int i) {
        this.f = i;
        this.g = System.currentTimeMillis();
    }

    protected void a(int i, @Nullable Bundle bundle, int i2) {
        this.a.sendMessage(this.a.obtainMessage(7, i2, -1, new j(this, i, bundle)));
    }

    protected void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.a.sendMessage(this.a.obtainMessage(1, i2, -1, new i(this, i, iBinder, bundle)));
    }

    void a(int i, T t) {
    }

    @CallSuper
    protected void a(@NonNull T t) {
        this.h = System.currentTimeMillis();
    }

    @CallSuper
    protected void a(ConnectionResult connectionResult) {
        this.i = connectionResult.c();
        this.j = System.currentTimeMillis();
    }

    @VisibleForTesting
    protected void a(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, @Nullable PendingIntent pendingIntent) {
        this.b = (ConnectionProgressReportCallbacks) ar.a((Object) connectionProgressReportCallbacks, (Object) "Connection progress callbacks cannot be null.");
        this.a.sendMessage(this.a.obtainMessage(3, this.c.get(), i, pendingIntent));
    }

    protected String b() {
        return "com.google.android.gms";
    }

    public void b(int i) {
        this.a.sendMessage(this.a.obtainMessage(6, this.c.get(), i));
    }

    protected int c() {
        return 129;
    }

    public void connect(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.b = (ConnectionProgressReportCallbacks) ar.a((Object) connectionProgressReportCallbacks, (Object) "Connection progress callbacks cannot be null.");
        b(2, null);
    }

    @NonNull
    protected abstract String d();

    public void disconnect() {
        this.c.incrementAndGet();
        synchronized (this.t) {
            int size = this.t.size();
            for (int i = 0; i < size; i++) {
                ((e) this.t.get(i)).d();
            }
            this.t.clear();
        }
        synchronized (this.q) {
            this.r = null;
        }
        b(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        PrintWriter append;
        long j;
        String format;
        synchronized (this.p) {
            i = this.v;
            iInterface = this.s;
        }
        synchronized (this.q) {
            iGmsServiceBroker = this.r;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(d()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.h > 0) {
            append = printWriter.append(str).append("lastConnectedTime=");
            j = this.h;
            format = simpleDateFormat.format(new Date(this.h));
            append.println(new StringBuilder(String.valueOf(format).length() + 21).append(j).append(" ").append(format).toString());
        }
        if (this.g > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.g;
            format = simpleDateFormat.format(new Date(this.g));
            append.println(new StringBuilder(String.valueOf(format).length() + 21).append(j).append(" ").append(format).toString());
        }
        if (this.j > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(com.google.android.gms.common.api.g.a(this.i));
            append = printWriter.append(" lastFailedTime=");
            j = this.j;
            String format2 = simpleDateFormat.format(new Date(this.j));
            append.println(new StringBuilder(String.valueOf(format2).length() + 21).append(j).append(" ").append(format2).toString());
        }
    }

    @Nullable
    protected final String e() {
        return this.z == null ? this.l.getClass().getName() : this.z;
    }

    @Nullable
    protected String f() {
        return null;
    }

    public void g() {
        int b = this.o.b(this.l, getMinApkVersion());
        if (b != 0) {
            b(1, null);
            a(new h(this), b, null);
            return;
        }
        connect(new h(this));
    }

    @Nullable
    public final Feature[] getAvailableFeatures() {
        ConnectionInfo connectionInfo = this.C;
        return connectionInfo == null ? null : connectionInfo.b();
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public String getEndpointPackageName() {
        if (isConnected() && this.k != null) {
            return this.k.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public int getMinApkVersion() {
        return g.b;
    }

    @WorkerThread
    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Throwable e;
        GetServiceRequest a = new GetServiceRequest(this.y).a(this.l.getPackageName()).a(m());
        if (set != null) {
            a.a((Collection) set);
        }
        if (requiresSignIn()) {
            a.a(l()).a(iAccountAccessor);
        } else if (p()) {
            a.a(i());
        }
        a.a(j());
        a.b(k());
        try {
            synchronized (this.q) {
                if (this.r != null) {
                    this.r.getService(new f(this, this.c.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (Throwable e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            b(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException e4) {
            e2 = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            a(8, null, null, this.c.get());
        } catch (RuntimeException e5) {
            e2 = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            a(8, null, null, this.c.get());
        }
    }

    @Nullable
    public IBinder getServiceBrokerBinder() {
        IBinder iBinder;
        synchronized (this.q) {
            if (this.r == null) {
                iBinder = null;
            } else {
                iBinder = this.r.asBinder();
            }
        }
        return iBinder;
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final Context h() {
        return this.l;
    }

    public Account i() {
        return null;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.p) {
            z = this.v == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.p) {
            z = this.v == 2 || this.v == 3;
        }
        return z;
    }

    public Feature[] j() {
        return e;
    }

    public Feature[] k() {
        return e;
    }

    public final Account l() {
        return i() != null ? i() : new Account("<<default account>>", "com.google");
    }

    protected Bundle m() {
        return new Bundle();
    }

    protected final void n() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T o() {
        T t;
        synchronized (this.p) {
            if (this.v == 5) {
                throw new DeadObjectException();
            }
            n();
            ar.a(this.s != null, (Object) "Client is connected but service is null");
            t = this.s;
        }
        return t;
    }

    public void onUserSignOut(@NonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public boolean p() {
        return false;
    }

    public boolean providesSignIn() {
        return false;
    }

    protected Set<Scope> q() {
        return Collections.EMPTY_SET;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }
}
