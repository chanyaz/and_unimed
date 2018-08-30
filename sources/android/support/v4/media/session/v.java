package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

public abstract class v {
    final Object a;
    private WeakReference<MediaSessionImpl> b;
    private w c = null;
    private boolean d;

    public v() {
        if (VERSION.SDK_INT >= 24) {
            this.a = MediaSessionCompatApi24.a(new z(this));
        } else if (VERSION.SDK_INT >= 23) {
            this.a = MediaSessionCompatApi23.a(new y(this));
        } else if (VERSION.SDK_INT >= 21) {
            this.a = MediaSessionCompatApi21.a(new x(this));
        } else {
            this.a = null;
        }
    }

    private void a(MediaSessionImpl mediaSessionImpl, Handler handler) {
        this.b = new WeakReference(mediaSessionImpl);
        if (this.c != null) {
            this.c.removeCallbacksAndMessages(null);
        }
        this.c = new w(this, handler.getLooper());
    }

    private void i() {
        if (this.d) {
            this.d = false;
            this.c.removeMessages(1);
            MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.b.get();
            if (mediaSessionImpl != null) {
                int i;
                PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                long b = playbackState == null ? 0 : playbackState.b();
                if (playbackState == null || playbackState.a() != 3) {
                    boolean i2 = false;
                } else {
                    i2 = 1;
                }
                if ((516 & b) != 0) {
                    int i3 = 1;
                } else {
                    boolean i32 = false;
                }
                if ((b & 514) != 0) {
                    int i4 = 1;
                } else {
                    boolean i42 = false;
                }
                if (i2 != 0 && i42 != 0) {
                    c();
                } else if (i2 == 0 && i32 != 0) {
                    b();
                }
            }
        }
    }

    public void a() {
    }

    public void a(int i) {
    }

    public void a(long j) {
    }

    public void a(Uri uri, Bundle bundle) {
    }

    public void a(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void a(MediaDescriptionCompat mediaDescriptionCompat, int i) {
    }

    public void a(RatingCompat ratingCompat) {
    }

    public void a(RatingCompat ratingCompat, Bundle bundle) {
    }

    public void a(String str, Bundle bundle) {
    }

    public void a(String str, Bundle bundle, ResultReceiver resultReceiver) {
    }

    public void a(boolean z) {
    }

    public boolean a(Intent intent) {
        MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.b.get();
        if (mediaSessionImpl == null || this.c == null) {
            return false;
        }
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null || keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
                if (keyEvent.getRepeatCount() > 0) {
                    i();
                } else if (this.d) {
                    this.c.removeMessages(1);
                    this.d = false;
                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    if (((playbackState == null ? 0 : playbackState.b()) & 32) != 0) {
                        d();
                    }
                } else {
                    this.d = true;
                    this.c.sendEmptyMessageDelayed(1, (long) ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            default:
                i();
                return false;
        }
    }

    public void b() {
    }

    public void b(int i) {
    }

    public void b(long j) {
    }

    public void b(Uri uri, Bundle bundle) {
    }

    public void b(MediaDescriptionCompat mediaDescriptionCompat) {
    }

    public void b(String str, Bundle bundle) {
    }

    public void c() {
    }

    public void c(String str, Bundle bundle) {
    }

    public void d() {
    }

    public void d(String str, Bundle bundle) {
    }

    public void e() {
    }

    public void e(String str, Bundle bundle) {
    }

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }
}
