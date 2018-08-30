package android.support.v4.util;

import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import java.util.Objects;

public class n {
    private n() {
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return VERSION.SDK_INT >= 19 ? Objects.equals(obj, obj2) : obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
