package retrofit2;

import okhttp3.ai;

final class b implements Converter<ai, ai> {
    static final b a = new b();

    b() {
    }

    /* renamed from: a */
    public ai convert(ai aiVar) {
        try {
            ai a = an.a(aiVar);
            return a;
        } finally {
            aiVar.close();
        }
    }
}
