package android.support.v4.media;

import android.os.Bundle;

public class aa<T> {
    private final Object a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;

    aa(Object obj) {
        this.a = obj;
    }

    void a(int i) {
        this.e = i;
    }

    void a(T t) {
    }

    boolean a() {
        return this.b || this.c || this.d;
    }

    int b() {
        return this.e;
    }

    void b(Bundle bundle) {
        throw new UnsupportedOperationException("It is not supported to send an error for " + this.a);
    }

    public void b(T t) {
        if (this.c || this.d) {
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.a);
        }
        this.c = true;
        a((Object) t);
    }

    public void c(Bundle bundle) {
        if (this.c || this.d) {
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.a);
        }
        this.d = true;
        b(bundle);
    }
}
