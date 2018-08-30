package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Suppliers {

    interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    private Suppliers() {
    }
}
