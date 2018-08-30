package android.support.v4.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class i<T> implements Iterator<T> {
    final int a;
    int b;
    int c;
    boolean d = false;
    final /* synthetic */ h e;

    i(h hVar, int i) {
        this.e = hVar;
        this.a = i;
        this.b = hVar.a();
    }

    public boolean hasNext() {
        return this.c < this.b;
    }

    public T next() {
        if (hasNext()) {
            T a = this.e.a(this.c, this.a);
            this.c++;
            this.d = true;
            return a;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.d) {
            this.c--;
            this.b--;
            this.d = false;
            this.e.a(this.c);
            return;
        }
        throw new IllegalStateException();
    }
}
