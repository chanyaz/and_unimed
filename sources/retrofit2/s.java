package retrofit2;

import javax.annotation.Nullable;

final class s<T> extends o<T> {
    private final String a;
    private final Converter<T, String> b;

    s(String str, Converter<T, String> converter) {
        this.a = (String) an.a((Object) str, "name == null");
        this.b = converter;
    }

    void a(ag agVar, @Nullable T t) {
        if (t != null) {
            String str = (String) this.b.convert(t);
            if (str != null) {
                agVar.a(this.a, str);
            }
        }
    }
}
