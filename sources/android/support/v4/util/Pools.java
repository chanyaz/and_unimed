package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class Pools {

    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t);
    }

    private Pools() {
    }
}
