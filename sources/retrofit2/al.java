package retrofit2;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.ad;
import okhttp3.ai;
import okhttp3.q;
import okhttp3.s;
import okhttp3.v;

final class al<R, T> {
    static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    static final Pattern b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    final Factory c;
    final CallAdapter<R, T> d;
    private final s e;
    private final Converter<ai, R> f;
    private final String g;
    private final String h;
    private final q i;
    private final v j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final o<?>[] n;

    al(am<R, T> amVar) {
        this.c = amVar.a.a();
        this.d = amVar.w;
        this.e = amVar.a.b();
        this.f = amVar.v;
        this.g = amVar.m;
        this.h = amVar.q;
        this.i = amVar.r;
        this.j = amVar.s;
        this.k = amVar.n;
        this.l = amVar.o;
        this.m = amVar.p;
        this.n = amVar.u;
    }

    static Class<?> a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    static Set<String> a(String str) {
        Matcher matcher = a.matcher(str);
        Set<String> linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    R a(ai aiVar) {
        return this.f.convert(aiVar);
    }

    ad a(@Nullable Object... objArr) {
        int i = 0;
        ag agVar = new ag(this.g, this.e, this.h, this.i, this.j, this.k, this.l, this.m);
        o[] oVarArr = this.n;
        int length = objArr != null ? objArr.length : 0;
        if (length != oVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + oVarArr.length + ")");
        }
        while (i < length) {
            oVarArr[i].a(agVar, objArr[i]);
            i++;
        }
        return agVar.a();
    }
}
