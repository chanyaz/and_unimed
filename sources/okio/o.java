package okio;

import java.util.Arrays;

final class o extends ByteString {
    final transient byte[][] f;
    final transient int[] g;

    o(d dVar, int i) {
        int i2 = 0;
        super(null);
        q.a(dVar.b, 0, (long) i);
        m mVar = dVar.a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (mVar.c == mVar.b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += mVar.c - mVar.b;
            i3++;
            mVar = mVar.f;
        }
        this.f = new byte[i3][];
        this.g = new int[(i3 * 2)];
        m mVar2 = dVar.a;
        i4 = 0;
        while (i2 < i) {
            this.f[i4] = mVar2.a;
            int i5 = (mVar2.c - mVar2.b) + i2;
            if (i5 > i) {
                i5 = i;
            }
            this.g[i4] = i5;
            this.g[this.f.length + i4] = mVar2.b;
            mVar2.d = true;
            i4++;
            mVar2 = mVar2.f;
            i2 = i5;
        }
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    private ByteString j() {
        return new ByteString(h());
    }

    private Object writeReplace() {
        return j();
    }

    public byte a(int i) {
        q.a((long) this.g[this.f.length - 1], (long) i, 1);
        int b = b(i);
        return this.f[b][(i - (b == 0 ? 0 : this.g[b - 1])) + this.g[this.f.length + b]];
    }

    public String a() {
        return j().a();
    }

    public ByteString a(int i, int i2) {
        return j().a(i, i2);
    }

    void a(d dVar) {
        int i = 0;
        int length = this.f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            m mVar = new m(this.f[i], i3, (i3 + i4) - i2);
            if (dVar.a == null) {
                mVar.g = mVar;
                mVar.f = mVar;
                dVar.a = mVar;
            } else {
                dVar.a.g.a(mVar);
            }
            i++;
            i2 = i4;
        }
        dVar.b = ((long) i2) + dVar.b;
    }

    public boolean a(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.g[b - 1];
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            if (!byteString.a(i2, this.f[b], (i - i4) + this.g[this.f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.g[b - 1];
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            if (!q.a(this.f[b], (i - i4) + this.g[this.f.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    public String b() {
        return j().b();
    }

    public ByteString c() {
        return j().c();
    }

    public ByteString d() {
        return j().d();
    }

    public String e() {
        return j().e();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof ByteString) && ((ByteString) obj).g() == g() && a(0, (ByteString) obj, 0, g());
        return z;
    }

    public ByteString f() {
        return j().f();
    }

    public int g() {
        return this.g[this.f.length - 1];
    }

    public byte[] h() {
        int i = 0;
        Object obj = new byte[this.g[this.f.length - 1]];
        int length = this.f.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            System.arraycopy(this.f[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    public int hashCode() {
        int i = this.d;
        if (i == 0) {
            i = 1;
            int length = this.f.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.f[i2];
                int i4 = this.g[length + i2];
                int i5 = this.g[i2];
                i3 = (i5 - i3) + i4;
                int i6 = i4;
                i4 = i;
                for (i = i6; i < i3; i++) {
                    i4 = (i4 * 31) + bArr[i];
                }
                i2++;
                i3 = i5;
                i = i4;
            }
            this.d = i;
        }
        return i;
    }

    byte[] i() {
        return h();
    }

    public String toString() {
        return j().toString();
    }
}
