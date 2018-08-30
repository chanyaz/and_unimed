package okhttp3;

import com.mopub.common.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.d;

public final class t {
    @Nullable
    String a;
    String b = "";
    String c = "";
    @Nullable
    String d;
    int e = -1;
    final List<String> f = new ArrayList();
    @Nullable
    List<String> g;
    @Nullable
    String h;

    public t() {
        this.f.add("");
    }

    private static String a(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i4 < bArr.length) {
            int i5 = i4;
            while (i5 < 16 && bArr[i5] == (byte) 0 && bArr[i5 + 1] == (byte) 0) {
                i5 += 2;
            }
            int i6 = i5 - i4;
            if (i6 > i2 && i6 >= 4) {
                i2 = i6;
                i3 = i4;
            }
            i4 = i5 + 2;
        }
        d dVar = new d();
        while (i < bArr.length) {
            if (i == i3) {
                dVar.writeByte(58);
                i += i2;
                if (i == 16) {
                    dVar.writeByte(58);
                }
            } else {
                if (i > 0) {
                    dVar.writeByte(58);
                }
                dVar.writeHexadecimalUnsignedLong((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                i += 2;
            }
        }
        return dVar.readUtf8();
    }

    private void a(String str, int i, int i2) {
        if (i != i2) {
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                this.f.set(this.f.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int a = c.a(str, i3, i2, "/\\");
                boolean z = a < i2;
                a(str, i3, a, z, true);
                if (z) {
                    a++;
                }
                i3 = a;
            }
        }
    }

    private void a(String str, int i, int i2, boolean z, boolean z2) {
        String a = s.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
        if (!f(a)) {
            if (g(a)) {
                d();
                return;
            }
            if (((String) this.f.get(this.f.size() - 1)).isEmpty()) {
                this.f.set(this.f.size() - 1, a);
            } else {
                this.f.add(a);
            }
            if (z) {
                this.f.add("");
            }
        }
    }

    private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i;
        int i5 = i3;
        while (i4 < i2) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i3) {
                if (str.charAt(i4) != '.') {
                    return false;
                }
                i4++;
            }
            int i6 = 0;
            int i7 = i4;
            while (i7 < i2) {
                char charAt = str.charAt(i7);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if (i6 == 0 && i4 != i7) {
                    return false;
                } else {
                    i6 = ((i6 * 10) + charAt) - 48;
                    if (i6 > 255) {
                        return false;
                    }
                    i7++;
                }
            }
            if (i7 - i4 == 0) {
                return false;
            }
            i4 = i5 + 1;
            bArr[i5] = (byte) i6;
            i5 = i4;
            i4 = i7;
        }
        return i5 == i3 + 4;
    }

    private static int b(String str, int i, int i2) {
        if (i2 - i < 2) {
            return -1;
        }
        char charAt = str.charAt(i);
        if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
            return -1;
        }
        int i3 = i + 1;
        while (i3 < i2) {
            char charAt2 = str.charAt(i3);
            if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && ((charAt2 < '0' || charAt2 > '9') && charAt2 != '+' && charAt2 != '-' && charAt2 != '.'))) {
                return charAt2 == ':' ? i3 : -1;
            } else {
                i3++;
            }
        }
        return -1;
    }

    private static int c(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\\' && charAt != '/') {
                break;
            }
            i3++;
            i++;
        }
        return i3;
    }

    /* JADX WARNING: Missing block: B:6:0x000f, code:
            if (r0 >= r5) goto L_0x000a;
     */
    private static int d(java.lang.String r3, int r4, int r5) {
        /*
        r0 = r4;
    L_0x0001:
        if (r0 >= r5) goto L_0x001a;
    L_0x0003:
        r1 = r3.charAt(r0);
        switch(r1) {
            case 58: goto L_0x001b;
            case 91: goto L_0x000d;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000d:
        r0 = r0 + 1;
        if (r0 >= r5) goto L_0x000a;
    L_0x0011:
        r1 = r3.charAt(r0);
        r2 = 93;
        if (r1 != r2) goto L_0x000d;
    L_0x0019:
        goto L_0x000a;
    L_0x001a:
        r0 = r5;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.t.d(java.lang.String, int, int):int");
    }

    private void d() {
        if (!((String) this.f.remove(this.f.size() - 1)).isEmpty() || this.f.isEmpty()) {
            this.f.add("");
        } else {
            this.f.set(this.f.size() - 1, "");
        }
    }

    private static String e(String str, int i, int i2) {
        String a = s.a(str, i, i2, false);
        if (!a.contains(":")) {
            return c.a(a);
        }
        InetAddress f = (a.startsWith("[") && a.endsWith("]")) ? f(a, 1, a.length() - 1) : f(a, 0, a.length());
        if (f == null) {
            return null;
        }
        byte[] address = f.getAddress();
        if (address.length == 16) {
            return a(address);
        }
        throw new AssertionError();
    }

    @Nullable
    private static InetAddress f(String str, int i, int i2) {
        byte[] bArr = new byte[16];
        int i3 = i;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        while (i3 < i2) {
            if (i6 == bArr.length) {
                return null;
            }
            int a;
            if (i3 + 2 > i2 || !str.regionMatches(i3, "::", 0, 2)) {
                if (i6 != 0) {
                    if (str.regionMatches(i3, ":", 0, 1)) {
                        i3++;
                    } else if (!str.regionMatches(i3, ".", 0, 1)) {
                        return null;
                    } else {
                        if (!a(str, i4, i2, bArr, i6 - 2)) {
                            return null;
                        }
                        i6 += 2;
                    }
                }
            } else if (i5 != -1) {
                return null;
            } else {
                i3 += 2;
                i5 = i6 + 2;
                if (i3 == i2) {
                    i6 = i5;
                    break;
                }
                i6 = i5;
            }
            i4 = 0;
            int i7 = i3;
            while (i7 < i2) {
                a = s.a(str.charAt(i7));
                if (a == -1) {
                    break;
                }
                i4 = (i4 << 4) + a;
                i7++;
            }
            a = i7 - i3;
            if (a == 0 || a > 4) {
                return null;
            }
            a = i6 + 1;
            bArr[i6] = (byte) ((i4 >>> 8) & 255);
            i6 = a + 1;
            bArr[a] = (byte) (i4 & 255);
            i4 = i3;
            i3 = i7;
        }
        if (i6 != bArr.length) {
            if (i5 == -1) {
                return null;
            }
            System.arraycopy(bArr, i5, bArr, bArr.length - (i6 - i5), i6 - i5);
            Arrays.fill(bArr, i5, (bArr.length - i6) + i5, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    private boolean f(String str) {
        return str.equals(".") || str.equalsIgnoreCase("%2e");
    }

    private static int g(String str, int i, int i2) {
        try {
            int parseInt = Integer.parseInt(s.a(str, i, i2, "", false, false, false, true));
            return (parseInt <= 0 || parseInt > 65535) ? -1 : parseInt;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean g(String str) {
        return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
    }

    int a() {
        return this.e != -1 ? this.e : s.a(this.a);
    }

    public t a(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("unexpected port: " + i);
        }
        this.e = i;
        return this;
    }

    public t a(String str) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (str.equalsIgnoreCase(Constants.HTTP)) {
            this.a = Constants.HTTP;
        } else if (str.equalsIgnoreCase(Constants.HTTPS)) {
            this.a = Constants.HTTPS;
        } else {
            throw new IllegalArgumentException("unexpected scheme: " + str);
        }
        return this;
    }

    public t a(String str, @Nullable String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        Object a;
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(s.a(str, " \"'<>#&=", false, false, true, true));
        List list = this.g;
        if (str2 != null) {
            a = s.a(str2, " \"'<>#&=", false, false, true, true);
        } else {
            a = null;
        }
        list.add(a);
        return this;
    }

    u a(@Nullable s sVar, String str) {
        int d;
        int a = c.a(str, 0, str.length());
        int b = c.b(str, a, str.length());
        if (b(str, a, b) != -1) {
            if (str.regionMatches(true, a, "https:", 0, 6)) {
                this.a = Constants.HTTPS;
                a += "https:".length();
            } else {
                if (!str.regionMatches(true, a, "http:", 0, 5)) {
                    return u.UNSUPPORTED_SCHEME;
                }
                this.a = Constants.HTTP;
                a += "http:".length();
            }
        } else if (sVar == null) {
            return u.MISSING_SCHEME;
        } else {
            this.a = sVar.a;
        }
        Object obj = null;
        Object obj2 = null;
        int c = c(str, a, b);
        if (c >= 2 || sVar == null || !sVar.a.equals(this.a)) {
            a += c;
            while (true) {
                Object obj3 = obj2;
                Object obj4 = obj;
                int i = a;
                int a2 = c.a(str, i, b, "@/\\?#");
                switch (a2 != b ? str.charAt(a2) : 65535) {
                    case 65535:
                    case '#':
                    case '/':
                    case '?':
                    case '\\':
                        d = d(str, i, a2);
                        if (d + 1 < a2) {
                            this.d = e(str, i, d);
                            this.e = g(str, d + 1, a2);
                            if (this.e == -1) {
                                return u.INVALID_PORT;
                            }
                        }
                        this.d = e(str, i, d);
                        this.e = s.a(this.a);
                        if (this.d != null) {
                            a = a2;
                            break;
                        }
                        return u.INVALID_HOST;
                    case '@':
                        if (obj3 == null) {
                            a = c.a(str, i, a2, ':');
                            String a3 = s.a(str, i, a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (obj4 != null) {
                                a3 = this.b + "%40" + a3;
                            }
                            this.b = a3;
                            if (a != a2) {
                                obj3 = 1;
                                this.c = s.a(str, a + 1, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            obj4 = 1;
                        } else {
                            this.c += "%40" + s.a(str, i, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        }
                        a = a2 + 1;
                        obj2 = obj3;
                        continue;
                    default:
                        obj2 = obj3;
                        a = i;
                        continue;
                }
                obj = obj4;
            }
        } else {
            this.b = sVar.d();
            this.c = sVar.e();
            this.d = sVar.b;
            this.e = sVar.c;
            this.f.clear();
            this.f.addAll(sVar.i());
            if (a == b || str.charAt(a) == '#') {
                e(sVar.k());
            }
        }
        d = c.a(str, a, b, "?#");
        a(str, a, d);
        if (d >= b || str.charAt(d) != '?') {
            a = d;
        } else {
            a = c.a(str, d, b, '#');
            this.g = s.b(s.a(str, d + 1, a, " \"'<>#", true, false, true, true));
        }
        if (a < b && str.charAt(a) == '#') {
            this.h = s.a(str, a + 1, b, "", true, false, false, false);
        }
        return u.SUCCESS;
    }

    t b() {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.set(i, s.a((String) this.f.get(i), "[]", true, true, false, true));
        }
        if (this.g != null) {
            int size2 = this.g.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str = (String) this.g.get(i2);
                if (str != null) {
                    this.g.set(i2, s.a(str, "\\^`{|}", true, true, true, true));
                }
            }
        }
        if (this.h != null) {
            this.h = s.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
        }
        return this;
    }

    public t b(String str) {
        if (str == null) {
            throw new NullPointerException("username == null");
        }
        this.b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return this;
    }

    public t b(String str, @Nullable String str2) {
        if (str == null) {
            throw new NullPointerException("encodedName == null");
        }
        Object a;
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(s.a(str, " \"'<>#&=", true, false, true, true));
        List list = this.g;
        if (str2 != null) {
            a = s.a(str2, " \"'<>#&=", true, false, true, true);
        } else {
            a = null;
        }
        list.add(a);
        return this;
    }

    public s c() {
        if (this.a == null) {
            throw new IllegalStateException("scheme == null");
        } else if (this.d != null) {
            return new s(this);
        } else {
            throw new IllegalStateException("host == null");
        }
    }

    public t c(String str) {
        if (str == null) {
            throw new NullPointerException("password == null");
        }
        this.c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return this;
    }

    public t d(String str) {
        if (str == null) {
            throw new NullPointerException("host == null");
        }
        String e = e(str, 0, str.length());
        if (e == null) {
            throw new IllegalArgumentException("unexpected host: " + str);
        }
        this.d = e;
        return this;
    }

    public t e(@Nullable String str) {
        List b;
        if (str != null) {
            b = s.b(s.a(str, " \"'<>#", true, false, true, true));
        } else {
            b = null;
        }
        this.g = b;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("://");
        if (!(this.b.isEmpty() && this.c.isEmpty())) {
            stringBuilder.append(this.b);
            if (!this.c.isEmpty()) {
                stringBuilder.append(':');
                stringBuilder.append(this.c);
            }
            stringBuilder.append('@');
        }
        if (this.d.indexOf(58) != -1) {
            stringBuilder.append('[');
            stringBuilder.append(this.d);
            stringBuilder.append(']');
        } else {
            stringBuilder.append(this.d);
        }
        int a = a();
        if (a != s.a(this.a)) {
            stringBuilder.append(':');
            stringBuilder.append(a);
        }
        s.a(stringBuilder, this.f);
        if (this.g != null) {
            stringBuilder.append('?');
            s.b(stringBuilder, this.g);
        }
        if (this.h != null) {
            stringBuilder.append('#');
            stringBuilder.append(this.h);
        }
        return stringBuilder.toString();
    }
}
