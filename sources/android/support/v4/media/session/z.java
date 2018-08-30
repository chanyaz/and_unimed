package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.media.session.MediaSessionCompatApi24.Callback;

@RequiresApi(24)
class z extends y implements Callback {
    final /* synthetic */ v c;

    z(v vVar) {
        this.c = vVar;
        super(vVar);
    }

    public void onPrepare() {
        this.c.a();
    }

    public void onPrepareFromMediaId(String str, Bundle bundle) {
        this.c.a(str, bundle);
    }

    public void onPrepareFromSearch(String str, Bundle bundle) {
        this.c.b(str, bundle);
    }

    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        this.c.a(uri, bundle);
    }
}
