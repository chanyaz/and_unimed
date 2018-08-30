package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.media.session.MediaSessionCompatApi23.Callback;

@RequiresApi(23)
class y extends x implements Callback {
    final /* synthetic */ v b;

    y(v vVar) {
        this.b = vVar;
        super(vVar);
    }

    public void onPlayFromUri(Uri uri, Bundle bundle) {
        this.b.b(uri, bundle);
    }
}
