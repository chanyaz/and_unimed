package com.puzzlersworld.a.a;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.af;
import okhttp3.ai;
import retrofit2.Converter;
import retrofit2.aj;
import retrofit2.h;

public class a extends h {
    private final ObjectMapper a;

    private a(ObjectMapper objectMapper) {
        if (objectMapper == null) {
            throw new NullPointerException("mapper == null");
        }
        this.a = objectMapper;
    }

    public static a a(ObjectMapper objectMapper) {
        return new a(objectMapper);
    }

    public Converter<ai, ?> a(Type type, Annotation[] annotationArr, aj ajVar) {
        return new c(this.a.reader(this.a.getTypeFactory().constructType(type)));
    }

    public Converter<?, af> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, aj ajVar) {
        return new b(this.a.writerWithType(this.a.getTypeFactory().constructType(type)));
    }
}
