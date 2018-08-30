package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public abstract class g {
    protected static Class<?> a(Type type) {
        return an.a(type);
    }

    @Nullable
    public abstract CallAdapter<?, ?> a(Type type, Annotation[] annotationArr, aj ajVar);
}
