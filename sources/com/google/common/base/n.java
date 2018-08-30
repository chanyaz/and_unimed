package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.base.m.AnonymousClass1;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class n {
    private final m a;
    private final String b;

    private n(m mVar, String str) {
        this.a = mVar;
        this.b = (String) s.a((Object) str);
    }

    /* synthetic */ n(m mVar, String str, AnonymousClass1 anonymousClass1) {
        this(mVar, str);
    }

    @Beta
    public <A extends Appendable> A a(A a, Iterator<? extends Entry<?, ?>> it) {
        s.a((Object) a);
        if (it.hasNext()) {
            Entry entry = (Entry) it.next();
            a.append(this.a.a(entry.getKey()));
            a.append(this.b);
            a.append(this.a.a(entry.getValue()));
            while (it.hasNext()) {
                a.append(this.a.a);
                entry = (Entry) it.next();
                a.append(this.a.a(entry.getKey()));
                a.append(this.b);
                a.append(this.a.a(entry.getValue()));
            }
        }
        return a;
    }

    @Beta
    public StringBuilder a(StringBuilder stringBuilder, Iterable<? extends Entry<?, ?>> iterable) {
        return a(stringBuilder, iterable.iterator());
    }

    @Beta
    public StringBuilder a(StringBuilder stringBuilder, Iterator<? extends Entry<?, ?>> it) {
        try {
            a((Appendable) stringBuilder, (Iterator) it);
            return stringBuilder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public StringBuilder a(StringBuilder stringBuilder, Map<?, ?> map) {
        return a(stringBuilder, map.entrySet());
    }
}
