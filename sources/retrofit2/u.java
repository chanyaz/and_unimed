package retrofit2;

import javax.annotation.Nullable;
import okhttp3.af;
import okhttp3.q;

final class u<T> extends o<T> {
    private final q a;
    private final Converter<T, af> b;

    u(q qVar, Converter<T, af> converter) {
        this.a = qVar;
        this.b = converter;
    }

    void a(ag agVar, @Nullable T t) {
        if (t != null) {
            try {
                agVar.a(this.a, (af) this.b.convert(t));
            } catch (Throwable e) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
            }
        }
    }
}
