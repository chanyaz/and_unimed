package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

class ab {
    final /* synthetic */ MediaBrowserServiceCompat a;

    ab(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.a = mediaBrowserServiceCompat;
    }

    public void a(final ServiceCallbacks serviceCallbacks) {
        this.a.d.a(new Runnable() {
            public void run() {
                z zVar = (z) ab.this.a.b.remove(serviceCallbacks.asBinder());
                if (zVar != null) {
                    zVar.c.asBinder().unlinkToDeath(zVar, 0);
                }
            }
        });
    }

    public void a(final ServiceCallbacks serviceCallbacks, final Bundle bundle) {
        this.a.d.a(new Runnable() {
            public void run() {
                IBinder asBinder = serviceCallbacks.asBinder();
                ab.this.a.b.remove(asBinder);
                DeathRecipient zVar = new z(ab.this.a);
                zVar.c = serviceCallbacks;
                zVar.b = bundle;
                ab.this.a.b.put(asBinder, zVar);
                try {
                    asBinder.linkToDeath(zVar, 0);
                } catch (RemoteException e) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        });
    }

    public void a(String str, int i, Bundle bundle, ServiceCallbacks serviceCallbacks) {
        if (this.a.a(str, i)) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final Bundle bundle2 = bundle;
            final int i2 = i;
            this.a.d.a(new Runnable() {
                public void run() {
                    IBinder asBinder = serviceCallbacks2.asBinder();
                    ab.this.a.b.remove(asBinder);
                    z zVar = new z(ab.this.a);
                    zVar.a = str2;
                    zVar.b = bundle2;
                    zVar.c = serviceCallbacks2;
                    zVar.d = ab.this.a.a(str2, i2, bundle2);
                    if (zVar.d == null) {
                        Log.i("MBServiceCompat", "No root for client " + str2 + " from service " + getClass().getName());
                        try {
                            serviceCallbacks2.onConnectFailed();
                            return;
                        } catch (RemoteException e) {
                            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str2);
                            return;
                        }
                    }
                    try {
                        ab.this.a.b.put(asBinder, zVar);
                        asBinder.linkToDeath(zVar, 0);
                        if (ab.this.a.e != null) {
                            serviceCallbacks2.onConnect(zVar.d.a(), ab.this.a.e, zVar.d.b());
                        }
                    } catch (RemoteException e2) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str2);
                        ab.this.a.b.remove(asBinder);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
    }

    public void a(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
        if (!TextUtils.isEmpty(str) && resultReceiver != null) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final Bundle bundle2 = bundle;
            final ResultReceiver resultReceiver2 = resultReceiver;
            this.a.d.a(new Runnable() {
                public void run() {
                    z zVar = (z) ab.this.a.b.get(serviceCallbacks2.asBinder());
                    if (zVar == null) {
                        Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str2);
                    } else {
                        ab.this.a.a(str2, bundle2, zVar, resultReceiver2);
                    }
                }
            });
        }
    }

    public void a(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
        final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
        final String str2 = str;
        final IBinder iBinder2 = iBinder;
        final Bundle bundle2 = bundle;
        this.a.d.a(new Runnable() {
            public void run() {
                z zVar = (z) ab.this.a.b.get(serviceCallbacks2.asBinder());
                if (zVar == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str2);
                } else {
                    ab.this.a.a(str2, zVar, iBinder2, bundle2);
                }
            }
        });
    }

    public void a(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
        this.a.d.a(new Runnable() {
            public void run() {
                z zVar = (z) ab.this.a.b.get(serviceCallbacks.asBinder());
                if (zVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                } else if (!ab.this.a.a(str, zVar, iBinder)) {
                    Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                }
            }
        });
    }

    public void a(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
        if (!TextUtils.isEmpty(str) && resultReceiver != null) {
            this.a.d.a(new Runnable() {
                public void run() {
                    z zVar = (z) ab.this.a.b.get(serviceCallbacks.asBinder());
                    if (zVar == null) {
                        Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                    } else {
                        ab.this.a.a(str, zVar, resultReceiver);
                    }
                }
            });
        }
    }

    public void b(final ServiceCallbacks serviceCallbacks) {
        this.a.d.a(new Runnable() {
            public void run() {
                IBinder asBinder = serviceCallbacks.asBinder();
                z zVar = (z) ab.this.a.b.remove(asBinder);
                if (zVar != null) {
                    asBinder.unlinkToDeath(zVar, 0);
                }
            }
        });
    }

    public void b(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
        if (!TextUtils.isEmpty(str) && resultReceiver != null) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final Bundle bundle2 = bundle;
            final ResultReceiver resultReceiver2 = resultReceiver;
            this.a.d.a(new Runnable() {
                public void run() {
                    z zVar = (z) ab.this.a.b.get(serviceCallbacks2.asBinder());
                    if (zVar == null) {
                        Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str2 + ", extras=" + bundle2);
                    } else {
                        ab.this.a.b(str2, bundle2, zVar, resultReceiver2);
                    }
                }
            });
        }
    }
}
