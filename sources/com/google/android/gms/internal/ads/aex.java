package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class aex {
    private static final String a = aex.class.getSimpleName();
    private final adn b;
    private final String c;
    private final String d;
    private final int e = 2;
    private volatile Method f = null;
    private final Class<?>[] g;
    private CountDownLatch h = new CountDownLatch(1);

    public aex(adn adn, String str, String str2, Class<?>... clsArr) {
        this.b = adn;
        this.c = str;
        this.d = str2;
        this.g = clsArr;
        this.b.c().submit(new aey(this));
    }

    private final String a(byte[] bArr, String str) {
        return new String(this.b.e().a(bArr, str), "UTF-8");
    }

    private final void b() {
        try {
            Class loadClass = this.b.d().loadClass(a(this.b.f(), this.c));
            if (loadClass != null) {
                this.f = loadClass.getMethod(a(this.b.f(), this.d), this.g);
                if (this.f == null) {
                    this.h.countDown();
                } else {
                    this.h.countDown();
                }
            }
        } catch (zzcl e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.h.countDown();
        }
    }

    public final Method a() {
        if (this.f != null) {
            return this.f;
        }
        try {
            return this.h.await(2, TimeUnit.SECONDS) ? this.f : null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
