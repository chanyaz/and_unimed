package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.af;
import okhttp3.ai;
import retrofit2.http.Streaming;

final class a extends h {
    a() {
    }

    public Converter<ai, ?> a(Type type, Annotation[] annotationArr, aj ajVar) {
        return type == ai.class ? an.a(annotationArr, Streaming.class) ? d.a : b.a : type == Void.class ? f.a : null;
    }

    public Converter<?, af> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, aj ajVar) {
        return af.class.isAssignableFrom(an.a(type)) ? c.a : null;
    }
}
