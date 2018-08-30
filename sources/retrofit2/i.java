package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class i extends g {
    static final g a = new i();

    i() {
    }

    public CallAdapter<?, ?> a(Type type, Annotation[] annotationArr, aj ajVar) {
        if (g.a(type) != Call.class) {
            return null;
        }
        final Type e = an.e(type);
        return new CallAdapter<Object, Call<?>>() {
            /* renamed from: a */
            public Call<Object> adapt(Call<Object> call) {
                return call;
            }

            public Type responseType() {
                return e;
            }
        };
    }
}
