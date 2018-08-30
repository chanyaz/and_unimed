package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible
public final class o {
    private o() {
    }

    public static int a(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static p a(Object obj) {
        return new p(a(obj.getClass()));
    }

    private static String a(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T b(@Nullable T t, @Nullable T t2) {
        return t != null ? t : s.a((Object) t2);
    }
}
