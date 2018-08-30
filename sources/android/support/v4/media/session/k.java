package android.support.v4.media.session;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v4.media.session.MediaSessionCompat.Token;

@RequiresApi(23)
class k extends MediaControllerImplApi21 {
    public k(Context context, Token token) {
        super(context, token);
    }

    public o getTransportControls() {
        Object a = MediaControllerCompatApi21.a(this.a);
        return a != null ? new q(a) : null;
    }
}
