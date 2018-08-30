package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

class g extends Handler {
    boolean a;
    final /* synthetic */ f b;

    public void handleMessage(Message message) {
        if (this.a) {
            switch (message.what) {
                case 1:
                    this.b.a((String) message.obj, message.getData());
                    return;
                case 2:
                    this.b.a((PlaybackStateCompat) message.obj);
                    return;
                case 3:
                    this.b.a((MediaMetadataCompat) message.obj);
                    return;
                case 4:
                    this.b.a((n) message.obj);
                    return;
                case 5:
                    this.b.a((List) message.obj);
                    return;
                case 6:
                    this.b.a((CharSequence) message.obj);
                    return;
                case 7:
                    this.b.a((Bundle) message.obj);
                    return;
                case 8:
                    this.b.b();
                    return;
                case 9:
                    this.b.a(((Integer) message.obj).intValue());
                    return;
                case 11:
                    this.b.a(((Boolean) message.obj).booleanValue());
                    return;
                case 12:
                    this.b.b(((Integer) message.obj).intValue());
                    return;
                case 13:
                    this.b.a();
                    return;
                default:
                    return;
            }
        }
    }
}
