package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class hc {
    @GuardedBy("this")
    private BigInteger a = BigInteger.ONE;

    public final synchronized String a() {
        String bigInteger;
        bigInteger = this.a.toString();
        this.a = this.a.add(BigInteger.ONE);
        return bigInteger;
    }
}
