package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi24.Callback;

class af<T extends Callback> extends ae<T> {
    public af(T t) {
        super(t);
    }

    public void onPrepare() {
        ((Callback) this.a).onPrepare();
    }

    public void onPrepareFromMediaId(String str, Bundle bundle) {
        ((Callback) this.a).onPrepareFromMediaId(str, bundle);
    }

    public void onPrepareFromSearch(String str, Bundle bundle) {
        ((Callback) this.a).onPrepareFromSearch(str, bundle);
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        ((Callback) this.a).onPrepareFromUri(uri, bundle);
    }
}
