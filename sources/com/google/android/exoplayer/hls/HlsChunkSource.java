package com.google.android.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer.audio.a;
import com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener;
import com.google.android.exoplayer.chunk.f;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.l;
import com.google.android.exoplayer.util.m;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public class HlsChunkSource {
    private final DataSource a;
    private final j b;
    private final BandwidthMeter c;
    private final int d;
    private final String e;
    private final int f;
    private final int g;
    private final long h;
    private final long i;
    private final a j;
    private final n[] k;
    private final f[] l;
    private final long[] m;
    private final long[] n;
    private int o;
    private byte[] p;
    private boolean q;
    private long r;
    private Uri s;
    private byte[] t;
    private String u;
    private byte[] v;

    public interface EventListener extends BaseChunkSampleSourceEventListener {
    }

    private int a(long j) {
        boolean z = false;
        if (j == -1) {
            j = 0;
        }
        int i = (int) (((float) j) * 0.8f);
        int i2 = -1;
        for (int i3 = 0; i3 < this.k.length; i3++) {
            if (this.n[i3] == 0) {
                if (this.k[i3].b.c <= i) {
                    return i3;
                }
                i2 = i3;
            }
        }
        if (i2 != -1) {
            z = true;
        }
        b.b(z);
        return i2;
    }

    private int a(f fVar) {
        for (int i = 0; i < this.k.length; i++) {
            if (this.k[i].b.equals(fVar)) {
                return i;
            }
        }
        throw new IllegalStateException("Invalid format: " + fVar);
    }

    private int a(m mVar, long j) {
        d();
        long bitrateEstimate = this.c.getBitrateEstimate();
        if (this.n[this.o] != 0) {
            return a(bitrateEstimate);
        }
        if (mVar == null) {
            return this.o;
        }
        if (bitrateEstimate == -1) {
            return this.o;
        }
        int a = a(bitrateEstimate);
        if (a == this.o) {
            return this.o;
        }
        bitrateEstimate = (this.d == 1 ? mVar.g : mVar.h) - j;
        return (this.n[this.o] != 0 || ((a > this.o && bitrateEstimate < this.i) || (a < this.o && bitrateEstimate > this.h))) ? a : this.o;
    }

    private b a(Uri uri, String str, int i) {
        return new b(this.a, new c(uri, 0, -1, null, 1), this.p, str, i);
    }

    private void a(int i, f fVar) {
        this.m[i] = SystemClock.elapsedRealtime();
        this.l[i] = fVar;
        this.q |= fVar.e;
        this.r = fVar.f;
    }

    private void a(Uri uri, String str, byte[] bArr) {
        Object toByteArray = new BigInteger(str.toLowerCase(Locale.getDefault()).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        Object obj = new byte[16];
        int length = toByteArray.length > 16 ? toByteArray.length - 16 : 0;
        System.arraycopy(toByteArray, length, obj, (obj.length - toByteArray.length) + length, toByteArray.length - length);
        this.s = uri;
        this.t = bArr;
        this.u = str;
        this.v = obj;
    }

    private boolean a(int i) {
        return SystemClock.elapsedRealtime() - this.m[i] >= ((long) ((this.l[i].b * 1000) / 2));
    }

    private int b(int i) {
        f fVar = this.l[i];
        return (fVar.d.size() > 3 ? fVar.d.size() - 3 : 0) + fVar.a;
    }

    private void b() {
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
    }

    private c c(int i) {
        Uri a = l.a(this.e, this.k[i].a);
        return new c(this.a, new c(a, 0, -1, null, 1), this.p, this.b, i, a.toString());
    }

    private boolean c() {
        for (long j : this.n) {
            if (j == 0) {
                return false;
            }
        }
        return true;
    }

    private void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = 0;
        while (i < this.n.length) {
            if (this.n[i] != 0 && elapsedRealtime - this.n[i] > 60000) {
                this.n[i] = 0;
            }
            i++;
        }
    }

    public long a() {
        return this.q ? -1 : this.r;
    }

    public com.google.android.exoplayer.chunk.b a(m mVar, long j, long j2) {
        int i;
        boolean z;
        int a;
        if (this.d == 0) {
            i = this.o;
            z = false;
        } else {
            a = a(mVar, j2);
            boolean z2 = (mVar == null || this.k[a].b.equals(mVar.d) || this.d != 1) ? false : true;
            z = z2;
            i = a;
        }
        f fVar = this.l[i];
        if (fVar == null) {
            return c(i);
        }
        int b;
        this.o = i;
        Object obj;
        if (this.q) {
            if (mVar == null) {
                obj = null;
                b = b(i);
            } else {
                a = z ? mVar.i : mVar.i + 1;
                if (a < fVar.a) {
                    b = b(i);
                    int obj2 = 1;
                } else {
                    obj2 = null;
                    b = a;
                }
            }
        } else if (mVar == null) {
            obj2 = null;
            b = m.a(fVar.d, Long.valueOf(j), true, true) + fVar.a;
        } else {
            obj2 = null;
            b = z ? mVar.i : mVar.i + 1;
        }
        int i2 = b - fVar.a;
        if (i2 >= fVar.d.size()) {
            return (fVar.e && a(i)) ? c(i) : null;
        } else {
            d dVar;
            g gVar = (g) fVar.d.get(i2);
            Uri a2 = l.a(fVar.g, gVar.c);
            if (gVar.e) {
                Uri a3 = l.a(fVar.g, gVar.f);
                if (!a3.equals(this.s)) {
                    return a(a3, gVar.g, this.o);
                } else if (!m.a(gVar.g, this.u)) {
                    a(a3, gVar.g, this.t);
                }
            } else {
                b();
            }
            c cVar = new c(a2, (long) gVar.h, (long) gVar.i, null);
            long j3 = this.q ? mVar == null ? 0 : z ? mVar.g : mVar.h : gVar.d;
            long j4 = j3 + ((long) (gVar.b * 1000000.0d));
            boolean z3 = !fVar.e && i2 == fVar.d.size() - 1;
            f fVar2 = this.k[this.o].b;
            if (mVar == null || gVar.a || !fVar2.equals(mVar.d) || obj2 != null) {
                dVar = new d(0, fVar2, j3, a2.getLastPathSegment().endsWith(".aac") ? new com.google.android.exoplayer.extractor.b.b(j3) : new com.google.android.exoplayer.extractor.b.l(j3, this.j), z);
            } else {
                dVar = mVar.a;
            }
            return new m(this.a, cVar, 0, fVar2, j3, j4, b, z3, dVar, this.t, this.v);
        }
    }

    public void a(com.google.android.exoplayer.chunk.b bVar) {
        if (bVar instanceof c) {
            c cVar = (c) bVar;
            this.p = cVar.a();
            a(cVar.a, cVar.b());
        } else if (bVar instanceof b) {
            b bVar2 = (b) bVar;
            this.p = bVar2.a();
            a(bVar2.e.a, bVar2.a, bVar2.b());
        }
    }

    public void a(k kVar) {
        if (this.f != -1 && this.g != -1) {
            kVar.a(this.f, this.g);
        }
    }

    public boolean a(com.google.android.exoplayer.chunk.b bVar, IOException iOException) {
        if (bVar.e() != 0) {
            return false;
        }
        if ((!(bVar instanceof m) && !(bVar instanceof c) && !(bVar instanceof b)) || !(iOException instanceof InvalidResponseCodeException)) {
            return false;
        }
        int i = ((InvalidResponseCodeException) iOException).b;
        if (i != 404 && i != 410) {
            return false;
        }
        int a = bVar instanceof m ? a(((m) bVar).d) : bVar instanceof c ? ((c) bVar).a : ((b) bVar).g;
        boolean z = this.n[a] != 0;
        this.n[a] = SystemClock.elapsedRealtime();
        if (z) {
            Log.w("HlsChunkSource", "Already blacklisted variant (" + i + "): " + bVar.e.a);
            return false;
        } else if (c()) {
            Log.w("HlsChunkSource", "Final variant not blacklisted (" + i + "): " + bVar.e.a);
            this.n[a] = 0;
            return false;
        } else {
            Log.w("HlsChunkSource", "Blacklisted variant (" + i + "): " + bVar.e.a);
            return true;
        }
    }
}
