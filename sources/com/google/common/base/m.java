package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public class m {
    private final String a;

    private m(m mVar) {
        this.a = mVar.a;
    }

    /* synthetic */ m(m mVar, AnonymousClass1 anonymousClass1) {
        this(mVar);
    }

    private m(String str) {
        this.a = (String) s.a((Object) str);
    }

    public static m a(char c) {
        return new m(String.valueOf(c));
    }

    public static m a(String str) {
        return new m(str);
    }

    public <A extends Appendable> A a(A a, Iterator<?> it) {
        s.a((Object) a);
        if (it.hasNext()) {
            a.append(a(it.next()));
            while (it.hasNext()) {
                a.append(this.a);
                a.append(a(it.next()));
            }
        }
        return a;
    }

    CharSequence a(Object obj) {
        s.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    public final String a(Iterator<?> it) {
        return a(new StringBuilder(), (Iterator) it).toString();
    }

    public final String a(Object[] objArr) {
        return a(Arrays.asList(objArr));
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterable<?> iterable) {
        return a(stringBuilder, iterable.iterator());
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterator<?> it) {
        try {
            a((Appendable) stringBuilder, (Iterator) it);
            return stringBuilder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CheckReturnValue
    public m b(final String str) {
        s.a((Object) str);
        return new m(this) {
            CharSequence a(@Nullable Object obj) {
                return obj == null ? str : m.this.a(obj);
            }

            public m b(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    @CheckReturnValue
    public n c(String str) {
        return new n(this, str, null);
    }
}
