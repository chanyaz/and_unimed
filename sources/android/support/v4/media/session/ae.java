package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi23.Callback;

class ae<T extends Callback> extends ab<T> {
    public ae(T t) {
        super(t);
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
        ((Callback) this.a).onPlayFromUri(uri, bundle);
    }
}
