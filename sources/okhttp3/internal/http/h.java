package okhttp3.internal.http;

import java.net.Proxy.Type;
import okhttp3.ad;
import okhttp3.s;

public final class h {
    private h() {
    }

    public static String a(ad adVar, Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(adVar.b());
        stringBuilder.append(' ');
        if (b(adVar, type)) {
            stringBuilder.append(adVar.a());
        } else {
            stringBuilder.append(a(adVar.a()));
        }
        stringBuilder.append(" HTTP/1.1");
        return stringBuilder.toString();
    }

    public static String a(s sVar) {
        String h = sVar.h();
        String k = sVar.k();
        return k != null ? h + '?' + k : h;
    }

    private static boolean b(ad adVar, Type type) {
        return !adVar.g() && type == Type.HTTP;
    }
}
