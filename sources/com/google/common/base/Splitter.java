package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated = true)
public final class Splitter {
    private final d a;
    private final boolean b;
    private final Strategy c;
    private final int d;

    interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, d.m, MoPubClientPositioning.NO_REPEAT);
    }

    private Splitter(Strategy strategy, boolean z, d dVar, int i) {
        this.c = strategy;
        this.b = z;
        this.a = dVar;
        this.d = i;
    }

    public static Splitter a(char c) {
        return a(d.a(c));
    }

    public static Splitter a(final d dVar) {
        s.a((Object) dVar);
        return new Splitter(new Strategy() {
            /* renamed from: a */
            public z iterator(Splitter splitter, CharSequence charSequence) {
                return new z(splitter, charSequence) {
                    int a(int i) {
                        return dVar.a(this.b, i);
                    }

                    int b(int i) {
                        return i + 1;
                    }
                };
            }
        });
    }

    @CheckReturnValue
    public Splitter a() {
        return b(d.o);
    }

    @CheckReturnValue
    public Splitter b(d dVar) {
        s.a((Object) dVar);
        return new Splitter(this.c, this.b, dVar, this.d);
    }
}
