package android.support.v4.media;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

class l implements ServiceConnection {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    private void a(Runnable runnable) {
        if (Thread.currentThread() == this.a.e.getLooper().getThread()) {
            runnable.run();
        } else {
            this.a.e.post(runnable);
        }
    }

    boolean a(String str) {
        if (this.a.g == this && this.a.f != 0 && this.a.f != 1) {
            return true;
        }
        if (!(this.a.f == 0 || this.a.f == 1)) {
            Log.i("MediaBrowserCompat", str + " for " + this.a.b + " with mServiceConnection=" + this.a.g + " this=" + this);
        }
        return false;
    }

    public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
        a(new Runnable() {
            public void run() {
                if (MediaBrowserCompat.a) {
                    Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                    l.this.a.b();
                }
                if (l.this.a("onServiceConnected")) {
                    l.this.a.h = new n(iBinder, l.this.a.d);
                    l.this.a.i = new Messenger(l.this.a.e);
                    l.this.a.e.a(l.this.a.i);
                    l.this.a.f = 2;
                    try {
                        if (MediaBrowserCompat.a) {
                            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                            l.this.a.b();
                        }
                        l.this.a.h.a(l.this.a.a, l.this.a.i);
                    } catch (RemoteException e) {
                        Log.w("MediaBrowserCompat", "RemoteException during connect for " + l.this.a.b);
                        if (MediaBrowserCompat.a) {
                            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                            l.this.a.b();
                        }
                    }
                }
            }
        });
    }

    public void onServiceDisconnected(final ComponentName componentName) {
        a(new Runnable() {
            public void run() {
                if (MediaBrowserCompat.a) {
                    Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + l.this.a.g);
                    l.this.a.b();
                }
                if (l.this.a("onServiceDisconnected")) {
                    l.this.a.h = null;
                    l.this.a.i = null;
                    l.this.a.e.a(null);
                    l.this.a.f = 4;
                    l.this.a.c.b();
                }
            }
        });
    }
}
