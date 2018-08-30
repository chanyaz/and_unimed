package retrofit2;

import javax.annotation.Nullable;

final class x<T> extends o<T> {
    private final String a;
    private final Converter<T, String> b;
    private final boolean c;

    x(String str, Converter<T, String> converter, boolean z) {
        this.a = (String) an.a((Object) str, "name == null");
        this.b = converter;
        this.c = z;
    }

    void a(ag agVar, @Nullable T t) {
        if (t != null) {
            String str = (String) this.b.convert(t);
            if (str != null) {
                agVar.b(this.a, str, this.c);
            }
        }
    }
}
