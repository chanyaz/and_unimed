package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer.audio.AudioTrack;
import com.google.android.exoplayer.audio.AudioTrack.InitializationException;
import com.google.android.exoplayer.audio.AudioTrack.WriteException;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.util.e;
import java.nio.ByteBuffer;

@TargetApi(16)
public class MediaCodecAudioTrackRenderer extends MediaCodecTrackRenderer implements MediaClock {
    private final EventListener c;
    private final AudioTrack d;
    private int e;
    private long f;
    private boolean g;

    public interface EventListener extends com.google.android.exoplayer.MediaCodecTrackRenderer.EventListener {
        void onAudioTrackInitializationError(InitializationException initializationException);

        void onAudioTrackWriteError(WriteException writeException);
    }

    public MediaCodecAudioTrackRenderer(SampleSource sampleSource) {
        this(sampleSource, null, true);
    }

    public MediaCodecAudioTrackRenderer(SampleSource sampleSource, DrmSessionManager drmSessionManager, boolean z) {
        this(sampleSource, drmSessionManager, z, null, null);
    }

    public MediaCodecAudioTrackRenderer(SampleSource sampleSource, DrmSessionManager drmSessionManager, boolean z, Handler handler, EventListener eventListener) {
        super(sampleSource, drmSessionManager, z, handler, eventListener);
        this.c = eventListener;
        this.e = 0;
        this.d = new AudioTrack();
    }

    private void a(final InitializationException initializationException) {
        if (this.b != null && this.c != null) {
            this.b.post(new Runnable() {
                public void run() {
                    MediaCodecAudioTrackRenderer.this.c.onAudioTrackInitializationError(initializationException);
                }
            });
        }
    }

    private void a(final WriteException writeException) {
        if (this.b != null && this.c != null) {
            this.b.post(new Runnable() {
                public void run() {
                    MediaCodecAudioTrackRenderer.this.c.onAudioTrackWriteError(writeException);
                }
            });
        }
    }

    private void d(long j) {
        this.d.h();
        this.f = j;
        this.g = true;
    }

    protected MediaClock a() {
        return this;
    }

    protected c a(String str, boolean z) {
        return e.e(str) ? new c("OMX.google.raw.decoder", true) : super.a(str, z);
    }

    protected void a(int i) {
    }

    protected void a(long j) {
        super.a(j);
        d(j);
    }

    protected void a(long j, boolean z) {
        super.a(j, z);
        d(j);
    }

    protected void a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        if ("OMX.google.raw.decoder".equals(str)) {
            String string = mediaFormat.getString("mime");
            mediaFormat.setString("mime", "audio/raw");
            mediaCodec.configure(mediaFormat, null, mediaCrypto, 0);
            mediaFormat.setString("mime", string);
            return;
        }
        mediaCodec.configure(mediaFormat, null, mediaCrypto, 0);
    }

    protected void a(k kVar, MediaFormat mediaFormat) {
        if (e.e(kVar.a)) {
            this.d.a(kVar.a());
        } else {
            this.d.a(mediaFormat);
        }
    }

    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z) {
        a aVar;
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            aVar = this.a;
            aVar.f++;
            this.d.d();
            return true;
        }
        if (!this.d.a()) {
            try {
                if (this.e != 0) {
                    this.d.a(this.e);
                } else {
                    this.e = this.d.b();
                    a(this.e);
                }
                if (r() == 3) {
                    this.d.c();
                }
            } catch (Throwable e) {
                a((InitializationException) e);
                throw new ExoPlaybackException(e);
            }
        }
        try {
            int a = this.d.a(byteBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
            if ((a & 1) != 0) {
                g();
                this.g = true;
            }
            if ((a & 2) == 0) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            aVar = this.a;
            aVar.e++;
            return true;
        } catch (Throwable e2) {
            a((WriteException) e2);
            throw new ExoPlaybackException(e2);
        }
    }

    protected boolean a(String str) {
        return e.b(str) && super.a(str);
    }

    protected void b() {
        super.b();
        this.d.c();
    }

    protected void c() {
        this.d.g();
        super.c();
    }

    protected boolean d() {
        return super.d() && !(this.d.e() && this.d.f());
    }

    protected boolean e() {
        return this.d.e() || (super.e() && p() == 2);
    }

    protected void f() {
        this.e = 0;
        try {
            this.d.i();
        } finally {
            super.f();
        }
    }

    protected void g() {
    }

    public long getPositionUs() {
        long a = this.d.a(d());
        if (a != Long.MIN_VALUE) {
            if (!this.g) {
                a = Math.max(this.f, a);
            }
            this.f = a;
            this.g = false;
        }
        return this.f;
    }

    public void handleMessage(int i, Object obj) {
        if (i == 1) {
            this.d.a(((Float) obj).floatValue());
        } else {
            super.handleMessage(i, obj);
        }
    }
}
