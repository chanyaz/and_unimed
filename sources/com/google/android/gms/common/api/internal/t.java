package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class t {
    private final Map<BasePendingResult<?>, Boolean> a = Collections.synchronizedMap(new WeakHashMap());
    private final Map<b<?>, Boolean> b = Collections.synchronizedMap(new WeakHashMap());

    private final void a(boolean z, Status status) {
        synchronized (this.a) {
            Map hashMap = new HashMap(this.a);
        }
        synchronized (this.b) {
            Map hashMap2 = new HashMap(this.b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).a(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((b) entry2.getKey()).b(new ApiException(status));
            }
        }
    }

    final void a(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        this.a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.a(new u(this, basePendingResult));
    }

    final <TResult> void a(b<TResult> bVar, boolean z) {
        this.b.put(bVar, Boolean.valueOf(z));
        bVar.a().a(new v(this, bVar));
    }

    final boolean a() {
        return (this.a.isEmpty() && this.b.isEmpty()) ? false : true;
    }

    public final void b() {
        a(false, e.a);
    }

    public final void c() {
        a(true, bt.a);
    }
}
