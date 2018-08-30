package retrofit2.converter.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.af;
import okhttp3.ai;
import retrofit2.Converter;
import retrofit2.aj;
import retrofit2.h;

public final class a extends h {
    private final ObjectMapper a;

    private a(ObjectMapper objectMapper) {
        this.a = objectMapper;
    }

    public static a a(ObjectMapper objectMapper) {
        if (objectMapper != null) {
            return new a(objectMapper);
        }
        throw new NullPointerException("mapper == null");
    }

    public Converter<ai, ?> a(Type type, Annotation[] annotationArr, aj ajVar) {
        return new c(this.a.readerFor(this.a.getTypeFactory().constructType(type)));
    }

    public Converter<?, af> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, aj ajVar) {
        return new b(this.a.writerFor(this.a.getTypeFactory().constructType(type)));
    }
}
