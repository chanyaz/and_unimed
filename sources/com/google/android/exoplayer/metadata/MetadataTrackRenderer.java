package com.google.android.exoplayer.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.l;
import com.google.android.exoplayer.m;
import com.google.android.exoplayer.q;

public final class MetadataTrackRenderer<T> extends q implements Callback {
    private final SampleSourceReader a;
    private final MetadataParser<T> b;
    private final MetadataRenderer<T> c;
    private final Handler d;
    private final l e;
    private final m f;
    private int g;
    private boolean h;
    private long i;
    private T j;

    public interface MetadataRenderer<T> {
        void onMetadata(T t);
    }

    private void a(T t) {
        if (this.d != null) {
            this.d.obtainMessage(0, t).sendToTarget();
        } else {
            b((Object) t);
        }
    }

    private void b(T t) {
        this.c.onMetadata(t);
    }

    private void g() {
        this.j = null;
        this.h = false;
    }

    protected void a(long j) {
        this.a.seekToUs(j);
        g();
    }

    protected void a(long j, long j2) {
        this.a.continueBuffering(this.g, j);
        if (!this.h && this.j == null) {
            int readData = this.a.readData(this.g, j, this.e, this.f, false);
            if (readData == -3) {
                this.i = this.f.e;
                try {
                    this.j = this.b.parse(this.f.b.array(), this.f.c);
                    this.f.b.clear();
                } catch (Throwable e) {
                    throw new ExoPlaybackException(e);
                }
            } else if (readData == -1) {
                this.h = true;
            }
        }
        if (this.j != null && this.i <= j) {
            a(this.j);
            this.j = null;
        }
    }

    protected void a(long j, boolean z) {
        this.a.enable(this.g, j);
        g();
    }

    protected int b(long j) {
        int i = 0;
        if (!this.a.prepare(j)) {
            return 0;
        }
        int trackCount = this.a.getTrackCount();
        while (i < trackCount) {
            if (this.b.canParse(this.a.getTrackInfo(i).a)) {
                this.g = i;
                return 1;
            }
            i++;
        }
        return -1;
    }

    protected boolean d() {
        return this.h;
    }

    protected boolean e() {
        return true;
    }

    protected void f() {
        this.j = null;
        this.a.disable(this.g);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                b(message.obj);
                return true;
            default:
                return false;
        }
    }

    protected long m() {
        return this.a.getTrackInfo(this.g).b;
    }

    protected long n() {
        return -3;
    }

    protected void o() {
        try {
            this.a.maybeThrowError();
        } catch (Throwable e) {
            throw new ExoPlaybackException(e);
        }
    }
}
