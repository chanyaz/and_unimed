package retrofit2;

import javax.annotation.Nullable;

final class z<T> extends o<T> {
    private final Converter<T, String> a;
    private final boolean b;

    z(Converter<T, String> converter, boolean z) {
        this.a = converter;
        this.b = z;
    }

    void a(ag agVar, @Nullable T t) {
        if (t != null) {
            agVar.b((String) this.a.convert(t), null, this.b);
        }
    }
}
