package com.mikepenz.fastadapter.utils;

import android.support.annotation.NonNull;
import com.mikepenz.fastadapter.IIdentifyable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class b {
    private static final AtomicLong a = new AtomicLong(9000000000000000000L);

    public static <T extends IIdentifyable> T a(@NonNull T t) {
        if (t.getIdentifier() == -1) {
            t.withIdentifier(a.incrementAndGet());
        }
        return t;
    }

    public static <T extends IIdentifyable> List<T> a(@NonNull List<T> list) {
        for (T a : list) {
            a((IIdentifyable) a);
        }
        return list;
    }
}
