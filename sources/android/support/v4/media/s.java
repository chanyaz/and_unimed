package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;

class s<T extends ConnectionCallback> extends ConnectionCallback {
    protected final T a;

    public s(T t) {
        this.a = t;
    }

    public void onConnected() {
        this.a.onConnected();
    }

    public void onConnectionFailed() {
        this.a.onConnectionFailed();
    }

    public void onConnectionSuspended() {
        this.a.onConnectionSuspended();
    }
}
