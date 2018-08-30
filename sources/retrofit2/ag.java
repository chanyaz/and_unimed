package retrofit2;

import javax.annotation.Nullable;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.af;
import okhttp3.o;
import okhttp3.q;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.x;
import okhttp3.y;
import okio.d;

final class ag {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String b;
    private final s c;
    @Nullable
    private String d;
    @Nullable
    private t e;
    private final ae f = new ae();
    @Nullable
    private v g;
    private final boolean h;
    @Nullable
    private x i;
    @Nullable
    private o j;
    @Nullable
    private af k;

    ag(String str, s sVar, @Nullable String str2, @Nullable q qVar, @Nullable v vVar, boolean z, boolean z2, boolean z3) {
        this.b = str;
        this.c = sVar;
        this.d = str2;
        this.g = vVar;
        this.h = z;
        if (qVar != null) {
            this.f.a(qVar);
        }
        if (z2) {
            this.j = new o();
        } else if (z3) {
            this.i = new x();
            this.i.a(w.e);
        }
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                d dVar = new d();
                dVar.writeUtf8(str, 0, i);
                a(dVar, str, i, length, z);
                return dVar.readUtf8();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void a(d dVar, String str, int i, int i2, boolean z) {
        d dVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!(z && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13))) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (dVar2 == null) {
                        dVar2 = new d();
                    }
                    dVar2.writeUtf8CodePoint(codePointAt);
                    while (!dVar2.exhausted()) {
                        int readByte = dVar2.readByte() & 255;
                        dVar.writeByte(37);
                        dVar.writeByte(a[(readByte >> 4) & 15]);
                        dVar.writeByte(a[readByte & 15]);
                    }
                } else {
                    dVar.writeUtf8CodePoint(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    ad a() {
        s c;
        t tVar = this.e;
        if (tVar != null) {
            c = tVar.c();
        } else {
            c = this.c.c(this.d);
            if (c == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.c + ", Relative: " + this.d);
            }
        }
        af afVar = this.k;
        if (afVar == null) {
            if (this.j != null) {
                afVar = this.j.a();
            } else if (this.i != null) {
                afVar = this.i.a();
            } else if (this.h) {
                afVar = af.a(null, new byte[0]);
            }
        }
        v vVar = this.g;
        if (vVar != null) {
            if (afVar != null) {
                afVar = new ah(afVar, vVar);
            } else {
                this.f.b("Content-Type", vVar.toString());
            }
        }
        return this.f.a(c).a(this.b, afVar).a();
    }

    void a(Object obj) {
        this.d = obj.toString();
    }

    void a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            v a = v.a(str2);
            if (a == null) {
                throw new IllegalArgumentException("Malformed content type: " + str2);
            }
            this.g = a;
            return;
        }
        this.f.b(str, str2);
    }

    void a(String str, String str2, boolean z) {
        if (this.d == null) {
            throw new AssertionError();
        }
        this.d = this.d.replace("{" + str + "}", a(str2, z));
    }

    void a(af afVar) {
        this.k = afVar;
    }

    void a(q qVar, af afVar) {
        this.i.a(qVar, afVar);
    }

    void a(y yVar) {
        this.i.a(yVar);
    }

    void b(String str, @Nullable String str2, boolean z) {
        if (this.d != null) {
            this.e = this.c.d(this.d);
            if (this.e == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.c + ", Relative: " + this.d);
            }
            this.d = null;
        }
        if (z) {
            this.e.b(str, str2);
        } else {
            this.e.a(str, str2);
        }
    }

    void c(String str, String str2, boolean z) {
        if (z) {
            this.j.b(str, str2);
        } else {
            this.j.a(str, str2);
        }
    }
}
