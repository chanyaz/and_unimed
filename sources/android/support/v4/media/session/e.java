package android.support.v4.media.session;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;
import android.util.Log;
import android.view.KeyEvent;

class e extends ConnectionCallback {
    private final Context c;
    private final Intent d;
    private final PendingResult e;
    private MediaBrowserCompat f;

    e(Context context, Intent intent, PendingResult pendingResult) {
        this.c = context;
        this.d = intent;
        this.e = pendingResult;
    }

    private void d() {
        this.f.b();
        this.e.finish();
    }

    public void a() {
        try {
            new MediaControllerCompat(this.c, this.f.c()).a((KeyEvent) this.d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
        } catch (Throwable e) {
            Log.e("MediaButtonReceiver", "Failed to create a media controller", e);
        }
        d();
    }

    void a(MediaBrowserCompat mediaBrowserCompat) {
        this.f = mediaBrowserCompat;
    }

    public void b() {
        d();
    }

    public void c() {
        d();
    }
}
