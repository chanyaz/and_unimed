package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import android.os.ConditionVariable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class acv {
    protected static volatile aib a = null;
    private static final ConditionVariable d = new ConditionVariable();
    private static volatile Random e = null;
    protected volatile Boolean b;
    private adn c;

    public acv(adn adn) {
        this.c = adn;
        adn.c().execute(new acw(this));
    }

    public static int a() {
        try {
            return VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : c().nextInt();
        } catch (RuntimeException e) {
            return c().nextInt();
        }
    }

    private static Random c() {
        if (e == null) {
            synchronized (acv.class) {
                if (e == null) {
                    e = new Random();
                }
            }
        }
        return e;
    }

    public final void a(int i, int i2, long j) {
        try {
            d.block();
            if (this.b.booleanValue() && a != null) {
                abj rvVar = new rv();
                rvVar.a = this.c.a.getPackageName();
                rvVar.b = Long.valueOf(j);
                aid a = a.a(abj.a(rvVar));
                a.a(i2);
                a.b(i);
                a.a();
            }
        } catch (Exception e) {
        }
    }
}
