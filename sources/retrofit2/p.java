package retrofit2;

import javax.annotation.Nullable;
import okhttp3.af;

final class p<T> extends o<T> {
    private final Converter<T, af> a;

    p(Converter<T, af> converter) {
        this.a = converter;
    }

    void a(ag agVar, @Nullable T t) {
        if (t == null) {
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
        try {
            agVar.a((af) this.a.convert(t));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
        }
    }
}
