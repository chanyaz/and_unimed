package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;

class d implements ConnectionCallback {
    final /* synthetic */ ConnectionCallback a;

    d(ConnectionCallback connectionCallback) {
        this.a = connectionCallback;
    }

    public void onConnected() {
        if (this.a.b != null) {
            this.a.b.onConnected();
        }
        this.a.a();
    }

    public void onConnectionFailed() {
        if (this.a.b != null) {
            this.a.b.onConnectionFailed();
        }
        this.a.c();
    }

    public void onConnectionSuspended() {
        if (this.a.b != null) {
            this.a.b.onConnectionSuspended();
        }
        this.a.b();
    }
}
