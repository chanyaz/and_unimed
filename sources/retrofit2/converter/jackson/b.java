package retrofit2.converter.jackson;

import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.af;
import okhttp3.v;
import retrofit2.Converter;

final class b<T> implements Converter<T, af> {
    private static final v a = v.a("application/json; charset=UTF-8");
    private final ObjectWriter b;

    b(ObjectWriter objectWriter) {
        this.b = objectWriter;
    }

    /* renamed from: a */
    public af convert(T t) {
        return af.a(a, this.b.writeValueAsBytes(t));
    }
}
