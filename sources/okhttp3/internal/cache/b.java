package okhttp3.internal.cache;

import javax.annotation.Nullable;
import okhttp3.ad;
import okhttp3.ag;

public final class b {
    @Nullable
    public final ad a;
    @Nullable
    public final ag b;

    b(ad adVar, ag agVar) {
        this.a = adVar;
        this.b = agVar;
    }

    public static boolean a(ag agVar, ad adVar) {
        switch (agVar.b()) {
            case 200:
            case 203:
            case 204:
            case 300:
            case 301:
            case 308:
            case 404:
            case 405:
            case 410:
            case 414:
            case 501:
                break;
            case 302:
            case 307:
                if (agVar.b("Expires") == null && agVar.i().c() == -1 && !agVar.i().e() && !agVar.i().d()) {
                    return false;
                }
            default:
                return false;
        }
        return (agVar.i().b() || adVar.f().b()) ? false : true;
    }
}
