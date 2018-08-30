package okhttp3.internal.connection;

import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.internal.http.f;
import okhttp3.z;

public final class a implements Interceptor {
    public final z a;

    public a(z zVar) {
        this.a = zVar;
    }

    public ag intercept(Chain chain) {
        f fVar = (f) chain;
        ad request = fVar.request();
        f a = fVar.a();
        return fVar.a(request, a, a.a(this.a, !request.b().equals("GET")), a.b());
    }
}
