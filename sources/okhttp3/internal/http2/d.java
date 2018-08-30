package okhttp3.internal.http2;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.List;
import okhttp3.internal.c;
import okio.ByteString;

final class d {
    int a;
    int b;
    a[] c;
    int d;
    int e;
    int f;
    private final okio.d g;
    private final boolean h;
    private int i;
    private boolean j;

    d(int i, boolean z, okio.d dVar) {
        this.i = MoPubClientPositioning.NO_REPEAT;
        this.c = new a[8];
        this.d = this.c.length - 1;
        this.e = 0;
        this.f = 0;
        this.a = i;
        this.b = i;
        this.h = z;
        this.g = dVar;
    }

    d(okio.d dVar) {
        this(4096, true, dVar);
    }

    private void a() {
        Arrays.fill(this.c, null);
        this.d = this.c.length - 1;
        this.e = 0;
        this.f = 0;
    }

    private void a(a aVar) {
        int i = aVar.i;
        if (i > this.b) {
            a();
            return;
        }
        b((this.f + i) - this.b);
        if (this.e + 1 > this.c.length) {
            Object obj = new a[(this.c.length * 2)];
            System.arraycopy(this.c, 0, obj, this.c.length, this.c.length);
            this.d = this.c.length - 1;
            this.c = obj;
        }
        int i2 = this.d;
        this.d = i2 - 1;
        this.c[i2] = aVar;
        this.e++;
        this.f = i + this.f;
    }

    private int b(int i) {
        int i2 = 0;
        if (i > 0) {
            int length = this.c.length;
            while (true) {
                length--;
                if (length < this.d || i <= 0) {
                    System.arraycopy(this.c, this.d + 1, this.c, (this.d + 1) + i2, this.e);
                    Arrays.fill(this.c, this.d + 1, (this.d + 1) + i2, null);
                    this.d += i2;
                } else {
                    i -= this.c[length].i;
                    this.f -= this.c[length].i;
                    this.e--;
                    i2++;
                }
            }
            System.arraycopy(this.c, this.d + 1, this.c, (this.d + 1) + i2, this.e);
            Arrays.fill(this.c, this.d + 1, (this.d + 1) + i2, null);
            this.d += i2;
        }
        return i2;
    }

    private void b() {
        if (this.b >= this.f) {
            return;
        }
        if (this.b == 0) {
            a();
        } else {
            b(this.f - this.b);
        }
    }

    void a(int i) {
        this.a = i;
        int min = Math.min(i, 16384);
        if (this.b != min) {
            if (min < this.b) {
                this.i = Math.min(this.i, min);
            }
            this.j = true;
            this.b = min;
            b();
        }
    }

    void a(int i, int i2, int i3) {
        if (i < i2) {
            this.g.writeByte(i3 | i);
            return;
        }
        this.g.writeByte(i3 | i2);
        int i4 = i - i2;
        while (i4 >= 128) {
            this.g.writeByte((i4 & 127) | 128);
            i4 >>>= 7;
        }
        this.g.writeByte(i4);
    }

    void a(List<a> list) {
        if (this.j) {
            if (this.i < this.b) {
                a(this.i, 31, 32);
            }
            this.j = false;
            this.i = MoPubClientPositioning.NO_REPEAT;
            a(this.b, 31, 32);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int intValue;
            int i2;
            a aVar = (a) list.get(i);
            ByteString f = aVar.g.f();
            ByteString byteString = aVar.h;
            Integer num = (Integer) b.b.get(f);
            if (num != null) {
                intValue = num.intValue() + 1;
                if (intValue > 1 && intValue < 8) {
                    if (c.a(b.a[intValue - 1].h, (Object) byteString)) {
                        i2 = intValue;
                    } else if (c.a(b.a[intValue].h, (Object) byteString)) {
                        i2 = intValue + 1;
                    }
                }
                i2 = -1;
            } else {
                intValue = -1;
                i2 = -1;
            }
            if (i2 == -1) {
                int length = this.c.length;
                for (int i3 = this.d + 1; i3 < length; i3++) {
                    if (c.a(this.c[i3].g, (Object) f)) {
                        if (c.a(this.c[i3].h, (Object) byteString)) {
                            i2 = (i3 - this.d) + b.a.length;
                            break;
                        } else if (intValue == -1) {
                            intValue = (i3 - this.d) + b.a.length;
                        }
                    }
                }
            }
            if (i2 != -1) {
                a(i2, 127, 128);
            } else if (intValue == -1) {
                this.g.writeByte(64);
                a(f);
                a(byteString);
                a(aVar);
            } else if (!f.a(a.a) || a.f.equals(f)) {
                a(intValue, 63, 64);
                a(byteString);
                a(aVar);
            } else {
                a(intValue, 15, 0);
                a(byteString);
            }
        }
    }

    void a(ByteString byteString) {
        if (!this.h || r.a().a(byteString) >= byteString.g()) {
            a(byteString.g(), 127, 0);
            this.g.write(byteString);
            return;
        }
        Object dVar = new okio.d();
        r.a().a(byteString, dVar);
        ByteString readByteString = dVar.readByteString();
        a(readByteString.g(), 127, 128);
        this.g.write(readByteString);
    }
}
