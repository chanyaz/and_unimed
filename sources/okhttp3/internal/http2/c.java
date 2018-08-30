package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.i;

final class c {
    a[] a;
    int b;
    int c;
    int d;
    private final List<a> e;
    private final BufferedSource f;
    private final int g;
    private int h;

    c(int i, int i2, Source source) {
        this.e = new ArrayList();
        this.a = new a[8];
        this.b = this.a.length - 1;
        this.c = 0;
        this.d = 0;
        this.g = i;
        this.h = i2;
        this.f = i.a(source);
    }

    c(int i, Source source) {
        this(i, i, source);
    }

    private int a(int i) {
        int i2 = 0;
        if (i > 0) {
            int length = this.a.length;
            while (true) {
                length--;
                if (length < this.b || i <= 0) {
                    System.arraycopy(this.a, this.b + 1, this.a, (this.b + 1) + i2, this.c);
                    this.b += i2;
                } else {
                    i -= this.a[length].i;
                    this.d -= this.a[length].i;
                    this.c--;
                    i2++;
                }
            }
            System.arraycopy(this.a, this.b + 1, this.a, (this.b + 1) + i2, this.c);
            this.b += i2;
        }
        return i2;
    }

    private void a(int i, a aVar) {
        this.e.add(aVar);
        int i2 = aVar.i;
        if (i != -1) {
            i2 -= this.a[c(i)].i;
        }
        if (i2 > this.h) {
            e();
            return;
        }
        int a = a((this.d + i2) - this.h);
        if (i == -1) {
            if (this.c + 1 > this.a.length) {
                Object obj = new a[(this.a.length * 2)];
                System.arraycopy(this.a, 0, obj, this.a.length, this.a.length);
                this.b = this.a.length - 1;
                this.a = obj;
            }
            a = this.b;
            this.b = a - 1;
            this.a[a] = aVar;
            this.c++;
        } else {
            this.a[(a + c(i)) + i] = aVar;
        }
        this.d = i2 + this.d;
    }

    private void b(int i) {
        if (g(i)) {
            this.e.add(b.a[i]);
            return;
        }
        int c = c(i - b.a.length);
        if (c < 0 || c > this.a.length - 1) {
            throw new IOException("Header index too large " + (i + 1));
        }
        this.e.add(this.a[c]);
    }

    private int c(int i) {
        return (this.b + 1) + i;
    }

    private void d() {
        if (this.h >= this.d) {
            return;
        }
        if (this.h == 0) {
            e();
        } else {
            a(this.d - this.h);
        }
    }

    private void d(int i) {
        this.e.add(new a(f(i), c()));
    }

    private void e() {
        Arrays.fill(this.a, null);
        this.b = this.a.length - 1;
        this.c = 0;
        this.d = 0;
    }

    private void e(int i) {
        a(-1, new a(f(i), c()));
    }

    private ByteString f(int i) {
        return g(i) ? b.a[i].g : this.a[c(i - b.a.length)].g;
    }

    private void f() {
        this.e.add(new a(b.a(c()), c()));
    }

    private void g() {
        a(-1, new a(b.a(c()), c()));
    }

    private boolean g(int i) {
        return i >= 0 && i <= b.a.length - 1;
    }

    private int h() {
        return this.f.readByte() & 255;
    }

    int a(int i, int i2) {
        int i3 = i & i2;
        if (i3 < i2) {
            return i3;
        }
        i3 = 0;
        while (true) {
            int h = h();
            if ((h & 128) == 0) {
                return (h << i3) + i2;
            }
            i2 += (h & 127) << i3;
            i3 += 7;
        }
    }

    void a() {
        while (!this.f.exhausted()) {
            int readByte = this.f.readByte() & 255;
            if (readByte == 128) {
                throw new IOException("index == 0");
            } else if ((readByte & 128) == 128) {
                b(a(readByte, 127) - 1);
            } else if (readByte == 64) {
                g();
            } else if ((readByte & 64) == 64) {
                e(a(readByte, 63) - 1);
            } else if ((readByte & 32) == 32) {
                this.h = a(readByte, 31);
                if (this.h < 0 || this.h > this.g) {
                    throw new IOException("Invalid dynamic table size update " + this.h);
                }
                d();
            } else if (readByte == 16 || readByte == 0) {
                f();
            } else {
                d(a(readByte, 15) - 1);
            }
        }
    }

    public List<a> b() {
        List arrayList = new ArrayList(this.e);
        this.e.clear();
        return arrayList;
    }

    ByteString c() {
        int h = h();
        Object obj = (h & 128) == 128 ? 1 : null;
        h = a(h, 127);
        return obj != null ? ByteString.a(r.a().a(this.f.readByteArray((long) h))) : this.f.readByteString((long) h);
    }
}
