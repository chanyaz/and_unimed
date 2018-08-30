package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.util.e;
import com.google.android.exoplayer.util.k;
import com.google.android.exoplayer.util.m;
import com.mopub.mobileads.VastIconXmlManager;
import java.nio.ByteBuffer;

@TargetApi(16)
public class MediaCodecVideoTrackRenderer extends MediaCodecTrackRenderer {
    private final FrameReleaseTimeHelper c;
    private final EventListener d;
    private final long e;
    private final int f;
    private final int g;
    private Surface h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private int m;
    private int n;
    private int o;
    private float p;
    private float q;
    private int r;
    private int s;
    private float t;

    public interface EventListener extends com.google.android.exoplayer.MediaCodecTrackRenderer.EventListener {
        void onDrawnToSurface(Surface surface);

        void onDroppedFrames(int i, long j);

        void onVideoSizeChanged(int i, int i2, float f);
    }

    public interface FrameReleaseTimeHelper {
        long adjustReleaseTime(long j, long j2);

        void disable();

        void enable();
    }

    public MediaCodecVideoTrackRenderer(SampleSource sampleSource, int i, long j, Handler handler, EventListener eventListener, int i2) {
        this(sampleSource, null, true, i, j, null, handler, eventListener, i2);
    }

    public MediaCodecVideoTrackRenderer(SampleSource sampleSource, DrmSessionManager drmSessionManager, boolean z, int i, long j, FrameReleaseTimeHelper frameReleaseTimeHelper, Handler handler, EventListener eventListener, int i2) {
        super(sampleSource, drmSessionManager, z, handler, eventListener);
        this.f = i;
        this.e = 1000 * j;
        this.c = frameReleaseTimeHelper;
        this.d = eventListener;
        this.g = i2;
        this.k = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1;
        this.s = -1;
        this.t = -1.0f;
    }

    private void a(Surface surface) {
        if (this.h != surface) {
            this.h = surface;
            this.i = false;
            int r = r();
            if (r == 2 || r == 3) {
                k();
                h();
            }
        }
    }

    private void g() {
        if (this.b != null && this.d != null) {
            if (this.r != this.n || this.s != this.o || this.t != this.p) {
                final int i = this.n;
                final int i2 = this.o;
                final float f = this.p;
                this.b.post(new Runnable() {
                    public void run() {
                        MediaCodecVideoTrackRenderer.this.d.onVideoSizeChanged(i, i2, f);
                    }
                });
                this.r = i;
                this.s = i2;
                this.t = f;
            }
        }
    }

    private void w() {
        if (this.b != null && this.d != null && !this.i) {
            final Surface surface = this.h;
            this.b.post(new Runnable() {
                public void run() {
                    MediaCodecVideoTrackRenderer.this.d.onDrawnToSurface(surface);
                }
            });
            this.i = true;
        }
    }

    private void x() {
        if (this.b != null && this.d != null && this.m != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final int i = this.m;
            final long j = elapsedRealtime - this.l;
            this.b.post(new Runnable() {
                public void run() {
                    MediaCodecVideoTrackRenderer.this.d.onDroppedFrames(i, j);
                }
            });
            this.m = 0;
            this.l = elapsedRealtime;
        }
    }

    protected void a(long j) {
        super.a(j);
        this.j = false;
        this.k = -1;
    }

    protected void a(long j, boolean z) {
        super.a(j, z);
        this.j = false;
        if (z && this.e > 0) {
            this.k = (SystemClock.elapsedRealtime() * 1000) + this.e;
        }
        if (this.c != null) {
            this.c.enable();
        }
    }

    protected void a(MediaCodec mediaCodec, int i) {
        k.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        k.a();
        a aVar = this.a;
        aVar.f++;
    }

    @TargetApi(21)
    protected void a(MediaCodec mediaCodec, int i, long j) {
        g();
        k.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        k.a();
        a aVar = this.a;
        aVar.e++;
        this.j = true;
        w();
    }

    protected void a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, this.h, mediaCrypto, 0);
        mediaCodec.setVideoScalingMode(this.f);
    }

    protected void a(k kVar, MediaFormat mediaFormat) {
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        this.n = obj != null ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(VastIconXmlManager.WIDTH);
        this.o = obj != null ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(VastIconXmlManager.HEIGHT);
        this.p = this.q;
    }

    protected void a(l lVar) {
        super.a(lVar);
        this.q = lVar.a.f == -1.0f ? 1.0f : lVar.a.f;
    }

    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z) {
        if (z) {
            a(mediaCodec, i);
            return true;
        }
        long elapsedRealtime = (bufferInfo.presentationTimeUs - j) - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime = System.nanoTime();
        long j3 = (1000 * elapsedRealtime) + nanoTime;
        if (this.c != null) {
            j3 = this.c.adjustReleaseTime(bufferInfo.presentationTimeUs, j3);
            elapsedRealtime = (j3 - nanoTime) / 1000;
        }
        if (elapsedRealtime < -30000) {
            b(mediaCodec, i);
            return true;
        } else if (!this.j) {
            if (m.a >= 21) {
                a(mediaCodec, i, System.nanoTime());
            } else {
                c(mediaCodec, i);
            }
            return true;
        } else if (r() != 3) {
            return false;
        } else {
            if (m.a >= 21) {
                if (elapsedRealtime < 50000) {
                    a(mediaCodec, i, j3);
                    return true;
                }
            } else if (elapsedRealtime < 30000) {
                if (elapsedRealtime > 11000) {
                    try {
                        Thread.sleep((elapsedRealtime - 10000) / 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                c(mediaCodec, i);
                return true;
            }
            return false;
        }
    }

    protected boolean a(MediaCodec mediaCodec, boolean z, k kVar, k kVar2) {
        return kVar2.a.equals(kVar.a) && (z || (kVar.d == kVar2.d && kVar.e == kVar2.e));
    }

    protected boolean a(String str) {
        return e.c(str) && super.a(str);
    }

    protected void b() {
        super.b();
        this.m = 0;
        this.l = SystemClock.elapsedRealtime();
    }

    protected void b(MediaCodec mediaCodec, int i) {
        k.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        k.a();
        a aVar = this.a;
        aVar.g++;
        this.m++;
        if (this.m == this.g) {
            x();
        }
    }

    protected void c() {
        this.k = -1;
        x();
        super.c();
    }

    protected void c(MediaCodec mediaCodec, int i) {
        g();
        k.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        k.a();
        a aVar = this.a;
        aVar.e++;
        this.j = true;
        w();
    }

    protected boolean e() {
        if (super.e() && (this.j || !j() || p() == 2)) {
            this.k = -1;
            return true;
        } else if (this.k == -1) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() * 1000 < this.k) {
                return true;
            }
            this.k = -1;
            return false;
        }
    }

    public void f() {
        this.n = -1;
        this.o = -1;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1;
        this.s = -1;
        this.t = -1.0f;
        if (this.c != null) {
            this.c.disable();
        }
        super.f();
    }

    public void handleMessage(int i, Object obj) {
        if (i == 1) {
            a((Surface) obj);
        } else {
            super.handleMessage(i, obj);
        }
    }

    protected boolean i() {
        return super.i() && this.h != null && this.h.isValid();
    }
}
