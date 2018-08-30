package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.util.a;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import java.util.Map.Entry;

class k implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
    final Context a;
    final ComponentName b;
    final ConnectionCallback c;
    final Bundle d;
    final c e = new c(this);
    int f = 1;
    l g;
    n h;
    Messenger i;
    private final a<String, o> j = new a();
    private String k;
    private Token l;
    private Bundle m;

    public k(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (componentName == null) {
            throw new IllegalArgumentException("service component must not be null");
        } else if (connectionCallback == null) {
            throw new IllegalArgumentException("connection callback must not be null");
        } else {
            this.a = context;
            this.b = componentName;
            this.c = connectionCallback;
            this.d = bundle == null ? null : new Bundle(bundle);
        }
    }

    private static String a(int i) {
        switch (i) {
            case 0:
                return "CONNECT_STATE_DISCONNECTING";
            case 1:
                return "CONNECT_STATE_DISCONNECTED";
            case 2:
                return "CONNECT_STATE_CONNECTING";
            case 3:
                return "CONNECT_STATE_CONNECTED";
            case 4:
                return "CONNECT_STATE_SUSPENDED";
            default:
                return "UNKNOWN/" + i;
        }
    }

    private boolean a(Messenger messenger, String str) {
        if (this.i == messenger && this.f != 0 && this.f != 1) {
            return true;
        }
        if (!(this.f == 0 || this.f == 1)) {
            Log.i("MediaBrowserCompat", str + " for " + this.b + " with mCallbacksMessenger=" + this.i + " this=" + this);
        }
        return false;
    }

    void a() {
        if (this.g != null) {
            this.a.unbindService(this.g);
        }
        this.f = 1;
        this.g = null;
        this.h = null;
        this.i = null;
        this.e.a(null);
        this.k = null;
        this.l = null;
    }

    void b() {
        Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
        Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.b);
        Log.d("MediaBrowserCompat", "  mCallback=" + this.c);
        Log.d("MediaBrowserCompat", "  mRootHints=" + this.d);
        Log.d("MediaBrowserCompat", "  mState=" + a(this.f));
        Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.g);
        Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.h);
        Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.i);
        Log.d("MediaBrowserCompat", "  mRootId=" + this.k);
        Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.l);
    }

    public void connect() {
        if (this.f == 0 || this.f == 1) {
            this.f = 2;
            this.e.post(new Runnable() {
                public void run() {
                    if (k.this.f != 0) {
                        k.this.f = 2;
                        if (MediaBrowserCompat.a && k.this.g != null) {
                            throw new RuntimeException("mServiceConnection should be null. Instead it is " + k.this.g);
                        } else if (k.this.h != null) {
                            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + k.this.h);
                        } else if (k.this.i != null) {
                            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + k.this.i);
                        } else {
                            Intent intent = new Intent("android.media.browse.MediaBrowserService");
                            intent.setComponent(k.this.b);
                            k.this.g = new l(k.this);
                            boolean z = false;
                            try {
                                z = k.this.a.bindService(intent, k.this.g, 1);
                            } catch (Exception e) {
                                Log.e("MediaBrowserCompat", "Failed binding to service " + k.this.b);
                            }
                            if (!z) {
                                k.this.a();
                                k.this.c.c();
                            }
                            if (MediaBrowserCompat.a) {
                                Log.d("MediaBrowserCompat", "connect...");
                                k.this.b();
                            }
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + a(this.f) + ")");
    }

    public void disconnect() {
        this.f = 0;
        this.e.post(new Runnable() {
            public void run() {
                if (k.this.i != null) {
                    try {
                        k.this.h.a(k.this.i);
                    } catch (RemoteException e) {
                        Log.w("MediaBrowserCompat", "RemoteException during connect for " + k.this.b);
                    }
                }
                int i = k.this.f;
                k.this.a();
                if (i != 0) {
                    k.this.f = i;
                }
                if (MediaBrowserCompat.a) {
                    Log.d("MediaBrowserCompat", "disconnect...");
                    k.this.b();
                }
            }
        });
    }

    @Nullable
    public Bundle getExtras() {
        if (isConnected()) {
            return this.m;
        }
        throw new IllegalStateException("getExtras() called while not connected (state=" + a(this.f) + ")");
    }

    public void getItem(@NonNull final String str, @NonNull final f fVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId is empty");
        } else if (fVar == null) {
            throw new IllegalArgumentException("cb is null");
        } else if (isConnected()) {
            try {
                this.h.a(str, new ItemReceiver(str, fVar, this.e), this.i);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                this.e.post(new Runnable() {
                    public void run() {
                        fVar.a(str);
                    }
                });
            }
        } else {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.e.post(new Runnable() {
                public void run() {
                    fVar.a(str);
                }
            });
        }
    }

    @NonNull
    public String getRoot() {
        if (isConnected()) {
            return this.k;
        }
        throw new IllegalStateException("getRoot() called while not connected(state=" + a(this.f) + ")");
    }

    @NonNull
    public ComponentName getServiceComponent() {
        if (isConnected()) {
            return this.b;
        }
        throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.f + ")");
    }

    @NonNull
    public Token getSessionToken() {
        if (isConnected()) {
            return this.l;
        }
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f + ")");
    }

    public boolean isConnected() {
        return this.f == 3;
    }

    public void onConnectionFailed(Messenger messenger) {
        Log.e("MediaBrowserCompat", "onConnectFailed for " + this.b);
        if (!a(messenger, "onConnectFailed")) {
            return;
        }
        if (this.f != 2) {
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f) + "... ignoring");
            return;
        }
        a();
        this.c.c();
    }

    public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle) {
        if (a(messenger, "onLoadChildren")) {
            if (MediaBrowserCompat.a) {
                Log.d("MediaBrowserCompat", "onLoadChildren for " + this.b + " id=" + str);
            }
            o oVar = (o) this.j.get(str);
            if (oVar != null) {
                p a = oVar.a(this.a, bundle);
                if (a == null) {
                    return;
                }
                if (bundle == null) {
                    if (list == null) {
                        a.a(str);
                    } else {
                        a.a(str, list);
                    }
                } else if (list == null) {
                    a.a(str, bundle);
                } else {
                    a.a(str, list, bundle);
                }
            } else if (MediaBrowserCompat.a) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
            }
        }
    }

    public void onServiceConnected(Messenger messenger, String str, Token token, Bundle bundle) {
        if (!a(messenger, "onConnect")) {
            return;
        }
        if (this.f != 2) {
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f) + "... ignoring");
            return;
        }
        this.k = str;
        this.l = token;
        this.m = bundle;
        this.f = 3;
        if (MediaBrowserCompat.a) {
            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            b();
        }
        this.c.a();
        try {
            for (Entry entry : this.j.entrySet()) {
                String str2 = (String) entry.getKey();
                o oVar = (o) entry.getValue();
                List c = oVar.c();
                List b = oVar.b();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < c.size()) {
                        this.h.a(str2, ((p) c.get(i2)).c, (Bundle) b.get(i2), this.i);
                        i = i2 + 1;
                    }
                }
            }
        } catch (RemoteException e) {
            Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
        }
    }

    public void search(@NonNull final String str, final Bundle bundle, @NonNull final m mVar) {
        if (isConnected()) {
            try {
                this.h.a(str, bundle, new SearchResultReceiver(str, bundle, mVar, this.e), this.i);
                return;
            } catch (Throwable e) {
                Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e);
                this.e.post(new Runnable() {
                    public void run() {
                        mVar.a(str, bundle);
                    }
                });
                return;
            }
        }
        throw new IllegalStateException("search() called while not connected (state=" + a(this.f) + ")");
    }

    public void sendCustomAction(@NonNull final String str, final Bundle bundle, @Nullable final e eVar) {
        if (isConnected()) {
            try {
                this.h.b(str, bundle, new CustomActionResultReceiver(str, bundle, eVar, this.e), this.i);
                return;
            } catch (Throwable e) {
                Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                if (eVar != null) {
                    this.e.post(new Runnable() {
                        public void run() {
                            eVar.c(str, bundle, null);
                        }
                    });
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Cannot send a custom action (" + str + ") with " + "extras " + bundle + " because the browser is not connected to the " + "service.");
    }

    public void subscribe(@NonNull String str, Bundle bundle, @NonNull p pVar) {
        o oVar;
        o oVar2 = (o) this.j.get(str);
        if (oVar2 == null) {
            oVar2 = new o();
            this.j.put(str, oVar2);
            oVar = oVar2;
        } else {
            oVar = oVar2;
        }
        Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        oVar.a(this.a, bundle2, pVar);
        if (isConnected()) {
            try {
                this.h.a(str, pVar.c, bundle2, this.i);
            } catch (RemoteException e) {
                Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + str);
            }
        }
    }

    public void unsubscribe(@NonNull String str, p pVar) {
        o oVar = (o) this.j.get(str);
        if (oVar != null) {
            if (pVar == null) {
                try {
                    if (isConnected()) {
                        this.h.a(str, null, this.i);
                    }
                } catch (RemoteException e) {
                    Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
                }
            } else {
                List c = oVar.c();
                List b = oVar.b();
                for (int size = c.size() - 1; size >= 0; size--) {
                    if (c.get(size) == pVar) {
                        if (isConnected()) {
                            this.h.a(str, pVar.c, this.i);
                        }
                        c.remove(size);
                        b.remove(size);
                    }
                }
            }
            if (oVar.a() || pVar == null) {
                this.j.remove(str);
            }
        }
    }
}
