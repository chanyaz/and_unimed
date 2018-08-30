package okhttp3.internal.http;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.CookieJar;
import okhttp3.ag;
import okhttp3.l;
import okhttp3.q;
import okhttp3.s;

public final class d {
    private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    private d() {
    }

    public static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != 9) {
                break;
            }
            i++;
        }
        return i;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    private static long a(String str) {
        long j = -1;
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public static long a(ag agVar) {
        return a(agVar.f());
    }

    public static long a(q qVar) {
        return a(qVar.a("Content-Length"));
    }

    public static void a(CookieJar cookieJar, s sVar, q qVar) {
        if (cookieJar != CookieJar.a) {
            List a = l.a(sVar, qVar);
            if (!a.isEmpty()) {
                cookieJar.saveFromResponse(sVar, a);
            }
        }
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong > 2147483647L ? MoPubClientPositioning.NO_REPEAT : parseLong < 0 ? 0 : (int) parseLong;
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static boolean b(ag agVar) {
        if (agVar.a().b().equals("HEAD")) {
            return false;
        }
        int b = agVar.b();
        return ((b >= 100 && b < 200) || b == 204 || b == 304) ? a(agVar) != -1 || "chunked".equalsIgnoreCase(agVar.b("Transfer-Encoding")) : true;
    }
}
