package retrofit2;

import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

class ac {
    private static final ac a = c();

    ac() {
    }

    static ac a() {
        return a;
    }

    private static ac c() {
        try {
            Class.forName("android.os.Build");
            if (VERSION.SDK_INT != 0) {
                return new ad();
            }
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("java.util.Optional");
            return new af();
        } catch (ClassNotFoundException e2) {
            return new ac();
        }
    }

    @Nullable
    Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) {
        throw new UnsupportedOperationException();
    }

    g a(@Nullable Executor executor) {
        return executor != null ? new j(executor) : i.a;
    }

    boolean a(Method method) {
        return false;
    }

    @Nullable
    Executor b() {
        return null;
    }
}
