package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

final class j extends g {
    final Executor a;

    j(Executor executor) {
        this.a = executor;
    }

    public CallAdapter<?, ?> a(Type type, Annotation[] annotationArr, aj ajVar) {
        if (g.a(type) != Call.class) {
            return null;
        }
        final Type e = an.e(type);
        return new CallAdapter<Object, Call<?>>() {
            /* renamed from: a */
            public Call<Object> adapt(Call<Object> call) {
                return new k(j.this.a, call);
            }

            public Type responseType() {
                return e;
            }
        };
    }
}
