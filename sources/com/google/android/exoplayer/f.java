package com.google.android.exoplayer;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer.ExoPlayer.ExoPlayerComponent;
import com.google.android.exoplayer.ExoPlayer.Listener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class f implements ExoPlayer {
    private final Handler a;
    private final g b;
    private final CopyOnWriteArraySet<Listener> c = new CopyOnWriteArraySet();
    private final boolean[] d;
    private final boolean[] e;
    private boolean f = false;
    private int g = 1;
    private int h;

    @SuppressLint({"HandlerLeak"})
    public f(int i, int i2, int i3) {
        int i4 = 0;
        Log.i("ExoPlayerImpl", "Init 1.4.2");
        this.d = new boolean[i];
        this.e = new boolean[i];
        while (i4 < this.e.length) {
            this.e[i4] = true;
            i4++;
        }
        this.a = new Handler() {
            public void handleMessage(Message message) {
                f.this.a(message);
            }
        };
        this.b = new g(this.a, this.f, this.e, i2, i3);
    }

    void a(Message message) {
        Iterator it;
        switch (message.what) {
            case 1:
                boolean[] zArr = (boolean[]) message.obj;
                System.arraycopy(zArr, 0, this.d, 0, zArr.length);
                this.g = message.arg1;
                it = this.c.iterator();
                while (it.hasNext()) {
                    ((Listener) it.next()).onPlayerStateChanged(this.f, this.g);
                }
                return;
            case 2:
                this.g = message.arg1;
                it = this.c.iterator();
                while (it.hasNext()) {
                    ((Listener) it.next()).onPlayerStateChanged(this.f, this.g);
                }
                return;
            case 3:
                this.h--;
                if (this.h == 0) {
                    it = this.c.iterator();
                    while (it.hasNext()) {
                        ((Listener) it.next()).onPlayWhenReadyCommitted();
                    }
                    return;
                }
                return;
            case 4:
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    ((Listener) it2.next()).onPlayerError(exoPlaybackException);
                }
                return;
            default:
                return;
        }
    }

    public void addListener(Listener listener) {
        this.c.add(listener);
    }

    public void blockingSendMessage(ExoPlayerComponent exoPlayerComponent, int i, Object obj) {
        this.b.b(exoPlayerComponent, i, obj);
    }

    public int getBufferedPercentage() {
        long j = 100;
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -1 || duration == -1) {
            return 0;
        }
        if (duration != 0) {
            j = (100 * bufferedPosition) / duration;
        }
        return (int) j;
    }

    public long getBufferedPosition() {
        return this.b.c();
    }

    public long getCurrentPosition() {
        return this.b.b();
    }

    public long getDuration() {
        return this.b.d();
    }

    public boolean getPlayWhenReady() {
        return this.f;
    }

    public Looper getPlaybackLooper() {
        return this.b.a();
    }

    public int getPlaybackState() {
        return this.g;
    }

    public boolean getRendererEnabled(int i) {
        return this.e[i];
    }

    public boolean getRendererHasMedia(int i) {
        return this.d[i];
    }

    public boolean isPlayWhenReadyCommitted() {
        return this.h == 0;
    }

    public void prepare(q... qVarArr) {
        Arrays.fill(this.d, false);
        this.b.a(qVarArr);
    }

    public void release() {
        this.b.f();
        this.a.removeCallbacksAndMessages(null);
    }

    public void removeListener(Listener listener) {
        this.c.remove(listener);
    }

    public void seekTo(long j) {
        this.b.a(j);
    }

    public void sendMessage(ExoPlayerComponent exoPlayerComponent, int i, Object obj) {
        this.b.a(exoPlayerComponent, i, obj);
    }

    public void setPlayWhenReady(boolean z) {
        if (this.f != z) {
            this.f = z;
            this.h++;
            this.b.a(z);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onPlayerStateChanged(z, this.g);
            }
        }
    }

    public void setRendererEnabled(int i, boolean z) {
        if (this.e[i] != z) {
            this.e[i] = z;
            this.b.a(i, z);
        }
    }

    public void stop() {
        this.b.e();
    }
}
