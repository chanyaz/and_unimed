package retrofit2;

import okhttp3.ai;

final class f implements Converter<ai, Void> {
    static final f a = new f();

    f() {
    }

    /* renamed from: a */
    public Void convert(ai aiVar) {
        aiVar.close();
        return null;
    }
}
