package android.support.v4.media.session;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v4.media.session.MediaSessionCompat.Token;

@RequiresApi(24)
class l extends k {
    public l(Context context, Token token) {
        super(context, token);
    }

    public o getTransportControls() {
        Object a = MediaControllerCompatApi21.a(this.a);
        return a != null ? new r(a) : null;
    }
}
