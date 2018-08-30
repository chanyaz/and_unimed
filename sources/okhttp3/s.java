package okhttp3;

import com.mopub.common.Constants;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.d;

public final class s {
    private static final char[] d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;
    final String b;
    final int c;
    private final String e;
    private final String f;
    private final List<String> g;
    @Nullable
    private final List<String> h;
    @Nullable
    private final String i;
    private final String j;

    s(t tVar) {
        String str = null;
        this.a = tVar.a;
        this.e = a(tVar.b, false);
        this.f = a(tVar.c, false);
        this.b = tVar.d;
        this.c = tVar.a();
        this.g = a(tVar.f, false);
        this.h = tVar.g != null ? a(tVar.g, true) : null;
        if (tVar.h != null) {
            str = a(tVar.h, false);
        }
        this.i = str;
        this.j = tVar.toString();
    }

    static int a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    public static int a(String str) {
        return str.equals(Constants.HTTP) ? 80 : str.equals(Constants.HTTPS) ? 443 : -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !a(str, i3, i2)))) || (codePointAt == 43 && z3)))) {
                d dVar = new d();
                dVar.writeUtf8(str, i, i3);
                a(dVar, str, i3, i2, str2, z, z2, z3, z4);
                return dVar.readUtf8();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                d dVar = new d();
                dVar.writeUtf8(str, i, i3);
                a(dVar, str, i3, i2, z);
                return dVar.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    static void a(d dVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        d dVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!(z && (codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13))) {
                if (codePointAt == 43 && z3) {
                    dVar.writeUtf8(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i, i2)))))) {
                    if (dVar2 == null) {
                        dVar2 = new d();
                    }
                    dVar2.writeUtf8CodePoint(codePointAt);
                    while (!dVar2.exhausted()) {
                        int readByte = dVar2.readByte() & 255;
                        dVar.writeByte(37);
                        dVar.writeByte(d[(readByte >> 4) & 15]);
                        dVar.writeByte(d[readByte & 15]);
                    }
                } else {
                    dVar.writeUtf8CodePoint(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static void a(d dVar, String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt != 37 || i3 + 2 >= i2) {
                if (codePointAt == 43 && z) {
                    dVar.writeByte(32);
                }
                dVar.writeUtf8CodePoint(codePointAt);
            } else {
                int a = a(str.charAt(i3 + 1));
                int a2 = a(str.charAt(i3 + 2));
                if (!(a == -1 || a2 == -1)) {
                    dVar.writeByte((a << 4) + a2);
                    i3 += 2;
                }
                dVar.writeUtf8CodePoint(codePointAt);
            }
            i3 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && a(str.charAt(i + 1)) != -1 && a(str.charAt(i + 2)) != -1;
    }

    static List<String> b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    @Nullable
    public static s e(String str) {
        t tVar = new t();
        return tVar.a(null, str) == u.SUCCESS ? tVar.c() : null;
    }

    public URI a() {
        String tVar = o().b().toString();
        try {
            return new URI(tVar);
        } catch (Throwable e) {
            try {
                return URI.create(tVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public String b() {
        return this.a;
    }

    @Nullable
    public s c(String str) {
        t d = d(str);
        return d != null ? d.c() : null;
    }

    public boolean c() {
        return this.a.equals(Constants.HTTPS);
    }

    public String d() {
        if (this.e.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        return this.j.substring(length, c.a(this.j, length, this.j.length(), ":@"));
    }

    @Nullable
    public t d(String str) {
        t tVar = new t();
        return tVar.a(this, str) == u.SUCCESS ? tVar : null;
    }

    public String e() {
        if (this.f.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.a.length() + 3) + 1, this.j.indexOf(64));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof s) && ((s) obj).j.equals(this.j);
    }

    public String f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public String h() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        return this.j.substring(indexOf, c.a(this.j, indexOf, this.j.length(), "?#"));
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public List<String> i() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        int a = c.a(this.j, indexOf, this.j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            indexOf = c.a(this.j, i, a, '/');
            arrayList.add(this.j.substring(i, indexOf));
        }
        return arrayList;
    }

    public List<String> j() {
        return this.g;
    }

    @Nullable
    public String k() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        return this.j.substring(indexOf, c.a(this.j, indexOf + 1, this.j.length(), '#'));
    }

    @Nullable
    public String l() {
        if (this.h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder, this.h);
        return stringBuilder.toString();
    }

    @Nullable
    public String m() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public String n() {
        return d("/...").b("").c("").c().toString();
    }

    public t o() {
        t tVar = new t();
        tVar.a = this.a;
        tVar.b = d();
        tVar.c = e();
        tVar.d = this.b;
        tVar.e = this.c != a(this.a) ? this.c : -1;
        tVar.f.clear();
        tVar.f.addAll(i());
        tVar.e(k());
        tVar.h = m();
        return tVar;
    }

    public String toString() {
        return this.j;
    }
}
