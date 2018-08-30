package com.google.android.gms.common.util.a;

import com.google.android.gms.common.internal.ar;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class b implements ThreadFactory {
    private final String a;
    private final int b;
    private final ThreadFactory c;

    public b(String str) {
        this(str, 0);
    }

    public b(String str, int i) {
        this.c = Executors.defaultThreadFactory();
        this.a = (String) ar.a((Object) str, (Object) "Name must not be null");
        this.b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.c.newThread(new d(runnable, this.b));
        newThread.setName(this.a);
        return newThread;
    }
}
