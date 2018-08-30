package android.support.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class g {
    private final ICustomTabsCallback a;
    private final a b = new a() {
        public void a(int i, Bundle bundle) {
            try {
                g.this.a.onNavigationEvent(i, bundle);
            } catch (RemoteException e) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void a(Bundle bundle) {
            try {
                g.this.a.onMessageChannelReady(bundle);
            } catch (RemoteException e) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void a(String str, Bundle bundle) {
            try {
                g.this.a.extraCallback(str, bundle);
            } catch (RemoteException e) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        public void b(String str, Bundle bundle) {
            try {
                g.this.a.onPostMessage(str, bundle);
            } catch (RemoteException e) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    };

    g(ICustomTabsCallback iCustomTabsCallback) {
        this.a = iCustomTabsCallback;
    }

    IBinder a() {
        return this.a.asBinder();
    }

    public boolean equals(Object obj) {
        return !(obj instanceof g) ? false : ((g) obj).a().equals(this.a.asBinder());
    }

    public int hashCode() {
        return a().hashCode();
    }
}
