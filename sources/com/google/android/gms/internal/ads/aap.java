package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class aap {
    Unsafe a;

    aap(Unsafe unsafe) {
        this.a = unsafe;
    }

    public abstract byte a(Object obj, long j);

    public final long a(Field field) {
        return this.a.objectFieldOffset(field);
    }

    public abstract void a(Object obj, long j, byte b);

    public abstract void a(Object obj, long j, double d);

    public abstract void a(Object obj, long j, float f);

    public final void a(Object obj, long j, int i) {
        this.a.putInt(obj, j, i);
    }

    public final void a(Object obj, long j, long j2) {
        this.a.putLong(obj, j, j2);
    }

    public abstract void a(Object obj, long j, boolean z);

    public abstract boolean b(Object obj, long j);

    public abstract float c(Object obj, long j);

    public abstract double d(Object obj, long j);

    public final int e(Object obj, long j) {
        return this.a.getInt(obj, j);
    }

    public final long f(Object obj, long j) {
        return this.a.getLong(obj, j);
    }
}
