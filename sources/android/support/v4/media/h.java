package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.c;
import android.support.v4.util.a;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

@RequiresApi(21)
class h implements ConnectionCallbackInternal, MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
    final Context a;
    protected final Object b;
    protected final Bundle c;
    protected final c d = new c(this);
    protected int e;
    protected n f;
    protected Messenger g;
    private final a<String, o> h = new a();
    private Token i;

    h(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        this.a = context;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_client_version", 1);
        this.c = new Bundle(bundle);
        connectionCallback.a(this);
        this.b = MediaBrowserCompatApi21.a(context, componentName, connectionCallback.a, this.c);
    }

    public void connect() {
        MediaBrowserCompatApi21.a(this.b);
    }

    public void disconnect() {
        if (!(this.f == null || this.g == null)) {
            try {
                this.f.c(this.g);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
            }
        }
        MediaBrowserCompatApi21.b(this.b);
    }

    @Nullable
    public Bundle getExtras() {
        return MediaBrowserCompatApi21.f(this.b);
    }

    public void getItem(@NonNull final String str, @NonNull final f fVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("mediaId is empty");
        } else if (fVar == null) {
            throw new IllegalArgumentException("cb is null");
        } else if (!MediaBrowserCompatApi21.c(this.b)) {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.d.post(new Runnable() {
                public void run() {
                    fVar.a(str);
                }
            });
        } else if (this.f == null) {
            this.d.post(new Runnable() {
                public void run() {
                    fVar.a(str);
                }
            });
        } else {
            try {
                this.f.a(str, new ItemReceiver(str, fVar, this.d), this.g);
            } catch (RemoteException e) {
                Log.i("MediaBrowserCompat", "Remote error getting media item: " + str);
                this.d.post(new Runnable() {
                    public void run() {
                        fVar.a(str);
                    }
                });
            }
        }
    }

    @NonNull
    public String getRoot() {
        return MediaBrowserCompatApi21.e(this.b);
    }

    public ComponentName getServiceComponent() {
        return MediaBrowserCompatApi21.d(this.b);
    }

    @NonNull
    public Token getSessionToken() {
        if (this.i == null) {
            this.i = Token.a(MediaBrowserCompatApi21.g(this.b));
        }
        return this.i;
    }

    public boolean isConnected() {
        return MediaBrowserCompatApi21.c(this.b);
    }

    public void onConnected() {
        Bundle f = MediaBrowserCompatApi21.f(this.b);
        if (f != null) {
            this.e = f.getInt("extra_service_version", 0);
            IBinder a = android.support.v4.app.h.a(f, "extra_messenger");
            if (a != null) {
                this.f = new n(a, this.c);
                this.g = new Messenger(this.d);
                this.d.a(this.g);
                try {
                    this.f.b(this.g);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
            IMediaSession a2 = c.a(android.support.v4.app.h.a(f, "extra_session_binder"));
            if (a2 != null) {
                this.i = Token.a(MediaBrowserCompatApi21.g(this.b), a2);
            }
        }
    }

    public void onConnectionFailed() {
    }

    public void onConnectionFailed(Messenger messenger) {
    }

    public void onConnectionSuspended() {
        this.f = null;
        this.g = null;
        this.i = null;
        this.d.a(null);
    }

    public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle) {
        if (this.g == messenger) {
            o oVar = (o) this.h.get(str);
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
    }

    public void search(@NonNull final String str, final Bundle bundle, @NonNull final m mVar) {
        if (!isConnected()) {
            throw new IllegalStateException("search() called while not connected");
        } else if (this.f == null) {
            Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
            this.d.post(new Runnable() {
                public void run() {
                    mVar.a(str, bundle);
                }
            });
        } else {
            try {
                this.f.a(str, bundle, new SearchResultReceiver(str, bundle, mVar, this.d), this.g);
            } catch (Throwable e) {
                Log.i("MediaBrowserCompat", "Remote error searching items with query: " + str, e);
                this.d.post(new Runnable() {
                    public void run() {
                        mVar.a(str, bundle);
                    }
                });
            }
        }
    }

    public void sendCustomAction(@NonNull final String str, final Bundle bundle, @Nullable final e eVar) {
        if (isConnected()) {
            if (this.f == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
                if (eVar != null) {
                    this.d.post(new Runnable() {
                        public void run() {
                            eVar.c(str, bundle, null);
                        }
                    });
                }
            }
            try {
                this.f.b(str, bundle, new CustomActionResultReceiver(str, bundle, eVar, this.d), this.g);
                return;
            } catch (Throwable e) {
                Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                if (eVar != null) {
                    this.d.post(new Runnable() {
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
        o oVar = (o) this.h.get(str);
        if (oVar == null) {
            oVar = new o();
            this.h.put(str, oVar);
        }
        pVar.a(oVar);
        Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        oVar.a(this.a, bundle2, pVar);
        if (this.f == null) {
            MediaBrowserCompatApi21.a(this.b, str, pVar.b);
            return;
        }
        try {
            this.f.a(str, pVar.c, bundle2, this.g);
        } catch (RemoteException e) {
            Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + str);
        }
    }

    public void unsubscribe(@NonNull String str, p pVar) {
        o oVar = (o) this.h.get(str);
        if (oVar != null) {
            List c;
            List b;
            int size;
            if (this.f == null) {
                if (pVar == null) {
                    MediaBrowserCompatApi21.a(this.b, str);
                } else {
                    c = oVar.c();
                    b = oVar.b();
                    for (size = c.size() - 1; size >= 0; size--) {
                        if (c.get(size) == pVar) {
                            c.remove(size);
                            b.remove(size);
                        }
                    }
                    if (c.size() == 0) {
                        MediaBrowserCompatApi21.a(this.b, str);
                    }
                }
            } else if (pVar == null) {
                try {
                    this.f.a(str, null, this.g);
                } catch (RemoteException e) {
                    Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
                }
            } else {
                c = oVar.c();
                b = oVar.b();
                for (size = c.size() - 1; size >= 0; size--) {
                    if (c.get(size) == pVar) {
                        this.f.a(str, pVar.c, this.g);
                        c.remove(size);
                        b.remove(size);
                    }
                }
            }
            if (oVar.a() || pVar == null) {
                this.h.remove(str);
            }
        }
    }
}
