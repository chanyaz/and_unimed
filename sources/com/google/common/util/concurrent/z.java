package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.Future;

@Beta
public final class z {
    private z() {
    }

    public static <V> V a(Future<V> future) {
        Object obj = null;
        while (true) {
            try {
                V v = future.get();
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
                return v;
            } catch (InterruptedException e) {
                obj = 1;
            } catch (Throwable th) {
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
