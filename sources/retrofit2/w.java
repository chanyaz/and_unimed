package retrofit2;

import javax.annotation.Nullable;

final class w<T> extends o<T> {
    private final String a;
    private final Converter<T, String> b;
    private final boolean c;

    w(String str, Converter<T, String> converter, boolean z) {
        this.a = (String) an.a((Object) str, "name == null");
        this.b = converter;
        this.c = z;
    }

    void a(ag agVar, @Nullable T t) {
        if (t == null) {
            throw new IllegalArgumentException("Path parameter \"" + this.a + "\" value must not be null.");
        }
        agVar.a(this.a, (String) this.b.convert(t), this.c);
    }
}
