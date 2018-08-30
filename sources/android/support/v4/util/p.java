package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;

public class p<T> implements Pool<T> {
    private final Object[] a;
    private int b;

    public p(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[i];
    }

    private boolean a(@NonNull T t) {
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] == t) {
                return true;
            }
        }
        return false;
    }

    public T acquire() {
        if (this.b <= 0) {
            return null;
        }
        int i = this.b - 1;
        T t = this.a[i];
        this.a[i] = null;
        this.b--;
        return t;
    }

    public boolean release(@NonNull T t) {
        if (a(t)) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.b >= this.a.length) {
            return false;
        } else {
            this.a[this.b] = t;
            this.b++;
            return true;
        }
    }
}
