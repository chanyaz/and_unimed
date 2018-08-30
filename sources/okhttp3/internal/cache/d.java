package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;

public final class d implements Closeable, Flushable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean j = (!d.class.desiredAssertionStatus());
    final FileSystem b;
    final int c;
    BufferedSink d;
    final LinkedHashMap<String, f> e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    private long k;
    private long l;
    private long m;
    private final Executor n;
    private final Runnable o;

    private synchronized void d() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    synchronized void a(e eVar, boolean z) {
        int i = 0;
        synchronized (this) {
            f fVar = eVar.a;
            if (fVar.f != eVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!fVar.e) {
                    int i2 = 0;
                    while (i2 < this.c) {
                        if (!eVar.b[i2]) {
                            eVar.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!this.b.exists(fVar.d[i2])) {
                            eVar.b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.c) {
                File file = fVar.d[i];
                if (!z) {
                    this.b.delete(file);
                } else if (this.b.exists(file)) {
                    File file2 = fVar.c[i];
                    this.b.rename(file, file2);
                    long j = fVar.b[i];
                    long size = this.b.size(file2);
                    fVar.b[i] = size;
                    this.l = (this.l - j) + size;
                }
                i++;
            }
            this.f++;
            fVar.f = null;
            if ((fVar.e | z) != 0) {
                fVar.e = true;
                this.d.writeUtf8("CLEAN").writeByte(32);
                this.d.writeUtf8(fVar.a);
                fVar.a(this.d);
                this.d.writeByte(10);
                if (z) {
                    long j2 = this.m;
                    this.m = 1 + j2;
                    fVar.g = j2;
                }
            } else {
                this.e.remove(fVar.a);
                this.d.writeUtf8("REMOVE").writeByte(32);
                this.d.writeUtf8(fVar.a);
                this.d.writeByte(10);
            }
            this.d.flush();
            if (this.l > this.k || a()) {
                this.n.execute(this.o);
            }
        }
    }

    boolean a() {
        return this.f >= 2000 && this.f >= this.e.size();
    }

    boolean a(f fVar) {
        if (fVar.f != null) {
            fVar.f.a();
        }
        for (int i = 0; i < this.c; i++) {
            this.b.delete(fVar.c[i]);
            this.l -= fVar.b[i];
            fVar.b[i] = 0;
        }
        this.f++;
        this.d.writeUtf8("REMOVE").writeByte(32).writeUtf8(fVar.a).writeByte(10);
        this.e.remove(fVar.a);
        if (a()) {
            this.n.execute(this.o);
        }
        return true;
    }

    public synchronized boolean b() {
        return this.h;
    }

    void c() {
        while (this.l > this.k) {
            a((f) this.e.values().iterator().next());
        }
        this.i = false;
    }

    public synchronized void close() {
        if (!this.g || this.h) {
            this.h = true;
        } else {
            for (f fVar : (f[]) this.e.values().toArray(new f[this.e.size()])) {
                if (fVar.f != null) {
                    fVar.f.b();
                }
            }
            c();
            this.d.close();
            this.d = null;
            this.h = true;
        }
    }

    public synchronized void flush() {
        if (this.g) {
            d();
            c();
            this.d.flush();
        }
    }
}
