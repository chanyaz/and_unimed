package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.support.v4.util.o;
import java.util.HashMap;
import java.util.List;

class z implements DeathRecipient {
    String a;
    Bundle b;
    ServiceCallbacks c;
    y d;
    HashMap<String, List<o<IBinder, Bundle>>> e = new HashMap();
    final /* synthetic */ MediaBrowserServiceCompat f;

    z(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.f = mediaBrowserServiceCompat;
    }

    public void binderDied() {
        this.f.d.post(new Runnable() {
            public void run() {
                z.this.f.b.remove(z.this.c.asBinder());
            }
        });
    }
}
