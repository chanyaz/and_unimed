package com.google.android.exoplayer.upstream.cache;

import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.upstream.cache.CacheDataSink.CacheDataSinkException;
import java.io.IOException;

public final class CacheDataSource implements DataSource {
    private final Cache a;
    private final DataSource b;
    private final DataSource c;
    private final DataSource d;
    private final EventListener e;
    private final boolean f;
    private final boolean g;
    private DataSource h;
    private Uri i;
    private int j;
    private String k;
    private long l;
    private long m;
    private a n;
    private boolean o;
    private long p;

    public interface EventListener {
        void onCachedBytesRead(long j, long j2);
    }

    private void a() {
        a aVar = null;
        try {
            c cVar;
            if (!this.o) {
                if (this.m == -1) {
                    Log.w("CacheDataSource", "Cache bypassed due to unbounded length.");
                } else {
                    aVar = this.f ? this.a.startReadWrite(this.k, this.l) : this.a.startReadWriteNonBlocking(this.k, this.l);
                }
            }
            if (aVar == null) {
                this.h = this.d;
                cVar = new c(this.i, this.l, this.m, this.k, this.j);
            } else if (aVar.d) {
                long j = this.l - aVar.b;
                cVar = new c(Uri.fromFile(aVar.e), this.l, j, Math.min(aVar.c - j, this.m), this.k, this.j);
                this.h = this.b;
            } else {
                this.n = aVar;
                cVar = new c(this.i, this.l, aVar.a() ? this.m : Math.min(aVar.c, this.m), this.k, this.j);
                this.h = this.c != null ? this.c : this.d;
            }
            this.h.open(cVar);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void a(IOException iOException) {
        if (!this.g) {
            return;
        }
        if (this.h == this.b || (iOException instanceof CacheDataSinkException)) {
            this.o = true;
        }
    }

    /* JADX WARNING: Failed to extract finally block: empty outs */
    /* JADX WARNING: Missing block: B:14:?, code:
            return;
     */
    private void b() {
        /*
        r4 = this;
        r3 = 0;
        r0 = r4.h;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = r4.h;	 Catch:{ all -> 0x001c }
        r0.close();	 Catch:{ all -> 0x001c }
        r0 = 0;
        r4.h = r0;	 Catch:{ all -> 0x001c }
        r0 = r4.n;
        if (r0 == 0) goto L_0x0005;
    L_0x0012:
        r0 = r4.a;
        r1 = r4.n;
        r0.releaseHoleSpan(r1);
        r4.n = r3;
        goto L_0x0005;
    L_0x001c:
        r0 = move-exception;
        r1 = r4.n;
        if (r1 == 0) goto L_0x002a;
    L_0x0021:
        r1 = r4.a;
        r2 = r4.n;
        r1.releaseHoleSpan(r2);
        r4.n = r3;
    L_0x002a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer.upstream.cache.CacheDataSource.b():void");
    }

    private void c() {
        if (this.e != null && this.p > 0) {
            this.e.onCachedBytesRead(this.a.getCacheSpace(), this.p);
            this.p = 0;
        }
    }

    public void close() {
        c();
        try {
            b();
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    public long open(c cVar) {
        try {
            this.i = cVar.a;
            this.j = cVar.g;
            this.k = cVar.f;
            this.l = cVar.d;
            this.m = cVar.e;
            a();
            return cVar.e;
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            int read = this.h.read(bArr, i, i2);
            if (read >= 0) {
                if (this.h == this.b) {
                    this.p += (long) read;
                }
                this.l += (long) read;
                if (this.m == -1) {
                    return read;
                }
                this.m -= (long) read;
                return read;
            }
            b();
            if (this.m <= 0 || this.m == -1) {
                return read;
            }
            a();
            return read(bArr, i, i2);
        } catch (IOException e) {
            a(e);
            throw e;
        }
    }
}
