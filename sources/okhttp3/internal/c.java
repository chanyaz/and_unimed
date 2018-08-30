package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.af;
import okhttp3.ai;
import okhttp3.s;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.d;

public final class c {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];
    public static final ai c = ai.a(null, a);
    public static final af d = af.a(null, a);
    public static final Charset e = Charset.forName("UTF-8");
    public static final TimeZone f = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> g = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final ByteString h = ByteString.b("efbbbf");
    private static final ByteString i = ByteString.b("feff");
    private static final ByteString j = ByteString.b("fffe");
    private static final ByteString k = ByteString.b("0000ffff");
    private static final ByteString l = ByteString.b("ffff0000");
    private static final Charset m = Charset.forName("UTF-16BE");
    private static final Charset n = Charset.forName("UTF-16LE");
    private static final Charset o = Charset.forName("UTF-32BE");
    private static final Charset p = Charset.forName("UTF-32LE");
    private static final Pattern q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private c() {
    }

    public static int a(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            switch (str.charAt(i3)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i3++;
                default:
                    return i3;
            }
        }
        return i2;
    }

    public static int a(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    public static int a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String a(String str) {
        try {
            String toLowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            return (toLowerCase.isEmpty() || d(toLowerCase)) ? null : toLowerCase;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String a(s sVar, boolean z) {
        String f = sVar.f().contains(":") ? "[" + sVar.f() + "]" : sVar.f();
        return (z || sVar.g() != s.a(sVar.b())) ? f + ":" + sVar.g() : f;
    }

    public static Charset a(BufferedSource bufferedSource, Charset charset) {
        if (bufferedSource.rangeEquals(0, h)) {
            bufferedSource.skip((long) h.g());
            return e;
        } else if (bufferedSource.rangeEquals(0, i)) {
            bufferedSource.skip((long) i.g());
            return m;
        } else if (bufferedSource.rangeEquals(0, j)) {
            bufferedSource.skip((long) j.g());
            return n;
        } else if (bufferedSource.rangeEquals(0, k)) {
            bufferedSource.skip((long) k.g());
            return o;
        } else if (!bufferedSource.rangeEquals(0, l)) {
            return charset;
        } else {
            bufferedSource.skip((long) l.g());
            return p;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(Source source, int i, TimeUnit timeUnit) {
        try {
            return b(source, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        List arrayList = new ArrayList();
        for (Object obj : strArr) {
            for (Object compare : strArr2) {
                if (comparator.compare(obj, compare) == 0) {
                    arrayList.add(obj);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] a(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    public static int b(String str) {
        int i = 0;
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int b(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i) {
            switch (str.charAt(i3)) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    i3--;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (Object obj : strArr) {
            for (Object compare : strArr2) {
                if (comparator.compare(obj, compare) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(Source source, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long d = source.timeout().m_() ? source.timeout().d() - nanoTime : Long.MAX_VALUE;
        source.timeout().a(Math.min(d, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            d dVar = new d();
            while (source.read(dVar, 8192) != -1) {
                dVar.d();
            }
            if (d == Long.MAX_VALUE) {
                source.timeout().f();
            } else {
                source.timeout().a(d + nanoTime);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (d == Long.MAX_VALUE) {
                source.timeout().f();
            } else {
                source.timeout().a(d + nanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (d == Long.MAX_VALUE) {
                source.timeout().f();
            } else {
                source.timeout().a(d + nanoTime);
            }
            throw th;
        }
    }

    public static String c(String str, int i, int i2) {
        int a = a(str, i, i2);
        return str.substring(a, b(str, a, i2));
    }

    public static boolean c(String str) {
        return q.matcher(str).matches();
    }

    private static boolean d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return true;
            }
            if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }
}
