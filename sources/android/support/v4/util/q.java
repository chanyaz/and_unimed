package android.support.v4.util;

import android.support.annotation.NonNull;

public class q<T> extends p<T> {
    private final Object a = new Object();

    public q(int i) {
        super(i);
    }

    public T acquire() {
        T acquire;
        synchronized (this.a) {
            acquire = super.acquire();
        }
        return acquire;
    }

    public boolean release(@NonNull T t) {
        boolean release;
        synchronized (this.a) {
            release = super.release(t);
        }
        return release;
    }
}
