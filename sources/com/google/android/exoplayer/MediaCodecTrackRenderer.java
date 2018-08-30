package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.drm.a;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.k;
import com.google.android.exoplayer.util.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class MediaCodecTrackRenderer extends q {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    public final a a;
    protected final Handler b;
    private final DrmSessionManager c;
    private final boolean d;
    private final SampleSourceReader e;
    private final m f;
    private final l g;
    private final List<Long> h;
    private final BufferInfo i;
    private final EventListener j;
    private k k;
    private a l;
    private MediaCodec m;
    private boolean n;
    private boolean o;
    private ByteBuffer[] p;
    private ByteBuffer[] q;
    private long r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z;

    public interface EventListener {
        void onCryptoError(CryptoException cryptoException);

        void onDecoderInitializationError(DecoderInitializationException decoderInitializationException);

        void onDecoderInitialized(String str, long j, long j2);
    }

    public class DecoderInitializationException extends Exception {
        public final String a;
        public final String b;

        public DecoderInitializationException(k kVar, Throwable th, int i) {
            super("Decoder init failed: [" + i + "], " + kVar, th);
            this.a = null;
            this.b = a(i);
        }

        public DecoderInitializationException(k kVar, Throwable th, String str) {
            super("Decoder init failed: " + str + ", " + kVar, th);
            this.a = str;
            this.b = m.a >= 21 ? a(th) : null;
        }

        private static String a(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        @TargetApi(21)
        private static String a(Throwable th) {
            return th instanceof CodecException ? ((CodecException) th).getDiagnosticInfo() : null;
        }
    }

    public MediaCodecTrackRenderer(SampleSource sampleSource, DrmSessionManager drmSessionManager, boolean z, Handler handler, EventListener eventListener) {
        b.b(m.a >= 16);
        this.e = sampleSource.register();
        this.c = drmSessionManager;
        this.d = z;
        this.b = handler;
        this.j = eventListener;
        this.a = new a();
        this.f = new m(0);
        this.g = new l();
        this.h = new ArrayList();
        this.i = new BufferInfo();
        this.w = 0;
        this.x = 0;
    }

    private static CryptoInfo a(m mVar, int i) {
        CryptoInfo a = mVar.a.a();
        if (i != 0) {
            if (a.numBytesOfClearData == null) {
                a.numBytesOfClearData = new int[1];
            }
            int[] iArr = a.numBytesOfClearData;
            iArr[0] = iArr[0] + i;
        }
        return a;
    }

    private void a(final CryptoException cryptoException) {
        if (this.b != null && this.j != null) {
            this.b.post(new Runnable() {
                public void run() {
                    MediaCodecTrackRenderer.this.j.onCryptoError(cryptoException);
                }
            });
        }
    }

    private void a(DecoderInitializationException decoderInitializationException) {
        b(decoderInitializationException);
        throw new ExoPlaybackException((Throwable) decoderInitializationException);
    }

    private void a(String str, long j, long j2) {
        if (this.b != null && this.j != null) {
            final String str2 = str;
            final long j3 = j;
            final long j4 = j2;
            this.b.post(new Runnable() {
                public void run() {
                    MediaCodecTrackRenderer.this.j.onDecoderInitialized(str2, j3, j4);
                }
            });
        }
    }

    private boolean a(boolean z) {
        if (!this.u) {
            return false;
        }
        int state = this.c.getState();
        if (state != 0) {
            return state != 4 ? z || !this.d : false;
        } else {
            throw new ExoPlaybackException(this.c.getError());
        }
    }

    private void b(final DecoderInitializationException decoderInitializationException) {
        if (this.b != null && this.j != null) {
            this.b.post(new Runnable() {
                public void run() {
                    MediaCodecTrackRenderer.this.j.onDecoderInitializationError(decoderInitializationException);
                }
            });
        }
    }

    private boolean b(long j, long j2) {
        if (this.C) {
            return false;
        }
        if (this.t < 0) {
            this.t = this.m.dequeueOutputBuffer(this.i, q());
        }
        a aVar;
        if (this.t == -2) {
            a(this.k, this.m.getOutputFormat());
            aVar = this.a;
            aVar.c++;
            return true;
        } else if (this.t == -3) {
            this.q = this.m.getOutputBuffers();
            aVar = this.a;
            aVar.d++;
            return true;
        } else if (this.t < 0) {
            if (!this.o || (!this.B && this.x != 2)) {
                return false;
            }
            y();
            return true;
        } else if ((this.i.flags & 4) != 0) {
            y();
            return false;
        } else {
            int f = f(this.i.presentationTimeUs);
            if (!a(j, j2, this.m, this.q[this.t], this.i, this.t, f != -1)) {
                return false;
            }
            if (f != -1) {
                this.h.remove(f);
            }
            this.t = -1;
            return true;
        }
    }

    private static boolean b(String str) {
        return m.a <= 17 && "ht7s3".equals(m.b) && "OMX.rk.video_decoder.avc".equals(str);
    }

    private boolean c(long j, boolean z) {
        if (this.B || this.x == 2) {
            return false;
        }
        if (this.s < 0) {
            this.s = this.m.dequeueInputBuffer(0);
            if (this.s < 0) {
                return false;
            }
            this.f.b = this.p[this.s];
            this.f.b.clear();
        }
        if (this.x == 1) {
            if (!this.o) {
                this.m.queueInputBuffer(this.s, 0, 0, 0, 4);
                this.s = -1;
            }
            this.x = 2;
            return false;
        }
        int i;
        int i2;
        if (this.D) {
            i = -3;
        } else {
            if (this.w == 1) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 >= this.k.i.size()) {
                        break;
                    }
                    this.f.b.put((byte[]) this.k.i.get(i2));
                    i = i2 + 1;
                }
                this.w = 2;
            }
            i = this.e.readData(this.z, j, this.g, this.f, false);
            if (z && this.A == 1 && i == -2) {
                this.A = 2;
            }
        }
        if (i == -2) {
            return false;
        }
        if (i == -5) {
            w();
            return true;
        } else if (i == -4) {
            if (this.w == 2) {
                this.f.b.clear();
                this.w = 1;
            }
            a(this.g);
            return true;
        } else if (i == -1) {
            if (this.w == 2) {
                this.f.b.clear();
                this.w = 1;
            }
            this.B = true;
            try {
                if (!this.o) {
                    this.m.queueInputBuffer(this.s, 0, 0, 0, 4);
                    this.s = -1;
                }
                return false;
            } catch (Throwable e) {
                a((CryptoException) e);
                throw new ExoPlaybackException(e);
            }
        } else {
            if (this.E) {
                if (this.f.c()) {
                    this.E = false;
                } else {
                    this.f.b.clear();
                    if (this.w == 2) {
                        this.w = 1;
                    }
                    return true;
                }
            }
            boolean a = this.f.a();
            this.D = a(a);
            if (this.D) {
                return false;
            }
            try {
                int position = this.f.b.position();
                i2 = position - this.f.c;
                long j2 = this.f.e;
                if (this.f.b()) {
                    this.h.add(Long.valueOf(j2));
                }
                if (a) {
                    this.m.queueSecureInputBuffer(this.s, 0, a(this.f, i2), j2, 0);
                } else {
                    this.m.queueInputBuffer(this.s, 0, position, j2, 0);
                }
                this.s = -1;
                this.y = true;
                this.w = 0;
                return true;
            } catch (Throwable e2) {
                a((CryptoException) e2);
                throw new ExoPlaybackException(e2);
            }
        }
    }

    private void d(long j) {
        if (this.e.readData(this.z, j, this.g, this.f, false) == -4) {
            a(this.g);
        }
    }

    private void e(long j) {
        if (this.m != null) {
            if (this.e.readData(this.z, j, this.g, this.f, true) == -5) {
                w();
            }
        }
    }

    private int f(long j) {
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.h.get(i)).longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    private void g() {
        this.A = 0;
        this.B = false;
        this.C = false;
    }

    private void w() {
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.E = true;
        this.D = false;
        this.h.clear();
        if (m.a < 18 || this.x != 0) {
            k();
            h();
        } else {
            this.m.flush();
            this.y = false;
        }
        if (this.v && this.k != null) {
            this.w = 1;
        }
    }

    private boolean x() {
        return SystemClock.elapsedRealtime() < this.r + 1000;
    }

    private void y() {
        if (this.x == 2) {
            k();
            h();
            return;
        }
        this.C = true;
    }

    protected c a(String str, boolean z) {
        return MediaCodecUtil.a(str, z);
    }

    protected void a(long j) {
        this.e.seekToUs(j);
        g();
    }

    protected void a(long j, long j2) {
        int i = this.e.continueBuffering(this.z, j) ? this.A == 0 ? 1 : this.A : 0;
        this.A = i;
        e(j);
        if (this.k == null) {
            d(j);
        }
        if (this.m == null && i()) {
            h();
        }
        if (this.m != null) {
            k.a("drainAndFeed");
            do {
            } while (b(j, j2));
            if (c(j, true)) {
                do {
                } while (c(j, false));
            }
            k.a();
        }
        this.a.a();
    }

    protected void a(long j, boolean z) {
        this.e.enable(this.z, j);
        g();
    }

    protected void a(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, null, mediaCrypto, 0);
    }

    protected void a(k kVar, MediaFormat mediaFormat) {
    }

    protected void a(l lVar) {
        k kVar = this.k;
        this.k = lVar.a;
        this.l = lVar.b;
        if (this.m != null && a(this.m, this.n, kVar, this.k)) {
            this.v = true;
            this.w = 1;
        } else if (this.y) {
            this.x = 1;
        } else {
            k();
            h();
        }
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z);

    protected boolean a(MediaCodec mediaCodec, boolean z, k kVar, k kVar2) {
        return false;
    }

    protected boolean a(String str) {
        return true;
    }

    protected int b(long j) {
        int i = 0;
        if (!this.e.prepare(j)) {
            return 0;
        }
        int trackCount = this.e.getTrackCount();
        while (i < trackCount) {
            if (a(this.e.getTrackInfo(i).a)) {
                this.z = i;
                return 1;
            }
            i++;
        }
        return -1;
    }

    protected void b() {
    }

    protected void c() {
    }

    protected boolean d() {
        return this.C;
    }

    protected boolean e() {
        return (this.k == null || this.D || (this.A == 0 && this.t < 0 && !x())) ? false : true;
    }

    protected void f() {
        this.k = null;
        this.l = null;
        try {
            k();
            try {
                if (this.u) {
                    this.c.close();
                    this.u = false;
                }
                this.e.disable(this.z);
            } catch (Throwable th) {
                this.e.disable(this.z);
            }
        } catch (Throwable th2) {
            this.e.disable(this.z);
        }
    }

    protected final void h() {
        if (i()) {
            MediaCrypto mediaCrypto;
            c a;
            String str = this.k.a;
            boolean z = false;
            if (this.l == null) {
                mediaCrypto = null;
            } else if (this.c == null) {
                throw new ExoPlaybackException("Media requires a DrmSessionManager");
            } else {
                if (!this.u) {
                    this.c.open(this.l);
                    this.u = true;
                }
                int state = this.c.getState();
                if (state == 0) {
                    throw new ExoPlaybackException(this.c.getError());
                } else if (state == 3 || state == 4) {
                    MediaCrypto mediaCrypto2 = this.c.getMediaCrypto();
                    z = this.c.requiresSecureDecoderComponent(str);
                    mediaCrypto = mediaCrypto2;
                } else {
                    return;
                }
            }
            try {
                a = a(str, z);
            } catch (Throwable e) {
                a(new DecoderInitializationException(this.k, e, -49998));
                a = null;
            }
            if (a == null) {
                a(new DecoderInitializationException(this.k, null, -49999));
            }
            String str2 = a.a;
            this.n = a.b;
            this.o = b(str2);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                k.a("createByCodecName(" + str2 + ")");
                this.m = MediaCodec.createByCodecName(str2);
                k.a();
                k.a("configureCodec");
                a(this.m, str2, this.k.a(), mediaCrypto);
                k.a();
                k.a("codec.start()");
                this.m.start();
                k.a();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.p = this.m.getInputBuffers();
                this.q = this.m.getOutputBuffers();
            } catch (Throwable e2) {
                a(new DecoderInitializationException(this.k, e2, str2));
            }
            this.r = r() == 3 ? SystemClock.elapsedRealtime() : -1;
            this.s = -1;
            this.t = -1;
            this.E = true;
            a aVar = this.a;
            aVar.a++;
        }
    }

    protected boolean i() {
        return this.m == null && this.k != null;
    }

    protected final boolean j() {
        return this.m != null;
    }

    protected void k() {
        if (this.m != null) {
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.D = false;
            this.h.clear();
            this.p = null;
            this.q = null;
            this.v = false;
            this.y = false;
            this.n = false;
            this.o = false;
            this.w = 0;
            this.x = 0;
            a aVar = this.a;
            aVar.b++;
            try {
                this.m.stop();
                try {
                    this.m.release();
                } finally {
                    this.m = null;
                }
            } catch (Throwable th) {
                this.m.release();
            } finally {
                this.m = null;
            }
        }
    }

    protected void l() {
        this.e.release();
    }

    protected long m() {
        return this.e.getTrackInfo(this.z).b;
    }

    protected long n() {
        return this.e.getBufferedPositionUs();
    }

    protected void o() {
        try {
            this.e.maybeThrowError();
        } catch (Throwable e) {
            throw new ExoPlaybackException(e);
        }
    }

    protected final int p() {
        return this.A;
    }

    protected long q() {
        return 0;
    }
}
