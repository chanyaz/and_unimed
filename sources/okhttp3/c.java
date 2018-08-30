package okhttp3;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.http.d;

public final class c {
    public static final c a = new d().a().c();
    public static final c b = new d().b().a(MoPubClientPositioning.NO_REPEAT, TimeUnit.SECONDS).c();
    @Nullable
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    c(d dVar) {
        this.d = dVar.a;
        this.e = dVar.b;
        this.f = dVar.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = dVar.d;
        this.l = dVar.e;
        this.m = dVar.f;
        this.n = dVar.g;
        this.o = dVar.h;
    }

    private c(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.d = z;
        this.e = z2;
        this.f = i;
        this.g = i2;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i3;
        this.l = i4;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.c = str;
    }

    public static c a(q qVar) {
        boolean z;
        boolean z2 = false;
        boolean z3 = false;
        int i = -1;
        int i2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        Object obj = 1;
        int a = qVar.a();
        int i5 = 0;
        String str = null;
        while (true) {
            z = z2;
            if (i5 >= a) {
                break;
            }
            String a2 = qVar.a(i5);
            String b = qVar.b(i5);
            if (a2.equalsIgnoreCase("Cache-Control")) {
                if (str != null) {
                    obj = null;
                } else {
                    str = b;
                }
            } else if (a2.equalsIgnoreCase("Pragma")) {
                obj = null;
            } else {
                z2 = z;
                i5++;
            }
            z2 = z;
            int i6 = 0;
            while (i6 < b.length()) {
                String str2;
                int a3 = d.a(b, i6, "=,;");
                String trim = b.substring(i6, a3).trim();
                if (a3 == b.length() || b.charAt(a3) == ',' || b.charAt(a3) == ';') {
                    i6 = a3 + 1;
                    str2 = null;
                } else {
                    i6 = d.a(b, a3 + 1);
                    String trim2;
                    if (i6 >= b.length() || b.charAt(i6) != '\"') {
                        a3 = d.a(b, i6, ",;");
                        trim2 = b.substring(i6, a3).trim();
                        i6 = a3;
                        str2 = trim2;
                    } else {
                        i6++;
                        a3 = d.a(b, i6, "\"");
                        trim2 = b.substring(i6, a3);
                        i6 = a3 + 1;
                        str2 = trim2;
                    }
                }
                if ("no-cache".equalsIgnoreCase(trim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(trim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(trim)) {
                    i = d.b(str2, -1);
                } else if ("s-maxage".equalsIgnoreCase(trim)) {
                    i2 = d.b(str2, -1);
                } else if ("private".equalsIgnoreCase(trim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(trim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(trim)) {
                    i3 = d.b(str2, MoPubClientPositioning.NO_REPEAT);
                } else if ("min-fresh".equalsIgnoreCase(trim)) {
                    i4 = d.b(str2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(trim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(trim)) {
                    z9 = true;
                }
            }
            i5++;
        }
        return new c(z, z3, i, i2, z4, z5, z6, i3, i4, z7, z8, z9, obj == null ? null : str);
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.d) {
            stringBuilder.append("no-cache, ");
        }
        if (this.e) {
            stringBuilder.append("no-store, ");
        }
        if (this.f != -1) {
            stringBuilder.append("max-age=").append(this.f).append(", ");
        }
        if (this.g != -1) {
            stringBuilder.append("s-maxage=").append(this.g).append(", ");
        }
        if (this.h) {
            stringBuilder.append("private, ");
        }
        if (this.i) {
            stringBuilder.append("public, ");
        }
        if (this.j) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.k != -1) {
            stringBuilder.append("max-stale=").append(this.k).append(", ");
        }
        if (this.l != -1) {
            stringBuilder.append("min-fresh=").append(this.l).append(", ");
        }
        if (this.m) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.n) {
            stringBuilder.append("no-transform, ");
        }
        if (this.o) {
            stringBuilder.append("immutable, ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    public String toString() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        str = j();
        this.c = str;
        return str;
    }
}
