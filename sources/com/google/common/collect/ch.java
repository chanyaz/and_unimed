package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.o;

@GwtCompatible(emulated = true)
@Deprecated
@Beta
abstract class ch<K0, V0> {
    @GwtIncompatible("To be supported")
    RemovalListener<K0, V0> a;

    ch() {
    }

    @GwtIncompatible("To be supported")
    <K extends K0, V extends V0> RemovalListener<K, V> a() {
        return (RemovalListener) o.b(this.a, ci.INSTANCE);
    }
}
