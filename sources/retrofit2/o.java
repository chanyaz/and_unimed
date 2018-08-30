package retrofit2;

import java.lang.reflect.Array;
import javax.annotation.Nullable;

abstract class o<T> {
    o() {
    }

    final o<Iterable<T>> a() {
        return new o<Iterable<T>>() {
            void a(ag agVar, @Nullable Iterable<T> iterable) {
                if (iterable != null) {
                    for (T a : iterable) {
                        o.this.a(agVar, a);
                    }
                }
            }
        };
    }

    abstract void a(ag agVar, @Nullable T t);

    final o<Object> b() {
        return new o<Object>() {
            void a(ag agVar, @Nullable Object obj) {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        o.this.a(agVar, Array.get(obj, i));
                    }
                }
            }
        };
    }
}
