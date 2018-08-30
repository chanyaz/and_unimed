package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    public interface Types {
    }

    public abstract long a();

    public abstract int b();

    public abstract String h();

    public abstract long i();

    public abstract long k();

    public abstract long l();

    public abstract String m();

    public String toString() {
        long a = a();
        int b = b();
        long i = i();
        String m = m();
        return new StringBuilder(String.valueOf(m).length() + 53).append(a).append("\t").append(b).append("\t").append(i).append(m).toString();
    }
}
