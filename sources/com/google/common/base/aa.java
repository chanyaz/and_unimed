package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
@Beta
public final class aa {
    private final ad a;
    private boolean b;
    private long c;
    private long d;

    /* renamed from: com.google.common.base.aa$1 */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[TimeUnit.values().length];

        static {
            try {
                a[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Deprecated
    public aa() {
        this(ad.b());
    }

    @Deprecated
    public aa(ad adVar) {
        this.a = (ad) s.a((Object) adVar, (Object) "ticker");
    }

    public static aa a() {
        return new aa();
    }

    private static TimeUnit a(long j) {
        return TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.DAYS : TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.HOURS : TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MINUTES : TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.SECONDS : TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MILLISECONDS : TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS;
    }

    private static String b(TimeUnit timeUnit) {
        switch (AnonymousClass1.a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    private long c() {
        return this.b ? (this.a.a() - this.d) + this.c : this.c;
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(c(), TimeUnit.NANOSECONDS);
    }

    public aa b() {
        s.b(!this.b, (Object) "This stopwatch is already running.");
        this.b = true;
        this.d = this.a.a();
        return this;
    }

    @GwtIncompatible("String.format()")
    public String toString() {
        long c = c();
        double convert = ((double) c) / ((double) TimeUnit.NANOSECONDS.convert(1, a(c)));
        return String.format("%.4g %s", new Object[]{Double.valueOf(convert), b(r2)});
    }
}
