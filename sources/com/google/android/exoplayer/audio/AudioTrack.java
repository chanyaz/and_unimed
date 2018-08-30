package com.google.android.exoplayer.audio;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.util.Log;
import com.google.android.exoplayer.util.a;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.e;
import com.google.android.exoplayer.util.m;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class AudioTrack {
    public static boolean a = false;
    public static boolean b = false;
    private byte[] A;
    private int B;
    private int C;
    private boolean D;
    private int E;
    private final ConditionVariable c = new ConditionVariable(true);
    private final long[] d;
    private final b e;
    private android.media.AudioTrack f;
    private android.media.AudioTrack g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private long p;
    private long q;
    private boolean r;
    private long s;
    private Method t;
    private long u;
    private int v;
    private long w;
    private long x;
    private long y;
    private float z;

    public final class InitializationException extends Exception {
        public final int a;

        public InitializationException(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.a = i;
        }
    }

    public final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public final class WriteException extends Exception {
        public final int a;

        public WriteException(int i) {
            super("AudioTrack write failed: " + i);
            this.a = i;
        }
    }

    public AudioTrack() {
        if (m.a >= 18) {
            try {
                this.t = android.media.AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (m.a >= 19) {
            this.e = new c();
        } else {
            this.e = new b();
        }
        this.d = new long[10];
        this.z = 1.0f;
        this.v = 0;
    }

    @TargetApi(21)
    private static int a(android.media.AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private long a(long j) {
        return this.D ? this.E == 0 ? 0 : ((8 * j) * ((long) this.h)) / ((long) (this.E * 1000)) : j / ((long) this.k);
    }

    @TargetApi(21)
    private static void a(android.media.AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    private long b(long j) {
        return (1000000 * j) / ((long) this.h);
    }

    private static void b(android.media.AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    private long c(long j) {
        return (((long) this.h) * j) / 1000000;
    }

    private void j() {
        if (this.f != null) {
            final android.media.AudioTrack audioTrack = this.f;
            this.f = null;
            new Thread() {
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean k() {
        return a() && this.v != 0;
    }

    private void l() {
        long c = this.e.c();
        if (c != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.q >= 30000) {
                this.d[this.n] = c - nanoTime;
                this.n = (this.n + 1) % 10;
                if (this.o < 10) {
                    this.o++;
                }
                this.q = nanoTime;
                this.p = 0;
                for (int i = 0; i < this.o; i++) {
                    this.p += this.d[i] / ((long) this.o);
                }
            }
            if (!this.D && nanoTime - this.s >= 500000) {
                this.r = this.e.d();
                if (this.r) {
                    long e = this.e.e() / 1000;
                    long f = this.e.f();
                    String str;
                    if (e < this.x) {
                        this.r = false;
                    } else if (Math.abs(e - nanoTime) > 5000000) {
                        str = "Spurious audio timestamp (system clock mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (b) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.r = false;
                    } else if (Math.abs(b(f) - c) > 5000000) {
                        str = "Spurious audio timestamp (frame position mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c;
                        if (b) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.r = false;
                    }
                }
                if (this.t != null) {
                    try {
                        this.y = (((long) ((Integer) this.t.invoke(this.g, (Object[]) null)).intValue()) * 1000) - b(a((long) this.m));
                        this.y = Math.max(this.y, 0);
                        if (this.y > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.y);
                            this.y = 0;
                        }
                    } catch (Exception e2) {
                        this.t = null;
                    }
                }
                this.s = nanoTime;
            }
        }
    }

    private void m() {
        int state = this.g.getState();
        if (state != 1) {
            try {
                this.g.release();
            } catch (Exception e) {
            } finally {
                this.g = null;
            }
            throw new InitializationException(state, this.h, this.i, this.m);
        }
    }

    private void n() {
        this.p = 0;
        this.o = 0;
        this.n = 0;
        this.q = 0;
        this.r = false;
        this.s = 0;
    }

    public int a(int i) {
        this.c.block();
        if (i == 0) {
            this.g = new android.media.AudioTrack(3, this.h, this.i, this.j, this.m, 1);
        } else {
            this.g = new android.media.AudioTrack(3, this.h, this.i, this.j, this.m, 1, i);
        }
        m();
        int audioSessionId = this.g.getAudioSessionId();
        if (a && m.a < 21) {
            if (!(this.f == null || audioSessionId == this.f.getAudioSessionId())) {
                j();
            }
            if (this.f == null) {
                this.f = new android.media.AudioTrack(3, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        this.e.a(this.g, this.D);
        a(this.z);
        return audioSessionId;
    }

    public int a(ByteBuffer byteBuffer, int i, int i2, long j) {
        if (i2 == 0) {
            return 2;
        }
        if (m.a <= 22 && this.D) {
            if (this.g.getPlayState() == 2) {
                return 0;
            }
            if (this.g.getPlayState() == 1 && this.e.b() != 0) {
                return 0;
            }
        }
        int i3 = 0;
        if (this.C == 0) {
            if (this.D && this.E == 0) {
                this.E = a.a(i2, this.h);
            }
            long b = j - b(a((long) i2));
            if (this.v == 0) {
                this.w = Math.max(0, b);
                this.v = 1;
            } else {
                long b2 = this.w + b(a(this.u));
                if (this.v == 1 && Math.abs(b2 - b) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + b2 + ", got " + b + "]");
                    this.v = 2;
                }
                if (this.v == 2) {
                    this.w += b - b2;
                    this.v = 1;
                    i3 = 1;
                }
            }
        }
        if (this.C == 0) {
            this.C = i2;
            byteBuffer.position(i);
            if (m.a < 21) {
                if (this.A == null || this.A.length < i2) {
                    this.A = new byte[i2];
                }
                byteBuffer.get(this.A, 0, i2);
                this.B = 0;
            }
        }
        int i4 = 0;
        if (m.a < 21) {
            int b3 = this.m - ((int) (this.u - (this.e.b() * ((long) this.k))));
            if (b3 > 0) {
                i4 = this.g.write(this.A, this.B, Math.min(this.C, b3));
                if (i4 >= 0) {
                    this.B += i4;
                }
            }
        } else {
            i4 = a(this.g, byteBuffer, this.C);
        }
        if (i4 < 0) {
            throw new WriteException(i4);
        }
        this.C -= i4;
        this.u += (long) i4;
        return this.C == 0 ? i3 | 2 : i3;
    }

    public long a(boolean z) {
        if (!k()) {
            return Long.MIN_VALUE;
        }
        if (this.g.getPlayState() == 3) {
            l();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.r) {
            return b(c(nanoTime - (this.e.e() / 1000)) + this.e.f()) + this.w;
        }
        nanoTime = this.o == 0 ? this.e.c() + this.w : (nanoTime + this.p) + this.w;
        return !z ? nanoTime - this.y : nanoTime;
    }

    public void a(float f) {
        this.z = f;
        if (!a()) {
            return;
        }
        if (m.a >= 21) {
            a(this.g, f);
        } else {
            b(this.g, f);
        }
    }

    public void a(MediaFormat mediaFormat) {
        a(mediaFormat, 0);
    }

    public void a(MediaFormat mediaFormat, int i) {
        int i2;
        boolean z = true;
        int integer = mediaFormat.getInteger("channel-count");
        switch (integer) {
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 12;
                break;
            case 6:
                i2 = 252;
                break;
            case 8:
                i2 = 1020;
                break;
            default:
                throw new IllegalArgumentException("Unsupported channel count: " + integer);
        }
        int integer2 = mediaFormat.getInteger("sample-rate");
        int d = e.d(mediaFormat.getString("mime"));
        boolean z2 = d == 5 || d == 6;
        if (!a() || this.h != integer2 || this.i != i2 || this.D || z2) {
            h();
            this.j = d;
            this.h = integer2;
            this.i = i2;
            this.D = z2;
            this.E = 0;
            this.k = integer * 2;
            this.l = android.media.AudioTrack.getMinBufferSize(integer2, i2, d);
            if (this.l == -2) {
                z = false;
            }
            b.b(z);
            if (i != 0) {
                this.m = i;
                return;
            }
            int i3 = this.l * 4;
            i2 = ((int) c(250000)) * this.k;
            int max = (int) Math.max((long) this.l, c(750000) * ((long) this.k));
            if (i3 >= i2) {
                i2 = i3 > max ? max : i3;
            }
            this.m = i2;
        }
    }

    public boolean a() {
        return this.g != null;
    }

    public int b() {
        return a(0);
    }

    public void c() {
        if (a()) {
            this.x = System.nanoTime() / 1000;
            this.g.play();
        }
    }

    public void d() {
        if (this.v == 1) {
            this.v = 2;
        }
    }

    public boolean e() {
        return a() && (a(this.u) > this.e.b() || this.e.a());
    }

    public boolean f() {
        return this.u > ((long) ((this.l * 3) / 2));
    }

    public void g() {
        if (a()) {
            n();
            this.g.pause();
        }
    }

    public void h() {
        if (a()) {
            this.u = 0;
            this.C = 0;
            this.v = 0;
            this.y = 0;
            n();
            if (this.g.getPlayState() == 3) {
                this.g.pause();
            }
            final android.media.AudioTrack audioTrack = this.g;
            this.g = null;
            this.e.a(null, false);
            this.c.close();
            new Thread() {
                public void run() {
                    try {
                        audioTrack.release();
                    } finally {
                        AudioTrack.this.c.open();
                    }
                }
            }.start();
        }
    }

    public void i() {
        h();
        j();
    }
}
