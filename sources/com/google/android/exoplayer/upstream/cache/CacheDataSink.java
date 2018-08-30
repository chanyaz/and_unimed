package com.google.android.exoplayer.upstream.cache;

import com.google.android.exoplayer.upstream.DataSink;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class CacheDataSink implements DataSink {
    private final Cache a;
    private final long b;
    private c c;
    private File d;
    private FileOutputStream e;
    private long f;
    private long g;

    public class CacheDataSinkException extends IOException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    private void a() {
        this.d = this.a.startFile(this.c.f, this.c.c + this.g, Math.min(this.c.e - this.g, this.b));
        this.e = new FileOutputStream(this.d);
        this.f = 0;
    }

    private void b() {
        if (this.e != null) {
            try {
                this.e.flush();
                this.e.getFD().sync();
                m.a(this.e);
                this.a.commitFile(this.d);
                this.e = null;
                this.d = null;
            } catch (Throwable th) {
                m.a(this.e);
                this.d.delete();
                this.e = null;
                this.d = null;
            }
        }
    }

    public void close() {
        try {
            b();
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    public DataSink open(c cVar) {
        b.b(cVar.e != -1);
        try {
            this.c = cVar;
            this.g = 0;
            a();
            return this;
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.f == this.b) {
                    b();
                    a();
                }
                int min = (int) Math.min((long) (i2 - i3), this.b - this.f);
                this.e.write(bArr, i + i3, min);
                i3 += min;
                this.f += (long) min;
                this.g += (long) min;
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }
}
