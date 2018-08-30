package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class aez implements Callable {
    protected final adn a;
    protected final wr b;
    protected Method c;
    private final String d = getClass().getSimpleName();
    private final String e;
    private final String f;
    private final int g;
    private final int h;

    public aez(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        this.a = adn;
        this.e = str;
        this.f = str2;
        this.b = wrVar;
        this.g = i;
        this.h = i2;
    }

    protected abstract void a();

    /* renamed from: b */
    public Void call() {
        try {
            long nanoTime = System.nanoTime();
            this.c = this.a.a(this.e, this.f);
            if (this.c != null) {
                a();
                acv h = this.a.h();
                if (!(h == null || this.g == Integer.MIN_VALUE)) {
                    h.a(this.h, this.g, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }
}
