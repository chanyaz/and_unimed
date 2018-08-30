package retrofit2;

import javax.annotation.Nullable;
import okhttp3.ag;

public final class ai<T> {
    private final ag a;
    @Nullable
    private final T b;
    @Nullable
    private final okhttp3.ai c;

    private ai(ag agVar, @Nullable T t, @Nullable okhttp3.ai aiVar) {
        this.a = agVar;
        this.b = t;
        this.c = aiVar;
    }

    public static <T> ai<T> a(@Nullable T t, ag agVar) {
        an.a((Object) agVar, "rawResponse == null");
        if (agVar.c()) {
            return new ai(agVar, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> ai<T> a(okhttp3.ai aiVar, ag agVar) {
        an.a((Object) aiVar, "body == null");
        an.a((Object) agVar, "rawResponse == null");
        if (!agVar.c()) {
            return new ai(agVar, null, aiVar);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public boolean a() {
        return this.a.c();
    }

    @Nullable
    public T b() {
        return this.b;
    }

    @Nullable
    public okhttp3.ai c() {
        return this.c;
    }

    public String toString() {
        return this.a.toString();
    }
}
