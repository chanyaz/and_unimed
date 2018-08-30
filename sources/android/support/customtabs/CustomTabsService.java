package android.support.customtabs;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.util.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {
    private final Map<IBinder, DeathRecipient> a = new a();
    private j b = new j() {
        public Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.a(str, bundle);
        }

        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            return CustomTabsService.this.a(new g(iCustomTabsCallback), uri, bundle, list);
        }

        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            boolean z = false;
            final g gVar = new g(iCustomTabsCallback);
            try {
                DeathRecipient anonymousClass1 = new DeathRecipient() {
                    public void binderDied() {
                        CustomTabsService.this.a(gVar);
                    }
                };
                synchronized (CustomTabsService.this.a) {
                    iCustomTabsCallback.asBinder().linkToDeath(anonymousClass1, 0);
                    CustomTabsService.this.a.put(iCustomTabsCallback.asBinder(), anonymousClass1);
                }
                return CustomTabsService.this.b(gVar);
            } catch (RemoteException e) {
                return z;
            }
        }

        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return CustomTabsService.this.a(new g(iCustomTabsCallback), str, bundle);
        }

        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return CustomTabsService.this.a(new g(iCustomTabsCallback), uri);
        }

        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return CustomTabsService.this.a(new g(iCustomTabsCallback), bundle);
        }

        public boolean warmup(long j) {
            return CustomTabsService.this.a(j);
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    protected abstract int a(g gVar, String str, Bundle bundle);

    protected abstract Bundle a(String str, Bundle bundle);

    protected abstract boolean a(long j);

    protected boolean a(g gVar) {
        try {
            synchronized (this.a) {
                IBinder a = gVar.a();
                a.unlinkToDeath((DeathRecipient) this.a.get(a), 0);
                this.a.remove(a);
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected abstract boolean a(g gVar, Uri uri);

    protected abstract boolean a(g gVar, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean a(g gVar, Bundle bundle);

    protected abstract boolean b(g gVar);
}
