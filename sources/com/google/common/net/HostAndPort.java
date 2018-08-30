package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import java.io.Serializable;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
@Beta
public final class HostAndPort implements Serializable {
    private static final long serialVersionUID = 0;
    private final String a;
    private final int b;
    private final boolean c;

    public boolean a() {
        return this.b >= 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        return o.a(this.a, hostAndPort.a) && this.b == hostAndPort.b && this.c == hostAndPort.c;
    }

    public int hashCode() {
        return o.a(this.a, Integer.valueOf(this.b), Boolean.valueOf(this.c));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.a.length() + 7);
        if (this.a.indexOf(58) >= 0) {
            stringBuilder.append('[').append(this.a).append(']');
        } else {
            stringBuilder.append(this.a);
        }
        if (a()) {
            stringBuilder.append(':').append(this.b);
        }
        return stringBuilder.toString();
    }
}
