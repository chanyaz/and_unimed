package com.google.android.gms.common.api;

import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public abstract class m {
    @GuardedBy("sLock")
    private static final Map<Object, m> a = new WeakHashMap();
    private static final Object b = new Object();

    public abstract void a(int i);
}
