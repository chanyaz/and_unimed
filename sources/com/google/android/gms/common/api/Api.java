package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ar;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final a<?, O> a;
    private final e<?, O> b = null;
    private final d<?> c;
    private final f<?> d;
    private final String e;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }
    }

    @KeepForSdk
    public interface AnyClient {
    }

    @KeepForSdk
    public interface Client extends AnyClient {
        void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        @Nullable
        IBinder getServiceBrokerBinder();

        Intent getSignInIntent();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(SignOutCallbacks signOutCallbacks);

        boolean providesSignIn();

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public interface SimpleClient<T extends IInterface> extends AnyClient {
        T createServiceInterface(IBinder iBinder);

        String getServiceDescriptor();

        String getStartServiceAction();

        void setState(int i, T t);
    }

    public <C extends Client> Api(String str, a<C, O> aVar, d<C> dVar) {
        ar.a((Object) aVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        ar.a((Object) dVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.e = str;
        this.a = aVar;
        this.c = dVar;
        this.d = null;
    }

    public final c<?, O> a() {
        return this.a;
    }

    public final a<?, O> b() {
        ar.a(this.a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }

    public final b<?> c() {
        if (this.c != null) {
            return this.c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String d() {
        return this.e;
    }
}
